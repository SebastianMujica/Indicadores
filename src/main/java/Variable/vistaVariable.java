package Variable;
import groovy.ui.ConsoleTextEditor;

import java.util.*;

import Maestro.Maestro;
import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import UnidadDeMedida.UnidadDeMedida;

import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaVariable extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lblstrcodigo=new JLabel("Código: ");
  JTextField txtstrcodigo=new JTextField(50);
  JLabel lbldtocategoria=new JLabel("Categoría: ");
  ComboBox cmbdtocategoria=new ComboBox(new Maestro());
  
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField(50);
  JLabel lblstrdescripcion=new JLabel("Descripción: ");
  JTextField txtstrdescripcion=new JTextField(255);
  JLabel lbldtounidad_medida=new JLabel("Unidad de Medida: ");
  ComboBox cmbdtounidad_medida=new ComboBox(new UnidadDeMedida());
  
  JLabel lblflovalor_minimo=new JLabel("Valor Mínimo: ");
  JTextField txtflovalor_minimo=new JTextField(20);
  
  JLabel lblflovalor_maximo=new JLabel("Valor Máximo: ");
  JTextField txtflovalor_maximo=new JTextField(20);
  
  JLabel lbldtotipo_dato=new JLabel("Tipo Dato: ");
  ComboBox cmbdtotipo_dato=new ComboBox(new Maestro());
  
  JLabel lbllngnum_decimales=new JLabel("Nro. Decimales: ");
  JTextField txtlngnum_decimales=new JTextField(2);
  
  JLabel lblstrformato_presente=new JLabel("Formato: ");
  JTextField txtstrformato_presente=new JTextField(255);
  
  JLabel lbllngtamano=new JLabel("Tamaño: ");
  JTextField txtlngtamano=new JTextField(2);
  
  JLabel lblstrformula=new JLabel("Formula: ");
  ConsoleTextEditor txtstrformula=new ConsoleTextEditor();
  //JTextPane paneTxt=new JTextPane();
  JButton btndeshacer=new JButton("deshacer");
  JButton btnrehacer=new JButton("rehacer");
  JButton btnrun=new JButton("probar");
  JLabel lblbolactivo=new JLabel("Activo: ");
  JCheckBox chkbolactivo=new JCheckBox();
  
  JLabel lblstrbase_datos=new JLabel("Base Datos: ");
  JTextField txtstrbase_datos=new JTextField(50);
  JLabel lblstrpuerto_bd=new JLabel("Puerto: ");
  JTextField txtstrpuerto_bd=new JTextField(50);
  JLabel lblstrusuario_bd=new JLabel("Usuario: ");
  JTextField txtstrusuario_bd=new JTextField(50);
  JLabel lblstrpwd_bd=new JLabel("Contraseña: ");
  JTextField txtstrpwd_bd=new JTextField(50);
  
  JLabel lblstrtabla=new JLabel("Entidad: ");
  JTextField txtstrtabla=new JTextField(50);
  JLabel lblstrcolumna=new JLabel("Propiedad: ");
  JTextField txtstrcolumna=new JTextField(50);
  JLabel lblstrclase=new JLabel("Clase: ");
  JTextField txtstrclase=new JTextField(50);
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
  
  public vistaVariable(  ActionListener controlador){
    this.setTitle("Variable");
    this.setSize(750, 590);
    //this.getForm().setLayoutConstraints("debug");
    
    this.txtlngid.setName("txtlngid");
	this.txtlngid.addKeyListener((KeyListener) controlador);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
    
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","width 250px");
    this.cmbdtocategoria.addActionListener(controlador);
    this.agregar(lbldtocategoria,cmbdtocategoria,"","width 250px,wrap 1");
    
    this.txtstrcodigo.setName("txtstrcodigo");
    this.txtstrcodigo.addKeyListener((KeyListener) controlador);
    this.txtstrcodigo.addActionListener(controlador);
    this.agregar(lblstrcodigo,txtstrcodigo,"","width 200px");
    this.txtstrnombre.setName("txtstrnombre");
    this.txtstrnombre.addKeyListener((KeyListener) controlador);
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","growx,width 200px,wrap 1");
    
    this.txtstrdescripcion.setName("txtstrdescripcion");
    this.txtstrdescripcion.addKeyListener((KeyListener) controlador);
    this.txtstrdescripcion.addActionListener(controlador);
    this.agregar(lblstrdescripcion,"");
    this.agregar(txtstrdescripcion, "span 3,growx,wrap 1");
    
    this.txtflovalor_minimo.setName("txtflovalor_minimo");
    this.txtflovalor_minimo.addKeyListener((KeyListener) controlador);
    this.txtflovalor_minimo.addActionListener(controlador);
    this.agregar(lblflovalor_minimo,txtflovalor_minimo,"","width 150px");
    this.txtflovalor_maximo.setName("txtflovalor_maximo");
    this.txtflovalor_maximo.addKeyListener((KeyListener) controlador);
    this.txtflovalor_maximo.addActionListener(controlador);
    this.agregar(lblflovalor_maximo,txtflovalor_maximo,"","width 150px,wrap 1");
    
    this.cmbdtounidad_medida.addActionListener(controlador);
    this.agregar(lbldtounidad_medida,cmbdtounidad_medida,"","growx,width 250px");
    this.cmbdtotipo_dato.addActionListener(controlador);
    this.agregar(lbldtotipo_dato,cmbdtotipo_dato,"","width 250px,wrap 1");
    
    this.txtlngtamano.setName("txtlngtamano");
    this.txtlngtamano.addKeyListener((KeyListener) controlador);
    this.txtlngtamano.addActionListener(controlador);
    this.agregar(lbllngtamano,txtlngtamano,"","width 100px");
    this.txtlngnum_decimales.setName("txtlngnum_decimales");
    this.txtlngnum_decimales.addKeyListener((KeyListener) controlador);
    this.txtlngnum_decimales.addActionListener(controlador);
    this.agregar(lbllngnum_decimales,txtlngnum_decimales,"","width 100px,wrap 1");
    
    this.chkbolactivo.setName("chkbolactivo");
    this.chkbolactivo.addActionListener(controlador);
    this.agregar(lblbolactivo,chkbolactivo,"","width 50px");
    this.txtstrformato_presente.setName("txtstrformato_presente");
    this.txtstrformato_presente.addKeyListener((KeyListener) controlador);
    this.txtstrformato_presente.addActionListener(controlador);
    this.agregar(lblstrformato_presente,txtstrformato_presente,"","growx,width 100px,wrap 3");
    
    this.txtstrbase_datos.setName("txtstrbase_datos");
    this.txtstrbase_datos.addKeyListener((KeyListener) controlador);
    this.txtstrbase_datos.addActionListener(controlador);
    this.agregar(lblstrbase_datos,txtstrbase_datos,"span 4,split 8,align center","width 100px");
    this.txtstrpuerto_bd.setName("txtstrpuerto_bd");
    this.txtstrpuerto_bd.addKeyListener((KeyListener) controlador);
    this.txtstrpuerto_bd.addActionListener(controlador);
    this.agregar(lblstrpuerto_bd,txtstrpuerto_bd,"","width 50px");
    this.txtstrusuario_bd.setName("txtstrusuario_bd");
    this.txtstrusuario_bd.addKeyListener((KeyListener) controlador);
    this.txtstrusuario_bd.addActionListener(controlador);
    this.agregar(lblstrusuario_bd,txtstrusuario_bd,"","width 80px");
    this.txtstrpwd_bd.setName("txtstrpwd_bd");
    this.txtstrpwd_bd.addKeyListener((KeyListener) controlador);
    this.txtstrpwd_bd.addActionListener(controlador);
    this.agregar(lblstrpwd_bd,txtstrpwd_bd,"","width 80px,wrap 1");
    
    
    this.txtstrtabla.setName("txtstrtabla");
    this.txtstrtabla.addKeyListener((KeyListener) controlador);
    this.txtstrtabla.addActionListener(controlador);
    this.agregar(lblstrtabla,txtstrtabla,"span 4,split 6,align center","width 120px");
    this.txtstrcolumna.setName("txtstrcolumna");
    this.txtstrcolumna.addKeyListener((KeyListener) controlador);
    this.txtstrcolumna.addActionListener(controlador);
    this.agregar(lblstrcolumna,txtstrcolumna,"","width 120px");
    this.txtstrclase.setName("txtstrclase");
    this.txtstrclase.addKeyListener((KeyListener) controlador);
    this.txtstrclase.addActionListener(controlador);
    this.agregar(lblstrclase,txtstrclase,"","width 120px,wrap 1");
 
    this.agregar(lblstrformula,txtstrformula,"","width 800px,height 400px,span 3");
    this.agregar(btndeshacer,"cell 1 11, split 3,align center");
    this.agregar(btnrehacer,"");
    this.agregar(btnrun,"wrap 1");
    this.btnrehacer.addActionListener(controlador);
    this.btndeshacer.addActionListener(controlador);
    this.btnrun.addActionListener(controlador);
    
 
    
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
  public JLabel getLblstrtabla(){
    return lblstrtabla;
  }
  public void setLblstrtabla(  JLabel param){
    this.lblstrtabla=param;
  }
  public JTextField getTxtstrtabla(){
    return txtstrtabla;
  }
  public void setTxtstrtabla(  JTextField param){
    this.txtstrtabla=param;
  }
  public JLabel getLblstrcolumna(){
    return lblstrcolumna;
  }
  public void setLblstrcolumna(  JLabel param){
    this.lblstrcolumna=param;
  }
  public JTextField getTxtstrcolumna(){
    return txtstrcolumna;
  }
  public void setTxtstrcolumna(  JTextField param){
    this.txtstrcolumna=param;
  }
public JLabel getLblstrclase() {
	return lblstrclase;
}
public void setLblstrclase(JLabel lblstrclase) {
	this.lblstrclase = lblstrclase;
}
public JTextField getTxtstrclase() {
	return txtstrclase;
}
public void setTxtstrclase(JTextField txtstrclase) {
	this.txtstrclase = txtstrclase;
}
public JLabel getLblstrformula() {
	return lblstrformula;
}
public void setLblstrformula(JLabel lblstrformula) {
	this.lblstrformula = lblstrformula;
}
public ConsoleTextEditor getTxtstrformula() {
	return txtstrformula;
}
public void setTxtstrformula(ConsoleTextEditor txtstrformula) {
	this.txtstrformula = txtstrformula;
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
public JLabel getLbldtounidad_medida() {
	return lbldtounidad_medida;
}
public void setLbldtounidad_medida(JLabel lbldtounidadMedida) {
	lbldtounidad_medida = lbldtounidadMedida;
}
public ComboBox getCmbdtounidad_medida() {
	return cmbdtounidad_medida;
}
public void setCmbdtounidad_medida(ComboBox cmbdtounidadMedida) {
	cmbdtounidad_medida = cmbdtounidadMedida;
}
public JLabel getLblflovalor_minimo() {
	return lblflovalor_minimo;
}
public void setLblflovalor_minimo(JLabel lblflovalorMinimo) {
	lblflovalor_minimo = lblflovalorMinimo;
}
public JTextField getTxtflovalor_minimo() {
	return txtflovalor_minimo;
}
public void setTxtflovalor_minimo(JTextField txtflovalorMinimo) {
	txtflovalor_minimo = txtflovalorMinimo;
}
public JLabel getLblflovalor_maximo() {
	return lblflovalor_maximo;
}
public void setLblflovalor_maximo(JLabel lblflovalorMaximo) {
	lblflovalor_maximo = lblflovalorMaximo;
}
public JTextField getTxtflovalor_maximo() {
	return txtflovalor_maximo;
}
public void setTxtflovalor_maximo(JTextField txtflovalorMaximo) {
	txtflovalor_maximo = txtflovalorMaximo;
}

public ComboBox getCmbdtotipo_dato() {
	return cmbdtotipo_dato;
}
public void setCmbdtotipo_dato(ComboBox cmbdtotipoDato) {
	cmbdtotipo_dato = cmbdtotipoDato;
}
public JLabel getLbllngnum_decimales() {
	return lbllngnum_decimales;
}
public void setLbllngnum_decimales(JLabel lbllngnumDecimales) {
	lbllngnum_decimales = lbllngnumDecimales;
}
public JTextField getTxtlngnum_decimales() {
	return txtlngnum_decimales;
}
public void setTxtlngnum_decimales(JTextField txtlngnumDecimales) {
	txtlngnum_decimales = txtlngnumDecimales;
}
public JLabel getLblstrformato_presente() {
	return lblstrformato_presente;
}
public void setLblstrformato_presente(JLabel lblstrformatoPresente) {
	lblstrformato_presente = lblstrformatoPresente;
}
public JTextField getTxtstrformato_presente() {
	return txtstrformato_presente;
}
public void setTxtstrformato_presente(JTextField txtstrformatoPresente) {
	txtstrformato_presente = txtstrformatoPresente;
}
public JLabel getLbllngtamano() {
	return lbllngtamano;
}
public void setLbllngtamano(JLabel lbllngtamano) {
	this.lbllngtamano = lbllngtamano;
}
public JTextField getTxtlngtamano() {
	return txtlngtamano;
}
public void setTxtlngtamano(JTextField txtlngtamano) {
	this.txtlngtamano = txtlngtamano;
}
public JLabel getLbldtotipo_dato() {
	return lbldtotipo_dato;
}
public void setLbldtotipo_dato(JLabel lbldtotipoDato) {
	lbldtotipo_dato = lbldtotipoDato;
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
public JLabel getLblstrbase_datos() {
	return lblstrbase_datos;
}
public void setLblstrbase_datos(JLabel lblstrbaseDatos) {
	lblstrbase_datos = lblstrbaseDatos;
}
public JTextField getTxtstrbase_datos() {
	return txtstrbase_datos;
}
public void setTxtstrbase_datos(JTextField txtstrbaseDatos) {
	txtstrbase_datos = txtstrbaseDatos;
}
public JLabel getLblstrpuerto_bd() {
	return lblstrpuerto_bd;
}
public void setLblstrpuerto_bd(JLabel lblstrpuertoBd) {
	lblstrpuerto_bd = lblstrpuertoBd;
}
public JTextField getTxtstrpuerto_bd() {
	return txtstrpuerto_bd;
}
public void setTxtstrpuerto_bd(JTextField txtstrpuertoBd) {
	txtstrpuerto_bd = txtstrpuertoBd;
}
public JLabel getLblstrusuario_bd() {
	return lblstrusuario_bd;
}
public void setLblstrusuario_bd(JLabel lblstrusuarioBd) {
	lblstrusuario_bd = lblstrusuarioBd;
}
public JTextField getTxtstrusuario_bd() {
	return txtstrusuario_bd;
}
public void setTxtstrusuario_bd(JTextField txtstrusuarioBd) {
	txtstrusuario_bd = txtstrusuarioBd;
}
public JLabel getLblstrpwd_bd() {
	return lblstrpwd_bd;
}
public void setLblstrpwd_bd(JLabel lblstrpwdBd) {
	lblstrpwd_bd = lblstrpwdBd;
}
public JTextField getTxtstrpwd_bd() {
	return txtstrpwd_bd;
}
public void setTxtstrpwd_bd(JTextField txtstrpwdBd) {
	txtstrpwd_bd = txtstrpwdBd;
}

}

