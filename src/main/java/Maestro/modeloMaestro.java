package Maestro;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;

public class modeloMaestro extends ModeloBase {
	
	public Maestro buscarMaestro(  Maestro param,  String campo,  String clave){
		return (Maestro)super.buscar(param,campo,clave).get(0);
	}
	
	public Maestro[] buscarMaestros(){
		List<DtoBase> listaBase=super.buscar(new Maestro());
		Maestro[] arreglo=new Maestro[listaBase.size()];
		for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Maestro)listaBase.get(i);
		return arreglo;
	}
	
	public void eliminar(  Maestro param){
		super.eliminar(param);
	}
	
	public void eliminar(  String clave){
		super.eliminar(this.buscarMaestro(new Maestro(),"lngid",clave));
	}
	
	public void grabar(  Maestro param){
		super.guardar(param);
	}
	
	public Maestro[] hijosPorMaestro(String strCodigo){

		Maestro dtoMaestro = new Maestro();
		
		this.iniciaOperacion();

		//Criteria criterio=this.getFactory().getCurrentSession().createCriteria(dtoMaestro.getClass());
		Criteria criterio=this.getSession().createCriteria(dtoMaestro.getClass());
		Criterion activo=Restrictions.eq("bolactivo",true);
		criterio.add(activo);
		Criterion borrado=Restrictions.eq("bolborrado",false);
		criterio.add(borrado);
		Criterion strcodigo=Restrictions.eq("strcodigo",strCodigo);
		criterio.add(strcodigo);

		try{
			List <DtoBase> listadto =  criterio.list();
			if(!listadto.isEmpty())
				dtoMaestro = (Maestro)listadto.get(0);
			else
				dtoMaestro = null;
			this.cerrar_transaccion(getTransaccion());
		}catch (HibernateException e) {
			// TODO: handle exception
			this.manejaExcepcion(e);
		}

		if(dtoMaestro!=null){
			List<Maestro> listahijos=dtoMaestro.getDtohijos();
			Maestro[] arreglo=new Maestro[listahijos.size()];
			for (int i=0; i < listahijos.size(); i++)     arreglo[i]=(Maestro)listahijos.get(i);
			return arreglo;
		}
		else
			//return null;
			return new Maestro[0];
	}

	public List<DtoBase> lstHijosPorMaestro(String strCodigo){

		Maestro dtoMaestro = new Maestro();
		List<DtoBase> lst = new ArrayList<DtoBase>();

		this.iniciaOperacion();

		//Criteria criterio=this.getFactory().getCurrentSession().createCriteria(dtoMaestro.getClass());
		Criteria criterio=this.getSession().createCriteria(dtoMaestro.getClass());
		Criterion activo=Restrictions.eq("bolactivo",true);
		criterio.add(activo);
		Criterion borrado=Restrictions.eq("bolborrado",false);
		criterio.add(borrado);
		Criterion strcodigo=Restrictions.eq("strcodigo",strCodigo);
		criterio.add(strcodigo);

		try{
			List <DtoBase> listadto =  criterio.list();
			if(!listadto.isEmpty())
				dtoMaestro = (Maestro)listadto.get(0);
			else
				dtoMaestro = null;
			this.cerrar_transaccion(getTransaccion());
		}catch (HibernateException e) {
			// TODO: handle exception
			this.manejaExcepcion(e);
		}

		if(dtoMaestro!=null){
			for (Maestro mstr : dtoMaestro.getDtohijos()) {
				lst.add(mstr);
			}
		}

		return lst;
	}

}

