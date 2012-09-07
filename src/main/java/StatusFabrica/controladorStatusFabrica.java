package StatusFabrica;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import org.apache.log4j.Category;
import org.codehaus.groovy.ant.Groovy;
import org.codehaus.groovy.control.CompilationFailedException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import OrdenDeArrime.vistaOrdenDeArrime;
import Productor.Productor;
import Productor.modeloProductor;
import Reporte.Reporte;
import SwingBernate.ControladorBase;
import SwingBernate.DtoBase;
import SwingBernate.VistaBase;
import SwingBernate.dtoVacio;
import SwingBernate.ayudantes.ComboBox;
import Variable.Variable;
import Variable.modeloVariable;

public class controladorStatusFabrica extends ControladorBase implements ActionListener {

public controladorStatusFabrica(){
	this.setGridCompActive(false);
	vistaStatusFabrica vista=new vistaStatusFabrica(this);
	this.iniciarSesion(vista,new dtoVacio());
	
	this.cambiarVista();
	modeloVariable modeloVar=new modeloVariable();
	DefaultComboBoxModel modeloCvar=new DefaultComboBoxModel(modeloVar.buscarVariables("strclase","Categoria"));
	vista.getCmbdtovariable().setModelo(modeloCvar);
	
	
	DefaultComboBoxModel modeloVarval=new DefaultComboBoxModel(modeloVar.buscarVariables("strclase","Valor"));
	vista.getCmbdtovariablevalor().setModelo(modeloVarval);



	
	}

public void aplicar(){
	
	vistaStatusFabrica vista=(vistaStatusFabrica)this.getSession().getVista();
	String tipoGrafico=(String)vista.getCmbtipo().getSelectedItem();
	modeloProductor prod=new modeloProductor();
	Binding binding=new Binding();
	binding.setVariable("prod", prod);
	//GroovyShell shell=new GroovyShell(binding);
	modeloVariable variable=new modeloVariable();
	//Productor arreglo[]=(Productor[])shell.evaluate("");
	Binding vars=new Binding();
	
	vars.setVariable("Turnos" , "");
	vars.setVariable("Desde"  , "");
	vars.setVariable("Hasta"  , "");
	vars.setVariable("Central", "");
	vars.setVariable("Zafra"  , "");
	
	if (tipoGrafico.equals("Barras")){
	
		String varName="";
		String catName="";
		String val="";
		
		
		GroovyShell shell=new GroovyShell();

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
	

			//shell.setVariable("Categorias", categorias);
			//Object valores[]=(Object[])shell.evaluate(varivalor.getStrformula());
		
		
		
		dataset.addValue(Float.parseFloat(val), catName, varName);
		
		
		
		
		
		
		
		dataset.addValue(1.0, "Row 1", "Column 1");
		dataset.addValue(5.0, "Row 1", "Column 2");
		dataset.addValue(3.0, "Row 1", "Column 3");
		dataset.addValue(2.0, "Row 2", "Column 1");
		dataset.addValue(3.0, "Row 2", "Column 2");
		dataset.addValue(2.0, "Row 2", "Column 3");
		
		JFreeChart chart = ChartFactory.createBarChart(
			    "Bar Chart Demo", // chart title
			    "Category", // domain axis label
			    "Value", // range axis label
			    dataset, // data
			    PlotOrientation.VERTICAL, // orientation
			    true, // include legend
			    true, // tooltips?
			    false // URLs?
			);		
		ChartPanel cp = new ChartPanel(chart);

		JInternalFrame frame= new JInternalFrame("Grafico de Barras", true, true, true, true);
		frame.add(cp);
		frame.pack();
		frame.setVisible(true);
		
		vista.getDeskGraficos().add(frame);
	}
	if (tipoGrafico.equals("Torta")){
		//Data Ejemplo 2 parametros
		System.out.println("epaaaa");
		//parametro categoritco o identificativo
		
		Variable vari=(Variable)vista.getCmbdtovariable().getSelectedItem();
		Variable varivalor=(Variable)vista.getCmbdtovariablevalor().getSelectedItem();
		
		if (vari.getStrclase().equals("Categoria")){
			
			
			GroovyShell shell=new GroovyShell();
			
			//ArrayList cate=(ArrayList)shell.evaluate(vari.getStrformula());
			DtoBase categorias[]=(DtoBase[])shell.evaluate(vari.getStrformula());
			
			
			
			if (varivalor.getStrclase().equals("Valor")){
			shell.setVariable("Categorias", categorias);
			//ArrayList valores[]=(ArrayList[])shell.evaluate(varivalor.getStrformula());
			
			Object valores[]=(Object[])shell.evaluate(varivalor.getStrformula());
			
			DefaultPieDataset data = new DefaultPieDataset();			
			for (int i = 0; i < categorias.length; i++) {
				data.setValue(categorias[i].toString(),Double.parseDouble(valores[i].toString()));
			}
			JFreeChart chart = ChartFactory.createPieChart(vari.getStrnombre(), data, true,true,true);
			ChartPanel cp = new ChartPanel(chart);
			JInternalFrame frame= new JInternalFrame("Grafico de Torta", true, true, true, true);
			frame.add(cp);
			frame.pack();
			frame.setVisible(true);
			vista.getDeskGraficos().add(frame);			
			
			
			}
		
		
		}
		
		
				
		

		
		
//vista.revalidate();
	}
	if (tipoGrafico.equals("Lineas")){
		
		
		// create a dataset...
		XYSeries series1 = new XYSeries("Azucar");
		series1.add(1.0, 1.0);
		series1.add(2.0, 4.0);
		series1.add(3.0, 3.0);
		series1.add(4.0, 5.0);
		series1.add(5.0, 5.0);
		series1.add(6.0, 7.0);
		series1.add(7.0, 7.0);
		series1.add(8.0, 8.0);
		
		XYSeries series2 = new XYSeries("Caña Molida");
		series2.add(1.0, 5.0);
		series2.add(2.0, 7.0);
		series2.add(3.0, 6.0);
		series2.add(4.0, 8.0);
		series2.add(5.0, 4.0);
		series2.add(6.0, 4.0);
		series2.add(7.0, 2.0);
		series2.add(8.0, 1.0);
		
		XYSeries series3 = new XYSeries("Melaza");
		series3.add(3.0, 4.0);
		series3.add(4.0, 3.0);
		series3.add(5.0, 2.0);
		series3.add(6.0, 3.0);
		series3.add(7.0, 6.0);
		series3.add(8.0, 3.0);
		series3.add(9.0, 4.0);
		series3.add(10.0, 3.0);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		
		JFreeChart chart = ChartFactory.createXYLineChart(
														"Grafico de Lineas", 
														"Fecha", 
														"Miles x Toneladas", 
														dataset,
														PlotOrientation.VERTICAL, 
														true, 
														true, 
														true);
		ChartPanel cp = new ChartPanel(chart);

		JInternalFrame frame= new JInternalFrame("Grafico de Lineas", true, true, true, true);
		frame.add(cp);
		frame.pack();
		frame.setVisible(true);
		
		vista.getDeskGraficos().add(frame);
		
	}
}
public void actionPerformed(  ActionEvent ae){
    if ("Salir".equals(ae.getActionCommand()))      this.terminarVista();
    if ("Lista".equals(ae.getActionCommand()))      this.imprimir(ae.getActionCommand());
    if ("Actual".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
    if ("Aplicar".equals(ae.getActionCommand()))    this.aplicar();
	  if("javax.swing.JComboBox".equals(ae.getSource().getClass().getCanonicalName()))
	  { 
		  JComboBox combo1=(JComboBox) ae.getSource();
		  vistaStatusFabrica vista=(vistaStatusFabrica)this.getSession().getVista();
		  
	  
			  if (combo1.getSelectedItem().toString().equals("Torta")){
				  vista.getCmbdtovariable().setVisible(true);
				  vista.getLstdtovariable().setVisible(false);
				  //vista.agregarCategoria();
			  }
			  if (combo1.getSelectedItem().toString().equals("Barras")){
				  vista.getCmbdtovariable().setVisible(false);
				  vista.getLstdtovariable().setVisible(true);
				//  vista.agregarCategoria();	
				
			  }
			  if (combo1.getSelectedItem().toString().equals("Lineas")){
				  vista.getCmbdtovariable().setVisible(false);
				  vista.getLstdtovariable().setVisible(true);
				  try {
					  vista.removerCategoria();	
				} catch (Exception e) {
					System.out.println("ya fue removido");
				}
			  
		}
	  }  
	  }
}
