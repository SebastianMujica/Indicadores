package Productor;
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

import SocioDeNegocio.SocioDeNegocio;
import SocioDeNegocio.modeloSocioDeNegocio;
import Hacienda.modeloHacienda;
public class controladorProductor extends ControladorBase implements ActionListener, MouseListener {
  public controladorProductor(){
    vistaProductor vista=new vistaProductor(this);
    Productor dto=new Productor();
    this.iniciarSesion(vista,dto);
    this.actualizarVista();
    this.getSession().getVista().getSimpleGrid().addMouseListener(this);
  }
  public void actualizarVista(){
    vistaProductor vista=(vistaProductor)this.getSession().getVista();
    Productor dto=new Productor();
    modeloProductor modProductor=new modeloProductor();
    this.getSession().setListaDto(modProductor.buscar(dto));
    modeloReporte modeloReporte=new modeloReporte();
    javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Productor").toArray());
    vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    modeloSocioDeNegocio modeloSocioDeNegocio=new modeloSocioDeNegocio();
    javax.swing.DefaultComboBoxModel modeloComboSocioDeNegocio=new javax.swing.DefaultComboBoxModel(modeloSocioDeNegocio.buscarSocioDeNegocios());
    vista.getCmbdtosocio().setModel(modeloComboSocioDeNegocio);
    modeloHacienda modeloHacienda=new modeloHacienda();
    vista.getLsthaciendas().setModelDes(modeloHacienda.buscarHaciendas());
    this.getSession().setDtoActual(0,dto);
    
    this.cargarGrid();
  }
  public void nuevo(){
    vistaProductor vista=new vistaProductor(this);
    vista=(vistaProductor)this.getSession().getVista();
    vista.setDto(new Productor());
  }
  public void grabar(){
    vistaProductor vista=new vistaProductor(this);
    vista=(vistaProductor)this.getSession().getVista();
    Productor dto=new Productor();
    dto.setHash(vista.getDto(dto));
    List<String> lsError=this.testValidacion(dto);
    if (lsError.isEmpty()) {
      modeloProductor modelo=new modeloProductor();
      modelo.grabar(dto);
    }
 else {
      vista.mensageDialogo("error","Por favor verifíque los datos. Debe ingresarlos correctamente!","Error en datos");
      vista.marcarError(lsError);
    }
  }
  public void eliminar(){
    vistaProductor vista=new vistaProductor(this);
    vista=(vistaProductor)this.getSession().getVista();
    modeloProductor modelo=new modeloProductor();
    if (vista.mensageDialogo("confirmar","¿Desea eliminar este Registro?","Confirmar Eliminación") == 0) {
      modelo.eliminar(vista.getTxtlngid().getText());
    }
  }
  public void buscar(){
    vistaProductor vista=new vistaProductor(this);
    vista=(vistaProductor)this.getSession().getVista();
    modeloProductor modelo=new modeloProductor();
    Productor dto=new Productor();
    dto=modelo.buscarProductor(new Productor(),"lngid",vista.getTxtlngid().getText());
    vista.setDto(dto);
  }
  public void siguiente(){
    this.getSession().setDtoActual(this.getSession().getActual() + 1,new Productor());
  }
  public void anterior(){
    this.getSession().setDtoActual(this.getSession().getActual() - 1,new Productor());
  }
  public void primero(){
    this.getSession().setDtoActual(0,new Productor());
  }
  public void ultimo(){
    this.getSession().setDtoActual(this.getSession().getListaDto().size() - 1,new Productor());
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
        this.getSession().setDtoActual(row,new Productor());
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

