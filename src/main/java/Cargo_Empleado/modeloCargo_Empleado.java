package Cargo_Empleado;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloCargo_Empleado extends ModeloBase {
  public Cargo_Empleado buscarCargo_Empleado(  Cargo_Empleado param,  String campo,  String clave){
    return (Cargo_Empleado)super.buscar(param,campo,clave).get(0);
  }
  public Cargo_Empleado[] buscarCargo_Empleados(){
    List<DtoBase> listaBase=super.buscar(new Cargo_Empleado());
    Cargo_Empleado[] arreglo=new Cargo_Empleado[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Cargo_Empleado)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Cargo_Empleado param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarCargo_Empleado(new Cargo_Empleado(),"lngid",clave));
  }
  public void grabar(  Cargo_Empleado param){
    super.guardar(param);
  }
}

