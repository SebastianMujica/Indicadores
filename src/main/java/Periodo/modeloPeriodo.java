package Periodo;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloPeriodo extends ModeloBase {
  public Periodo buscarPeriodo(  Periodo param,  String campo,  String clave){
    return (Periodo)super.buscar(param,campo,clave).get(0);
  }
  public Periodo[] buscarPeriodos(){
    List<DtoBase> listaBase=super.buscar(new Periodo());
    Periodo[] arreglo=new Periodo[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Periodo)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Periodo param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarPeriodo(new Periodo(),"lngid",clave));
  }
  public void grabar(  Periodo param){
    super.guardar(param);
  }
}

