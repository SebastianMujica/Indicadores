package Perfil;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import Menu.Menu;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloPerfil extends ModeloBase {
	public Perfil buscarPerfil(  Perfil param,  String campo,  String clave){
		return (Perfil)super.buscar(param,campo,clave).get(0);
	}
	public Perfil[] buscarPerfils(){
		List<DtoBase> listaBase=super.buscar(new Perfil());
		Perfil[] arreglo=new Perfil[listaBase.size()];
		for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Perfil)listaBase.get(i);
		return arreglo;
	}
	public void eliminar(  Perfil param){
		super.eliminar(param);
	}
	public void eliminar(  String clave){
		super.eliminar(this.buscarPerfil(new Perfil(),"lngid",clave));
	}
	public void grabar(  Perfil param){
		super.guardar(param);
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

}
