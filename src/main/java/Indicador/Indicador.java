package Indicador;
import java.util.*;

import Maestro.Maestro;
import Meta_Org.Meta_Org;
import Organizacion.Organizacion;
import SwingBernate.*;
import Tarea.Tarea;
import UnidadDeMedida.UnidadDeMedida;
import Variable.Variable;
import VariableIndicador.VariableIndicador;

import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="tblind_indicador")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@org.hibernate.annotations.BatchSize(size = 10)

public  class Indicador extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  //@NotNull() long lngorg;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_org_indicador") 
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org;
  
  @NotNull(message="{campo_obligatorio}")
  @Index(name="idx_codigo_indicador")
 @Size(min=3,max=20,message="{longitud_entre}") String strcodigo;
  
  @Size(min=3,max=50,message="{longitud_entre}") String strnombre;
  @Size(min=3,max=255,message="{longitud_entre}") String strproposito;
  @Size(min=3,max=255,message="{longitud_entre}") String strcalculo;
  @Size(min=3,max=255,message="{longitud_entre}") String strcaracterista;
  
  //@NotNull() long lngfrecuencia_carga;
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_frecuencia_indicador") 
  @JoinColumn(name="lngsis_frecuencia_carga",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dto_frecuencia_carga;
  
  
  @Size(min=3,max=255,message="{longitud_entre}") String strformula;
  float flovalor_minimo;
  float flovalor_maximo;
  //@NotNull() long lngunidad_medida;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_unidadmedida_indicador") 
  @JoinColumn(name="lngsis_unidad_medida",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) UnidadDeMedida dto_unidadmedida;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_categoria_indicador") 
  @JoinColumn(name="lngsis_categoria",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dtocategoria;
  
  @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinTable(name="tblind_variable_indicador",uniqueConstraints = {
		    @UniqueConstraint(columnNames={"lngind_indicador","lngind_variable"})},
		    joinColumns = @JoinColumn( name="lngind_indicador"), 
		    inverseJoinColumns = @JoinColumn( name="lngind_variable"))
  @LazyCollection(LazyCollectionOption.FALSE) List<Variable> dtovariable;
  
  //@NotNull(message="{campo_obligatorio}")
 /* @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_metaorg_indicador") 
  @JoinColumn(name="lngind_meta_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Meta_Org dto_meta_org;
*/
  
  
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
  public Organizacion getDto_org() {
	return dto_org;
  }
  public void setDto_org(Organizacion dtoOrg) {
	dto_org = dtoOrg;
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
  public String getStrproposito(){
    return strproposito;
  }
  public void setStrproposito(  String param){
    this.strproposito=param;
  }
  public String getStrcalculo(){
    return strcalculo;
  }
  public void setStrcalculo(  String param){
    this.strcalculo=param;
  }
  public String getStrcaracterista(){
    return strcaracterista;
  }
  public void setStrcaracterista(  String param){
    this.strcaracterista=param;
  }
  public Maestro getDto_frecuencia_carga() {
	return dto_frecuencia_carga;
}
public void setDto_frecuencia_carga(Maestro dtoFrecuenciaCarga) {
	dto_frecuencia_carga = dtoFrecuenciaCarga;
}
public String getStrformula(){
    return strformula;
  }
  public void setStrformula(  String param){
    this.strformula=param;
  }
  public float getFlovalor_minimo(){
    return flovalor_minimo;
  }
  public void setFlovalor_minimo(  float param){
    this.flovalor_minimo=param;
  }
  public float getFlovalor_maximo(){
    return flovalor_maximo;
  }
  public void setFlovalor_maximo(  float param){
    this.flovalor_maximo=param;
  }
  public UnidadDeMedida getDto_unidadmedida() {
	return dto_unidadmedida;
}
public void setDto_unidadmedida(UnidadDeMedida dtoUnidadmedida) {
	dto_unidadmedida = dtoUnidadmedida;
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
  
/*public Meta_Org getDto_meta_org() {
	return dto_meta_org;
}
public void setDto_meta_org(Meta_Org dtoMetaOrg) {
	dto_meta_org = dtoMetaOrg;
}*/
public String toString(){
    return "[" + strcodigo + "] " + strnombre;
  }
public Maestro getDtocategoria() {
	return dtocategoria;
}
public void setDtocategoria(Maestro dtoCategoria) {
	dtocategoria = dtoCategoria;
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
/*public List<VariableIndicador> getDtovariableindicador() {
	return dtovariableindicador;
}
public void setDtovariableindicador(List<VariableIndicador> dtovariableindicador) {
	this.dtovariableindicador = dtovariableindicador;
}*/
public List<Variable> getDtovariable() {
	return dtovariable;
}
public void setDtovariable(List<Variable> dtovariable) {
	this.dtovariable = dtovariable;
}
public void addVariable(Variable variable)
{
    this.dtovariable.add(variable);
}
}
