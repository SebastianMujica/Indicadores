package Remesa;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Hacienda.Hacienda;
import Nucleo.Nucleo;
import Productor.Productor;
import SwingBernate.VistaBase;
import SwingBernate.ayudantes.ComboBox;
import SwingBernate.ayudantes.ListaDoble;
import Tablon.Tablon;

public class vistaGenerarRemesa extends VistaBase {

	JLabel lbldtonucleo=new JLabel("Dtonucleo: ");
	ComboBox cmbdtonucleo=new ComboBox(new Nucleo());
	JLabel lbldtoproductor=new JLabel("Dtoproductor: ");
	ComboBox cmbdtoproductor=new ComboBox(new Productor());
	JLabel lbldtohacienda=new JLabel("Dtohacienda: ");
	ComboBox cmbdtohacienda=new ComboBox(new Hacienda());
	JLabel lbltablonesacosechar=new JLabel("Tablonesacosechar: ");
	ListaDoble lsttablonesacosechar=new ListaDoble("tablonesacosechar",new Tablon());

	public vistaGenerarRemesa(ActionListener controlador){
		this.setTitle("Generar Remesas");
		
		this.cmbdtonucleo.addActionListener(controlador);
		this.agregar(lbldtonucleo, cmbdtonucleo);
		this.cmbdtoproductor.addActionListener(controlador);
		this.agregar(lbldtoproductor, cmbdtoproductor);
		this.cmbdtohacienda.addActionListener(controlador);
		this.agregar(lbldtohacienda, cmbdtohacienda);
		this.agregar(lbltablonesacosechar, lsttablonesacosechar);
		
		this.getCentro2().setVisible(false);
	    this.getCentro().setVisible(true);
	    this.getButtonVistaR().setEnabled(false);
	}

	public JLabel getLbldtonucleo() {
		return lbldtonucleo;
	}

	public void setLbldtonucleo(JLabel lbldtonucleo) {
		this.lbldtonucleo = lbldtonucleo;
	}

	public ComboBox getCmbdtonucleo() {
		return cmbdtonucleo;
	}

	public void setCmbdtonucleo(ComboBox cmbdtonucleo) {
		this.cmbdtonucleo = cmbdtonucleo;
	}

	public JLabel getLbldtoproductor() {
		return lbldtoproductor;
	}

	public void setLbldtoproductor(JLabel lbldtoproductor) {
		this.lbldtoproductor = lbldtoproductor;
	}

	public ComboBox getCmbdtoproductor() {
		return cmbdtoproductor;
	}

	public void setCmbdtoproductor(ComboBox cmbdtoproductor) {
		this.cmbdtoproductor = cmbdtoproductor;
	}

	public JLabel getLbldtohacienda() {
		return lbldtohacienda;
	}

	public void setLbldtohacienda(JLabel lbldtohacienda) {
		this.lbldtohacienda = lbldtohacienda;
	}

	public ComboBox getCmbdtohacienda() {
		return cmbdtohacienda;
	}

	public void setCmbdtohacienda(ComboBox cmbdtohacienda) {
		this.cmbdtohacienda = cmbdtohacienda;
	}

	public JLabel getLbltablonesacosechar() {
		return lbltablonesacosechar;
	}

	public void setLbltablonesacosechar(JLabel lbltablonesacosechar) {
		this.lbltablonesacosechar = lbltablonesacosechar;
	}

	public ListaDoble getLsttablonesacosechar() {
		return lsttablonesacosechar;
	}

	public void setLsttablonesacosechar(ListaDoble lsttablonesacosechar) {
		this.lsttablonesacosechar = lsttablonesacosechar;
	}	
}
