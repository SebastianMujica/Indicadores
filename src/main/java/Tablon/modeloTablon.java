package Tablon;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import Telefono.Telefono;
public class modeloTablon extends ModeloBase {
  public Tablon buscarTablon(  Tablon param,  String campo,  String clave){
    return (Tablon)super.buscar(param,campo,clave).get(0);
  }
  public Tablon[] buscarTablons(){
    List<DtoBase> listaBase=super.buscar(new Tablon());
    Tablon[] arreglo=new Tablon[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Tablon)listaBase.get(i);
    return arreglo;
  }

  public Tablon[] buscarTablonesLibres(long haciendaid){
	  Tablon[] arreglo=null;
	  try{  
		  this.iniciaOperacion();
		  Session sess=this.getFactory().getCurrentSession();
		  List resultado= sess.createSQLQuery("SELECT * FROM tablon where dtohacienda_lngid="+haciendaid +"and lngid NOT in (SELECT tablon_lngid from tablonesorden)").addEntity(Tablon.class).list();
		  arreglo=new Tablon[resultado.size()];
		  for (int i=0; i < resultado.size(); i++)     arreglo[i]=(Tablon)resultado.get(i);
		  this.terminaOperacion();
	  }catch (Exception e) {
		  // TODO: handle exception
		  e.printStackTrace();
		  System.out.println("Error al Buscar Tablones Libres");
	  } 
	  return arreglo;
  }
  public void eliminar(  Tablon param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarTablon(new Tablon(),"lngid",clave));
  }
  public void grabar(  Tablon param){
    super.guardar(param);
  }
}

