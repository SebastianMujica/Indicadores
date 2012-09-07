package Cargo_Org;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloCargo_Org extends ModeloBase {
  public Cargo_Org buscarCargo_Org(  Cargo_Org param,  String campo,  String clave){
    return (Cargo_Org)super.buscar(param,campo,clave).get(0);
  }
  public Cargo_Org[] buscarCargo_Orgs(){
    List<DtoBase> listaBase=super.buscar(new Cargo_Org());
    Cargo_Org[] arreglo=new Cargo_Org[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Cargo_Org)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Cargo_Org param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarCargo_Org(new Cargo_Org(),"lngid",clave));
  }
  public void grabar(  Cargo_Org param){
    super.guardar(param);
  }
}

