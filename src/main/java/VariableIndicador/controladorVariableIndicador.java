package VariableIndicador;
import java.util.Date;
import java.util.List;

import Maestro.modeloMaestro;
import Organizacion.modeloOrganizacion;
import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import UnidadDeMedida.modeloUnidadDeMedida;
import VariableIndicador.VariableIndicador;
import VariableIndicador.modeloVariableIndicador;
import VariableIndicador.vistaVariableIndicador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
public class controladorVariableIndicador extends ControladorBase implements ActionListener, MouseListener,KeyListener {
  public controladorVariableIndicador(){
    vistaVariableIndicador vista=new vistaVariableIndicador(this);
    VariableIndicador dto=new VariableIndicador();
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
    vistaVariableIndicador vista=(vistaVariableIndicador)this.getSession().getVista();
    VariableIndicador dto=new VariableIndicador();
    modeloVariableIndicador modVariableIndicador=new modeloVariableIndicador();
    this.getSession().setListaDto(modVariableIndicador.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","VariableIndicador").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    
    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
    vista.getCmbdto_org().setModel(modeloComboOrganizacion);
    
    modeloMaestro modeloMaestro=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloComboCategoria=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("CAT_IND"));
    vista.getCmbdto_categoria().setModelo(modeloComboCategoria);
    
    modeloUnidadDeMedida modeloUnidaDeMedida=new modeloUnidadDeMedida();
    javax.swing.DefaultComboBoxModel modeloComboUnidadDeMedida=new javax.swing.DefaultComboBoxModel(modeloUnidaDeMedida.buscarUnidadDeMedidas());
    vista.getCmbdto_unidad_medida().setModelo(modeloComboUnidadDeMedida);
    
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
	    vistaVariableIndicador vista=new vistaVariableIndicador(this);
	    vista=(vistaVariableIndicador)this.getSession().getVista();
	    vista.setDto(new VariableIndicador());
	    if (vista.getCentro2().isVisible()){
	    	this.cambiarVista();
	    }
	    vista.limpiarError();
	  }
	  public void grabar(){
	    vistaVariableIndicador vista=new vistaVariableIndicador(this);
	    vista=(vistaVariableIndicador)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    
	    if (strlngid.isEmpty() || strlngid.length()==0){
	    	vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
	    }else{
	    	VariableIndicador dto=new VariableIndicador();
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
	    		dto.setBolactivo(true);
	    		
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
	               modeloVariableIndicador modelo=new modeloVariableIndicador();
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
	    vistaVariableIndicador vista=new vistaVariableIndicador(this);
	    vista=(vistaVariableIndicador)this.getSession().getVista();
	    String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
	    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
	    }else{
	       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
	    	 modeloVariableIndicador modelo=new modeloVariableIndicador();
	         modelo.eliminar(vista.getTxtlngid().getText().trim());
	       }
	    }
	  }
	  public void buscar(){
	    vistaVariableIndicador vista=new vistaVariableIndicador(this);
	    vista=(vistaVariableIndicador)this.getSession().getVista();
	    String str=vista.getTxtlngid().getText().trim();
	    if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
	       vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
	    }else{
	    	modeloVariableIndicador modelo=new modeloVariableIndicador();
	        VariableIndicador dto=new VariableIndicador();
	        dto=modelo.buscarVariableIndicador(new VariableIndicador(),"lngid",str);
	        vista.setDto(dto);		
	    }
	  }
	  public void refrescar(){
		  vistaVariableIndicador vista=new vistaVariableIndicador(this);
		  vista=(vistaVariableIndicador)this.getSession().getVista();
		  vista.limpiarError();
		  if (this.getSession().getListaDto().size()>0){
			  this.actualizarVista();
		 	}else{
		 		vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		 	}
	  }
	  public void siguiente(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() + 1,new VariableIndicador());
	 	}else{
	 		vistaVariableIndicador vista=new vistaVariableIndicador(this);
	 		vista=(vistaVariableIndicador)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void anterior(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() - 1,new VariableIndicador());
	 	}else{
	 		vistaVariableIndicador vista=new vistaVariableIndicador(this);
	 		vista=(vistaVariableIndicador)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void primero(){
	    if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(0,new VariableIndicador());
	 	}else{
	 		vistaVariableIndicador vista=new vistaVariableIndicador(this);
	 		vista=(vistaVariableIndicador)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	  }
	  public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
	       this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new VariableIndicador());
		}else{
			vistaVariableIndicador vista=new vistaVariableIndicador(this);
			vista=(vistaVariableIndicador)this.getSession().getVista();
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
      this.getSession().setDtoActual(row,new VariableIndicador());
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

