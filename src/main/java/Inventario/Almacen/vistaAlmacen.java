package Inventario.Almacen;
import java.util.*;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;
import Organizacion.Organizacion;
public class vistaAlmacen extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField();
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lblstrcodigo=new JLabel("Código: ");
  JTextField txtstrcodigo=new JTextField();
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField();
  JLabel lblstrdescripcion=new JLabel("Descripción: ");
  JTextField txtstrdescripcion=new JTextField();
  JLabel lblstrcolor_id=new JLabel("Color Identificador: ");
  JTextField txtstrcolor_id=new JTextField();
  JLabel lblbolactivo=new JLabel("Activo: ");
  JCheckBox chkbolactivo=new JCheckBox();
  public vistaAlmacen(  ActionListener controlador){
    this.setTitle("Definición de Almacenes");
    this.setSize(650, 400);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 90px,wrap 1");
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","width 90px,wrap 1");
    this.txtstrcodigo.addActionListener(controlador);
    this.agregar(lblstrcodigo,txtstrcodigo,"","width 150px,wrap 1");
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","width 150px,wrap 1");
    this.txtstrdescripcion.addActionListener(controlador);
    this.agregar(lblstrdescripcion,txtstrdescripcion,"","width 150px,wrap 1");
    this.txtstrcolor_id.addActionListener(controlador);
    this.agregar(lblstrcolor_id,txtstrcolor_id,"","width 150px,wrap 1");
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
}

