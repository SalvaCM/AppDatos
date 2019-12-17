package alojamientos.appdatosA;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Cargando..............................................................." );
        
        Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
        SessionFactory sesionFactory = config.buildSessionFactory();
        Session sesion = sesionFactory.openSession();
        sesion.beginTransaction();
        
        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setId(1);
        alojamiento.setNombre("Aloj1");
        
        sesion.save(alojamiento);
        sesion.getTransaction().commit();
        sesionFactory.close();
        
    }
}
