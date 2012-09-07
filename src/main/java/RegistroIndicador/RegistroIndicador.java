package RegistroIndicador;
import java.util.*;

import Indicador.Indicador;
import Organizacion.Organizacion;
import Periodo.Periodo;
import RegistroVariable.RegistroVariable;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="tblind_registro_indicador")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@org.hibernate.annotations.BatchSize(size = 10)
public  class RegistroIndicador extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @Index(name="idx_org_registroindicador")
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Organizacion dtoorganizacion;
  
  @Index(name="idx_periodo_registroindicador")
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @JoinColumn(name="lngsis_periodo",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Periodo dtoperiodo;
  
  @Index(name="idx_indicador_registroindicador")
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @JoinColumn(name="lngind_indicador",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Indicador dtoindicador;
  
  @NotNull(message="{campo_obligatorio}") 
  @Size(min=1,max=30,message="{longitud_entre}") 
  String strvalor;
  
  @NotNull(message="{campo_obligatorio}") Date dtmfecha_valor;
  
  @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinTable(name="tblind_registro_variable_indicador",uniqueConstraints = {
		    @UniqueConstraint(columnNames={"lngind_registro_indicador","lngind_registro_variable"})},
		    joinColumns = @JoinColumn( name="lngind_registro_indicador"), 
		    inverseJoinColumns = @JoinColumn( name="lngind_registro_variable"))
  @LazyCollection(LazyCollectionOption.FALSE) List<RegistroVariable> dtoregistro_variable;
  
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
  public Organizacion getDtoorganizacion() {
	return dtoorganizacion;
}
public void setDtoorganizacion(Organizacion dtoorganizacion) {
	this.dtoorganizacion = dtoorganizacion;
}
public Periodo getDtoperiodo() {
	return dtoperiodo;
}
public void setDtoperiodo(Periodo dtoperiodo) {
	this.dtoperiodo = dtoperiodo;
}
public Date getDtmfecha_valor() {
	return dtmfecha_valor;
}
public void setDtmfecha_valor(Date dtmfechaValor) {
	dtmfecha_valor = dtmfechaValor;
}
public List<RegistroVariable> getDtoregistro_variable() {
	return dtoregistro_variable;
}
public void setDtoregistro_variable(List<RegistroVariable> dtoregistroVariable) {
	dtoregistro_variable = dtoregistroVariable;
}
public String getStrvalor(){
    return strvalor;
  }
  public void setStrvalor(  String param){
    this.strvalor=param;
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
    return lngid +" "+dtoindicador+" "+strvalor;
  }
public void setDtoindicador(Indicador lngindicador) {
	this.dtoindicador = lngindicador;
}
public Indicador getDtoindicador() {
	return dtoindicador;
}
public void addRegistroVariable(RegistroVariable registrovariable)
{
    this.dtoregistro_variable.add(registrovariable);
}
}

