package Productor;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloProductor extends ModeloBase {
  public Productor buscarProductor(  Productor param,  String campo,  String clave){
    return (Productor)super.buscar(param,campo,clave).get(0);
  }
  public Productor[] buscarProductors(){
    List<DtoBase> listaBase=super.buscar(new Productor());
    Productor[] arreglo=new Productor[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Productor)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Productor param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarProductor(new Productor(),"lngid",clave));
  }
  public void grabar(  Productor param){
    super.guardar(param);
  }
}

