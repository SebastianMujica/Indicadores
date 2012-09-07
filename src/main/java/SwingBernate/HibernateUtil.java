package SwingBernate;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            //sessionFactory = new Configuration().configure(new File("/home/sebastian/CarpetaDeTrabajo/Swingbernate4/src/main/resources/hibernate.cfg.xml")).buildSessionFactory();
        	
        	//Este estaba funcionando...
        	sessionFactory = new Configuration().configure().buildSessionFactory();
//        	Logger.getLogger("org.hibernate").setLevel(Level.DEBUG);
//        	Logger.getLogger("org.hibernate.cache").setLevel(Level.DEBUG);
        	//Este es con Annotation
        	//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Creacion de la Sesion Falló: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
