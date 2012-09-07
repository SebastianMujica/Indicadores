package Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;

public class modeloMenu extends ModeloBase {

	public Menu buscar(  Menu param,  String campo,  String clave){
		return (Menu)super.buscar(param,campo,clave).get(0);
	}
	
	public Menu[] buscarMenu(){
		List<DtoBase> listaBase=super.buscar(new Menu());
		Menu[] arreglo=new Menu[listaBase.size()];
		for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Menu)listaBase.get(i);
		return arreglo;
	}

	public void eliminar(  Menu param){
		super.eliminar(param);
	}

	public void eliminar(  String clave){
		super.eliminar(this.buscar(new Menu(),"id",clave));
	}

	public void grabar(  Menu param){
		super.guardar(param);
	}

	public Menu[] buscarSubMenu(Menu dtoparametro, boolean padrenull) throws HibernateException{

		List<Menu> listadto = null;
		Menu arrMenu[] =  null;

		this.iniciaOperacion();

		//Criteria criterio=this.getFactory().getCurrentSession().createCriteria(dtoparametro.getClass());
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
		Criterion activo=Restrictions.eq("bolactivo",true);
		criterio.add(activo);	    
		criterio.add(Restrictions.eq("bolsubmenu",true));
		criterio.addOrder(Order.asc("intnivel"));
		criterio.addOrder(Order.asc("intpos_rel"));
		if(padrenull)
			criterio.add(Restrictions.isNull("dtomenu"));

		try {
			//return criterio.list();
			Menu dto = new Menu();
			dto.setLngid(0);
			dto.setStrnombre("Seleccione");
			dto.setBolactivo(true);
			listadto = criterio.list();
			this.cerrar_transaccion(getTransaccion());
			Collections.sort(listadto, Menu.ComparaNivelMenu);
			if(!listadto.isEmpty()){
				arrMenu = new Menu[listadto.size()+1];
				arrMenu[0] = dto;
				for (int i=0; i < listadto.size(); i++){
					arrMenu[i+1]=(Menu)listadto.get(i);
				}		    	
			}else{
				arrMenu = new Menu[1];
				arrMenu[0] = dto;
			}
			//this.terminaOperacion();
		} catch(HibernateException he){
			/*System.out.println(he.toString());
			return null;*/
			this.manejaExcepcion(he);
		}

		return arrMenu;

	}

}

