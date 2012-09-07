package Menu;

import java.util.*;

import SwingBernate.*;
import javax.validation.constraints.*;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="tblseg_menu")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@org.hibernate.annotations.BatchSize(size = 10)
public class Menu extends DtoBase {
	
	@Id() @GeneratedValue(strategy=GenerationType.IDENTITY) long lngid;
	@NotNull(message="{campo_obligatorio}") @Size(min=3,max=40,message="{longitud}") String strnombre;
	@NotNull(message="{campo_obligatorio}") @Size(min=3,max=20,message="{longitud}") String strsigla;
	//@NotNull() @Size(min=3,max=250,message="{longitud}") String strpaquete;	
	@Size(min=0,max=100,message="{longitud}") String strpaquete;
	
	@Index(name="idx_padre_menu")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name="dtomenu_lngid",insertable=true,updatable=true,nullable=true) 
	@ManyToOne(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE) private Menu dtomenu;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="dtomenu", cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	@LazyCollection(LazyCollectionOption.FALSE) private List<Menu> dtonodo = new ArrayList<Menu>();
	
	@NotNull(message="{campo_obligatorio}") Short intnivel;
	@NotNull(message="{campo_obligatorio}") Short intpos_rel;	
	

	boolean bolsubmenu;
	
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
	public String getStrsigla(){
		return strsigla;
	}
	public void setStrsigla(  String param){
		this.strsigla=param;
	}
	public String getStrpaquete(){
		return strpaquete;
	}
	public void setStrpaquete(  String param){
		this.strpaquete=param;
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
	public Menu getDtomenu() {
		return dtomenu;
	}
	public void setDtomenu(Menu dtomenu) {
		this.dtomenu = dtomenu;
	}
	public List<Menu> getDtonodo() {
		List<Menu> auxnodos = new ArrayList<Menu>();
		for (Menu menu : dtonodo) {
			if(menu.isBolactivo())
				auxnodos.add(menu);
		}
		//return dtonodo;
		this.setDtonodo(auxnodos);
		return auxnodos;
	}
	public void setDtonodo(List<Menu> dtonodo) {
		this.dtonodo = dtonodo;
	}
	public boolean isBolsubmenu() {
		return bolsubmenu;
	}
	public boolean getBolsubmenu() {
		return bolsubmenu;
	}
	public void setBolsubmenu(boolean bolsubmenu) {
		this.bolsubmenu = bolsubmenu;
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

	public static Comparator getComparaNivelMenu() {
		return ComparaNivelMenu;
	}

	public static final Comparator ComparaNivelMenu= new Comparator(){
		
		public int compare(Object o1, Object o2){
			int rt = 0;
			if (o1 == o2 || !(o1 instanceof Menu ) || !(o2 instanceof Menu )) 
				rt = 0;
			else{
				Menu m1 = (Menu)o1;
				Menu m2 = (Menu)o2;
				if(m1.intnivel.compareTo(m2.intnivel)==0)
					rt = m1.intpos_rel.compareTo(m2.intpos_rel);
				else
					rt = m1.intnivel.compareTo(m2.intnivel);
			}
			
			return rt;
		}
		
	};
	
	
	@Override
	public String toString() {
		return strnombre;
	}
	
}

