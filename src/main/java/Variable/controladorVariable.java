package Variable;
import groovy.lang.GroovyShell;
import java.util.Date;
import java.util.List;

import Maestro.modeloMaestro;
import Organizacion.modeloOrganizacion;
import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import UnidadDeMedida.modeloUnidadDeMedida;
import Variable.Variable;
import Variable.modeloVariable;
import Variable.vistaVariable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class controladorVariable extends ControladorBase implements ActionListener, MouseListener,KeyListener {
  public controladorVariable(){
    vistaVariable vista=new vistaVariable(this);
    Variable dto=new Variable();
    this.iniciarSesion(vista,dto);
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
    vistaVariable vista=(vistaVariable)this.getSession().getVista();
    Variable dto=new Variable();
    modeloVariable modVariable=new modeloVariable();
    this.getSession().setListaDto(modVariable.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Variable").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    
    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
    vista.getCmbdto_org().setModel(modeloComboOrganizacion);
    
    modeloMaestro modeloMaestro=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloComboCategoria=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("CAT_IND"));
    vista.getCmbdtocategoria().setModelo(modeloComboCategoria);
    
    javax.swing.DefaultComboBoxModel modeloComboTipo_Dato=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("TIP_DAT"));
    vista.getCmbdtotipo_dato().setModelo(modeloComboTipo_Dato);
    
    modeloUnidadDeMedida modeloUnidaDeMedida=new modeloUnidadDeMedida();
    javax.swing.DefaultComboBoxModel modeloComboUnidadDeMedida=new javax.swing.DefaultComboBoxModel(modeloUnidaDeMedida.buscarUnidadDeMedidas());
    vista.getCmbdtounidad_medida().setModelo(modeloComboUnidadDeMedida);
    
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  
  public void nuevo(){
	    vistaVariable vista=new vistaVariable(this);
	    vista=(vistaVariable)this.getSession().getVista();
	    vista.setDto(new Variable());
	    if (vista.getCentro2().isVisible()){
	    	this.cambiarVista();
	    }
	    vista.limpiarError();
	    vista.getChkbolactivo().setSelected(true);
	  }
	  public void grabar(){
	    vistaVariable vista=new vistaVariable(this);
	    vista=(vistaVariable)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    
	    if (strlngid.isEmpty() || strlngid.length()==0){
	    	vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
	    }else{
	    	Variable dto=new Variable();
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
	    		//dto.setBolactivo(true);
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
	               modeloVariable modelo=new modeloVariable();
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
	    vistaVariable vista=new vistaVariable(this);
	    vista=(vistaVariable)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
	    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
	    }else{
	       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
	    	 modeloVariable modelo=new modeloVariable();
	         modelo.eliminar(vista.getTxtlngid().getText().trim());
	       }
	    }
	  }
	  public void buscar(){
	    vistaVariable vista=new vistaVariable(this);
	    vista=(vistaVariable)this.getSession().getVista();
	    String str=vista.getTxtlngid().getText().trim();
	    if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
	       vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
	    }else{
	    	modeloVariable modelo=new modeloVariable();
	        Variable dto=new Variable();
	        dto=modelo.buscarVariable(new Variable(),"lngid",str);
	        vista.setDto(dto);		
	    }
	  }
	  public void refrescar(){
		  vistaVariable vista=new vistaVariable(this);
		  vista=(vistaVariable)this.getSession().getVista();
		  vista.limpiarError();
		  if (this.getSession().getListaDto().size()>0){
			  this.actualizarVista();
		 	}else{
		 		vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		 	}
	  }
	  public void siguiente(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() + 1,new Variable());
	 	}else{
	 		vistaVariable vista=new vistaVariable(this);
	 		vista=(vistaVariable)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void anterior(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() - 1,new Variable());
	 	}else{
	 		vistaVariable vista=new vistaVariable(this);
	 		vista=(vistaVariable)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void primero(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(0,new Variable());
	 	}else{
	 		vistaVariable vista=new vistaVariable(this);
	 		vista=(vistaVariable)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
	       this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Variable());
		}else{
			vistaVariable vista=new vistaVariable(this);
			vista=(vistaVariable)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
	  }
  public void editar(){
//	    
//	    Console console = new Console();
//	    modeloSocioDeNegocio socio=new modeloSocioDeNegocio();
//	    console.setVariable("socio", socio);
//	    
//	    console.run();
//	   	    
	    //vistaVariable vista=(vistaVariable)this.getSession().getVista();
	    
	    //System.out.println(vista.getTxtstrformula().getTextEditor().getText());
	    
  }
  public void actionPerformed(  ActionEvent ae){
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
    if ("deshacer".equals(ae.getActionCommand()))     {
    	vistaVariable vista=(vistaVariable)this.getSession().getVista();
    	try {
    		vista.getTxtstrformula().getUndoAction().actionPerformed(ae);	
		} catch (Exception e) {
			System.out.println("No hay mas que deshacer");
		}
    	
    	}
    if ("rehacer".equals(ae.getActionCommand()))     {
    	vistaVariable vista=(vistaVariable)this.getSession().getVista(); 
    	
    	try {
    		vista.getTxtstrformula().getRedoAction().actionPerformed(ae);	
		} catch (Exception e) {
			System.out.println("No hay mas que rehacer");
		}
    	
    	}
    if ("grabar".equals(ae.getActionCommand()))     this.grabar();
    if ("probar".equals(ae.getActionCommand()))  {
    	vistaVariable vista=(vistaVariable)this.getSession().getVista();
    	//vista.getPaneTxt().setBackground(Color.white);

    	GroovyShell shell=new GroovyShell();
        shell.getClassLoader().addClasspath("/lib/");
    	
    
    try {
    		//vista.getPaneTxt().setText(shell.evaluate(vista.getTxtstrformula().getTextEditor().getText()).toString());
    	shell.evaluate(vista.getTxtstrformula().getTextEditor().getText());
		} catch (Exception e) {
			
			
			Throwable exc = e;
	        StringBuffer output = new StringBuffer();
	        collectTraces(exc, output);
	        if (exc.getCause() != null) {
	           exc = exc.getCause();
	           output.append("caused by::\n");
	           output.append(exc.getMessage());
	           output.append("\n");
	           collectTraces(exc, output);
	           //vista.getPaneTxt().setBackground(Color.red);
	           //vista.getPaneTxt().setText(output.toString());
	        }
			
		System.out.println(output);
		}
    	
    	
    } 
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
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista();
  }
  private void collectTraces(Throwable e, StringBuffer output) {
      StackTraceElement[] trace = e.getStackTrace();
      for (int i=0; i < trace.length; i++) {
          output.append(trace[i].toString());
          output.append("\n");
      }
  }
  public void mouseClicked(  MouseEvent e){
    if (e.getClickCount() == 2) {
      JTable target=(JTable)e.getSource();
      int row=target.getSelectedRow();
      this.getSession().setDtoActual(row,new Variable());
      this.cambiarVista();
    }
  }
  public void mouseEntered(  MouseEvent e){
  }
  public void mouseExited(  MouseEvent e){
  }
  public void mousePressed(  MouseEvent e){
  }
  public void mouseReleased(  MouseEvent e){
  }
}

