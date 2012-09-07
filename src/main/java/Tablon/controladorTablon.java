package Tablon;

import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ControladorBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import Hacienda.modeloHacienda;

public class controladorTablon extends ControladorBase implements ActionListener, MouseListener {
  public controladorTablon(){
    vistaTablon vista=new vistaTablon(this);
    Tablon dto=new Tablon();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaTablon vista=(vistaTablon)this.getSession().getVista();
    Tablon dto=new Tablon();
    modeloTablon modTablon=new modeloTablon();
    this.getSession().setListaDto(modTablon.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Tablon").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloHacienda modeloHacienda=new modeloHacienda();
    javax.swing.DefaultComboBoxModel modeloComboHacienda=new javax.swing.DefaultComboBoxModel(modeloHacienda.buscarHaciendas());
    vista.getCmbdtohacienda().setModel(modeloComboHacienda);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaTablon vista=new vistaTablon(this);
    vista=(vistaTablon)this.getSession().getVista();
    vista.setDto(new Tablon());
  }
  public void grabar(){
    vistaTablon vista=new vistaTablon(this);
    vista=(vistaTablon)this.getSession().getVista();
    Tablon dto=new Tablon();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloTablon modelo=new modeloTablon();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaTablon vista=new vistaTablon(this);
    vista=(vistaTablon)this.getSession().getVista();
    modeloTablon modelo=new modeloTablon();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaTablon vista=new vistaTablon(this);
    vista=(vistaTablon)this.getSession().getVista();
    modeloTablon modelo=new modeloTablon();
    Tablon dto=new Tablon();
    dto=modelo.buscarTablon(new Tablon(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Tablon());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Tablon());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Tablon());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Tablon());
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
          this.getSession().setDtoActual(row,new Tablon());
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

