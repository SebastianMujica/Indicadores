package Vehiculo;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloVehiculo extends ModeloBase {
  public Vehiculo buscarVehiculo(  Vehiculo param,  String campo,  String clave){
    return (Vehiculo)super.buscar(param,campo,clave).get(0);
  }
  public Vehiculo[] buscarVehiculos(){
    List<DtoBase> listaBase=super.buscar(new Vehiculo());
    Vehiculo[] arreglo=new Vehiculo[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Vehiculo)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Vehiculo param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarVehiculo(new Vehiculo(),"lngid",clave));
  }
  public void grabar(  Vehiculo param){
    super.guardar(param);
  }
}

