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
        
        //ALOJAMIENTOS
        Alojamientos alojamientos = new Alojamientos();
        alojamientos.setCodAlojamiento(1);
        alojamientos.setNombre("Nombre Alojamiento 1");
        alojamientos.setDescripcion("Descripción 1");
        alojamientos.setTipo("Tipo alojamiento1");
        alojamientos.setLocalizacion("Localizacion1");
        alojamientos.setTelefono("666333111");
        alojamientos.setDireccion("Dirección alojamiento1");
        alojamientos.setLocalidad("Localidad1");
        alojamientos.setEmail("email1");
        alojamientos.setWeb("web1");
        alojamientos.setCapacidad(100);
        
        sesion.save(alojamientos);
        sesion.getTransaction().commit();
   
        //USUARIOS
        Usuarios usuarios = new Usuarios();
        usuarios.setDni("22222222W");
        usuarios.setNombre("Nombre1");
        usuarios.setApellidos("Apellido1");
        usuarios.setContrasena("Contrasena1");
        usuarios.setTelefono(666333221);
        usuarios.setTipoUsuario("Normal");
        
        sesion.save(usuarios);
        sesion.getTransaction().commit();
        sesionFactory.close();
        
    }
}

