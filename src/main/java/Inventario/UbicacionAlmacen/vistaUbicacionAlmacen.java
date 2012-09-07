package Inventario.UbicacionAlmacen;
import java.util.*;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;
import Organizacion.Organizacion;
import Inventario.Almacen.Almacen;

public class vistaUbicacionAlmacen extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField();
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lblstrcodigo=new JLabel("Código: ");
  JTextField txtstrcodigo=new JTextField();
  JLabel lbldto_almacen=new JLabel("Almacén: ");
  ComboBox cmbdto_almacen=new ComboBox(new Almacen());
  JLabel lblstrpasillo_x=new JLabel("Pasillo (X): ");
  JTextField txtstrpasillo_x=new JTextField();
  JLabel lblstrnivel_y=new JLabel("Nivel (Y): ");
  JTextField txtstrnivel_y=new JTextField();
  JLabel lblstrestante_z=new JLabel("Estante (Z): ");
  JTextField txtstrestante_z=new JTextField();
  JLabel lblstrcolor_id=new JLabel("Color Identificador: ");
  JTextField txtstrcolor_id=new JTextField();
  JLabel lblbolactivo=new JLabel("Activo: ");
  JCheckBox chkbolactivo=new JCheckBox();

  public vistaUbicacionAlmacen(  ActionListener controlador){
    this.setTitle("Organización de los Almacenes");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 90px,wrap 1");
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","width 150px,wrap 1");
    this.txtstrcodigo.addActionListener(controlador);
    this.agregar(lblstrcodigo,txtstrcodigo,"","width 150px,wrap 1");
    this.cmbdto_almacen.addActionListener(controlador);
    this.agregar(lbldto_almacen,cmbdto_almacen,"","width 150px,wrap 1");
    this.txtstrpasillo_x.addActionListener(controlador);
    this.agregar(lblstrpasillo_x,txtstrpasillo_x,"","width 150px,wrap 1");
    this.txtstrnivel_y.addActionListener(controlador);
    this.agregar(lblstrnivel_y,txtstrnivel_y,"","width 150px,wrap 1");
    this.txtstrestante_z.addActionListener(controlador);
    this.agregar(lblstrestante_z,txtstrestante_z,"","width 150px,wrap 1");
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
  public JLabel getLbldto_almacen(){
    return lbldto_almacen;
  }
  public void setLbldto_almacen(  JLabel param){
    this.lbldto_almacen=param;
  }
  public ComboBox getCmbdto_almacen(){
    return cmbdto_almacen;
  }
  public void setCmbdto_almacen(  ComboBox param){
    this.cmbdto_almacen=param;
  }
  public JLabel getLblstrpasillo_x(){
    return lblstrpasillo_x;
  }
  public void setLblstrpasillo_x(  JLabel param){
    this.lblstrpasillo_x=param;
  }
  public JTextField getTxtstrpasillo_x(){
    return txtstrpasillo_x;
  }
  public void setTxtstrpasillo_x(  JTextField param){
    this.txtstrpasillo_x=param;
  }
  public JLabel getLblstrnivel_y(){
    return lblstrnivel_y;
  }
  public void setLblstrnivel_y(  JLabel param){
    this.lblstrnivel_y=param;
  }
  public JTextField getTxtstrnivel_y(){
    return txtstrnivel_y;
  }
  public void setTxtstrnivel_y(  JTextField param){
    this.txtstrnivel_y=param;
  }
  public JLabel getLblstrestante_z(){
    return lblstrestante_z;
  }
  public void setLblstrestante_z(  JLabel param){
    this.lblstrestante_z=param;
  }
  public JTextField getTxtstrestante_z(){
    return txtstrestante_z;
  }
  public void setTxtstrestante_z(  JTextField param){
    this.txtstrestante_z=param;
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

