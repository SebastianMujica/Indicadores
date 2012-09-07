package Tema;
import java.util.*;

import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;
@Entity
@Table(name="tblsis_tema")
public  class Tema extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  @NotNull() @Size() String strnombre;
  @NotNull() @Size() String strprimario1;
  @NotNull() @Size() String strprimario2;
  @NotNull() @Size() String strprimario3;
  @NotNull() @Size() String strsecundario1;
  @NotNull() @Size() String strsecundario2;
  @NotNull() @Size() String strsecundario3;
  @Size() String strblanco;
  @Size() String strnegro;
  @NotNull() long lngmenuopacidad;
  @NotNull() long lngframeopacidad;
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
  public String getStrnombre(){
    return strnombre;
  }
  public void setStrnombre(  String param){
    this.strnombre=param;
  }
  public String getStrprimario1(){
    return strprimario1;
  }
  public void setStrprimario1(  String param){
    this.strprimario1=param;
  }
  public String getStrprimario2(){
    return strprimario2;
  }
  public void setStrprimario2(  String param){
    this.strprimario2=param;
  }
  public String getStrprimario3(){
    return strprimario3;
  }
  public void setStrprimario3(  String param){
    this.strprimario3=param;
  }
  public String getStrsecundario1(){
    return strsecundario1;
  }
  public void setStrsecundario1(  String param){
    this.strsecundario1=param;
  }
  public String getStrsecundario2(){
    return strsecundario2;
  }
  public void setStrsecundario2(  String param){
    this.strsecundario2=param;
  }
  public String getStrsecundario3(){
    return strsecundario3;
  }
  public void setStrsecundario3(  String param){
    this.strsecundario3=param;
  }
  public String getStrblanco(){
    return strblanco;
  }
  public void setStrblanco(  String param){
    this.strblanco=param;
  }
  public String getStrnegro(){
    return strnegro;
  }
  public void setStrnegro(  String param){
    this.strnegro=param;
  }
  public long getLngmenuopacidad(){
    return lngmenuopacidad;
  }
  public void setLngmenuopacidad(  long param){
    this.lngmenuopacidad=param;
  }
  public long getLngframeopacidad(){
    return lngframeopacidad;
  }
  public void setLngframeopacidad(  long param){
    this.lngframeopacidad=param;
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
  }
