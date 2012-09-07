package Maestro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Maestro.Maestro;
import Maestro.modeloMaestro;
import Maestro.vistaMaestro;
import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.opcionListaCombo;
import Usuario.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import moduloPrototipo.mainPrototipo;

public class controladorMaestro extends ControladorBase implements ActionListener, MouseListener,KeyListener {
	
	private String tipoMaestro = "";
	
	public controladorMaestro(){}
	
	public controladorMaestro(String param){
		vistaMaestro vista=new vistaMaestro(this);
		Maestro dto=new Maestro();
		this.iniciarSesion(vista,dto);
		if(param != ""){
			String[] params = param.split(",");
			this.tipoMaestro = params[0].trim();
			vista.getLbldtomaestro().setText(params[1].trim());
			vista.setTitle(params[2].trim());
		}		
		//this.crearMaestroInicio(vista);
		this.actualizarVista();
		if (this.getSession().getListaDto().size()==0){
	    	vista.getCentro2().setVisible(false);
	    	vista.getCentro().setVisible(true);
	    }else{
	    	this.cambiarVista();
	    }
		this.getSession().getVista().getSimpleGrid().addMouseListener(this);
	}
	public void actualizarVista(){

		vistaMaestro vista=(vistaMaestro)this.getSession().getVista();
		Maestro dto=new Maestro();
		modeloMaestro modMaestro=new modeloMaestro();
		
		if(this.tipoMaestro != "")
			this.getSession().setListaDto(modMaestro.lstHijosPorMaestro(this.tipoMaestro));
		else
			this.getSession().setListaDto(modMaestro.buscar(dto));

		modeloReporte modeloReporte=new modeloReporte();
		javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Maestro").toArray());
		vista.getImprimir().getTemplate().setModel(modeloComboReporte);

		//javax.swing.DefaultComboBoxModel modeloComboMaestro=new javax.swing.DefaultComboBoxModel(modeloMaestro.buscarMaestros());
		javax.swing.DefaultComboBoxModel modeloComboMaestro;
		if(this.tipoMaestro != ""){
			Maestro[] arrTipoMaestro = new Maestro[1];
			arrTipoMaestro[0] = modMaestro.buscarMaestro(new Maestro(), "strcodigo", this.tipoMaestro);
			//modeloComboMaestro=new javax.swing.DefaultComboBoxModel(modMaestro.hijosPorMaestro(this.tipoMaestro));
			modeloComboMaestro=new javax.swing.DefaultComboBoxModel(arrTipoMaestro);
		}
		else
			modeloComboMaestro=new javax.swing.DefaultComboBoxModel(modMaestro.buscarMaestros());
		
		vista.getCmbdtomaestro().setModelo(modeloComboMaestro);

		this.cargarCmbShort(vista.getCmbshrnivel(), vista.getCmbdtomaestro());
		this.cargarCmbShort(vista.getCmbshrpos_rel(), vista.getCmbdtomaestro());
		this.getSession().setDtoActual(0,dto);
		//dto = (Maestro)this.getSession().getDto(0);
		this.cargarGrid();

	}
	public void nuevo(){
		vistaMaestro vista=new vistaMaestro(this);
		vista=(vistaMaestro)this.getSession().getVista();
		vista.setDto(new Maestro());
		this.crearMaestroInicio(vista);
		this.cargarCmbShort(vista.getCmbshrnivel(), vista.getCmbdtomaestro());
		this.cargarCmbShort(vista.getCmbshrpos_rel(), vista.getCmbdtomaestro());
		if (vista.getCentro2().isVisible()){
	    	this.cambiarVista();
	    }
	    vista.limpiarError();
	    vista.getChkbolactivo().setSelected(true);
	}
	public void grabar(){
	    vistaMaestro vista=new vistaMaestro(this);
	    vista=(vistaMaestro)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    
	    if (strlngid.isEmpty() || strlngid.length()==0){
	    	vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
	    }else{
	    	Maestro dto=new Maestro();
	        dto.setHash(vista.getDto(dto));
	        this.getSession().setUsuarioInicio(vista);
	        if(dto.getLngid() ==0){
	        	dto.setLngseg_usuario_creacion(this.getSession().getLngusr());
	        	dto.setDtmfecha_creacion(new Date());
	    		dto.setStrip_creacion(this.obtenerIpHost());
	    		dto.setStrhost_creacion(this.obtenerNombreHost());
	    		dto.setLngseg_usuario_modificacion(this.getSession().getLngusr());
	    		dto.setDtmfecha_modificacion(new Date());
	    		dto.setStrip_modificacion(this.obtenerIpHost());
	    		dto.setStrhost_modificacion(this.obtenerNombreHost());
	    		dto.setDtmvalido_desde(new Date());
	    		dto.setDtmvalido_hasta(this.sumarAnios(20));
	    		dto.setBolborrado(false);
	    		
	    	}else{
	    		dto.setStrip_modificacion(this.obtenerIpHost());
	    		dto.setStrhost_modificacion(this.obtenerNombreHost());
	    		dto.setDtmfecha_modificacion(new Date());
	    		dto.setLngseg_usuario_modificacion(this.getSession().getLngusr());
	    	}
	        List<String> lsError=this.testValidacion(dto);
	        if (lsError.isEmpty()) {
	  	      int intDialogo = vista.mensageDialogo("confirmar","¿Desea grabar los cambios?" , vista.getTitle());
	  	      if (JOptionPane.YES_OPTION == intDialogo){
	               modeloMaestro modelo=new modeloMaestro();
	               modelo.grabar(dto);
	               vista.mensageDialogo("informacion","Datos Grabados." , vista.getTitle());
	               vista.limpiarError();
	  	      }
	        }
	        else {
	           //vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
	           vista.marcarError(lsError);
	        }
	    }
	  }
	public void eliminar(){
		vistaMaestro vista=new vistaMaestro(this);
		vista=(vistaMaestro)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
	    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
	    }else{
	       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
	    	 modeloMaestro modelo=new modeloMaestro();
	         modelo.eliminar(vista.getTxtlngid().getText().trim());
	       }
	    }
	}
	public void buscar(){
		vistaMaestro vista=new vistaMaestro(this);
		vista=(vistaMaestro)this.getSession().getVista();
		String str=vista.getTxtlngid().getText().trim();
	    if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
	       vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
	    }else{
	    	modeloMaestro modelo=new modeloMaestro();
	        Maestro dto=new Maestro();
	        dto=modelo.buscarMaestro(new Maestro(),"lngid",str);
	        vista.setDto(dto);		
	    }
	}
	public void refrescar(){
		vistaMaestro vista=new vistaMaestro(this);
		vista=(vistaMaestro)this.getSession().getVista();
		vista.limpiarError();
		  if (this.getSession().getListaDto().size()>0){
			  this.actualizarVista();
		 	}else{
		 		vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		 	}
	  }
	public void siguiente(){
		int sig = this.getSession().getActual() + 1;
		if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(sig,new Maestro());
	    	if(sig<=this.getSession().getListaDto().size()){
				Maestro dto = (Maestro)this.getSession().getDto(sig);
				this.setearCmbShort(dto);
			}
	 	}else{
	 		vistaMaestro vista=new vistaMaestro(this);
	 		vista=(vistaMaestro)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	}
	public void anterior(){
		int ant = this.getSession().getActual() - 1;
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(ant,new Maestro());
			if(ant >=0){
				Maestro dto = (Maestro)this.getSession().getDto(ant);
				this.setearCmbShort(dto);
			}
	 	}else{
	 		vistaMaestro vista=new vistaMaestro(this);
	 		vista=(vistaMaestro)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}		
	}
	public void primero(){
		if (this.getSession().getListaDto().size()>0){
			this.getSession().setDtoActual(0,new Maestro());
			Maestro dto = (Maestro)this.getSession().getDto(0);
			this.setearCmbShort(dto);
	 	}else{
	 		vistaMaestro vista=new vistaMaestro(this);
	 		vista=(vistaMaestro)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}		
	}
	public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
			int ult = this.getSession().getListaDto().size() - 1;
			this.getSession().setDtoActual(ult,new Maestro());
			Maestro dto = (Maestro)this.getSession().getDto(ult);
			this.setearCmbShort(dto);
		}else{
				vistaMaestro vista=new vistaMaestro(this);
				vista=(vistaMaestro)this.getSession().getVista();
				vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
			}
		
	}
	public void actionPerformed(  ActionEvent ae){
		if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
		if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista() ;
		if ("grabar".equals(ae.getActionCommand()))     this.grabar();
		if ("buscar".equals(ae.getActionCommand()))     this.buscar();
		if ("eliminar".equals(ae.getActionCommand()))     this.eliminar();
		if ("siguiente".equals(ae.getActionCommand()))     this.siguiente();
		if ("anterior".equals(ae.getActionCommand()))     this.anterior();
		if ("refrescar".equals(ae.getActionCommand()))     this.refrescar();
		if ("primero".equals(ae.getActionCommand()))     this.primero();
		if ("ultimo".equals(ae.getActionCommand()))     this.ultimo();
		if ("Salir".equals(ae.getActionCommand()))     this.terminarVista();
		if ("Lista".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
		if ("Actual".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
		if(ae.getSource().getClass().getName().equals("SwingBernate.ayudantes.ComboBox")){
			ComboBox cmbox = (ComboBox)ae.getSource();
			try {
				Maestro selectMaestro = (Maestro)cmbox.getSelectedItem();
				int intNivel = selectMaestro.getIntnivel()+1;
				opcionListaCombo optNivel_Pos = new opcionListaCombo((short)intNivel, "Nivel: "+intNivel);
				List<opcionListaCombo> lst = new ArrayList<opcionListaCombo>();
				lst.add(optNivel_Pos);
				this.cargarCmbShort(((vistaMaestro)this.getSession().getVista()).getCmbshrnivel(), lst);
				
				int nuHijos = selectMaestro.getDtohijos().size();
				lst.clear();
				int i = 0;
				while (i <= nuHijos) {
					i ++;
					optNivel_Pos = new opcionListaCombo((short)i, "Pos: "+i);
					lst.add(optNivel_Pos);
				}
				this.cargarCmbShort(((vistaMaestro)this.getSession().getVista()).getCmbshrpos_rel(), lst);

			} catch (Exception e) {
				// TODO: handle exception
				//System.out.println("seleccionó Vacio "+e.getMessage());
			}    	
		}
	}
	public void cargarCmbShort(JComboBox cmbShort, ComboBox cmbpadre){
		opcionListaCombo opcion = new opcionListaCombo();
		if(cmbShort.getName().equals("cmbshrnivel"))
			opcion = new opcionListaCombo((short)1, "Nivel: "+1);
		else
			opcion = new opcionListaCombo((short)1, "Pos: "+1);
		List<opcionListaCombo> lstopcion = new ArrayList<opcionListaCombo>();
		if(cmbpadre.getSelectedItem().getClass().getCanonicalName().equals("SwingBernate.dtoVacio")){
			lstopcion.add(opcion);
			DefaultComboBoxModel shrotModelo = new DefaultComboBoxModel(lstopcion.toArray());
			cmbShort.setModel(shrotModelo);  
		}
	}
	public void cargarCmbShort(JComboBox cmbShort, List<opcionListaCombo> lista){
		DefaultComboBoxModel shrotModelo = new DefaultComboBoxModel(lista.toArray());
		cmbShort.setModel(shrotModelo);
		cmbShort.setSelectedIndex(lista.size()-1);
	}	
	public void setearCmbShort(Maestro dtoM){
		vistaMaestro vista = (vistaMaestro)this.getSession().getVista();
		if(dtoM.getDtomaestro()==null){
			//TODO
			this.cargarCmbShort(vista.getCmbshrnivel(), vista.getCmbdtomaestro());
			this.cargarCmbShort(vista.getCmbshrpos_rel(), vista.getCmbdtomaestro());
		}else{
			opcionListaCombo opcion = new opcionListaCombo(dtoM.getIntpos_rel(), "Pos: "+dtoM.getIntpos_rel());
			vista.getCmbshrpos_rel().setSelectedItem(opcion);
		}
	}
	public void crearMaestroInicio(vistaMaestro vista){	
		//mainPrototipo principal = (mainPrototipo)vista.getParent().getParent().getParent().getParent().getParent();
		modeloMaestro modeloMaestro=new modeloMaestro();
		
		if(modeloMaestro.buscarMaestros().length==0){
			//System.out.println("Crear Maestro inicio");
			Maestro mstr = new Maestro();
			mstr.setLngid(0);
			mstr.setStrcodigo("RAIZ");
			mstr.setStrnombre("Sistema");
			mstr.setStrsigla("RAIZ");
			mstr.setIntnivel((short)1);
			mstr.setIntpos_rel((short)1);
			mstr.setStrip_creacion(this.obtenerIpHost());
			mstr.setStrhost_creacion(this.obtenerNombreHost());
			mstr.setDtmfecha_creacion(new Date());
			mstr.setDtmvalido_hasta(this.sumarAnios(5));
			mstr.setBolactivo(true);			
			//mstr.setDtousuario_cracion(principal.getUsrConectado());
			modeloMaestro.grabar(mstr);
			javax.swing.DefaultComboBoxModel modeloComboMaestro=new javax.swing.DefaultComboBoxModel(modeloMaestro.buscarMaestros());
			vista.getCmbdtomaestro().setModelo(modeloComboMaestro);
			this.getSession().setListaDto(modeloMaestro.buscar(new Maestro()));
		}
		this.cargarGrid();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			JTable target = (JTable)e.getSource();
			int row = target.getSelectedRow();
			this.getSession().setDtoActual(row,new Maestro());
			this.cambiarVista();       
		}	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

