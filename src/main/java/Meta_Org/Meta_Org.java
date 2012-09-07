package Meta_Org;
import java.util.*;

import SwingBernate.*;
import Usuario.Usuario;

import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Indicador.Indicador;
import Organizacion.Organizacion;
import Periodo.Periodo;
@Entity
@Table(name="tblind_meta_org")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)

public  class Meta_Org extends DtoBase {
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	
	@NotNull(message="{campo_obligatorio}")
	@Index(name="idx_org_meta_org")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Organizacion dtoorganizacion;
	
	@NotNull(message="{campo_obligatorio}")
	@Index(name="idx_indicador_meta_org")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name="lngind_indicador",insertable=true,updatable=true,nullable=false) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Indicador dtoindicador;
	
	@NotNull(message="{campo_obligatorio}") float flovalor;
	
	@NotNull(message="{campo_obligatorio}")
	@Index(name="idx_periodo_meta_org")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Periodo dtoperiodo;
	
	Date dtmfecha_creacion;
	  Date dtmfecha_modificacion;
	  @NotNull(message="{campo_obligatorio}") Date dtmvalido_desde;
	  @NotNull(message="{campo_obligatorio}") Date dtmvalido_hasta;
	  boolean bolactivo;
	  boolean bolborrado;
	  String strip_creacion;
	  String strip_modificacion;
	  String strhost_creacion;
	  String strhost_modificacion;
	  long lngseg_usuario_creacion;
	  long lngseg_usuario_modificacion;
	
	public long getLngid() {
		return lngid;
	}
	public void setLngid(long lngid) {
		this.lngid = lngid;
	}
	public Organizacion getDtoorganizacion() {
		return dtoorganizacion;
	}
	public void setDtoorganizacion(Organizacion dtoorganizacion) {
		this.dtoorganizacion = dtoorganizacion;
	}
	public Indicador getDtoindicador() {
		return dtoindicador;
	}
	public void setDtoindicador(Indicador dtoindicador) {
		this.dtoindicador = dtoindicador;
	}
	public float getFlovalor() {
		return flovalor;
	}
	public void setFlovalor(float flovalor) {
		this.flovalor = flovalor;
	}
	public Periodo getDtoperiodo() {
		return dtoperiodo;
	}
	public void setDtoperiodo(Periodo dtoperiodo) {
		this.dtoperiodo = dtoperiodo;
	}
	public Date getDtmfecha_creacion() {
		return dtmfecha_creacion;
	}
	public void setDtmfecha_creacion(Date dtmfechaCreacion) {
		dtmfecha_creacion = dtmfechaCreacion;
	}
	public Date getDtmfecha_modificacion() {
		return dtmfecha_modificacion;
	}
	public void setDtmfecha_modificacion(Date dtmfechaModificacion) {
		dtmfecha_modificacion = dtmfechaModificacion;
	}
	public Date getDtmvalido_desde() {
		return dtmvalido_desde;
	}
	public void setDtmvalido_desde(Date dtmvalidoDesde) {
		dtmvalido_desde = dtmvalidoDesde;
	}
	public Date getDtmvalido_hasta() {
		return dtmvalido_hasta;
	}
	public void setDtmvalido_hasta(Date dtmvalidoHasta) {
		dtmvalido_hasta = dtmvalidoHasta;
	}
	public boolean isBolactivo() {
		return bolactivo;
	}
	public boolean getBolactivo() {
		return bolactivo;
	}
	public void setBolactivo(boolean bolactivo) {
		this.bolactivo = bolactivo;
	}
	public boolean getBolborrado() {
		return bolborrado;
	}
	public boolean isBolborrado() {
		return bolborrado;
	}
	public void setBolborrado(boolean bolborrado) {
		this.bolborrado = bolborrado;
	}
	public String getStrip_creacion() {
		return strip_creacion;
	}
	public void setStrip_creacion(String stripCreacion) {
		strip_creacion = stripCreacion;
	}
	public String getStrip_modificacion() {
		return strip_modificacion;
	}
	public void setStrip_modificacion(String stripModificacion) {
		strip_modificacion = stripModificacion;
	}
	public String getStrhost_creacion() {
		return strhost_creacion;
	}
	public void setStrhost_creacion(String strhostCreacion) {
		strhost_creacion = strhostCreacion;
	}
	public String getStrhost_modificacion() {
		return strhost_modificacion;
	}
	public void setStrhost_modificacion(String strhostModificacion) {
		strhost_modificacion = strhostModificacion;
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
		return dtoindicador+" "+flovalor+" "+dtoorganizacion+" ("+lngid+")";
	}
}

