package DomicilioSocioDeNegocio;
import Estado.Estado;
import Maestro.Maestro;
import Municipio.Municipio;
import Pais.Pais;
import Parroquia.Parroquia;
import SocioDeNegocio.SocioDeNegocio;
import SwingBernate.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import SwingBernate.ayudantes.ComboBox;
public class vistaDomicilioSocioDeNegocio extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField(15);
  JLabel lbldto_sociodenegocio=new JLabel("Socio de Negocio: ");
  ComboBox cmbdto_sociodenegocio=new ComboBox(new SocioDeNegocio());
  JLabel lbldto_tipo_direccion=new JLabel("Tipo Domicilio: ");
  ComboBox cmbdto_tipo_direccion=new ComboBox(new Maestro());
  JLabel lblstrav_calle_sector=new JLabel("Av/Calle/Sector: ");
  JTextField txtstrav_calle_sector=new JTextField(50);
  JLabel lblstredif_casa=new JLabel("Edificio/Casa: ");
  JTextField txtstredif_casa=new JTextField(20);
  JLabel lblstrpiso=new JLabel("Piso: ");
  JTextField txtstrpiso=new JTextField(10);
  JLabel lblstrapto_ofic_nro=new JLabel("Apartamento/Oficina Nro: ");
  JTextField txtstrapto_ofic_nro=new JTextField(20);
  JLabel lblstrciudad=new JLabel("Ciudad: ");
  JTextField txtstrciudad=new JTextField(30);
  JLabel lbldto_pais=new JLabel("Pais: ");
  ComboBox cmbdto_pais=new ComboBox(new Pais());
  JLabel lbldto_estado=new JLabel("Estado: ");
  ComboBox cmbdto_estado=new ComboBox(new Estado());
  JLabel lbldto_municipio=new JLabel("Municipio: ");
  ComboBox cmbdto_municipio=new ComboBox(new Municipio());
  JLabel lbldto_parroquia=new JLabel("Parroquia: ");
  ComboBox cmbdto_parroquia=new ComboBox(new Parroquia());
  JLabel lblstrapartado_postal=new JLabel("Apartado Postal: ");
  JTextField txtstrapartado_postal=new JTextField(8);
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
  
  public vistaDomicilioSocioDeNegocio(  ActionListener controlador){
    this.setTitle("Domicilio x Socio de Negocio");
    this.txtlngid.setName("txtlngid");
    this.txtlngid.addActionListener(controlador);
    this.txtlngid.addKeyListener((KeyListener) controlador);
    this.agregar(lbllngid,txtlngid,"","width 90px,wrap 1");
    this.cmbdto_sociodenegocio.addActionListener(controlador);
    this.agregar(lbldto_sociodenegocio,cmbdto_sociodenegocio,"","width 250px,wrap 1");
    this.cmbdto_tipo_direccion.addActionListener(controlador);
    this.agregar(lbldto_tipo_direccion,cmbdto_tipo_direccion,"","width 250px,wrap 1");
    this.txtstrav_calle_sector.setName("txtstrav_calle_sector");
    this.txtstrav_calle_sector.addActionListener(controlador);
    this.txtstrav_calle_sector.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrav_calle_sector,txtstrav_calle_sector,"","width 250px,wrap 1");
    this.txtstredif_casa.setName("txtstredif_casa");
    this.txtstredif_casa.addActionListener(controlador);
    this.txtstredif_casa.addKeyListener((KeyListener) controlador);
    this.agregar(lblstredif_casa,txtstredif_casa,"","width 250px,wrap 1");
    this.txtstrpiso.setName("txtstrpiso");
    this.txtstrpiso.addActionListener(controlador);
    this.txtstrpiso.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrpiso,txtstrpiso,"","width 120px,wrap 1");
    this.txtstrapto_ofic_nro.setName("txtstrapto_ofic_nro");
    this.txtstrapto_ofic_nro.addActionListener(controlador);
    this.txtstrapto_ofic_nro.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrapto_ofic_nro,txtstrapto_ofic_nro,"","width 120px,wrap 1");
    this.txtstrciudad.setName("txtstrciudad");
    this.txtstrciudad.addActionListener(controlador);
    this.txtstrciudad.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrciudad,txtstrciudad,"","width 250px,wrap 1");
    this.cmbdto_pais.addActionListener(controlador);
    this.cmbdto_pais.setName("cmbdto_pais");
    this.agregar(lbldto_pais,cmbdto_pais,"","width 250px,wrap 1");
    this.cmbdto_estado.addActionListener(controlador);
    this.cmbdto_estado.setName("cmbdto_estado");
    this.agregar(lbldto_estado,cmbdto_estado,"","width 250px,wrap 1");
    this.cmbdto_municipio.addActionListener(controlador);
    this.cmbdto_municipio.setName("cmbdto_municipio");
    this.agregar(lbldto_municipio,cmbdto_municipio,"","width 250px,wrap 1");
    this.cmbdto_parroquia.addActionListener(controlador);
    this.cmbdto_parroquia.setName("cmbdto_parroquia");
    this.agregar(lbldto_parroquia,cmbdto_parroquia,"","width 250px,wrap 1");
    this.txtstrapartado_postal.setName("txtstrapartado_postal");
    this.txtstrapartado_postal.addActionListener(controlador);
    this.txtstrapartado_postal.addKeyListener((KeyListener) controlador);
    this.agregar(lblstrapartado_postal,txtstrapartado_postal,"","width 120px,wrap 1");
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
    this.setSize(600, 520);
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
  public JLabel getLbldto_sociodenegocio(){
    return lbldto_sociodenegocio;
  }
  public void setLbldto_sociodenegocio(  JLabel param){
    this.lbldto_sociodenegocio=param;
  }
  public ComboBox getCmbdto_sociodenegocio(){
    return cmbdto_sociodenegocio;
  }
  public void setCmbdto_sociodenegocio(  ComboBox param){
    this.cmbdto_sociodenegocio=param;
  }
  public JLabel getLbldto_tipo_direccion(){
    return lbldto_tipo_direccion;
  }
  public void setLbldto_tipo_direccion(  JLabel param){
    this.lbldto_tipo_direccion=param;
  }
  public ComboBox getCmbdto_tipo_direccion(){
    return cmbdto_tipo_direccion;
  }
  public void setCmbdto_tipo_direccion(  ComboBox param){
    this.cmbdto_tipo_direccion=param;
  }
  public JLabel getLblstrav_calle_sector(){
    return lblstrav_calle_sector;
  }
  public void setLblstrav_calle_sector(  JLabel param){
    this.lblstrav_calle_sector=param;
  }
  public JTextField getTxtstrav_calle_sector(){
    return txtstrav_calle_sector;
  }
  public void setTxtstrav_calle_sector(  JTextField param){
    this.txtstrav_calle_sector=param;
  }
  public JLabel getLblstredif_casa(){
    return lblstredif_casa;
  }
  public void setLblstredif_casa(  JLabel param){
    this.lblstredif_casa=param;
  }
  public JTextField getTxtstredif_casa(){
    return txtstredif_casa;
  }
  public void setTxtstredif_casa(  JTextField param){
    this.txtstredif_casa=param;
  }
  public JLabel getLblstrpiso(){
    return lblstrpiso;
  }
  public void setLblstrpiso(  JLabel param){
    this.lblstrpiso=param;
  }
  public JTextField getTxtstrpiso(){
    return txtstrpiso;
  }
  public void setTxtstrpiso(  JTextField param){
    this.txtstrpiso=param;
  }
  public JLabel getLblstrapto_ofic_nro(){
    return lblstrapto_ofic_nro;
  }
  public void setLblstrapto_ofic_nro(  JLabel param){
    this.lblstrapto_ofic_nro=param;
  }
  public JTextField getTxtstrapto_ofic_nro(){
    return txtstrapto_ofic_nro;
  }
  public void setTxtstrapto_ofic_nro(  JTextField param){
    this.txtstrapto_ofic_nro=param;
  }
  public JLabel getLblstrciudad(){
    return lblstrciudad;
  }
  public void setLblstrciudad(  JLabel param){
    this.lblstrciudad=param;
  }
  public JTextField getTxtstrciudad(){
    return txtstrciudad;
  }
  public void setTxtstrciudad(  JTextField param){
    this.txtstrciudad=param;
  }
  public JLabel getLbldto_pais(){
    return lbldto_pais;
  }
  public void setLbldto_pais(  JLabel param){
    this.lbldto_pais=param;
  }
  public ComboBox getCmbdto_pais(){
    return cmbdto_pais;
  }
  public void setCmbdto_pais(  ComboBox param){
    this.cmbdto_pais=param;
  }
  public JLabel getLbldto_estado(){
    return lbldto_estado;
  }
  public void setLbldto_estado(  JLabel param){
    this.lbldto_estado=param;
  }
  public ComboBox getCmbdto_estado(){
    return cmbdto_estado;
  }
  public void setCmbdto_estado(  ComboBox param){
    this.cmbdto_estado=param;
  }
  public JLabel getLbldto_municipio(){
    return lbldto_municipio;
  }
  public void setLbldto_municipio(  JLabel param){
    this.lbldto_municipio=param;
  }
  public ComboBox getCmbdto_municipio(){
    return cmbdto_municipio;
  }
  public void setCmbdto_municipio(  ComboBox param){
    this.cmbdto_municipio=param;
  }
  public JLabel getLbldto_parroquia(){
    return lbldto_parroquia;
  }
  public void setLbldto_parroquia(  JLabel param){
    this.lbldto_parroquia=param;
  }
  public ComboBox getCmbdto_parroquia(){
    return cmbdto_parroquia;
  }
  public void setCmbdto_parroquia(  ComboBox param){
    this.cmbdto_parroquia=param;
  }
  public JLabel getLblstrapartado_postal(){
    return lblstrapartado_postal;
  }
  public void setLblstrapartado_postal(  JLabel param){
    this.lblstrapartado_postal=param;
  }
  public JTextField getTxtstrapartado_postal(){
    return txtstrapartado_postal;
  }
  public void setTxtstrapartado_postal(  JTextField param){
    this.txtstrapartado_postal=param;
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

