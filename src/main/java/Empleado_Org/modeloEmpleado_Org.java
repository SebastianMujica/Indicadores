package Empleado_Org;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloEmpleado_Org extends ModeloBase {
  public Empleado_Org buscarEmpleado_Org(  Empleado_Org param,  String campo,  String clave){
    return (Empleado_Org)super.buscar(param,campo,clave).get(0);
  }
  public Empleado_Org[] buscarEmpleado_Orgs(){
    List<DtoBase> listaBase=super.buscar(new Empleado_Org());
    Empleado_Org[] arreglo=new Empleado_Org[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Empleado_Org)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Empleado_Org param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarEmpleado_Org(new Empleado_Org(),"lngid",clave));
  }
  public void grabar(  Empleado_Org param){
    super.guardar(param);
  }
}

