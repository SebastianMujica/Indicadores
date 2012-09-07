package Tablon;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;
import Hacienda.Hacienda;
@Entity
public  class Tablon extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  @ManyToOne() Hacienda dtohacienda;
  @NotNull() @Size(min=3,max=40,message="{longitud}") String strnombre;
  @NotNull() float flohectareas;
  @NotNull() float flotoneladas_estimadas;
  @NotNull() @Size(min=3,max=40,message="{longitud}") String strvariedad_cana;
  @NotNull() @Size(min=3,max=40,message="{longitud}") String strclase_cana;
  Date dtmfecha_creacion;
  Date dtmfecha_modificacion;
  Date dtmvalido_desde;
  Date dtmvalido_hasta;
  boolean bolactivo;
  boolean bolborrado;
  String strip_creacion;
  String strip_modificacion;
  String strhost_creacion;
  String strhost_modificacion;
  public long getLngid(){
    return lngid;
  }
  public void setLngid(  long param){
    this.lngid=param;
  }
  public Hacienda getDtohacienda(){
    return dtohacienda;
  }
  public void setDtohacienda(  Hacienda param){
    this.dtohacienda=param;
  }
  public String getStrnombre(){
    return strnombre;
  }
  public void setStrnombre(  String param){
    this.strnombre=param;
  }
  public float getFlohectareas(){
    return flohectareas;
  }
  public void setFlohectareas(  float param){
    this.flohectareas=param;
  }
  public float getFlotoneladas_estimadas(){
    return flotoneladas_estimadas;
  }
  public void setFlotoneladas_estimadas(  float param){
    this.flotoneladas_estimadas=param;
  }
  public String getStrvariedad_cana(){
    return strvariedad_cana;
  }
  public void setStrvariedad_cana(  String param){
    this.strvariedad_cana=param;
  }
  public String getStrclase_cana(){
    return strclase_cana;
  }
  public void setStrclase_cana(  String param){
    this.strclase_cana=param;
  }
  public Date getDtmfecha_creacion(){
    return dtmfecha_creacion;
  }
  public void setDtmfecha_creacion(  Date param){
    this.dtmfecha_creacion=param;
  }
  public Date getDtmfecha_modificacion(){
    return dtmfecha_modificacion;
  }
  public void setDtmfecha_modificacion(  Date param){
    this.dtmfecha_modificacion=param;
  }
  public Date getDtmvalido_desde(){
    return dtmvalido_desde;
  }
  public void setDtmvalido_desde(  Date param){
    this.dtmvalido_desde=param;
  }
  public Date getDtmvalido_hasta(){
    return dtmvalido_hasta;
  }
  public void setDtmvalido_hasta(  Date param){
    this.dtmvalido_hasta=param;
  }
  public boolean getBolactivo(){
    return bolactivo;
  }
  public void setBolactivo(  boolean param){
    this.bolactivo=param;
  }
  public boolean getBolborrado(){
    return bolborrado;
  }
  public void setBolborrado(  boolean param){
    this.bolborrado=param;
  }
  public String getStrip_creacion(){
    return strip_creacion;
  }
  public void setStrip_creacion(  String param){
    this.strip_creacion=param;
  }
  public String getStrip_modificacion(){
    return strip_modificacion;
  }
  public void setStrip_modificacion(  String param){
    this.strip_modificacion=param;
  }
  public String getStrhost_creacion(){
    return strhost_creacion;
  }
  public void setStrhost_creacion(  String param){
    this.strhost_creacion=param;
  }
  public String getStrhost_modificacion(){
    return strhost_modificacion;
  }
  public void setStrhost_modificacion(  String param){
    this.strhost_modificacion=param;
  }
  public String toString(){
    return lngid+" "+ strnombre;
  }
}

