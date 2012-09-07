package Tema;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloTema extends ModeloBase {
  public Tema buscarTema(  Tema param,  String campo,  String clave){
    return (Tema)super.buscar(param,campo,clave).get(0);
  }
  public Tema[] buscarTemas(){
    List<DtoBase> listaBase=super.buscar(new Tema());
    Tema[] arreglo=new Tema[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Tema)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Tema param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarTema(new Tema(),"lngid",clave));
  }
  public void grabar(  Tema param){
    super.guardar(param);
  }
}

