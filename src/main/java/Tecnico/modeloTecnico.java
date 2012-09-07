package Tecnico;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloTecnico extends ModeloBase {
  public Tecnico buscarTecnico(  Tecnico param,  String campo,  String clave){
    return (Tecnico)super.buscar(param,campo,clave).get(0);
  }
  public Tecnico[] buscarTecnicos(){
    List<DtoBase> listaBase=super.buscar(new Tecnico());
    Tecnico[] arreglo=new Tecnico[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Tecnico)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Tecnico param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarTecnico(new Tecnico(),"lngid",clave));
  }
  public void grabar(  Tecnico param){
    super.guardar(param);
  }
}

