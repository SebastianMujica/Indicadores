package Reporte;
import java.util.*;
import SwingBernate.*;
import java.awt.event.*;
import javax.swing.*;
public class vistaReporte extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField(5);
  JLabel lblstrnombre=new JLabel("Strnombre: ");
  JTextField txtstrnombre=new JTextField(25);
  JLabel lblstrurl=new JLabel("Strurl: ");
  JTextField txtstrurl=new JTextField(30);
  JLabel lblstrpadre=new JLabel("Strpadre: ");
  JTextField txtstrpadre=new JTextField(20);
  public vistaReporte(  ActionListener controlador){
    this.setTitle("Reporte");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre);
    this.txtstrurl.addActionListener(controlador);
    this.agregar(lblstrurl,txtstrurl);
    this.txtstrpadre.addActionListener(controlador);
    this.agregar(lblstrpadre,txtstrpadre);
    this.getButtonNuevo().addActionListener(controlador);
    this.getButtonBuscar().addActionListener(controlador);
    this.getButtonEliminar().addActionListener(controlador);
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
    this.setSize(600, 300);
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
  public JLabel getLblstrurl(){
    return lblstrurl;
  }
  public void setLblstrurl(  JLabel param){
    this.lblstrurl=param;
  }
  public JTextField getTxtstrurl(){
    return txtstrurl;
  }
  public void setTxtstrurl(  JTextField param){
    this.txtstrurl=param;
  }
  public JLabel getLblstrpadre(){
    return lblstrpadre;
  }
  public void setLblstrpadre(  JLabel param){
    this.lblstrpadre=param;
  }
  public JTextField getTxtstrpadre(){
    return txtstrpadre;
  }
  public void setTxtstrpadre(  JTextField param){
    this.txtstrpadre=param;
  }
}

