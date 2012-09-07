package Perfil;
import java.util.*;

import Menu.Menu;
import Organizacion.Organizacion;
import SwingBernate.*;
import SwingBernate.ayudantes.*;

import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class vistaPerfil extends VistaBase {
	JLabel lbllngid=new JLabel("Id: ");
	JTextField txtlngid=new JTextField(15);
	JLabel lbldto_org=new JLabel("Organización: ");
	ComboBox cmbdto_org=new ComboBox(new Organizacion());
	JLabel lblstrcodigo=new JLabel("Código: ");
	JTextField txtstrcodigo=new JTextField(15);
	JLabel lblstrnombre=new JLabel("Nombre: ");
	JTextField txtstrnombre=new JTextField(30);
	JLabel lblstrdescripcion=new JLabel("Descripción: ");
	JTextField txtstrdescripcion=new JTextField(255);

	JLabel lbldto_menu=new JLabel("Menu: ");
	ListaDoble lstdto_menu=new ListaDoble("Ítems",new Menu());
	JLabel lbldto_menu2=new JLabel("Menú: ");
	TablaCheckBox tbldto_menu = new TablaCheckBox();

	JLabel lblbolactivo=new JLabel("Activo: ");
	JCheckBox chkbolactivo=new JCheckBox();

	JTextField txtstrip_creacion=new JTextField();
	JTextField txtstrip_modificacion=new JTextField();
	JTextField txtstrhost_creacion=new JTextField();
	JTextField txtstrhost_modificacion=new JTextField();
	JDateChooser  dchdtmfecha_creacion   = new JDateChooser();
	JDateChooser  dchdtmfecha_modificacion   = new JDateChooser();
	JDateChooser  dchdtmvalido_desde   = new JDateChooser();
	JDateChooser  dchdtmvalido_hasta   = new JDateChooser();
	JTextField txtlngseg_usuario_creacion=new JTextField(2);
	JTextField txtlngseg_usuario_modificacion=new JTextField(2);

	public vistaPerfil(  ActionListener controlador){
		this.setTitle("Seguridad::.Perfil de Usuario");

		this.txtlngid.setName("txtlngid");
		this.txtlngid.addKeyListener((KeyListener) controlador);
		this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
		this.cmbdto_org.addActionListener(controlador);
		this.agregar(lbldto_org,cmbdto_org,"","width 250px,wrap 1");

		this.txtstrcodigo.setName("txtstrcodigo");
		this.txtstrcodigo.addKeyListener((KeyListener) controlador);
		this.txtstrcodigo.addActionListener(controlador);
		this.agregar(lblstrcodigo,txtstrcodigo,"","width 90px,wrap 1");

		this.txtstrnombre.setName("txtstrnombre");
		this.txtstrnombre.addKeyListener((KeyListener) controlador);
		this.txtstrnombre.addActionListener(controlador);
		this.agregar(lblstrnombre,txtstrnombre,"","width 250px,wrap 1");

		this.txtstrdescripcion.setName("txtstrdescripcion");
		this.txtstrdescripcion.addKeyListener((KeyListener) controlador);
		this.txtstrdescripcion.addActionListener(controlador);
		this.agregar(lblstrdescripcion,txtstrdescripcion,"","width 250px,wrap 1");

		//this.agregar(lbldto_menu,lstdto_menu,"","growx,width 350px,wrap 1");
		this.tbldto_menu.setName("tbl_menu");
		this.agregar(lbldto_menu2,tbldto_menu,"","growx,width 350px, height 350px,wrap 1");

		this.chkbolactivo.setName("chkbolactivo");
		this.chkbolactivo.addActionListener(controlador);
		this.agregar(lblbolactivo,chkbolactivo,"","width 50px,wrap 1");

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
		this.setSize(700, 500);
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
	public JTextField getTxtstrip_creacion() {
		return txtstrip_creacion;
	}
	public void setTxtstrip_creacion(JTextField txtstripCreacion) {
		txtstrip_creacion = txtstripCreacion;
	}
	public JTextField getTxtstrip_modificacion() {
		return txtstrip_modificacion;
	}
	public void setTxtstrip_modificacion(JTextField txtstripModificacion) {
		txtstrip_modificacion = txtstripModificacion;
	}
	public JTextField getTxtstrhost_creacion() {
		return txtstrhost_creacion;
	}
	public void setTxtstrhost_creacion(JTextField txtstrhostCreacion) {
		txtstrhost_creacion = txtstrhostCreacion;
	}
	public JTextField getTxtstrhost_modificacion() {
		return txtstrhost_modificacion;
	}
	public void setTxtstrhost_modificacion(JTextField txtstrhostModificacion) {
		txtstrhost_modificacion = txtstrhostModificacion;
	}
	public JDateChooser getDchdtmfecha_creacion() {
		return dchdtmfecha_creacion;
	}
	public void setDchdtmfecha_creacion(JDateChooser dchdtmfechaCreacion) {
		dchdtmfecha_creacion = dchdtmfechaCreacion;
	}
	public JDateChooser getDchdtmfecha_modificacion() {
		return dchdtmfecha_modificacion;
	}
	public void setDchdtmfecha_modificacion(JDateChooser dchdtmfechaModificacion) {
		dchdtmfecha_modificacion = dchdtmfechaModificacion;
	}
	public JDateChooser getDchdtmvalido_desde() {
		return dchdtmvalido_desde;
	}
	public void setDchdtmvalido_desde(JDateChooser dchdtmvalidoDesde) {
		dchdtmvalido_desde = dchdtmvalidoDesde;
	}
	public JDateChooser getDchdtmvalido_hasta() {
		return dchdtmvalido_hasta;
	}
	public void setDchdtmvalido_hasta(JDateChooser dchdtmvalidoHasta) {
		dchdtmvalido_hasta = dchdtmvalidoHasta;
	}
	public JTextField getTxtlngseg_usuario_creacion() {
		return txtlngseg_usuario_creacion;
	}
	public void setTxtlngseg_usuario_creacion(JTextField txtlngsegUsuarioCreacion) {
		txtlngseg_usuario_creacion = txtlngsegUsuarioCreacion;
	}
	public JTextField getTxtlngseg_usuario_modificacion() {
		return txtlngseg_usuario_modificacion;
	}
	public void setTxtlngseg_usuario_modificacion(
			JTextField txtlngsegUsuarioModificacion) {
		txtlngseg_usuario_modificacion = txtlngsegUsuarioModificacion;
	}
	public JLabel getLblbolactivo() {
		return lblbolactivo;
	}
	public void setLblbolactivo(JLabel lblbolactivo) {
		this.lblbolactivo = lblbolactivo;
	}
	public JCheckBox getChkbolactivo() {
		return chkbolactivo;
	}
	public void setChkbolactivo(JCheckBox chkbolactivo) {
		this.chkbolactivo = chkbolactivo;
	}
	public JLabel getLbldto_menu() {
		return lbldto_menu;
	}
	public void setLbldto_menu(JLabel lbldtoMenu) {
		lbldto_menu = lbldtoMenu;
	}
	public ListaDoble getLstdto_menu() {
		return lstdto_menu;
	}
	public void setLstdto_menu(ListaDoble lstdtoMenu) {
		lstdto_menu = lstdtoMenu;
	}
	public JLabel getLbldto_menu2() {
		return lbldto_menu2;
	}
	public void setLbldto_menu2(JLabel lbldtoMenu2) {
		lbldto_menu2 = lbldtoMenu2;
	}
	public TablaCheckBox getTbldto_menu() {
		return tbldto_menu;
	}
	public void setTbldto_menu(TablaCheckBox tbldtoMenu) {
		tbldto_menu = tbldtoMenu;
	}
	
	public void marcarItemsMenu(){
		
		List<Object> lst = this.lstdto_menu.getSelected();
		this.tbldto_menu.desactivarTodos();
		
		for (Object object : lst) {
			//System.out.println( ((Menu)object).getStrnombre() );
			Menu selMenu = (Menu)object;
			//this.tbldto_menu.activarNodos(selMenu, true);
			int fila = this.tbldto_menu.buscarNodoTabla(selMenu);
			this.tbldto_menu.activarPadres(selMenu, true, fila);
		}
		
		/*Object arrMenu[] = this.lstdto_menu.getModeloLstA().toArray();
		if(arrMenu.length>0){
			this.tbldto_menu.desactivarTodos();
			for (int i = 0; i < arrMenu.length; i++) {
				Menu selMenu = (Menu)arrMenu[i];
				this.tbldto_menu.activarNodos(selMenu, true);
				int fila = this.tbldto_menu.buscarNodoTabla(selMenu);
				this.tbldto_menu.activarPadres(selMenu, true, fila);
			}
		}else
			this.tbldto_menu.desactivarTodos();*/
	}

}
