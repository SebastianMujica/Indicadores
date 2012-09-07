package Inventario.Almacen;
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
public class controladorAlmacen extends ControladorBase implements ActionListener, MouseListener {
  public controladorAlmacen(){
    vistaAlmacen vista=new vistaAlmacen(this);
    Almacen dto=new Almacen();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    if (this.getSession().getListaDto().size()==0){
    	vista.getCentro2().setVisible(false);
    	vista.getCentro().setVisible(true);
    }
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaAlmacen vista=(vistaAlmacen)this.getSession().getVista();
    Almacen dto=new Almacen();
    modeloAlmacen modAlmacen=new modeloAlmacen();
    this.getSession().setListaDto(modAlmacen.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Almacen").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
    vista.getCmbdto_org().setModel(modeloComboOrganizacion);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaAlmacen vista=new vistaAlmacen(this);
    vista=(vistaAlmacen)this.getSession().getVista();
    vista.setDto(new Almacen());
  }
  public void grabar(){
    vistaAlmacen vista=new vistaAlmacen(this);
    vista=(vistaAlmacen)this.getSession().getVista();
    Almacen dto=new Almacen();
    System.out.println("aquie es la vainawwwwwwwwwwwwwwwwww");
    dto.setHash(vista.getDto(dto));
    System.out.println("//////////////////////////////   "+dto.getClass());
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloAlmacen modelo=new modeloAlmacen();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaAlmacen vista=new vistaAlmacen(this);
    vista=(vistaAlmacen)this.getSession().getVista();
    modeloAlmacen modelo=new modeloAlmacen();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaAlmacen vista=new vistaAlmacen(this);
    vista=(vistaAlmacen)this.getSession().getVista();
    modeloAlmacen modelo=new modeloAlmacen();
    Almacen dto=new Almacen();
    dto=modelo.buscarAlmacen(new Almacen(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Almacen());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Almacen());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Almacen());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Almacen());
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
      this.getSession().setDtoActual(row,new Almacen());
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

