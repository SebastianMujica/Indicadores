package Empleado_Org;
import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Empleado_Org.Empleado_Org;
import Empleado_Org.modeloEmpleado_Org;
import Empleado_Org.vistaEmpleado_Org;
import Cargo_Org.Cargo_Org;
import Cargo_Org.vistaCargo_Org;
import Maestro.modeloMaestro;
import Organizacion.modeloOrganizacion;
import SocioDeNegocio.modeloSocioDeNegocio;

public class controladorEmpleado_Org extends ControladorBase implements ActionListener, MouseListener,KeyListener {
  public controladorEmpleado_Org(){
    vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
    Empleado_Org dto=new Empleado_Org();
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
    vistaEmpleado_Org vista=(vistaEmpleado_Org)this.getSession().getVista();
    Empleado_Org dto=new Empleado_Org();
    modeloEmpleado_Org modEmpleado_Org=new modeloEmpleado_Org();
    this.getSession().setListaDto(modEmpleado_Org.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Empleado_Org").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    
    modeloMaestro modeloMaestro=new modeloMaestro();
    
    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
    vista.getCmbdto_org().setModelo(modeloComboOrganizacion);
    modeloSocioDeNegocio modeloSocioDeNegocio=new modeloSocioDeNegocio();
    javax.swing.DefaultComboBoxModel modeloComboSocioDeNegocio=new javax.swing.DefaultComboBoxModel(modeloSocioDeNegocio.buscarSocioDeNegocios());
    vista.getCmbdto_socionegocio().setModelo(modeloComboSocioDeNegocio);
    
    javax.swing.DefaultComboBoxModel modeloComboNivelEstudio=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("TIPO_NIV_EST"));
    vista.getCmbdtonivel_estudio().setModelo(modeloComboNivelEstudio);
    
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
    vista=(vistaEmpleado_Org)this.getSession().getVista();
    vista.setDto(new Empleado_Org());
    if (vista.getCentro2().isVisible()){
    	this.cambiarVista();
    }
    vista.limpiarError();
    vista.getChkbolactivo().setSelected(true);
  }
  public void grabar(){
	    vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
	    vista=(vistaEmpleado_Org)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    
	    if (strlngid.isEmpty() || strlngid.length()==0){
	    	vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
	    }else{
	    	Empleado_Org dto=new Empleado_Org();
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
	               modeloEmpleado_Org modelo=new modeloEmpleado_Org();
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
    vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
    vista=(vistaEmpleado_Org)this.getSession().getVista();
    String strlngid=vista.getTxtlngid().getText();
    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
    }else{
       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
    	 modeloEmpleado_Org modelo=new modeloEmpleado_Org();
         modelo.eliminar(vista.getTxtlngid().getText().trim());
       }
    }
  }
  public void buscar(){
    vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
    vista=(vistaEmpleado_Org)this.getSession().getVista();
    String str=vista.getTxtlngid().getText().trim();
    if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
       vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
    }else{
    	modeloEmpleado_Org modelo=new modeloEmpleado_Org();
    	Empleado_Org dto=new Empleado_Org();
        dto=modelo.buscarEmpleado_Org(new Empleado_Org(),"lngid",str);
        vista.setDto(dto);		
    }
  }
  public void refrescar(){
	  vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
	  vista=(vistaEmpleado_Org)this.getSession().getVista();
	  vista.limpiarError();
	  if (this.getSession().getListaDto().size()>0){
		  this.actualizarVista();
	 	}else{
	 		vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
	 	}
  }
  public void siguiente(){
	  if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() + 1,new Cargo_Org());
	 	}else{
	 		vistaCargo_Org vista=new vistaCargo_Org(this);
	 		vista=(vistaCargo_Org)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
  }
  public void anterior(){
	  if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() - 1,new Empleado_Org());
	 	}else{
	 		vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
	 		vista=(vistaEmpleado_Org)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
  }
  public void primero(){
	  if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(0,new Empleado_Org());
	 	}else{
	 		vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
	 		vista=(vistaEmpleado_Org)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
  }
  public void ultimo(){
	  if (this.getSession().getListaDto().size()>0){
	       this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Empleado_Org());
		}else{
			vistaEmpleado_Org vista=new vistaEmpleado_Org(this);
			vista=(vistaEmpleado_Org)this.getSession().getVista();
			vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
		}
  }
  public void actionPerformed(  ActionEvent ae){
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
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
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista();
  }
  public void mouseClicked(  MouseEvent e){
    if (e.getClickCount() == 2) {
      JTable target=(JTable)e.getSource();
      int row=target.getSelectedRow();
      this.getSession().setDtoActual(row,new Empleado_Org());
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

