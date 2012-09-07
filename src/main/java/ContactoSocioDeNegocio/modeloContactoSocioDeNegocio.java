package ContactoSocioDeNegocio;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloContactoSocioDeNegocio extends ModeloBase {
  public ContactoSocioDeNegocio buscarContactoSocioDeNegocio(  ContactoSocioDeNegocio param,  String campo,  String clave){
    return (ContactoSocioDeNegocio)super.buscar(param,campo,clave).get(0);
  }
  public ContactoSocioDeNegocio[] buscarContactoSocioDeNegocios(){
    List<DtoBase> listaBase=super.buscar(new ContactoSocioDeNegocio());
    ContactoSocioDeNegocio[] arreglo=new ContactoSocioDeNegocio[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(ContactoSocioDeNegocio)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  ContactoSocioDeNegocio param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarContactoSocioDeNegocio(new ContactoSocioDeNegocio(),"lngid",clave));
  }
  public void grabar(  ContactoSocioDeNegocio param){
    super.guardar(param);
  }
}

