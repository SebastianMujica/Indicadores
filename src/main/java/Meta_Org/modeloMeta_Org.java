package Meta_Org;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloMeta_Org extends ModeloBase {
  public Meta_Org buscarMeta_Org(  Meta_Org param,  String campo,  String clave){
    return (Meta_Org)super.buscar(param,campo,clave).get(0);
  }
  public Meta_Org[] buscarMeta_Orgs(){
    List<DtoBase> listaBase=super.buscar(new Meta_Org());
    Meta_Org[] arreglo=new Meta_Org[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Meta_Org)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Meta_Org param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarMeta_Org(new Meta_Org(),"lngid",clave));
  }
  public void grabar(  Meta_Org param){
    super.guardar(param);
  }
}

