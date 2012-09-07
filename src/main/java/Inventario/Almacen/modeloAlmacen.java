package Inventario.Almacen;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloAlmacen extends ModeloBase {
  public Almacen buscarAlmacen(  Almacen param,  String campo,  String clave){
    return (Almacen)super.buscar(param,campo,clave).get(0);
  }
  public Almacen[] buscarAlmacens(){
    List<DtoBase> listaBase=super.buscar(new Almacen());
    Almacen[] arreglo=new Almacen[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Almacen)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Almacen param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarAlmacen(new Almacen(),"lngid",clave));
  }
  public void grabar(  Almacen param){
    super.guardar(param);
  }
}

