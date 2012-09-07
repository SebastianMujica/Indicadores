package Fabrica.ParametroFabrica;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import Organizacion.Organizacion;
import Organizacion.Organizacion;
import UnidadDeMedida.UnidadDeMedida;
import UnidadDeMedida.UnidadDeMedida;
//import Formula.Formula;
//import Formula.Formula;
@Entity
@Table(name="tblfab_parametro_fabrica")
public  class ParametroFabrica extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) @ManyToOne() Organizacion dto_org;
  @NotNull() @Size(min=3,max=20,message="{longitud}") String strcodigo;
  @NotNull() @Size(min=3,max=50,message="{longitud}") String strnombre;
  String strdescripcion;
  @JoinColumn(name="lngsis_unidad_medida",insertable=true,updatable=true,nullable=false) @ManyToOne() UnidadDeMedida dto_unidad_medida;
  @NotNull() float flolim_inf_num;
  @NotNull() float flolim_sup_num;
  //@JoinColumn(name="lngsis_formula",insertable=true,updatable=true,nullable=true) @ManyToOne() Formula dto_formula;
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
  public String getStrnombre(){
    return strnombre;
  }
  public void setStrnombre(  String param){
    this.strnombre=param;
  }
  public String getStrdescripcion(){
    return strdescripcion;
  }
  public void setStrdescripcion(  String param){
    this.strdescripcion=param;
  }
  public UnidadDeMedida getDto_unidad_medida(){
    return dto_unidad_medida;
  }
  public void setDto_unidad_medida(  UnidadDeMedida param){
    this.dto_unidad_medida=param;
  }
  public float getFlolim_inf_num(){
    return flolim_inf_num;
  }
  public void setFlolim_inf_num(  float param){
    this.flolim_inf_num=param;
  }
  public float getFlolim_sup_num(){
    return flolim_sup_num;
  }
  public void setFlolim_sup_num(  float param){
    this.flolim_sup_num=param;
  }
  /*public Formula getDto_formula(){
    return dto_formula;
  }
  public void setDto_formula(  Formula param){
    this.dto_formula=param;
  }
  */
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
	  return strnombre + " (" + strcodigo +")" ;
  }
}

