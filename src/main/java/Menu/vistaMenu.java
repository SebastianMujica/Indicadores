package Menu;

import SwingBernate.*;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ListaFiltro;

import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class vistaMenu extends VistaBase implements ActionListener{

	JLabel lbllngid=new JLabel("Id: ");
	JTextField txtlngid=new JTextField(15);
	JLabel lblstrnombre=new JLabel("Nombre: ");
	JTextField txtstrnombre=new JTextField(40);
	JLabel lblstrsigla=new JLabel("Sigla: ");
	JTextField txtstrsigla=new JTextField(20);
	JLabel lblbolsubmenu=new JLabel("Es SubMenú: ");
	JCheckBox chkbolsubmenu=new JCheckBox();
	JLabel lbldtomenu=new JLabel("SubMenú: ");
	ComboBox cmbdtomenu=new ComboBox(new Menu());
	JLabel lblstrpaquete=new JLabel("Paquete: ");
	JTextField txtstrpaquete=new JTextField(100);
	JLabel lbldtonodo=new JLabel("Lista Filtro: ");
	ListaFiltro lsfdtonodo = new ListaFiltro("Nodos",new Menu());
	
	JLabel lblbolactivo=new JLabel("Activo: ");
	JCheckBox chkbolactivo=new JCheckBox();
	
	JLabel lblintnivel=new JLabel("Shrnivel: ");
	JComboBox cmbintnivel=new JComboBox();
	JLabel lblintpos_rel=new JLabel("Shrpos_rel: ");
	JComboBox cmbintpos_rel=new JComboBox();
	
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
	

	public vistaMenu(ActionListener controlador){
		
		this.setTitle("Menú");
		
		this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid,txtlngid,"","width 150px,wrap 1");
		this.txtstrnombre.addActionListener(controlador);
		this.agregar(lblstrnombre,txtstrnombre,"","growx,width 280px,wrap 1");
		this.txtstrsigla.addActionListener(controlador);
		this.agregar(lblstrsigla,txtstrsigla,"","width 150px,wrap 1");
		//check menu item
		this.agregar(lblbolsubmenu, chkbolsubmenu,"","width 100px,wrap 1");
		this.chkbolsubmenu.setActionCommand("submenu");
		this.chkbolsubmenu.setSelected(false);
		this.chkbolsubmenu.addActionListener(this);
		//Combo subMenu
		this.cmbdtomenu.addActionListener(controlador);
		this.agregar(lbldtomenu, cmbdtomenu,"","growx,width 280px,wrap 1");		
		this.txtstrpaquete.addActionListener(controlador);
		this.agregar(lblstrpaquete,txtstrpaquete,"","growx,width 280px,wrap 1");
		//this.agregar(lbldtonodo,lsfdtonodo);
		this.cmbintnivel.setName("cmbshrnivel");
		this.cmbintnivel.addActionListener(controlador);
		this.agregar(lblintnivel,cmbintnivel,"","width 280px,wrap 1");
		this.cmbintpos_rel.setName("cmbshrpos_rel");
		this.cmbintpos_rel.addActionListener(controlador);
		this.agregar(lblintpos_rel,cmbintpos_rel,"","width 200px,wrap 1");
		this.agregar(lblbolactivo,chkbolactivo,"","width 100px,wrap 1");
		
		this.getButtonNuevo().addActionListener(controlador);
		this.getButtonBuscar().addActionListener(controlador);
		this.getButtonEliminar().addActionListener(controlador);
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
		
		this.setSize(500,350);
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
	public JLabel getLblstrsigla(){
		return lblstrsigla;
	}
	public void setLblstrsigla(  JLabel param){
		this.lblstrsigla=param;
	}
	public JTextField getTxtstrsigla(){
		return txtstrsigla;
	}
	public void setTxtstrsigla(  JTextField param){
		this.txtstrsigla=param;
	}
	public JLabel getLblstrpaquete(){
		return lblstrpaquete;
	}
	public void setLblstrpaquete(  JLabel param){
		this.lblstrpaquete=param;
	}
	public JTextField getTxtstrpaquete(){
		return txtstrpaquete;
	}
	public void setTxtstrpaquete(  JTextField param){
		this.txtstrpaquete=param;
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

	public JLabel getLblbolsubmenu() {
		return lblbolsubmenu;
	}
	public void setLblbolsubmenu(JLabel lblbolsubmenu) {
		this.lblbolsubmenu = lblbolsubmenu;
	}
	public JCheckBox getChkbolsubmenu() {
		return chkbolsubmenu;
	}
	public void setChkbolsubmenu(JCheckBox chkbolsubmenu) {
		this.chkbolsubmenu = chkbolsubmenu;
	}
	public JLabel getLbldtomenu() {
		return lbldtomenu;
	}
	public void setLbldtomenu(JLabel lbldtomenu) {
		this.lbldtomenu = lbldtomenu;
	}

	public ComboBox getCmbdtomenu() {
		return cmbdtomenu;
	}

	public void setCmbdtomenu(ComboBox cmbdtomenu) {
		this.cmbdtomenu = cmbdtomenu;
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

	public JLabel getLblintnivel() {
		return lblintnivel;
	}

	public void setLblintnivel(JLabel lblintnivel) {
		this.lblintnivel = lblintnivel;
	}

	public JComboBox getCmbintnivel() {
		return cmbintnivel;
	}

	public void setCmbintnivel(JComboBox cmbintnivel) {
		this.cmbintnivel = cmbintnivel;
	}

	public JLabel getLblintpos_rel() {
		return lblintpos_rel;
	}

	public void setLblintpos_rel(JLabel lblintpos_rel) {
		this.lblintpos_rel = lblintpos_rel;
	}

	public JComboBox getCmbintpos_rel() {
		return cmbintpos_rel;
	}

	public void setCmbintpos_rel(JComboBox cmbintpos_rel) {
		this.cmbintpos_rel = cmbintpos_rel;
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

	public JDateChooser getDchdtmvalido_hasta() {
		return dchdtmvalido_hasta;
	}

	public void setDchdtmvalido_hasta(JDateChooser dchdtmvalidoHasta) {
		dchdtmvalido_hasta = dchdtmvalidoHasta;
	}

	public JLabel getLbldtonodo() {
		return lbldtonodo;
	}

	public void setLbldtonodo(JLabel lbldtonodo) {
		this.lbldtonodo = lbldtonodo;
	}

	public ListaFiltro getLsfdtonodo() {
		return lsfdtonodo;
	}

	public void setLsfdtonodo(ListaFiltro lsfdtonodo) {
		this.lsfdtonodo = lsfdtonodo;
	}

	public JDateChooser getDchdtmvalido_desde() {
		return dchdtmvalido_desde;
	}

	public void setDchdtmvalido_desde(JDateChooser dchdtmvalidoDesde) {
		dchdtmvalido_desde = dchdtmvalidoDesde;
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if("submenu".equals(arg0.getActionCommand())){
			boolean select = this.chkbolsubmenu.isSelected();
			this.lblstrpaquete.setVisible(!select);
			this.txtstrpaquete.setVisible(!select);			
		}
	}
}
