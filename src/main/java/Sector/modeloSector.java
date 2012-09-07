package Sector;
import java.util.ArrayList;
import java.util.List;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloSector extends ModeloBase {
  public Sector buscarSector(  Sector param,  String campo,  String clave){
    return (Sector)super.buscar(param,campo,clave).get(0);
  }
  public Sector[] buscarSectors(){
    List<DtoBase> listaBase=super.buscar(new Sector());
    Sector[] arreglo=new Sector[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Sector)listaBase.get(i);
    return arreglo;
  }
  public void eliminar(  Sector param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarSector(new Sector(),"lngid",clave));
  }
  public void grabar(  Sector param){
    super.guardar(param);
  }
}

