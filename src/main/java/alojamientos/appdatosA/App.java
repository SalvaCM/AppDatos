package alojamientos.appdatosA;

import java.io.File;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public ArrayList<Alojamientos> listaAlojamientos = new ArrayList<Alojamientos>();
	public App() {
	
		
		  System.out.println( "Cargando..............................................................." );
	        
	        CargaXml xml = new CargaXml();
	        xml.descargaXml();
	        xml.leerXml("archivos/apartamentos.xml");
	        
	        listaAlojamientos= xml.guardarDatosAlojamientos("archivos/apartamentos.xml",listaAlojamientos );
			for (int i = 0; i < listaAlojamientos.size(); i++) {
				System.out.println(listaAlojamientos.get(i).getNombre());
			}
	        
	       Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
	        SessionFactory sesionFactory = config.buildSessionFactory();
	        Session sesion = sesionFactory.openSession();
	        sesion.beginTransaction();
	        
//	        //ALOJAMIENTOS
//	        Alojamientos alojamientos = new Alojamientos();
//	        alojamientos.setCodAlojamiento(1);
//	        alojamientos.setNombre("Nombre Alojamiento 1");
//	        alojamientos.setDescripcion("Descripción 1");
//	        alojamientos.setTipo("Tipo alojamiento1");
//	        alojamientos.setLocalizacion("Localizacion1");
//	        alojamientos.setTelefono("666333111");
//	        alojamientos.setDireccion("Dirección alojamiento1");
//	        alojamientos.setLocalidad("Localidad1");
//	        alojamientos.setEmail("benjas2");
//	        alojamientos.setWeb("web1");
//	        alojamientos.setCapacidad(100);
//	        
//	        sesion.save(alojamientos);
	        
	        for (int i = 0; i < listaAlojamientos.size(); i++) {
	        	//ALOJAMIENTOS
	        Alojamientos alojamientos = new Alojamientos();
	        alojamientos.setCodAlojamiento(i);
	        alojamientos.setNombre("Nombre Alojamiento 1");
	        alojamientos.setDescripcion("Descripción 1");
	        alojamientos.setTipo("Tipo alojamiento1");
	        alojamientos.setLocalizacion("Localizacion1");
	        alojamientos.setTelefono("666333111");
	        alojamientos.setDireccion("Dirección alojamiento1");
	        alojamientos.setLocalidad("Localidad1");
	        alojamientos.setEmail("benjas2");
	        alojamientos.setWeb("web1");
	        alojamientos.setCapacidad(100);
	        
	        sesion.save(alojamientos);
	        }
	        
	       
	        //USUARIOS
	        Usuarios usuarios = new Usuarios();
	        usuarios.setDni("22222222W");
	        usuarios.setNombre("Nombre1");
	        usuarios.setApellidos("Apellido1");
	        usuarios.setContrasena("Contrasena1");
	        usuarios.setTelefono(666333221);
	        usuarios.setTipoUsuario("Normal");
	        
	        sesion.save(usuarios);
	        
	        //RESERVAS
	        Reservas reservas = new Reservas();
	        reservas.setCodReserva(1);
	        reservas.setCodAlojamiento(1);
	        reservas.setCodUsuario(1);
	        reservas.setFechaRealizada(Fechas.mostrarFechaActual());
	        //reservas.setFechaEntrada(fechaEntrada);
	        // reservas.setFechaSalida(fechaSalida);
	        
	       	sesion.save(reservas);
	        //se comitean los cambios y se cierra la sesión
	        sesion.getTransaction().commit();
	        sesionFactory.close(); 
	        
	        
	}
    public static void main( String[] args )
    {
      App app = new App();
        
    }
}

