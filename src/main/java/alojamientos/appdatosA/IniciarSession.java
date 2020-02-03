package alojamientos.appdatosA;

import java.io.File;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class IniciarSession {
	private ArrayList<Alojamientos> listaAlojamientos = new ArrayList<Alojamientos>();
	String ruta = "archivos/";
	CargaXml cargaXml = new CargaXml();
	
	public boolean Iniciar() {
		try {
			Configuration config = new Configuration().configure(new File("hibernate.cfg.xml"));
			SessionFactory sesionFactory = config.buildSessionFactory();
			Session session = sesionFactory.openSession();
			session.beginTransaction();
			listaAlojamientos = cargaXml.guardarDatosAlojamientos(ruta, listaAlojamientos);

			for (int z = 0; z < listaAlojamientos.size(); z++) {
				// ALOJAMIENTOS
				Alojamientos alojamientos = new Alojamientos();
				alojamientos.setCodAlojamiento(listaAlojamientos.get(z).getCodAlojamiento());
				alojamientos.setNombre(listaAlojamientos.get(z).getNombre());
				alojamientos.setDescripcion(listaAlojamientos.get(z).getDescripcion());

				session.saveOrUpdate(alojamientos);

			}
			listaAlojamientos.clear();
			session.getTransaction().commit();
			sesionFactory.close();
			
			BBDDJSON json = new BBDDJSON();
			json.cargaDatosBBDDAlojamientos();
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			return false;
		}
		return true;
	}
}
