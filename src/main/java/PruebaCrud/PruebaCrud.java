package PruebaCrud;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;
public class PruebaCrud extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long id;
  @NotNull() @Size(min=3,max=40,message="{longitud}") String nombre;
  @NotNull() @Size(min=7,max=8,message="{longitud}") @OneToMany(mappedBy="padre",cascade=CascadeType.ALL,fetch=FetchType.EAGER) String cedula;
  public long getId(){
    return id;
  }
  public void setId(  long param){
    this.id=param;
  }
  public String getNombre(){
    return nombre;
  }
  public void setNombre(  String param){
    this.nombre=param;
  }
  public String getCedula(){
    return cedula;
  }
  public void setCedula(  String param){
    this.cedula=param;
  }
  public String toString(){
    return "id+ nombre+ cedula";
  }
}

