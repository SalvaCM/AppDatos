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
	
		int contador = 0;
		int contador2 = 0;
		  System.out.println( "Cargando..............................................................." );
	        
	        CargaXml xml = new CargaXml();
	        xml.descargaXml();
	      
	        Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
	        SessionFactory sesionFactory = config.buildSessionFactory();
	        Session sesion = sesionFactory.openSession();
	        sesion.beginTransaction();
	        
	        listaAlojamientos= xml.guardarDatosAlojamientos("archivos/apartamentos.xml",listaAlojamientos );
	        
	        for (int i = 0; i < listaAlojamientos.size(); i++) {
	        	//ALOJAMIENTOS
	        Alojamientos alojamientos = new Alojamientos();
	        alojamientos.setCodAlojamiento(i);
	        alojamientos.setNombre(listaAlojamientos.get(i).getNombre());
	        alojamientos.setDescripcion(listaAlojamientos.get(i).getDescripcion());
	        alojamientos.setTipo("Aloc");
	        alojamientos.setLocalizacion(listaAlojamientos.get(i).getLocalizacion());
	        alojamientos.setTelefono(listaAlojamientos.get(i).getTelefono());
	        alojamientos.setDireccion(listaAlojamientos.get(i).getDireccion());
	        alojamientos.setLocalidad(listaAlojamientos.get(i).getLocalidad());
	        alojamientos.setEmail(listaAlojamientos.get(i).getEmail());
	        alojamientos.setWeb(listaAlojamientos.get(i).getWeb());
	        alojamientos.setCapacidad(listaAlojamientos.get(i).getCapacidad());
	        alojamientos.setLatitud(listaAlojamientos.get(i).getLatitud());
	        alojamientos.setLongitud(listaAlojamientos.get(i).getLongitud());
	        
	        sesion.save(alojamientos);
	        contador = i;
	        }
	        
	        listaAlojamientos.clear();
	        contador++;
	        listaAlojamientos = xml.guardarDatosAlojamientos("archivos/apartamentos-rulares.xml",listaAlojamientos );
	        for (int i = 0; i < (listaAlojamientos.size()); i++) {
	        	//ALOJAMIENTOS-RULARES
	        Alojamientos alojamientos = new Alojamientos();
	        alojamientos.setCodAlojamiento(i + contador);
	        alojamientos.setNombre(listaAlojamientos.get(i).getNombre());
	        alojamientos.setDescripcion(listaAlojamientos.get(i).getDescripcion());
	        alojamientos.setTipo("Rural");
	        alojamientos.setLocalizacion(listaAlojamientos.get(i).getLocalizacion());
	        alojamientos.setTelefono(listaAlojamientos.get(i).getTelefono());
	        alojamientos.setDireccion(listaAlojamientos.get(i).getDireccion());
	        alojamientos.setLocalidad(listaAlojamientos.get(i).getLocalidad());
	        alojamientos.setEmail(listaAlojamientos.get(i).getEmail());
	        alojamientos.setWeb(listaAlojamientos.get(i).getWeb());
	        alojamientos.setCapacidad(listaAlojamientos.get(i).getCapacidad());
	        alojamientos.setLatitud(listaAlojamientos.get(i).getLatitud());
	        alojamientos.setLongitud(listaAlojamientos.get(i).getLongitud());
	        
	        sesion.save(alojamientos);
	        contador2 = i + contador;
	        }
	        listaAlojamientos.clear();
	        contador2++;
	        listaAlojamientos = xml.guardarDatosAlojamientos("archivos/apartamentos-camping.xml",listaAlojamientos );
	        for (int i = 0; i < (listaAlojamientos.size()); i++) {
	        	//ALOJAMIENTOS-CAMPING
	        Alojamientos alojamientos = new Alojamientos();
	        alojamientos.setCodAlojamiento(i + contador2);
	        alojamientos.setNombre(listaAlojamientos.get(i).getNombre());
	        alojamientos.setDescripcion(listaAlojamientos.get(i).getDescripcion());
	        alojamientos.setTipo("Camping");
	        alojamientos.setLocalizacion(listaAlojamientos.get(i).getLocalizacion());
	        alojamientos.setTelefono(listaAlojamientos.get(i).getTelefono());
	        alojamientos.setDireccion(listaAlojamientos.get(i).getDireccion());
	        alojamientos.setLocalidad(listaAlojamientos.get(i).getLocalidad());
	        alojamientos.setEmail(listaAlojamientos.get(i).getEmail());
	        alojamientos.setWeb(listaAlojamientos.get(i).getWeb());
	        alojamientos.setCapacidad(listaAlojamientos.get(i).getCapacidad());
	        alojamientos.setLatitud(listaAlojamientos.get(i).getLatitud());
	        alojamientos.setLongitud(listaAlojamientos.get(i).getLongitud());
	        
	        sesion.save(alojamientos);
	        }
	        
	       
	        //USUARIOS
	        Usuarios usuarios = new Usuarios();
	        usuarios.setDni("22222222W");
	        usuarios.setNombre("Nombre1");
	        usuarios.setApellidos("Apellido1");
	        usuarios.setContrasena("Contrasena1");
	        usuarios.setTelefono(666333221);
	        usuarios.setEmail("default@default.com");
	        
	        sesion.save(usuarios);
	        
	        //RESERVAS
	        Reservas reservas = new Reservas();
	        reservas.setCodReserva(1);
	        reservas.setCodAlojamiento(1);
	        reservas.setCodUsuario("22758295W");
	        reservas.setFechaRealizada(Fechas.mostrarFechaActual());
	        
	      	sesion.save(reservas);
	        //ADMINISTRADORES
	        
	        Administradores admin = new Administradores();
	        admin.setApellidos("21232f297a57a5a743894a0e4a801fc3");
	        admin.setContrasena("21232f297a57a5a743894a0e4a801fc3");
	        admin.setDni("21232f297a57a5a743894a0e4a801fc3");
	        admin.setNombre("21232f297a57a5a743894a0e4a801fc3");
	        admin.setTipoUsuario("admin");
	        admin.setTelefono(123456789);
	        
	        sesion.save(admin);

	        //se comitean los cambios y se cierra la sesión
	        sesion.getTransaction().commit();
	        sesionFactory.close(); 
	        
	        BBDDJSON json = new BBDDJSON();
	        json.cargaDatosBBDDAlojamientos();
	        json.cargaDatosBBDDReservas();
	        json.cargaDatosBBDDUsuarios();
	}
    public static void main( String[] args )
    {
      App app = new App();
        
    }
}

