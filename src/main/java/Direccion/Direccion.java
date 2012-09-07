package Direccion;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Pais.Pais;
import Pais.Pais;
import Estado.Estado;
import Estado.Estado;
import Municipio.Municipio;
import Municipio.Municipio;
import Parroquia.Parroquia;
import Parroquia.Parroquia;
import Telefono.Telefono;
import Telefono.Telefono;
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public  class Direccion extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  @NotNull() @Size() String strdireccion;
  @NotNull() @Size() String strciudadpoblacion;
  @NotNull() @Size() String strreferencia;
  @JoinColumn(name="pais_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Pais dtopais;
  @JoinColumn(name="estado_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Estado dtoestado;
  @JoinColumn(name="municipio_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Municipio dtomunicipio;
  @JoinColumn(name="parroquia_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() Parroquia dtoparroquia;
  @NotNull() @Size() String strzonapostal;
  @OneToMany() 
  @LazyCollection(LazyCollectionOption.FALSE) 
  @JoinTable(name="TelefonosAsociadosDireccion", joinColumns = @JoinColumn( name="lngid_Dir"), inverseJoinColumns = @JoinColumn( name="telefono_lngid"))
  List<Telefono> dtotelefono;
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
  public String getStrdireccion(){
    return strdireccion;
  }
  public void setStrdireccion(  String param){
    this.strdireccion=param;
  }
  public String getStrciudadpoblacion(){
    return strciudadpoblacion;
  }
  public void setStrciudadpoblacion(  String param){
    this.strciudadpoblacion=param;
  }
  public String getStrreferencia(){
    return strreferencia;
  }
  public void setStrreferencia(  String param){
    this.strreferencia=param;
  }
  public Pais getDtopais(){
    return dtopais;
  }
  public void setDtopais(  Pais param){
    this.dtopais=param;
  }
  public Estado getDtoestado(){
    return dtoestado;
  }
  public void setDtoestado(  Estado param){
    this.dtoestado=param;
  }
  public Municipio getDtomunicipio(){
    return dtomunicipio;
  }
  public void setDtomunicipio(  Municipio param){
    this.dtomunicipio=param;
  }
  public Parroquia getDtoparroquia(){
    return dtoparroquia;
  }
  public void setDtoparroquia(  Parroquia param){
    this.dtoparroquia=param;
  }
  public String getStrzonapostal(){
    return strzonapostal;
  }
  public void setStrzonapostal(  String param){
    this.strzonapostal=param;
  }
  public List<Telefono> getDtotelefono(){
    return dtotelefono;
  }
  public void setDtotelefono(  List<Telefono> param){
    this.dtotelefono=param;
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
    return lngid+" "+strciudadpoblacion+" "+strreferencia;
  }
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + (int) (lngid ^ (lngid >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	Direccion other = (Direccion) obj;
	if (lngid != other.lngid) {
		return false;
	}
	return true;
}
  
}

