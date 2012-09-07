package Municipio;
import java.util.*;

import Estado.Estado;
import Parroquia.Parroquia;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import SwingBernate.ayudantes.ListaDoble;
public class vistaMunicipio extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldtoestado=new JLabel("Estado: ");
  ComboBox cmbdtoestado=new ComboBox(new Estado());
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField(40);
  JLabel lblstrsigla=new JLabel("Siglas: ");
  JTextField txtstrsigla=new JTextField(10);
  JLabel lblparroquias=new JLabel("Parroquias: ");
  JLabel lblbolactivo=new JLabel("Activo: ");
  JCheckBox chkbolactivo=new JCheckBox();
  
  JTextField txtstrip_creacion=new JTextField();
  JTextField txtstrip_modificacion=new JTextField();
  JTextField txtstrhost_creacion=new JTextField();
  JTextField txtstrhost_modificacion=new JTextField();
  JDateChooser  dchdtmfecha_creacion   = new JDateChooser();
  JDateChooser  dchdtmfecha_modificacion   = new JDateChooser();
  JTextField txtlngseg_usuario_creacion=new JTextField(2);
  JTextField txtlngseg_usuario_modificacion=new JTextField(2);
  
  ListaDoble lstparroquias=new ListaDoble("Parroquias",new Parroquia());
  public vistaMunicipio(  ActionListener controlador){
    this.setTitle("Municipios");
    
    this.txtlngid.setName("txtlngid");
	this.txtlngid.addKeyListener((KeyListener) controlador);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
    
    this.cmbdtoestado.addActionListener(controlador);
    this.agregar(lbldtoestado,cmbdtoestado,"","width 250px,wrap 1");
    
    this.txtstrnombre.setName("txtstrnombre");
	this.txtstrnombre.addKeyListener((KeyListener) controlador);
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","width 180px,wrap 1");
    
    this.txtstrsigla.setName("txtstrsigla");
	this.txtstrsigla.addKeyListener((KeyListener) controlador);
    this.txtstrsigla.addActionListener(controlador);
    this.agregar(lblstrsigla,txtstrsigla,"","width 150px,wrap 1");
    
    this.agregar(lblparroquias,lstparroquias,"","width 250px,wrap 1");
    
    this.chkbolactivo.setName("chkbolactivo");
    this.chkbolactivo.addActionListener(controlador);
    this.agregar(lblbolactivo,chkbolactivo,"","width 50px,wrap 1");
    this.getButtonNuevo().addActionListener(controlador);
    this.getButtonBuscar().addActionListener(controlador);
    this.getButtonEliminar().addActionListener(controlador);
    this.getImprimir().addActionListener(controlador);
    this.getButtonGuardar().addActionListener(controlador);
    this.getButtonCancelar().addActionListener(controlador);
    this.getButtonSiguiente().addActionListener(controlador);
    this.getButtonAnterior().addActionListener(controlador);
    this.getButtonPrimero().addActionListener(controlador);
    this.getButtonUltimo().addActionListener(controlador);
    this.getButtonRefrescar().addActionListener(controlador);
    this.getMenuItemNuevo().addActionListener(controlador);
    this.getMenuItemBuscar().addActionListener(controlador);
    this.getMenuItemEliminar().addActionListener(controlador);
    this.getMenuItemGuardar().addActionListener(controlador);
    this.getMenuItemSalir().addActionListener(controlador);
    this.getButtonVistaR().addActionListener(controlador);
    this.setSize(550, 550);
  }
  public JLabel getLbllngid(){
    return lbllngid;
  }
  public void setLbllngid(  JLabel param){
    this.lbllngid=param;
  }
  public JTextField getTxtlngid(){
    return txtlngid;
  }
  public void setTxtlngid(  JTextField param){
    this.txtlngid=param;
  }
  public JLabel getLbldtoestado(){
    return lbldtoestado;
  }
  public void setLbldtoestado(  JLabel param){
    this.lbldtoestado=param;
  }
  public ComboBox getCmbdtoestado(){
    return cmbdtoestado;
  }
  public void setCmbdtoestado(  ComboBox param){
    this.cmbdtoestado=param;
  }
  public JLabel getLblstrnombre(){
    return lblstrnombre;
  }
  public void setLblstrnombre(  JLabel param){
    this.lblstrnombre=param;
  }
  public JTextField getTxtstrnombre(){
    return txtstrnombre;
  }
  public void setTxtstrnombre(  JTextField param){
    this.txtstrnombre=param;
  }
  public JLabel getLblstrsigla(){
    return lblstrsigla;
  }
  public void setLblstrsigla(  JLabel param){
    this.lblstrsigla=param;
  }
  public JTextField getTxtstrsigla(){
    return txtstrsigla;
  }
  public void setTxtstrsigla(  JTextField param){
    this.txtstrsigla=param;
  }
  public JLabel getLblparroquias(){
    return lblparroquias;
  }
  public void setLblparroquias(  JLabel param){
    this.lblparroquias=param;
  }
  public ListaDoble getLstparroquias(){
    return lstparroquias;
  }
  public void setLstparroquias(  ListaDoble param){
    this.lstparroquias=param;
  }
public JTextField getTxtstrip_creacion() {
	return txtstrip_creacion;
}
public void setTxtstrip_creacion(JTextField txtstripCreacion) {
	txtstrip_creacion = txtstripCreacion;
}
public JTextField getTxtstrip_modificacion() {
	return txtstrip_modificacion;
}
public void setTxtstrip_modificacion(JTextField txtstripModificacion) {
	txtstrip_modificacion = txtstripModificacion;
}
public JTextField getTxtstrhost_creacion() {
	return txtstrhost_creacion;
}
public void setTxtstrhost_creacion(JTextField txtstrhostCreacion) {
	txtstrhost_creacion = txtstrhostCreacion;
}
public JTextField getTxtstrhost_modificacion() {
	return txtstrhost_modificacion;
}
public void setTxtstrhost_modificacion(JTextField txtstrhostModificacion) {
	txtstrhost_modificacion = txtstrhostModificacion;
}
public JDateChooser getDchdtmfecha_creacion() {
	return dchdtmfecha_creacion;
}
public void setDchdtmfecha_creacion(JDateChooser dchdtmfechaCreacion) {
	dchdtmfecha_creacion = dchdtmfechaCreacion;
}
public JDateChooser getDchdtmfecha_modificacion() {
	return dchdtmfecha_modificacion;
}
public void setDchdtmfecha_modificacion(JDateChooser dchdtmfechaModificacion) {
	dchdtmfecha_modificacion = dchdtmfechaModificacion;
}
public JTextField getTxtlngseg_usuario_creacion() {
	return txtlngseg_usuario_creacion;
}
public void setTxtlngseg_usuario_creacion(JTextField txtlngsegUsuarioCreacion) {
	txtlngseg_usuario_creacion = txtlngsegUsuarioCreacion;
}
public JTextField getTxtlngseg_usuario_modificacion() {
	return txtlngseg_usuario_modificacion;
}
public void setTxtlngseg_usuario_modificacion(
		JTextField txtlngsegUsuarioModificacion) {
	txtlngseg_usuario_modificacion = txtlngsegUsuarioModificacion;
}
public JLabel getLblbolactivo() {
	return lblbolactivo;
}
public void setLblbolactivo(JLabel lblbolactivo) {
	this.lblbolactivo = lblbolactivo;
}
public JCheckBox getChkbolactivo() {
	return chkbolactivo;
}
public void setChkbolactivo(JCheckBox chkbolactivo) {
	this.chkbolactivo = chkbolactivo;
}
}

