package OrdenDeArrime;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Productor.Productor;
import Productor.Productor;
import Hacienda.Hacienda;
import Hacienda.Hacienda;
import Nucleo.Nucleo;
import Nucleo.Nucleo;
import Tablon.Tablon;
import Tecnico.Tecnico;
import Tecnico.Tecnico;
@Entity
public  class OrdenDeArrime extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  @NotNull() Date dtmfecha_arrime;
  @JoinColumn(name="socio_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Productor dtoproductor;
  @JoinColumn(name="hacienda_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Hacienda dtohacienda;
  @OneToMany() 
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(name="TablonesOrden", joinColumns = @JoinColumn( name="lngid"), inverseJoinColumns = @JoinColumn( name="tablon_lngid"))
  List<Tablon> tablonesacosechar;
  @JoinColumn(name="nucleo_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Nucleo dtonucleo;
  @JoinColumn(name="tecnico_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Tecnico dtoingazucarero;
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
  public Date getDtmfecha_arrime(){
    return dtmfecha_arrime;
  }
  public void setDtmfecha_arrime(  Date param){
    this.dtmfecha_arrime=param;
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
  public List<Tablon> getTablonesacosechar(){
    return tablonesacosechar;
  }
  public void setTablonesacosechar(  List<Tablon> param){
    this.tablonesacosechar=param;
  }
  public Nucleo getDtonucleo(){
    return dtonucleo;
  }
  public void setDtonucleo(  Nucleo param){
    this.dtonucleo=param;
  }
  public Tecnico getDtoingazucarero(){
    return dtoingazucarero;
  }
  public void setDtoingazucarero(  Tecnico param){
    this.dtoingazucarero=param;
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
    return lngid+" "+dtmfecha_arrime+" "+ dtoproductor;
  }
}

