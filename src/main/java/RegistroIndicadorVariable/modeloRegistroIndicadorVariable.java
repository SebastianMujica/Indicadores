package RegistroIndicadorVariable;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloRegistroIndicadorVariable extends ModeloBase {
  public RegistroIndicadorVariable buscarRegistroIndicadorVariable(  RegistroIndicadorVariable param,  String campo,  String clave){
    return (RegistroIndicadorVariable)super.buscar(param,campo,clave).get(0);
  }
  public RegistroIndicadorVariable[] buscarRegistroIndicadorVariables(){
    List<DtoBase> listaBase=super.buscar(new RegistroIndicadorVariable());
    RegistroIndicadorVariable[] arreglo=new RegistroIndicadorVariable[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(RegistroIndicadorVariable)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  RegistroIndicadorVariable param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarRegistroIndicadorVariable(new RegistroIndicadorVariable(),"lngid",clave));
  }
  public void grabar(  RegistroIndicadorVariable param){
    super.guardar(param);
  }
}

