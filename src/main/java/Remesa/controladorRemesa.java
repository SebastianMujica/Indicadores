package Remesa;
import java.util.ArrayList;
import java.util.Date;
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

import Nucleo.Nucleo;
import Nucleo.modeloNucleo;
import Productor.Productor;
import Productor.modeloProductor;
import Hacienda.Hacienda;
import Hacienda.modeloHacienda;
import Tablon.Tablon;
import Tablon.modeloTablon;
public class controladorRemesa extends ControladorBase implements ActionListener, MouseListener {
  public controladorRemesa(){
    vistaRemesa vista=new vistaRemesa(this);
    Remesa dto=new Remesa();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaRemesa vista=(vistaRemesa)this.getSession().getVista();
    Remesa dto=new Remesa();
    modeloRemesa modRemesa=new modeloRemesa();
    this.getSession().setListaDto(modRemesa.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Remesa").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloNucleo modeloNucleo=new modeloNucleo();
    javax.swing.DefaultComboBoxModel modeloComboNucleo=new javax.swing.DefaultComboBoxModel(modeloNucleo.buscarNucleos());
    vista.getCmbdtonucleo().setModel(modeloComboNucleo);
    modeloProductor modeloProductor=new modeloProductor();
    javax.swing.DefaultComboBoxModel modeloComboProductor=new javax.swing.DefaultComboBoxModel(modeloProductor.buscarProductors());
    vista.getCmbdtoproductor().setModel(modeloComboProductor);
    modeloHacienda modeloHacienda=new modeloHacienda();
    javax.swing.DefaultComboBoxModel modeloComboHacienda=new javax.swing.DefaultComboBoxModel(modeloHacienda.buscarHaciendas());
    vista.getCmbdtohacienda().setModel(modeloComboHacienda);
    modeloTablon modeloTablon=new modeloTablon();
    javax.swing.DefaultComboBoxModel modeloComboTablon=new javax.swing.DefaultComboBoxModel(modeloTablon.buscarTablons());
    vista.getCmbdtotablon().setModel(modeloComboTablon);
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaRemesa vista=new vistaRemesa(this);
    vista=(vistaRemesa)this.getSession().getVista();
    vista.setDto(new Remesa());
  }
  public void grabar(){
    vistaRemesa vista=new vistaRemesa(this);
    vista=(vistaRemesa)this.getSession().getVista();
    Remesa dto=new Remesa();
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
      modeloRemesa modelo=new modeloRemesa();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaRemesa vista=new vistaRemesa(this);
    vista=(vistaRemesa)this.getSession().getVista();
    modeloRemesa modelo=new modeloRemesa();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaRemesa vista=new vistaRemesa(this);
    vista=(vistaRemesa)this.getSession().getVista();
    modeloRemesa modelo=new modeloRemesa();
    Remesa dto=new Remesa();
    dto=modelo.buscarRemesa(new Remesa(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Remesa());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Remesa());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Remesa());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Remesa());
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
      this.getSession().setDtoActual(row,new Remesa());
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

