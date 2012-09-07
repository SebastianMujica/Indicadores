package Maestro;

import java.util.*;

import SwingBernate.*;
import Usuario.Usuario;

import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name="tblsis_maestro", uniqueConstraints = {
	    @UniqueConstraint(columnNames={"strcodigo", "bolborrado"})}
	    )
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@org.hibernate.annotations.BatchSize(size = 10)

public  class Maestro extends DtoBase {
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	
	@Index(name="idx_maestro_maestro")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name="maestro_lngid",insertable=true,updatable=true,nullable=true) 
	@ManyToOne(fetch=FetchType.LAZY) 
	@LazyCollection(LazyCollectionOption.FALSE) Maestro dtomaestro;
	//@JoinColumn(name="organizacion_lngid",insertable=true,updatable=true,nullable=true) @ManyToOne() Organizacion dtoorganizacion;
	
	@Index(name="idx_codigo_maestro") 
	@NotNull() @Size(min=3,max=50,message="{longitud_entre}") String strcodigo;
	
	@NotNull() @Size(min=3,max=20,message="{longitud_entre}") String strsigla;
	@NotNull() @Size(min=3,max=150,message="{longitud_entre}") String strnombre;
	String strdescripcion;
	Short intnivel;
	Short intpos_rel;
	boolean bolpredeterminado;
	//@OneToMany(mappedBy="dtomaestro",cascade=CascadeType.ALL,fetch=FetchType.EAGER) List<Maestro> dtohijos;
	
	@JoinColumn(name="maestro_lngid")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE) List<Maestro> dtohijos;
	
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
	
	public long getLngid() {
		return lngid;
	}
	public void setLngid(long lngid) {
		this.lngid = lngid;
	}
	public Maestro getDtomaestro() {
		return dtomaestro;
	}
	public void setDtomaestro(Maestro dtomaestro) {
		this.dtomaestro = dtomaestro;
	}
	public String getStrcodigo() {
		return strcodigo;
	}
	public void setStrcodigo(String strcodigo) {
		this.strcodigo = strcodigo;
	}
	public String getStrsigla() {
		return strsigla;
	}
	public void setStrsigla(String strsigla) {
		this.strsigla = strsigla;
	}
	public String getStrnombre() {
		return strnombre;
	}
	public void setStrnombre(String strnombre) {
		this.strnombre = strnombre;
	}
	public String getStrdescripcion() {
		return strdescripcion;
	}
	public void setStrdescripcion(String strdescripcion) {
		this.strdescripcion = strdescripcion;
	}
	public Short getIntnivel() {
		return intnivel;
	}
	public void setIntnivel(Short intnivel) {
		this.intnivel = intnivel;
	}
	public Short getIntpos_rel() {
		return intpos_rel;
	}
	public void setIntpos_rel(Short intposRel) {
		intpos_rel = intposRel;
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
	public List<Maestro> getDtohijos() {
		return dtohijos;
	}
	public void setDtohijos(List<Maestro> dtohijos) {
		this.dtohijos = dtohijos;
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
	public boolean getBolborrado() {
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
		//return lngid+" "+strnombre+" "+strsigla;
		return strnombre + " (" + strsigla + ")" ;
	}
}

