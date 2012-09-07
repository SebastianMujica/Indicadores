package VariableIndicador;
import java.util.*;

import Indicador.Indicador;
import Maestro.Maestro;
import Organizacion.Organizacion;
import SwingBernate.*;
import UnidadDeMedida.UnidadDeMedida;

import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="tblind_variable_indicador")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
//@org.hibernate.annotations.BatchSize(size = 10)

public  class VariableIndicador extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @NotNull(message="{campo_obligatorio}")
  @Index(name="idx_org_variableindicador") 
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org;
  
  @Index(name="idx_codigo_variableindicador")
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=20,message="{longitud_entre}") String strcodigo;
  
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=50,message="{longitud_entre}") String strnombre;
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=255,message="{longitud_entre}") String strdescripcion;
  @NotNull(message="{campo_obligatorio}") float flovalor_minimo;
  @NotNull(message="{campo_obligatorio}") float flovalor_maximo;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_categoria_indicador") 
  @JoinColumn(name="lngsis_categoria",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dto_categoria;
  
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=20,message="{longitud_entre}") String strtipo_dato;
  @NotNull(message="{campo_obligatorio}") long lngnum_decimales;
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=255,message="{longitud_entre}") String strformato_presente;
  @NotNull(message="{campo_obligatorio}") long lngtamano;
  
  @NotNull(message="{campo_obligatorio}")
  @Index(name="idx_unidadmedida_variableindicador") 
  @JoinColumn(name="lngsis_unidad_medida",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) UnidadDeMedida dto_unidad_medida;
  
  //@NotNull(message="{campo_obligatorio}")
  @Index(name="idx_indicador_variableindicador") 
  @JoinColumn(name="indicador_lngid",insertable=true,updatable=true,nullable=true) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Indicador dtoindicador;
  
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
  public float getFlovalor_minimo(){
    return flovalor_minimo;
  }
  public void setFlovalor_minimo(  float param){
    this.flovalor_minimo=param;
  }
  public String getStrtipo_dato(){
    return strtipo_dato;
  }
  public void setStrtipo_dato(  String param){
    this.strtipo_dato=param;
  }
  public long getLngnum_decimales(){
    return lngnum_decimales;
  }
  public void setLngnum_decimales(  long param){
    this.lngnum_decimales=param;
  }
  public String getStrformato_presente(){
    return strformato_presente;
  }
  public void setStrformato_presente(  String param){
    this.strformato_presente=param;
  }
  public long getLngtamano(){
    return lngtamano;
  }
  public void setLngtamano(  long param){
    this.lngtamano=param;
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
  public String toString(){
    return "[" + strcodigo + "] " + strnombre;
  }
/*public Indicador getDtoindicador() {
	return dtoindicador;
}
public void setDtoindicador(Indicador dtoindicador) {
	this.dtoindicador = dtoindicador;
}*/
public Organizacion getDto_org() {
	return dto_org;
}
public void setDto_org(Organizacion dtoOrg) {
	dto_org = dtoOrg;
}
public String getStrcodigo() {
	return strcodigo;
}
public void setStrcodigo(String strcodigo) {
	this.strcodigo = strcodigo;
}
public float getFlovalor_maximo() {
	return flovalor_maximo;
}
public void setFlovalor_maximo(float flovalorMaximo) {
	flovalor_maximo = flovalorMaximo;
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
public UnidadDeMedida getDto_unidad_medida() {
	return dto_unidad_medida;
}
public void setDto_unidad_medida(UnidadDeMedida dtoUnidadMedida) {
	dto_unidad_medida = dtoUnidadMedida;
}
public Maestro getDto_categoria() {
	return dto_categoria;
}
public void setDto_categoria(Maestro dtoCategoria) {
	dto_categoria = dtoCategoria;
}
public Indicador getDtoindicador() {
	return dtoindicador;
}
public void setDtoindicador(Indicador dtoindicador) {
	this.dtoindicador = dtoindicador;
}

}

