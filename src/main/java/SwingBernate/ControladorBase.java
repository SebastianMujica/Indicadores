package SwingBernate;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TableColumnModelEvent;
import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.hibernate.validator.engine.ResourceBundleMessageInterpolator;

import Reporte.Reporte;
import SwingBernate.ayudantes.Imprimir;
import SwingBernate.ayudantes.validity;

/** 
 * ControladorBase.java
 * Clase q se encarga de Garantizar la comunicacion entre el modelo y la vista
 * Tambien la gestion de las Respuestas y Acciones. 
 * @author Ing Sebastian Mujica
 *
 */
public class ControladorBase implements ActionListener,KeyListener{
	private Sesion session=new Sesion();
	private boolean isGridCompActive= true;	
	private String param=new String();
	public void iniciarSesion(VistaBase vista,DtoBase dto){
/*		BoletoInternalFrame vista =	new BoletoInternalFrame(this);
    	DtoBoleto boleto = new DtoBoleto();
	*/	
		this.session.agregarDto(dto);
		//this.session.replaceVista(vista);
		this.session.agregarVista(vista);
		
	}
	
	public void sessionDump(){
		this.session.mostrar();
	}
	
	public Sesion getSession() {
		return this.session;
	}
	
	public void setSession(Sesion session) {
		this.session = session;
	}
	
	public void terminarVista(){
		this.session.getVista().dispose();
	
	}
	
	public void iniciarModelo(){}
	
	public JInternalFrame getVista(){
		return this.session.getVista();
	}
	
	public void actualizarModelo(){}
	
	public void terminarModelo(){}
	
	public void mostrar(){}
	
	public void limpiar(){}
	
	public void refrescar(){
		SwingUtilities.updateComponentTreeUI(this.session.getVista());
	}
	public void cargarGrid(){
		if(!this.session.getListaDto().isEmpty())
			this.session.getVista().modelo.setData(this.session.getListaDto());
			SwingUtilities.updateComponentTreeUI(this.session.getVista());

	}
	
	public void cambiarVista(){
		
		if (isGridCompActive){
		if(this.session.getVista().getCentro2().isVisible()){
			this.session.getVista().getCentro2().setVisible(false);
			this.session.getVista().getCentro().setVisible(true);
			SwingUtilities.updateComponentTreeUI(this.session.getVista());
		}else{
			this.session.getVista().getCentro2().setVisible(true);
			this.session.getVista().getCentro().setVisible(false);
			SwingUtilities.updateComponentTreeUI(this.session.getVista());	
			
		}
		}else{
			this.session.getVista().getCentro2().setVisible(false);
			this.session.getVista().getCentro().setVisible(true);
			SwingUtilities.updateComponentTreeUI(this.session.getVista());
		}
		
		SwingUtilities.updateComponentTreeUI(this.session.getVista());

		//this.session.getVista().repaint();
		//this.session.getVista().simpleGrid.getParent().repaint();
		//VistaBase frame=this.session.getVista();
		//frame.getCentro().p
		//frame.repaint();
		//frame.revalidate();
	}
	public List<String> testValidacion(Object dto){
		
		List<String> lsErrores = new ArrayList<String>();
		
		
		Configuration<?> config = Validation.byDefaultProvider().configure();
		ResourceBundle resources = ResourceBundle.getBundle("MensajesValidacion", Locale.getDefault());
		//ResourceBundleMessageInterpolator messageInterpolator = new ResourceBundleMessageInterpolator(new PropertyResourceBundle(in));
		ResourceBundleMessageInterpolator messageInterpolator = new ResourceBundleMessageInterpolator(resources);
		config.messageInterpolator(messageInterpolator);
		
		//ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		ValidatorFactory factory = config.buildValidatorFactory();
	    Validator validator = factory.getValidator();
	    
	    try{
	    	Set<ConstraintViolation<Object>> errorValidacion = validator.validate(dto);
	    	
	    	if(errorValidacion.isEmpty()){
	    		//valido = true;
	    		System.out.println("dto valido para guardar..");
	    	}else{
	    		for (ConstraintViolation<Object> constraintViolation : errorValidacion) {
					lsErrores.add(constraintViolation.getPropertyPath().toString()+"||"+constraintViolation.getMessage());
	    		}
	    		System.out.println("Total Errores: "+lsErrores.size());
	    	}
	    }catch(Exception ex){
	    	System.out.println("Error al verificar la validacion " + ex);
	    }
	        
	    return lsErrores;
	}

	public String obtenerIpHost(){
		String strIp = "";
		
		Enumeration interfaces;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
				if(!ni.isLoopback()){
					if(ni.getInterfaceAddresses().size()>1)
						strIp = ni.getInterfaceAddresses().get(1).getAddress().toString().substring(1);
					else{
						try {
							strIp = InetAddress.getLocalHost().getHostAddress();
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}	    		  
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		
		return strIp;
	}
	
	public String obtenerNombreHost(){
		String strHost = "";
		try {
			strHost = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strHost;
	}
	public void imprimir(String ae){
    JasperReport reporte;
	System.out.println("Imprimiendo");
        try {
		
			Imprimir impObj=this.getSession().getVista().getImprimir();
			
			Reporte reporteO=impObj.getTemplateSelected();
			
			System.out.println(System.getProperty("ZACARO_HOME"));
			System.out.println(System.getenv("ZACARO_HOME"));
			reporte = (JasperReport) JRLoader.loadObject(System.getProperty("ZACARO_HOME")+reporteO.getStrurl());
			JasperPrint jasperPrint=new JasperPrint();
			if ("Lista".equals(ae)){
			jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(this.getSession().getListaDto()));
			}else{
				List<DtoBase> actual=new ArrayList<DtoBase>();
				actual.add(this.getSession().getDto(this.getSession().getActual()));
				jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(actual));	
			}
	        //JRExporter exporter = new JRPdfExporter(); 
	        //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte2PDF_2.pdf")); 
	        //exporter.exportReport();
	        
	        JasperViewer mostrar=new JasperViewer(jasperPrint, false, Locale.getDefault());
	        mostrar.setTitle(this.getSession().getVista().getTitle());
	        mostrar.setVisible(true);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			System.out.println("Error imprimiendo");
			e.printStackTrace();
		}
	}

	public void imprimir(List<DtoBase> lista,String ae){
	    JasperReport reporte;
		System.out.println("Imprimiendo");
	        try {
			
				Imprimir impObj=this.getSession().getVista().getImprimir();
				Reporte reporteO=impObj.getTemplateSelected();
				System.out.println(System.getProperty("ZACARO_HOME"));
				System.out.println(System.getenv("ZACARO_HOME"));
				reporte = (JasperReport) JRLoader.loadObject(System.getProperty("ZACARO_HOME")+reporteO.getStrurl());
				JasperPrint jasperPrint=new JasperPrint();
				jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
			    JasperViewer mostrar=new JasperViewer(jasperPrint, false, Locale.getDefault());
		        mostrar.setTitle(this.getSession().getVista().getTitle());
		        mostrar.setVisible(true);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				System.out.println("Error imprimiendo");
				e.printStackTrace();
			}
		}
	/**
	 * 
	 * @param anios
	 * @return
	 * 
	 * Esta función le suma n años a la fecha actual
	 * del sistema
	 */
	public Date sumarAnios(int n){
		Date date = new Date(); //Extraigo la fecha de la bdd
		Date date1 = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy 00:00:00");
	    String hoy = formato.format(date) + " 00:00:00";
		Calendar cal = Calendar.getInstance(); 
		//cal.setTime(date); 		
		try {
			date1 = formato1.parse(hoy);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.setTime(date1);
		cal.add(Calendar.YEAR, n);
		cal.add(Calendar.HOUR_OF_DAY, 23);
		cal.add(Calendar.MINUTE, 59);
		cal.add(Calendar.SECOND, 59);
		return cal.getTime();
	}
	
	/**
	 * 
	 * @param fecha
	 * @param n
	 * @return
	 * 
	 * Función que suma n años a la fecha
	 * dada como entrada
	 */
	public Date sumarAnios(Date fecha, int n){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(fecha); 
		cal.add(Calendar.YEAR, n);
		return cal.getTime();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("Controlador BaSE "+ae.getActionCommand());
		if ("Salir".equals(ae.getActionCommand())){

				this.terminarVista();

			}
		
	  }

	public boolean isGridCompActive() {
		return isGridCompActive;
	}

	public void setGridCompActive(boolean isGridCompActive) {
		this.isGridCompActive = isGridCompActive;
	}

    public void procesarTecla(KeyEvent event){
    try{
    	if (event.getSource().getClass().getCanonicalName().equals("javax.swing.JTextField")){
    			  JTextField campo=(JTextField) event.getSource();
    			  //System.out.println(campo.getName() + ":" + campo.getColumns());
    			  int largo=campo.getColumns();
    			  if (largo>0){
    				  if (campo.getText().length()==largo){
    					 event.consume(); 
    					 Toolkit.getDefaultToolkit().beep();
    				  } 
    			  }
    			  String nombre_campo=campo.getName().toLowerCase();
    			  if (nombre_campo != null){
    			     String tipo_campo=nombre_campo.substring(3, 6);
    			     String formato_campo="";
    			     if (nombre_campo.length()>9){formato_campo=nombre_campo.substring(7, 9);}
    			     if (tipo_campo.contentEquals("str")){
    			    	 if (formato_campo.isEmpty()){
    			    		campo.setText(validity.validar(campo.getText(), "c"));
    			    	 }else if (formato_campo=="cod"){
    				    		campo.setText(validity.validar(campo.getText(), "c","-_"));
    				     }else {
    				    		campo.setText(validity.validar(campo.getText(), "c",".,-_@ñÑáéíóúüÁÉÍÓÚÜ "));
    				     } 
    			     }else if (tipo_campo.contentEquals("int") || tipo_campo.contentEquals("lng")){
    			    	 campo.setText(validity.validar(campo.getText(), "c|l","-").trim());
    			     }else if (tipo_campo.contentEquals("flo")){
    			    	 campo.setText(validity.validar(campo.getText(), "c|l",".-").trim());  
    			     }else if (tipo_campo.contentEquals("lng") || tipo_campo.contentEquals("lng")){
    			    	 campo.setText(validity.validar(campo.getText(), "c|l","-").trim());
    			     }
    			  }//Fin de if nombre_campo != null
    		}
    	if (event.getSource().getClass().getCanonicalName().equals("javax.swing.JTextArea")){
			  JTextArea campo=(JTextArea) event.getSource();
			  String nombre_campo=campo.getName().toLowerCase();
			  if (nombre_campo != null){
			     String tipo_campo=nombre_campo.substring(3, 6);
			     String formato_campo="";
			     if (nombre_campo.length()>9){formato_campo=nombre_campo.substring(7, 9);}
			     if (tipo_campo.contentEquals("str")){
			    	 if (formato_campo.isEmpty()){
			    		campo.setText(validity.validar(campo.getText(), "c"));
			    	 }else if (formato_campo=="cod"){
				    		campo.setText(validity.validar(campo.getText(), "c","-_"));
				     }else {
				    		campo.setText(validity.validar(campo.getText(), "c",".,-@áéíóúüÁÉÍÓÚÜ "));
				     } 
			     }else if (tipo_campo.contentEquals("int") || tipo_campo.contentEquals("lng")){
			    	 campo.setText(validity.validar(campo.getText(), "c|l","-").trim());
			     }else if (tipo_campo.contentEquals("flo")){
			    	 campo.setText(validity.validar(campo.getText(), "c|l",".-").trim());  
			     }
			  }//Fin de if nombre_campo != null
		}
    }catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent event) {
        procesarTecla(event);
	}

	public void keyTyped(KeyEvent event) {
		procesarTecla(event);	
	}
}

	
