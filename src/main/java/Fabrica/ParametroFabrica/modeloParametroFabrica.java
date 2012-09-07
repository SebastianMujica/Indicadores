package Fabrica.ParametroFabrica;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloParametroFabrica extends ModeloBase {
  public ParametroFabrica buscarParametroFabrica(  ParametroFabrica param,  String campo,  String clave){
    return (ParametroFabrica)super.buscar(param,campo,clave).get(0);
  }
  public ParametroFabrica[] buscarParametroFabricas(){
    List<DtoBase> listaBase=super.buscar(new ParametroFabrica());
    ParametroFabrica[] arreglo=new ParametroFabrica[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(ParametroFabrica)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  ParametroFabrica param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarParametroFabrica(new ParametroFabrica(),"lngid",clave));
  }
  public void grabar(  ParametroFabrica param){
    super.guardar(param);
  }
}

