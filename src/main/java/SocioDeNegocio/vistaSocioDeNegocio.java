package SocioDeNegocio;
import java.util.*;


import Maestro.Maestro;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaSocioDeNegocio extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldto_tipo_personalidad=new JLabel("Personalidad Legal: ");
  ComboBox cmbdto_tipo_personalidad=new ComboBox(new Maestro());
  JLabel lbldto_tipo_documento=new JLabel("Tipo Documento: ");
  ComboBox cmbdto_tipo_documento=new ComboBox(new Maestro());
  JLabel lblstrcedularif=new JLabel("Nro. Identificación: ");
  JLabel lbldto_tipo_clasificacion=new JLabel("Clasificación: ");
  ComboBox cmbdto_tipo_clasificacion=new ComboBox(new Maestro());
  JTextField txtstrcedularif=new JTextField(12);
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField(50);
  JLabel lblstrapellido=new JLabel("Apellido: ");
  JTextField txtstrapellido=new JTextField(50);
  JLabel lbldto_genero_persona=new JLabel("Género: ");
  ComboBox cmbdto_genero_persona=new ComboBox(new Maestro());
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
  
  public vistaSocioDeNegocio(  ActionListener controlador){
    this.setTitle("Socio de Negocio");
    this.txtlngid.setName("txtlngid");
    this.txtlngid.addActionListener(controlador);
    this.txtlngid.addKeyListener((KeyListener) controlador);
    this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
    this.cmbdto_tipo_personalidad.addActionListener(controlador);
    this.agregar(lbldto_tipo_personalidad,cmbdto_tipo_personalidad,"","width 250px,wrap 1");
    this.cmbdto_tipo_documento.addActionListener(controlador);
    this.agregar(lbldto_tipo_documento,cmbdto_tipo_documento,"","width 250px,wrap 1");
    this.cmbdto_tipo_clasificacion.addActionListener(controlador);
    this.agregar(lbldto_tipo_clasificacion,cmbdto_tipo_clasificacion,"","width 250px,wrap 1");
    this.txtstrcedularif.setName("txtstrcedularif");
    this.txtstrcedularif.addActionListener(controlador);
    this.txtstrcedularif.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrcedularif,txtstrcedularif,"","width 150px,wrap 1");
    this.txtstrnombre.setName("txtstrnombre");
    this.txtstrnombre.addActionListener(controlador);
    this.txtstrnombre.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","width 250px,wrap 1");
    this.txtstrapellido.setName("txtstrcedularif");
    this.txtstrapellido.addActionListener(controlador);
    this.txtstrapellido.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrapellido,txtstrapellido,"","width 250px,wrap 1");
    this.cmbdto_genero_persona.addActionListener(controlador);
    this.agregar(lbldto_genero_persona,cmbdto_genero_persona,"","width 250px,wrap 1");
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
    this.setSize(600, 420);
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
  public JLabel getLbldto_tipo_personalidad(){
    return lbldto_tipo_personalidad;
  }
  public void setLbldto_tipo_personalidad(  JLabel param){
    this.lbldto_tipo_personalidad=param;
  }
  public ComboBox getCmbdto_tipo_personalidad(){
    return cmbdto_tipo_personalidad;
  }
  public void setCmbdto_tipo_personalidad(  ComboBox param){
    this.cmbdto_tipo_personalidad=param;
  }
  public JLabel getLbldto_tipo_documento(){
    return lbldto_tipo_documento;
  }
  public void setLbldto_tipo_documento(  JLabel param){
    this.lbldto_tipo_documento=param;
  }
  public ComboBox getCmbdto_tipo_documento(){
    return cmbdto_tipo_documento;
  }
  public void setCmbdto_tipo_documento(  ComboBox param){
    this.cmbdto_tipo_documento=param;
  }
  public JLabel getLbldto_tipo_clasificacion(){
    return lbldto_tipo_clasificacion;
  }
  public void setLbldto_tipo_clasificacion(  JLabel param){
    this.lbldto_tipo_clasificacion=param;
  }
  public ComboBox getCmbdto_tipo_clasificacion(){
    return cmbdto_tipo_clasificacion;
  }
  public void setCmbdto_tipo_clasificacion(  ComboBox param){
    this.cmbdto_tipo_clasificacion=param;
  }
  public JLabel getLblstrcedularif(){
    return lblstrcedularif;
  }
  public void setLblstrcedularif(  JLabel param){
    this.lblstrcedularif=param;
  }
  public JTextField getTxtstrcedularif(){
    return txtstrcedularif;
  }
  public void setTxtstrcedularif(  JTextField param){
    this.txtstrcedularif=param;
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
  public JLabel getLblstrapellido(){
    return lblstrapellido;
  }
  public void setLblstrapellido(  JLabel param){
    this.lblstrapellido=param;
  }
  public JTextField getTxtstrapellido(){
    return txtstrapellido;
  }
  public void setTxtstrapellido(  JTextField param){
    this.txtstrapellido=param;
  }
  public JLabel getLbldto_genero_persona(){
    return lbldto_genero_persona;
  }
  public void setLbldto_genero_persona(  JLabel param){
    this.lbldto_genero_persona=param;
  }
  public ComboBox getCmbdto_genero_persona(){
    return cmbdto_genero_persona;
  }
  public void setCmbdto_genero_persona(  ComboBox param){
    this.cmbdto_genero_persona=param;
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
