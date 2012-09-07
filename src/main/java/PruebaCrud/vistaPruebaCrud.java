package PruebaCrud;
import java.util.*;
import SwingBernate.*;
import java.awt.event.*;
import javax.swing.*;
public class vistaPruebaCrud extends VistaBase {
  JLabel lblid=new JLabel("Id: ");
  JTextField txtid=new JTextField();
  JLabel lblnombre=new JLabel("Nombre: ");
  JTextField txtnombre=new JTextField();
  JLabel lblcedula=new JLabel("Cedula: ");
  JComboBox txtcedula=new JComboBox();
  public vistaPruebaCrud(  ActionListener controlador){
    this.txtid.addActionListener(controlador);
    this.agregar(lblid,txtid);
    this.txtnombre.addActionListener(controlador);
    this.agregar(lblnombre,txtnombre);
    this.txtcedula.addActionListener(controlador);
    this.agregar(lblcedula,txtcedula);
    this.getButtonNuevo().addActionListener(controlador);
    this.getButtonBuscar().addActionListener(controlador);
    this.getButtonEliminar().addActionListener(controlador);
    this.getButtonGuardar().addActionListener(controlador);
    this.getButtonCancelar().addActionListener(controlador);
    this.getButtonSiguiente().addActionListener(controlador);
    this.getButtonAnterior().addActionListener(controlador);
    this.getMenuItemNuevo().addActionListener(controlador);
    this.getMenuItemBuscar().addActionListener(controlador);
    this.getMenuItemEliminar().addActionListener(controlador);
    this.getMenuItemGuardar().addActionListener(controlador);
    this.getMenuItemSalir().addActionListener(controlador);
  }
  public JLabel getLblid(){
    return lblid;
  }
  public void setLblid(  JLabel param){
    this.lblid=param;
  }
  public JTextField getTxtid(){
    return txtid;
  }
  public void setTxtid(  JTextField param){
    this.txtid=param;
  }
  public JLabel getLblnombre(){
    return lblnombre;
  }
  public void setLblnombre(  JLabel param){
    this.lblnombre=param;
  }
  public JTextField getTxtnombre(){
    return txtnombre;
  }
  public void setTxtnombre(  JTextField param){
    this.txtnombre=param;
  }
  public JLabel getLblcedula(){
    return lblcedula;
  }
  public void setLblcedula(  JLabel param){
    this.lblcedula=param;
  }
  public JComboBox getTxtcedula(){
    return txtcedula;
  }
  public void setTxtcedula(  JComboBox param){
    this.txtcedula=param;
  }
}

