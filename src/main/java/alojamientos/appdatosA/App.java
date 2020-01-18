package alojamientos.appdatosA;

import java.io.File;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	private ArrayList<Alojamientos> listaAlojamientos = new ArrayList<Alojamientos>();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		App runApp = new App();

	}

	public App() {
		boolean descargar;
		System.out.println("Cargando...............................................................");
		CargaXml xml = new CargaXml();
		descargar = xml.gestionXML(); // Esto carga los xml comparando si estan o no!

		if (descargar) {
			Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
			SessionFactory sesionFactory = config.buildSessionFactory();
			Session sesion = sesionFactory.openSession();
			sesion.beginTransaction();

			for (int i = 0; i < xml.recursoXml.recursos.size(); i++) {
				if (xml.recursoXml.recursos.get(i).descargar) {
					listaAlojamientos = xml.guardarDatosAlojamientos(xml.recursoXml.recursos.get(i).getArchivoXml(),
							listaAlojamientos);

					for (int z = 0; z < listaAlojamientos.size(); z++) {
						// ALOJAMIENTOS
						Alojamientos alojamientos = new Alojamientos();
						alojamientos.setCodAlojamiento(z);
						alojamientos.setNombre(listaAlojamientos.get(z).getNombre());
						alojamientos.setDescripcion(listaAlojamientos.get(z).getDescripcion());
						alojamientos.setTipo(xml.recursoXml.recursos.get(i).getTipo());
						alojamientos.setLocalizacion(listaAlojamientos.get(z).getLocalizacion());
						alojamientos.setTelefono(listaAlojamientos.get(z).getTelefono());
						alojamientos.setDireccion(listaAlojamientos.get(z).getDireccion());
						alojamientos.setLocalidad(listaAlojamientos.get(z).getLocalidad());
						alojamientos.setEmail(listaAlojamientos.get(z).getEmail());
						alojamientos.setWeb(listaAlojamientos.get(z).getWeb());
						alojamientos.setCapacidad(listaAlojamientos.get(z).getCapacidad());
						alojamientos.setLatitud(listaAlojamientos.get(z).getLatitud());
						alojamientos.setLongitud(listaAlojamientos.get(z).getLongitud());

						sesion.saveOrUpdate(alojamientos);

					}
					listaAlojamientos.clear();
				}
			}
			// USUARIOS
			Usuarios usuarios = new Usuarios();
			usuarios.setDni("22222222W");
			usuarios.setNombre("Nombre1");
			usuarios.setApellidos("Apellido1");
			usuarios.setContrasena("Contrasena1");
			usuarios.setTelefono(666333221);
			usuarios.setEmail("default@default.com");

			sesion.saveOrUpdate(usuarios);

			// RESERVAS
			Reservas reservas = new Reservas();
			reservas.setCodReserva(1);
			reservas.setCodAlojamiento(1);
			reservas.setCodUsuario("22758295W");
			reservas.setFechaRealizada(Fechas.mostrarFechaActual());

			sesion.saveOrUpdate(reservas);
			// ADMINISTRADORES

			Administradores admin = new Administradores();
			admin.setApellidos("Halojamientos");
			admin.setContrasena("21232f297a57a5a743894a0e4a801fc3");
			admin.setDni("21232f297a57a5a743894a0e4a801fc3");
			admin.setNombre("Yon");
			admin.setTipoUsuario("admin");
			admin.setTelefono(123456789);

			sesion.saveOrUpdate(admin);

			// se comitean los cambios y se cierra la sesión
			sesion.getTransaction().commit();
			sesionFactory.close();

			BBDDJSON json = new BBDDJSON();
			json.cargaDatosBBDDAlojamientos();
			json.cargaDatosBBDDReservas();
			json.cargaDatosBBDDUsuarios();
		} else {
			// tb puede ser error en la carga asi que hay que dividirlo en dos, una si todos
			// los miembros de array dan false y otra si hay error en la descarga.
			System.out.println("La BBDD ya se encuentra actualizada -----------");
		}

	}

}
