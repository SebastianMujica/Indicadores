package RegistroVariable;
import java.util.*;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;
public class vistaRegistroVariable extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField();
  JLabel lbllngorg=new JLabel("Lngorg: ");
  JTextField txtlngorg=new JTextField();
  JLabel lbllngindicador=new JLabel("Lngindicador: ");
  JTextField txtlngindicador=new JTextField();
  JLabel lbllngperiodo=new JLabel("Lngperiodo: ");
  JTextField txtlngperiodo=new JTextField();
  JLabel lbllngvariableindicador=new JLabel("Lngvariableindicador: ");
  JTextField txtlngvariableindicador=new JTextField();
  JLabel lblstrvalor=new JLabel("Strvalor: ");
  JTextField txtstrvalor=new JTextField();
  JLabel lblbolactivo=new JLabel("Activo: ");
  JCheckBox chkbolactivo=new JCheckBox();

  
  public vistaRegistroVariable(  ActionListener controlador){
    this.setTitle("RegistroVariable");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.txtlngorg.addActionListener(controlador);
    this.agregar(lbllngorg,txtlngorg);
    this.txtlngindicador.addActionListener(controlador);
    this.agregar(lbllngindicador,txtlngindicador);
    this.txtlngperiodo.addActionListener(controlador);
    this.agregar(lbllngperiodo,txtlngperiodo);
    this.txtlngvariableindicador.addActionListener(controlador);
    this.agregar(lbllngvariableindicador,txtlngvariableindicador);
    this.txtstrvalor.addActionListener(controlador);
    this.agregar(lblstrvalor,txtstrvalor);
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
  public JLabel getLbllngorg(){
    return lbllngorg;
  }
  public void setLbllngorg(  JLabel param){
    this.lbllngorg=param;
  }
  public JTextField getTxtlngorg(){
    return txtlngorg;
  }
  public void setTxtlngorg(  JTextField param){
    this.txtlngorg=param;
  }
  public JLabel getLbllngindicador(){
    return lbllngindicador;
  }
  public void setLbllngindicador(  JLabel param){
    this.lbllngindicador=param;
  }
  public JTextField getTxtlngindicador(){
    return txtlngindicador;
  }
  public void setTxtlngindicador(  JTextField param){
    this.txtlngindicador=param;
  }
  public JLabel getLbllngperiodo(){
    return lbllngperiodo;
  }
  public void setLbllngperiodo(  JLabel param){
    this.lbllngperiodo=param;
  }
  public JTextField getTxtlngperiodo(){
    return txtlngperiodo;
  }
  public void setTxtlngperiodo(  JTextField param){
    this.txtlngperiodo=param;
  }
  public JLabel getLbllngvariableindicador(){
    return lbllngvariableindicador;
  }
  public void setLbllngvariableindicador(  JLabel param){
    this.lbllngvariableindicador=param;
  }
  public JTextField getTxtlngvariableindicador(){
    return txtlngvariableindicador;
  }
  public void setTxtlngvariableindicador(  JTextField param){
    this.txtlngvariableindicador=param;
  }
  public JLabel getLblstrvalor(){
    return lblstrvalor;
  }
  public void setLblstrvalor(  JLabel param){
    this.lblstrvalor=param;
  }
  public JTextField getTxtstrvalor(){
    return txtstrvalor;
  }
  public void setTxtstrvalor(  JTextField param){
    this.txtstrvalor=param;
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

