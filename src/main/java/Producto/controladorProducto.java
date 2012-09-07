package Producto;
import java.util.ArrayList;
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

import UnidadDeMedida.modeloUnidadDeMedida;
import Maestro.modeloMaestro;
import Organizacion.modeloOrganizacion;

public class controladorProducto extends ControladorBase implements ActionListener, MouseListener {
  public controladorProducto(){
    vistaProducto vista=new vistaProducto(this);
    Producto dto=new Producto();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
    if(this.getSession().getListaDto().size()==0){
		vista.getCentro2().setVisible(false);
		vista.getCentro().setVisible(true);
	}
  }
  public void actualizarVista(){
    vistaProducto vista=(vistaProducto)this.getSession().getVista();
    Producto dto=new Producto();
    modeloProducto modProducto=new modeloProducto();
    this.getSession().setListaDto(modProducto.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Producto").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    
    modeloOrganizacion modeloOrganizacion=new modeloOrganizacion();
    javax.swing.DefaultComboBoxModel modeloComboOrganizacion=new javax.swing.DefaultComboBoxModel(modeloOrganizacion.buscarOrganizacions());
    vista.getCmbdtoorganizacion().setModelo(modeloComboOrganizacion);
    
    modeloUnidadDeMedida modeloUnidadDeMedida=new modeloUnidadDeMedida();
    javax.swing.DefaultComboBoxModel modeloComboUnidadDeMedida=new javax.swing.DefaultComboBoxModel(modeloUnidadDeMedida.buscarUnidadDeMedidas());
    vista.getCmbdtounidadmedida().setModelo(modeloComboUnidadDeMedida);
    
    modeloMaestro modeloMaestro=new modeloMaestro();
    javax.swing.DefaultComboBoxModel modeloCombotip_prod=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("TIP_PROD"));
    vista.getCmbdtotipoproducto().setModelo(modeloCombotip_prod);
    javax.swing.DefaultComboBoxModel modeloCombocat_prod=new javax.swing.DefaultComboBoxModel(modeloMaestro.hijosPorMaestro("CAT_PROD"));
    vista.getCmbdtocategoriaproducto().setModelo(modeloCombocat_prod);
    
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaProducto vista=new vistaProducto(this);
    vista=(vistaProducto)this.getSession().getVista();
    vista.setDto(new Producto());
  }
  public void grabar(){
    vistaProducto vista=new vistaProducto(this);
    vista=(vistaProducto)this.getSession().getVista();
    Producto dto=new Producto();
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
      modeloProducto modelo=new modeloProducto();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaProducto vista=new vistaProducto(this);
    vista=(vistaProducto)this.getSession().getVista();
    modeloProducto modelo=new modeloProducto();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaProducto vista=new vistaProducto(this);
    vista=(vistaProducto)this.getSession().getVista();
    modeloProducto modelo=new modeloProducto();
    Producto dto=new Producto();
    dto=modelo.buscarProducto(new Producto(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Producto());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Producto());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Producto());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Producto());
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
      this.getSession().setDtoActual(row,new Producto());
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

