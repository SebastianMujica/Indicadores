package Periodo;
import java.util.*;

import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaPeriodo extends VistaBase {
	JLabel lbllngid=new JLabel("Id: ");
	JTextField txtlngid=new JTextField(15);
	JLabel lbldtoorganizacion=new JLabel("Organización: ");
	ComboBox cmbdtoorganizacion=new ComboBox(new Organizacion());
	JLabel lblstrcodigo=new JLabel("Código: ");
	JTextField txtstrcodigo=new JTextField(20);
	JLabel lblstrnombre=new JLabel("Nombre: ");
	JTextField txtstrnombre=new JTextField(30);	
	JLabel lblstrdescripcion=new JLabel("Descripción: ");
	JTextField txtstrdescripcion=new JTextField(255);
	JLabel lblbolactivo=new JLabel("Activo: ");
	JCheckBox chkbolactivo=new JCheckBox();

	JTextField txtstrip_creacion=new JTextField();
	JTextField txtstrip_modificacion=new JTextField();
	JTextField txtstrhost_creacion=new JTextField();
	JTextField txtstrhost_modificacion=new JTextField();
	JDateChooser  dchdtmfecha_creacion   = new JDateChooser();
	JDateChooser  dchdtmfecha_modificacion   = new JDateChooser();
	JLabel lbldtmvalido_desde=new JLabel("Válido Desde: ");
	JDateChooser  dchdtmvalido_desde   = new JDateChooser();
	JLabel lbldtmvalido_hasta=new JLabel("Válido Hasta: ");
	JDateChooser  dchdtmvalido_hasta   = new JDateChooser();
	JTextField txtlngseg_usuario_creacion=new JTextField(2);
	JTextField txtlngseg_usuario_modificacion=new JTextField(2);
	
	public vistaPeriodo(  ActionListener controlador){

		this.setTitle("Períodos");
		
		this.txtlngid.setName("txtlngid");
		this.txtlngid.addKeyListener((KeyListener) controlador);
		this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid,txtlngid,"","width 150px, wrap 1");
		
		this.cmbdtoorganizacion.addActionListener(controlador);
		this.agregar(lbldtoorganizacion,cmbdtoorganizacion);
		
		this.txtstrcodigo.setName("txtstrcodigo");
		this.txtstrcodigo.addKeyListener((KeyListener) controlador);
		this.txtstrcodigo.addActionListener(controlador);
		this.agregar(lblstrcodigo,txtstrcodigo,"","width 150px, wrap 1");
		
		this.txtstrnombre.setName("txtstrnombre");
		this.txtstrnombre.addKeyListener((KeyListener) controlador);
		this.txtstrnombre.addActionListener(controlador);
		this.agregar(lblstrnombre,txtstrnombre,"","width 280px, wrap 1");
		
		this.txtstrdescripcion.setName("txtstrdescripcion");
		this.txtstrdescripcion.addKeyListener((KeyListener) controlador);
		this.txtstrdescripcion.addActionListener(controlador);
		this.agregar(lblstrdescripcion,txtstrdescripcion,"","width 280px, wrap 1");

		this.agregar(lbldtmvalido_desde,dchdtmvalido_desde,"","width 100px, wrap 1");
		this.agregar(lbldtmvalido_hasta,dchdtmvalido_hasta,"","width 100px,wrap 1");
		
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

		this.setSize(500, 400);
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
	public JLabel getLbldtoorganizacion(){
		return lbldtoorganizacion;
	}
	public void setLbldtoorganizacion(  JLabel param){
		this.lbldtoorganizacion=param;
	}
	public ComboBox getCmbdtoorganizacion(){
		return cmbdtoorganizacion;
	}
	public void setCmbdtoorganizacion(  ComboBox param){
		this.cmbdtoorganizacion=param;
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
	public JLabel getLbldtmvalido_desde() {
		return lbldtmvalido_desde;
	}
	public void setLbldtmvalido_desde(JLabel lbldtmvalidoDesde) {
		lbldtmvalido_desde = lbldtmvalidoDesde;
	}
	public JDateChooser getDchdtmvalido_desde() {
		return dchdtmvalido_desde;
	}
	public void setDchdtmvalido_desde(JDateChooser dchdtmvalidoDesde) {
		dchdtmvalido_desde = dchdtmvalidoDesde;
	}
	public JLabel getLbldtmvalido_hasta() {
		return lbldtmvalido_hasta;
	}
	public void setLbldtmvalido_hasta(JLabel lbldtmvalidoHasta) {
		lbldtmvalido_hasta = lbldtmvalidoHasta;
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

