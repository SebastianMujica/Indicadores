package Menu_Perfil;
import java.util.*;

import SwingBernate.*;
import Variable.Variable;

import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Organizacion.Organizacion;
import Perfil.Perfil;
import Menu.Menu;
import Municipio.Municipio;
@Entity
@Table(name="tblseg_menu_perfil")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public  class Menu_Perfil extends DtoBase {
  @Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
  
  @Index(name="idx_org_menu_perfil")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @JoinColumn(name="lngsis_org",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Organizacion dto_org;
  
  @Index(name="idx_perfil_menu_perfil")
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @JoinColumn(name="lngseg_perfil",insertable=true,updatable=true,nullable=false) 
  @ManyToOne(fetch=FetchType.EAGER) 
  @LazyCollection(LazyCollectionOption.FALSE) Perfil dtoperfil;
  
  //@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
  @JoinTable(name="tblseg_menu_perfil_menu",uniqueConstraints = {
		    @UniqueConstraint(columnNames={"lngseg_menu_perfil","lngseg_menu"})},
		    joinColumns = @JoinColumn( name="lngseg_menu_perfil"), 
		    inverseJoinColumns = @JoinColumn( name="lngseg_menu"))
  @LazyCollection(LazyCollectionOption.FALSE) List<Menu> dto_menu;
  
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
  public Organizacion getDto_org(){
    return dto_org;
  }
  public void setDto_org(  Organizacion param){
    this.dto_org=param;
  }
  public Perfil getDtoperfil(){
    return dtoperfil;
  }
  public void setDtoperfil(  Perfil param){
    this.dtoperfil=param;
  }
  public List<Menu> getDto_menu(){
    return dto_menu;
  }
  public void setDto_menu(  List<Menu> param){
    this.dto_menu=param;
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
public void addMenu(Menu menu)
{
    this.dto_menu.add(menu);
}
public String toString(){
	return dtoperfil + "-" + dto_menu;
  }
	}

