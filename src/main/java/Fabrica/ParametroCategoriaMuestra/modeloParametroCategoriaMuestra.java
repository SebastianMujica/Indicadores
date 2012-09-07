package Fabrica.ParametroCategoriaMuestra;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloParametroCategoriaMuestra extends ModeloBase {
  public ParametroCategoriaMuestra buscarParametroCategoriaMuestra(  ParametroCategoriaMuestra param,  String campo,  String clave){
    return (ParametroCategoriaMuestra)super.buscar(param,campo,clave).get(0);
  }
  public ParametroCategoriaMuestra[] buscarParametroCategoriaMuestras(){
    List<DtoBase> listaBase=super.buscar(new ParametroCategoriaMuestra());
    ParametroCategoriaMuestra[] arreglo=new ParametroCategoriaMuestra[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(ParametroCategoriaMuestra)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  ParametroCategoriaMuestra param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarParametroCategoriaMuestra(new ParametroCategoriaMuestra(),"lngid",clave));
  }
  public void grabar(  ParametroCategoriaMuestra param){
    super.guardar(param);
  }
}

