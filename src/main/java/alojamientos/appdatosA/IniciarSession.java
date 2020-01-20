package alojamientos.appdatosA;

import java.io.File;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class IniciarSession {
	private ArrayList<Alojamientos> listaAlojamientos = new ArrayList<Alojamientos>();
	String ruta = "archivos/";

	public boolean Iniciar(CargaXml xml) {
		try {
			Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
			SessionFactory sesionFactory = config.buildSessionFactory();
			Session session = sesionFactory.openSession();
			session.beginTransaction();

			for (int i = 0; i < xml.recursoXml.recursos.size(); i++) {
				if (xml.recursoXml.recursos.get(i).descargar) {
					listaAlojamientos = xml.guardarDatosAlojamientos(
							ruta + xml.recursoXml.recursos.get(i).getArchivoXml(), listaAlojamientos);

					for (int z = 0; z < listaAlojamientos.size(); z++) {
						// ALOJAMIENTOS
						Alojamientos alojamientos = new Alojamientos();
						alojamientos.setCodAlojamiento(listaAlojamientos.get(z).getCodAlojamiento());
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

						session.saveOrUpdate(alojamientos);

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

			session.saveOrUpdate(usuarios);

			// RESERVAS
			Reservas reservas = new Reservas();
			reservas.setCodReserva(1);
			reservas.setCodAlojamiento(1);
			reservas.setCodUsuario("22758295W");
			reservas.setFechaRealizada(Fechas.mostrarFechaActual());

			session.saveOrUpdate(reservas);
			// ADMINISTRADORES

			Administradores admin = new Administradores();
			admin.setApellidos("Halojamientos");
			admin.setContrasena("21232f297a57a5a743894a0e4a801fc3");
			admin.setDni("21232f297a57a5a743894a0e4a801fc3");
			admin.setNombre("Yon");
			admin.setTipoUsuario("admin");
			admin.setTelefono(123456789);

			session.saveOrUpdate(admin);

			// se comitean los cambios y se cierra la sesión
			session.getTransaction().commit();
			sesionFactory.close();

			BBDDJSON json = new BBDDJSON();
			json.cargaDatosBBDDAlojamientos();
			json.cargaDatosBBDDReservas();
			json.cargaDatosBBDDUsuarios();
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			return false;
		}
		return true;
	}
}
