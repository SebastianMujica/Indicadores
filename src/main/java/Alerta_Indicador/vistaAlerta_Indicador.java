package Alerta_Indicador;
import java.util.*;

import Indicador.Indicador;
import Organizacion.Organizacion;
import Periodo.Periodo;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaAlerta_Indicador extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lbldto_periodo=new JLabel("Período: ");
  ComboBox cmbdto_periodo=new ComboBox(new Periodo());
  JLabel lbldto_indicador=new JLabel("Indicador: ");
  ComboBox cmbdto_indicador=new ComboBox(new Indicador());
  JLabel lblflovalor_minimo=new JLabel("Valor Mínimo: ");
  JTextField txtflovalor_minimo=new JTextField(15);
  JLabel lblflovalor_maximo=new JLabel("Valor Máximo: ");
  JTextField txtflovalor_maximo=new JTextField(15);
  JLabel lblstrcolor_id=new JLabel("Color Id: ");
  JTextField txtstrcolor_id=new JTextField(15);
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
	
  public vistaAlerta_Indicador(  ActionListener controlador){
    this.setTitle("Alerta Indicador");
    
    this.txtlngid.setName("txtlngid");
    this.txtlngid.addKeyListener((KeyListener) controlador);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
    
    this.cmbdto_org.setName("cmbdto_org");
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","growx,width 250px,wrap 1");
    
    this.cmbdto_periodo.setName("cmbdto_periodo");
    this.cmbdto_periodo.addActionListener(controlador);
    this.agregar(lbldto_periodo,cmbdto_periodo,"","growx,width 250px,wrap 1");
    
    this.cmbdto_indicador.setName("cmbdto_indicador");
    this.cmbdto_indicador.addActionListener(controlador);
    this.agregar(lbldto_indicador,cmbdto_indicador,"","growx,width 250px,wrap 1");
    
    this.txtflovalor_minimo.setName("txtflovalor_minimo");
    this.txtflovalor_minimo.addKeyListener((KeyListener) controlador);
    this.txtflovalor_minimo.addActionListener(controlador);
    this.agregar(lblflovalor_minimo,txtflovalor_minimo,"","width 120px,wrap 1");
    
    this.txtflovalor_maximo.setName("txtflovalor_maximo");
    this.txtflovalor_maximo.addKeyListener((KeyListener) controlador);
    this.txtflovalor_maximo.addActionListener(controlador);
    this.agregar(lblflovalor_maximo,txtflovalor_maximo,"","width 120px,wrap 1");
    
    this.txtstrcolor_id.setName("txtstrcolor_id");
    this.txtstrcolor_id.addKeyListener((KeyListener) controlador);
    this.txtstrcolor_id.addActionListener(controlador);
    this.agregar(lblstrcolor_id,txtstrcolor_id,"","width 120px,wrap 1");
    
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
    this.setSize(500, 380);
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
  public JLabel getLbldto_periodo(){
    return lbldto_periodo;
  }
  public void setLbldto_periodo(  JLabel param){
    this.lbldto_periodo=param;
  }
  public ComboBox getCmbdto_periodo(){
    return cmbdto_periodo;
  }
  public void setCmbdto_periodo(  ComboBox param){
    this.cmbdto_periodo=param;
  }
  public JLabel getLbldto_indicador(){
    return lbldto_indicador;
  }
  public void setLbldto_indicador(  JLabel param){
    this.lbldto_indicador=param;
  }
  public ComboBox getCmbdto_indicador(){
    return cmbdto_indicador;
  }
  public void setCmbdto_indicador(  ComboBox param){
    this.cmbdto_indicador=param;
  }
  public JLabel getLblflovalor_minimo(){
    return lblflovalor_minimo;
  }
  public void setLblflovalor_minimo(  JLabel param){
    this.lblflovalor_minimo=param;
  }
  public JTextField getTxtflovalor_minimo(){
    return txtflovalor_minimo;
  }
  public void setTxtflovalor_minimo(  JTextField param){
    this.txtflovalor_minimo=param;
  }
  public JLabel getLblflovalor_maximo(){
    return lblflovalor_maximo;
  }
  public void setLblflovalor_maximo(  JLabel param){
    this.lblflovalor_maximo=param;
  }
  public JTextField getTxtflovalor_maximo(){
    return txtflovalor_maximo;
  }
  public void setTxtflovalor_maximo(  JTextField param){
    this.txtflovalor_maximo=param;
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
}

