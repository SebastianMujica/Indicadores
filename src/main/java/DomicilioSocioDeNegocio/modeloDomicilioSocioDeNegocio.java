package DomicilioSocioDeNegocio;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloDomicilioSocioDeNegocio extends ModeloBase {
  public DomicilioSocioDeNegocio buscarDomicilioSocioDeNegocio(  DomicilioSocioDeNegocio param,  String campo,  String clave){
    return (DomicilioSocioDeNegocio)super.buscar(param,campo,clave).get(0);
  }
  public DomicilioSocioDeNegocio[] buscarDomicilioSocioDeNegocios(){
    List<DtoBase> listaBase=super.buscar(new DomicilioSocioDeNegocio());
    DomicilioSocioDeNegocio[] arreglo=new DomicilioSocioDeNegocio[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(DomicilioSocioDeNegocio)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  DomicilioSocioDeNegocio param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarDomicilioSocioDeNegocio(new DomicilioSocioDeNegocio(),"lngid",clave));
  }
  public void grabar(  DomicilioSocioDeNegocio param){
    super.guardar(param);
  }
}

