package Direccion;

import java.util.*;

import Estado.Estado;
import Municipio.Municipio;
import Pais.Pais;
import Parroquia.Parroquia;

import SwingBernate.*;
import java.awt.event.*;
import javax.swing.*;

import SwingBernate.ayudantes.ComponenteUbicacion;
import SwingBernate.ayudantes.ListaDoble;
import SwingBernate.ayudantes.ComboBox;
import Telefono.Telefono;

public class vistaDireccion extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField();
  JLabel lblstrdireccion=new JLabel("Strdireccion: ");
  JTextField txtstrdireccion=new JTextField();
  JLabel lblstrciudadpoblacion=new JLabel("Strciudadpoblacion: ");
  JTextField txtstrciudadpoblacion=new JTextField();
  JLabel lblstrreferencia=new JLabel("Strreferencia: ");
  JTextField txtstrreferencia=new JTextField();
  
  JLabel lbldtopais=new JLabel("Dtopais: ");
  ComboBox cmbdtopais=new ComboBox(new Pais());
  JLabel lbldtoestado=new JLabel("Dtoestado: ");
  ComboBox cmbdtoestado=new ComboBox(new Estado());
  JLabel lbldtomunicipio=new JLabel("Dtomunicipio: ");
  ComboBox cmbdtomunicipio=new ComboBox(new Municipio());
  JLabel lbldtoparroquia=new JLabel("Dtoparroquia: ");
  ComboBox cmbdtoparroquia=new ComboBox(new Parroquia());
  
  //JLabel lblcmpcmbubicacion=new JLabel("Ubicación: ");
  //ComponenteUbicacion cmpcmbubicacion = new ComponenteUbicacion();
  
  
  JLabel lblstrzonapostal=new JLabel("Strzonapostal: ");
  JTextField txtstrzonapostal=new JTextField();  
  JLabel lbldtotelefono=new JLabel("Dtotelefono: ");
  ListaDoble lstdtotelefono=new ListaDoble("dtotelefono",new Telefono());
  
  public vistaDireccion(  ActionListener controlador){
    this.setTitle("Direccion");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.txtstrdireccion.addActionListener(controlador);
    this.agregar(lblstrdireccion,txtstrdireccion);
    this.txtstrciudadpoblacion.addActionListener(controlador);
    this.agregar(lblstrciudadpoblacion,txtstrciudadpoblacion);
    this.txtstrreferencia.addActionListener(controlador);
    this.agregar(lblstrreferencia,txtstrreferencia);
    this.cmbdtopais.addActionListener(controlador);
    this.cmbdtopais.setName("cmpDtopais");
    this.agregar(lbldtopais,cmbdtopais);
    this.cmbdtoestado.addActionListener(controlador);
    this.cmbdtoestado.setName("cmpDtoestado");
    this.agregar(lbldtoestado,cmbdtoestado);
    this.cmbdtomunicipio.addActionListener(controlador);
    this.cmbdtomunicipio.setName("cmpDtomunicipio");
    this.agregar(lbldtomunicipio,cmbdtomunicipio);
    this.cmbdtoparroquia.addActionListener(controlador);
    this.cmbdtoparroquia.setName("cmpDtoparroquia");
    this.agregar(lbldtoparroquia,cmbdtoparroquia);
    //this.agregar(lblcmpcmbubicacion, this.cmpcmbubicacion);
    this.txtstrzonapostal.addActionListener(controlador);
    this.agregar(lblstrzonapostal,txtstrzonapostal);
    this.agregar(lbldtotelefono,lstdtotelefono);
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
  public JLabel getLblstrdireccion(){
    return lblstrdireccion;
  }
  public void setLblstrdireccion(  JLabel param){
    this.lblstrdireccion=param;
  }
  public JTextField getTxtstrdireccion(){
    return txtstrdireccion;
  }
  public void setTxtstrdireccion(  JTextField param){
    this.txtstrdireccion=param;
  }
  public JLabel getLblstrciudadpoblacion(){
    return lblstrciudadpoblacion;
  }
  public void setLblstrciudadpoblacion(  JLabel param){
    this.lblstrciudadpoblacion=param;
  }
  public JTextField getTxtstrciudadpoblacion(){
    return txtstrciudadpoblacion;
  }
  public void setTxtstrciudadpoblacion(  JTextField param){
    this.txtstrciudadpoblacion=param;
  }
  public JLabel getLblstrreferencia(){
    return lblstrreferencia;
  }
  public void setLblstrreferencia(  JLabel param){
    this.lblstrreferencia=param;
  }
  public JTextField getTxtstrreferencia(){
    return txtstrreferencia;
  }
  public void setTxtstrreferencia(  JTextField param){
    this.txtstrreferencia=param;
  }
  public JLabel getLbldtopais(){
    return lbldtopais;
  }
  public void setLbldtopais(  JLabel param){
    this.lbldtopais=param;
  }
  public ComboBox getCmbdtopais(){
    return cmbdtopais;
  }
  public void setCmbdtopais(  ComboBox param){
    this.cmbdtopais=param;
  }
  public JLabel getLbldtoestado(){
    return lbldtoestado;
  }
  public void setLbldtoestado(  JLabel param){
    this.lbldtoestado=param;
  }
  public ComboBox getCmbdtoestado(){
    return cmbdtoestado;
  }
  public void setCmbdtoestado(  ComboBox param){
    this.cmbdtoestado=param;
  }
  public JLabel getLbldtomunicipio(){
    return lbldtomunicipio;
  }
  public void setLbldtomunicipio(  JLabel param){
    this.lbldtomunicipio=param;
  }
  public ComboBox getCmbdtomunicipio(){
    return cmbdtomunicipio;
  }
  public void setCmbdtomunicipio(  ComboBox param){
    this.cmbdtomunicipio=param;
  }
  public JLabel getLbldtoparroquia(){
    return lbldtoparroquia;
  }
  public void setLbldtoparroquia(  JLabel param){
    this.lbldtoparroquia=param;
  }
  public ComboBox getCmbdtoparroquia(){
    return cmbdtoparroquia;
  }
  public void setCmbdtoparroquia(  ComboBox param){
    this.cmbdtoparroquia=param;
  }
/*public void setLblcmpcmbubicacion(JLabel lblcmpcmbubicacion) {
	this.lblcmpcmbubicacion = lblcmpcmbubicacion;
}
public ComponenteUbicacion getCmpcmbubicacion() {
	return cmpcmbubicacion;
}
public void setCmpcmbubicacion(ComponenteUbicacion cmpcmbubicacion) {
	this.cmpcmbubicacion = cmpcmbubicacion;
}
public JLabel getLblcmpcmbubicacion() {
	return lblcmpcmbubicacion;
}*/
  public void setLblstrzonapostal(  JLabel param){
    this.lblstrzonapostal=param;
  }

  public JLabel getLblstrzonapostal(){
    return lblstrzonapostal;
  }
  public JTextField getTxtstrzonapostal(){
    return txtstrzonapostal;
  }
  public void setTxtstrzonapostal(  JTextField param){
    this.txtstrzonapostal=param;
  }
  public JLabel getLbldtotelefono(){
    return lbldtotelefono;
  }
  public void setLbldtotelefono(  JLabel param){
    this.lbldtotelefono=param;
  }
  public ListaDoble getLstdtotelefono(){
    return lstdtotelefono;
  }
  public void setLstdtotelefono(  ListaDoble param){
    this.lstdtotelefono=param;
  }
}

