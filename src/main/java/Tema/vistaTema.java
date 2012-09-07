package Tema;
import java.util.*;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaTema extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField();
  JLabel lblstrnombre=new JLabel("Strnombre: ");
  JTextField txtstrnombre=new JTextField();
  JLabel lblstrprimario1=new JLabel("Strprimario1: ");
  JTextField txtstrprimario1=new JTextField();
  JLabel lblstrprimario2=new JLabel("Strprimario2: ");
  JTextField txtstrprimario2=new JTextField();
  JLabel lblstrprimario3=new JLabel("Strprimario3: ");
  JTextField txtstrprimario3=new JTextField();
  JLabel lblstrsecundario1=new JLabel("Strsecundario1: ");
  JTextField txtstrsecundario1=new JTextField();
  JLabel lblstrsecundario2=new JLabel("Strsecundario2: ");
  JTextField txtstrsecundario2=new JTextField();
  JLabel lblstrsecundario3=new JLabel("Strsecundario3: ");
  JTextField txtstrsecundario3=new JTextField();
  JLabel lblstrblanco=new JLabel("Strblanco: ");
  JTextField txtstrblanco=new JTextField();
  JLabel lblstrnegro=new JLabel("Strnegro: ");
  JTextField txtstrnegro=new JTextField();
  JLabel lbllngmenuopacidad=new JLabel("Lngmenuopacidad: ");
  JTextField txtlngmenuopacidad=new JTextField();
  JLabel lbllngframeopacidad=new JLabel("Lngframeopacidad: ");
  JTextField txtlngframeopacidad=new JTextField();
  JLabel lblbolactivo=new JLabel("Activo: ");
  JCheckBox chkbolactivo=new JCheckBox();
  
  JTextField txtstrip_creacion=new JTextField();
  JTextField txtstrip_modificacion=new JTextField();
  JTextField txtstrhost_creacion=new JTextField();
  JTextField txtstrhost_modificacion=new JTextField();
  JDateChooser  dchdtmfecha_creacion   = new JDateChooser();
  JDateChooser  dchdtmfecha_modificacion   = new JDateChooser();
  JDateChooser  dchdtmvalido_desde   = new JDateChooser();
  JDateChooser  dchdtmvalido_hasta   = new JDateChooser();
  JTextField txtlngseg_usuario_creacion=new JTextField(2);
  JTextField txtlngseg_usuario_modificacion=new JTextField(2);
  
  public vistaTema(  ActionListener controlador){
    this.setTitle("Tema");
    this.setSize(500, 500);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 100px,wrap 1");
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","width 100px,wrap 1");
    this.txtstrprimario1.addActionListener(controlador);
    this.agregar(lblstrprimario1,txtstrprimario1,"","width 100px,wrap 1");
    this.txtstrprimario2.addActionListener(controlador);
    this.agregar(lblstrprimario2,txtstrprimario2,"","width 100px,wrap 1");
    this.txtstrprimario3.addActionListener(controlador);
    this.agregar(lblstrprimario3,txtstrprimario3,"","width 100px,wrap 1");
    this.txtstrsecundario1.addActionListener(controlador);
    this.agregar(lblstrsecundario1,txtstrsecundario1,"","width 100px,wrap 1");
    this.txtstrsecundario2.addActionListener(controlador);
    this.agregar(lblstrsecundario2,txtstrsecundario2,"","width 100px,wrap 1");
    this.txtstrsecundario3.addActionListener(controlador);
    this.agregar(lblstrsecundario3,txtstrsecundario3,"","width 100px,wrap 1");
    this.txtstrblanco.addActionListener(controlador);
    this.agregar(lblstrblanco,txtstrblanco,"","width 100px,wrap 1");
    this.txtstrnegro.addActionListener(controlador);
    this.agregar(lblstrnegro,txtstrnegro,"","width 100px,wrap 1");
    this.txtlngmenuopacidad.addActionListener(controlador);
    this.agregar(lbllngmenuopacidad,txtlngmenuopacidad,"","width 100px,wrap 1");
    this.txtlngframeopacidad.addActionListener(controlador);
    this.agregar(lbllngframeopacidad,txtlngframeopacidad,"","width 100px,wrap 1");
    
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
  public JLabel getLblstrprimario1(){
    return lblstrprimario1;
  }
  public void setLblstrprimario1(  JLabel param){
    this.lblstrprimario1=param;
  }
  public JTextField getTxtstrprimario1(){
    return txtstrprimario1;
  }
  public void setTxtstrprimario1(  JTextField param){
    this.txtstrprimario1=param;
  }
  public JLabel getLblstrprimario2(){
    return lblstrprimario2;
  }
  public void setLblstrprimario2(  JLabel param){
    this.lblstrprimario2=param;
  }
  public JTextField getTxtstrprimario2(){
    return txtstrprimario2;
  }
  public void setTxtstrprimario2(  JTextField param){
    this.txtstrprimario2=param;
  }
  public JLabel getLblstrprimario3(){
    return lblstrprimario3;
  }
  public void setLblstrprimario3(  JLabel param){
    this.lblstrprimario3=param;
  }
  public JTextField getTxtstrprimario3(){
    return txtstrprimario3;
  }
  public void setTxtstrprimario3(  JTextField param){
    this.txtstrprimario3=param;
  }
  public JLabel getLblstrsecundario1(){
    return lblstrsecundario1;
  }
  public void setLblstrsecundario1(  JLabel param){
    this.lblstrsecundario1=param;
  }
  public JTextField getTxtstrsecundario1(){
    return txtstrsecundario1;
  }
  public void setTxtstrsecundario1(  JTextField param){
    this.txtstrsecundario1=param;
  }
  public JLabel getLblstrsecundario2(){
    return lblstrsecundario2;
  }
  public void setLblstrsecundario2(  JLabel param){
    this.lblstrsecundario2=param;
  }
  public JTextField getTxtstrsecundario2(){
    return txtstrsecundario2;
  }
  public void setTxtstrsecundario2(  JTextField param){
    this.txtstrsecundario2=param;
  }
  public JLabel getLblstrsecundario3(){
    return lblstrsecundario3;
  }
  public void setLblstrsecundario3(  JLabel param){
    this.lblstrsecundario3=param;
  }
  public JTextField getTxtstrsecundario3(){
    return txtstrsecundario3;
  }
  public void setTxtstrsecundario3(  JTextField param){
    this.txtstrsecundario3=param;
  }
  public JLabel getLblstrblanco(){
    return lblstrblanco;
  }
  public void setLblstrblanco(  JLabel param){
    this.lblstrblanco=param;
  }
  public JTextField getTxtstrblanco(){
    return txtstrblanco;
  }
  public void setTxtstrblanco(  JTextField param){
    this.txtstrblanco=param;
  }
  public JLabel getLblstrnegro(){
    return lblstrnegro;
  }
  public void setLblstrnegro(  JLabel param){
    this.lblstrnegro=param;
  }
  public JTextField getTxtstrnegro(){
    return txtstrnegro;
  }
  public void setTxtstrnegro(  JTextField param){
    this.txtstrnegro=param;
  }
  public JLabel getLbllngmenuopacidad(){
    return lbllngmenuopacidad;
  }
  public void setLbllngmenuopacidad(  JLabel param){
    this.lbllngmenuopacidad=param;
  }
  public JTextField getTxtlngmenuopacidad(){
    return txtlngmenuopacidad;
  }
  public void setTxtlngmenuopacidad(  JTextField param){
    this.txtlngmenuopacidad=param;
  }
  public JLabel getLbllngframeopacidad(){
    return lbllngframeopacidad;
  }
  public void setLbllngframeopacidad(  JLabel param){
    this.lbllngframeopacidad=param;
  }
  public JTextField getTxtlngframeopacidad(){
    return txtlngframeopacidad;
  }
  public void setTxtlngframeopacidad(  JTextField param){
    this.txtlngframeopacidad=param;
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
public JDateChooser getDchdtmvalido_desde() {
	return dchdtmvalido_desde;
}
public void setDchdtmvalido_desde(JDateChooser dchdtmvalidoDesde) {
	dchdtmvalido_desde = dchdtmvalidoDesde;
}
public JDateChooser getDchdtmvalido_hasta() {
	return dchdtmvalido_hasta;
}
public void setDchdtmvalido_hasta(JDateChooser dchdtmvalidoHasta) {
	dchdtmvalido_hasta = dchdtmvalidoHasta;
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
}

