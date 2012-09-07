package RegistroVariable;
import java.util.ArrayList;
import java.util.List;

import RegistroIndicador.RegistroIndicador;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloRegistroVariable extends ModeloBase {
  public RegistroVariable buscarRegistroVariable(  RegistroVariable param,  String campo,  String clave){
    return (RegistroVariable)super.buscar(param,campo,clave).get(0);
  }
  public RegistroVariable[] buscarRegistroVariables(){
    List<DtoBase> listaBase=super.buscar(new RegistroVariable());
    RegistroVariable[] arreglo=new RegistroVariable[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(RegistroVariable)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  RegistroVariable param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarRegistroVariable(new RegistroVariable(),"lngid",clave));
  }
  public void grabar(  RegistroVariable param){
    super.guardar(param);
  }
  public void grabar(  RegistroVariable param,boolean bolTran){
	    super.guardar(param,bolTran);
}
public void iniciar_operacion(){
	  super.iniciaOperacion();
}
public void terminar_operacion(){
	  super.cerrar_transaccion(super.getTransaccion());
}
}

