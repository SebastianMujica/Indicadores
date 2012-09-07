package Indicador;
import groovy.ui.ConsoleTextEditor;

import Maestro.Maestro;
import Meta_Org.Meta_Org;
import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import UnidadDeMedida.UnidadDeMedida;
import Variable.Variable;
import VariableIndicador.VariableIndicador;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class vistaIndicador extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldto_org=new JLabel("Organizacion: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lblstrcodigo=new JLabel("Código: ");
  JTextField txtstrcodigo=new JTextField(20);
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField(50);
  JLabel lblstrproposito=new JLabel("Propósito: ");
  JTextField txtstrproposito=new JTextField(255);
  JLabel lblstrcalculo=new JLabel("Cálculo: ");
  JTextField txtstrcalculo=new JTextField(255);
  JLabel lblstrcaracterista=new JLabel("Característica: ");
  JTextField txtstrcaracterista=new JTextField(255);
  JLabel lbldto_unidadmedida=new JLabel("Unidad de Medida: ");
  ComboBox cmbdto_unidadmedida=new ComboBox(new UnidadDeMedida());
  JLabel lbldto_frecuencia_carga=new JLabel("Frecuencia de Carga: ");
  ComboBox cmbdto_frecuencia_carga=new ComboBox(new UnidadDeMedida());
  JLabel lbldtocategoria=new JLabel("Categoría: ");
  ComboBox cmbdtocategoria=new ComboBox(new Maestro());
  JLabel lblflovalor_minimo=new JLabel("Valor Mínimo: ");
  JTextField txtflovalor_minimo=new JTextField(20);
  JLabel lblflovalor_maximo=new JLabel("Valor Máximo: ");
  JTextField txtflovalor_maximo=new JTextField(20);
  /*JLabel lbldto_meta_org=new JLabel("Meta: ");
  ComboBox cmbdto_meta_org=new ComboBox(new Meta_Org());*/
  
  // Correspondiente a lo de la Formula
  ListaDoble lstdtovariable=new ListaDoble("Variables",new Variable());
  
  JLabel lblstrformula=new JLabel("Fórmula: ");
  ConsoleTextEditor txtstrformula=new ConsoleTextEditor();
  //JTextPane paneTxt=new JTextPane();
  JButton btndeshacer=new JButton("deshacer");
  JButton btnrehacer=new JButton("rehacer");
  JButton btnrun=new JButton("probar");
  // Correspondiente a lo de la Formula  
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
  
  public vistaIndicador(  ActionListener controlador){
     
	  this.setSize(800,550);
	  //this.setResizable(false);
    //this.getForm().setLayoutConstraints("debug");

	this.setTitle("Indicador");
	this.txtlngid.setName("txtlngid");
	this.txtlngid.addKeyListener((KeyListener) controlador);
	this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","");
    
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","growx,wrap 1");
    
    this.txtstrcodigo.setName("txtstrcodigo");
	this.txtstrcodigo.addKeyListener((KeyListener) controlador);
    this.txtstrcodigo.addActionListener(controlador);
    this.agregar(lblstrcodigo,txtstrcodigo,"","");
    
    this.txtstrnombre.setName("txtstrnombre");
	this.txtstrnombre.addKeyListener((KeyListener) controlador);
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","wrap 1");
    
    this.txtstrproposito.setName("txtstrproposito");
	this.txtstrproposito.addKeyListener((KeyListener) controlador);
    this.txtstrproposito.addActionListener(controlador);
    this.agregar(lblstrproposito,txtstrproposito,"","span 3,wrap 1");
    
    this.txtstrcalculo.setName("txtstrcalculo");
	this.txtstrcalculo.addKeyListener((KeyListener) controlador);
    this.txtstrcalculo.addActionListener(controlador);
    this.agregar(lblstrcalculo,txtstrcalculo,"","span 3,wrap 1");
    
    this.txtstrcaracterista.setName("txtstrcaracterista");
	this.txtstrcaracterista.addKeyListener((KeyListener) controlador);
    this.txtstrcaracterista.addActionListener(controlador);
    this.agregar(lblstrcaracterista,txtstrcaracterista,"","span 3,wrap 1");
    
    this.cmbdtocategoria.addActionListener(controlador);
    this.agregar(lbldtocategoria,cmbdtocategoria,"","");
    this.cmbdto_unidadmedida.addActionListener(controlador);
    this.agregar(lbldto_unidadmedida,cmbdto_unidadmedida,"","growx,wrap 1");
    
    this.txtflovalor_minimo.setName("txtflovalor_minimo");
	this.txtflovalor_minimo.addKeyListener((KeyListener) controlador);
    this.txtflovalor_minimo.addActionListener(controlador);
    this.agregar(lblflovalor_minimo,txtflovalor_minimo,"","");
    
    this.txtflovalor_maximo.setName("txtflovalor_maximo");
	this.txtflovalor_maximo.addKeyListener((KeyListener) controlador);
    this.txtflovalor_maximo.addActionListener(controlador);
    this.agregar(lblflovalor_maximo,txtflovalor_maximo,"","wrap 1");

    this.agregar(lblbolactivo,chkbolactivo,"","");
    this.agregar(lbldto_frecuencia_carga,cmbdto_frecuencia_carga,"","growx,wrap 1");
        
    this.agregar(lstdtovariable,"growx,span 2 3");
    this.agregar(lblstrformula,"span 2,align left,wrap 1");
    this.agregar(txtstrformula,"height 150px,growx,span 2,wrap 1");
    
    this.btndeshacer.addActionListener(controlador);
	this.agregar(btndeshacer,"span 2, split 3,align center");
	this.btnrehacer.addActionListener(controlador);
	this.agregar(btnrehacer,"");    
    this.btnrun.addActionListener(controlador);
    this.agregar(btnrun,"wrap 1");
    
    //this.agregar(lblbolactivo, chkbolactivo, "", "width 150px,wrap 1");
    
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
  public JLabel getLblstrproposito(){
    return lblstrproposito;
  }
  public void setLblstrproposito(  JLabel param){
    this.lblstrproposito=param;
  }
  public JTextField getTxtstrproposito(){
    return txtstrproposito;
  }
  public void setTxtstrproposito(  JTextField param){
    this.txtstrproposito=param;
  }
  public JLabel getLblstrcalculo(){
    return lblstrcalculo;
  }
  public void setLblstrcalculo(  JLabel param){
    this.lblstrcalculo=param;
  }
  public JTextField getTxtstrcalculo(){
    return txtstrcalculo;
  }
  public void setTxtstrcalculo(  JTextField param){
    this.txtstrcalculo=param;
  }
  public JLabel getLblstrcaracterista(){
    return lblstrcaracterista;
  }
  public void setLblstrcaracterista(  JLabel param){
    this.lblstrcaracterista=param;
  }
  public JTextField getTxtstrcaracterista(){
    return txtstrcaracterista;
  }
  public void setTxtstrcaracterista(  JTextField param){
    this.txtstrcaracterista=param;
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
public JLabel getLbldto_frecuencia_carga() {
	return lbldto_frecuencia_carga;
}
public void setLbldto_frecuencia_carga(JLabel lbldtoFrecuenciaCarga) {
	lbldto_frecuencia_carga = lbldtoFrecuenciaCarga;
}
public ComboBox getCmbdto_frecuencia_carga() {
	return cmbdto_frecuencia_carga;
}
public void setCmbdto_frecuencia_carga(ComboBox cmbdtoFrecuenciaCarga) {
	cmbdto_frecuencia_carga = cmbdtoFrecuenciaCarga;
}
public JLabel getLblstrformula(){
    return lblstrformula;
  }
  public void setLblstrformula(  JLabel param){
    this.lblstrformula=param;
  }

  public ConsoleTextEditor getTxtstrformula() {
	return txtstrformula;
}
public void setTxtstrformula(ConsoleTextEditor txtstrformula) {
	this.txtstrformula = txtstrformula;
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
  public JLabel getLblflopvalor_maximo(){
    return lblflovalor_maximo;
  }
  public void setLblflovalor_maximo(  JLabel param){
    this.lblflovalor_maximo=param;
  }
  public JTextField getTxtflopvalor_maximo(){
    return txtflovalor_maximo;
  }
  public void setTxtflopvalor_maximo(  JTextField param){
    this.txtflovalor_maximo=param;
  }
  
public JLabel getLbldto_unidadmedida() {
	return lbldto_unidadmedida;
}
public void setLbldto_unidadmedida(JLabel lbldtoUnidadmedida) {
	lbldto_unidadmedida = lbldtoUnidadmedida;
}
public ComboBox getCmbdto_unidadmedida() {
	return cmbdto_unidadmedida;
}
public void setCmbdto_unidadmedida(ComboBox cmbdtoUnidadmedida) {
	cmbdto_unidadmedida = cmbdtoUnidadmedida;
}
public ListaDoble getLstdtovariable() {
	return lstdtovariable;
}
public void setLstdtovariable(ListaDoble lstdtovariable) {
	this.lstdtovariable = lstdtovariable;
}
public JButton getBtndeshacer() {
	return btndeshacer;
}
public void setBtndeshacer(JButton btndeshacer) {
	this.btndeshacer = btndeshacer;
}
public JButton getBtnrehacer() {
	return btnrehacer;
}
public void setBtnrehacer(JButton btnrehacer) {
	this.btnrehacer = btnrehacer;
}
public JButton getBtnrun() {
	return btnrun;
}
public void setBtnrun(JButton btnrun) {
	this.btnrun = btnrun;
}
public JLabel getLbldtocategoria() {
	return lbldtocategoria;
}
public void setLbldtocategoria(JLabel lbldtoCategoria) {
	lbldtocategoria = lbldtoCategoria;
}
public ComboBox getCmbdtocategoria() {
	return cmbdtocategoria;
}
public void setCmbdtocategoria(ComboBox cmbdtoCategoria) {
	cmbdtocategoria = cmbdtoCategoria;
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
public JTextField getTxtflovalor_maximo() {
	return txtflovalor_maximo;
}
public void setTxtflovalor_maximo(JTextField txtflovalorMaximo) {
	txtflovalor_maximo = txtflovalorMaximo;
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
/*public JLabel getLbldto_meta_org() {
	return lbldto_meta_org;
}
public void setLbldto_meta_org(JLabel lbldtoMetaOrg) {
	lbldto_meta_org = lbldtoMetaOrg;
}
public ComboBox getCmbdto_meta_org() {
	return cmbdto_meta_org;
}
public void setCmbdto_meta_org(ComboBox cmbdtoMetaOrg) {
	cmbdto_meta_org = cmbdtoMetaOrg;
}*/
public JLabel getLblflovalor_maximo() {
	return lblflovalor_maximo;
}
}
