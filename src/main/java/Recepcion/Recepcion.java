package Recepcion;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;
import Productor.Productor;
import Productor.Productor;
import Hacienda.Hacienda;
import Hacienda.Hacienda;
import Tablon.Tablon;
import Tablon.Tablon;
import OrdenDeArrime.OrdenDeArrime;
import OrdenDeArrime.OrdenDeArrime;
import Nucleo.Nucleo;
import Nucleo.Nucleo;
import Tecnico.Tecnico;
import Tecnico.Tecnico;
import Vehiculo.Vehiculo;
import Vehiculo.Vehiculo;
@Entity
public  class Recepcion extends DtoBase {
  @Id() @GeneratedValue() long lngid;
  @NotNull() @Size() String strremesa;
  @JoinColumn(name="productor_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Productor dtoproductor;
  @JoinColumn(name="hacienda_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Hacienda dtohacienda;
  @JoinColumn(name="tablon_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Tablon dtotablon;
  @JoinColumn(name="ordendearrime_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() OrdenDeArrime dtoordendearrime;
  @NotNull() Date dtmfechadequema;
  @JoinColumn(name="nucleo_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Nucleo dtonucleo;
  @JoinColumn(name="tecnico_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Tecnico dtotecnico;
  @NotNull() String strchofer;
  @JoinColumn(name="vehiculo_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Vehiculo dtovehiculo;
  @NotNull() Float flopesobruto;
  @NotNull() Float flopesotara;
  @NotNull() String strobservacion;
  @NotNull() Date dtmfechaentrada;
  @NotNull() Date dtmfechadesalida;
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
  public String getStrremesa(){
    return strremesa;
  }
  public void setStrremesa(  String param){
    this.strremesa=param;
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
  public OrdenDeArrime getDtoordendearrime(){
    return dtoordendearrime;
  }
  public void setDtoordendearrime(  OrdenDeArrime param){
    this.dtoordendearrime=param;
  }
  public Date getDtmfechadequema(){
    return dtmfechadequema;
  }
  public void setDtmfechadequema(  Date param){
    this.dtmfechadequema=param;
  }
  public Nucleo getDtonucleo(){
    return dtonucleo;
  }
  public void setDtonucleo(  Nucleo param){
    this.dtonucleo=param;
  }
  public Tecnico getDtotecnico(){
    return dtotecnico;
  }
  public void setDtotecnico(  Tecnico param){
    this.dtotecnico=param;
  }
  public String getStrchofer(){
    return strchofer;
  }
  public void setStrchofer(  String param){
    this.strchofer=param;
  }
  public Vehiculo getDtovehiculo(){
    return dtovehiculo;
  }
  public void setDtovehiculo(  Vehiculo param){
    this.dtovehiculo=param;
  }
  public Float getFlopesobruto(){
    return flopesobruto;
  }
  public void setFlopesobruto(  Float param){
    this.flopesobruto=param;
  }
  public Float getFlopesotara(){
    return flopesotara;
  }
  public void setFlopesotara(  Float param){
    this.flopesotara=param;
  }
  public String getStrobservacion(){
    return strobservacion;
  }
  public void setStrobservacion(  String param){
    this.strobservacion=param;
  }
  public Date getDtmfechaentrada(){
    return dtmfechaentrada;
  }
  public void setDtmfechaentrada(  Date param){
    this.dtmfechaentrada=param;
  }
  public Date getDtmfechadesalida(){
    return dtmfechadesalida;
  }
  public void setDtmfechadesalida(  Date param){
    this.dtmfechadesalida=param;
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
    return "lngid+ strremesa+ dtoproductor+ dtohacienda+ dtotablon+ dtoordendearrime+ dtmfechadequema+ dtonucleo+ dtotecnico+ strchofer+ dtovehiculo+ flopesobruto+ flopesotara+ strobservacion+ dtmfechaentrada+ dtmfechadesalida+ dtmfecha_creacion+ dtmfecha_modificacion+ dtmvalido_desde+ dtmvalido_hasta+ bolactivo+ bolborrado+ strip_creacion+ strip_modificacion+ strhost_creacion+ strhost_modificacion";
  }
}

