package SubZona;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import Zona.Zona;
public class modeloSubZona extends ModeloBase {
  public SubZona buscarSubZona(  SubZona param,  String campo,  String clave){
    return (SubZona)super.buscar(param,campo,clave).get(0);
  }
  public SubZona[] buscarSubZonas(){
    List<DtoBase> listaBase=super.buscar(new SubZona());
    SubZona[] arreglo=new SubZona[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(SubZona)listaBase.get(i);
    return arreglo;
  }
  
  public void eliminar(  SubZona param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarSubZona(new SubZona(),"lngid",clave));
  }
  public void grabar(  SubZona param){
    super.guardar(param);
  }
}

