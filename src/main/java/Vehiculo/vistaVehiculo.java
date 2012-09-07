package Vehiculo;

import Nucleo.Nucleo;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class vistaVehiculo extends VistaBase {
	JLabel lbllngid=new JLabel("Lngid: ");
	JTextField txtlngid=new JTextField(5);
	JLabel lblstrplaca=new JLabel("Strplaca: ");
	JTextField txtstrplaca=new JTextField(10);
	JLabel lblflocapacidad=new JLabel("Capacidad: ");
	JTextField txtflocapacidad=new JTextField(5);
	JLabel lbldtonucleo=new JLabel("Nucleo: ");
	ComboBox cmbdtonucleo=new ComboBox(new Nucleo());

	JTextField txtstrip_creacion=new JTextField();
	JTextField txtstrip_modificacion=new JTextField();
	JTextField txtstrhost_creacion=new JTextField();
	JTextField txtstrhost_modificacion=new JTextField();
	JDateChooser  dchdtmfecha_creacion   = new JDateChooser();
	JDateChooser  dchdtmfecha_modificacion   = new JDateChooser();
	JDateChooser  dchdtmvalido_hasta   = new JDateChooser();

	public vistaVehiculo(  ActionListener controlador){
		this.setTitle("Vehiculo");
		this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid,txtlngid);
		this.txtstrplaca.addActionListener(controlador);
		this.agregar(lblstrplaca,txtstrplaca);
		this.txtflocapacidad.addActionListener(controlador);
		this.agregar(lblflocapacidad,txtflocapacidad);
		this.cmbdtonucleo.setName("cmbdtonucleo");
		this.cmbdtonucleo.addActionListener(controlador);
		this.agregar(lbldtonucleo,cmbdtonucleo);
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

		this.setSize(500,400);
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
	public JLabel getLblstrplaca(){
		return lblstrplaca;
	}
	public void setLblstrplaca(  JLabel param){
		this.lblstrplaca=param;
	}
	public JTextField getTxtstrplaca(){
		return txtstrplaca;
	}
	public void setTxtstrplaca(  JTextField param){
		this.txtstrplaca=param;
	}	
	public JLabel getLblflocapacidad() {
		return lblflocapacidad;
	}
	public void setLblflocapacidad(JLabel lblflocapacidad) {
		this.lblflocapacidad = lblflocapacidad;
	}
	public JTextField getTxtflocapacidad() {
		return txtflocapacidad;
	}
	public void setTxtflocapacidad(JTextField txtflocapacidad) {
		this.txtflocapacidad = txtflocapacidad;
	}
	public JLabel getLbldtonucleo(){
		return lbldtonucleo;
	}
	public void setLbldtonucleo(  JLabel param){
		this.lbldtonucleo=param;
	}
	public ComboBox getCmbdtonucleo(){
		return cmbdtonucleo;
	}
	public void setCmbdtonucleo(  ComboBox param){
		this.cmbdtonucleo=param;
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

