package Producto;

import Maestro.Maestro;
import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import UnidadDeMedida.UnidadDeMedida;

import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class vistaProducto extends VistaBase {

	JLabel lbllngid=new JLabel("Lngid: ");
	JTextField txtlngid=new JTextField(5);
	JLabel lblstrcodigo=new JLabel("Strcodigo: ");
	JTextField txtstrcodigo=new JTextField(10);
	JLabel lblstrnombre=new JLabel("Strnombre: ");
	JTextField txtstrnombre=new JTextField(20);
	JLabel lblstrsimbolo=new JLabel("Strsimbolo: ");
	JTextField txtstrsimbolo=new JTextField(10);
	JLabel lblstrdescripcion=new JLabel("Strdescripcion: ");
	JTextField txtstrdescripcion=new JTextField(30);
	JLabel lbldtoorganizacion=new JLabel("DtoOrganizacion: ");
	ComboBox cmbdtoorganizacion=new ComboBox(new Organizacion());
	JLabel lbldtounidadmedida=new JLabel("Dtounidadmedida: ");
	ComboBox cmbdtounidadmedida=new ComboBox(new UnidadDeMedida());
	JLabel lbldtotipoproducto=new JLabel("Dtotipoproducto: ");
	ComboBox cmbdtotipoproducto=new ComboBox(new Maestro());
	JLabel lbldtocategoriaproducto=new JLabel("Dtocategoriaproducto: ");
	ComboBox cmbdtocategoriaproducto=new ComboBox(new Maestro());

	JTextField txtstrip_creacion=new JTextField();
	JTextField txtstrip_modificacion=new JTextField();
	JTextField txtstrhost_creacion=new JTextField();
	JTextField txtstrhost_modificacion=new JTextField();
	JDateChooser  dchdtmfecha_creacion   = new JDateChooser();
	JDateChooser  dchdtmfecha_modificacion   = new JDateChooser();
	JDateChooser  dchdtmvalido_hasta   = new JDateChooser();

	public vistaProducto(  ActionListener controlador){
		this.setTitle("Producto");
		
		this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid,txtlngid);
		this.txtstrcodigo.addActionListener(controlador);
		this.agregar(lblstrcodigo,txtstrcodigo);
		this.txtstrnombre.addActionListener(controlador);
		this.agregar(lblstrnombre,txtstrnombre);
		this.txtstrsimbolo.addActionListener(controlador);
		this.agregar(lblstrsimbolo,txtstrsimbolo);
		this.txtstrdescripcion.addActionListener(controlador);
		this.agregar(lblstrdescripcion,txtstrdescripcion);
		
		this.cmbdtoorganizacion.addActionListener(controlador);
		this.cmbdtoorganizacion.setName("cmborganizacion");
		this.agregar(lbldtoorganizacion,cmbdtoorganizacion);
		this.cmbdtounidadmedida.addActionListener(controlador);
		this.cmbdtounidadmedida.setName("cmbunidadmedida");
		this.agregar(lbldtounidadmedida,cmbdtounidadmedida);
		this.cmbdtotipoproducto.addActionListener(controlador);
		this.cmbdtotipoproducto.setName("cmbtipoproducto");
		this.agregar(lbldtotipoproducto,cmbdtotipoproducto);
		this.cmbdtocategoriaproducto.addActionListener(controlador);
		this.cmbdtocategoriaproducto.setName("cmbcategoriaproducto");
		this.agregar(lbldtocategoriaproducto,cmbdtocategoriaproducto);
		
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
	public JLabel getLblstrsimbolo(){
		return lblstrsimbolo;
	}
	public void setLblstrsimbolo(  JLabel param){
		this.lblstrsimbolo=param;
	}
	public JTextField getTxtstrsimbolo(){
		return txtstrsimbolo;
	}
	public void setTxtstrsimbolo(  JTextField param){
		this.txtstrsimbolo=param;
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
	public JLabel getLbldtoorganizacion() {
		return lbldtoorganizacion;
	}
	public void setLbldtoorganizacion(JLabel lbldtoorganizacion) {
		this.lbldtoorganizacion = lbldtoorganizacion;
	}
	public ComboBox getCmbdtoorganizacion() {
		return cmbdtoorganizacion;
	}
	public void setCmbdtoorganizacion(ComboBox cmbdtoorganizacion) {
		this.cmbdtoorganizacion = cmbdtoorganizacion;
	}
	public JLabel getLbldtounidadmedida(){
		return lbldtounidadmedida;
	}
	public void setLbldtounidadmedida(  JLabel param){
		this.lbldtounidadmedida=param;
	}
	public ComboBox getCmbdtounidadmedida(){
		return cmbdtounidadmedida;
	}
	public void setCmbdtounidadmedida(  ComboBox param){
		this.cmbdtounidadmedida=param;
	}
	public JLabel getLbldtotipoproducto(){
		return lbldtotipoproducto;
	}
	public void setLbldtotipoproducto(  JLabel param){
		this.lbldtotipoproducto=param;
	}
	public ComboBox getCmbdtotipoproducto(){
		return cmbdtotipoproducto;
	}
	public void setCmbdtotipoproducto(  ComboBox param){
		this.cmbdtotipoproducto=param;
	}
	public JLabel getLbldtocategoriaproducto(){
		return lbldtocategoriaproducto;
	}
	public void setLbldtocategoriaproducto(  JLabel param){
		this.lbldtocategoriaproducto=param;
	}
	public ComboBox getCmbdtocategoriaproducto(){
		return cmbdtocategoriaproducto;
	}
	public void setCmbdtocategoriaproducto(  ComboBox param){
		this.cmbdtocategoriaproducto=param;
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
}

