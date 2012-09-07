package VariableIndicador;
import java.util.*;

import Maestro.Maestro;
import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import UnidadDeMedida.UnidadDeMedida;

import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaVariableIndicador extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  
  JLabel lblstrcodigo=new JLabel("Código: ");
  JTextField txtstrcodigo=new JTextField(20);
  
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField(50);
  
  JLabel lblstrdescripcion=new JLabel("Descripción: ");
  JTextField txtstrdescripcion=new JTextField(255);
  
  JLabel lbldto_unidad_medida=new JLabel("Unidad de Medida: ");
  ComboBox cmbdto_unidad_medida=new ComboBox(new UnidadDeMedida());
  
  JLabel lblflovalor_minimo=new JLabel("Valor Mínimo: ");
  JTextField txtflovalor_minimo=new JTextField(20);
  
  JLabel lblflovalor_maximo=new JLabel("Valor Máximo: ");
  JTextField txtflovalor_maximo=new JTextField(20);
  
  JLabel lbldto_categoria=new JLabel("Categoría: ");
  ComboBox cmbdto_categoria=new ComboBox(new Maestro());
  
  JLabel lblstrtipo_dato=new JLabel("Tipo de Dato: ");
  JTextField txtstrtipo_dato=new JTextField(20);
  
  JLabel lbllngnum_decimales=new JLabel("Nro. Decimales: ");
  JTextField txtlngnum_decimales=new JTextField(2);
  
  JLabel lblstrformato_presente=new JLabel("Formato: ");
  JTextField txtstrformato_presente=new JTextField(255);
  
  JLabel lbllngtamano=new JLabel("Tamaño: ");
  JTextField txtlngtamano=new JTextField(2);
  
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
  
  public vistaVariableIndicador(  ActionListener controlador){
    this.setTitle("Variables");
    
    this.txtlngid.setName("txtlngid");
	this.txtlngid.addKeyListener((KeyListener) controlador);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 150px,wrap");
    
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","width 250px,wrap");
    
    this.txtstrcodigo.setName("txtstrcodigo");
	this.txtstrcodigo.addKeyListener((KeyListener) controlador);
    this.txtstrcodigo.addActionListener(controlador);
    this.agregar(lblstrcodigo,txtstrcodigo,"","width 150px,wrap");
    
    this.txtstrnombre.setName("txtstrnombre");
	this.txtstrnombre.addKeyListener((KeyListener) controlador);
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","width 280px,wrap");
    
    this.txtstrdescripcion.setName("txtstrdescripcion");
	this.txtstrdescripcion.addKeyListener((KeyListener) controlador);
    this.txtstrdescripcion.addActionListener(controlador);
    this.agregar(lblstrdescripcion,txtstrdescripcion,"","growx,width 280px,wrap");
    
    this.txtflovalor_minimo.setName("txtflovalor_minimo");
	this.txtflovalor_minimo.addKeyListener((KeyListener) controlador);
    this.txtflovalor_minimo.addActionListener(controlador);
    this.agregar(lblflovalor_minimo,txtflovalor_minimo,"","width 80px,wrap");
    
    this.txtflovalor_maximo.setName("txtflovalor_maximo");
	this.txtflovalor_maximo.addKeyListener((KeyListener) controlador);
    this.txtflovalor_maximo.addActionListener(controlador);
    this.agregar(lblflovalor_maximo,txtflovalor_maximo,"","width 80px,wrap");
    
    this.cmbdto_unidad_medida.addActionListener(controlador);
    this.agregar(lbldto_unidad_medida,cmbdto_unidad_medida,"","width 250px,wrap");
    
    this.cmbdto_categoria.addActionListener(controlador);
    this.agregar(lbldto_categoria,cmbdto_categoria,"","width 250px,wrap");
    
    this.txtstrtipo_dato.setName("txtstrtipo_dato");
	this.txtstrtipo_dato.addKeyListener((KeyListener) controlador);
    this.txtstrtipo_dato.addActionListener(controlador);
    this.agregar(lblstrtipo_dato,txtstrtipo_dato,"","width 150px,wrap");
    
    this.txtlngnum_decimales.setName("txtlngnum_decimales");
	this.txtlngnum_decimales.addKeyListener((KeyListener) controlador);
    this.txtlngnum_decimales.addActionListener(controlador);
    this.agregar(lbllngnum_decimales,txtlngnum_decimales,"","width 100px,wrap");
    
    this.txtstrformato_presente.setName("txtstrformato_presente");
	this.txtstrformato_presente.addKeyListener((KeyListener) controlador);
    this.txtstrformato_presente.addActionListener(controlador);
    this.agregar(lblstrformato_presente,txtstrformato_presente,"","width 100px,wrap");
    
    this.txtlngtamano.setName("txtlngtamano");
	this.txtlngtamano.addKeyListener((KeyListener) controlador);
    this.txtlngtamano.addActionListener(controlador);
    this.agregar(lbllngtamano,txtlngtamano,"","width 100px,wrap");
    
    this.chkbolactivo.setName("chkbolactivo");
    this.chkbolactivo.addActionListener(controlador);
    this.agregar(lblbolactivo,chkbolactivo,"","width 50px,wrap");
    
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
    this.setSize(500, 500);
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
  
  public JLabel getLbldto_org() {
	return lbldto_org;
}
public void setLbldto_org(JLabel lbldtoOrg) {
	lbldto_org = lbldtoOrg;
}
public ComboBox getCmbdto_org() {
	return cmbdto_org;
}
public void setCmbdto_org(ComboBox cmbdtoOrg) {
	cmbdto_org = cmbdtoOrg;
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
public void setTxtflovalor_maximo(JTextField txtflovalorMaximo) {
	txtflovalor_maximo = txtflovalorMaximo;
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
  public void setTxtflopvalor_maximo(  JTextField param){
    this.txtflovalor_maximo=param;
  }
  public JLabel getLblstrtipo_dato(){
    return lblstrtipo_dato;
  }
  public void setLblstrtipo_dato(  JLabel param){
    this.lblstrtipo_dato=param;
  }
  public JTextField getTxtstrtipo_dato(){
    return txtstrtipo_dato;
  }
  public void setTxtstrtipo_dato(  JTextField param){
    this.txtstrtipo_dato=param;
  }
  public JLabel getLbllngnum_decimales(){
    return lbllngnum_decimales;
  }
  public void setLbllngnum_decimales(  JLabel param){
    this.lbllngnum_decimales=param;
  }
  public JTextField getTxtlngnum_decimales(){
    return txtlngnum_decimales;
  }
  public void setTxtlngnum_decimales(  JTextField param){
    this.txtlngnum_decimales=param;
  }
  public JLabel getLblstrformato_presente(){
    return lblstrformato_presente;
  }
  public void setLblstrformato_presente(  JLabel param){
    this.lblstrformato_presente=param;
  }
  public JTextField getTxtstrformato_presente(){
    return txtstrformato_presente;
  }
  public void setTxtstrformato_presente(  JTextField param){
    this.txtstrformato_presente=param;
  }
  public JLabel getLbllngtamano(){
    return lbllngtamano;
  }
  public void setLbllngtamano(  JLabel param){
    this.lbllngtamano=param;
  }
  public JTextField getTxtlngtamano(){
    return txtlngtamano;
  }
  public void setTxtlngtamano(  JTextField param){
    this.txtlngtamano=param;
  }
public JLabel getLbldto_categoria() {
	return lbldto_categoria;
}
public void setLbldto_categoria(JLabel lbldtoCategoria) {
	lbldto_categoria = lbldtoCategoria;
}
public ComboBox getCmbdto_categoria() {
	return cmbdto_categoria;
}
public void setCmbdto_categoria(ComboBox cmbdtoCategoria) {
	cmbdto_categoria = cmbdtoCategoria;
}
public JLabel getLbldto_unidad_medida() {
	return lbldto_unidad_medida;
}
public void setLbldto_unidad_medida(JLabel lbldtoUnidadMedida) {
	lbldto_unidad_medida = lbldtoUnidadMedida;
}
public ComboBox getCmbdto_unidad_medida() {
	return cmbdto_unidad_medida;
}
public void setCmbdto_unidad_medida(ComboBox cmbdtoUnidadMedida) {
	cmbdto_unidad_medida = cmbdtoUnidadMedida;
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
  
/*public JLabel getLbldtoindicador() {
	return lbldtoindicador;
}
public void setLbldtoindicador(JLabel lbldtoindicador) {
	this.lbldtoindicador = lbldtoindicador;
}
public ComboBox getCmbdtoindicador() {
	return cmbdtoindicador;
}
public void setCmbdtoindicador(ComboBox cmbdtoindicador) {
	this.cmbdtoindicador = cmbdtoindicador;
}*/
}

