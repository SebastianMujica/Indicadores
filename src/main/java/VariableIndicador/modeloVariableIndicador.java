package VariableIndicador;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloVariableIndicador extends ModeloBase {
  public VariableIndicador buscarVariableIndicador(  VariableIndicador param,  String campo,  String clave){
    return (VariableIndicador)super.buscar(param,campo,clave).get(0);
  }
  public VariableIndicador[] buscarVariableIndicadors(){
    List<DtoBase> listaBase=super.buscar(new VariableIndicador());
    VariableIndicador[] arreglo=new VariableIndicador[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(VariableIndicador)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  VariableIndicador param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarVariableIndicador(new VariableIndicador(),"lngid",clave));
  }
  public void grabar(  VariableIndicador param){
    super.guardar(param);
  }
}

