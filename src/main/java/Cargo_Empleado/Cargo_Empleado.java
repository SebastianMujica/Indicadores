package Cargo_Empleado;
import java.util.*;

import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Organizacion.Organizacion;
import Empleado_Org.Empleado_Org;
import Unidad_Org.Unidad_Org;
import Cargo_Org.Cargo_Org;
@Entity
@Table(name="tblsis_cargo_empleado")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
//@org.hibernate.annotations.BatchSize(size = 10)
public  class Cargo_Empleado extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@Index(name="idx_org_cargo_empleado") 
	@JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org;
  
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_empleado_cargo_empleado") 
  @JoinColumn(name="lngsis_empleado",insertable=true,updatable=true,nullable=false)
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Empleado_Org dto_empleado;
  
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_unidad_org_cargo_empleado") 
  @JoinColumn(name="lngsis_unidad_org",insertable=true,updatable=true,nullable=false)
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Unidad_Org dto_unidad_org;
  
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_cargo_org_cargo_empleado") 
  @JoinColumn(name="lngsis_cargo_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Cargo_Org dto_cargo_org;
  
  @NotNull() Date dtmfecha_desde;
  Date dtmfecha_hasta;
  
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
  public Empleado_Org getDto_empleado(){
    return dto_empleado;
  }
  public void setDto_empleado(  Empleado_Org param){
    this.dto_empleado=param;
  }
  public Unidad_Org getDto_unidad_org(){
    return dto_unidad_org;
  }
  public void setDto_unidad_org(  Unidad_Org param){
    this.dto_unidad_org=param;
  }
  public Cargo_Org getDto_cargo_org(){
    return dto_cargo_org;
  }
  public void setDto_cargo_org(  Cargo_Org param){
    this.dto_cargo_org=param;
  }
  public Date getDtmfecha_desde(){
    return dtmfecha_desde;
  }
  public void setDtmfecha_desde(  Date param){
    this.dtmfecha_desde=param;
  }
  public Date getDtmfecha_hasta(){
    return dtmfecha_hasta;
  }
  public void setDtmfecha_hasta(  Date param){
    this.dtmfecha_hasta=param;
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
    return lngid+ " "+ dto_empleado+" ("+dto_cargo_org+")";
  }
}

