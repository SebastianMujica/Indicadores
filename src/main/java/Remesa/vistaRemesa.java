package Remesa;

import Hacienda.Hacienda;
import Nucleo.Nucleo;
import Productor.Productor;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import Tablon.Tablon;

import java.awt.event.*;
import javax.swing.*;

public class vistaRemesa extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField(5);
  JLabel lbllngnroremesa=new JLabel("Lngnroremesa: ");
  JTextField txtlngnroremesa=new JTextField(6);
  JLabel lbldtonucleo=new JLabel("Dtonucleo: ");
  ComboBox cmbdtonucleo=new ComboBox(new Nucleo());
  JLabel lbldtoproductor=new JLabel("Dtoproductor: ");
  ComboBox cmbdtoproductor=new ComboBox(new Productor());
  JLabel lbldtohacienda=new JLabel("Dtohacienda: ");
  ComboBox cmbdtohacienda=new ComboBox(new Hacienda());
  JLabel lbldtotablon=new JLabel("Dtotablon: ");
  ComboBox cmbdtotablon=new ComboBox(new Tablon());
  JLabel lblstrnombreconductor=new JLabel("Strnombreconductor: ");
  JTextField txtstrnombreconductor=new JTextField(25);
  JLabel lblstrcedulaconductor=new JLabel("Strcedulaconductor: ");
  JTextField txtstrcedulaconductor=new JTextField(10);
  JLabel lblstrplacavehiculo=new JLabel("Strplacavehiculo: ");
  JTextField txtstrplacavehiculo=new JTextField(10);
  public vistaRemesa(  ActionListener controlador){
    this.setTitle("Remesa");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.txtlngnroremesa.addActionListener(controlador);
    this.agregar(lbllngnroremesa,txtlngnroremesa);
    this.cmbdtonucleo.addActionListener(controlador);
    this.agregar(lbldtonucleo,cmbdtonucleo);
    this.cmbdtoproductor.addActionListener(controlador);
    this.agregar(lbldtoproductor,cmbdtoproductor);
    this.cmbdtohacienda.addActionListener(controlador);
    this.agregar(lbldtohacienda,cmbdtohacienda);
    this.cmbdtotablon.addActionListener(controlador);
    this.agregar(lbldtotablon,cmbdtotablon);
    this.txtstrnombreconductor.addActionListener(controlador);
    this.agregar(lblstrnombreconductor,txtstrnombreconductor);
    this.txtstrcedulaconductor.addActionListener(controlador);
    this.agregar(lblstrcedulaconductor,txtstrcedulaconductor);
    this.txtstrplacavehiculo.addActionListener(controlador);
    this.agregar(lblstrplacavehiculo,txtstrplacavehiculo);
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
  public JLabel getLbllngnroremesa(){
    return lbllngnroremesa;
  }
  public void setLbllngnroremesa(  JLabel param){
    this.lbllngnroremesa=param;
  }
  public JTextField getTxtlngnroremesa(){
    return txtlngnroremesa;
  }
  public void setTxtlngnroremesa(  JTextField param){
    this.txtlngnroremesa=param;
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
  public JLabel getLbldtotablon(){
    return lbldtotablon;
  }
  public void setLbldtotablon(  JLabel param){
    this.lbldtotablon=param;
  }
  public ComboBox getCmbdtotablon(){
    return cmbdtotablon;
  }
  public void setCmbdtotablon(  ComboBox param){
    this.cmbdtotablon=param;
  }
  public JLabel getLblstrnombreconductor(){
    return lblstrnombreconductor;
  }
  public void setLblstrnombreconductor(  JLabel param){
    this.lblstrnombreconductor=param;
  }
  public JTextField getTxtstrnombreconductor(){
    return txtstrnombreconductor;
  }
  public void setTxtstrnombreconductor(  JTextField param){
    this.txtstrnombreconductor=param;
  }
  public JLabel getLblstrcedulaconductor(){
    return lblstrcedulaconductor;
  }
  public void setLblstrcedulaconductor(  JLabel param){
    this.lblstrcedulaconductor=param;
  }
  public JTextField getTxtstrcedulaconductor(){
    return txtstrcedulaconductor;
  }
  public void setTxtstrcedulaconductor(  JTextField param){
    this.txtstrcedulaconductor=param;
  }
  public JLabel getLblstrplacavehiculo(){
    return lblstrplacavehiculo;
  }
  public void setLblstrplacavehiculo(  JLabel param){
    this.lblstrplacavehiculo=param;
  }
  public JTextField getTxtstrplacavehiculo(){
    return txtstrplacavehiculo;
  }
  public void setTxtstrplacavehiculo(  JTextField param){
    this.txtstrplacavehiculo=param;
  }
}

