package Tablon;
import java.util.*;

import Hacienda.Hacienda;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;
public class vistaTablon extends VistaBase {
  JLabel lbllngid=new JLabel("Lngid: ");
  JTextField txtlngid=new JTextField();
  JLabel lbldtohacienda=new JLabel("Dtohacienda: ");
  ComboBox cmbdtohacienda=new ComboBox(new Hacienda());
  JLabel lblstrnombre=new JLabel("Strnombre: ");
  JTextField txtstrnombre=new JTextField();
  JLabel lblflohectareas=new JLabel("Flohectareas: ");
  JTextField txtflohectareas=new JTextField();
  JLabel lblflotoneladas_estimadas=new JLabel("Flotoneladas_estimadas: ");
  JTextField txtflotoneladas_estimadas=new JTextField();
  JLabel lblstrvariedad_cana=new JLabel("Strvariedad_cana: ");
  JTextField txtstrvariedad_cana=new JTextField();
  JLabel lblstrclase_cana=new JLabel("Strclase_cana: ");
  JTextField txtstrclase_cana=new JTextField();
  public vistaTablon(  ActionListener controlador){
    this.setTitle("Tablon");
    this.txtlngid.addActionListener(controlador);
    this.agregar(lbllngid,txtlngid);
    this.cmbdtohacienda.addActionListener(controlador);
    this.agregar(lbldtohacienda,cmbdtohacienda);
    this.txtstrnombre.addActionListener(controlador);
    this.agregar(lblstrnombre,txtstrnombre);
    this.txtflohectareas.addActionListener(controlador);
    this.agregar(lblflohectareas,txtflohectareas);
    this.txtflotoneladas_estimadas.addActionListener(controlador);
    this.agregar(lblflotoneladas_estimadas,txtflotoneladas_estimadas);
    this.txtstrvariedad_cana.addActionListener(controlador);
    this.agregar(lblstrvariedad_cana,txtstrvariedad_cana);
    this.txtstrclase_cana.addActionListener(controlador);
    this.agregar(lblstrclase_cana,txtstrclase_cana);
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
    //this.setSize(500, 300);
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
  public JLabel getLblflohectareas(){
    return lblflohectareas;
  }
  public void setLblflohectareas(  JLabel param){
    this.lblflohectareas=param;
  }
  public JTextField getTxtflohectareas(){
    return txtflohectareas;
  }
  public void setTxtflohectareas(  JTextField param){
    this.txtflohectareas=param;
  }
  public JLabel getLblflotoneladas_estimadas(){
    return lblflotoneladas_estimadas;
  }
  public void setLblflotoneladas_estimadas(  JLabel param){
    this.lblflotoneladas_estimadas=param;
  }
  public JTextField getTxtflotoneladas_estimadas(){
    return txtflotoneladas_estimadas;
  }
  public void setTxtflotoneladas_estimadas(  JTextField param){
    this.txtflotoneladas_estimadas=param;
  }
  public JLabel getLblstrvariedad_cana(){
    return lblstrvariedad_cana;
  }
  public void setLblstrvariedad_cana(  JLabel param){
    this.lblstrvariedad_cana=param;
  }
  public JTextField getTxtstrvariedad_cana(){
    return txtstrvariedad_cana;
  }
  public void setTxtstrvariedad_cana(  JTextField param){
    this.txtstrvariedad_cana=param;
  }
  public JLabel getLblstrclase_cana(){
    return lblstrclase_cana;
  }
  public void setLblstrclase_cana(  JLabel param){
    this.lblstrclase_cana=param;
  }
  public JTextField getTxtstrclase_cana(){
    return txtstrclase_cana;
  }
  public void setTxtstrclase_cana(  JTextField param){
    this.txtstrclase_cana=param;
  }
}

