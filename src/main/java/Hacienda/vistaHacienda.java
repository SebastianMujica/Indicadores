package Hacienda;
import java.util.*;

import Productor.Productor;
import SubZona.SubZona;
import SwingBernate.*;
import SwingBernate.ayudantes.*;
import java.awt.event.*;
import javax.swing.*;
import SwingBernate.ayudantes.ListaDoble;
import Tablon.Tablon;
import Zona.Zona;
public class vistaHacienda extends VistaBase {
	JLabel lbllngid=new JLabel("Lngid: ");
	JTextField txtlngid=new JTextField();
	JLabel lbldtoproductor=new JLabel("Dtoproductor: ");
	ComboBox cmbdtoproductor=new ComboBox(new Productor());
	JLabel lblstrnombre=new JLabel("Strnombre: ");
	JTextField txtstrnombre=new JTextField();
	JLabel lbllngdistancia=new JLabel("Lngdistancia: ");
	JTextField txtlngdistancia=new JTextField();
	JLabel lbllnghectareas=new JLabel("Lnghectareas: ");
	JTextField txtlnghectareas=new JTextField();
	JLabel lbllngcanaestimada=new JLabel("Lngcanaestimada: ");
	JTextField txtlngcanaestimada=new JTextField();
	//JLabel lblstrzona=new JLabel("Strzona: ");
	//JTextField txtstrzona=new JTextField();
	JLabel lbldtotablones=new JLabel("Dtotablones: ");  
	ListaDoble lstdtotablones=new ListaDoble("dtotablones",new Tablon());
	JLabel lbldtozona=new JLabel("Zona: ");
	ComboBox cmbdtozona=new ComboBox(new Zona());
	JLabel lbldtosubzona=new JLabel("SubZona: ");
	ComboBox cmbdtosubzona=new ComboBox(new SubZona());
	public vistaHacienda(  ActionListener controlador){
		this.setTitle("Hacienda");
		this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid,txtlngid);
		this.cmbdtoproductor.addActionListener(controlador);
		this.agregar(lbldtoproductor,cmbdtoproductor);
		this.txtstrnombre.addActionListener(controlador);
		this.agregar(lblstrnombre,txtstrnombre);
		this.txtlngdistancia.addActionListener(controlador);
		this.agregar(lbllngdistancia,txtlngdistancia);
		this.txtlnghectareas.addActionListener(controlador);
		this.agregar(lbllnghectareas,txtlnghectareas);
		this.txtlngcanaestimada.addActionListener(controlador);
		this.agregar(lbllngcanaestimada,txtlngcanaestimada);
		//this.txtstrzona.addActionListener(controlador);
		//this.agregar(lblstrzona,txtstrzona);
		this.agregar(lbldtotablones,lstdtotablones);
		this.cmbdtozona.setName("cmbDtoZona");
		this.cmbdtozona.addActionListener(controlador);
		this.agregar(lbldtozona,cmbdtozona);
		this.cmbdtosubzona.setName("cmbDtoSubZona");
		this.cmbdtosubzona.addActionListener(controlador);
		this.agregar(lbldtosubzona,cmbdtosubzona);
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
		this.setSize(500, 400);

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
	public JLabel getLbllngdistancia(){
		return lbllngdistancia;
	}
	public void setLbllngdistancia(  JLabel param){
		this.lbllngdistancia=param;
	}
	public JTextField getTxtlngdistancia(){
		return txtlngdistancia;
	}
	public void setTxtlngdistancia(  JTextField param){
		this.txtlngdistancia=param;
	}
	public JLabel getLbllnghectareas(){
		return lbllnghectareas;
	}
	public void setLbllnghectareas(  JLabel param){
		this.lbllnghectareas=param;
	}
	public JTextField getTxtlnghectareas(){
		return txtlnghectareas;
	}
	public void setTxtlnghectareas(  JTextField param){
		this.txtlnghectareas=param;
	}
	public JLabel getLbllngcanaestimada(){
		return lbllngcanaestimada;
	}
	public void setLbllngcanaestimada(  JLabel param){
		this.lbllngcanaestimada=param;
	}
	public JTextField getTxtlngcanaestimada(){
		return txtlngcanaestimada;
	}
	public void setTxtlngcanaestimada(  JTextField param){
		this.txtlngcanaestimada=param;
	}
	/*public JLabel getLblstrzona(){
    return lblstrzona;
  }
  public void setLblstrzona(  JLabel param){
    this.lblstrzona=param;
  }
  public JTextField getTxtstrzona(){
    return txtstrzona;
  }
  public void setTxtstrzona(  JTextField param){
    this.txtstrzona=param;
  }*/
	public JLabel getLbldtotablones(){
		return lbldtotablones;
	}
	public void setLbldtotablones(  JLabel param){
		this.lbldtotablones=param;
	}
	public ListaDoble getLstdtotablones(){
		return lstdtotablones;
	}
	public void setLstdtotablones(  ListaDoble param){
		this.lstdtotablones=param;
	}
	public JLabel getLbldtozona() {
		return lbldtozona;
	}
	public void setLbldtozona(JLabel lbldtozona) {
		this.lbldtozona = lbldtozona;
	}
	public ComboBox getCmbdtozona() {
		return cmbdtozona;
	}
	public void setCmbdtozona(ComboBox cmbdtozona) {
		this.cmbdtozona = cmbdtozona;
	}
	public JLabel getLbldtosubzona() {
		return lbldtosubzona;
	}
	public void setLbldtosubzona(JLabel lbldtosubzona) {
		this.lbldtosubzona = lbldtosubzona;
	}
	public ComboBox getCmbdtosubzona() {
		return cmbdtosubzona;
	}
	public void setCmbdtosubzona(ComboBox cmbdtosubzona) {
		this.cmbdtosubzona = cmbdtosubzona;
	}
}

