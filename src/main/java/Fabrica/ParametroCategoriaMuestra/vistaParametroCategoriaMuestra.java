package Fabrica.ParametroCategoriaMuestra;
import java.util.*;

import Fabrica.ParametroFabrica.ParametroFabrica;
import Maestro.Maestro;
import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;
import SwingBernate.ayudantes.ListaDoble;
public class vistaParametroCategoriaMuestra extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField();
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lbldto_categoria_muestra=new JLabel("Categoría Muestra: ");
  ComboBox cmbdto_categoria_muestra=new ComboBox(new Maestro());
  JLabel lbldto_parametro_fabrica=new JLabel("Parámetros: ");
  ListaDoble lstdto_parametro_fabrica=new ListaDoble("Lista de Parámetros",new ParametroFabrica());
  public vistaParametroCategoriaMuestra(  ActionListener controlador){
    this.setTitle("Parámetros x Categorías de Muestras");
    this.setSize(550, 480);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 90px,wrap");
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org);
    this.cmbdto_categoria_muestra.addActionListener(controlador);
    this.agregar(lbldto_categoria_muestra,cmbdto_categoria_muestra);
    this.agregar(lbldto_parametro_fabrica,lstdto_parametro_fabrica);
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
  public JLabel getLbldto_org(){
    return lbldto_org;
  }
  public void setLbldto_org(  JLabel param){
    this.lbldto_org=param;
  }
  public ComboBox getCmbdto_org(){
    return cmbdto_org;
  }
  public void setCmbdto_org(  ComboBox param){
    this.cmbdto_org=param;
  }
  public JLabel getLbldto_categoria_muestra(){
    return lbldto_categoria_muestra;
  }
  public void setLbldto_categoria_muestra(  JLabel param){
    this.lbldto_categoria_muestra=param;
  }
  public ComboBox getCmbdto_categoria_muestra(){
    return cmbdto_categoria_muestra;
  }
  public void setCmbdto_categoria_muestra(  ComboBox param){
    this.cmbdto_categoria_muestra=param;
  }
  public JLabel getLbldto_parametro_fabrica(){
    return lbldto_parametro_fabrica;
  }
  public void setLbldto_parametro_fabrica(  JLabel param){
    this.lbldto_parametro_fabrica=param;
  }
  public ListaDoble getLstdto_parametro_fabrica(){
    return lstdto_parametro_fabrica;
  }
  public void setLstdto_parametro_fabrica(  ListaDoble param){
    this.lstdto_parametro_fabrica=param;
  }
}

