package Recepcion;
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

import Productor.Productor;
import Productor.modeloProductor;
import Hacienda.Hacienda;
import Hacienda.modeloHacienda;
import Tablon.Tablon;
import Tablon.modeloTablon;
import OrdenDeArrime.OrdenDeArrime;
import OrdenDeArrime.modeloOrdenDeArrime;
import Nucleo.Nucleo;
import Nucleo.modeloNucleo;
import Tecnico.Tecnico;
import Tecnico.modeloTecnico;
import Vehiculo.Vehiculo;
import Vehiculo.modeloVehiculo;
public class controladorRecepcion extends ControladorBase implements ActionListener, MouseListener {
  public controladorRecepcion(){
    vistaRecepcion vista=new vistaRecepcion(this);
    Recepcion dto=new Recepcion();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaRecepcion vista=(vistaRecepcion)this.getSession().getVista();
    Recepcion dto=new Recepcion();
    modeloRecepcion modRecepcion=new modeloRecepcion();
    this.getSession().setListaDto(modRecepcion.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Recepcion").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloProductor modeloProductor=new modeloProductor();
    javax.swing.DefaultComboBoxModel modeloComboProductor=new javax.swing.DefaultComboBoxModel(modeloProductor.buscarProductors());
    vista.getCmbdtoproductor().setModel(modeloComboProductor);
    modeloHacienda modeloHacienda=new modeloHacienda();
    javax.swing.DefaultComboBoxModel modeloComboHacienda=new javax.swing.DefaultComboBoxModel(modeloHacienda.buscarHaciendas());
    vista.getCmbdtohacienda().setModel(modeloComboHacienda);
    modeloTablon modeloTablon=new modeloTablon();
    javax.swing.DefaultComboBoxModel modeloComboTablon=new javax.swing.DefaultComboBoxModel(modeloTablon.buscarTablons());
    vista.getCmbdtotablon().setModel(modeloComboTablon);
    modeloOrdenDeArrime modeloOrdenDeArrime=new modeloOrdenDeArrime();
    javax.swing.DefaultComboBoxModel modeloComboOrdenDeArrime=new javax.swing.DefaultComboBoxModel(modeloOrdenDeArrime.buscarOrdenDeArrimes());
    vista.getCmbdtoordendearrime().setModel(modeloComboOrdenDeArrime);
    modeloNucleo modeloNucleo=new modeloNucleo();
    javax.swing.DefaultComboBoxModel modeloComboNucleo=new javax.swing.DefaultComboBoxModel(modeloNucleo.buscarNucleos());
    vista.getCmbdtonucleo().setModel(modeloComboNucleo);
    modeloTecnico modeloTecnico=new modeloTecnico();
    javax.swing.DefaultComboBoxModel modeloComboTecnico=new javax.swing.DefaultComboBoxModel(modeloTecnico.buscarTecnicos());
    vista.getCmbdtotecnico().setModel(modeloComboTecnico);
    modeloVehiculo modeloVehiculo=new modeloVehiculo();
    javax.swing.DefaultComboBoxModel modeloComboVehiculo=new javax.swing.DefaultComboBoxModel(modeloVehiculo.buscarVehiculos());
    vista.getCmbdtovehiculo().setModel(modeloComboVehiculo);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaRecepcion vista=new vistaRecepcion(this);
    vista=(vistaRecepcion)this.getSession().getVista();
    vista.setDto(new Recepcion());
  }
  public void grabar(){
    vistaRecepcion vista=new vistaRecepcion(this);
    vista=(vistaRecepcion)this.getSession().getVista();
    Recepcion dto=new Recepcion();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloRecepcion modelo=new modeloRecepcion();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaRecepcion vista=new vistaRecepcion(this);
    vista=(vistaRecepcion)this.getSession().getVista();
    modeloRecepcion modelo=new modeloRecepcion();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaRecepcion vista=new vistaRecepcion(this);
    vista=(vistaRecepcion)this.getSession().getVista();
    modeloRecepcion modelo=new modeloRecepcion();
    Recepcion dto=new Recepcion();
    dto=modelo.buscarRecepcion(new Recepcion(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Recepcion());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Recepcion());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Recepcion());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Recepcion());
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
      this.getSession().setDtoActual(row,new Recepcion());
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

