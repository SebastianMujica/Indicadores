package Zona;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

//import moduloPrototipo.dto.dtoSubZona;

import Estado.Estado;
import Municipio.Municipio;
import Organizacion.Organizacion;
import Pais.Pais;
import Parroquia.Parroquia;
import SwingBernate.VistaBase;
import SwingBernate.ayudantes.AyudanteGrid;
import SwingBernate.ayudantes.ComboBox;

public class vistaZona extends VistaBase {
	
	JLabel     lbllngid   = new JLabel("Id:");
	JTextField txtlngid   = new JTextField(15);
	JLabel lbldto_org=new JLabel("Organización: ");
	ComboBox cmbdto_org=new ComboBox(new Organizacion());
	JLabel lblstrcodigo=new JLabel("Código: ");
	JTextField txtstrcodigo=new JTextField(20);
	JLabel     lblstrnombre   = new JLabel("Zona:");
	JTextField txtstrnombre   = new JTextField(30);
	JLabel     lbldtopais   = new JLabel("Pais:");
	ComboBox cmbdtopais = new ComboBox(new Pais());
	JLabel     lbldtoestado   = new JLabel("Estado:");
	ComboBox cmbdtoestado = new ComboBox(new Estado());
	JLabel     lbldtomunicipio   = new JLabel("Municipio:");
	ComboBox cmbdtomunicipio = new ComboBox(new Municipio());
	JLabel     lbldtoparroquia   = new JLabel("Parroquia:");
	ComboBox cmbdtoparroquia = new ComboBox(new Parroquia());
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

	public vistaZona(ActionListener controlador){
		this.setTitle("Zonas");
	    
	    this.txtlngid.setName("txtlngid");
	    this.txtlngid.addKeyListener((KeyListener) controlador);
		this.txtlngid.addActionListener(controlador);
		this.agregar(lbllngid, txtlngid, "", "width 150px,wrap 1");
		
		this.cmbdto_org.addActionListener(controlador);
		this.cmbdto_org.setName("cmbdto_org");
		this.agregar(lbldto_org, cmbdto_org,"","growx,width 300px,wrap 1");
		
		this.txtstrcodigo.setName("txtstrcodigo");
	    this.txtstrcodigo.addKeyListener((KeyListener) controlador);
		this.txtstrcodigo.addActionListener(controlador);
		this.agregar(lblstrcodigo, txtstrcodigo, "", "width 150px,wrap 1");
		
		this.txtstrnombre.setName("txtstrnombre");
	    this.txtstrnombre.addKeyListener((KeyListener) controlador);
		this.txtstrnombre.addActionListener(controlador);
		this.agregar(lblstrnombre, txtstrnombre, "", "width 250px,wrap 1");
		
		this.cmbdtopais.addActionListener(controlador);
		this.cmbdtopais.setName("cmbDtopais");
		this.agregar(lbldtopais, cmbdtopais,"","growx,width 350px,wrap 1");
		
		this.cmbdtoestado.addActionListener(controlador);
		this.cmbdtoestado.setName("cmbDtoestado");
		this.agregar(lbldtoestado, cmbdtoestado,"","growx,width 350px,wrap 1");
		
		this.cmbdtomunicipio.addActionListener(controlador);
		this.cmbdtomunicipio.setName("cmbDtomunicipio");
		this.agregar(lbldtomunicipio, cmbdtomunicipio,"","growx,width 250px,wrap 1");
		
		this.cmbdtoparroquia.addActionListener(controlador);
		this.cmbdtoparroquia.setName("cmbDtoparroquia");
		this.agregar(lbldtoparroquia, cmbdtoparroquia,"","growx,width 250px,wrap 1");
		
		this.chkbolactivo.setName("chkbolactivo");
		this.chkbolactivo.addActionListener(controlador);
		this.agregar(lblbolactivo,chkbolactivo,"","width 50px,wrap 1");
						
		this.getButtonNuevo().addActionListener(controlador);
		this.getButtonBuscar().addActionListener(controlador);
		this.getButtonEliminar().addActionListener(controlador);
		this.getButtonGuardar().addActionListener(controlador);
		this.getButtonCancelar().addActionListener(controlador);
		this.getButtonSiguiente().addActionListener(controlador);
		this.getButtonAnterior().addActionListener(controlador);
		this.getMenuItemNuevo().addActionListener(controlador);
		this.getMenuItemBuscar().addActionListener(controlador);
		this.getMenuItemEliminar().addActionListener(controlador);
		this.getMenuItemGuardar().addActionListener(controlador);
		this.getMenuItemSalir().addActionListener(controlador);
		this.getButtonVistaR().addActionListener(controlador);
		this.setSize(500,400);		
	}

	public JLabel getLbllngid() {
		return lbllngid;
	}

	public void setLbllngid(JLabel lbllngid) {
		this.lbllngid = lbllngid;
	}

	public JTextField getTxtlngid() {
		return txtlngid;
	}

	public void setTxtlngid(JTextField txtlngid) {
		this.txtlngid = txtlngid;
	}

	public JLabel getLblstrnombre() {
		return lblstrnombre;
	}

	public void setLblstrnombre(JLabel lblstrnombre) {
		this.lblstrnombre = lblstrnombre;
	}

	public JTextField getTxtstrnombre() {
		return txtstrnombre;
	}

	public void setTxtstrnombre(JTextField txtstrnombre) {
		this.txtstrnombre = txtstrnombre;
	}

	public JLabel getLbldtopais() {
		return lbldtopais;
	}

	public void setLbldtopais(JLabel lbldtopais) {
		this.lbldtopais = lbldtopais;
	}

	public ComboBox getCmbdtopais() {
		return cmbdtopais;
	}

	public void setCmbdtopais(ComboBox cmbdtopais) {
		this.cmbdtopais = cmbdtopais;
	}

	public JLabel getLbldtoestado() {
		return lbldtoestado;
	}

	public void setLbldtoestado(JLabel lbldtoestado) {
		this.lbldtoestado = lbldtoestado;
	}

	public ComboBox getCmbdtoestado() {
		return cmbdtoestado;
	}

	public void setCmbdtoestado(ComboBox cmbdtoestado) {
		this.cmbdtoestado = cmbdtoestado;
	}

	public JLabel getLbldtomunicipio() {
		return lbldtomunicipio;
	}

	public void setLbldtomunicipio(JLabel lbldtomunicipio) {
		this.lbldtomunicipio = lbldtomunicipio;
	}

	public ComboBox getCmbdtomunicipio() {
		return cmbdtomunicipio;
	}

	public void setCmbdtomunicipio(ComboBox cmbdtomunicipio) {
		this.cmbdtomunicipio = cmbdtomunicipio;
	}

	public JLabel getLbldtoparroquia() {
		return lbldtoparroquia;
	}

	public void setLbldtoparroquia(JLabel lbldtoparroquia) {
		this.lbldtoparroquia = lbldtoparroquia;
	}

	public ComboBox getCmbdtoparroquia() {
		return cmbdtoparroquia;
	}

	public void setCmbdtoparroquia(ComboBox cmbdtoparroquia) {
		this.cmbdtoparroquia = cmbdtoparroquia;
	}	

	public JDateChooser getDchdtmvalido_hasta() {
		return dchdtmvalido_hasta;
	}

	public void setDchdtmvalido_hasta(JDateChooser dchdtmvalidoHasta) {
		dchdtmvalido_hasta = dchdtmvalidoHasta;
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

	public JLabel getLbldto_org() {
		return lbldto_org;
	}

	public void setLbldto_org(JLabel lbldtoOrg) {
		lbldto_org = lbldtoOrg;
	}

	public ComboBox getCmbdto_org() {
		return cmbdto_org;
	}

	public void setCmbdto_org(ComboBox cmbdtoOrg) {
		cmbdto_org = cmbdtoOrg;
	}

	public JLabel getLblstrcodigo() {
		return lblstrcodigo;
	}

	public void setLblstrcodigo(JLabel lblstrcodigo) {
		this.lblstrcodigo = lblstrcodigo;
	}

	public JTextField getTxtstrcodigo() {
		return txtstrcodigo;
	}

	public void setTxtstrcodigo(JTextField txtstrcodigo) {
		this.txtstrcodigo = txtstrcodigo;
	}

	public void setDtoZona(Zona dto){
		this.txtlngid.setText(""+dto.getLngid());
		this.txtstrnombre.setText(dto.getStrnombre());
		this.dchdtmvalido_hasta.setDate(dto.getDtmvalido_hasta());
	}

	public Zona getDtoZona(){
		Zona dto= new Zona();
		dto.setLngid(Long.parseLong(this.getTxtlngid().getText()));
		dto.setStrnombre(this.getTxtstrnombre().getText());
		return dto;
	}

	@Override
	public String toString() {
		return "vistaZona";
	}
	
}
