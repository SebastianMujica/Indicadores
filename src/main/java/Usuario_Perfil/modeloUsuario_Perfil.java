package Usuario_Perfil;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
public class modeloUsuario_Perfil extends ModeloBase {
	public Usuario_Perfil buscarUsuario_Perfil(  Usuario_Perfil param,  String campo,  String clave){
		return (Usuario_Perfil)super.buscar(param,campo,clave).get(0);
	}
	public Usuario_Perfil[] buscarUsuario_Perfils(){
		List<DtoBase> listaBase=super.buscar(new Usuario_Perfil());
		Usuario_Perfil[] arreglo=new Usuario_Perfil[listaBase.size()];
		for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Usuario_Perfil)listaBase.get(i);
		return arreglo;
	}
	
	public List<Usuario_Perfil> buscarUsuario_Perfils(long usuario_lngid){
		List<Usuario_Perfil> listaPrf = new ArrayList<Usuario_Perfil>();

		this.iniciaOperacion();

		Criteria criterio=this.getFactory().getCurrentSession().createCriteria(new Usuario_Perfil().getClass());
		Criterion fk=Restrictions.eq("lngseg_usuario_perfil",usuario_lngid);
		criterio.add(fk);
		Criterion activo=Restrictions.eq("bolactivo",true);
		criterio.add(activo);
		//Criterion borrado=Restrictions.eq("bolborrado",false);

		try {
			//return criterio.list();
			listaPrf = criterio.list();
			this.terminaOperacion();
		} catch(HibernateException he){
			/*System.out.println(he.toString());
			return null;*/
			this.manejaExcepcion(he);
		}

		return listaPrf;
	}
	
	public void eliminar(  Usuario_Perfil param){
		super.eliminar(param);
	}
	
	public void eliminar(  String clave){
		super.eliminar(this.buscarUsuario_Perfil(new Usuario_Perfil(),"lngid",clave));
	}
	public void grabar(  Usuario_Perfil param){
		super.guardar(param);
	}
}

