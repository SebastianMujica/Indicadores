package SwingBernate;
import java.io.*;
import java.util.*;

import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;

public class XMLReaderPrueba {

  public static void main(String[] args) {
     try {
       
    	SAXBuilder builder=new SAXBuilder(false); 
        Document documento =builder.build("src/swingbernate/dto/DtoPersona.hbm.xml");
        Element  raiz=documento.getRootElement();
        
        System.out.println("Raiz : "+raiz.getName());
        
        Element clase = raiz.getChild("class");
        
        Element idprimario=clase.getChild("id");
        
        System.out.println("Nombre de la Clase:"+clase.getAttributeValue("name"));
        System.out.println("Nombre de la Tabla:"+clase.getAttributeValue("table"));
        System.out.println("Nombre del Esquema:"+clase.getAttributeValue("schema"));
        
        System.out.println("Se relaciona con:");
        System.out.println("Clave Primaria:"+ idprimario.getAttributeValue("name") +" de tipo "+ idprimario.getAttributeValue("type"));
        
        List atributos=clase.getChildren("property");
        System.out.println("posee "+atributos.size()+" propiedades");
        for (Iterator iterator = atributos.iterator(); iterator.hasNext();) {
			Element propiedad = (Element) iterator.next();
			System.out.println("Propiedad "+ propiedad.getAttributeValue("name")+" tipo "+ propiedad.getAttributeValue("type"));
			
		}
  
        


        // Dejamos de mano del lector el sacar el nombre 
        //de los arbitros, animate!!
          }catch (Exception e){
        e.printStackTrace();
     }
  }
}

