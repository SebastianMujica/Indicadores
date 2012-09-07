package SwingBernate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.List;
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
*/
import java.util.Hashtable;

import SwingBernate.ayudantes.opcionListaCombo;
import Usuario.Usuario;


public class DtoBase extends Object{
	
	long lngid;
	
	boolean bolactivo;
	boolean bolborrado;
	//Date dtmfecha_modificacion=new Date();
	Date dtmfecha_modificacion;
	Date dtmfecha_creacion;
	Date dtmvalido_desde;
	Date dtmvalido_hasta;
	
	String strip_creacion;
	String strip_modificacion;
	String strhost_creacion;
	String strhost_modificacion;
	Usuario dtousuario_creacion;
	Usuario dtousuario_modificacion;
	
	public long getLngid() {
		return lngid;
	}
	
	public void setLngid(long lngid) {
		this.lngid = lngid;
	}


	public boolean isBolactivo() {
		return bolactivo;
	}

	public void setBolactivo(boolean bolactivo) {
		this.bolactivo = bolactivo;
	}

	public Date getDtmfecha_modificacion() {
		return dtmfecha_modificacion;
	}

	public void setDtmfecha_modificacion(Date dtmfechaModificacion) {
		dtmfecha_modificacion = dtmfechaModificacion;
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
	
	public Usuario getDtousuario_creacion() {
		return dtousuario_creacion;
	}

	public void setDtousuario_creacion(Usuario dtousuarioCreacion) {
		dtousuario_creacion = dtousuarioCreacion;
	}

	public Usuario getDtousuario_modificacion() {
		return dtousuario_modificacion;
	}

	public void setDtousuario_modificacion(Usuario dtousuarioModificacion) {
		dtousuario_modificacion = dtousuarioModificacion;
	}

	@Override
	public String toString() {
		return "DtoBase [bolactivo=" + bolactivo + ", dtmfecha_modificacion="
				+ dtmfecha_modificacion + ", lngid=" + lngid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bolactivo ? 1231 : 1237);
		result = prime
				* result
				+ ((dtmfecha_modificacion == null) ? 0 : dtmfecha_modificacion
						.hashCode());
		result = prime * result + (int) (lngid ^ (lngid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		DtoBase dto=(DtoBase)obj;
		if ( (this.getLngid()==dto.getLngid()) && (this.isBolactivo()==dto.isBolactivo()) ){
			//System.out.println("igual ->"+this.toString());
			//System.out.println("igual ->"+dto.toString());
			return true;
			
		}		
		else{
			//System.out.println("desigual ->"+this.toString());
		    //System.out.println("desigual ->"+dto.toString());
			return false;	
			
		} 
		
	}

	public void setHash(Hashtable h){
		Field campos[]=this.getClass().getDeclaredFields();
		
		
		for (Field field : campos) {
			//System.out.println("DTO BASE ####");
			//System.out.println(field.getName());
			//System.out.println("DTO BASE ####");
			if(h.containsKey(field.getName())){
				try {
					
					
					System.out.println("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1,field.getName().length()));
					
					Method setterVta = this.getClass().getMethod("set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1,field.getName().length()),field.getType());
					
					
					
					Object param[]={h.get(field.getName())};
					
				//	System.out.println("TIPO_>>>>>>>>>>>>>>"+param[0].getClass().getCanonicalName());					
				//	System.out.println(field.getName()+" #####################"+field.getType().getCanonicalName());
					
					if(field.getType().getCanonicalName()=="long"){
						setterVta.invoke(this, Long.parseLong((String)param[0]));
					}else if(field.getType().getCanonicalName()=="float"){
						setterVta.invoke(this, Float.parseFloat((String)param[0]));
					}else if(field.getType().getCanonicalName()=="java.lang.String"){
						setterVta.invoke(this, (String)param[0]);
					}else if(field.getType().getCanonicalName()=="java.util.Date"){
						setterVta.invoke(this, (Date)param[0]);
					}else if(field.getType().getCanonicalName()=="java.lang.Short"){
						opcionListaCombo op=(opcionListaCombo)param[0];
							setterVta.invoke(this,op.getId());
					}else{
						//System.out.println("#################"+param[0].getClass().getCanonicalName());
						if( !param[0].getClass().getCanonicalName().equals("SwingBernate.dtoVacio") )
							setterVta.invoke(this, param[0]);
					}
					
					
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				
			}	
		}
		//System.out.println(this.toString());
		
	}
}

