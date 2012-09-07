package DomicilioSocioDeNegocio;
import java.util.*;

import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import SocioDeNegocio.SocioDeNegocio;
import Maestro.Maestro;
import DomicilioSocioDeNegocio.DomicilioSocioDeNegocio;
import Pais.Pais;
import Estado.Estado;
import Municipio.Municipio;
import Parroquia.Parroquia;
@Entity
@Table(name="tblsis_domicilio_socionegocio")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@org.hibernate.annotations.BatchSize(size = 10)
public  class DomicilioSocioDeNegocio extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @Index(name="idx_sociodenegocio_domicilio") 
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @JoinColumn(name="lngsis_sociodenegocio",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) SocioDeNegocio dto_sociodenegocio;
  
  @Index(name="idx_tipodireccion_domicilio") 
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @JoinColumn(name="lngsis_tipo_direccion",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Maestro dto_tipo_direccion;
  
  @NotNull() @Size(min=6,max=50,message="{longitud}") String strav_calle_sector;
  @NotNull() @Size(min=2,max=20,message="{longitud}") String stredif_casa;
  @Size(min=1,max=10,message="{longitud}") String strpiso;
  @Size(min=1,max=20,message="{longitud}") String strapto_ofic_nro;
  @NotNull() @Size(min=3,max=30,message="{longitud}") String strciudad;
  
  
  //@Fetch(FetchMode.SELECT)
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_pais_domicilio") 
     @JoinColumn(name="lngsis_pais",insertable=true,updatable=true,nullable=false) 
     @ManyToOne(fetch=FetchType.EAGER) 
     @LazyCollection(LazyCollectionOption.FALSE) Pais dto_pais;
  
  //@Fetch(FetchMode.SELECT)
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_estado_domicilio") 
     @JoinColumn(name="lngsis_estado",insertable=true,updatable=true,nullable=false) 
     @ManyToOne(fetch=FetchType.EAGER) 
     @LazyCollection(LazyCollectionOption.FALSE) Estado dto_estado;
  
  //@Fetch(FetchMode.SELECT)
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_municipio_domicilio") 
  @JoinColumn(name="lngsis_municipio",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Municipio dto_municipio;
  
  //@Fetch(FetchMode.SELECT)
  @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  @Index(name="idx_parroquia_domicilio") 
     @JoinColumn(name="lngsis_parroquia",insertable=true,updatable=true,nullable=false) 
     @ManyToOne(fetch=FetchType.EAGER) 
     @LazyCollection(LazyCollectionOption.FALSE) Parroquia dto_parroquia;
  
  @Size(min=3,max=8,message="{longitud}") String strapartado_postal;
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
  public SocioDeNegocio getDto_sociodenegocio(){
    return dto_sociodenegocio;
  }
  public void setDto_sociodenegocio(  SocioDeNegocio param){
    this.dto_sociodenegocio=param;
  }
  public Maestro getDto_tipo_direccion(){
    return dto_tipo_direccion;
  }
  public void setDto_tipo_direccion(  Maestro param){
    this.dto_tipo_direccion=param;
  }
  public String getStrav_calle_sector(){
    return strav_calle_sector;
  }
  public void setStrav_calle_sector(  String param){
    this.strav_calle_sector=param;
  }
  public String getStredif_casa(){
    return stredif_casa;
  }
  public void setStredif_casa(  String param){
    this.stredif_casa=param;
  }
  public String getStrpiso(){
    return strpiso;
  }
  public void setStrpiso(  String param){
    this.strpiso=param;
  }
  public String getStrapto_ofic_nro(){
    return strapto_ofic_nro;
  }
  public void setStrapto_ofic_nro(  String param){
    this.strapto_ofic_nro=param;
  }
  public String getStrciudad(){
    return strciudad;
  }
  public void setStrciudad(  String param){
    this.strciudad=param;
  }
  public Pais getDto_pais(){
    return dto_pais;
  }
  public void setDto_pais(  Pais param){
    this.dto_pais=param;
  }
  public Estado getDto_estado(){
    return dto_estado;
  }
  public void setDto_estado(  Estado param){
    this.dto_estado=param;
  }
  public Municipio getDto_municipio(){
    return dto_municipio;
  }
  public void setDto_municipio(  Municipio param){
    this.dto_municipio=param;
  }
  public Parroquia getDto_parroquia(){
    return dto_parroquia;
  }
  public void setDto_parroquia(  Parroquia param){
    this.dto_parroquia=param;
  }
  public String getStrapartado_postal(){
    return strapartado_postal;
  }
  public void setStrapartado_postal(  String param){
    this.strapartado_postal=param;
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
    return dto_tipo_direccion + ": " + strav_calle_sector + ", " + stredif_casa + ". " + strciudad + " Edo. " + dto_estado + ".";
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
		DomicilioSocioDeNegocio other = (DomicilioSocioDeNegocio) obj;
		if (lngid != other.lngid) {
			return false;
		}
		return true;
	}
}

