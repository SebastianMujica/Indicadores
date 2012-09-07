package Tarea;
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
import Tarea.Tarea;
@Entity
@Table(name="tblseg_tarea")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@org.hibernate.annotations.BatchSize(size = 10)

public  class Tarea extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @NotNull(message="{campo_obligatorio}")
  @Index(name="idx_org_tarea") 
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org;
  
  @Index(name="idx_codigo_tarea") 
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=20,message="{longitud_entre}") String strcodigo;
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=30,message="{longitud_entre}") String strnombre;
  @Size(min=0,max=255,message="{longitud_entre}") String strdescripcion;
  
  @Index(name="idx_tarea_tarea") 
  @JoinColumn(name="lngseg_tarea",insertable=true,updatable=true,nullable=true) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Tarea dto_tarea_padre;
  
  @NotNull(message="{campo_obligatorio}") Short intnivel;
  @NotNull(message="{campo_obligatorio}") Short intpos_rel;
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=50,message="{longitud_entre}") String strtexto_ayuda;
  String strimg_activa;
  String strimg_desactiva;
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
  public Tarea getDto_tarea_padre(){
    return dto_tarea_padre;
  }
  public void setDto_tarea_padre(  Tarea param){
    this.dto_tarea_padre=param;
  }
  public Short getIntnivel(){
    return intnivel;
  }
  public void setIntnivel(  Short param){
    this.intnivel=param;
  }
  public Short getIntpos_rel(){
    return intpos_rel;
  }
  public void setIntpos_rel(  Short param){
    this.intpos_rel=param;
  }
  public String getStrtexto_ayuda(){
    return strtexto_ayuda;
  }
  public void setStrtexto_ayuda(  String param){
    this.strtexto_ayuda=param;
  }
  public String getStrimg_activa(){
    return strimg_activa;
  }
  public void setStrimg_activa(  String param){
    this.strimg_activa=param;
  }
  public String getStrimg_desactiva(){
    return strimg_desactiva;
  }
  public void setStrimg_desactiva(  String param){
    this.strimg_desactiva=param;
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
  public boolean isBolactivo() {
		return bolactivo;
	}
public boolean isBolborrado() {
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
	  return strnombre+ " (" + strcodigo + ")" ;
  }
}

