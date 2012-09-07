package SwingBernate;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Clase Base del Modelo 
 * @author Ing. Sebastian Mujica
 *
 */
public class ModeloBase {
	
    private static final Restrictions Expression = null;
	private Session sesion=null;
	private SessionFactory factory=null;
	private Transaction transcc=null;
	
	protected SessionFactory getFactory(){
        if (factory==null){
        	factory = HibernateUtil.getSessionFactory();
        }
		return factory;
    }	
	protected Session getSession(){
		if (sesion == null){
		   //sesion = this.getFactory().getCurrentSession();
			sesion = this.getFactory().openSession();
		}
        return sesion;
    }
	protected Transaction getTransaccion(){
		if (transcc==null){
			Session s = this.getSession();
			transcc = s.getTransaction();
		}
		return transcc;
	}
	
	protected void iniciar_transaccion(Transaction tx){
    	if (!tx.isActive()){
    		tx.begin();
    	}
    }
	protected boolean cerrar_transaccion(Transaction tx){
    	boolean bolOp=false;
    	if (tx.isActive()){
    		tx.commit();
    	}
    	bolOp=tx.wasCommitted();
    	this.getSession().close();
    	this.sesion=null;
    	return bolOp;
    }
	protected boolean abortar_transaccion(Transaction tx){
    	boolean bolOp=false;
    	if (tx.isActive()){
    		tx.rollback();
    	}
    	this.getSession().close();
    	this.sesion=null;
    	return bolOp;
    }
    
	protected void iniciaOperacion()
    {   
    	//factory=HibernateUtil.getSessionFactory();
    	//factory.getCurrentSession().beginTransaction();
    	//this.getFactory().openSession();
    	Transaction tx = this.getSession().getTransaction();
    	this.iniciar_transaccion(tx);
    	
    	//HibernateUtil
    	//sesion = HibernateUtil.getSessionFactory().getCurrentSession();
    	//sesion.getTransaction().begin();
        }

	protected void terminaOperacion()
    {
    	factory.getCurrentSession().getTransaction().commit();

    	//sesion.getTransaction().commit();
        //sesion.close();
    }

	protected void manejaExcepcion(HibernateException he) throws HibernateException
    {
    	if (this.transcc!=null && this.transcc.isActive()){
    		//factory.getCurrentSession().getTransaction().rollback();
    		this.getSession().getTransaction().rollback();
    	}        
    	this.getSession().close();
    	this.sesion=null;
        throw he;
    }

    
	public void conectar(){
	}
	
	public void guardar(DtoBase dtoparametro){
		this.iniciaOperacion();
        dtoparametro.setBolborrado(false);
       try{
    	   if (dtoparametro.getLngid()==0)
    		   this.getSession().save(dtoparametro);
    	   else
    	   this.getSession().update(dtoparametro);
    	   
    	   System.out.println("Registro Guardado");	
    	   //this.terminaOperacion();
    	   this.cerrar_transaccion(getTransaccion());
       }catch(HibernateException he){
    	   System.out.println("**************************\nExcepcion en: ModeloBase.java;guardar(DtoBase dtoparametro)");
    		this.manejaExcepcion(he);
    	}
	}
	public void guardar(DtoBase dtoparametro,boolean bolTran){
		if (bolTran) this.iniciaOperacion();
        dtoparametro.setBolborrado(false);
        try{
    	   if (dtoparametro.getLngid()==0)
    		   this.getSession().save(dtoparametro);
    	   else
    	   this.getSession().update(dtoparametro);
    	   
    	   System.out.println("Registro Guardado");	
    	   //this.terminaOperacion();
    	   if (bolTran) this.cerrar_transaccion(getTransaccion());
       }catch(HibernateException he){
    	   System.out.println("**************************\nExcepcion en: ModeloBase.java;guardar(DtoBase dtoparametro)");
    		this.manejaExcepcion(he);
    	}
	}
	public void eliminar(DtoBase dtoparametro){
		this.iniciaOperacion();
    	try{
    		dtoparametro.setBolborrado(true);
    		dtoparametro.setDtmfecha_modificacion(new Date());
    		this.getSession().update(dtoparametro);
    		//this.terminaOperacion();
    		this.cerrar_transaccion(getTransaccion());
    	}catch(HibernateException he){
    		System.out.println("**************************\nExcepcion en: ModeloBase.java;eliminar(DtoBase dtoparametro)");
    		this.manejaExcepcion(he);
        } 
    }
	
	public DtoBase buscar(DtoBase dtoparametro, long id) throws HibernateException{
		DtoBase dtoRecuperado = null;	
		this.iniciaOperacion();
		//factory=HibernateUtil.getSessionFactory();
		//Criteria criterio=this.getFactory().getCurrentSession().createCriteria(dtoparametro.getClass());
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
		
	    Criterion pk=Restrictions.idEq(id);
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    criterio.add(pk);
	    criterio.add(borrado);
	    
	    try {
	    	//System.out.println("Buscando... [ModeloBase.java; Método buscar(DtoBase dtoparametro, long id)]");
	    	dtoRecuperado = (DtoBase)criterio.list().get(0);
	    	//System.out.println("Recuperado... lngId="+ dtoRecuperado.getLngid() + ".[ModeloBase.java; Método buscar(DtoBase dtoparametro, long id)]");
	    	this.cerrar_transaccion(getTransaccion());
 		} catch(HibernateException he){
 			System.out.println("**************************\nExcepcion en: ModeloBase.java;buscar(DtoBase dtoparametro, long id)");
			this.manejaExcepcion(he);
		}
			return dtoRecuperado;
    }
	
	public List <DtoBase> buscar(DtoBase dtoparametro,Criterion[] criterios) throws HibernateException{
		List <DtoBase> listadto = null;
		this.iniciaOperacion();
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
	    
		
		for (int i = 0; i < criterios.length; i++) {
			
			criterio.add(criterios[i]);
		}
		
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    criterio.add(borrado);
	    
	    try {
	    	//System.out.println("Buscando... [ModeloBase.java; Método buscar(DtoBase dtoparametro,String campo,Object clave)]");
	    	listadto = criterio.list();
	    	System.out.println("Recuperado... listadto.size()="+ listadto.size() + ". [ModeloBase.java; Método buscar(DtoBase dtoparametro,String campo,Object clave)]");
	    	this.cerrar_transaccion(getTransaccion());
	    	
		} catch(HibernateException he){
			System.out.println("**************************\nExcepcion en: ModeloBase.java; buscar(DtoBase dtoparametro,Criterion)");
			he.printStackTrace();
			this.manejaExcepcion(he);
		}
		return listadto;
    }
	
	
	
	
	
	
	public List <DtoBase> buscar(DtoBase dtoparametro,String campo,Object clave) throws HibernateException{
		List <DtoBase> listadto = null;
		this.iniciaOperacion();
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
	    Criterion fk=Restrictions.eq(campo,clave);
	    if (campo.equals("lngid")) {
	    	      fk=Restrictions.eq(campo,Long.parseLong(clave.toString()));	
		}
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    criterio.add(fk);
	    criterio.add(borrado);
	    
	    try {
	    	//System.out.println("Buscando... [ModeloBase.java; Método buscar(DtoBase dtoparametro,String campo,Object clave)]");
	    	listadto = criterio.list();
	    	//System.out.println("Recuperado... listadto.size()="+ listadto.size() + ". [ModeloBase.java; Método buscar(DtoBase dtoparametro,String campo,Object clave)]");
	    	this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			System.out.println("**************************\nExcepcion en: ModeloBase.java; buscar(DtoBase dtoparametro,String campo,Object clave)");
			this.manejaExcepcion(he);
		}
		return listadto;
    }
	
	public List <DtoBase> buscar(DtoBase dtoparametro) throws HibernateException{
    	List <DtoBase> listadto = null;
    	 try {
        this.iniciaOperacion();
        Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
        criterio.setCacheable(true);
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    criterio.add(borrado);
	    criterio.addOrder(Order.desc("lngid"));
	    //System.out.println("Buscando... [ModeloBase.java; Método buscar(DtoBase dtoparametro)]");
	    listadto = criterio.list();
	    //System.out.println("Recuperado... listadto.size()="+ listadto.size() + ".[ModeloBase.java; Método buscar(DtoBase dtoparametro)]\n");
	    System.out.println(this.getFactory().getStatistics()+"\n");
	    //this.terminaOperacion();
	    this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			System.out.println("**************************\nExcepcion en: ModeloBase.java; buscar(DtoBase dtoparametro)");
			this.manejaExcepcion(he);
		}
		return listadto;
    }
	
public List <DtoBase> nUltimos(DtoBase dtoparametro, int n,long id,DtoBase campo) throws HibernateException{
		
		List <DtoBase> listadto = null;
		this.iniciaOperacion();
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
		criterio.setCacheable(true);
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    Criterion restid=Restrictions.eq("dtoindicador",campo);
	    criterio.add(restid);
	    criterio.add(borrado);
	    criterio.addOrder(Order.desc("dtmfecha_creacion"));
	    criterio.setMaxResults(n);
	    try {
	    	//System.out.println("Buscando... [ModeloBase.java; Método nUltimos(DtoBase dtoparametro, int n,long id,DtoBase campo)]");
		    listadto = criterio.list();
		    //System.out.println("Recuperado... listadto.size()="+ listadto.size() + ".[ModeloBase.java; Método nUltimos(DtoBase dtoparametro, int n,long id,DtoBase campo)]");
		    this.cerrar_transaccion(getTransaccion());
	    } catch(HibernateException he){
	    	System.out.println("**************************\nExcepcion en: ModeloBase.java;nUltimos(DtoBase dtoparametro, int n,long id,DtoBase campo)");
			this.manejaExcepcion(he);
		}
		return listadto;
    }
	
/*
 * TODO
 */
public List <DtoBase> nUltimosUnicos(DtoBase dtoparametro, int n,long id,String campo,String dist) throws HibernateException{
	List <DtoBase> listadto = null;	
	this.iniciaOperacion();
	//factory=HibernateUtil.getSessionFactory();
	//Criteria criterio=this.getFactory().getCurrentSession().createCriteria(dtoparametro.getClass());
	Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
	criterio.setCacheable(true);
    Criterion borrado=Restrictions.eq("bolborrado",false);
    Criterion restid=Restrictions.eq(campo,id);
    criterio.add(restid);
    criterio.add(borrado);
    criterio.addOrder(Order.desc("dtmfecha_creacion"));
    criterio.setMaxResults(n);
    try {
    	//System.out.println("Buscando... [ModeloBase.java; Método nUltimosUnicos(DtoBase dtoparametro, int n,long id,String campo,String dist)]");
	    listadto = criterio.list();
	    //System.out.println("Recuperado... listadto.size()="+ listadto.size() + ".[ModeloBase.java; Método nUltimosUnicos(DtoBase dtoparametro, int n,long id,String campo,String dist)]");
	    this.cerrar_transaccion(getTransaccion());
    } catch(HibernateException he){
    	System.out.println("**************************\nExcepcion en: ModeloBase.java; nUltimosUnicos(DtoBase dtoparametro, int n,long id,String campo,String dist)]");
		this.manejaExcepcion(he);
	}
	return listadto;
}
	
	
	
	public <T> List<T> getListaEntidades(DtoBase dtoparametro) throws HibernateException{
		
		List<T> listaResultado = null;
		this.iniciaOperacion();
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
		criterio.setCacheable(true);
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    criterio.add(borrado);
	    try {
	    	//System.out.println("Buscando... [ModeloBase.java; Método getListaEntidades(DtoBase dtoparametro)]");
	    	listaResultado = criterio.list();
	    	//System.out.println("Recuperado... listadto.size()="+ listaResultado.size() + ". [ModeloBase.java; Método getListaEntidades(DtoBase dtoparametro)]");
	    	this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			System.out.println("**************************\nExcepcion en: ModeloBase.java; getListaEntidades(DtoBase dtoparametro)");
			this.manejaExcepcion(he);
		}		
		return listaResultado;
    }

	
	
	public List <DtoBase> buscarLike(DtoBase dtoparametro,String campo,String clave) throws HibernateException{
		List <DtoBase> listadto = null;
		this.iniciaOperacion();
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
		criterio.setCacheable(true);
	    Criterion fk=Restrictions.ilike(campo,clave+"%");
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    criterio.add(fk);
	    criterio.add(borrado);
	    try {
	    	//System.out.println("Buscando... [ModeloBase.java; Método buscarLike(DtoBase dtoparametro,String campo,String clave)]");
	    	listadto = criterio.list();
	    	//System.out.println("Recuperado... listadto.size()="+ listadto.size() + ". [ModeloBase.java; Método buscarLike(DtoBase dtoparametro,String campo,String clave)]");
	    	this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			System.out.println("**************************\nExcepcion en: ModeloBase.java; buscarLike(DtoBase dtoparametro,String campo,String clave)");
			this.manejaExcepcion(he);
		}
		return listadto;
    }
	
	public DtoBase buscarFk(DtoBase dtoparametro, String campo, long clave) throws HibernateException{
		DtoBase dtoRecuperado = null;
		List<DtoBase> lista = null;
		this.iniciaOperacion();
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
		criterio.setCacheable(true);
	    Criterion fk=Restrictions.eq(campo,clave);
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    criterio.add(fk);
	    criterio.add(borrado);
	    try {
	    	//System.out.println("Buscando... [ModeloBase.java; Método buscarFk(DtoBase dtoparametro, String campo, long clave)]");
	    	lista = criterio.list();
	    	if(!lista.isEmpty()){
	    		dtoRecuperado = lista.get(0);
	    	}
	    	//System.out.println("Recuperado... listadto.size()="+ lista.size() + ". [ModeloBase.java; Método buscarFk(DtoBase dtoparametro, String campo, long clave)]");
	    	this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			System.out.println("**************************\nExcepcion en: ModeloBase.java; buscarFk(DtoBase dtoparametro, String campo, long clave)");
			this.manejaExcepcion(he);
		}
		
		return dtoRecuperado;
    }
	
	public List<DtoBase> buscarListaFk(DtoBase dtoparametro, String campo, long clave) throws HibernateException{
		List<DtoBase> lista = null;
		this.iniciaOperacion();
		Criteria criterio=this.getSession().createCriteria(dtoparametro.getClass());
		criterio.setCacheable(true);
	    Criterion fk=Restrictions.eq(campo,clave);
	    Criterion borrado=Restrictions.eq("bolborrado",false);
	    criterio.add(fk);
	    criterio.add(borrado);
	    try {
	    	//System.out.println("Buscando... [ModeloBase.java; Método buscarListaFk(DtoBase dtoparametro, String campo, long clave)]");
	    	lista = criterio.list();
	    	//System.out.println("Recuperado... listadto.size()="+ lista.size() + ". [ModeloBase.java; Método buscarListaFk(DtoBase dtoparametro, String campo, long clave)]");
	    	this.cerrar_transaccion(getTransaccion());
		} catch(HibernateException he){
			System.out.println("**************************\nExcepcion en: ModeloBase.java; buscarListaFk(DtoBase dtoparametro, String campo, long clave)");
			this.manejaExcepcion(he);
		}
		
		return lista;
    }
	
}
