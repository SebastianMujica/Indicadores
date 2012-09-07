package Municipio;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloMunicipio extends ModeloBase {
  public Municipio buscarMunicipio(  Municipio param,  String campo,  String clave){
    return (Municipio)super.buscar(param,campo,clave).get(0);
  }
  public Municipio[] buscarMunicipios(){
    List<DtoBase> listaBase=super.buscar(new Municipio());
    Municipio[] arreglo=new Municipio[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Municipio)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Municipio param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarMunicipio(new Municipio(),"lngid",clave));
  }
  public void grabar(  Municipio param){
    super.guardar(param);
  }
}

