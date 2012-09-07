package Reporte;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloReporte extends ModeloBase {
  public Reporte buscarReporte(  Reporte param,  String campo,  String clave){
    return (Reporte)super.buscar(param,campo,clave).get(0);
  }
  public Reporte[] buscarReportes(){
    List<DtoBase> listaBase=super.buscar(new Reporte());
    Reporte[] arreglo=new Reporte[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Reporte)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Reporte param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarReporte(new Reporte(),"lngid",clave));
  }
  public void grabar(  Reporte param){
    super.guardar(param);
  }
}

