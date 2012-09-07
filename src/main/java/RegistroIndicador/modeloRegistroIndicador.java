package RegistroIndicador;
import java.util.ArrayList;
import java.util.List;


import Indicador.Indicador;



import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloRegistroIndicador extends ModeloBase {
  public RegistroIndicador buscarRegistroIndicador(  RegistroIndicador param,  String campo,  String clave){
    return (RegistroIndicador)super.buscar(param,campo,clave).get(0);
  }
  public RegistroIndicador[] buscarRegistroIndicadors(){
    List<DtoBase> listaBase=super.buscar(new RegistroIndicador());
    RegistroIndicador[] arreglo=new RegistroIndicador[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(RegistroIndicador)listaBase.get(i);
    return arreglo;
  }
  public RegistroIndicador[] nUltimos(int n,long id,Indicador campo){
	    List<DtoBase> listaBase=super.nUltimos(new RegistroIndicador(), n, id,campo);
	    RegistroIndicador[] arreglo=new RegistroIndicador[listaBase.size()];
	    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(RegistroIndicador)listaBase.get(i);
	    return arreglo;
	  }
  public List<RegistroIndicador> getRegistroIndicadors(){
	  List<DtoBase> listaBase=this.buscar(new RegistroIndicador());
	  List<RegistroIndicador> lista=new ArrayList<RegistroIndicador>();
	  for (DtoBase dtoBase : listaBase) {
		lista.add((RegistroIndicador)dtoBase);
	}
	  return lista;
  }
  
  public void eliminar(  RegistroIndicador param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarRegistroIndicador(new RegistroIndicador(),"lngid",clave));
  }
  public void grabar(  RegistroIndicador param){
    super.guardar(param);
  }
  public void grabar(  RegistroIndicador param,boolean bolTran){
	    super.guardar(param,bolTran);
  }
  public void iniciar_operacion(){
	  super.iniciaOperacion();
  }
  public void terminar_operacion(){
	  super.cerrar_transaccion(super.getTransaccion());
  }
}

