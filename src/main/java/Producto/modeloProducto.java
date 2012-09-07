package Producto;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloProducto extends ModeloBase {
  public Producto buscarProducto(  Producto param,  String campo,  String clave){
    return (Producto)super.buscar(param,campo,clave).get(0);
  }
  public Producto[] buscarProductos(){
    List<DtoBase> listaBase=super.buscar(new Producto());
    Producto[] arreglo=new Producto[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Producto)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Producto param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarProducto(new Producto(),"lngid",clave));
  }
  public void grabar(  Producto param){
    super.guardar(param);
  }
}

