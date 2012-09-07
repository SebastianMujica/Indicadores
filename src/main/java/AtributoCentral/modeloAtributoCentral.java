package AtributoCentral;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloAtributoCentral extends ModeloBase {
  public AtributoCentral buscarAtributoCentral(  AtributoCentral param,  String campo,  String clave){
    return (AtributoCentral)super.buscar(param,campo,clave).get(0);
  }
  public AtributoCentral[] buscarAtributoCentrals(){
    List<DtoBase> listaBase=super.buscar(new AtributoCentral());
    AtributoCentral[] arreglo=new AtributoCentral[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(AtributoCentral)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  AtributoCentral param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarAtributoCentral(new AtributoCentral(),"lngid",clave));
  }
  public void grabar(  AtributoCentral param){
    super.guardar(param);
  }
}

