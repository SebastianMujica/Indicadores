package Menu_Tarea;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloMenu_Tarea extends ModeloBase {
  public Menu_Tarea buscarMenu_Tarea(  Menu_Tarea param,  String campo,  String clave){
    return (Menu_Tarea)super.buscar(param,campo,clave).get(0);
  }
  public Menu_Tarea[] buscarMenu_Tareas(){
    List<DtoBase> listaBase=super.buscar(new Menu_Tarea());
    Menu_Tarea[] arreglo=new Menu_Tarea[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Menu_Tarea)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Menu_Tarea param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarMenu_Tarea(new Menu_Tarea(),"lngid",clave));
  }
  public void grabar(  Menu_Tarea param){
    super.guardar(param);
  }
}

