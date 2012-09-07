package OrdenDeArrime;
import java.util.*;

import Hacienda.Hacienda;
import Nucleo.Nucleo;
import Productor.Productor;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import SwingBernate.ayudantes.ListaDoble;
import Tablon.Tablon;
import Tecnico.Tecnico;
public class vistaOrdenDeArrime extends VistaBase {
  JLabel lbllngid=new JLabel("Numero de Orden : ");
  JTextField txtlngid=new JTextField();
  JLabel lbldtmfecha_arrime=new JLabel("Fecha de Arrime : ");
  JDateChooser  dchdtmfecha_arrime   = new JDateChooser();
  JLabel lbldtoproductor=new JLabel("Productor : ");
  ComboBox cmbdtoproductor=new ComboBox(new Productor());
  JLabel lbldtohacienda=new JLabel("Hacienda : ");
  ComboBox cmbdtohacienda=new ComboBox(new Hacienda());
  JLabel lbltablonesacosechar=new JLabel("Tablones : ");
  ListaDoble lsttablonesacosechar=new ListaDoble("Tablones a Cosechar",new Tablon());
  JLabel lbldtonucleo=new JLabel("Nucleo : ");
  ComboBox cmbdtonucleo=new ComboBox(new Nucleo());
  JLabel lbldtoingazucarero=new JLabel("Técnico : ");
  ComboBox cmbdtoingazucarero=new ComboBox(new Tecnico());
  public vistaOrdenDeArrime(  ActionListener controlador){
    this.setTitle("Orden de Arrime");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 60px");
    this.agregar(lbldtmfecha_arrime,dchdtmfecha_arrime,"","width 100px");
    this.cmbdtoproductor.addActionListener(controlador);
    this.agregar(lbldtoproductor,cmbdtoproductor,"cell 0 1","cell 1 1");
    this.cmbdtohacienda.addActionListener(controlador);
    this.agregar(lbldtohacienda,cmbdtohacienda);
    this.agregar(lbltablonesacosechar,lsttablonesacosechar,"cell 0 3","cell 1 3 ");
    this.cmbdtonucleo.addActionListener(controlador);
    this.agregar(lbldtonucleo,cmbdtonucleo,"cell 0 2","cell 1 2");
    this.cmbdtoingazucarero.addActionListener(controlador);
    this.agregar(lbldtoingazucarero,cmbdtoingazucarero,"cell 2 2","cell  3 2");
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
this.setSize(800, 500);
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
  public JLabel getLbldtmfecha_arrime(){
    return lbldtmfecha_arrime;
  }
  public void setLbldtmfecha_arrime(  JLabel param){
    this.lbldtmfecha_arrime=param;
  }
  public JDateChooser getDchdtmfecha_arrime(){
    return dchdtmfecha_arrime;
  }
  public void setDchdtmfecha_arrime(  JDateChooser param){
    this.dchdtmfecha_arrime=param;
  }
  public JLabel getLbldtoproductor(){
    return lbldtoproductor;
  }
  public void setLbldtoproductor(  JLabel param){
    this.lbldtoproductor=param;
  }
  public ComboBox getCmbdtoproductor(){
    return cmbdtoproductor;
  }
  public void setCmbdtoproductor(  ComboBox param){
    this.cmbdtoproductor=param;
  }
  public JLabel getLbldtohacienda(){
    return lbldtohacienda;
  }
  public void setLbldtohacienda(  JLabel param){
    this.lbldtohacienda=param;
  }
  public ComboBox getCmbdtohacienda(){
    return cmbdtohacienda;
  }
  public void setCmbdtohacienda(  ComboBox param){
    this.cmbdtohacienda=param;
  }
  public JLabel getLbltablonesacosechar(){
    return lbltablonesacosechar;
  }
  public void setLbltablonesacosechar(  JLabel param){
    this.lbltablonesacosechar=param;
  }
  public ListaDoble getLsttablonesacosechar(){
    return lsttablonesacosechar;
  }
  public void setLsttablonesacosechar(  ListaDoble param){
    this.lsttablonesacosechar=param;
  }
  public JLabel getLbldtonucleo(){
    return lbldtonucleo;
  }
  public void setLbldtonucleo(  JLabel param){
    this.lbldtonucleo=param;
  }
  public ComboBox getCmbdtonucleo(){
    return cmbdtonucleo;
  }
  public void setCmbdtonucleo(  ComboBox param){
    this.cmbdtonucleo=param;
  }
  public JLabel getLbldtoingazucarero(){
    return lbldtoingazucarero;
  }
  public void setLbldtoingazucarero(  JLabel param){
    this.lbldtoingazucarero=param;
  }
  public ComboBox getCmbdtoingazucarero(){
    return cmbdtoingazucarero;
  }
  public void setCmbdtoingazucarero(  ComboBox param){
    this.cmbdtoingazucarero=param;
  }
}

