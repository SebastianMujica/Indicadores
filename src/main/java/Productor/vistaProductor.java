package Productor;
import java.util.*;

import Hacienda.Hacienda;
import SocioDeNegocio.SocioDeNegocio;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;
import SwingBernate.ayudantes.ListaDoble;
public class vistaProductor extends VistaBase {
  JLabel lbllngid=new JLabel("codigo: ");
  JTextField txtlngid=new JTextField();
  JLabel lbldtosocio=new JLabel("Datos Personales: ");
  ComboBox cmbdtosocio=new ComboBox(new SocioDeNegocio());
  JLabel lblhaciendas=new JLabel("Haciendas: ");
  ListaDoble lsthaciendas=new ListaDoble("haciendas",new Hacienda());
  public vistaProductor(  ActionListener controlador){
    this.setTitle("Productor");
    this.setSize(650, 500);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.cmbdtosocio.addActionListener(controlador);
    this.agregar(lbldtosocio,cmbdtosocio);
    this.agregar(lblhaciendas,lsthaciendas);
    this.getButtonNuevo().addActionListener(controlador);
    this.getButtonVistaR().addActionListener(controlador);
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
  public JLabel getLbldtosocio(){
    return lbldtosocio;
  }
  public void setLbldtosocio(  JLabel param){
    this.lbldtosocio=param;
  }
  public ComboBox getCmbdtosocio(){
    return cmbdtosocio;
  }
  public void setCmbdtosocio(  ComboBox param){
    this.cmbdtosocio=param;
  }
  public JLabel getLblhaciendas(){
    return lblhaciendas;
  }
  public void setLblhaciendas(  JLabel param){
    this.lblhaciendas=param;
  }
  public ListaDoble getLsthaciendas(){
    return lsthaciendas;
  }
  public void setLsthaciendas(  ListaDoble param){
    this.lsthaciendas=param;
  }
}

