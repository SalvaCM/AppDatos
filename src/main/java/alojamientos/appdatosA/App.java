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
        
        CargaXml xml = new CargaXml();
        xml.descargaXml();
        Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
        SessionFactory sesionFactory = config.buildSessionFactory();
        Session sesion = sesionFactory.openSession();
        sesion.beginTransaction();
        
        //ALOJAMIENTOS
        Alojamientos alojamiento1 = new Alojamientos();
        alojamiento1.setCodAlojamiento(1);
        alojamiento1.setNombre("Nombre Alojamiento 1");
        alojamiento1.setDescripcion("Descripción 1");
        alojamiento1.setTipo("Tipo alojamiento1");
        alojamiento1.setLocalizacion("Localizacion1");
        alojamiento1.setTelefono("666333111");
        alojamiento1.setDireccion("Dirección alojamiento1");
        alojamiento1.setLocalidad("Localidad1");
        alojamiento1.setEmail("email1");
        alojamiento1.setWeb("web1");
        alojamiento1.setCapacidad(100);
        
        sesion.save(alojamiento1);
       
        //USUARIOS
        Usuarios usuario1 = new Usuarios();
        usuario1.setDni("22222222W");
        usuario1.setNombre("Nombre1");
        usuario1.setApellidos("Apellido1");
        usuario1.setContrasena("Contrasena1");
        usuario1.setTelefono(666333221);
        usuario1.setTipoUsuario("Normal");
        
        sesion.save(usuario1);
        
        //RESERVAS
        Reservas reservas = new Reservas();
        reservas.setCodReserva(1);
        reservas.setAlojamiento(alojamiento1);
        reservas.setUsuario(usuario1);
        reservas.setFechaRealizada(Fechas.mostrarFechaActual());
        //reservas.setFechaEntrada(fechaEntrada);
        // reservas.setFechaSalida(fechaSalida);
        
       	sesion.save(reservas);
        //se comitean los cambios y se cierra la sesión
        sesion.getTransaction().commit();
        sesionFactory.close();
        
        
        
    }
}

