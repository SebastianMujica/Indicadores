package SwingBernate.ayudantes;

import java.util.ArrayList;
import java.util.List;

import Estado.Estado;
import Municipio.Municipio;
import Pais.Pais;
import Pais.modeloPais;
import Parroquia.Parroquia;
import SubZona.modeloSubZona;
import SwingBernate.dtoVacio;
import Zona.Zona;
import Zona.modeloZona;

public class ComboBoxSelect {
	
	public ComboBoxSelect(){}
	
	public void LimpiarCombos(ComboBox cmb){		
		cmb.setSelectedIndex(0);
	}
	
	public void LlenarPais(ComboBox cmbpais){
		modeloPais modpais = new modeloPais();
		javax.swing.DefaultComboBoxModel modeloComboPais=new javax.swing.DefaultComboBoxModel(modpais.buscarPaiss());		
		cmbpais.setModelo(modeloComboPais);
		cmbpais.setSelectedIndex(0);
	}
	
	public void LlenarEstado(ComboBox cmbpais, ComboBox cmbestado){
		Pais selPais = new Pais();
		javax.swing.DefaultComboBoxModel modeloComboestado=new javax.swing.DefaultComboBoxModel();
		
		if(!cmbpais.getSelectedItem().getClass().equals(new dtoVacio().getClass())){
			selPais = (Pais) cmbpais.getSelectedItem();
			modeloComboestado=new javax.swing.DefaultComboBoxModel(selPais.getEstados().toArray());	
		}
			
		cmbestado.setModelo(modeloComboestado);
		cmbestado.setSelectedIndex(0);
	}
	
	public void LlenarMunicipio(ComboBox cmbestado, ComboBox cmbmunicipio){
		Estado selEstado = new Estado();
		javax.swing.DefaultComboBoxModel modeloComboMunicipio=new javax.swing.DefaultComboBoxModel();
		if(!cmbestado.getSelectedItem().getClass().equals(new dtoVacio().getClass())){
			selEstado = (Estado) cmbestado.getSelectedItem();
			modeloComboMunicipio=new javax.swing.DefaultComboBoxModel(selEstado.getMunicipios().toArray());
		}
		
		cmbmunicipio.setModelo(modeloComboMunicipio);
		cmbmunicipio.setSelectedIndex(0);
	}
	
	public void LlenarParroquia(ComboBox cmbmunicipio, ComboBox cmbparroquia){
		Municipio selMunicipio = new Municipio();
		javax.swing.DefaultComboBoxModel modeloComboParroquia=new javax.swing.DefaultComboBoxModel();
		if(!cmbmunicipio.getSelectedItem().getClass().equals(new dtoVacio().getClass())){
			selMunicipio = (Municipio) cmbmunicipio.getSelectedItem();
			modeloComboParroquia=new javax.swing.DefaultComboBoxModel(selMunicipio.getParroquias().toArray());
		}
		
		cmbparroquia.setModelo(modeloComboParroquia);
		cmbparroquia.setSelectedIndex(0);
	}
	
	public void LlenarZona(ComboBox cmbzona){
		modeloZona modzona = new modeloZona();
		javax.swing.DefaultComboBoxModel modeloComboZona=new javax.swing.DefaultComboBoxModel(modzona.buscarZonas());
		cmbzona.setModelo(modeloComboZona);
		cmbzona.setSelectedIndex(0);
	}
	
	public void LlenarSubZona(ComboBox cmbzona, ComboBox cmbsubzona){
		Zona selZona = new Zona();
		javax.swing.DefaultComboBoxModel modeloComboSubZona=new javax.swing.DefaultComboBoxModel();
		if(!cmbzona.getSelectedItem().getClass().equals(new dtoVacio().getClass())){
			modeloSubZona modsubzona = new modeloSubZona();
			selZona = (Zona) cmbzona.getSelectedItem();
			modeloComboSubZona = new javax.swing.DefaultComboBoxModel( selZona.getSubzonas().toArray());
		}
		cmbsubzona.setModelo(modeloComboSubZona);
		cmbsubzona.setSelectedIndex(0);
	}
	
}
