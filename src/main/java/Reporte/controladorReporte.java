package Reporte;

import java.util.Date;
import java.util.List;

import SwingBernate.ControladorBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
public class controladorReporte extends ControladorBase implements ActionListener, MouseListener {
  public controladorReporte(){
    vistaReporte vista=new vistaReporte(this);
    Reporte dto=new Reporte();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaReporte vista;
    Reporte dto=new Reporte();
    modeloReporte modReporte=new modeloReporte();
    this.getSession().setListaDto(modReporte.buscar(dto));
    this.getSession().setDtoActual(0,dto);
    this.cargarGrid();
  }
  public void nuevo(){
    vistaReporte vista=new vistaReporte(this);
    vista=(vistaReporte)this.getSession().getVista();
    vista.setDto(new Reporte());
  }
  public void grabar(){
    vistaReporte vista=new vistaReporte(this);
    vista=(vistaReporte)this.getSession().getVista();
    Reporte dto=new Reporte();
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
      modeloReporte modelo=new modeloReporte();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaReporte vista=new vistaReporte(this);
    vista=(vistaReporte)this.getSession().getVista();
    modeloReporte modelo=new modeloReporte();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaReporte vista=new vistaReporte(this);
    vista=(vistaReporte)this.getSession().getVista();
    modeloReporte modelo=new modeloReporte();
    Reporte dto=new Reporte();
    dto=modelo.buscarReporte(new Reporte(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Reporte());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Reporte());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Reporte());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Reporte());
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
    if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista();
  }
  
  public void mouseClicked(  MouseEvent e){
	    if (e.getClickCount() == 2) {
	      JTable target=(JTable)e.getSource();
	      int row=target.getSelectedRow();
	      this.getSession().setDtoActual(row,new Reporte());
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

