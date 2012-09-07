package Usuario;
import java.util.*;

import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import SocioDeNegocio.SocioDeNegocio;
import Tema.Tema;
import Usuario_Perfil.Usuario_Perfil;
@Entity
@Table(name="tblseg_usuario")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
//@org.hibernate.annotations.BatchSize(size = 10)
public  class Usuario extends DtoBase {
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	
	
	@Index(name="idx_sociodenegocio_usuario") 
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name="socio_lngid",insertable=true,updatable=true,nullable=false) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) SocioDeNegocio dtosocio;
	
	@NotNull() @Size(min=6,max=30,message="{longitud}") String strusername;
	@NotNull() @Size(min=6,max=50,message="{longitud}") String strpassword;
	@NotNull() @Size(min=6,max=50,message="{longitud}") String strconfirpassword;
	
	@ManyToMany(mappedBy="dto_usuario")
	@LazyCollection(LazyCollectionOption.FALSE) List<Usuario_Perfil> dto_perfil;
	
	@Index(name="idx_tema_usuario")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name="tema_lngid",insertable=true,updatable=true,nullable=true)
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) Tema dto_tema;
	
	Date dtmfecha_ultimologin;
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
	public SocioDeNegocio getDtosocio(){
		return dtosocio;
	}
	public void setDtosocio(  SocioDeNegocio param){
		this.dtosocio=param;
	}
	public String getStrusername(){
		return strusername;
	}
	public void setStrusername(  String param){
		this.strusername=param;
	}
	public String getStrpassword(){
		return strpassword;
	}
	public void setStrpassword(  String param){
		this.strpassword=param;
	}
	public String getStrconfirpassword(){
		return strconfirpassword;
	}
	public void setStrconfirpassword(  String param){
		this.strconfirpassword=param;
	}

	public Date getDtmfecha_ultimologin() {
		return dtmfecha_ultimologin;
	}
	public void setDtmfecha_ultimologin(Date dtmfechaUltimologin) {
		dtmfecha_ultimologin = dtmfechaUltimologin;
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
	public List<Usuario_Perfil> getDto_perfil() {
		return dto_perfil;
	}
	public void setDto_perfil(List<Usuario_Perfil> dtoPerfil) {
		dto_perfil = dtoPerfil;
	}
	public Tema getDto_tema() {
		return dto_tema;
	}
	public void setDto_tema(Tema dtoTema) {
		dto_tema = dtoTema;
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
		return dtosocio+" --> "+strusername;
	}
}

