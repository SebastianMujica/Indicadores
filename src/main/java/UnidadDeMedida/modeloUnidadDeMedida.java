package UnidadDeMedida;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import Maestro.Maestro;
import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloUnidadDeMedida extends ModeloBase {
	public UnidadDeMedida buscarUnidadDeMedida(  UnidadDeMedida param,  String campo,  String clave){
		return (UnidadDeMedida)super.buscar(param,campo,clave).get(0);
	}
	public UnidadDeMedida[] buscarUnidadDeMedidas(){
		List<DtoBase> listaBase=super.buscar(new UnidadDeMedida());
		UnidadDeMedida[] arreglo=new UnidadDeMedida[listaBase.size()];
		for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(UnidadDeMedida)listaBase.get(i);
		return arreglo;
	}
	public UnidadDeMedida[] buscarUnidadDeMedidasTipo(long idunidad){
		
		UnidadDeMedida[] arreglo;
		List <DtoBase> listadto = new ArrayList<DtoBase>();
		
		this.iniciaOperacion();

		//Criteria criterio=this.getFactory().getCurrentSession().createCriteria(UnidadDeMedida.class);
		Criteria criterio=this.getSession().createCriteria(UnidadDeMedida.class);
		Criterion activo=Restrictions.eq("bolactivo",true);
		criterio.add(activo);
		Criterion borrado=Restrictions.eq("bolborrado",false);
		criterio.add(borrado);
		Criterion lngid_tipo=Restrictions.eq("dtotipo_unidad.lngid",idunidad);
		criterio.add(lngid_tipo);

		try{
			listadto =  criterio.list();	
			this.cerrar_transaccion(this.getTransaccion());
		}catch (HibernateException e) {
			// TODO: handle exception
			this.manejaExcepcion(e);
		}
		
		if(!listadto.isEmpty()){
			arreglo = new UnidadDeMedida[listadto.size()];
			for (int i=0; i < listadto.size(); i++)     arreglo[i]=(UnidadDeMedida)listadto.get(i);
			return arreglo;
		}else
			return null;
		
	}
	public void eliminar(  UnidadDeMedida param){
		super.eliminar(param);
	}
	public void eliminar(  String clave){
		super.eliminar(this.buscarUnidadDeMedida(new UnidadDeMedida(),"lngid",clave));
	}
	public void grabar(  UnidadDeMedida param){

		/*this.iniciaOperacion();
		try{
			this.getFactory().getCurrentSession().update(param.getDtousuario_creacion());
			this.getFactory().getCurrentSession().saveOrUpdate(param);
			this.terminaOperacion();
			System.out.println("Guardado...");
		}catch(HibernateException he){
			//System.out.println(he.toString());
			this.manejaExcepcion(he);
		}*/

		super.guardar(param);
	}
}

