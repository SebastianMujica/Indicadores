package OrdenDeArrime;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloOrdenDeArrime extends ModeloBase {
  public OrdenDeArrime buscarOrdenDeArrime(  OrdenDeArrime param,  String campo,  String clave){
    return (OrdenDeArrime)super.buscar(param,campo,clave).get(0);
  }
  public OrdenDeArrime[] buscarOrdenDeArrimes(){
    List<DtoBase> listaBase=super.buscar(new OrdenDeArrime());
    OrdenDeArrime[] arreglo=new OrdenDeArrime[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(OrdenDeArrime)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  OrdenDeArrime param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarOrdenDeArrime(new OrdenDeArrime(),"lngid",clave));
  }
  public void grabar(  OrdenDeArrime param){
    super.guardar(param);
  }
}

