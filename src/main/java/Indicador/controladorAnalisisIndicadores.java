package Indicador;

import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JInternalFrame;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



import Maestro.modeloMaestro;
import RegistroIndicador.RegistroIndicador;
import RegistroIndicador.modeloRegistroIndicador;
import Reporte.Reporte;
import Reporte.modeloReporte;

import SwingBernate.ControladorBase;
import VariableIndicador.modeloVariableIndicador;


public class controladorAnalisisIndicadores extends ControladorBase {

	public controladorAnalisisIndicadores(){
		this.setGridCompActive(false);
		analisisIndicadores vista=new analisisIndicadores(this);
		this.iniciarSesion(vista,new RegistroIndicador());
		this.cambiarVista();
		
		

		
		
		actualizarVista();
	}  
	public void actualizarVista(){
		analisisIndicadores vista=(analisisIndicadores)this.getSession().getVista();
		//modeloReporte modeloReporte=new modeloReporte();
		//javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(),"strpadre","Indicador").toArray());
		//vista.getImprimir().getTemplate().setModel(modeloComboReporte);
		
		RegistroIndicador[] Indicadores;
		modeloRegistroIndicador registroInd=new modeloRegistroIndicador();
		Indicadores=registroInd.buscarRegistroIndicadors();
		modeloIndicador modInd=new modeloIndicador(); 
		vista.cargarIndicadores(Indicadores, this, modInd);
		RegistroIndicador dto=new RegistroIndicador();
		this.getSession().setListaDto(modInd.buscar(dto));
		System.out.println(this.getSession().getListaDto().size());
		
	}
	public void actionPerformed(  ActionEvent ae){
	    if ("Salir".equals(ae.getActionCommand()))      this.terminarVista();
	    if ("Lista".equals(ae.getActionCommand()))      this.imprimir(ae.getActionCommand());
	    if ("Actual".equals(ae.getActionCommand()))     this.imprimir(ae.getActionCommand());
	    if(ae.getActionCommand().contains("Tendencia")){
	    	String[] arr=ae.getActionCommand().split("_");
	    	
	    	
	    	modeloIndicador modindicador=new modeloIndicador();
	    	modindicador.buscar(new Indicador(),Long.parseLong(arr[1]));
	    	Indicador indicador=(Indicador)modindicador.buscar(new Indicador(),Long.parseLong(arr[1]));
	    	
	    	
	    	
	    	modeloRegistroIndicador modelo=new modeloRegistroIndicador();
	    	
	    	RegistroIndicador[] registros=modelo.nUltimos(10,indicador.getLngid(),indicador);
	  

	    	//XYSeries valores = new XYSeries(indicador.getStrnombre());
	    	
	    	TimeSeries fecha = new TimeSeries(indicador.getStrnombre(),Second.class);
	   	    for (int i = 0; i < registros.length; i++) 
	   	    	{
	    		
	    		//valores.add(Integer.parseInt(i+""),Float.parseFloat(registros[i].getStrvalor()));
	   	    	
	   	    	Date d = new Date();
	   	    	Calendar c = Calendar.getInstance();
	   	    	c.setTime(registros[i].getDtmfecha_creacion());
	   	    	int anio = c.get(Calendar.YEAR);
	   	    	int mes = c.get(Calendar.MONTH);
	   	    	System.out.println(mes);
	    		fecha.add(new Second(registros[i].getDtmfecha_creacion()),Double.valueOf(registros[i].getStrvalor()));
	   	    	}
//	   	    XYSeriesCollection dataset = new XYSeriesCollection();
//	   		dataset.addSeries(valores);
	   	    
//			JFreeChart chart = ChartFactory.createXYLineChart(
//					"Grafico de Tendencia", 
//					"Valor", 
//					"Muestra", 
//					dataset,
//					PlotOrientation.VERTICAL, 
//					true, 
//					true, 
//					true);
	   		
	   		
	        
	   		
	   		
	   		TimeSeries prom = MovingAverage.createMovingAverage(fecha, "Promedio", 5, 5);
	        TimeSeriesCollection dataset = new TimeSeriesCollection();
	        dataset.addSeries(fecha);
	        dataset.addSeries(prom);
	   		
	   		
	   		
	   		
	   		
	   		JFreeChart chart = ChartFactory.createTimeSeriesChart(
	   	            "Grafico de Tendencia", 
	   	            "Fecha", 
	   	            "Valor",
	   	            dataset, 
	   	            true, 
	   	            true, 
	   	            false
	   	        );

			ChartPanel cp = new ChartPanel(chart);
			JInternalFrame frame= new JInternalFrame("Tendencia", true, true, true, true);

			frame.add(cp);
			frame.pack();
			frame.setVisible(true);
			
			this.getVista().getDesktopPane().add(frame);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	    
	   	}
//	    if ("Aplicar".equals(ae.getActionCommand()))    this.aplicar();
//		  if("javax.swing.JComboBox".equals(ae.getSource().getClass().getCanonicalName()))
//		  { 
//			  JComboBox combo1=(JComboBox) ae.getSource();
//			  vistaStatusFabrica vista=(vistaStatusFabrica)this.getSession().getVista();
//			  
//		  
//				  if (combo1.getSelectedItem().toString().equals("Torta")){
//					  vista.getCmbdtovariable().setVisible(true);
//					  vista.getLstdtovariable().setVisible(false);
//					  //vista.agregarCategoria();
//				  }
//				  if (combo1.getSelectedItem().toString().equals("Barras")){
//					  vista.getCmbdtovariable().setVisible(false);
//					  vista.getLstdtovariable().setVisible(true);
//					//  vista.agregarCategoria();	
//					
//				  }
//				  if (combo1.getSelectedItem().toString().equals("Lineas")){
//					  vista.getCmbdtovariable().setVisible(false);
//					  vista.getLstdtovariable().setVisible(true);
//					  try {
//						  vista.removerCategoria();	
//					} catch (Exception e) {
//						System.out.println("ya fue removido");
//					}
//				  
//			}
//		  }  
//		  
}
	}

