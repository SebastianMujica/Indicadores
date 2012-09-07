package Estado;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloEstado extends ModeloBase {
  public Estado buscarEstado(  Estado param,  String campo,  String clave){
    return (Estado)super.buscar(param,campo,clave).get(0);
  }
  public Estado[] buscarEstados(){
    List<DtoBase> listaBase=super.buscar(new Estado());
    Estado[] arreglo=new Estado[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Estado)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Estado param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarEstado(new Estado(),"lngid",clave));
  }
  public void grabar(  Estado param){
    super.guardar(param);
  }
}

