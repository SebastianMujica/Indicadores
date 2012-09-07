package Telefono;

import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

public class controladorTelefono extends ControladorBase implements ActionListener, MouseListener {
  public controladorTelefono(){
    vistaTelefono vista=new vistaTelefono(this);
    Telefono dto=new Telefono();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaTelefono vista=(vistaTelefono)this.getSession().getVista();
    Telefono dto=new Telefono();
    modeloTelefono modTelefono=new modeloTelefono();
    this.getSession().setListaDto(modTelefono.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Telefono").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaTelefono vista=new vistaTelefono(this);
    vista=(vistaTelefono)this.getSession().getVista();
    vista.setDto(new Telefono());
  }
  public void grabar(){
    vistaTelefono vista=new vistaTelefono(this);
    vista=(vistaTelefono)this.getSession().getVista();
    Telefono dto=new Telefono();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloTelefono modelo=new modeloTelefono();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaTelefono vista=new vistaTelefono(this);
    vista=(vistaTelefono)this.getSession().getVista();
    modeloTelefono modelo=new modeloTelefono();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaTelefono vista=new vistaTelefono(this);
    vista=(vistaTelefono)this.getSession().getVista();
    modeloTelefono modelo=new modeloTelefono();
    Telefono dto=new Telefono();
    dto=modelo.buscarTelefono(new Telefono(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Telefono());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Telefono());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Telefono());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Telefono());
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
          this.getSession().setDtoActual(row,new Telefono());
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

