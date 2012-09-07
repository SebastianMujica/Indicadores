package Usuario;
import java.util.*;

import SocioDeNegocio.SocioDeNegocio;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import Tema.Tema;

import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class vistaUsuario extends VistaBase {
	JLabel lbllngid=new JLabel("Id: ");
	JTextField txtlngid=new JTextField(15);
	JLabel lbldtosocio=new JLabel("Socio de Negocio: ");
	ComboBox cmbdtosocio=new ComboBox(new SocioDeNegocio());
	JLabel lblstrusername=new JLabel("Usuario: ");
	JTextField txtstrusername=new JTextField(30);
	JLabel lblstrpassword=new JLabel("Contraseña: ");
	JPasswordField txtstrpassword=new JPasswordField(50);
	JLabel lblstrconfirpassword=new JLabel("Confirmar Contraseña: ");
	JPasswordField txtstrconfirpassword=new JPasswordField(50);
	JLabel lbldtmfecha_ultimologin=new JLabel("Último Inicio de Sesión: ");
	JDateChooser  dchdtmfecha_ultimologin   = new JDateChooser();
	JLabel lbldto_tema=new JLabel("Tema: ");
	ComboBox cmbdto_tema=new ComboBox(new Tema());
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

	public vistaUsuario(  ActionListener controlador){
		this.setTitle("Usuario");
		
		this.txtlngid.setName("txtlngid");
	    this.txtlngid.addKeyListener((KeyListener) controlador);
	    this.txtlngid.addActionListener(controlador);
	    this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
	    
		this.cmbdtosocio.addActionListener(controlador);
		this.agregar(lbldtosocio,cmbdtosocio);
		
		this.txtstrusername.setName("txtstrusername");
	    this.txtstrusername.addKeyListener((KeyListener) controlador);
		this.txtstrusername.addActionListener(controlador);
		this.agregar(lblstrusername,txtstrusername,"","width 180px,wrap 1");
		
		this.txtstrpassword.setName("txtstrpassword");
	    this.txtstrpassword.addKeyListener((KeyListener) controlador);
		this.txtstrpassword.addActionListener(controlador);
		this.agregar(lblstrpassword,txtstrpassword,"","width 180px,wrap 1");
		
		this.txtstrconfirpassword.setName("txtstrconfirpassword");
	    this.txtstrconfirpassword.addKeyListener((KeyListener) controlador);
		this.txtstrconfirpassword.addActionListener(controlador);
		this.agregar(lblstrconfirpassword,txtstrconfirpassword,"","width 180px,wrap 1");
		
		this.agregar(lbldtmfecha_ultimologin,dchdtmfecha_ultimologin);
		this.agregar(lbldto_tema,cmbdto_tema);
		this.cmbdto_tema.addActionListener(controlador);
		
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
	public JLabel getLbldtosocio(){
		return lbldtosocio;
	}
	public void setLbldtosocio(  JLabel param){
		this.lbldtosocio=param;
	}
	public ComboBox getCmbdtosocio(){
		return cmbdtosocio;
	}
	public void setCmbdtosocio(  ComboBox param){
		this.cmbdtosocio=param;
	}
	public JLabel getLblstrusername(){
		return lblstrusername;
	}
	public void setLblstrusername(  JLabel param){
		this.lblstrusername=param;
	}
	public JTextField getTxtstrusername(){
		return txtstrusername;
	}
	public void setTxtstrusername(  JTextField param){
		this.txtstrusername=param;
	}
	public JLabel getLblstrpassword(){
		return lblstrpassword;
	}
	public void setLblstrpassword(  JLabel param){
		this.lblstrpassword=param;
	}
	public JTextField getTxtstrpassword(){
		return txtstrpassword;
	}
	public void setTxtstrpassword(  JPasswordField param){
		this.txtstrpassword=param;
	}
	public JLabel getLblstrconfirpassword(){
		return lblstrconfirpassword;
	}
	public void setLblstrconfirpassword(  JLabel param){
		this.lblstrconfirpassword=param;
	}
	public JTextField getTxtstrconfirpassword(){
		return txtstrconfirpassword;
	}
	public void setTxtstrconfirpassword(  JPasswordField param){
		this.txtstrconfirpassword=param;
	}
	public JLabel getLbldtmfecha_ultimologin() {
		return lbldtmfecha_ultimologin;
	}
	public void setLbldtmfecha_ultimologin(JLabel lbldtmfechaUltimologin) {
		lbldtmfecha_ultimologin = lbldtmfechaUltimologin;
	}
	public JDateChooser getDchdtmfecha_ultimologin() {
		return dchdtmfecha_ultimologin;
	}
	public void setDchdtmfecha_ultimologin(JDateChooser dchdtmfechaUltimologin) {
		dchdtmfecha_ultimologin = dchdtmfechaUltimologin;
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
	public JLabel getLbldto_tema() {
		return lbldto_tema;
	}
	public void setLbldto_tema(JLabel lbldtoTema) {
		lbldto_tema = lbldtoTema;
	}
	public ComboBox getCmbdto_tema() {
		return cmbdto_tema;
	}
	public void setCmbdto_tema(ComboBox cmbdtoTema) {
		cmbdto_tema = cmbdtoTema;
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

