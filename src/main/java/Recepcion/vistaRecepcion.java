package Recepcion;
import java.util.*;

import Hacienda.Hacienda;
import Nucleo.Nucleo;
import OrdenDeArrime.OrdenDeArrime;
import Productor.Productor;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import Tablon.Tablon;
import Tecnico.Tecnico;
import Vehiculo.Vehiculo;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.event.*;
import javax.swing.*;
import eu.hansolo.steelseries.gauges.*;
import com.toedter.calendar.JDateChooser;
public class vistaRecepcion extends VistaBase {
  JLabel lbllngid=new JLabel("codigo: ");
  JTextField txtlngid=new JTextField();
  JLabel lblstrremesa=new JLabel("Codigo de Remesa: ");
  JTextField txtstrremesa=new JTextField();
  JLabel lbldtoproductor=new JLabel("Productor: ");
  ComboBox cmbdtoproductor=new ComboBox(new Productor());
  JLabel lbldtohacienda=new JLabel("Hacienda: ");
  ComboBox cmbdtohacienda=new ComboBox(new Hacienda());
  JLabel lbldtotablon=new JLabel("Tablon: ");
  ComboBox cmbdtotablon=new ComboBox(new Tablon());
  JLabel lbldtoordendearrime=new JLabel("Orden de Arrime: ");
  ComboBox cmbdtoordendearrime=new ComboBox(new OrdenDeArrime());
  JLabel lbldtmfechadequema=new JLabel("Fecha de Quema: ");
  JDateChooser  dchfechadequema   = new JDateChooser();
  JLabel lbldtonucleo=new JLabel("Nucleo: ");
  ComboBox cmbdtonucleo=new ComboBox(new Nucleo());
  JLabel lbldtotecnico=new JLabel("Técnico: ");
  ComboBox cmbdtotecnico=new ComboBox(new Tecnico());
  JLabel lblstrchofer=new JLabel("Chofer: ");
  JTextField txtstrchofer=new JTextField();
  JLabel lbldtovehiculo=new JLabel("Vehículo: ");
  ComboBox cmbdtovehiculo=new ComboBox(new Vehiculo());
  JLabel lblflopesobruto=new JLabel("Peso Bruto: ");
  JTextField txtflopesobruto=new JTextField();
  JLabel lblflopesotara=new JLabel("Peso Tara: ");
  JTextField txtflopesotara=new JTextField();
  JLabel lblstrobservacion=new JLabel("Observacion: ");
  JTextField txtstrobservacion=new JTextField();
  JLabel lbldtmfechaentrada=new JLabel("Entrada: ");
  JDateChooser  dchfechaentrada   = new JDateChooser();
  JLabel lbldtmfechadesalida=new JLabel("Salida: ");
  JDateChooser  dchfechasalida   = new JDateChooser();
  Radial radial=new Radial();
  DisplaySingle display=new DisplaySingle();
  public vistaRecepcion(  ActionListener controlador){
    this.setResizable(false);
	this.setSize(750, 800);
	  
	this.setTitle("Recepcion");
    
	
	this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 50px,wrap");

    
   
    

    
    ///////////////////Datos del Productor
    this.agregar(new JLabel("Datos del Productor"),"split 2 ,span");
    JSeparator separador4=new JSeparator();
    this.agregar(separador4,"growx,wrap");
    
    this.cmbdtoproductor.addActionListener(controlador);
    this.agregar(lbldtoproductor,cmbdtoproductor,"","wrap");
    this.cmbdtohacienda.addActionListener(controlador);
    this.agregar(lbldtohacienda,cmbdtohacienda);
    this.cmbdtotablon.addActionListener(controlador);
    
   
    
    
    
    this.agregar(lbldtotablon,cmbdtotablon);
   
    ///////////////////Datos de Arrime
    this.agregar(new JLabel("Datos del Arrime"),"split 2 ,span");
    JSeparator separador3=new JSeparator();
    
    this.agregar(separador3,"growx,wrap");
    this.agregar(lbldtmfechadequema,dchfechadequema);
    this.txtstrremesa.addActionListener(controlador);
    this.agregar(lblstrremesa,txtstrremesa,"","width 50px,wrap");
    this.cmbdtoordendearrime.addActionListener(controlador);    
    this.agregar(lbldtoordendearrime,cmbdtoordendearrime," ","span 2");
    this.agregar(lbldtoordendearrime,cmbdtoordendearrime);
    this.cmbdtotecnico.addActionListener(controlador);
    this.agregar(lbldtotecnico,cmbdtotecnico);
    this.cmbdtonucleo.addActionListener(controlador);
    this.agregar(lbldtonucleo,cmbdtonucleo);
    this.txtstrobservacion.addActionListener(controlador);
    this.agregar(lblstrobservacion,txtstrobservacion,"","width 250px,wrap");
    
    
    
    ///////////////////Datos del Vehiculo
    this.agregar(new JLabel("Datos del Vehículo"),"split 2 ,span");
    JSeparator separador2=new JSeparator();

    this.agregar(separador2,"growx,wrap");

    this.txtstrchofer.addActionListener(controlador);
    this.agregar(lblstrchofer,txtstrchofer,"","width 120px,wrap");
    this.cmbdtovehiculo.addActionListener(controlador);
    this.agregar(lbldtovehiculo,cmbdtovehiculo);
    ///////////////////Datos del Pesaje
    
    
    this.agregar(new JLabel("Datos del Pesaje"),"split 2 ,span");
    JSeparator separador=new JSeparator();
    this.agregar(separador,"growx,wrap");
    
    display.setDigitalFont(true);
    display.setLcdUnitString("Kg");
    display.setLcdValueAnimated(444.55);
    display.setGlowing(true);
    display.setGlowColor(Color.cyan);
    display.setGlowVisible(true);
    display.setBargraphVisible(true);
    
    GradientPaint fondo=new GradientPaint(5,7 ,Color.blue, 100, 7, Color.red);
    
    Color colores[]={Color.red,Color.blue};
    display.setCustomLcdBackground(display.createCustomLcdBackgroundPaint(colores));
    
    
    
    
    
    this.agregar(display,"span 2 4,grow");
    
    this.agregar(lbldtmfechaentrada,dchfechaentrada);
    this.agregar(lbldtmfechadesalida,dchfechasalida);
    this.txtflopesobruto.addActionListener(controlador);
    this.agregar(lblflopesobruto,txtflopesobruto,"","width 75px,wrap");
    this.txtflopesotara.addActionListener(controlador);
    this.agregar(lblflopesotara,txtflopesotara,"","width 75px");
    
    
    
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
  public JLabel getLblstrremesa(){
    return lblstrremesa;
  }
  public void setLblstrremesa(  JLabel param){
    this.lblstrremesa=param;
  }
  public JTextField getTxtstrremesa(){
    return txtstrremesa;
  }
  public void setTxtstrremesa(  JTextField param){
    this.txtstrremesa=param;
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
  public JLabel getLbldtoordendearrime(){
    return lbldtoordendearrime;
  }
  public void setLbldtoordendearrime(  JLabel param){
    this.lbldtoordendearrime=param;
  }
  public ComboBox getCmbdtoordendearrime(){
    return cmbdtoordendearrime;
  }
  public void setCmbdtoordendearrime(  ComboBox param){
    this.cmbdtoordendearrime=param;
  }
  public JLabel getLbldtmfechadequema(){
    return lbldtmfechadequema;
  }
  public void setLbldtmfechadequema(  JLabel param){
    this.lbldtmfechadequema=param;
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
  public JLabel getLbldtotecnico(){
    return lbldtotecnico;
  }
  public void setLbldtotecnico(  JLabel param){
    this.lbldtotecnico=param;
  }
  public ComboBox getCmbdtotecnico(){
    return cmbdtotecnico;
  }
  public void setCmbdtotecnico(  ComboBox param){
    this.cmbdtotecnico=param;
  }
  public JLabel getLblstrchofer(){
    return lblstrchofer;
  }
  public void setLblstrchofer(  JLabel param){
    this.lblstrchofer=param;
  }
  public JTextField getTxtstrchofer(){
    return txtstrchofer;
  }
  public void setTxtstrchofer(  JTextField param){
    this.txtstrchofer=param;
  }
  public JLabel getLbldtovehiculo(){
    return lbldtovehiculo;
  }
  public void setLbldtovehiculo(  JLabel param){
    this.lbldtovehiculo=param;
  }
  public ComboBox getCmbdtovehiculo(){
    return cmbdtovehiculo;
  }
  public void setCmbdtovehiculo(  ComboBox param){
    this.cmbdtovehiculo=param;
  }
  public JLabel getLblflopesobruto(){
    return lblflopesobruto;
  }
  public void setLblflopesobruto(  JLabel param){
    this.lblflopesobruto=param;
  }
  public JTextField getTxtflopesobruto(){
    return txtflopesobruto;
  }
  public void setTxtflopesobruto(  JTextField param){
    this.txtflopesobruto=param;
  }
  public JLabel getLblflopesotara(){
    return lblflopesotara;
  }
  public void setLblflopesotara(  JLabel param){
    this.lblflopesotara=param;
  }
  public JTextField getTxtflopesotara(){
    return txtflopesotara;
  }
  public void setTxtflopesotara(  JTextField param){
    this.txtflopesotara=param;
  }
  public JLabel getLblstrobservacion(){
    return lblstrobservacion;
  }
  public void setLblstrobservacion(  JLabel param){
    this.lblstrobservacion=param;
  }
  public JTextField getTxtstrobservacion(){
    return txtstrobservacion;
  }
  public void setTxtstrobservacion(  JTextField param){
    this.txtstrobservacion=param;
  }
  public JLabel getLbldtmfechaentrada(){
    return lbldtmfechaentrada;
  }
  public void setLbldtmfechaentrada(  JLabel param){
    this.lbldtmfechaentrada=param;
  }

  public JLabel getLbldtmfechadesalida(){
    return lbldtmfechadesalida;
  }
  public void setLbldtmfechadesalida(  JLabel param){
    this.lbldtmfechadesalida=param;
  }
public JDateChooser getDchfecha_entrada() {
	return dchfechaentrada;
}
public void setDchfechaentrada(JDateChooser dchfechaEntrada) {
	dchfechaentrada = dchfechaEntrada;
}
public JDateChooser getDchfecha_salida() {
	return dchfechasalida;
}
public void setDchfechasalida(JDateChooser dchfechaSalida) {
	dchfechasalida = dchfechaSalida;
}
public JDateChooser getDchfechadequema() {
	return dchfechadequema;
}
public void setDchfechadequema(JDateChooser dchfechadequema) {
	this.dchfechadequema = dchfechadequema;
}
}

