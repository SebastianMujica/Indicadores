package PruebaCrud;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloPruebaCrud extends ModeloBase {
  public PruebaCrud buscar(  PruebaCrud param,  String campo,  String clave){
    return (PruebaCrud)super.buscar(param,campo,clave).get(0);
  }
  public PruebaCrud[] buscarPruebaCruds(){
    List<DtoBase> listaBase=super.buscar(new PruebaCrud());
    PruebaCrud[] arreglo=new PruebaCrud[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(PruebaCrud)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  PruebaCrud param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscar(new PruebaCrud(),"id",clave));
  }
  public void grabar(  PruebaCrud param){
    super.guardar(param);
  }
}

