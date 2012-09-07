package Tarea;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloTarea extends ModeloBase {
  public Tarea buscarTarea(  Tarea param,  String campo,  String clave){
    return (Tarea)super.buscar(param,campo,clave).get(0);
  }
  public Tarea[] buscarTareas(){
    List<DtoBase> listaBase=super.buscar(new Tarea());
    Tarea[] arreglo=new Tarea[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Tarea)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Tarea param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarTarea(new Tarea(),"lngid",clave));
  }
  public void grabar(  Tarea param){
    super.guardar(param);
  }
}

