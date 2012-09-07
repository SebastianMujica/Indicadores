package Telefono;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloTelefono extends ModeloBase {
  public Telefono buscarTelefono(  Telefono param,  String campo,  String clave){
    return (Telefono)super.buscar(param,campo,clave).get(0);
  }
  public Telefono[] buscarTelefonos(){
    List<DtoBase> listaBase=super.buscar(new Telefono());
    Telefono[] arreglo=new Telefono[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Telefono)listaBase.get(i);
    return arreglo;
  }
  public Telefono[] buscarTelefonosLibres(){
	  Telefono[] arreglo=null;
	  try{  
		  this.iniciaOperacion();
		  Session sess=this.getFactory().getCurrentSession();
		  List resultado= sess.createSQLQuery("SELECT * FROM telefono where lngid NOT in ((SELECT telefono_lngid from TelefonosAsociadosSocioDeNegocio)union(SELECT telefono_lngid from TelefonosAsociadosDireccion))").addEntity(Telefono.class).list();
		  arreglo=new Telefono[resultado.size()];
		  for (int i=0; i < resultado.size(); i++)     arreglo[i]=(Telefono)resultado.get(i);
		  this.terminaOperacion();
	  }catch (Exception e) {
		  // TODO: handle exception
		  e.printStackTrace();
		  System.out.println("Error al Buscar Telefonos Libres");
	  } 
	  return arreglo;
  }
  public void eliminar(  Telefono param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarTelefono(new Telefono(),"lngid",clave));
  }
  public void grabar(  Telefono param){
    super.guardar(param);
  }
}

