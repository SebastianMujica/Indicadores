package Hacienda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
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

import Productor.Productor;
import Productor.modeloProductor;
import Tablon.modeloTablon;
import Zona.modeloZona;
public class controladorHacienda extends ControladorBase implements ActionListener , MouseListener{
  public controladorHacienda(){
    vistaHacienda vista=new vistaHacienda(this);
    Hacienda dto=new Hacienda();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaHacienda vista=(vistaHacienda)this.getSession().getVista();
    Hacienda dto=new Hacienda();
    modeloHacienda modHacienda=new modeloHacienda();
    this.getSession().setListaDto(modHacienda.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Hacienda").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloProductor modeloProductor=new modeloProductor();
    javax.swing.DefaultComboBoxModel modeloComboProductor=new javax.swing.DefaultComboBoxModel(modeloProductor.buscarProductors());
    vista.getCmbdtoproductor().setModel(modeloComboProductor);
    modeloTablon modeloTablon=new modeloTablon();
    vista.getLstdtotablones().setModelDes(modeloTablon.buscarTablons());
    
    modeloZona modeloZona=new modeloZona();
    javax.swing.DefaultComboBoxModel modeloComboZona=new javax.swing.DefaultComboBoxModel(modeloZona.buscarZonas());
    vista.getCmbdtozona().setModelo(modeloComboZona);
    
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();

  }
  public void nuevo(){
    vistaHacienda vista=new vistaHacienda(this);
    vista=(vistaHacienda)this.getSession().getVista();
    vista.setDto(new Hacienda());
  }
  public void grabar(){
    vistaHacienda vista=new vistaHacienda(this);
    vista=(vistaHacienda)this.getSession().getVista();
    Hacienda dto=new Hacienda();
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
    	if( vista.getCmbdtozona().getSelectedItem().getClass().getCanonicalName().equalsIgnoreCase("SwingBernate.dtoVacio") ||
    			vista.getCmbdtosubzona().getSelectedItem().getClass().getCanonicalName().equalsIgnoreCase("SwingBernate.dtoVacio") ){
    		vista.mensageDialogo("error","Por favor verifíque los datos de Zona y Subzona.\n Debe ingresarlos correctamente!","Error en datos");
    	}else{    		
    		modeloHacienda modelo=new modeloHacienda();
    		modelo.grabar(dto);	
    	}
      
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaHacienda vista=new vistaHacienda(this);
    vista=(vistaHacienda)this.getSession().getVista();
    modeloHacienda modelo=new modeloHacienda();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaHacienda vista=new vistaHacienda(this);
    vista=(vistaHacienda)this.getSession().getVista();
    modeloHacienda modelo=new modeloHacienda();
    Hacienda dto=new Hacienda();
    dto=modelo.buscarHacienda(new Hacienda(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Hacienda());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Hacienda());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Hacienda());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Hacienda());
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
    	if(cmbox.getName().contains("cmbDtoZona")){
    		ComboBoxSelect cmbselect = new ComboBoxSelect();
    		vistaHacienda vista = (vistaHacienda)this.getSession().getVista();
    		cmbselect.LlenarSubZona(vista.getCmbdtozona(), vista.getCmbdtosubzona());
    	}
    }
  }
  @Override
  public void mouseClicked(MouseEvent e) {
  	if (e.getClickCount() == 2) {
          JTable target = (JTable)e.getSource();
          int row = target.getSelectedRow();
          this.getSession().setDtoActual(row,new Hacienda());
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

