package Variable;
import java.util.*;

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
import org.hibernate.annotations.Type;
@Entity
@Table(name="tblind_variable")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
//@org.hibernate.annotations.BatchSize(size = 10)
public  class Variable extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @NotNull(message="{campo_obligatorio}")
  @Index(name="idx_org_variable") 
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org;
  
  @Index(name="idx_codigo_variable")
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=20,message="{longitud_entre}") String strcodigo;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_categoria_indicador") 
  @JoinColumn(name="lngsis_categoria",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dtocategoria;
  
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=255,message="{longitud_entre}") String strnombre;
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=255,message="{longitud_entre}") String strdescripcion;
  @NotNull(message="{campo_obligatorio}") float flovalor_minimo;
  @NotNull(message="{campo_obligatorio}") float flovalor_maximo;
  
  @NotNull(message="{campo_obligatorio}")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @Index(name="idx_tipo_dato_variable") 
  @JoinColumn(name="lngsis_tipo_dato",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dtotipo_dato;
  
  @NotNull(message="{campo_obligatorio}") long lngnum_decimales;
  @NotNull(message="{campo_obligatorio}") @Size(min=3,max=255,message="{longitud_entre}") String strformato_presente;
  @NotNull(message="{campo_obligatorio}") long lngtamano;
  
  @NotNull(message="{campo_obligatorio}")
  @Index(name="idx_unidadmedida_variable") 
  @JoinColumn(name="lngsis_unidad_medida",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) UnidadDeMedida dtounidad_medida;
  
  String strbase_datos;
  String strusuario_bd;
  String strpuerto_bd;
  String strpwd_bd;
  String strtabla;
  String strcolumna;
  String strclase;
  @Type(type="org.hibernate.type.TextType")  String strformula;
  
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
  public String getStrtabla(){
    return strtabla;
  }
  public void setStrtabla(  String param){
    this.strtabla=param;
  }
  public String getStrcolumna(){
    return strcolumna;
  }
  public void setStrcolumna(  String param){
    this.strcolumna=param;
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
public String getStrclase() {
	return strclase;
}
public void setStrclase(String strclase) {
	this.strclase = strclase;
}
public String getStrformula() {
	return strformula;
}
public void setStrformula(String strformula) {
	this.strformula = strformula;
}

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
public Maestro getDtocategoria() {
	return dtocategoria;
}
public void setDtocategoria(Maestro dtoCategoria) {
	dtocategoria = dtoCategoria;
}
public String getStrdescripcion() {
	return strdescripcion;
}
public void setStrdescripcion(String strdescripcion) {
	this.strdescripcion = strdescripcion;
}
public float getFlovalor_minimo() {
	return flovalor_minimo;
}
public void setFlovalor_minimo(float flovalorMinimo) {
	flovalor_minimo = flovalorMinimo;
}
public float getFlovalor_maximo() {
	return flovalor_maximo;
}
public void setFlovalor_maximo(float flovalorMaximo) {
	flovalor_maximo = flovalorMaximo;
}
public long getLngnum_decimales() {
	return lngnum_decimales;
}
public void setLngnum_decimales(long lngnumDecimales) {
	lngnum_decimales = lngnumDecimales;
}
public String getStrformato_presente() {
	return strformato_presente;
}
public void setStrformato_presente(String strformatoPresente) {
	strformato_presente = strformatoPresente;
}
public long getLngtamano() {
	return lngtamano;
}
public void setLngtamano(long lngtamano) {
	this.lngtamano = lngtamano;
}
public UnidadDeMedida getDtounidad_medida() {
	return dtounidad_medida;
}
public void setDtounidad_medida(UnidadDeMedida dtounidadMedida) {
	dtounidad_medida = dtounidadMedida;
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
public Maestro getDtotipo_dato() {
	return dtotipo_dato;
}
public void setDtotipo_dato(Maestro dtotipoDato) {
	dtotipo_dato = dtotipoDato;
}
public String getStrbase_datos() {
	return strbase_datos;
}
public void setStrbase_datos(String strbaseDatos) {
	strbase_datos = strbaseDatos;
}
public String getStrusuario_bd() {
	return strusuario_bd;
}
public void setStrusuario_bd(String strusuarioBd) {
	strusuario_bd = strusuarioBd;
}
public String getStrpuerto_bd() {
	return strpuerto_bd;
}
public void setStrpuerto_bd(String strpuertoBd) {
	strpuerto_bd = strpuertoBd;
}
public String getStrpwd_bd() {
	return strpwd_bd;
}
public void setStrpwd_bd(String strpwdBd) {
	strpwd_bd = strpwdBd;
}
public String getCodeName(){
	return "txt" + this.dtotipo_dato.getStrsigla().trim().toLowerCase() + "var" + lngid;
}
public String toString(){
    return "["+strcodigo+"] " + strnombre;
  }
}

