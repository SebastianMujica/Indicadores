package Indicador;

import groovy.lang.GroovyShell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import Maestro.Maestro;
import Maestro.modeloMaestro;
import Organizacion.Organizacion;
import Organizacion.modeloOrganizacion;
import Periodo.Periodo;
import Periodo.modeloPeriodo;
import RegistroIndicador.RegistroIndicador;
import RegistroIndicador.modeloRegistroIndicador;
import RegistroVariable.RegistroVariable;
import RegistroVariable.modeloRegistroVariable;
import SwingBernate.ControladorBase;
import SwingBernate.DtoBase;
import SwingBernate.dtoVacio;
import SwingBernate.ayudantes.ComboBox;
import Variable.Variable;

public class controladorCaptura extends ControladorBase implements ActionListener, MouseListener,KeyListener{
	int actualpag=1; //Página Actual.
	//int totalpag=1;  //Nro. de Páginas.
	//int rexpag=3;
	int TamPag=3; //Tamaño de Página (Items por Página)
	int TamLis=0; //Tamaño de la Lista de Indicadores.
	int NumPags=0; //Nro de Páginas.
	//List<List<DtoBase>> paginasList=new ArrayList<List<DtoBase>>();
    List<DtoBase> lstIndicador = new ArrayList<DtoBase>(); //Lista de Indicadores.
    
	public controladorCaptura(){
	    captura vista=new captura(this);
	    RegistroVariable dto=new RegistroVariable();
	    this.iniciarSesion(vista,dto);
	    this.actualizarVista();
	    //this.setGridCompActive(false);
		vista.getCentro2().setVisible(false);
    	vista.getCentro().setVisible(true);
	  }
	  public void actualizarVista(){
		  captura vista=(captura)this.getSession().getVista();
		  
		  modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
		  javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
		  vista.getCmbdto_org().setModelo(modeloComboOrganizacion);
		  
		  modeloMaestro modeloMaestro=new modeloMaestro();
		  javax.swing.DefaultComboBoxModel modeloCombotip_prod=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("CAT_IND"));
		  vista.getCmbdtocategoria().setModelo(modeloCombotip_prod);
		  }
	  
public void setList(List<DtoBase> Lis){
	this.lstIndicador=Lis;
}
public List<DtoBase> getList(){
	return this.lstIndicador;
}
public void setTamLis(int Tam){
	this.TamLis=Tam;
}
public int getTamLis(){
	return this.TamLis;
}
public void setNumPags(){
	int num_aux=0;
	int Tam=this.getTamLis();
	if (Tam>0){
		if (Tam<=this.TamPag){
			num_aux=1;
		}else{
			num_aux=(int) Math.ceil((double)Tam/this.TamPag);
		}
	}
	this.NumPags=num_aux;
}	
public int getNumPags(){
	return this.NumPags;
}
public int getLimInfPag(int NroPag){
	return (NroPag * this.TamPag) - this.TamPag;
}
public int getLimSupPag(int NroPag){
	int num_aux;
	if (NroPag<NumPags){
		num_aux=(NroPag * this.TamPag) - 1;
	}else num_aux=this.TamLis-1;
	return num_aux;
}
public int getPag_Actual(){
	return this.actualpag;
}
public void setPag_Actual(int Pag){
	this.actualpag=Pag;
}
public void inicializar(){
	this.actualpag=1; //Página Actual.
	this.TamPag=3; //Tamaño de Página (Items por Página)
	this.TamLis=0; //Tamaño de la Lista de Indicadores.
	this.NumPags=0; //Nro de Páginas.
	this.lstIndicador.clear();
}
public void primero(){
	  this.ir_a_pagina(1);
}
public void anterior(){	  
	  if (actualpag>1)
	  this.ir_a_pagina(actualpag-1);
}
public void siguiente(){
	  if (this.actualpag<this.NumPags)
		  this.ir_a_pagina(actualpag+1);
}
public void ultimo(){
	  this.ir_a_pagina(NumPags);
}
public void ir_a_pagina(int num_pag){
	  int lim_inf=this.getLimInfPag(num_pag);
	  int lim_sup=this.getLimSupPag(num_pag);
	  int i;
	  captura vista=(captura)this.getSession().getVista();
	  vista.panelContenedor.removeAll();
	  for (i=lim_inf;i<=lim_sup;i++){
		  vista.mostrar_panel_variable_indicador(i);
		  vista.revalidate();
	  }
	  this.setPag_Actual(num_pag);
	  vista.getLblPaginacion().setText("Página "+ this.actualpag+" de "+this.NumPags+".    ["+this.TamLis+" Indicador(es)].    Mostrando [" + this.TamPag+"] por Pág.");
}
/**
 * @param lista
 */
public void grabar(int Nro_Indi,List<RegistroVariable> lista)
  {
	captura vista=(captura)this.getSession().getVista();
	Indicador indi=(Indicador)this.lstIndicador.get(Nro_Indi);
	System.out.println("\nGRABANDO INDICADOR " + Nro_Indi + ". ["+indi.strcodigo+"]" );
    RegistroIndicador RegIndi=new RegistroIndicador();
	modeloRegistroVariable modeloVA=new modeloRegistroVariable();
	GroovyShell shell=new GroovyShell();
	Periodo periodo=new Periodo();
	periodo=(Periodo)vista.getCmbdto_periodo().getSelectedItem();
	RegIndi.setLngid(0);
	RegIndi.setDtoorganizacion((Organizacion)vista.getCmbdto_org().getSelectedItem());
	RegIndi.setDtoperiodo(periodo);
	RegIndi.setDtoindicador(indi);
	RegIndi.setDtmfecha_valor(vista.getDchdtmfecha_valor().getDate());
	int i;
	System.out.println("     SE PROCESARAN " + lista.size()+" Registros para este Indicador");
	for (i=0;i<lista.size();i++) {
		RegistroVariable registroVariable=new RegistroVariable();
		registroVariable=lista.get(i);
		this.getSession().setUsuarioInicio(vista);
		System.out.println("     VARIABLE " + i+". ["+registroVariable.getDtovariable().getStrcodigo()+"]");
		System.out.println("     Valor: "+ registroVariable.getStrvalor());
        if(registroVariable.getLngid() ==0){
        	registroVariable.setLngseg_usuario_creacion(this.getSession().getLngusr());
        	registroVariable.setDtmfecha_creacion(new Date());
        	registroVariable.setStrip_creacion(this.obtenerIpHost());
        	registroVariable.setStrhost_creacion(this.obtenerNombreHost());
        	registroVariable.setLngseg_usuario_modificacion(this.getSession().getLngusr());
        	registroVariable.setDtmfecha_modificacion(new Date());
        	registroVariable.setStrip_modificacion(this.obtenerIpHost());
        	registroVariable.setStrhost_modificacion(this.obtenerNombreHost());
        	registroVariable.setBolborrado(false);
        	registroVariable.setBolactivo(true);
        	registroVariable.setDtmvalido_desde(periodo.getDtmvalido_desde());
        	registroVariable.setDtmvalido_hasta(periodo.getDtmvalido_hasta());
    	}else{
    		registroVariable.setStrip_modificacion(this.obtenerIpHost());
    		registroVariable.setStrhost_modificacion(this.obtenerNombreHost());
    		registroVariable.setDtmfecha_modificacion(new Date());
    		registroVariable.setLngseg_usuario_modificacion(this.getSession().getLngusr());
    	}
	   	modeloVA.grabar(registroVariable);
	   	System.out.println("          REGISTRO VARIABLE GUARDADO ID " + registroVariable.getLngid());
	   	//lista_reg_var.add(i,registroVariable);
        //System.out.println(lista);
	   	//RegIndi.addRegistroVariable(registroVariable);
	   	Variable var = registroVariable.getDtovariable();
	   	String strTipoVar   = var.getDtotipo_dato().getStrsigla().toUpperCase().trim();
	   	//String strNombreVar = var.getStrnombre().trim().replace(" ","_");
	   	String strNombreVar = var.getStrcodigo();
	   	String strValorVar  = registroVariable.getStrvalor();
	   	System.out.println("          NOMBRE VAR: " + strNombreVar + ".");
	   	System.out.println("          VALOR VAR: " + strValorVar + ".");
	   	if (strTipoVar.equals("INT")){
	   		shell.setVariable(strNombreVar,Integer.parseInt(strValorVar));	
	   	}else if (strTipoVar.equals("LNG")){
	   		shell.setVariable(strNombreVar,Long.parseLong(strValorVar));	
	   	}else if (strTipoVar.equals("SHR")){
	   		shell.setVariable(strNombreVar,Short.parseShort(strValorVar));	
	   	}else if (strTipoVar.equals("FLO")){
	   		shell.setVariable(strNombreVar,Float.parseFloat(strValorVar));	
	   	}else if (strTipoVar.equals("DBL")){
	   		shell.setVariable(strNombreVar,Double.parseDouble(strValorVar));	
	   	}else{
	   		shell.setVariable(strNombreVar,registroVariable.getStrvalor());												
	   	}
	}//Fin del For
	System.out.println("     FORMULA: "+indi.getStrformula());
	String Resultado=shell.evaluate(indi.getStrformula()).toString();
	RegIndi.setStrvalor(Resultado);
	System.out.println("     Resultado --->>"+Resultado);
	if(RegIndi.getLngid() ==0){
		RegIndi.setLngseg_usuario_creacion(this.getSession().getLngusr());
		RegIndi.setDtmfecha_creacion(new Date());
		RegIndi.setStrip_creacion(this.obtenerIpHost());
		RegIndi.setStrhost_creacion(this.obtenerNombreHost());
		RegIndi.setLngseg_usuario_modificacion(this.getSession().getLngusr());
		RegIndi.setDtmfecha_modificacion(new Date());
		RegIndi.setStrip_modificacion(this.obtenerIpHost());
		RegIndi.setStrhost_modificacion(this.obtenerNombreHost());
		RegIndi.setBolborrado(false);
		RegIndi.setBolactivo(true);
		RegIndi.setDtmvalido_desde(periodo.getDtmvalido_desde());
		RegIndi.setDtmvalido_hasta(periodo.getDtmvalido_hasta());
	}else{
		RegIndi.setStrip_modificacion(this.obtenerIpHost());
		RegIndi.setStrhost_modificacion(this.obtenerNombreHost());
		RegIndi.setDtmfecha_modificacion(new Date());
		RegIndi.setLngseg_usuario_modificacion(this.getSession().getLngusr());
	}
	RegIndi.setDtoregistro_variable(lista);
	modeloRegistroIndicador modeloregind=new modeloRegistroIndicador();
	modeloregind.grabar(RegIndi);
  }

public void grabar(){
	int i=0;
	captura vista=(captura)this.getSession().getVista();
	int intDialogo = vista.mensageDialogo("confirmar","¿Desea grabar los cambios?" , vista.getTitle());
    if (JOptionPane.YES_OPTION == intDialogo){
      System.out.println("TAMAÑO LISTA COMPONENT "+ vista.getLstComponent().size());
      for (i=0;i<this.getTamLis();i++){
    	List<RegistroVariable> lista=new ArrayList<RegistroVariable>();
    	lista= vista.getValorIndicador(i);
    	this.grabar(i, lista);
      }
      vista.mensageDialogo("informacion","Datos Grabados." , vista.getTitle());
    }	
}

public void nuevo(){
	
}
	  
	  public void procesarComboOrg(){
			captura vista=(captura)this.getSession().getVista();
			if (!(vista.getCmbdto_org().getSelectedItem().getClass().equals(new dtoVacio().getClass())))
			{
				Organizacion org=(Organizacion)vista.cmbdto_org.getSelectedItem();
				modeloPeriodo modeloperiodo=new modeloPeriodo();
				Criterion[] arrCriterios=new Criterion[2];
				arrCriterios[0]=Restrictions.eq("dtoorganizacion", org);
				arrCriterios[1]=Restrictions.eq("bolactivo", true);
			    //List<DtoBase> lis=modeloperiodo.buscar(new Periodo(), "dto_org",org);
				List<DtoBase> lis=modeloperiodo.buscar(new Periodo(),arrCriterios);
			    if (lis.size()>0){
			    	Periodo[] arreglo=new Periodo[lis.size()];
			        for (int i=0; i < lis.size(); i++)     arreglo[i]=(Periodo)lis.get(i);
			        javax.swing.DefaultComboBoxModel modeloComboPeriodo=new javax.swing.DefaultComboBoxModel(arreglo);
			        vista.getCmbdto_periodo().setModelo(modeloComboPeriodo);
			    }else{
			    	vista.panelContenedor.removeAll();
				    vista.mensageDialogo("informacion","No se encontraron periodos activos para:" + org.getStrnombre()+"." , vista.getTitle());
			    }
			}else{
				Periodo[] arreglo=new Periodo[0];
				javax.swing.DefaultComboBoxModel modeloComboPeriodo=new javax.swing.DefaultComboBoxModel(arreglo);
		        vista.getCmbdto_periodo().setModelo(modeloComboPeriodo);
		        vista.panelContenedor.removeAll();
			}//Fin del if	
			
		}//Fin de procesarComboOrg()
	  
private void procesarComboPeriodo(){
	captura vista=(captura)this.getSession().getVista();
	if (!(vista.getCmbdto_periodo().getSelectedItem().getClass().equals(new dtoVacio().getClass()))){
		Periodo periodo = (Periodo)vista.cmbdto_periodo.getSelectedItem();
		Date dtmini_periodo=periodo.getDtmvalido_desde();
		Date dtmfin_periodo=periodo.getDtmvalido_hasta();
		Date dtmactual=new Date();
		System.out.println("INI PERIODO: "+dtmini_periodo);
		System.out.println("FIN PERIODO: "+dtmfin_periodo);
		System.out.println("ACTUAL     : "+dtmactual);
		vista.getDchdtmfecha_valor().setMinSelectableDate(dtmini_periodo);
		vista.getDchdtmfecha_valor().setMaxSelectableDate(dtmfin_periodo);
		System.out.println("MIN SELECCIONABLE: "+vista.getDchdtmfecha_valor().getMinSelectableDate());
		System.out.println("MAX SELECCIONABLE: "+vista.getDchdtmfecha_valor().getMaxSelectableDate());
		if ( (dtmactual.after(dtmini_periodo)) && (dtmactual.before(dtmfin_periodo)) ){
			vista.getDchdtmfecha_valor().setDate(dtmactual);
		}else if(dtmactual.after(dtmfin_periodo)){
			vista.getDchdtmfecha_valor().setDate(dtmfin_periodo);
		}else{
			vista.getDchdtmfecha_valor().setDate(dtmini_periodo);
		}
	}else{
		vista.getDchdtmfecha_valor().setDate(new Date());
		vista.panelContenedor.removeAll();
		vista.getCmbdto_periodo().setSelectedIndex(0);
	}
}
	  
private void procesarComboCategoria(){
	captura vista=(captura)this.getSession().getVista();
	if (vista.isShowing()){
	if (vista.getCmbdto_org().getItemCount()==1 || vista.getCmbdto_org().getSelectedIndex()==0){
		vista.mensageDialogo("informacion","Por favor seleccione una Organización." , vista.getTitle());
		vista.panelContenedor.removeAll();
		vista.getCmbdtocategoria().setSelectedIndex(0);
	}else if (vista.getCmbdto_periodo().getItemCount()==1 || vista.getCmbdto_periodo().getSelectedIndex()==0){
		vista.mensageDialogo("informacion","Por favor seleccione un Período." , vista.getTitle());
		vista.panelContenedor.removeAll();
		vista.getCmbdtocategoria().setSelectedIndex(0);
	}else if (vista.getCmbdtocategoria().getItemCount()==1 || vista.getCmbdtocategoria().getSelectedIndex()==0){
		vista.panelContenedor.removeAll();
		vista.mensageDialogo("informacion","Por favor seleccione una Categoría válida." , vista.getTitle());
	}else{
		Maestro cat=(Maestro)vista.cmbdtocategoria.getSelectedItem();
		modeloIndicador modeloindicador=new modeloIndicador();
	    List<DtoBase> lis=modeloindicador.buscar(new Indicador(), "dtocategoria",cat);
	       if (lis.size()>0){
	    	this.setList(lis);
	    	this.setTamLis(lis.size());
	    	this.setNumPags();
	    	//System.out.println("this.getList(): "+this.getList());
	    	System.out.println("this.getTamLis(): "+this.getTamLis());
	    	System.out.println("this.getNumPags(): " + this.getNumPags());
	    	System.out.println("Limites Pag 1. Inf: " + this.getLimInfPag(1) + " Sup: " + this.getLimSupPag(1));
	    	System.out.println("Limites Pag "+ this.getNumPags()+". Inf: " + this.getLimInfPag(this.getNumPags()) + " Sup: " + this.getLimSupPag(this.getNumPags()));
	    	   
	    	vista.cargarListaComponents(lis);
	    	System.out.println("Componentes cargados. Total Componentes: "+lis.size());
		      //this.paginasList=this.paginar(lis,rexpag);
    	      //this.irapagina(0);
	    	  this.ir_a_pagina(1);
	    	  this.setPag_Actual(1);
	       }else{
	    	   vista.panelContenedor.removeAll();
		      vista.mensageDialogo("informacion","No se encontraron indicadores." , vista.getTitle());
	       }
	}//Fin del if	
	}
}//Fin de procesarComboCategoria()
	  
	  public void actionPerformed(  ActionEvent ae){
//		    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
		    if ("grabar".equals(ae.getActionCommand()))     this.grabar();
//		    if ("buscar".equals(ae.getActionCommand()))     this.buscar();
//		    if ("eliminar".equals(ae.getActionCommand()))     this.eliminar();
		    if ("siguiente".equals(ae.getActionCommand()))     this.siguiente();
		    if ("anterior".equals(ae.getActionCommand()))     this.anterior();
//		    if ("refrescar".equals(ae.getActionCommand()))     this.actualizarVista();
		    if ("primero".equals(ae.getActionCommand()))     this.primero();
		    if ("ultimo".equals(ae.getActionCommand()))     this.ultimo();
		    if ("Salir".equals(ae.getActionCommand()))     this.terminarVista();
		    if ("Lista".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
		    if ("Actual".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
		    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista();
		    
		    if(ae.getSource().getClass().getName().equals("SwingBernate.ayudantes.ComboBox")){
		    	ComboBox objcmb = (ComboBox)ae.getSource();
		    	if (objcmb.getName().equals("cmbdto_org")){
		    		procesarComboOrg();
		    	}else if (objcmb.getName().equals("cmbdto_periodo")){
		    		procesarComboPeriodo();
		    	}else if (objcmb.getName().equals("cmbdtocategoria")){
		    		procesarComboCategoria();
		    	}	
		    }
	  }
	  
		  public void mouseClicked(  MouseEvent e){
	      }
		  public void mouseEntered(  MouseEvent e){
		  }
		  public void mouseExited(  MouseEvent e){
		  }
		  public void mousePressed(  MouseEvent e){
			  //System.out.println(e.getComponent().getName());	  
		  }
		  public void mouseReleased(  MouseEvent e){
		  }
}
