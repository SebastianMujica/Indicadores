package Empleado_Org;
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
import Organizacion.Organizacion;
import SocioDeNegocio.SocioDeNegocio;

@Entity
@Table(name="tblsis_empleado_org")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
//@org.hibernate.annotations.BatchSize(size = 10)
public  class Empleado_Org extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_empleado_org_cargo_org") 
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_socionegocio_cargo_org") 
  @JoinColumn(name="lngsis_socionegocio",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) SocioDeNegocio dto_socionegocio;
  
  
  @NotNull(message="{campo_obligatorio}") 
  @javax.validation.constraints.Past(message="{fecha_pasada}")
  Date dtmingreso_org;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_nivel_estudio_empleado_org") 
  @JoinColumn(name="lngsis_nivel_estudio",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dtonivel_estudio;
  
  @NotNull(message="{campo_obligatorio}") @Size(min=5,max=50,message="{longitud}") String strprofesion;
  
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
  public Organizacion getDto_org(){
    return dto_org;
  }
  public void setDto_org(  Organizacion param){
    this.dto_org=param;
  }
  public SocioDeNegocio getDto_socionegocio(){
    return dto_socionegocio;
  }
  public void setDto_socionegocio(  SocioDeNegocio param){
    this.dto_socionegocio=param;
  }
  public Date getDtmingreso_org(){
    return dtmingreso_org;
  }
  public void setDtmingreso_org(  Date param){
    this.dtmingreso_org=param;
  }
  public Maestro getDtonivel_estudio(){
    return dtonivel_estudio;
  }
  public void setDtonivel_estudio(  Maestro param){
    this.dtonivel_estudio=param;
  }
  public String getStrprofesion(){
    return strprofesion;
  }
  public void setStrprofesion(  String param){
    this.strprofesion=param;
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
	  return dto_socionegocio.toString();
  }
}

