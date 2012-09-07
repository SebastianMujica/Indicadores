package SocioDeNegocio;
import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Maestro.Maestro;

@Entity
@Table(name="tblsis_socionegocio")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
//@org.hibernate.annotations.BatchSize(size = 10)

public  class SocioDeNegocio extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_tipo_persona_sociodenegocio") 
  @JoinColumn(name="lngsis_tipo_persona",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dto_tipo_personalidad;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_tipo_documento_sociodenegocio") 
  @JoinColumn(name="lngsis_tipo_documento_persona",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dto_tipo_documento;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_clasificacion_sociodenegocio") 
  @JoinColumn(name="lngsis_clasificacion_persona",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dto_tipo_clasificacion;
  
  @NotNull(message="{campo_obligatorio}") @Size(min=7,max=20,message="{longitud_entre}") String strcedularif;
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=150,message="{longitud_entre}") String strnombre;
  @Size(min=0,max=50,message="{longitud_entre}") String strapellido;
  
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_genero_sociodenegocio") 
  @JoinColumn(name="lngsis_genero_persona",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dto_genero_persona;
  
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
  public Maestro getDto_tipo_personalidad(){
    return dto_tipo_personalidad;
  }
  public void setDto_tipo_personalidad(  Maestro param){
    this.dto_tipo_personalidad=param;
  }
  public Maestro getDto_tipo_documento(){
    return dto_tipo_documento;
  }
  public void setDto_tipo_documento(  Maestro param){
    this.dto_tipo_documento=param;
  }
  public Maestro getDto_tipo_clasificacion(){
    return dto_tipo_clasificacion;
  }
  public void setDto_tipo_clasificacion(  Maestro param){
    this.dto_tipo_clasificacion=param;
  }
  public String getStrcedularif(){
    return strcedularif;
  }
  public void setStrcedularif(  String param){
    this.strcedularif=param;
  }
  public String getStrnombre(){
    return strnombre;
  }
  public void setStrnombre(  String param){
    this.strnombre=param;
  }
  public String getStrapellido(){
    return strapellido;
  }
  public void setStrapellido(  String param){
    this.strapellido=param;
  }
  public Maestro getDto_genero_persona(){
    return dto_genero_persona;
  }
  public void setDto_genero_persona(  Maestro param){
    this.dto_genero_persona=param;
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
  public boolean isBolactivo() {
		return bolactivo;
	}
public boolean isBolborrado() {
		return bolborrado;
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
    return strnombre + " " + strapellido + " [" + strcedularif + "]";
  }
}
