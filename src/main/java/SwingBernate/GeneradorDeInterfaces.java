package SwingBernate;
/**
 * 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.Iterator;
import java.util.List;

/**
 * @author sebastian
 *
 */
public class GeneradorDeInterfaces {
	private String nombreArchivo;
	private String[][] propiedades;
	
	public GeneradorDeInterfaces(String urlString) {
	     try {
	         
	     	 SAXBuilder builder=new SAXBuilder(false); 
	         Document documento =builder.build(urlString);
	         Element  raiz=documento.getRootElement();
	         System.out.println("Construyendo Objeto Interfaz:");
	         
	         System.out.println("Raiz : "+raiz.getName());
	         
	         Element clase = raiz.getChild("class");
	         
	         Element idprimario=clase.getChild("id");
	         
	         System.out.println("Nombre de la Clase:"+clase.getAttributeValue("name"));
	         System.out.println("Nombre de la Tabla:"+clase.getAttributeValue("table"));
	         nombreArchivo=clase.getAttributeValue("table")+".java";
	         System.out.println("Nombre del Esquema:"+clase.getAttributeValue("schema"));
	         
	         System.out.println("Se relaciona con:");
	         System.out.println("Clave Primaria:"+ idprimario.getAttributeValue("name") +" de tipo "+ idprimario.getAttributeValue("type"));
	         
	         List atributos=clase.getChildren("property");
	         System.out.println("posee "+atributos.size()+" propiedades");
	         int i=0;
	         for (Iterator iterator = atributos.iterator(); iterator.hasNext();) {
	 			Element propiedad = (Element) iterator.next();
	 			System.out.println("Propiedad "+ propiedad.getAttributeValue("name")+" tipo "+ propiedad.getAttributeValue("type"));
	 			propiedades[i][i]=propiedad.getAttributeValue("name");
	 			propiedades[i][i+1]=propiedad.getAttributeValue("type");
	 			i++;
	 		 }
	   
	         


	         // Dejamos de mano del lector el sacar el nombre 
	         //de los arbitros, animate!!
	           }catch (Exception e){
	         e.printStackTrace();
	      }
		
	}
	/*
	 * Clase que agrega las acciones
	 */
	public void acciones() {
		
	}
	/*
	 * Clase que construye la ventana
	 */
	public void vista() {
		
	}
	/*
	 * Clase que exporta el codigo java
	 */
	public void exportador() {
		String sFichero = nombreArchivo;
		File fichero = new File(sFichero);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
			//Agregamos los Imports
			/*
			 *  import java.awt.*;
				import java.awt.event.*;
				import javax.swing.*;
				import javax.swing.border.*;
			 */
			bw.write("import java.awt.*;");
			bw.write("import java.awt.event.*;");
			bw.write("import javax.swing.*;");
			bw.write("import javax.swing.border.*;");
			//Agregamos el nombre de la Clase
			bw.write("public class "+nombreArchivo+" extends JPanel {");
			//
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Generacion del Archivo .java");
		
	}
	/*
	 * Clase que importa el codigo xml
	 */
	public void importador() {

		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*if (args.length <= 0)
		{
			System.out.println("Uso: java GeneradorDeInterfaces [urlarchivo]");
			return;
		}*/
		//String urlXmlDeConfiguracion = args[0];
		String urlXmlDeConfiguracion ="src/swingbernate/dto/DtoPersona.hbm.xml";
		/*try{
			XMLReader parser = XMLReaderFactory.createXMLReader();
			parser.parse(urlXmlDeConfiguracion);
			System.out.println(urlXmlDeConfiguracion+" no tiene errores");
		}
		catch(SAXParseException e)
		{
			System.out.println(urlXmlDeConfiguracion + "Tiene errores");
			System.out.println("linea "+e.getLineNumber());
		} catch (IOException e) {
			System.out.println("No se pudo abrir"+e.getMessage());
		} catch (SAXException e) {
			System.out.println("Error al Revisar"+e.getMessage());
		}
		/*Si el Archivo xml es valido*/
		GeneradorDeInterfaces nueva = new GeneradorDeInterfaces(urlXmlDeConfiguracion);
		nueva.exportador();
	}

}
