package Producto;

import java.util.*;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;
import UnidadDeMedida.UnidadDeMedida;
import Maestro.Maestro;
import Organizacion.Organizacion;

@Entity
@Table(name="tbl_producto")
public  class Producto extends DtoBase {

	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	@NotNull() @Size(min=2,max=50,message="{longitud_entre}") String strcodigo;
	@NotNull() @Size(min=2,max=100,message="{longitud_entre}") String strnombre;
	@NotNull() @Size(min=2,max=10,message="{longitud_entre}") String strsimbolo;
	@Size(min=2,max=255,message="{longitud}") String strdescripcion;
	
	@NotNull() @JoinColumn(name="organizacion_lngid",insertable=true,updatable=true,nullable=false) @ManyToOne() Organizacion dtoorganizacion;
	@NotNull() @JoinColumn(name="unidadmedida_lngid",insertable=true,updatable=true,nullable=false) @ManyToOne() UnidadDeMedida dtounidadmedida;
	@NotNull() @JoinColumn(name="maestro_tipprod_lngid",insertable=true,updatable=true,nullable=false) @ManyToOne() Maestro dtotipoproducto;
	@NotNull() @JoinColumn(name="maestro_catprod_lngid",insertable=true,updatable=true,nullable=false) @ManyToOne() Maestro dtocategoriaproducto;

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

	public long getLngid(){
		return lngid;
	}
	public void setLngid(  long param){
		this.lngid=param;
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
	public Organizacion getDtoorganizacion() {
		return dtoorganizacion;
	}
	public void setDtoorganizacion(Organizacion dtoorganizacion) {
		this.dtoorganizacion = dtoorganizacion;
	}
	public UnidadDeMedida getDtounidadmedida(){
		return dtounidadmedida;
	}
	public void setDtounidadmedida(  UnidadDeMedida param){
		this.dtounidadmedida=param;
	}
	public Maestro getDtotipoproducto(){
		return dtotipoproducto;
	}
	public void setDtotipoproducto(  Maestro param){
		this.dtotipoproducto=param;
	}
	public Maestro getDtocategoriaproducto(){
		return dtocategoriaproducto;
	}
	public void setDtocategoriaproducto(  Maestro param){
		this.dtocategoriaproducto=param;
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
	public String toString(){
	   return strcodigo+ "_" + strnombre + " (" + lngid+")" ;
	}
}

