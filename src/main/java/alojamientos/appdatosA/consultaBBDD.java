package alojamientos.appdatosA;
import java.io.File;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class consultaBBDD {

	public consultaBBDD() {
		
	}
	
	public void sacarAlojamientos() {
		
		Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
        SessionFactory sesionFactory = config.buildSessionFactory();
        Session sesion = sesionFactory.openSession();
        List<Alojamientos> alojamientos = loadAllData(Alojamientos.class, sesion);
        sesion.close();
        for (int i =0;i<alojamientos.size();i++)
        {
        	alojamientos.get(i).toString();
        }
	}
	private static <T> List<T> loadAllData(Class<T> type, Session session) {
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<T> data = session.createQuery(criteria).getResultList();
	    return data;
	  }
	/*
	public void actualizarUsuarios() {
		
		Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
        SessionFactory sesionFactory = config.buildSessionFactory();
        Session sesion = sesionFactory.openSession();
        Usuarios usu = new Usuarios("22222222W","Alex","Lara", "pass",987654321,"alex@gmail.com");
        sesion.beginTransaction();
        sesion.update(usu);
        sesion.getTransaction().commit();
        sesion.close();
	}
	public void insertarUsuarios() {
		
		Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
        SessionFactory sesionFactory = config.buildSessionFactory();
        Session sesion = sesionFactory.openSession();
        sesion.beginTransaction();
        Usuarios usu = new Usuarios("11111111W","Benjz","Laradd", "passssfs",99999999,"benj@gmail.com");
		sesion.save(usu);
		sesion.getTransaction().commit();
		sesion.close();
	}
	public void borrarUsuario() {
		
		Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
        SessionFactory sesionFactory = config.buildSessionFactory();
        Session sesion = sesionFactory.openSession();
        sesion.beginTransaction();
        Usuarios usu = new Usuarios("11111111W","Benjz","Laradd", "passssfs",99999999,"benj@gmail.com");
        sesion.delete(usu);
        sesion.getTransaction().commit();
		sesion.close();
	}*/

}
