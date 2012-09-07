package Inventario.UbicacionAlmacen;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloUbicacionAlmacen extends ModeloBase {
  public UbicacionAlmacen buscarUbicacionAlmacen(  UbicacionAlmacen param,  String campo,  String clave){
    return (UbicacionAlmacen)super.buscar(param,campo,clave).get(0);
  }
  public UbicacionAlmacen[] buscarUbicacionAlmacens(){
    List<DtoBase> listaBase=super.buscar(new UbicacionAlmacen());
    UbicacionAlmacen[] arreglo=new UbicacionAlmacen[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(UbicacionAlmacen)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  UbicacionAlmacen param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarUbicacionAlmacen(new UbicacionAlmacen(),"lngid",clave));
  }
  public void grabar(  UbicacionAlmacen param){
    super.guardar(param);
  }
}

