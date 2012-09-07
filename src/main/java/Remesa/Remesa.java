package Remesa;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;
import Nucleo.Nucleo;
import Productor.Productor;
import Hacienda.Hacienda;
import Tablon.Tablon;
@Entity
public  class Remesa extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  @NotNull() long lngnroremesa;
  @ManyToOne() Nucleo dtonucleo;
  @ManyToOne() Productor dtoproductor;
  @ManyToOne() Hacienda dtohacienda;
  @ManyToOne() Tablon dtotablon;
  @Size(min=0,max=50,message="{longitud}") String strnombreconductor;
  @Size(min=0,max=10,message="{longitud}") String strcedulaconductor;
  @Size(min=0,max=10,message="{longitud}") String strplacavehiculo;
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
  public long getLngnroremesa(){
    return lngnroremesa;
  }
  public void setLngnroremesa(  long param){
    this.lngnroremesa=param;
  }
  public Nucleo getDtonucleo(){
    return dtonucleo;
  }
  public void setDtonucleo(  Nucleo param){
    this.dtonucleo=param;
  }
  public Productor getDtoproductor(){
    return dtoproductor;
  }
  public void setDtoproductor(  Productor param){
    this.dtoproductor=param;
  }
  public Hacienda getDtohacienda(){
    return dtohacienda;
  }
  public void setDtohacienda(  Hacienda param){
    this.dtohacienda=param;
  }
  public Tablon getDtotablon(){
    return dtotablon;
  }
  public void setDtotablon(  Tablon param){
    this.dtotablon=param;
  }
  public String getStrnombreconductor(){
    return strnombreconductor;
  }
  public void setStrnombreconductor(  String param){
    this.strnombreconductor=param;
  }
  public String getStrcedulaconductor(){
    return strcedulaconductor;
  }
  public void setStrcedulaconductor(  String param){
    this.strcedulaconductor=param;
  }
  public String getStrplacavehiculo(){
    return strplacavehiculo;
  }
  public void setStrplacavehiculo(  String param){
    this.strplacavehiculo=param;
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
    return "lngid+ lngnroremesa+ dtonucleo+ dtoproductor+ dtohacienda+ dtotablon+ strnombreconductor+ strcedulaconductor+ strplacavehiculo+ dtmfecha_creacion+ dtmfecha_modificacion+ dtmvalido_desde+ dtmvalido_hasta+ bolactivo+ bolborrado+ strip_creacion+ strip_modificacion+ strhost_creacion+ strhost_modificacion";
  }
}

