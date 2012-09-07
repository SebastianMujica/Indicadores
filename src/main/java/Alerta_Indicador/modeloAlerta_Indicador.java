package Alerta_Indicador;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloAlerta_Indicador extends ModeloBase {
  public Alerta_Indicador buscarAlerta_Indicador(  Alerta_Indicador param,  String campo,  String clave){
    return (Alerta_Indicador)super.buscar(param,campo,clave).get(0);
  }
  public Alerta_Indicador[] buscarAlerta_Indicadors(){
    List<DtoBase> listaBase=super.buscar(new Alerta_Indicador());
    Alerta_Indicador[] arreglo=new Alerta_Indicador[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Alerta_Indicador)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Alerta_Indicador param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarAlerta_Indicador(new Alerta_Indicador(),"lngid",clave));
  }
  public void grabar(  Alerta_Indicador param){
    super.guardar(param);
  }
}

