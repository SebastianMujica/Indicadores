package ContactoSocioDeNegocio;
import java.util.*;

import Maestro.Maestro;
import SocioDeNegocio.SocioDeNegocio;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaContactoSocioDeNegocio extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldto_sociodenegocio=new JLabel("Socio de Negocio: ");
  ComboBox cmbdto_sociodenegocio=new ComboBox(new SocioDeNegocio());
  JLabel lbldto_tipo_contacto=new JLabel("Tipo Contacto: ");
  ComboBox cmbdto_tipo_contacto=new ComboBox(new Maestro());
  JLabel lblstrcod_area=new JLabel("Código de Área: ");
  JTextField txtstrcod_area=new JTextField(4);
  JLabel lblstrnro_telf=new JLabel("Nro. Teléfono: ");
  JTextField txtstrnro_telf=new JTextField(7);
  JLabel lblstrvalor_comunicacion=new JLabel("Correo Electrónico/Web: ");
  JTextField txtstrvalor_comunicacion=new JTextField(80);
  
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
  
  public vistaContactoSocioDeNegocio(  ActionListener controlador){
    this.setTitle("Medios de Contacto Socio de Negocio");
    this.txtlngid.setName("txtlngid");
    this.txtlngid.addActionListener(controlador);
    this.txtlngid.addKeyListener((KeyListener) controlador);
    this.agregar(lbllngid,txtlngid,"","width 120px,wrap 1");
    this.cmbdto_sociodenegocio.addActionListener(controlador);
    this.agregar(lbldto_sociodenegocio,cmbdto_sociodenegocio,"","width 300px,wrap 1");
    this.cmbdto_tipo_contacto.addActionListener(controlador);
    this.agregar(lbldto_tipo_contacto,cmbdto_tipo_contacto,"","width 300px,wrap 1");
    this.txtstrcod_area.setName("txtstrcod_area");
    this.txtstrcod_area.addActionListener(controlador);
    this.txtstrcod_area.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrcod_area,txtstrcod_area,"","width 120px,wrap 1");
    this.txtstrnro_telf.setName("txtstrnro_telf");
    this.txtstrnro_telf.addActionListener(controlador);
    this.txtstrnro_telf.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrnro_telf,txtstrnro_telf,"","width 150px,wrap 1");
    this.txtstrvalor_comunicacion.setName("txtstrvalor_comunicacion");
    this.txtstrvalor_comunicacion.addActionListener(controlador);
    this.txtstrvalor_comunicacion.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrvalor_comunicacion,txtstrvalor_comunicacion,"","width 300px,wrap 1");
    
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
    this.setSize(600, 380);
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
  public JLabel getLbldto_sociodenegocio(){
    return lbldto_sociodenegocio;
  }
  public void setLbldto_sociodenegocio(  JLabel param){
    this.lbldto_sociodenegocio=param;
  }
  public ComboBox getCmbdto_sociodenegocio(){
    return cmbdto_sociodenegocio;
  }
  public void setCmbdto_sociodenegocio(  ComboBox param){
    this.cmbdto_sociodenegocio=param;
  }
  public JLabel getLbldto_tipo_contacto(){
    return lbldto_tipo_contacto;
  }
  public void setLbldto_tipo_contacto(  JLabel param){
    this.lbldto_tipo_contacto=param;
  }
  public ComboBox getCmbdto_tipo_contacto(){
    return cmbdto_tipo_contacto;
  }
  public void setCmbdto_tipo_contacto(  ComboBox param){
    this.cmbdto_tipo_contacto=param;
  }
  public JLabel getLblstrcod_area(){
    return lblstrcod_area;
  }
  public void setLblstrcod_area(  JLabel param){
    this.lblstrcod_area=param;
  }
  public JTextField getTxtstrcod_area(){
    return txtstrcod_area;
  }
  public void setTxtstrcod_area(  JTextField param){
    this.txtstrcod_area=param;
  }
  public JLabel getLblstrnro_telf(){
    return lblstrnro_telf;
  }
  public void setLblstrnro_telf(  JLabel param){
    this.lblstrnro_telf=param;
  }
  public JTextField getTxtstrnro_telf(){
    return txtstrnro_telf;
  }
  public void setTxtstrnro_telf(  JTextField param){
    this.txtstrnro_telf=param;
  }
  public JLabel getLblstrvalor_comunicacion(){
    return lblstrvalor_comunicacion;
  }
  public void setLblstrvalor_comunicacion(  JLabel param){
    this.lblstrvalor_comunicacion=param;
  }
  public JTextField getTxtstrvalor_comunicacion(){
    return txtstrvalor_comunicacion;
  }
  public void setTxtstrvalor_comunicacion(  JTextField param){
    this.txtstrvalor_comunicacion=param;
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

