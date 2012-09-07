package Tarea;
import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaTarea extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lblstrcodigo=new JLabel("Código: ");
  JTextField txtstrcodigo=new JTextField(15);
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField(30);
  JLabel lblstrdescripcion=new JLabel("Descripción: ");
  JTextField txtstrdescripcion=new JTextField(255);
  JLabel lbldto_tarea_padre=new JLabel("Tarea Padre: ");
  ComboBox cmbdto_tarea_padre=new ComboBox(new Tarea());
  JLabel lbllngnivel=new JLabel("Nivel: ");
  JTextField txtintnivel=new JTextField(3);
  JLabel lbllngpos_rel=new JLabel("Pos. Relativa: ");
  JTextField txtintpos_rel=new JTextField(3);
  JLabel lblstrtexto_ayuda=new JLabel("Texto Ayuda: ");
  JTextField txtstrtexto_ayuda=new JTextField(50);
  JLabel lblstrimg_activa=new JLabel("Imágen Activa: ");
  JTextField txtstrimg_activa=new JTextField(100);
  JLabel lblstrimg_desactiva=new JLabel("Imágen Desactiva: ");
  JTextField txtstrimg_desactiva=new JTextField(100);
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
	
  public vistaTarea(  ActionListener controlador){
    this.setTitle("Seguridad::.Tareas");
    
    this.txtlngid.setName("txtlngid");
	this.txtlngid.addKeyListener((KeyListener) controlador);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 90px,wrap 1");
    
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","width 250px,wrap 1");
    
    this.txtstrcodigo.setName("txtstrcodigo");
	this.txtstrcodigo.addKeyListener((KeyListener) controlador);
    this.txtstrcodigo.addActionListener(controlador);
    this.agregar(lblstrcodigo,txtstrcodigo,"","width 150px,wrap 1");
    
    this.txtstrnombre.setName("txtstrnombre");
	this.txtstrnombre.addKeyListener((KeyListener) controlador);
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","width 250px,wrap 1");
    
    this.txtstrdescripcion.setName("txtstrdescripcion");
	this.txtstrdescripcion.addKeyListener((KeyListener) controlador);
    this.txtstrdescripcion.addActionListener(controlador);
    this.agregar(lblstrdescripcion,txtstrdescripcion,"","width 250px,wrap 1");
    this.cmbdto_tarea_padre.addActionListener(controlador);
    this.agregar(lbldto_tarea_padre,cmbdto_tarea_padre,"","width 250px,wrap 1");
    
    this.txtintnivel.setName("txtintnivel");
	this.txtintnivel.addKeyListener((KeyListener) controlador);
    this.txtintnivel.addActionListener(controlador);
    this.agregar(lbllngnivel,txtintnivel,"","width 150px,wrap 1");
    
    this.txtintpos_rel.setName("txtintpos_rel");
	this.txtintpos_rel.addKeyListener((KeyListener) controlador);
    this.txtintpos_rel.addActionListener(controlador);
    this.agregar(lbllngpos_rel,txtintpos_rel,"","width 150px,wrap 1");
    
    this.txtstrtexto_ayuda.setName("txtstrtexto_ayuda");
	this.txtstrtexto_ayuda.addKeyListener((KeyListener) controlador);
    this.txtstrtexto_ayuda.addActionListener(controlador);
    this.agregar(lblstrtexto_ayuda,txtstrtexto_ayuda,"","width 250px,wrap 1");
    
    this.txtstrimg_activa.setName("txtstrimg_activa");
	this.txtstrimg_activa.addKeyListener((KeyListener) controlador);
    this.txtstrimg_activa.addActionListener(controlador);
    this.agregar(lblstrimg_activa,txtstrimg_activa,"","width 250px,wrap 1");
    
    this.txtstrimg_desactiva.setName("txtstrimg_desactiva");
	this.txtstrimg_desactiva.addKeyListener((KeyListener) controlador);
    this.txtstrimg_desactiva.addActionListener(controlador);
    this.agregar(lblstrimg_desactiva,txtstrimg_desactiva,"","width 250px,wrap 1");
    
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
  public JLabel getLbldto_org(){
    return lbldto_org;
  }
  public void setLbldto_org(  JLabel param){
    this.lbldto_org=param;
  }
  public ComboBox getCmbdto_org(){
    return cmbdto_org;
  }
  public void setCmbdto_org(  ComboBox param){
    this.cmbdto_org=param;
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
  public JLabel getLblstrdescripcion(){
    return lblstrdescripcion;
  }
  public void setLblstrdescripcion(  JLabel param){
    this.lblstrdescripcion=param;
  }
  public JTextField getTxtstrdescripcion(){
    return txtstrdescripcion;
  }
  public void setTxtstrdescripcion(  JTextField param){
    this.txtstrdescripcion=param;
  }
  public JLabel getLbldto_tarea_padre(){
    return lbldto_tarea_padre;
  }
  public void setLbldto_tarea_padre(  JLabel param){
    this.lbldto_tarea_padre=param;
  }
  public ComboBox getCmbdto_tarea_padre(){
    return cmbdto_tarea_padre;
  }
  public void setCmbdto_tarea_padre(  ComboBox param){
    this.cmbdto_tarea_padre=param;
  }
  public JLabel getLbllngnivel(){
    return lbllngnivel;
  }
  public void setLbllngnivel(  JLabel param){
    this.lbllngnivel=param;
  }
  public JTextField getTxtintnivel(){
    return txtintnivel;
  }
  public void setTxtintnivel(  JTextField param){
    this.txtintnivel=param;
  }
  public JLabel getLbllngpos_rel(){
    return lbllngpos_rel;
  }
  public void setLbllngpos_rel(  JLabel param){
    this.lbllngpos_rel=param;
  }
  public JTextField getTxtintpos_rel(){
    return txtintpos_rel;
  }
  public void setTxtintpos_rel(  JTextField param){
    this.txtintpos_rel=param;
  }
  public JLabel getLblstrtexto_ayuda(){
    return lblstrtexto_ayuda;
  }
  public void setLblstrtexto_ayuda(  JLabel param){
    this.lblstrtexto_ayuda=param;
  }
  public JTextField getTxtstrtexto_ayuda(){
    return txtstrtexto_ayuda;
  }
  public void setTxtstrtexto_ayuda(  JTextField param){
    this.txtstrtexto_ayuda=param;
  }
  public JLabel getLblstrimg_activa(){
    return lblstrimg_activa;
  }
  public void setLblstrimg_activa(  JLabel param){
    this.lblstrimg_activa=param;
  }
  public JTextField getTxtstrimg_activa(){
    return txtstrimg_activa;
  }
  public void setTxtstrimg_activa(  JTextField param){
    this.txtstrimg_activa=param;
  }
  public JLabel getLblstrimg_desactiva(){
    return lblstrimg_desactiva;
  }
  public void setLblstrimg_desactiva(  JLabel param){
    this.lblstrimg_desactiva=param;
  }
  public JTextField getTxtstrimg_desactiva(){
    return txtstrimg_desactiva;
  }
  public void setTxtstrimg_desactiva(  JTextField param){
    this.txtstrimg_desactiva=param;
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

