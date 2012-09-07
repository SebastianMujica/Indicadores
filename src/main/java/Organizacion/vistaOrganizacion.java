package Organizacion;
import java.util.*;

import SocioDeNegocio.SocioDeNegocio;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaOrganizacion extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lblstrcodigo=new JLabel("Código: ");
  JTextField txtstrcodigo=new JTextField(20);
  JLabel lbldto_org_superior=new JLabel("Org. Padre: ");
  ComboBox cmbdto_org_superior=new ComboBox(new Organizacion());
  JLabel lbldto_tipo_org=new JLabel("Tipo Organización: ");
  //ComboBox cmbdto_tipo_org=new ComboBox(new TipoOrganizacion());
  JLabel lbldto_socio_negocio=new JLabel("Socio de Negocio: ");
  ComboBox cmbdto_socio_negocio=new ComboBox(new SocioDeNegocio());
  JLabel lblstrsiglas=new JLabel("Siglas: ");
  JTextField txtstrsiglas=new JTextField(15);
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField(50);
  JLabel lblintnivel=new JLabel("Nivel Organizacional: ");
  JTextField txtlngnivel=new JTextField(2);
  JLabel lblintpos_rel=new JLabel("Posición Relativa: ");
  JTextField txtlngpos_rel=new JTextField(3);
  JLabel lblstrcolor_id=new JLabel("Color Identificador: ");
  JTextField txtstrcolor_id=new JTextField(7);
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
	
  public vistaOrganizacion(  ActionListener controlador){
	  
    this.setTitle("Organización");
    
    this.txtlngid.setName("txtlngid");
	this.txtlngid.addKeyListener((KeyListener) controlador);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
    
    this.txtstrcodigo.setName("txtstrcodigo");
	this.txtstrcodigo.addKeyListener((KeyListener) controlador);
    this.txtstrcodigo.addActionListener(controlador);
    this.agregar(lblstrcodigo,txtstrcodigo,"","width 150px,wrap 1");
    
    this.cmbdto_org_superior.addActionListener(controlador);
    this.agregar(lbldto_org_superior,cmbdto_org_superior,"","width 250px,wrap 1");
    //this.cmbdto_tipo_org.addActionListener(controlador);
    //this.agregar(lbldto_tipo_org,cmbdto_tipo_org);
    this.cmbdto_socio_negocio.addActionListener(controlador);
    this.agregar(lbldto_socio_negocio,cmbdto_socio_negocio,"","width 250px,wrap 1");
    
    this.txtstrsiglas.setName("txtstrsiglas");
	this.txtstrsiglas.addKeyListener((KeyListener) controlador);
    this.txtstrsiglas.addActionListener(controlador);
    this.agregar(lblstrsiglas,txtstrsiglas,"","width 120px,wrap 1");
    
    this.txtstrnombre.setName("txtstrnombre");
	this.txtstrnombre.addKeyListener((KeyListener) controlador);
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","width 280px,wrap 1");
    
    this.txtlngnivel.setName("txtlngnivel");
	this.txtlngnivel.addKeyListener((KeyListener) controlador);
    this.txtlngnivel.addActionListener(controlador);
    this.agregar(lblintnivel,txtlngnivel,"","width 90px,wrap 1");
    
    this.txtlngpos_rel.setName("txtlngpos_rel");
	this.txtlngpos_rel.addKeyListener((KeyListener) controlador);
    this.txtlngpos_rel.addActionListener(controlador);
    this.agregar(lblintpos_rel,txtlngpos_rel,"","width 90px,wrap 1");
    
    this.txtstrcolor_id.setName("txtstrcolor_id");
	this.txtstrcolor_id.addKeyListener((KeyListener) controlador);
    this.txtstrcolor_id.addActionListener(controlador);
    this.agregar(lblstrcolor_id,txtstrcolor_id,"","width 90px,wrap 1");
    
    this.chkbolactivo.setName("chkbolactivo");
    this.chkbolactivo.addActionListener(controlador);
    this.agregar(lblbolactivo,chkbolactivo,"","width 50px,wrap 1");
    this.getButtonNuevo().addActionListener(controlador);
    this.getButtonBuscar().addActionListener(controlador);
    this.getButtonEliminar().addActionListener(controlador);
    this.getImprimir().addActionListener(controlador);
    this.getButtonGuardar().addActionListener(controlador);
    //this.getButtonCancelar().addActionListener(controlador);
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
    this.setSize(650,450);
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
  public JLabel getLblstrcodigo(){
    return lblstrcodigo;
  }
  public void setLblstrcodigo(  JLabel param){
    this.lblstrcodigo=param;
  }
  public JTextField getTxtstrcodigo(){
    return txtstrcodigo;
  }
  public void setTxtstrcodigo(  JTextField param){
    this.txtstrcodigo=param;
  }
  public JLabel getLbldto_org_superior(){
    return lbldto_org_superior;
  }
  public void setLbldto_org_superior(  JLabel param){
    this.lbldto_org_superior=param;
  }
  public ComboBox getCmbdto_org_superior(){
    return cmbdto_org_superior;
  }
  public void setCmbdto_org_superior(  ComboBox param){
    this.cmbdto_org_superior=param;
  }
  public JLabel getLbldto_tipo_org(){
    return lbldto_tipo_org;
  }
  public void setLbldto_tipo_org(  JLabel param){
    this.lbldto_tipo_org=param;
  }
//  public ComboBox getCmbdto_tipo_org(){
//    return cmbdto_tipo_org;
//  }
//  public void setCmbdto_tipo_org(  ComboBox param){
//    this.cmbdto_tipo_org=param;
//  }
  public JLabel getLbldto_socio_negocio(){
    return lbldto_socio_negocio;
  }
  public void setLbldto_socio_negocio(  JLabel param){
    this.lbldto_socio_negocio=param;
  }
  public ComboBox getCmbdto_socio_negocio(){
    return cmbdto_socio_negocio;
  }
  public void setCmbdto_socio_negocio(  ComboBox param){
    this.cmbdto_socio_negocio=param;
  }
  public JLabel getLblstrsiglas(){
    return lblstrsiglas;
  }
  public void setLblstrsiglas(  JLabel param){
    this.lblstrsiglas=param;
  }
  public JTextField getTxtstrsiglas(){
    return txtstrsiglas;
  }
  public void setTxtstrsiglas(  JTextField param){
    this.txtstrsiglas=param;
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
  public JLabel getLblintnivel(){
    return lblintnivel;
  }
  public void setLblintnivel(  JLabel param){
    this.lblintnivel=param;
  }
  public JTextField getTxtlngnivel(){
    return txtlngnivel;
  }
  public void setTxtlngnivel(  JTextField param){
    this.txtlngnivel=param;
  }
  public JLabel getLblintpos_rel(){
    return lblintpos_rel;
  }
  public void setLblintpos_rel(  JLabel param){
    this.lblintpos_rel=param;
  }
  public JTextField getTxtlngpos_rel(){
    return txtlngpos_rel;
  }
  public void setTxtlngpos_rel(  JTextField param){
    this.txtlngpos_rel=param;
  }
  public JLabel getLblstrcolor_id(){
    return lblstrcolor_id;
  }
  public void setLblstrcolor_id(  JLabel param){
    this.lblstrcolor_id=param;
  }
  public JTextField getTxtstrcolor_id(){
    return txtstrcolor_id;
  }
  public void setTxtstrcolor_id(  JTextField param){
    this.txtstrcolor_id=param;
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

