package UnidadDeMedida;
import java.util.*;

import Maestro.Maestro;
import Organizacion.Organizacion;
import SwingBernate.*;
import Usuario.Usuario;

import javax.validation.constraints.*;
import javax.persistence.*;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="tblsis_unidadmedida")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
public  class UnidadDeMedida extends DtoBase {

	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@Index(name="idx_org_unidadmedida") 
	@JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE) Organizacion dtoorganizacion;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@Index(name="idx_tip_unidadmedida") 
	@JoinColumn(name="lngsis_tipo_unidad",insertable=true,updatable=true,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE) Maestro dtotipo_unidad;
	
	@Index(name="idx_codigo_unidadmedida") 
	@NotNull(message="{campo_obligatorio}") @Size(min=2,max=50,message="{longitud_entre}") String strcodigo;
	
	@NotNull(message="{campo_obligatorio}") @Size(min=2,max=100,message="{longitud_entre}") String strnombre;
	@NotNull(message="{campo_obligatorio}") @Size(min=2,max=10,message="{longitud_entre}") String strsimbolo;
	String strdescripcion;
	boolean bolpredeterminado;
	
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
	/*
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name="usuario_creacion_lngid",insertable=true,updatable=false,nullable=false) 
	@ManyToOne(fetch=FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE) Usuario dtousuario_creacion;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name="usuario_modificacion_lngid",insertable=true,updatable=true,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE) Usuario dtousuario_modificacion;*/
	
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
	public Maestro getDtotipo_unidad() {
		return dtotipo_unidad;
	}
	public void setDtotipo_unidad(Maestro dtotipoUnidad) {
		dtotipo_unidad = dtotipoUnidad;
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
	public String getStrsimbolo(){
		return strsimbolo;
	}
	public void setStrsimbolo(  String param){
		this.strsimbolo=param;
	}
	public String getStrdescripcion(){
		return strdescripcion;
	}
	public void setStrdescripcion(  String param){
		this.strdescripcion=param;
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
	public boolean isBolpredeterminado() {
		return bolpredeterminado;
	}
	public boolean getBolpredeterminado() {
		return bolpredeterminado;
	}
	public void setBolpredeterminado(boolean bolpredeterminado) {
		this.bolpredeterminado = bolpredeterminado;
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
	/*public Usuario getDtousuario_creacion() {
		return dtousuario_creacion;
	}
	public void setDtousuario_creacion(Usuario dtousuarioCreacion) {
		dtousuario_creacion = dtousuarioCreacion;
	}
	public Usuario getDtousuario_modificacion() {
		return dtousuario_modificacion;
	}
	public void setDtousuario_modificacion(Usuario dtousuarioModificacion) {
		dtousuario_modificacion = dtousuarioModificacion;
	}*/
	public String toString(){
		return strnombre + " [" + strsimbolo + "]" ;
	}
}

