package Nucleo;
import java.util.*;

import SubZona.SubZona;
import SwingBernate.*;
import javax.persistence.*;

import SocioDeNegocio.SocioDeNegocio;
import Zona.Zona;
@Entity
public  class Nucleo extends DtoBase {
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	@JoinColumn(name="socio_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() SocioDeNegocio dtosocio;
	@JoinColumn(name="zona_lngid",insertable=true,updatable=true,nullable=true) @ManyToOne() Zona dtozona;
	@JoinColumn(name="subzona_lngid",insertable=true,updatable=true,nullable=true) @ManyToOne() SubZona dtosubzona;
	//@JoinColumn(name="sector_lngid",insertable=true,updatable=false,nullable=true) @ManyToOne() SocioDeNegocio dtosector;
	Date dtmfecha_incorporacion;
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
	public Zona getDtozona() {
		return dtozona;
	}
	public void setDtozona(Zona dtozona) {
		this.dtozona = dtozona;
	}
	public SubZona getDtosubzona() {
		return dtosubzona;
	}
	public void setDtosubzona(SubZona dtosubzona) {
		this.dtosubzona = dtosubzona;
	}
	public Date getDtmfecha_incorporacion() {
		return dtmfecha_incorporacion;
	}
	public void setDtmfecha_incorporacion(Date dtmfechaIncorporacion) {
		dtmfecha_incorporacion = dtmfechaIncorporacion;
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
		return lngid+" "+dtosocio;
	}
}

