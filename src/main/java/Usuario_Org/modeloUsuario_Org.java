package Usuario_Org;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloUsuario_Org extends ModeloBase {
  public Usuario_Org buscarUsuario_Org(  Usuario_Org param,  String campo,  String clave){
    return (Usuario_Org)super.buscar(param,campo,clave).get(0);
  }
  public Usuario_Org[] buscarUsuario_Orgs(){
    List<DtoBase> listaBase=super.buscar(new Usuario_Org());
    Usuario_Org[] arreglo=new Usuario_Org[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Usuario_Org)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Usuario_Org param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarUsuario_Org(new Usuario_Org(),"lngid",clave));
  }
  public void grabar(  Usuario_Org param){
    super.guardar(param);
  }
}