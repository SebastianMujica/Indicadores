package Recepcion;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloRecepcion extends ModeloBase {
  public Recepcion buscarRecepcion(  Recepcion param,  String campo,  String clave){
    return (Recepcion)super.buscar(param,campo,clave).get(0);
  }
  public Recepcion[] buscarRecepcions(){
    List<DtoBase> listaBase=super.buscar(new Recepcion());
    Recepcion[] arreglo=new Recepcion[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Recepcion)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Recepcion param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarRecepcion(new Recepcion(),"lngid",clave));
  }
  public void grabar(  Recepcion param){
    super.guardar(param);
  }
}

