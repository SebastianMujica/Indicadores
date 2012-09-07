package Zona;

import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//import moduloPrototipo.dto.dtoSubZona;

import Estado.Estado;
import Municipio.Municipio;
import Organizacion.Organizacion;
import Pais.Pais;
import Parroquia.Parroquia;
import SubZona.SubZona;
import SwingBernate.DtoBase;

@Entity
@Table(name="tblsis_zona")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@org.hibernate.annotations.BatchSize(size = 10)
public class Zona extends DtoBase {
	
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@Index(name="idx_org_zona") 
	@JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
	@ManyToOne(fetch=FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org;
	
	@NotNull(message="{campo_obligatorio}") @Size(min=3,max=30,message="{longitud_entre}") String strcodigo;
	@NotNull(message="{campo_obligatorio}") @Size(min=3,max=30,message="{longitud_entre}") String strnombre;
	
	@NotNull(message="{campo_obligatorio}")
	@Index(name="idx_pais_zona")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name="pais_lngid",insertable=true,updatable=false,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Pais dtopais;
	
	@NotNull(message="{campo_obligatorio}")
	@Index(name="idx_estado_zona")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name="estado_lngid",insertable=true,updatable=false,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Estado dtoestado;
	
	@NotNull(message="{campo_obligatorio}")
	@Index(name="idx_municipio_zona")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name="municipio_lngid",insertable=true,updatable=false,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Municipio dtomunicipio;
	
	@Index(name="idx_parroquia_zona")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name="parroquia_lngid",insertable=true,updatable=false,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Parroquia dtoparroquia;
	
	@JoinColumn(name="zona_lngid") 
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
	@LazyCollection(LazyCollectionOption.FALSE)List<SubZona> subzonas;
	
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
	
	
	public Zona(){}
	
	public long getLngid() {
		return lngid;
	}

	public void setLngid(long lngid) {
		this.lngid = lngid;
	}

	public String getStrnombre() {
		return strnombre;
	}

	public void setStrnombre(String strnombre) {
		this.strnombre = strnombre;
	}

	public Pais getDtopais() {
		return dtopais;
	}

	public void setDtopais(Pais dtopais) {
		this.dtopais = dtopais;
	}

	public Estado getDtoestado() {
		return dtoestado;
	}

	public void setDtoestado(Estado dtoestado) {
		this.dtoestado = dtoestado;
	}

	public Municipio getDtomunicipio() {
		return dtomunicipio;
	}

	public void setDtomunicipio(Municipio dtomunicipio) {
		this.dtomunicipio = dtomunicipio;
	}

	public Parroquia getDtoparroquia() {
		return dtoparroquia;
	}

	public void setDtoparroquia(Parroquia dtoparroquia) {
		this.dtoparroquia = dtoparroquia;
	}

	public List<SubZona> getSubzonas() {
		return subzonas;
	}

	public void setSubzonas(List<SubZona> subzonas) {
		this.subzonas = subzonas;
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

	public boolean isBolborrado() {
		return bolborrado;
	}

	public void setBolborrado(boolean bolborrado) {
		this.bolborrado = bolborrado;
	}

	public Date getDtmfecha_creacion() {
		return dtmfecha_creacion;
	}

	public void setDtmfecha_creacion(Date dtmfechaCreacion) {
		dtmfecha_creacion = dtmfechaCreacion;
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

	public String getStrip_creacion() {
		return strip_creacion;
	}

	public void setStrip_creacion(String stripCreacion) {
		strip_creacion = stripCreacion;
	}

	public String getStrhost_creacion() {
		return strhost_creacion;
	}

	public void setStrhost_creacion(String strhostCreacion) {
		strhost_creacion = strhostCreacion;
	}

	public String getStrip_modificacion() {
		return strip_modificacion;
	}

	public void setStrip_modificacion(String stripModificacion) {
		strip_modificacion = stripModificacion;
	}

	public String getStrhost_modificacion() {
		return strhost_modificacion;
	}

	public void setStrhost_modificacion(String strhostModificacion) {
		strhost_modificacion = strhostModificacion;
	}

	public Date getDtmfecha_modificacion() {
		return dtmfecha_modificacion;
	}

	public void setDtmfecha_modificacion(Date dtmfechaModificacion) {
		dtmfecha_modificacion = dtmfechaModificacion;
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

	@Override
	/*	public String toString() {
			return "dtoZona [SubZonas=" + SubZonas + ", estado=" + estado + ", id="
					+ id + ", municipio=" + municipio + ", nombre=" + nombre
					+ ", parroquia=" + parroquia + "]";
		}*/
		public String toString() {
			return  strnombre;
		}
}
