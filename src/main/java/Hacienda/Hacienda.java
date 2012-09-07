package Hacienda;
import java.util.*;

import SubZona.SubZona;
import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Productor.Productor;
import Productor.Productor;
import Tablon.Tablon;
import Tablon.Tablon;
import Zona.Zona;
@Entity
public  class Hacienda extends DtoBase {
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	@JoinColumn(name="productor_lngid",insertable=true,updatable=true,nullable=true) @ManyToOne() Productor dtoproductor;
	@NotNull() @Size(min=3,max=40,message="{longitud}") String strnombre;
	@NotNull() long lngdistancia;
	@NotNull() long lnghectareas;
	@NotNull() long lngcanaestimada;
	//@NotNull() @Size(min=10,max=30,message="{longitud}") String strzona;
	@JoinColumn(name="hacienda_lngid") @OneToMany(cascade=CascadeType.ALL) @LazyCollection(LazyCollectionOption.FALSE) List<Tablon> dtotablones;
	@JoinColumn(name="zona_lngid",insertable=true,updatable=true,nullable=true) @ManyToOne() Zona dtozona;
	@JoinColumn(name="subzona_lngid",insertable=true,updatable=true,nullable=true) @ManyToOne() SubZona dtosubzona;
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
	public Productor getDtoproductor(){
		return dtoproductor;
	}
	public void setDtoproductor(  Productor param){
		this.dtoproductor=param;
	}
	public String getStrnombre(){
		return strnombre;
	}
	public void setStrnombre(  String param){
		this.strnombre=param;
	}
	public long getLngdistancia(){
		return lngdistancia;
	}
	public void setLngdistancia(  long param){
		this.lngdistancia=param;
	}
	public long getLnghectareas(){
		return lnghectareas;
	}
	public void setLnghectareas(  long param){
		this.lnghectareas=param;
	}
	public long getLngcanaestimada(){
		return lngcanaestimada;
	}
	public void setLngcanaestimada(  long param){
		this.lngcanaestimada=param;
	}
	/*public String getStrzona(){
		return strzona;
	}
	public void setStrzona(  String param){
		this.strzona=param;
	}*/
	public List<Tablon> getDtotablones(){
		return dtotablones;
	}
	public void setDtotablones(  List<Tablon> param){
		this.dtotablones=param;
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
	public String toString(){
		return lngid+" "+strnombre+" "+lnghectareas;
	}
}

