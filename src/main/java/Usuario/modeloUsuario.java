package Usuario;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import SwingBernate.ModeloBase;
import SwingBernate.DtoBase;
import SwingBernate.StringEncrypter;
import SwingBernate.StringMdEncrypter;

public class modeloUsuario extends ModeloBase {
	
	String mensaje ="";

	public Usuario buscarUsuario(  Usuario param,  String campo,  String clave){
		return (Usuario)super.buscar(param,campo,clave).get(0);
	}

	public Usuario buscarLogin(String nombreusuario,  String clave){

		Usuario dtousuario = new Usuario();
		String clave1 = new String("");

		this.iniciaOperacion();
		this.mensaje="datos de Usuario";
		SecretKey desKey;
		try {
			desKey = KeyGenerator.getInstance("DES").generateKey();
			StringEncrypter desEncrypter = new StringEncrypter(desKey, desKey.getAlgorithm());
			clave1 = desEncrypter.encrypt(clave);
			this.terminaOperacion();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			this.terminaOperacion();
			e1.printStackTrace();
		}

		//Criteria criterio=this.getFactory().getCurrentSession().createCriteria(dtousuario.getClass());
		Criteria criterio=this.getSession().createCriteria(dtousuario.getClass());
		Criterion login=Restrictions.eq("strusername",nombreusuario);
		criterio.add(login);	    
		criterio.add(Restrictions.eq("strpassword",clave1));
		
		try{
			List<Usuario> lsusuario = criterio.list();
			if(!lsusuario.isEmpty())
				dtousuario = (Usuario)lsusuario.get(0);
			else
				dtousuario = null;
			//this.terminaOperacion();
			this.cerrar_transaccion(getTransaccion());
		}catch(HibernateException he){
  		/*System.out.println(he.toString());
			return null;*/
			this.manejaExcepcion(he);
			this.terminaOperacion();
		}
		this.terminaOperacion();
		return dtousuario;	  
	}
	
	public Usuario buscarLogin1(String nombreusuario,  String clave){

		Usuario dtousuario = new Usuario();
		String clave1 = new String("");

		this.iniciaOperacion();
		this.mensaje="datos de Usuario";
		StringMdEncrypter mdEncrypter = new StringMdEncrypter();
		clave1 = mdEncrypter.getStringMessageDigest(clave, mdEncrypter.SHA1);

		//Criteria criterio=this.getFactory().getCurrentSession().createCriteria(dtousuario.getClass());
		Criteria criterio=this.getSession().createCriteria(dtousuario.getClass());
		Criterion login=Restrictions.eq("strusername",nombreusuario);
		criterio.add(login);	    
		criterio.add(Restrictions.eq("strpassword",clave1));
		
		try{
			List<Usuario> lsusuario = criterio.list();
			if(!lsusuario.isEmpty())
				dtousuario = (Usuario)lsusuario.get(0);
			else
				dtousuario = null;
			//this.terminaOperacion();
			this.cerrar_transaccion(getTransaccion());
		}catch(HibernateException he){
  		/*System.out.println(he.toString());
			return null;*/
			//this.terminaOperacion();
			this.manejaExcepcion(he);
		}

		return dtousuario;	  
	}

	public Usuario[] buscarUsuarios(){
		List<DtoBase> listaBase=super.buscar(new Usuario());
		Usuario[] arreglo=new Usuario[listaBase.size()];
		for (int i=0; i < listaBase.size(); i++)     arreglo[i]=(Usuario)listaBase.get(i);
		return arreglo;
	}
	public void eliminar(  Usuario param){
		super.eliminar(param);
	}
	public void eliminar(  String clave){
		super.eliminar(this.buscarUsuario(new Usuario(),"lngid",clave));
	}
	public void grabar(  Usuario param){
		super.guardar(param);
	}
}

