package Fabrica.ParametroCategoriaMuestra;
import java.util.*;

import SwingBernate.*;
import Tablon.Tablon;

import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Organizacion.Organizacion;
import Maestro.Maestro;
import Fabrica.ParametroFabrica.ParametroFabrica;
@Entity
@Table(name="tblfab_parametro_categoria_muestra")
public  class ParametroCategoriaMuestra extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false)
  @ManyToOne() Organizacion dto_org;
  
  @JoinColumn(name="lngfab_categoria_muestra",insertable=true,updatable=true,nullable=false) 
  @ManyToOne() Maestro dto_categoria_muestra;
  //@JoinColumn(name="lngfab_parametro_fabrica",insertable=true,updatable=true,nullable=false) @ManyToMany() List<ParametroFabrica> dto_parametro_fabrica;
  @OneToMany() 
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(name="tblfab_param_cat",uniqueConstraints = {
		    @UniqueConstraint(columnNames={"lngparametro_categoria_muestra","lngfab_parametro_fabrica"})},
		    joinColumns = @JoinColumn( name="lngparametro_categoria_muestra"), inverseJoinColumns = @JoinColumn( name="lngfab_parametro_fabrica"))
  List<ParametroFabrica> dto_parametro_fabrica;
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
  public Maestro getDto_categoria_muestra(){
    return dto_categoria_muestra;
  }
  public void setDto_categoria_muestra(  Maestro param){
    this.dto_categoria_muestra=param;
  }
  public List<ParametroFabrica> getDto_parametro_fabrica(){
    return dto_parametro_fabrica;
  }
  public void setDto_parametro_fabrica(  List<ParametroFabrica> param){
    this.dto_parametro_fabrica=param;
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
    return "";
  }
}

