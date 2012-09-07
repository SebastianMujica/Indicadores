package Telefono;
import java.util.*;
import SwingBernate.*;
import SwingBernate.ayudantes.*;

import java.awt.event.*;
import javax.swing.*;
public class vistaTelefono extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField();
  JLabel lblstrtipo=new JLabel("Strtipo: ");
  JTextField txtstrtipo=new JTextField();
  JLabel lblstrcodigoarea=new JLabel("Strcodigoarea: ");
  JTextField txtstrcodigoarea=new JTextField();
  JLabel lblstrnumero=new JLabel("Strnumero: ");
  JTextField txtstrnumero=new JTextField();
   
  public vistaTelefono(  ActionListener controlador){
    this.setTitle("Telefono");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.txtstrtipo.addActionListener(controlador);
    this.agregar(lblstrtipo,txtstrtipo);
    this.txtstrcodigoarea.addActionListener(controlador);
    this.agregar(lblstrcodigoarea,txtstrcodigoarea);
    this.txtstrnumero.addActionListener(controlador);
    this.agregar(lblstrnumero,txtstrnumero);
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
    
    this.setSize(600, 400);
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
  public JLabel getLblstrtipo(){
    return lblstrtipo;
  }
  public void setLblstrtipo(  JLabel param){
    this.lblstrtipo=param;
  }
  public JTextField getTxtstrtipo(){
    return txtstrtipo;
  }
  public void setTxtstrtipo(  JTextField param){
    this.txtstrtipo=param;
  }
  public JLabel getLblstrcodigoarea(){
    return lblstrcodigoarea;
  }
  public void setLblstrcodigoarea(  JLabel param){
    this.lblstrcodigoarea=param;
  }
  public JTextField getTxtstrcodigoarea(){
    return txtstrcodigoarea;
  }
  public void setTxtstrcodigoarea(  JTextField param){
    this.txtstrcodigoarea=param;
  }
  public JLabel getLblstrnumero(){
    return lblstrnumero;
  }
  public void setLblstrnumero(  JLabel param){
    this.lblstrnumero=param;
  }
  public JTextField getTxtstrnumero(){
    return txtstrnumero;
  }
  public void setTxtstrnumero(  JTextField param){
    this.txtstrnumero=param;
  }
}

