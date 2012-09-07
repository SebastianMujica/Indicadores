package Inventario.UbicacionAlmacen;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import Organizacion.Organizacion;
import Inventario.Almacen.Almacen;
@Entity
@Table(name="tblinv_ubicacion_almacen")
public  class UbicacionAlmacen extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) @ManyToOne() Organizacion dto_org;
  @NotNull() @Size(min=3,max=20,message="{longitud}") String strcodigo;
  @JoinColumn(name="lnginv_almacen",insertable=true,updatable=true,nullable=false) @ManyToOne() Almacen dto_almacen;
  @NotNull() @Size(min=1,max=50,message="{longitud}") String strpasillo_x;
  @NotNull() @Size(min=1,max=50,message="{longitud}") String strnivel_y;
  @NotNull() @Size(min=1,max=50,message="{longitud}") String strestante_z;
  @NotNull() @Size(min=7,max=7,message="{longitud}") String strcolor_id;
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
  public Organizacion getDto_org(){
    return dto_org;
  }
  public void setDto_org(  Organizacion param){
    this.dto_org=param;
  }
  public String getStrcodigo(){
    return strcodigo;
  }
  public void setStrcodigo(  String param){
    this.strcodigo=param;
  }
  public Almacen getDto_almacen(){
    return dto_almacen;
  }
  public void setDto_almacen(  Almacen param){
    this.dto_almacen=param;
  }
  public String getStrpasillo_x(){
    return strpasillo_x;
  }
  public void setStrpasillo_x(  String param){
    this.strpasillo_x=param;
  }
  public String getStrnivel_y(){
    return strnivel_y;
  }
  public void setStrnivel_y(  String param){
    this.strnivel_y=param;
  }
  public String getStrestante_z(){
    return strestante_z;
  }
  public void setStrestante_z(  String param){
    this.strestante_z=param;
  }
  public String getStrcolor_id(){
    return strcolor_id;
  }
  public void setStrcolor_id(  String param){
    this.strcolor_id=param;
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
  public boolean isBolactivo() {
		return bolactivo;
	}
public boolean isBolborrado() {
		return bolborrado;
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
	  return strcodigo+ "_" + strcodigo + " (" + lngid+")" ;
  }
}

