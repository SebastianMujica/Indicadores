package Indicador;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import UnidadDeMedida.UnidadDeMedida;
public class modeloIndicador extends ModeloBase {
  public Indicador buscarIndicador(  Indicador param,  String campo,  String clave){
    return (Indicador)super.buscar(param,campo,clave).get(0);
  }
  public Indicador[] buscarIndicadors(){
    List<DtoBase> listaBase=super.buscar(new Indicador());
    Indicador[] arreglo=new Indicador[listaBase.size()];
    for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Indicador)listaBase.get(i);
    return arreglo;
  }
  
  public List<DtoBase> buscarIndicadorCategoria(long id_categoria){
		
		Indicador[] arreglo;
		List <DtoBase> listadto = new ArrayList<DtoBase>();
		
		this.iniciaOperacion();

		Criteria criterio=this.getFactory().getCurrentSession().createCriteria(Indicador.class);
		Criterion activo=Restrictions.eq("bolactivo",true);
		criterio.add(activo);
		Criterion borrado=Restrictions.eq("bolborrado",false);
		criterio.add(borrado);
		Criterion lngid_tipo=Restrictions.eq("dtocategoria.lngid",id_categoria);
		criterio.add(lngid_tipo);

		try{
			listadto =  criterio.list();				
		}catch (HibernateException e) {
			// TODO: handle exception
			this.manejaExcepcion(e);
		}
		return listadto;
		
		/*if(!listadto.isEmpty()){
			arreglo = new Indicador[listadto.size()];
			for (int i=0; i < listadto.size(); i++)     arreglo[i]=(Indicador)listadto.get(i);
			return arreglo;
		}else
			return null;*/
		
	}

  
  
  public void eliminar(  Indicador param){
    super.eliminar(param);
  }
  public void eliminar(  String clave){
    super.eliminar(this.buscarIndicador(new Indicador(),"lngid",clave));
  }
  public void grabar(  Indicador param){
    super.guardar(param);
  }
}

