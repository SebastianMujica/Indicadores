package SwingBernate;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import SwingBernate.ayudantes.AyudanteGrid;
import SwingBernate.ayudantes.ListaFiltro;
import SwingBernate.ayudantes.SimpleGrid;
import SwingBernate.ayudantes.SimpleGridModel;

import com.toedter.calendar.JDateChooser;

public class Formulario {
	private GridBagConstraints constraints;
	private Container container;
	private MigLayout migLayout;
	private JPanel panel;
	private int columna=0;
	public Formulario(Container container) {
		this.container = container;
		container.setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5,5,5,5);
		constraints.gridx = 0;
		constraints.gridy = 0;

	}
	public Container getContainer(){

		return this.container;
	}
	public void setVisilble(boolean b){
		this.container.setVisible(b);
	}
	public boolean isVisible(){
		return this.container.isVisible();
	}
	public void addField(String label, JComponent component) {
		addField(new JLabel(label), component);
	}
	public void addField(JComponent component) {
		addField(new JLabel(), component);
	}

	public void addField2(JLabel label, JComponent component) {
		if (columna==0){
			constraints.gridy = 0;
		}else{
			constraints.gridy = 0+columna;
		}

		component.setBorder(BorderFactory.createLineBorder(Color.cyan) );
		label.setBorder(BorderFactory.createLineBorder(Color.cyan) );

		constraints.weightx = 0;
		constraints.weighty = 0;
		Class<?> clazz = component.getClass();

		label.setName("lbl"+label.getText());
		component.setName("cmp"+label.getText());

		//constraints.fill = GridBagConstraints.NONE;	      

		this.addField(label);
		container.add(label, constraints);

		constraints.gridy = 1+columna;

		if(JScrollPane.class == clazz)
			constraints.anchor = GridBagConstraints.FIRST_LINE_END;
		else
			constraints.anchor = GridBagConstraints.LINE_END;

		if(JScrollPane.class == clazz) {
			constraints.weightx = 1;
			constraints.weighty = 1;
			constraints.fill = GridBagConstraints.BOTH;
			container.add(component, constraints);
		} else if(JTextField.class == clazz) {
			JTextField textField = (JTextField) component;
			if(textField.getColumns() == 0) {
				// si no se ha especificado un número de columnas
				// el componente será tan ancho como la quepa en la ventana
				constraints.fill = GridBagConstraints.BOTH;
			} else {
				// esto arregla un problema que ocurre
				// cuando el componente no cabe en anchura
				textField.setMinimumSize(textField.getPreferredSize());
				constraints.anchor = GridBagConstraints.LINE_START;
			}
			container.add(component, constraints);
		} else if(JDateChooser.class == clazz){
			JDateChooser dateChooser = (JDateChooser) component;
			dateChooser.setMinimumSize(new Dimension(120,20));
			constraints.fill = GridBagConstraints.BOTH;
			constraints.gridwidth = GridBagConstraints.REMAINDER;
			//constraints.anchor = GridBagConstraints.LINE_START;
			container.add(component, constraints);
		}else if(ListaFiltro.class == clazz){
			constraints.fill = GridBagConstraints.BOTH;
			container.add(component, constraints);
		}else if(AyudanteGrid.class == clazz){
			constraints.weightx = 1;
			constraints.weighty = 1;
			constraints.fill = GridBagConstraints.BOTH;
			container.add(component, constraints);
		}else if(JTextArea.class == clazz){
			JTextArea areatxt=(JTextArea)component;
			JScrollPane scr=new JScrollPane(areatxt);
			constraints.anchor = GridBagConstraints.LINE_START;
			container.add(scr, constraints);
		}else {
			constraints.anchor = GridBagConstraints.LINE_START;
			container.add(component, constraints);
		}
		label.setLabelFor(component); // accesibilidad

		constraints.gridx++;
		if(constraints.gridx>3){
			//constraints.gridx++;
			columna++;
			constraints.gridx=0;
		} 
		//System.out.println("#########################################33    Formulario   Y    "+constraints.gridy);
		//System.out.println("#########################################33    Formulario   X    "+constraints.gridx);
	}
	
	public void addField(JLabel label, JComponent component) {
		if (columna==0){
			constraints.gridx = 0;
		}else{
			constraints.gridx = 0+columna;
		}

		//component.setBorder(BorderFactory.createLineBorder(Color.cyan) );
		//label.setBorder(BorderFactory.createLineBorder(Color.cyan) );

		constraints.weightx = 0;
		constraints.weighty = 0;

		Class<?> clazz = component.getClass();
		label.setName("lbl"+label.getText());
		
		if(component.getName() == null)
			component.setName("cmp"+label.getText());

		constraints.fill = GridBagConstraints.NONE;
		if(JScrollPane.class == clazz)
			constraints.anchor = GridBagConstraints.FIRST_LINE_END;
		else
			constraints.anchor = GridBagConstraints.LINE_END;
		
		container.add(label, constraints);

		//System.out.println("#########################################33    Formulario   Y    "+constraints.gridy);
		//System.out.println("#########################################33    Formulario   X    "+constraints.gridx);

		constraints.gridx = 1+columna;

		if(JScrollPane.class == clazz) {
			constraints.weightx = 1;
			constraints.weighty = 1;
			constraints.fill = GridBagConstraints.BOTH;
			container.add(component, constraints);
		} else if(JTextField.class == clazz) {
			/*constraints.gridx--;
			container.add(label, constraints);
			constraints.gridx++;*/
			JTextField textField = (JTextField) component;
			if(textField.getColumns() == 0) {
				// si no se ha especificado un número de columnas
				// el componente será tan ancho como la quepa en la ventana
				constraints.fill = GridBagConstraints.BOTH;
			} else {
				// esto arregla un problema que ocurre
				// cuando el componente no cabe en anchura
				textField.setMinimumSize(textField.getPreferredSize());
				constraints.anchor = GridBagConstraints.LINE_START;
			}
			container.add(component, constraints);
		} else if(JDateChooser.class == clazz){
			JDateChooser dateChooser = (JDateChooser) component;
			dateChooser.setMinimumSize(new Dimension(120,20));	        	      	
			//constraints.fill = GridBagConstraints.BOTH;
			//constraints.gridwidth = GridBagConstraints.REMAINDER;
			constraints.anchor = GridBagConstraints.LINE_START;
			container.add(component, constraints);
		}else if(ListaFiltro.class == clazz){
			constraints.fill = GridBagConstraints.BOTH;
			container.add(component, constraints);
		}else if(AyudanteGrid.class == clazz){
			constraints.weightx = 1;
			constraints.weighty = 1;
			constraints.fill = GridBagConstraints.BOTH;
			container.add(component, constraints);
		}else if(JTextArea.class == clazz){
			constraints.gridx--;
			container.add(label, constraints);
			constraints.gridx++;
			JTextArea areatxt=(JTextArea)component;
			JScrollPane scr=new JScrollPane(areatxt);
			constraints.anchor = GridBagConstraints.LINE_START;
			container.add(scr, constraints);
		}else {
			/*constraints.gridx--;
			container.add(label, constraints);
			constraints.gridx++;*/
			constraints.anchor = GridBagConstraints.LINE_START;
			container.add(component, constraints);
		}
		label.setLabelFor(component); // accesibilidad

		constraints.gridy++;
		if(constraints.gridy>=18){
			//constraints.gridx++;
			columna++;
			constraints.gridy=0;
		} 
//		System.out.println("#########################################33    Formulario   Y    "+constraints.gridy);
//		System.out.println("#########################################33    Formulario   X    "+constraints.gridx);
	}

	public void addField3(JLabel label, JComponent component){
		if (columna==0){
			constraints.gridx = 0;
		}else{
			constraints.gridx = 0+columna+1;
		}
		constraints.anchor = GridBagConstraints.LINE_END;
		container.add(label, constraints);
		constraints.gridx++;
		constraints.anchor = GridBagConstraints.LINE_START;
		container.add(component, constraints);
		constraints.gridx--;
		constraints.gridy++;
		if(constraints.gridy>=10){
			//constraints.gridx++;
			columna++;
			constraints.gridy=0;
		} 
	}

	public void llenadoAutomatico(Object dto)
	{
		System.out.println("El Dto es de Tipo :"+dto.getClass().getName());
		System.out.println("Se Creara un Formulario con los siguientes Campos:");
		Field[] fields = dto.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++)
		{
			String[] campo=fields[i].toString().split(" "); 
			String[] nombre=campo[2].split("\\.");
			System.out.println("El tipo es :" + campo[1]+" y el Nombre es: "+ nombre[3]);
			if (campo[1].equals("java.lang.String"))
			{
				this.addField(nombre[3],new JTextField());	
			}
			if (campo[1].equals("int"))
			{
				this.addField(nombre[3],new JSpinner());
			}

		}

	}
	
}
