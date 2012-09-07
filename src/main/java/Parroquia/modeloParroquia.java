package Parroquia;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloParroquia extends ModeloBase {
  public Parroquia buscarParroquia(  Parroquia param,  String campo,  String clave){
    return (Parroquia)super.buscar(param,campo,clave).get(0);
  }
  public Parroquia[] buscarParroquias(){
    List<DtoBase> listaBase=super.buscar(new Parroquia());
    Parroquia[] arreglo=new Parroquia[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Parroquia)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Parroquia param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarParroquia(new Parroquia(),"lngid",clave));
  }
  public void grabar(  Parroquia param){
    super.guardar(param);
  }
}

