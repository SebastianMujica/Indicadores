package RegistroVariable;
import java.util.ArrayList;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import SwingBernate.ControladorBase;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
public class controladorRegistroVariable extends ControladorBase implements ActionListener, MouseListener {
  public controladorRegistroVariable(){
    vistaRegistroVariable vista=new vistaRegistroVariable(this);
    RegistroVariable dto=new RegistroVariable();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaRegistroVariable vista=(vistaRegistroVariable)this.getSession().getVista();
    RegistroVariable dto=new RegistroVariable();
    modeloRegistroVariable modRegistroVariable=new modeloRegistroVariable();
    this.getSession().setListaDto(modRegistroVariable.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","RegistroVariable").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaRegistroVariable vista=new vistaRegistroVariable(this);
    vista=(vistaRegistroVariable)this.getSession().getVista();
    vista.setDto(new RegistroVariable());
  }
  public void grabar(){
    vistaRegistroVariable vista=new vistaRegistroVariable(this);
    vista=(vistaRegistroVariable)this.getSession().getVista();
    RegistroVariable dto=new RegistroVariable();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloRegistroVariable modelo=new modeloRegistroVariable();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaRegistroVariable vista=new vistaRegistroVariable(this);
    vista=(vistaRegistroVariable)this.getSession().getVista();
    modeloRegistroVariable modelo=new modeloRegistroVariable();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaRegistroVariable vista=new vistaRegistroVariable(this);
    vista=(vistaRegistroVariable)this.getSession().getVista();
    modeloRegistroVariable modelo=new modeloRegistroVariable();
    RegistroVariable dto=new RegistroVariable();
    dto=modelo.buscarRegistroVariable(new RegistroVariable(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new RegistroVariable());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new RegistroVariable());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new RegistroVariable());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new RegistroVariable());
  }
  public void actionPerformed(  ActionEvent ae){
    if ("nuevo".equals(ae.getActionCommand()))     this.nuevo();
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
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista();
  }
  public void mouseClicked(  MouseEvent e){
    if (e.getClickCount() == 2) {
      JTable target=(JTable)e.getSource();
      int row=target.getSelectedRow();
      this.getSession().setDtoActual(row,new RegistroVariable());
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

