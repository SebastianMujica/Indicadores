package SwingBernate.ayudantes;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Estado.Estado;
import Municipio.Municipio;
import Pais.Pais;
import Pais.modeloPais;
import Parroquia.Parroquia;
import SwingBernate.DtoBase;

public class ComponenteUbicacion extends JPanel implements ActionListener {
	
	private JLabel lblcmbdtopais = new JLabel("País: ");
	private JLabel lblcmbdtoestado = new JLabel("Estado: ");
	private JLabel lblcmbdtomunicipio = new JLabel("Municipio: ");
	private JLabel lblcmbdtoparroquia = new JLabel("Parroquia: ");
	
	private Pais elPais = new Pais();
	private Estado elEstado = new Estado();
	private Municipio elMunicipio = new Municipio();
	private Parroquia laParroquia = new Parroquia();
	
	private ComboBox cmbdtopais = new ComboBox(elPais);
	private ComboBox cmbdtoestado = new ComboBox(elEstado);
	private ComboBox cmbdtomunicipio = new ComboBox(elMunicipio);
	private ComboBox cmbdtoparroquia = new ComboBox(laParroquia);
		
	GridBagConstraints c = new GridBagConstraints();
	
	public ComponenteUbicacion(){
		
		this.setLayout(new GridBagLayout());		
		c.insets = new Insets(3,3,3,3);
		
		this.cmbdtopais.setMaximumRowCount(6);
		this.cmbdtoestado.setMaximumRowCount(6);
		this.cmbdtomunicipio.setMaximumRowCount(6);
		this.cmbdtoparroquia.setMaximumRowCount(6);
		
		//Pais		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.NONE;
		this.add(this.lblcmbdtopais,c);
		c.gridx = 1;
		c.gridy = 0;
		c.fill=GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(this.cmbdtopais,c);
		lblcmbdtopais.setLabelFor(this.cmbdtopais);
		
		//estado
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 1;
		this.add(this.lblcmbdtoestado,c);
		c.fill=GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 1;
		c.gridy = 1;
		this.add(this.cmbdtoestado,c);
		lblcmbdtoestado.setLabelFor(this.cmbdtoestado);
		
		//municipio
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 2;
		this.add(this.lblcmbdtomunicipio,c);
		c.fill=GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 1;
		c.gridy = 2;
		this.add(this.cmbdtomunicipio,c);
		lblcmbdtomunicipio.setLabelFor(this.cmbdtomunicipio);
		
		//parroquia
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 3;
		this.add(this.lblcmbdtoparroquia,c);
		c.fill=GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 1;
		c.gridy = 3;
		this.add(this.cmbdtoparroquia,c);
		lblcmbdtoparroquia.setLabelFor(this.cmbdtoparroquia);
		
		this.cmbdtopais.addActionListener(this);
		this.cmbdtoestado.addActionListener(this);
		this.cmbdtomunicipio.addActionListener(this);
		this.cmbdtoparroquia.addActionListener(this);
		
		this.LlenarPais();
		this.LlenarEstado();
		this.LlenarMunicipio();
		this.LlenarParroquia();
	}
	
	public void LimpiarCombos(){		
		this.cmbdtopais.setSelectedIndex(0);
	}
	
	public void LlenarPais(){
		modeloPais modpais = new modeloPais();
		Pais arrPais[] = modpais.buscarPaiss();
		Pais auxPais = new Pais();
		auxPais.setBolactivo(true);
		auxPais.setLngid(0);
		auxPais.setStrnombre("---");
		auxPais.setStrsigla("---");
		List<Pais> lstPais = new ArrayList<Pais>();
		lstPais.add(auxPais);
		for (int i = 0; i < arrPais.length; i++) {
			lstPais.add(arrPais[i]);
		}
		
		javax.swing.DefaultComboBoxModel modeloComboPais=new javax.swing.DefaultComboBoxModel(lstPais.toArray());
		this.cmbdtopais.setModel(modeloComboPais);
		this.cmbdtopais.setSelectedIndex(0);
	}
	
	public void LlenarEstado(){
		Pais selPais = (Pais) this.cmbdtopais.getSelectedItem();
		Estado auxEstado = new Estado();
		auxEstado.setBolactivo(true);
		auxEstado.setLngid(0);
		auxEstado.setStrnombre("---");
		auxEstado.setStrsigla("---");
		List<Estado> lstEstado = new ArrayList<Estado>();
		lstEstado.add(auxEstado);
		if(selPais.getLngid() != 0){
			lstEstado.addAll(1, selPais.getEstados());
		}
		javax.swing.DefaultComboBoxModel modeloComboestado=new javax.swing.DefaultComboBoxModel(lstEstado.toArray());
		this.cmbdtoestado.setModel(modeloComboestado);
		this.cmbdtoestado.setSelectedIndex(0);
	}
	
	public void LlenarMunicipio(){
		Estado selEstado = (Estado) this.cmbdtoestado.getSelectedItem();
		Municipio auxMunicipio = new Municipio();
		auxMunicipio.setBolactivo(true);
		auxMunicipio.setLngid(0);
		auxMunicipio.setStrnombre("---");
		auxMunicipio.setStrsigla("---");
		List<Municipio> lstMunicipio = new ArrayList<Municipio>();
		lstMunicipio.add(auxMunicipio);
		if(selEstado.getLngid() != 0){
			lstMunicipio.addAll(1, selEstado.getMunicipios());
		}
		javax.swing.DefaultComboBoxModel modeloComboMunicipio=new javax.swing.DefaultComboBoxModel(lstMunicipio.toArray());
		this.cmbdtomunicipio.setModel(modeloComboMunicipio);
		this.cmbdtomunicipio.setSelectedIndex(0);
	}
	
	public void LlenarParroquia(){
		Municipio selMunicipio = (Municipio) this.cmbdtomunicipio.getSelectedItem();
		Parroquia auxParroquia = new Parroquia();
		auxParroquia.setBolactivo(true);
		auxParroquia.setLngid(0);
		auxParroquia.setStrnombre("---");
		auxParroquia.setStrsigla("---");
		List<Parroquia> lstParroquia = new ArrayList<Parroquia>();
		lstParroquia.add(auxParroquia);
		if(selMunicipio.getLngid() != 0){
			lstParroquia.addAll(1, selMunicipio.getParroquias());
		}
		javax.swing.DefaultComboBoxModel modeloComboParroquia=new javax.swing.DefaultComboBoxModel(lstParroquia.toArray());
		this.cmbdtoparroquia.setModel(modeloComboParroquia);
		this.cmbdtoparroquia.setSelectedIndex(0);
	}
	
	public List<DtoBase> getSeleccionados(){
		List<DtoBase> lstDto = new ArrayList<DtoBase>();
		if(this.cmbdtopais.getSelectedIndex()>0 && this.cmbdtoestado.getSelectedIndex()>0 &&
				this.cmbdtomunicipio.getSelectedIndex()>0 && this.cmbdtoparroquia.getSelectedIndex()>0){
			lstDto.clear();
			lstDto.add((DtoBase)this.cmbdtopais.getSelectedItem());
			lstDto.add((DtoBase)this.cmbdtoestado.getSelectedItem());
			lstDto.add((DtoBase)this.cmbdtomunicipio.getSelectedItem());
			lstDto.add((DtoBase)this.cmbdtoparroquia.getSelectedItem());
		}
		
		return lstDto;
	}
	
	public void setSeleccionados(List<DtoBase> lstDto){
		if(lstDto.size()==4){
			//this.LlenarPais();
			this.cmbdtopais.setSelectedItem((Pais)lstDto.get(0));
			this.LlenarEstado();
			this.cmbdtoestado.setSelectedItem((Estado)lstDto.get(1));
			this.LlenarMunicipio();
			this.cmbdtomunicipio.setSelectedItem((Municipio)lstDto.get(2));
			this.LlenarParroquia();
			this.cmbdtoparroquia.setSelectedItem((Parroquia)lstDto.get(3));
		}		
	}
	
	public JLabel getLblcmbdtopais() {
		return lblcmbdtopais;
	}

	public void setLblcmbdtopais(JLabel lblcmbdtopais) {
		this.lblcmbdtopais = lblcmbdtopais;
	}

	public JLabel getLblcmbdtoestado() {
		return lblcmbdtoestado;
	}

	public void setLblcmbdtoestado(JLabel lblcmbdtoestado) {
		this.lblcmbdtoestado = lblcmbdtoestado;
	}

	public JLabel getLblcmbdtomunicipio() {
		return lblcmbdtomunicipio;
	}

	public void setLblcmbdtomunicipio(JLabel lblcmbdtomunicipio) {
		this.lblcmbdtomunicipio = lblcmbdtomunicipio;
	}

	public JLabel getLblcmbdtoparroquia() {
		return lblcmbdtoparroquia;
	}

	public void setLblcmbdtoparroquia(JLabel lblcmbdtoparroquia) {
		this.lblcmbdtoparroquia = lblcmbdtoparroquia;
	}

	public ComboBox getCmbdtopais() {
		return cmbdtopais;
	}

	public void setCmbdtopais(ComboBox cmbdtopais) {
		this.cmbdtopais = cmbdtopais;
	}

	public ComboBox getCmbdtoestado() {
		return cmbdtoestado;
	}

	public void setCmbdtoestado(ComboBox cmbdtoestado) {
		this.cmbdtoestado = cmbdtoestado;
	}

	public ComboBox getCmbdtomunicipio() {
		return cmbdtomunicipio;
	}

	public void setCmbdtomunicipio(ComboBox cmbdtomunicipio) {
		this.cmbdtomunicipio = cmbdtomunicipio;
	}

	public ComboBox getCmbdtoparroquia() {
		return cmbdtoparroquia;
	}

	public void setCmbdtoparroquia(ComboBox cmbdtoparroquia) {
		this.cmbdtoparroquia = cmbdtoparroquia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("SwingBernate.ayudantes.ComboBox".equals(e.getSource().getClass().getCanonicalName())){
			ComboBox combo = (ComboBox)e.getSource();
			if(combo.getTipo().getClass().equals(new Pais().getClass())){
				if(!this.elPais.equals( (Pais)this.cmbdtopais.getSelectedItem())){
					this.elPais = (Pais) this.cmbdtopais.getSelectedItem();
					this.LlenarEstado();
					this.LlenarMunicipio();
					this.LlenarParroquia();					
				}				
			}else if(combo.getTipo().getClass().equals(new Estado().getClass())){
				if(!this.elEstado.equals( (Estado)this.cmbdtoestado.getSelectedItem())){
					this.elEstado = (Estado) this.cmbdtoestado.getSelectedItem();
					this.LlenarMunicipio();
					this.LlenarParroquia();
				}
			}else if(combo.getTipo().getClass().equals(new Municipio().getClass())){
				if(!this.elMunicipio.equals( (Municipio)this.cmbdtomunicipio.getSelectedItem())){
					this.elMunicipio = (Municipio) this.cmbdtomunicipio.getSelectedItem();
					this.LlenarParroquia();
				}
			}
		}
	}

}
