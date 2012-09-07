package AtributoCentral;
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
import org.hibernate.annotations.Type;

import Organizacion.Organizacion;
@Entity
@Table(name="tblsis_atributo_central")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
//@org.hibernate.annotations.BatchSize(size = 10)

public  class AtributoCentral extends DtoBase {
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	
	@NotNull(message="{campo_obligatorio}")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@Index(name="idx_org_atributocentral") 
	@JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Organizacion dtoorganizacion;
	
	@NotNull float flocap_instalada;
	@NotNull float flocap_operativa;
	@NotNull float flocap_alm_crudo_azucar;
	@NotNull float flocap_alm_melaza;
	@Type(type="org.hibernate.type.TextType")  String strtecnologia;
	@NotNull Date dtmfecha_inicio_oper;
	Date dtmfecha_interv_nac;

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
	public Organizacion getDtoorganizacion() {
		return dtoorganizacion;
	}
	public void setDtoorganizacion(Organizacion dtoorganizacion) {
		this.dtoorganizacion = dtoorganizacion;
	}
	public float getFlocap_instalada() {
		return flocap_instalada;
	}
	public void setFlocap_instalada(float flocapInstalada) {
		flocap_instalada = flocapInstalada;
	}
	public float getFlocap_operativa() {
		return flocap_operativa;
	}
	public void setFlocap_operativa(float flocapOperativa) {
		flocap_operativa = flocapOperativa;
	}
	public float getFlocap_alm_crudo_azucar() {
		return flocap_alm_crudo_azucar;
	}
	public void setFlocap_alm_crudo_azucar(float flocapAlmCrudoAzucar) {
		flocap_alm_crudo_azucar = flocapAlmCrudoAzucar;
	}
	public float getFlocap_alm_melaza() {
		return flocap_alm_melaza;
	}
	public void setFlocap_alm_melaza(float flocapAlmMelaza) {
		flocap_alm_melaza = flocapAlmMelaza;
	}
	public String getStrtecnologia() {
		return strtecnologia;
	}
	public void setStrtecnologia(String strtecnologia) {
		this.strtecnologia = strtecnologia;
	}
	public Date getDtmfecha_inicio_oper() {
		return dtmfecha_inicio_oper;
	}
	public void setDtmfecha_inicio_oper(Date dtmfechaInicioOper) {
		dtmfecha_inicio_oper = dtmfechaInicioOper;
	}
	public Date getDtmfecha_interv_nac() {
		return dtmfecha_interv_nac;
	}
	public void setDtmfecha_interv_nac(Date dtmfechaIntervNac) {
		dtmfecha_interv_nac = dtmfechaIntervNac;
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
	public void setBolactivo(boolean bolactivo) {
		this.bolactivo = bolactivo;
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
		return dtoorganizacion+" "+ dtmfecha_inicio_oper+" "+ dtmfecha_interv_nac+" ("+lngid+")";
	}
}

