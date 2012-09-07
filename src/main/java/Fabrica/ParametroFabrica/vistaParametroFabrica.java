package Fabrica.ParametroFabrica;
import java.util.*;

import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import UnidadDeMedida.UnidadDeMedida;

import java.awt.event.*;
import javax.swing.*;
public class vistaParametroFabrica extends VistaBase {
  JLabel lbllngid=new JLabel("Id: ");
  JTextField txtlngid=new JTextField();
  JLabel lbldto_org=new JLabel("Organización: ");
  ComboBox cmbdto_org=new ComboBox(new Organizacion());
  JLabel lblstrcodigo=new JLabel("Código: ");
  JTextField txtstrcodigo=new JTextField();
  JLabel lblstrnombre=new JLabel("Nombre: ");
  JTextField txtstrnombre=new JTextField();
  JLabel lblstrdescripcion=new JLabel("Descripción: ");
  JTextField txtstrdescripcion=new JTextField();
  JLabel lbldto_unidad_medida=new JLabel("Unidad de Medida: ");
  ComboBox cmbdto_unidad_medida=new ComboBox(new UnidadDeMedida());
  JLabel lblflolim_inf_num=new JLabel("Límite Inferior: ");
  JTextField txtflolim_inf_num=new JTextField();
  JLabel lblflolim_sup_num=new JLabel("Límite Superior: ");
  JTextField txtflolim_sup_num=new JTextField();
  //JLabel lbldto_formula=new JLabel("Dto_formula: ");
  //ComboBox cmbdto_formula=new ComboBox(new Formula());
  public vistaParametroFabrica(  ActionListener controlador){
    this.setTitle("Parámetros de Fábrica");
    this.setSize(550, 380);
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid,"","width 90px,wrap");
    this.cmbdto_org.addActionListener(controlador);
    this.agregar(lbldto_org,cmbdto_org,"","width 90px,wrap");
    this.txtstrcodigo.addActionListener(controlador);
    this.agregar(lblstrcodigo,txtstrcodigo,"","width 90px,wrap");
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre,"","width 150px,wrap");
    this.txtstrdescripcion.addActionListener(controlador);
    this.agregar(lblstrdescripcion,txtstrdescripcion,"","width 280px,wrap");
    this.cmbdto_unidad_medida.addActionListener(controlador);
    this.agregar(lbldto_unidad_medida,cmbdto_unidad_medida);
    this.txtflolim_inf_num.addActionListener(controlador);
    this.agregar(lblflolim_inf_num,txtflolim_inf_num,"","width 90px,wrap");
    this.txtflolim_sup_num.addActionListener(controlador);
    this.agregar(lblflolim_sup_num,txtflolim_sup_num,"","width 90px,wrap");
    //this.cmbdto_formula.addActionListener(controlador);
    //this.agregar(lbldto_formula,cmbdto_formula);
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
  public JLabel getLblstrcodigo(){
    return lblstrcodigo;
  }
  public void setLblstrcodigo(  JLabel param){
    this.lblstrcodigo=param;
  }
  public JTextField getTxtstrcodigo(){
    return txtstrcodigo;
  }
  public void setTxtstrcodigo(  JTextField param){
    this.txtstrcodigo=param;
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
  public JLabel getLblstrdescripcion(){
    return lblstrdescripcion;
  }
  public void setLblstrdescripcion(  JLabel param){
    this.lblstrdescripcion=param;
  }
  public JTextField getTxtstrdescripcion(){
    return txtstrdescripcion;
  }
  public void setTxtstrdescripcion(  JTextField param){
    this.txtstrdescripcion=param;
  }
  public JLabel getLbldto_unidad_medida(){
    return lbldto_unidad_medida;
  }
  public void setLbldto_unidad_medida(  JLabel param){
    this.lbldto_unidad_medida=param;
  }
  public ComboBox getCmbdto_unidad_medida(){
    return cmbdto_unidad_medida;
  }
  public void setCmbdto_unidad_medida(  ComboBox param){
    this.cmbdto_unidad_medida=param;
  }
  public JLabel getLblflolim_inf_num(){
    return lblflolim_inf_num;
  }
  public void setLblflolim_inf_num(  JLabel param){
    this.lblflolim_inf_num=param;
  }
  public JTextField getTxtflolim_inf_num(){
    return txtflolim_inf_num;
  }
  public void setTxtflolim_inf_num(  JTextField param){
    this.txtflolim_inf_num=param;
  }
  public JLabel getLblflolim_sup_num(){
    return lblflolim_sup_num;
  }
  public void setLblflolim_sup_num(  JLabel param){
    this.lblflolim_sup_num=param;
  }
  public JTextField getTxtflolim_sup_num(){
    return txtflolim_sup_num;
  }
  public void setTxtflolim_sup_num(  JTextField param){
    this.txtflolim_sup_num=param;
  }
  /*public JLabel getLbldto_formula(){
    return lbldto_formula;
  }
  public void setLbldto_formula(  JLabel param){
    this.lbldto_formula=param;
  }
  public ComboBox getCmbdto_formula(){
    return cmbdto_formula;
  }
  public void setCmbdto_formula(  ComboBox param){
    this.cmbdto_formula=param;
  }
  */
}

