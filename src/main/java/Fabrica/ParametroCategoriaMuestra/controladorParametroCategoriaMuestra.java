package Fabrica.ParametroCategoriaMuestra;
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
import Maestro.Maestro;
import Maestro.modeloMaestro;
import Fabrica.ParametroFabrica.modeloParametroFabrica;
public class controladorParametroCategoriaMuestra extends ControladorBase implements ActionListener, MouseListener {
  public controladorParametroCategoriaMuestra(){
    vistaParametroCategoriaMuestra vista=new vistaParametroCategoriaMuestra(this);
    ParametroCategoriaMuestra dto=new ParametroCategoriaMuestra();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    if (this.getSession().getListaDto().size()==0){
    	vista.getCentro2().setVisible(false);
    	vista.getCentro().setVisible(true);
    }
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaParametroCategoriaMuestra vista=(vistaParametroCategoriaMuestra)this.getSession().getVista();
    ParametroCategoriaMuestra dto=new ParametroCategoriaMuestra();
    modeloParametroCategoriaMuestra modParametroCategoriaMuestra=new modeloParametroCategoriaMuestra();
    this.getSession().setListaDto(modParametroCategoriaMuestra.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","ParametroCategoriaMuestra").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
    vista.getCmbdto_org().setModel(modeloComboOrganizacion);
    modeloMaestro modeloCategoriaMuestra=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloComboCategoriaMuestra=new javax.swing.DefaultComboBoxModel(modeloCategoriaMuestra.buscarMaestros());
    vista.getCmbdto_categoria_muestra().setModel(modeloComboCategoriaMuestra);
    modeloParametroFabrica modeloParametroFabrica=new modeloParametroFabrica();
    vista.getLstdto_parametro_fabrica().setModelDes(modeloParametroFabrica.buscarParametroFabricas());
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaParametroCategoriaMuestra vista=new vistaParametroCategoriaMuestra(this);
    vista=(vistaParametroCategoriaMuestra)this.getSession().getVista();
    vista.setDto(new ParametroCategoriaMuestra());
  }
  public void grabar(){
    vistaParametroCategoriaMuestra vista=new vistaParametroCategoriaMuestra(this);
    vista=(vistaParametroCategoriaMuestra)this.getSession().getVista();
    ParametroCategoriaMuestra dto=new ParametroCategoriaMuestra();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloParametroCategoriaMuestra modelo=new modeloParametroCategoriaMuestra();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifique los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaParametroCategoriaMuestra vista=new vistaParametroCategoriaMuestra(this);
    vista=(vistaParametroCategoriaMuestra)this.getSession().getVista();
    modeloParametroCategoriaMuestra modelo=new modeloParametroCategoriaMuestra();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaParametroCategoriaMuestra vista=new vistaParametroCategoriaMuestra(this);
    vista=(vistaParametroCategoriaMuestra)this.getSession().getVista();
    modeloParametroCategoriaMuestra modelo=new modeloParametroCategoriaMuestra();
    ParametroCategoriaMuestra dto=new ParametroCategoriaMuestra();
    dto=modelo.buscarParametroCategoriaMuestra(new ParametroCategoriaMuestra(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new ParametroCategoriaMuestra());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new ParametroCategoriaMuestra());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new ParametroCategoriaMuestra());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new ParametroCategoriaMuestra());
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
      this.getSession().setDtoActual(row,new ParametroCategoriaMuestra());
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

