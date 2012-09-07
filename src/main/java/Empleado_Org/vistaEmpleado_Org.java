package Empleado_Org;
import Maestro.Maestro;
import Organizacion.Organizacion;
import SocioDeNegocio.SocioDeNegocio;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class vistaEmpleado_Org extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lbldto_socionegocio=new JLabel("Persona: ");
  ComboBox cmbdto_socionegocio=new ComboBox(new SocioDeNegocio());
  JLabel lbldtmingreso_org=new JLabel("Fecha Ingreso: ");
  JDateChooser dchdtmingreso_org=new JDateChooser();
  JLabel lbldtonivel_estudio=new JLabel("Nivel de Estudio: ");
  ComboBox cmbdtonivel_estudio=new ComboBox(new Maestro());
  JLabel lblstrprofesion=new JLabel("Profesion: ");
  JTextField txtstrprofesion=new JTextField(50);
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
  
  public vistaEmpleado_Org(  ActionListener controlador){
    this.setTitle("Empleado x Organización");
    
    this.txtlngid.setName("txtlngid");
	this.txtlngid.addKeyListener((KeyListener) controlador);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
    
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","width 250px,wrap 1");
    this.cmbdto_socionegocio.addActionListener(controlador);
    this.agregar(lbldto_socionegocio,cmbdto_socionegocio,"","width 250px,wrap 1");
    //this.dchdtmingreso_org.addActionListener(controlador);
    this.agregar(lbldtmingreso_org,dchdtmingreso_org,"","width 100px,wrap 1");
    
    this.cmbdtonivel_estudio.addActionListener(controlador);
    this.agregar(lbldtonivel_estudio,cmbdtonivel_estudio,"","width 250px,wrap 1");
    
    this.txtstrprofesion.setName("txtstrprofesion");
	this.txtstrprofesion.addKeyListener((KeyListener) controlador);
    this.txtstrprofesion.addActionListener(controlador);
    this.agregar(lblstrprofesion,txtstrprofesion,"","width 250px,wrap 1");
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
    this.setSize(480, 380);
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
  public JLabel getLbldto_socionegocio(){
    return lbldto_socionegocio;
  }
  public void setLbldto_socionegocio(  JLabel param){
    this.lbldto_socionegocio=param;
  }
  public ComboBox getCmbdto_socionegocio(){
    return cmbdto_socionegocio;
  }
  public void setCmbdto_socionegocio(  ComboBox param){
    this.cmbdto_socionegocio=param;
  }
  public JLabel getLbldtmingreso_org(){
    return lbldtmingreso_org;
  }
  public void setLbldtmingreso_org(  JLabel param){
    this.lbldtmingreso_org=param;
  }
  public JDateChooser getDchdtmingreso_org(){
    return dchdtmingreso_org;
  }
  public void setDchdtmingreso_org(  JDateChooser param){
    this.dchdtmingreso_org=param;
  }
  public JLabel getLbldtonivel_estudio(){
    return lbldtonivel_estudio;
  }
  public void setLbldtonivel_estudio(  JLabel param){
    this.lbldtonivel_estudio=param;
  }
  public ComboBox getCmbdtonivel_estudio(){
    return cmbdtonivel_estudio;
  }
  public void setCmbdtonivel_estudio(  ComboBox param){
    this.cmbdtonivel_estudio=param;
  }
  public JLabel getLblstrprofesion(){
    return lblstrprofesion;
  }
  public void setLblstrprofesion(  JLabel param){
    this.lblstrprofesion=param;
  }
  public JTextField getTxtstrprofesion(){
    return txtstrprofesion;
  }
  public void setTxtstrprofesion(  JTextField param){
    this.txtstrprofesion=param;
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

