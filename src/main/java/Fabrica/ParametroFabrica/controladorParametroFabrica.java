package Fabrica.ParametroFabrica;
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
import UnidadDeMedida.UnidadDeMedida;
import UnidadDeMedida.modeloUnidadDeMedida;
//import Formula.Formula;
//import Formula.modeloFormula;
public class controladorParametroFabrica extends ControladorBase implements ActionListener, MouseListener {
  public controladorParametroFabrica(){
    vistaParametroFabrica vista=new vistaParametroFabrica(this);
    ParametroFabrica dto=new ParametroFabrica();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    if (this.getSession().getListaDto().size()==0){
    	vista.getCentro2().setVisible(false);
    	vista.getCentro().setVisible(true);
    }
    this.getSession().getVista().getSimpleGrid().addMouseListener((MouseListener) this);
  }
  public void actualizarVista(){
    vistaParametroFabrica vista=(vistaParametroFabrica)this.getSession().getVista();
    ParametroFabrica dto=new ParametroFabrica();
    modeloParametroFabrica modParametroFabrica=new modeloParametroFabrica();
    this.getSession().setListaDto(modParametroFabrica.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","ParametroFabrica").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
    vista.getCmbdto_org().setModel(modeloComboOrganizacion);
    modeloUnidadDeMedida modeloUnidadDeMedida=new modeloUnidadDeMedida();
    javax.swing.DefaultComboBoxModel modeloComboUnidadDeMedida=new javax.swing.DefaultComboBoxModel(modeloUnidadDeMedida.buscarUnidadDeMedidas());
    vista.getCmbdto_unidad_medida().setModel(modeloComboUnidadDeMedida);
    //modeloFormula modeloFormula=new modeloFormula();
    //javax.swing.DefaultComboBoxModel modeloComboFormula=new javax.swing.DefaultComboBoxModel(modeloFormula.buscarFormulas());
    //vista.getCmbdto_formula().setModel(modeloComboFormula);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaParametroFabrica vista=new vistaParametroFabrica(this);
    vista=(vistaParametroFabrica)this.getSession().getVista();
    vista.setDto(new ParametroFabrica());
  }
  public void grabar(){
    vistaParametroFabrica vista=new vistaParametroFabrica(this);
    vista=(vistaParametroFabrica)this.getSession().getVista();
    ParametroFabrica dto=new ParametroFabrica();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloParametroFabrica modelo=new modeloParametroFabrica();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifique los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaParametroFabrica vista=new vistaParametroFabrica(this);
    vista=(vistaParametroFabrica)this.getSession().getVista();
    modeloParametroFabrica modelo=new modeloParametroFabrica();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaParametroFabrica vista=new vistaParametroFabrica(this);
    vista=(vistaParametroFabrica)this.getSession().getVista();
    modeloParametroFabrica modelo=new modeloParametroFabrica();
    ParametroFabrica dto=new ParametroFabrica();
    dto=modelo.buscarParametroFabrica(new ParametroFabrica(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new ParametroFabrica());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new ParametroFabrica());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new ParametroFabrica());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new ParametroFabrica());
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
      this.getSession().setDtoActual(row,new ParametroFabrica());
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

