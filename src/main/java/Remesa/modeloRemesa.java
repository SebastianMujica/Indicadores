package Remesa;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloRemesa extends ModeloBase {
  public Remesa buscarRemesa(  Remesa param,  String campo,  String clave){
    return (Remesa)super.buscar(param,campo,clave).get(0);
  }
  public Remesa[] buscarRemesas(){
    List<DtoBase> listaBase=super.buscar(new Remesa());
    Remesa[] arreglo=new Remesa[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Remesa)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Remesa param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarRemesa(new Remesa(),"lngid",clave));
  }
  public void grabar(  Remesa param){
    super.guardar(param);
  }
}

