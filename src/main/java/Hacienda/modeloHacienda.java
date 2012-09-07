package Hacienda;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloHacienda extends ModeloBase {
  public Hacienda buscarHacienda(  Hacienda param,  String campo,  String clave){
    return (Hacienda)super.buscar(param,campo,clave).get(0);
  }
  public Hacienda[] buscarHaciendas(){
    List<DtoBase> listaBase=super.buscar(new Hacienda());
    Hacienda[] arreglo=new Hacienda[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Hacienda)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Hacienda param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarHacienda(new Hacienda(),"lngid",clave));
  }
  public void grabar(  Hacienda param){
    super.guardar(param);
  }
}

