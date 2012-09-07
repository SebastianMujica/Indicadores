package RegistroIndicadorVariable;
import java.util.*;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;
public class vistaRegistroIndicadorVariable extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField();
  JLabel lbllngindicador=new JLabel("Lngindicador: ");
  JTextField txtlngindicador=new JTextField();
  JLabel lbllngvariableindicador=new JLabel("Lngvariableindicador: ");
  JTextField txtlngvariableindicador=new JTextField();
  JLabel lblbolactivo=new JLabel("Activo: ");
  JCheckBox chkbolactivo=new JCheckBox();
  
  public vistaRegistroIndicadorVariable(  ActionListener controlador){
    this.setTitle("RegistroIndicadorVariable");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.txtlngindicador.addActionListener(controlador);
    this.agregar(lbllngindicador,txtlngindicador);
    this.txtlngvariableindicador.addActionListener(controlador);
    this.agregar(lbllngvariableindicador,txtlngvariableindicador);
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

