package alojamientos.appdatosA;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// cargar la cantidad de elementos que hay en la base de datos
		int elementosBBDD = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.101.24/alojamientos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
			String sql = "SELECT count(*) FROM talojamientos";
			PreparedStatement stmt = conexion.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			elementosBBDD = rs.getInt(1);
			System.out.println(elementosBBDD);
			rs.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//si la base de datos esta vacia, que la cargue mediante los metodos que tenemos
		if(elementosBBDD == 0) {
					
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
	        }else{
	        	System.out.println("Hay datos registrados en la base de datos");
	        }
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

