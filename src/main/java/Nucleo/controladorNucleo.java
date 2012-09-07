package Nucleo;

import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SubZona.modeloSubZona;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import SwingBernate.ControladorBase;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ComboBoxSelect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import SocioDeNegocio.modeloSocioDeNegocio;
import Zona.modeloZona;

public class controladorNucleo extends ControladorBase implements ActionListener, MouseListener {
	
  public controladorNucleo(){
    vistaNucleo vista=new vistaNucleo(this);
    Nucleo dto=new Nucleo();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaNucleo vista=(vistaNucleo)this.getSession().getVista();
    Nucleo dto=new Nucleo();
    modeloNucleo modNucleo=new modeloNucleo();
    this.getSession().setListaDto(modNucleo.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Nucleo").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloSocioDeNegocio modeloSocioDeNegocio=new modeloSocioDeNegocio();
    javax.swing.DefaultComboBoxModel modeloComboSocioDeNegocio=new javax.swing.DefaultComboBoxModel(modeloSocioDeNegocio.buscarSocioDeNegocios());
    vista.getCmbdtosocio().setModel(modeloComboSocioDeNegocio);
    
    modeloZona modeloZna=new modeloZona();
    javax.swing.DefaultComboBoxModel modeloComboZona=new javax.swing.DefaultComboBoxModel(modeloZna.buscarZonas());
    vista.getCmbdtozona().setModelo(modeloComboZona);
    
    /*modeloSubZona modeloSubZna=new modeloSubZona();
    javax.swing.DefaultComboBoxModel modeloComboSubZona=new javax.swing.DefaultComboBoxModel(modeloSubZna.buscarSubZonas());
    vista.getCmbdtosubzona().setModelo(modeloComboSubZona);*/
    
    ComboBoxSelect cmbselect = new ComboBoxSelect();
    cmbselect.LlenarSubZona(vista.getCmbdtozona(), vista.getCmbdtosubzona());
    
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaNucleo vista=new vistaNucleo(this);
    vista=(vistaNucleo)this.getSession().getVista();
    vista.setDto(new Nucleo());
  }
  public void grabar(){
    vistaNucleo vista=new vistaNucleo(this);
    vista=(vistaNucleo)this.getSession().getVista();
    Nucleo dto=new Nucleo();
    dto.setHash(vista.getDto(dto));
    
    if(dto.getLngid() ==0){
		dto.setStrip_creacion(this.obtenerIpHost());
		dto.setStrhost_creacion(this.obtenerNombreHost());
		dto.setDtmfecha_creacion(new Date());
		dto.setDtmvalido_hasta(this.sumarAnios(5));
		dto.setBolactivo(true);
	}else{
		dto.setStrip_modificacion(this.obtenerIpHost());
		dto.setStrhost_modificacion(this.obtenerNombreHost());
		dto.setDtmfecha_modificacion(new Date());
	}
    
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloNucleo modelo=new modeloNucleo();
      
      if(dto.getDtosocio() == null || dto.getDtosubzona() == null || dto.getDtozona() == null)
    	  vista.mensageDialogo("error","Debe seleccionar El Socio, La Zona y La Subzona!","Error en datos");
      else  
    	  modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaNucleo vista=new vistaNucleo(this);
    vista=(vistaNucleo)this.getSession().getVista();
    modeloNucleo modelo=new modeloNucleo();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaNucleo vista=new vistaNucleo(this);
    vista=(vistaNucleo)this.getSession().getVista();
    modeloNucleo modelo=new modeloNucleo();
    Nucleo dto=new Nucleo();
    dto=modelo.buscarNucleo(new Nucleo(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Nucleo());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Nucleo());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Nucleo());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Nucleo());
  }
  public void actionPerformed(  ActionEvent ae){
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista() ;
    if ("grabar".equals(ae.getActionCommand()))     this.grabar();
    if ("buscar".equals(ae.getActionCommand()))     this.buscar();
    if ("eliminar".equals(ae.getActionCommand()))     this.eliminar();
    if ("siguiente".equals(ae.getActionCommand()))     this.siguiente();
    if ("anterior".equals(ae.getActionCommand()))     this.anterior();
    if ("refrescar".equals(ae.getActionCommand()))     this.actualizarVista();
    if ("primero".equals(ae.getActionCommand()))     this.primero();
    if ("ultimo".equals(ae.getActionCommand()))     this.ultimo();
    if ("Salir".equals(ae.getActionCommand()))     this.terminarVista();
    if ("Lista".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    if ("Actual".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    
    if(ae.getSource().getClass().getName().equals("SwingBernate.ayudantes.ComboBox")){
    	ComboBox cmbox = (ComboBox)ae.getSource();
    	String nombreCombo = cmbox.getName().toString();
    	    	
    	if( nombreCombo.contains("cmbDtozona")){
    		ComboBoxSelect cmbselect = new ComboBoxSelect();
    		vistaNucleo vista = (vistaNucleo)this.getSession().getVista();
    		cmbselect.LlenarSubZona(vista.getCmbdtozona(), vista.getCmbdtosubzona());
    	}
    }
    
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
  	if (e.getClickCount() == 2) {
          JTable target = (JTable)e.getSource();
          int row = target.getSelectedRow();
          this.getSession().setDtoActual(row,new Nucleo());
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

