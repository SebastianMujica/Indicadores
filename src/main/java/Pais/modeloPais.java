package Pais;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloPais extends ModeloBase {
  public Pais buscarPais(  Pais param,  String campo,  String clave){
    return (Pais)super.buscar(param,campo,clave).get(0);
  }
  public Pais[] buscarPaiss(){
    List<DtoBase> listaBase=super.buscar(new Pais());
    Pais[] arreglo=new Pais[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Pais)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Pais param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarPais(new Pais(),"lngid",clave));
  }
  public void grabar(  Pais param){
    super.guardar(param);
  }
}

