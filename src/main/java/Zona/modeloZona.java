package Zona;

import java.util.List;


import SwingBernate.DtoBase;
import SwingBernate.ModeloBase;

public class modeloZona extends ModeloBase {
	
	public void nuevo(){
		
	}
	public Zona buscar(Zona dto,String campo,String clave){
		return (Zona)super.buscar(dto, campo, clave).get(0);
		
	}
	
	public Zona buscar(String campo, String clave){
		List zonas = super.buscarLike(new Zona(), campo, clave);
		if(zonas.isEmpty()){
			return null;
		}else{
			return (Zona)zonas.get(0);
		}			
	}
	
	public Zona buscar(Zona dto, long clave){
		return (Zona)super.buscar(dto, clave);
	}
	
	public Zona[] buscarZonas(){
		List<DtoBase> listaBase = super.buscar(new Zona());
		Zona[] arrEjemplo = new Zona[listaBase.size()];
		for (int j = 0; j < listaBase.size(); j++) {
			arrEjemplo[j]= (Zona)listaBase.get(j);
			System.out.println(arrEjemplo[j]);
		}
		return arrEjemplo;
	}
	
	public void eliminar(Zona dto){
		super.eliminar(dto);
	}
	
	public void eliminar(long id){
		super.eliminar(this.buscar(new Zona(),id));
	}
	
	public void grabar(Zona dto){
		this.guardar(dto);
	}

}
