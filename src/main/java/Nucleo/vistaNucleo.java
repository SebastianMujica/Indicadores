package Nucleo;

import SocioDeNegocio.SocioDeNegocio;
import SubZona.SubZona;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import Zona.Zona;

import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaNucleo extends VistaBase {
	JLabel lbllngid=new JLabel("Lngid: ");
	JTextField txtlngid=new JTextField();
	JLabel lbldtosocio=new JLabel("Dtosocio: ");
	ComboBox cmbdtosocio=new ComboBox(new SocioDeNegocio());
	JLabel lbldtozona=new JLabel("Zona: ");
	ComboBox cmbdtozona=new ComboBox(new Zona());
	JLabel lbldtosubzona=new JLabel("SubZona: ");
	ComboBox cmbdtosubzona=new ComboBox(new SubZona());
	/*JLabel lbldtosocio=new JLabel("Dtosocio: ");
  ComboBox cmbdtosocio=new ComboBox(new SocioDeNegocio());*/
	
	JTextField txtstrip_creacion=new JTextField();
	JTextField txtstrip_modificacion=new JTextField();
	JTextField txtstrhost_creacion=new JTextField();
	JTextField txtstrhost_modificacion=new JTextField();
	JDateChooser  dchdtmfecha_creacion   = new JDateChooser();
	JDateChooser  dchdtmfecha_modificacion   = new JDateChooser();
	JDateChooser  dchdtmvalido_hasta   = new JDateChooser();
	
	public vistaNucleo(  ActionListener controlador){
		this.setTitle("Nucleo");
		this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid,txtlngid);

		this.cmbdtosocio.setName("cmbDtosocio");
		this.cmbdtosocio.addActionListener(controlador);
		this.agregar(lbldtosocio,cmbdtosocio);

		this.cmbdtozona.setName("cmbDtozona");
		this.cmbdtosubzona.setName("cmbDtosubzona");

		this.cmbdtozona.addActionListener(controlador);
		this.agregar(this.lbldtozona, this.cmbdtozona);
		this.cmbdtosubzona.addActionListener(controlador);
		this.agregar(this.lbldtosubzona, this.cmbdtosubzona);

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
	    
		this.setSize(500, 300);
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
	public JLabel getLbldtozona() {
		return lbldtozona;
	}
	public void setLbldtozona(JLabel lbldtozona) {
		this.lbldtozona = lbldtozona;
	}
	public ComboBox getCmbdtozona() {
		return cmbdtozona;
	}
	public void setCmbdtozona(ComboBox cmbdtozona) {
		this.cmbdtozona = cmbdtozona;
	}
	public JLabel getLbldtosubzona() {
		return lbldtosubzona;
	}
	public void setLbldtosubzona(JLabel lbldtosubzona) {
		this.lbldtosubzona = lbldtosubzona;
	}
	public ComboBox getCmbdtosubzona() {
		return cmbdtosubzona;
	}
	public void setCmbdtosubzona(ComboBox cmbdtosubzona) {
		this.cmbdtosubzona = cmbdtosubzona;
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

