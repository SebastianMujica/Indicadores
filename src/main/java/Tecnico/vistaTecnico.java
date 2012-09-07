package Tecnico;
import java.util.*;

import SocioDeNegocio.SocioDeNegocio;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaTecnico extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField();
  JLabel lbldtosocio=new JLabel("Socio: ");
  ComboBox cmbdtosocio=new ComboBox(new SocioDeNegocio());
  JLabel lbldtmfecha_ingreso=new JLabel("Fecha de ingreso: ");
  JDateChooser dchdtmfecha_ingreso=new JDateChooser();
  JLabel lbllngexperiencia=new JLabel("Años de experiencia: ");
  JTextField txtlngexperiencia=new JTextField();
  public vistaTecnico(  ActionListener controlador){
    this.setTitle("Tecnico");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.cmbdtosocio.addActionListener(controlador);
    this.agregar(lbldtosocio,cmbdtosocio);
    this.agregar(lbldtmfecha_ingreso,dchdtmfecha_ingreso);
    this.txtlngexperiencia.addActionListener(controlador);
    this.agregar(lbllngexperiencia,txtlngexperiencia);
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
    this.setSize(500, 300);
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
  public JLabel getLbldtmfecha_ingreso(){
    return lbldtmfecha_ingreso;
  }
  public void setLbldtmfecha_ingreso(  JLabel param){
    this.lbldtmfecha_ingreso=param;
  }
  public JDateChooser getDchdtmfecha_ingreso(){
    return dchdtmfecha_ingreso;
  }
  public void setDchdtmfecha_ingreso(  JDateChooser param){
    this.dchdtmfecha_ingreso=param;
  }
  public JLabel getLbllngexperiencia(){
    return lbllngexperiencia;
  }
  public void setLbllngexperiencia(  JLabel param){
    this.lbllngexperiencia=param;
  }
  public JTextField getTxtlngexperiencia(){
    return txtlngexperiencia;
  }
  public void setTxtlngexperiencia(  JTextField param){
    this.txtlngexperiencia=param;
  }
}

