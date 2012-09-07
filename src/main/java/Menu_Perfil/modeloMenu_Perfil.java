package Menu_Perfil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Array;

import Menu.Menu;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import Usuario_Perfil.Usuario_Perfil;
public class modeloMenu_Perfil extends ModeloBase {

	public Menu_Perfil buscarMenu_Perfil(  Menu_Perfil param,  String campo,  String clave){
		return (Menu_Perfil)super.buscar(param,campo,clave).get(0);
	}
	public Menu_Perfil[] buscarMenu_Perfils(){
		List<DtoBase> listaBase=super.buscar(new Menu_Perfil());
		Menu_Perfil[] arreglo=new Menu_Perfil[listaBase.size()];
		for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Menu_Perfil)listaBase.get(i);
		return arreglo;
	}

	public List<Menu> buscarMenu_Perfil_Usuario(long perfil_lngid){
		List<Menu> listaMenu_Perfil = new ArrayList<Menu>();

		this.iniciaOperacion();

		/*Criteria criterio=this.getFactory().getCurrentSession().createCriteria(new Menu_Perfil().getClass());
		Criterion fk=Restrictions.eq("dtoperfil",perfil_lngid);
		criterio.add(fk);
		Criterion activo=Restrictions.eq("bolactivo",true);
		criterio.add(activo);
		Criterion borrado=Restrictions.eq("bolborrado",false);
		criterio.add(borrado);*/

		String sqlstr = "Select mp From Menu_Perfil mp Where mp.dtoperfil = "+perfil_lngid+
		" and mp.bolactivo=true and mp.bolborrado=false";

		//Query sql = this.getFactory().getCurrentSession().createQuery(sqlstr);
		Query sql = this.getSession().createQuery(sqlstr);

		try {
			//Menu_Perfil menuPerfil = (Menu_Perfil)criterio.list().get(0);
			Menu_Perfil menuPerfil = (Menu_Perfil)sql.list().get(0);
			if(menuPerfil != null){
				listaMenu_Perfil = menuPerfil.getDto_menu();	
			}
			//this.terminaOperacion();
			this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			/*System.out.println(he.toString());
			return null;*/
			this.manejaExcepcion(he);
		}

		return listaMenu_Perfil;
	}

	public String getPeso_Nodo(Menu dto){
		String peso = "";

		this.iniciaOperacion();

		//Query query = this.getFactory().getCurrentSession().createSQLQuery("Select peso_nodo("+dto.getLngid()+")");
		Query query = this.getSession().createSQLQuery("Select peso_nodo("+dto.getLngid()+")");

		try{
			peso = (String)query.list().get(0); 
			this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			peso = "";
			this.manejaExcepcion(he);
		}

		return peso;
	}

	public String getLista_Nodo(Menu dto){
		String listnodo = "";

		this.iniciaOperacion();

		//Query query = this.getFactory().getCurrentSession().createSQLQuery("Select getListaNodoMenu("+dto.getLngid()+")");
		Query query = this.getSession().createSQLQuery("Select getListaNodoMenu("+dto.getLngid()+")");

		try{
			listnodo = (String)query.list().get(0); 
			this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			listnodo = "";
			this.manejaExcepcion(he);
		}

		return listnodo;
	}
	
	public List<Object> getids_arbol(long idmenuperfil){
		List<Object> listnodo=new ArrayList<Object>();	
		this.iniciaOperacion();
		//Query query = this.getFactory().getCurrentSession().createSQLQuery("Select getids_arbol("+idmenuperfil+")");
		Query query = this.getSession().createSQLQuery("Select getids_arbol("+idmenuperfil+")");
		
		try{
			listnodo = query.list(); 
			//return query.list();
			this.cerrar_transaccion(getTransaccion());
			return listnodo;
		} catch(HibernateException he){
			this.manejaExcepcion(he);
			return null;
		}
		
	}

	public void eliminar(  Menu_Perfil param){
		super.eliminar(param);
	}
	public void eliminar(  String clave){
		super.eliminar(this.buscarMenu_Perfil(new Menu_Perfil(),"lngid",clave));
	}
	public void grabar(  Menu_Perfil param){
		super.guardar(param);
	}

}

