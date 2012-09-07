package Vehiculo;

import java.util.Date;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import Nucleo.modeloNucleo;

public class controladorVehiculo extends ControladorBase implements ActionListener, MouseListener {
  public controladorVehiculo(){
    vistaVehiculo vista=new vistaVehiculo(this);
    Vehiculo dto=new Vehiculo();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaVehiculo vista=(vistaVehiculo)this.getSession().getVista();
    Vehiculo dto=new Vehiculo();
    modeloVehiculo modVehiculo=new modeloVehiculo();
    this.getSession().setListaDto(modVehiculo.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Vehiculo").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloNucleo modeloNucleo=new modeloNucleo();
    javax.swing.DefaultComboBoxModel modeloComboNucleo=new javax.swing.DefaultComboBoxModel(modeloNucleo.buscarNucleos());
    vista.getCmbdtonucleo().setModelo(modeloComboNucleo);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaVehiculo vista=new vistaVehiculo(this);
    vista=(vistaVehiculo)this.getSession().getVista();
    vista.setDto(new Vehiculo());
  }
  public void grabar(){
    vistaVehiculo vista=new vistaVehiculo(this);
    vista=(vistaVehiculo)this.getSession().getVista();
    Vehiculo dto=new Vehiculo();
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
    
    vista.limpiarError();
    
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty() && dto.getFlocapacidad()>0) {
      modeloVehiculo modelo=new modeloVehiculo();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaVehiculo vista=new vistaVehiculo(this);
    vista=(vistaVehiculo)this.getSession().getVista();
    modeloVehiculo modelo=new modeloVehiculo();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaVehiculo vista=new vistaVehiculo(this);
    vista=(vistaVehiculo)this.getSession().getVista();
    modeloVehiculo modelo=new modeloVehiculo();
    Vehiculo dto=new Vehiculo();
    dto=modelo.buscarVehiculo(new Vehiculo(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Vehiculo());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Vehiculo());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Vehiculo());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Vehiculo());
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
  }
  @Override
  public void mouseClicked(MouseEvent e) {
  	if (e.getClickCount() == 2) {
          JTable target = (JTable)e.getSource();
          int row = target.getSelectedRow();
          this.getSession().setDtoActual(row,new Vehiculo());
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

