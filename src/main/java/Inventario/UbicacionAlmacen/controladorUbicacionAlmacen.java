package Inventario.UbicacionAlmacen;
import java.util.ArrayList;
import java.util.List;

import Reporte.Reporte;
import Reporte.modeloReporte;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import SwingBernate.ControladorBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import Organizacion.Organizacion;
import Organizacion.modeloOrganizacion;
import Inventario.Almacen.Almacen;
import Inventario.Almacen.modeloAlmacen;

public class controladorUbicacionAlmacen extends ControladorBase implements ActionListener, MouseListener {
  public controladorUbicacionAlmacen(){
    vistaUbicacionAlmacen vista=new vistaUbicacionAlmacen(this);
    UbicacionAlmacen dto=new UbicacionAlmacen();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    if (this.getSession().getListaDto().size()==0){
    	vista.getCentro2().setVisible(false);
    	vista.getCentro().setVisible(true);
    }
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaUbicacionAlmacen vista=(vistaUbicacionAlmacen)this.getSession().getVista();
    UbicacionAlmacen dto=new UbicacionAlmacen();
    modeloUbicacionAlmacen modUbicacionAlmacen=new modeloUbicacionAlmacen();
    this.getSession().setListaDto(modUbicacionAlmacen.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","UbicacionAlmacen").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
    vista.getCmbdto_org().setModel(modeloComboOrganizacion);
    modeloAlmacen modeloAlmacen=new modeloAlmacen();
    javax.swing.DefaultComboBoxModel modeloComboAlmacen=new javax.swing.DefaultComboBoxModel(modeloAlmacen.buscarAlmacens());
    vista.getCmbdto_almacen().setModel(modeloComboAlmacen);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaUbicacionAlmacen vista=new vistaUbicacionAlmacen(this);
    vista=(vistaUbicacionAlmacen)this.getSession().getVista();
    vista.setDto(new UbicacionAlmacen());
  }
  public void grabar(){
    vistaUbicacionAlmacen vista=new vistaUbicacionAlmacen(this);
    vista=(vistaUbicacionAlmacen)this.getSession().getVista();
    UbicacionAlmacen dto=new UbicacionAlmacen();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloUbicacionAlmacen modelo=new modeloUbicacionAlmacen();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaUbicacionAlmacen vista=new vistaUbicacionAlmacen(this);
    vista=(vistaUbicacionAlmacen)this.getSession().getVista();
    modeloUbicacionAlmacen modelo=new modeloUbicacionAlmacen();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaUbicacionAlmacen vista=new vistaUbicacionAlmacen(this);
    vista=(vistaUbicacionAlmacen)this.getSession().getVista();
    modeloUbicacionAlmacen modelo=new modeloUbicacionAlmacen();
    UbicacionAlmacen dto=new UbicacionAlmacen();
    dto=modelo.buscarUbicacionAlmacen(new UbicacionAlmacen(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new UbicacionAlmacen());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new UbicacionAlmacen());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new UbicacionAlmacen());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new UbicacionAlmacen());
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
      this.getSession().setDtoActual(row,new UbicacionAlmacen());
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

