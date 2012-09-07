package Nucleo;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloNucleo extends ModeloBase {
  public Nucleo buscarNucleo(  Nucleo param,  String campo,  String clave){
    return (Nucleo)super.buscar(param,campo,clave).get(0);
  }
  public Nucleo[] buscarNucleos(){
    List<DtoBase> listaBase=super.buscar(new Nucleo());
    Nucleo[] arreglo=new Nucleo[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Nucleo)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Nucleo param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarNucleo(new Nucleo(),"lngid",clave));
  }
  public void grabar(  Nucleo param){
    super.guardar(param);
  }
}

