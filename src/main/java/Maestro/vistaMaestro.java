package Maestro;

import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class vistaMaestro extends VistaBase {
	
	JLabel lbllngid=new JLabel("Id: ");
	JTextField txtlngid=new JTextField(15);	
	JLabel lblstrnombre=new JLabel("Nombre: ");
	JTextField txtstrnombre=new JTextField(50);
	JLabel lblstrsigla=new JLabel("Siglas: ");
	JTextField txtstrsigla=new JTextField(25);
	JLabel lblstrdescripcion=new JLabel("Descripcion: ");
	JTextField txtstrdescripcion=new JTextField(255);
	JLabel lblstrcodigo=new JLabel("Código: ");
	JTextField txtstrcodigo=new JTextField(25);
	JLabel lbldtomaestro=new JLabel("Ítem Padre: ");
	ComboBox cmbdtomaestro=new ComboBox(new Maestro());
	JLabel lblshrnivel=new JLabel("Nivel: ");
	//JTextField txtshrnivel=new JTextField(5);
	JComboBox cmbshrnivel=new JComboBox();
	JLabel lblshrpos_rel=new JLabel("Posición Relativa: ");
	//JTextField txtshrnivel=new JTextField(5);
	JComboBox cmbshrpos_rel=new JComboBox();
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

	public vistaMaestro(  ActionListener controlador){

		this.setTitle("Maestro");
		this.txtlngid.setName("txtlngid");
	    this.txtlngid.addActionListener(controlador);
	    this.txtlngid.addKeyListener((KeyListener) controlador);
		this.agregar(lbllngid,txtlngid,"","width 90px,wrap 1");		
		
		this.txtstrcodigo.setName("txtstrcodigo");
		this.txtstrcodigo.addActionListener(controlador);
		this.txtstrcodigo.addKeyListener((KeyListener) controlador);
		this.agregar(lblstrcodigo,txtstrcodigo,"","width 100px,wrap 1");
		
		this.txtstrnombre.setName("txtstrnombre");
		this.txtstrnombre.addActionListener(controlador);
		this.txtstrnombre.addKeyListener((KeyListener) controlador);
		this.agregar(lblstrnombre,txtstrnombre,"","width 200px,wrap 1");
		
		this.txtstrsigla.setName("txtstrsigla");
		this.txtstrsigla.addActionListener(controlador);
		this.txtstrsigla.addKeyListener((KeyListener) controlador);
		this.agregar(lblstrsigla,txtstrsigla,"","width 150px,wrap 1");
		
		this.txtstrdescripcion.setName("txtstrdescripcion");
		this.txtstrdescripcion.addActionListener(controlador);
		this.txtstrsigla.addKeyListener((KeyListener) controlador);
		this.agregar(lblstrdescripcion,txtstrdescripcion,"","width 200px,wrap 1");
		
		this.cmbdtomaestro.addActionListener(controlador);
		this.agregar(lbldtomaestro,cmbdtomaestro,"","width 280px,wrap 1");
		
		this.cmbshrnivel.setName("cmbshrnivel");
		this.cmbshrnivel.addActionListener(controlador);
		this.agregar(lblshrnivel,cmbshrnivel,"","width 200px,wrap 1");
		
		this.cmbshrpos_rel.setName("cmbshrpos_rel");
		this.cmbshrpos_rel.addActionListener(controlador);
		this.agregar(lblshrpos_rel,cmbshrpos_rel,"","width 200px,wrap 1");
		
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
		
		this.setSize(550, 500);
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
	public JLabel getLbldtomaestro(){
		return lbldtomaestro;
	}
	public void setLbldtomaestro(  JLabel param){
		this.lbldtomaestro=param;
	}
	public ComboBox getCmbdtomaestro(){
		return cmbdtomaestro;
	}
	public void setCmbdtomaestro(  ComboBox param){
		this.cmbdtomaestro=param;
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
	public JLabel getLblstrdescripcion() {
		return lblstrdescripcion;
	}
	public void setLblstrdescripcion(JLabel lblstrdescripcion) {
		this.lblstrdescripcion = lblstrdescripcion;
	}
	public JTextField getTxtstrdescripcion() {
		return txtstrdescripcion;
	}
	public void setTxtstrdescripcion(JTextField txtstrdescripcion) {
		this.txtstrdescripcion = txtstrdescripcion;
	}
	public JLabel getLblstrcodigo() {
		return lblstrcodigo;
	}
	public void setLblstrcodigo(JLabel lblstrcodigo) {
		this.lblstrcodigo = lblstrcodigo;
	}
	public JTextField getTxtstrcodigo() {
		return txtstrcodigo;
	}
	public void setTxtstrcodigo(JTextField txtstrcodigo) {
		this.txtstrcodigo = txtstrcodigo;
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
	public JDateChooser getDchdtmvalido_hasta() {
		return dchdtmvalido_hasta;
	}
	public void setDchdtmvalido_hasta(JDateChooser dchdtmvalidoHasta) {
		dchdtmvalido_hasta = dchdtmvalidoHasta;
	}
	public JLabel getLblshrnivel() {
		return lblshrnivel;
	}
	public void setLblshrnivel(JLabel lblshrnivel) {
		this.lblshrnivel = lblshrnivel;
	}
	public JComboBox getCmbshrnivel() {
		return cmbshrnivel;
	}
	public void setCmbshrnivel(JComboBox cmbshrnivel) {
		this.cmbshrnivel = cmbshrnivel;
	}
	public JLabel getLblshrpos_rel() {
		return lblshrpos_rel;
	}
	public void setLblshrpos_rel(JLabel lblshrposRel) {
		lblshrpos_rel = lblshrposRel;
	}
	public JComboBox getCmbshrpos_rel() {
		return cmbshrpos_rel;
	}
	public void setCmbshrpos_rel(JComboBox cmbshrposRel) {
		cmbshrpos_rel = cmbshrposRel;
	}
	public JDateChooser getDchdtmvalido_desde() {
		return dchdtmvalido_desde;
	}
	public void setDchdtmvalido_desde(JDateChooser dchdtmvalidoDesde) {
		dchdtmvalido_desde = dchdtmvalidoDesde;
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

