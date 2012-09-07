package Direccion;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloDireccion extends ModeloBase {
  public Direccion buscarDireccion(  Direccion param,  String campo,  String clave){
    return (Direccion)super.buscar(param,campo,clave).get(0);
  }
  public Direccion[] buscarDireccions(){
    List<DtoBase> listaBase=super.buscar(new Direccion());
    Direccion[] arreglo=new Direccion[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Direccion)listaBase.get(i);
    return arreglo;
  }
  public Direccion[] buscarDireccionsLibres(){
	  Direccion[] arreglo=null;
	  try{  
		  this.iniciaOperacion();
		  Session sess=this.getFactory().getCurrentSession();
		 
		  
		  List resultado= sess.createSQLQuery("SELECT * FROM direccion where lngid NOT in (SELECT direccion_lngid from Direccionessocio)").addEntity(Direccion.class).list();
		  arreglo=new Direccion[resultado.size()];
		  for (int i=0; i < resultado.size(); i++)     arreglo[i]=(Direccion)resultado.get(i);
		  this.terminaOperacion();
	  }catch (Exception e) {
		  // TODO: handle exception
		  e.printStackTrace();
		  System.out.println("Error al Buscar Direcciones Libres");
	  } 
	  return arreglo;
  }
  public void eliminar(  Direccion param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarDireccion(new Direccion(),"lngid",clave));
  }
  public void grabar(  Direccion param){
    super.guardar(param);
  }
}

