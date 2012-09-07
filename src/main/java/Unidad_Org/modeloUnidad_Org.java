package Unidad_Org;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloUnidad_Org extends ModeloBase {
  public Unidad_Org buscarUnidad_Org(  Unidad_Org param,  String campo,  String clave){
    return (Unidad_Org)super.buscar(param,campo,clave).get(0);
  }
  public Unidad_Org[] buscarUnidad_Orgs(){
    List<DtoBase> listaBase=super.buscar(new Unidad_Org());
    Unidad_Org[] arreglo=new Unidad_Org[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Unidad_Org)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Unidad_Org param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarUnidad_Org(new Unidad_Org(),"lngid",clave));
  }
  public void grabar(  Unidad_Org param){
    super.guardar(param);
  }
}

