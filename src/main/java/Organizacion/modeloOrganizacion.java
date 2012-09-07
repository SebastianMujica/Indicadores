package Organizacion;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloOrganizacion extends ModeloBase {
  public Organizacion buscarOrganizacion(  Organizacion param,  String campo,  String clave){
    return (Organizacion)super.buscar(param,campo,clave).get(0);
  }
  public Organizacion[] buscarOrganizacions(){
    List<DtoBase> listaBase=super.buscar(new Organizacion());
    Organizacion[] arreglo=new Organizacion[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Organizacion)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Organizacion param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarOrganizacion(new Organizacion(),"lngid",clave));
  }
  public void grabar(  Organizacion param){
    super.guardar(param);
  }
}

