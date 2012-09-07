package SocioDeNegocio;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloSocioDeNegocio extends ModeloBase {
  public SocioDeNegocio buscarSocioDeNegocio(  SocioDeNegocio param,  String campo,  String clave){
    return (SocioDeNegocio)super.buscar(param,campo,clave).get(0);
  }
  public SocioDeNegocio[] buscarSocioDeNegocios(){
    List<DtoBase> listaBase=super.buscar(new SocioDeNegocio());
    SocioDeNegocio[] arreglo=new SocioDeNegocio[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(SocioDeNegocio)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  SocioDeNegocio param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarSocioDeNegocio(new SocioDeNegocio(),"lngid",clave));
  }
  public void grabar(  SocioDeNegocio param){
    super.guardar(param);
  }
}
