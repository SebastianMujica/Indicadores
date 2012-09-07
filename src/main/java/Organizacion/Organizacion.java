package Organizacion;
import java.util.*;

import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Menu.Menu;
import Organizacion.Organizacion;
import Organizacion.Organizacion;
//import TipoOrganizacion.TipoOrganizacion;
import SocioDeNegocio.SocioDeNegocio;

@Entity
@Table(name="tblsis_org")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
//@org.hibernate.annotations.BatchSize(size = 10)
public  class Organizacion extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @Index(name="idx_codigo_org")
  @NotNull() @Size(min=3,max=20,message="{longitud_entre}") String strcodigo;
  
  @Index(name="idx_org_superior_org")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @JoinColumn(name="lngsis_org_superior",insertable=true,updatable=true,nullable=true) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org_superior;
  
  //@JoinColumn(name="lngsis_tipo_org",insertable=true,updatable=true,nullable=false) @ManyToOne() TipoOrganizacion dto_tipo_org;
  
  @Index(name="idx_sociodenegocio_org")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @JoinColumn(name="lngsis_sociodenegocio",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) SocioDeNegocio dto_socio_negocio;
  
  @NotNull(message="{campo_requerido}") @Size(min=3,max=15,message="{longitud_entre}") String strsiglas;
  @NotNull(message="{campo_requerido}") @Size(min=5,max=50,message="{longitud_entre}") String strnombre;
  @NotNull(message="{campo_requerido}") long lngnivel;
  @NotNull(message="{campo_requerido}") long lngpos_rel;
  @NotNull(message="{campo_requerido}") @Size(min=7,max=7,message="{longitud_entre}") String strcolor_id;
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
  public String getStrcodigo(){
    return strcodigo;
  }
  public void setStrcodigo(  String param){
    this.strcodigo=param;
  }
  public Organizacion getDto_org_superior(){
    return dto_org_superior;
  }
  public void setDto_org_superior(  Organizacion param){
    this.dto_org_superior=param;
  }
//  public TipoOrganizacion getDto_tipo_org(){
//    return dto_tipo_org;
//  }
//  public void setDto_tipo_org(  TipoOrganizacion param){
//    this.dto_tipo_org=param;
//  }
  public SocioDeNegocio getDto_socio_negocio(){
    return dto_socio_negocio;
  }
  public void setDto_socio_negocio(  SocioDeNegocio param){
    this.dto_socio_negocio=param;
  }
  public String getStrsiglas(){
    return strsiglas;
  }
  public void setStrsiglas(  String param){
    this.strsiglas=param;
  }
  public String getStrnombre(){
    return strnombre;
  }
  public void setStrnombre(  String param){
    this.strnombre=param;
  }
  public Long getLngnivel(){
	  return lngnivel;
  }
  public void setLngnivel(  long param){
    this.lngnivel=param;
  }
  public Long getLngpos_rel(){
    return lngpos_rel;
  }
  
  public void setLngpos_rel(  long param){
    this.lngpos_rel=param;
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
    return strnombre + " (" + strsiglas + ")" ;
  }
}

