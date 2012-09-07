package Municipio;
import java.util.*;

import Parroquia.Parroquia;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Estado.Estado;
import Estado.Estado;
@Entity
@Table(name="tblsis_municipio")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@org.hibernate.annotations.BatchSize(size = 10)
public  class Municipio extends DtoBase {
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	
	@NotNull(message="{campo_obligatorio}")
	@Index(name="idx_estado_municipio")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name="estado_lngid",insertable=true,updatable=false,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Estado dtoestado;
	
	@NotNull(message="{campo_obligatorio}") @Size(min=3,max=40,message="{longitud}") String strnombre;
	@NotNull(message="{campo_obligatorio}") @Size(min=3,max=10,message="{longitud}") String strsigla;
	
	@NotNull(message="{campo_obligatorio}")
	@JoinColumn(name="municipio_lngid") 
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
	@LazyCollection(LazyCollectionOption.FALSE) List<Parroquia> parroquias;
	
	@NotNull(message="{campo_obligatorio}") @Size(min=3,max=40,message="{longitud}") String strcapital;
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
	public Estado getDtoestado(){
		return dtoestado;
	}
	public void setDtoestado(  Estado param){
		this.dtoestado=param;
	}
	public String getStrnombre(){
		return strnombre;
	}
	public void setStrnombre(  String param){
		this.strnombre=param;
	}
	public String getStrsigla(){
		return strsigla;
	}
	public void setStrsigla(  String param){
		this.strsigla=param;
	}
	public List<Parroquia> getParroquias(){
		return parroquias;
	}
	public void setParroquias(  List<Parroquia> param){
		this.parroquias=param;
	}
	public String getStrcapital() {
		return strcapital;
	}
	public void setStrcapital(String strcapital) {
		this.strcapital = strcapital;
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
		return strnombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (lngid ^ (lngid >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().getCanonicalName()=="SwingBernate.dtoVacio"){
			return false;
		}
		Municipio other = (Municipio) obj;
		if (lngid != other.lngid) {
			return false;
		}
		return true;
	}

}

