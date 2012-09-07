package AtributoCentral;
import java.util.*;

import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class vistaAtributoCentral extends VistaBase {
	
	JLabel lbllngid=new JLabel("Id: ");
	JTextField txtlngid=new JTextField(15);
	JLabel lbldtoorganizacion=new JLabel("Organización: ");
	ComboBox cmbdtoorganizacion=new ComboBox(new Organizacion());
	JLabel lblflocap_instalada=new JLabel("Capacidad Instalada (Tn/dia): ");
	JTextField txtflocap_instalada=new JTextField(10);
	JLabel lblflocap_operativa=new JLabel("Capacidad Operativa (Tn/dia): ");
	JTextField txtflocap_operativa=new JTextField(10);
	JLabel lblflocap_alm_crudo_azucar=new JLabel("Capacidad Almacenaje Azúcar Crudo: ");
	JTextField txtflocap_alm_crudo_azucar=new JTextField(10);
	JLabel lblflocap_alm_melaza=new JLabel("Capacidad Almacenaje de Melaza: ");
	JTextField txtflocap_alm_melaza=new JTextField(10);
	JLabel lblstrtecnologia=new JLabel("Descripción Tecnología Utilizada: ");
	JTextArea txtstrtecnologia=new JTextArea(40,10);
	JLabel lbldtmfecha_inicio_oper=new JLabel("Fecha de Inicio de Operaciones: ");
	JDateChooser  dchdtmfecha_inicio_oper   = new JDateChooser();
	JLabel lbldtmfecha_interv_nac=new JLabel("Fecha de Nacionalización: ");
	JDateChooser  dchdtmfecha_interv_nac   = new JDateChooser();
	
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

	public vistaAtributoCentral(  ActionListener controlador){
		this.setTitle("Atributo por Central");
		this.txtlngid.setName("txtlngid");
		this.txtlngid.addKeyListener((KeyListener) controlador);
	    this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid,txtlngid,"","width 90px,wrap 1 1");
		
		this.cmbdtoorganizacion.addActionListener(controlador);
		this.agregar(lbldtoorganizacion,cmbdtoorganizacion,"","width 350px, wrap 1");
		
		this.txtflocap_instalada.setName("txtflocap_instalada");
		this.txtflocap_instalada.addKeyListener((KeyListener) controlador);
		this.txtflocap_instalada.addActionListener(controlador);
		this.agregar(lblflocap_instalada,txtflocap_instalada,"","width 150px, wrap 1");
		
		this.txtflocap_operativa.setName("txtflocap_operativa");
		this.txtflocap_operativa.addKeyListener((KeyListener) controlador);
		this.txtflocap_operativa.addActionListener(controlador);
		this.agregar(lblflocap_operativa,txtflocap_operativa,"","width 150px, wrap 1");
		
		this.txtflocap_alm_crudo_azucar.setName("txtflocap_alm_crudo_azucar");
		this.txtflocap_alm_crudo_azucar.addKeyListener((KeyListener) controlador);
		this.txtflocap_alm_crudo_azucar.addActionListener(controlador);
		this.agregar(lblflocap_alm_crudo_azucar,txtflocap_alm_crudo_azucar,"","width 150px, wrap 1");
		
		this.txtflocap_alm_melaza.setName("txtflocap_alm_melaza");
		this.txtflocap_alm_melaza.addKeyListener((KeyListener) controlador);
		this.txtflocap_alm_melaza.addActionListener(controlador);
		this.agregar(lblflocap_alm_melaza,txtflocap_alm_melaza,"","width 150px, wrap 1");

		this.txtstrtecnologia.setMaximumSize(new Dimension(300, 100));
		this.agregar(lblstrtecnologia,txtstrtecnologia,"","width 300px, height 100px, wrap 1");
		this.agregar(lbldtmfecha_inicio_oper,dchdtmfecha_inicio_oper,"","width 150px, wrap 1");
		this.agregar(lbldtmfecha_interv_nac,dchdtmfecha_interv_nac,"","width 150px, wrap 1");
		
		this.chkbolactivo.setName("chkbolactivo");
		this.chkbolactivo.addActionListener(controlador);
		this.agregar(lblbolactivo,chkbolactivo,"","width 50px,wrap 1 ");

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

		this.setSize(700, 500);
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
	public JLabel getLblflocap_instalada(){
		return lblflocap_instalada;
	}
	public void setLblflocap_instalada(  JLabel param){
		this.lblflocap_instalada=param;
	}
	public JTextField getTxtflocap_instalada(){
		return txtflocap_instalada;
	}
	public void setTxtflocap_instalada(  JTextField param){
		this.txtflocap_instalada=param;
	}
	public JLabel getLblflocap_operativa(){
		return lblflocap_operativa;
	}
	public void setLblflocap_operativa(  JLabel param){
		this.lblflocap_operativa=param;
	}
	public JTextField getTxtflocap_operativa(){
		return txtflocap_operativa;
	}
	public void setTxtflocap_operativa(  JTextField param){
		this.txtflocap_operativa=param;
	}
	public JLabel getLblflocap_alm_crudo_azucar(){
		return lblflocap_alm_crudo_azucar;
	}
	public void setLblflocap_alm_crudo_azucar(  JLabel param){
		this.lblflocap_alm_crudo_azucar=param;
	}
	public JTextField getTxtflocap_alm_crudo_azucar(){
		return txtflocap_alm_crudo_azucar;
	}
	public void setTxtflocap_alm_crudo_azucar(  JTextField param){
		this.txtflocap_alm_crudo_azucar=param;
	}
	public JLabel getLblflocap_alm_melaza(){
		return lblflocap_alm_melaza;
	}
	public void setLblflocap_alm_melaza(  JLabel param){
		this.lblflocap_alm_melaza=param;
	}
	public JTextField getTxtflocap_alm_melaza(){
		return txtflocap_alm_melaza;
	}
	public void setTxtflocap_alm_melaza(  JTextField param){
		this.txtflocap_alm_melaza=param;
	}
	public JLabel getLblstrtecnologia() {
		return lblstrtecnologia;
	}
	public void setLblstrtecnologia(JLabel lblstrtecnologia) {
		this.lblstrtecnologia = lblstrtecnologia;
	}
	public JTextArea getTxtstrtecnologia() {
		return txtstrtecnologia;
	}
	public void setTxtstrtecnologia(JTextArea txtstrtecnologia) {
		this.txtstrtecnologia = txtstrtecnologia;
	}
	public JLabel getLbldtmfecha_inicio_oper() {
		return lbldtmfecha_inicio_oper;
	}
	public void setLbldtmfecha_inicio_oper(JLabel lbldtmfechaInicioOper) {
		lbldtmfecha_inicio_oper = lbldtmfechaInicioOper;
	}
	public JDateChooser getDchdtmfecha_inicio_oper() {
		return dchdtmfecha_inicio_oper;
	}
	public void setDchdtmfecha_inicio_oper(JDateChooser dchdtmfechaInicioOper) {
		dchdtmfecha_inicio_oper = dchdtmfechaInicioOper;
	}
	public JLabel getLbldtmfecha_interv_nac() {
		return lbldtmfecha_interv_nac;
	}
	public void setLbldtmfecha_interv_nac(JLabel lbldtmfechaIntervNac) {
		lbldtmfecha_interv_nac = lbldtmfechaIntervNac;
	}
	public JDateChooser getDchdtmfecha_interv_nac() {
		return dchdtmfecha_interv_nac;
	}
	public void setDchdtmfecha_interv_nac(JDateChooser dchdtmfechaIntervNac) {
		dchdtmfecha_interv_nac = dchdtmfechaIntervNac;
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

