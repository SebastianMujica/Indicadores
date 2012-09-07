package Variable;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloVariable extends ModeloBase {
  public Variable buscarVariable(  Variable param,  String campo,  String clave){
    return (Variable)super.buscar(param,campo,clave).get(0);
  }
  public Variable[] buscarVariables(){
    List<DtoBase> listaBase=super.buscar(new Variable());
    Variable[] arreglo=new Variable[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Variable)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Variable param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarVariable(new Variable(),"lngid",clave));
  }
  public void grabar(  Variable param){
    super.guardar(param);
  }
  
  public Variable[] buscarVariables(String campo,String clave){
	    List<DtoBase> listaBase=super.buscar(new Variable(),campo,clave);
	    Variable[] arreglo=new Variable[listaBase.size()];
	    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Variable)listaBase.get(i);
	    return arreglo;
	  }

  
  
  
}

