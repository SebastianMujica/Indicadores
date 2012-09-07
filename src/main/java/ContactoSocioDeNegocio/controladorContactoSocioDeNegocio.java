package ContactoSocioDeNegocio;
import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import SocioDeNegocio.modeloSocioDeNegocio;
import ContactoSocioDeNegocio.ContactoSocioDeNegocio;
import ContactoSocioDeNegocio.modeloContactoSocioDeNegocio;
import ContactoSocioDeNegocio.vistaContactoSocioDeNegocio;
import Maestro.modeloMaestro;
public class controladorContactoSocioDeNegocio extends ControladorBase implements ActionListener, MouseListener {
  public controladorContactoSocioDeNegocio(){
    vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
    ContactoSocioDeNegocio dto=new ContactoSocioDeNegocio();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    if (this.getSession().getListaDto().size()==0){
    	vista.getCentro2().setVisible(false);
    	vista.getCentro().setVisible(true);
    }else{ this.cambiarVista();}
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaContactoSocioDeNegocio vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
    ContactoSocioDeNegocio dto=new ContactoSocioDeNegocio();
    modeloContactoSocioDeNegocio modContactoSocioDeNegocio=new modeloContactoSocioDeNegocio();
    this.getSession().setListaDto(modContactoSocioDeNegocio.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","ContactoSocioDeNegocio").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloSocioDeNegocio modeloSocioDeNegocio=new modeloSocioDeNegocio();
    javax.swing.DefaultComboBoxModel modeloComboSocioDeNegocio=new javax.swing.DefaultComboBoxModel(modeloSocioDeNegocio.buscarSocioDeNegocios());
    vista.getCmbdto_sociodenegocio().setModel(modeloComboSocioDeNegocio);
    modeloMaestro modeloMaestro=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloComboMaestro=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("TIPO_COMM_PER"));
    vista.getCmbdto_tipo_contacto().setModel(modeloComboMaestro);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
		vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
		vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
		vista.setDto(new ContactoSocioDeNegocio());
		if (vista.getCentro2().isVisible()){
	    	this.cambiarVista();
	    }
	    vista.limpiarError();
	    vista.getChkbolactivo().setSelected(true);
	}
	public void grabar(){
		vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
		vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0){
	    	vista.mensageDialogo("error","Identificador vacío o inválido.\nÉste debe ser mayor o igual a cero." , vista.getTitle());
	    }else{
	    	ContactoSocioDeNegocio dto=new ContactoSocioDeNegocio();
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
	               modeloContactoSocioDeNegocio modelo=new modeloContactoSocioDeNegocio();
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
		vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
		vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
		String strlngid=vista.getTxtlngid().getText();
	    if (strlngid.isEmpty() || strlngid.length()==0 || strlngid.trim().contentEquals("0")){
	    	vista.mensageDialogo("error","Identificador de Registro No Válido." , vista.getTitle());
	    }else{
	       if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?",vista.getTitle()) == 0) {
	    	 modeloContactoSocioDeNegocio modelo=new modeloContactoSocioDeNegocio();
	         modelo.eliminar(vista.getTxtlngid().getText().trim());
	       }
	    }
	}
	public void buscar(){
		vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
		vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
		String str=vista.getTxtlngid().getText().trim();
	    if (str.isEmpty() || str.length()==0 || str.contentEquals("0")){
	       vista.mensageDialogo("error","Valor de búsqueda vacío o inválido.\nIntroduzca un número mayor que cero." , vista.getTitle());
	    }else{
	    	modeloContactoSocioDeNegocio modelo=new modeloContactoSocioDeNegocio();
	        ContactoSocioDeNegocio dto=new ContactoSocioDeNegocio();
	        dto=modelo.buscarContactoSocioDeNegocio(new ContactoSocioDeNegocio(),"lngid",str);
	        vista.setDto(dto);		
	    }
	}
	public void refrescar(){
		  vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
		  vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
		  vista.limpiarError();
		  if (this.getSession().getListaDto().size()>0){
			  this.actualizarVista();
		 	}else{
		 		vista.mensageDialogo("error","No Existen Datos que actualizar." , vista.getTitle());
		 	}
	  }
	public void siguiente(){
		if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() + 1,new ContactoSocioDeNegocio());
	 	}else{
	 		vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
	 		vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	}
	public void anterior(){
		if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(this.getSession().getActual() - 1,new ContactoSocioDeNegocio());
	 	}else{
	 		vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
	 		vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	}
	public void primero(){
		if (this.getSession().getListaDto().size()>0){
	    	this.getSession().setDtoActual(0,new ContactoSocioDeNegocio());
	 	}else{
	 		vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
	 		vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
	 		vista.mensageDialogo("error","No Existen Datos que mostrar." , vista.getTitle());
	 	}
	}
	public void ultimo(){
		if (this.getSession().getListaDto().size()>0){
		       this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new ContactoSocioDeNegocio());
			}else{
				vistaContactoSocioDeNegocio vista=new vistaContactoSocioDeNegocio(this);
				vista=(vistaContactoSocioDeNegocio)this.getSession().getVista();
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
      this.getSession().setDtoActual(row,new ContactoSocioDeNegocio());
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

