package Remesa;

import java.awt.event.ActionListener;

import Hacienda.modeloHacienda;
import Nucleo.modeloNucleo;
import Productor.modeloProductor;
import SwingBernate.ControladorBase;

public class controladorGenerarRemesa extends ControladorBase  implements ActionListener {
	
	public controladorGenerarRemesa(){
		vistaGenerarRemesa vista = new vistaGenerarRemesa(this);
		Remesa dto=new Remesa();
	    this.iniciarSesion(vista,dto);
	    this.actualizarVista();
	}
	
	public void actualizarVista(){
		vistaGenerarRemesa vista=(vistaGenerarRemesa)this.getSession().getVista();
	    Remesa dto=new Remesa();
	    modeloNucleo modeloNucleo=new modeloNucleo();
	    javax.swing.DefaultComboBoxModel modeloComboNucleo=new javax.swing.DefaultComboBoxModel(modeloNucleo.buscarNucleos());
	    vista.getCmbdtonucleo().setModel(modeloComboNucleo);
	    modeloProductor modeloProductor=new modeloProductor();
	    javax.swing.DefaultComboBoxModel modeloComboProductor=new javax.swing.DefaultComboBoxModel(modeloProductor.buscarProductors());
	    vista.getCmbdtoproductor().setModel(modeloComboProductor);
	    modeloHacienda modeloHacienda=new modeloHacienda();
	    javax.swing.DefaultComboBoxModel modeloComboHacienda=new javax.swing.DefaultComboBoxModel(modeloHacienda.buscarHaciendas());
	    vista.getCmbdtohacienda().setModel(modeloComboHacienda);
	}

}
