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
	
	public void sacarUsuarios() {
		
		Usuarios usu = new Usuarios();
		Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
        SessionFactory sesionFactory = config.buildSessionFactory();
        Session sesion = sesionFactory.openSession();
        List<Alojamientos> usuario = loadAllData(Alojamientos.class, sesion);
        System.out.println("Usuarios : ");
        for (int i = 0; i < usuario.size(); i++) {
        	System.out.println(i + "- " + usuario.get(i).getNombre());
        }
       
        sesion.close();
        
	}
	private static <T> List<T> loadAllData(Class<T> type, Session session) {
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<T> data = session.createQuery(criteria).getResultList();
	    return data;
	  }
	
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
	}
}
