package ContactoSocioDeNegocio;
import java.util.*;

import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import SocioDeNegocio.SocioDeNegocio;
import Maestro.Maestro;
@Entity
@Table(name="tblsis_contacto_socionegocio")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)

public  class ContactoSocioDeNegocio extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_sociodenegocio_contacto") 
  @JoinColumn(name="lngsis_sociodenegocio",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) SocioDeNegocio dto_sociodenegocio;
  
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_sociodenegocio_contacto") 
  @JoinColumn(name="lngsis_tipo_contacto",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dto_tipo_contacto;
  
  @Size(min=4,max=4,message="{longitud}") String strcod_area;
  @Size(min=7,max=7,message="{longitud}") String strnro_telf;
  @Size(min=6,max=80,message="{longitud}") String strvalor_comunicacion;
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
	long lngseg_usuario_creacion;
	long lngseg_usuario_modificacion;
	
  public long getLngid(){
    return lngid;
  }
  public void setLngid(  long param){
    this.lngid=param;
  }
  public SocioDeNegocio getDto_sociodenegocio(){
    return dto_sociodenegocio;
  }
  public void setDto_sociodenegocio(  SocioDeNegocio param){
    this.dto_sociodenegocio=param;
  }
  public Maestro getDto_tipo_contacto(){
    return dto_tipo_contacto;
  }
  public void setDto_tipo_contacto(  Maestro param){
    this.dto_tipo_contacto=param;
  }
  public String getStrcod_area(){
    return strcod_area;
  }
  public void setStrcod_area(  String param){
    this.strcod_area=param;
  }
  public String getStrnro_telf(){
    return strnro_telf;
  }
  public void setStrnro_telf(  String param){
    this.strnro_telf=param;
  }
  public String getStrvalor_comunicacion(){
    return strvalor_comunicacion;
  }
  public void setStrvalor_comunicacion(  String param){
    this.strvalor_comunicacion=param;
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
  
  public long getLngseg_usuario_creacion() {
	return lngseg_usuario_creacion;
}
public void setLngseg_usuario_creacion(long lngsegUsuarioCreacion) {
	lngseg_usuario_creacion = lngsegUsuarioCreacion;
}
public long getLngseg_usuario_modificacion() {
	return lngseg_usuario_modificacion;
}
public void setLngseg_usuario_modificacion(long lngsegUsuarioModificacion) {
	lngseg_usuario_modificacion = lngsegUsuarioModificacion;
}
public String toString(){
	  String strcad="";
	  if (strcod_area.trim().length()>0) {
		  strcad+="(" + strcod_area + ")" + strnro_telf;		  
	  } else{
		  strcad+=strvalor_comunicacion;
	  }
    return dto_tipo_contacto + ": " + strcad;
  }
}

