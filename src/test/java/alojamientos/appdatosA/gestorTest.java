package alojamientos.appdatosA;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class gestorTest  {
	GestorArchivos gestor = new GestorArchivos();
	CargaXml xml = new CargaXml();
	DatosXml datos = new DatosXml();
	@Before
	public void PrepararTest() // Probar con before y after
	{
		xml.descargaXml("archivos/temp/", datos.getArchivo1(), datos.getUrl1());
		xml.descargaXml("archivos/temp/", datos.getArchivo2(), datos.getUrl2());
		xml.descargaXml("archivos/temp/", datos.getArchivo3(), datos.getUrl3());
	}
	@Test
	public void borrarFicheroTest() { 
		boolean borrado;
		borrado = gestor.borrarFichero(datos.getArchivo1(),"archivos/");
		assertTrue(borrado);
	}
	@Test
	public void borrarFicheroTest2() { 
		boolean noBorrado;
		noBorrado = gestor.borrarFichero("Inexistente","archivos/");

		assertFalse(noBorrado);
	}

	@Test
	public void comparar() {
		boolean iguales1,iguales2,iguales3;
		iguales1 = gestor.comparar("archivos/apartamentos.xml","archivos/apartamentos.xml");
		iguales2 = gestor.comparar("archivos/apartamentos.xml","archivos/apartamentos-rulares.xml");
		iguales3 =  gestor.comparar("","");
		
		assertTrue(iguales1);
		assertFalse(iguales2);
		assertFalse(iguales3);
	}
	@Test
	public void existeFicheroTest() {
		boolean existe1,existe2;
		existe1 = gestor.exitenArchivos("apartamentos-camping.xml");
		existe2 = gestor.exitenArchivos("inexistente.xml");
		
		assertTrue(existe1);
		assertFalse(existe2);
		
	}
	@Test
	public void moverFicheroTest() {
		boolean movido1;
		movido1 = gestor.moverFichero("apartamentos-camping.xml");
	
		assertTrue(movido1);
	}
	@Test
	public void moverFicheroTestBad() {
		boolean movido2;
		movido2 = gestor.exitenArchivos("inexistent");
		
		assertFalse(movido2);
	}
	//
	@After
	public void descargarFicheros() // Probar con before y after
	{
		xml.descargaXml("archivos/", datos.getArchivo1(), datos.getUrl1());
	}
	@Test
	public void testAdmins() {
		Administradores admins = new Administradores("1", "nombre", "apellidos", "contrasena", 123456789, "admin");
		Administradores admins2 = new Administradores();
		admins2.setNombre(admins.getNombre());
		admins2.setApellidos(admins.getApellidos());
		admins2.setDni(admins.getDni());
		admins2.setTelefono(admins.getTelefono());
		admins2.setTipoUsuario(admins.getTipoUsuario());		
		admins2.setContrasena(admins.getContrasena());
		assertNotEquals(admins, admins2);
	}
	
	@Test
	public void testAlojamientos() {
		Alojamientos aloja = new Alojamientos(0, "n","des", "tipo", "localizacion", "323", "direccion", "localidad", "email", "web",22, "32,0.222222","0.222222222");
		Alojamientos aloja2 = new Alojamientos();
		aloja2.setCapacidad(aloja.getCapacidad());
		aloja2.setCodAlojamiento(aloja.getCodAlojamiento());
		aloja2.setDescripcion(aloja.getDescripcion());
		aloja2.setDireccion(aloja.getDireccion());
		aloja2.setEmail(aloja.getEmail());
		aloja2.setLocalidad(aloja.getLocalidad());
		aloja2.setLatitud(aloja.getLatitud());
		aloja2.setLocalizacion(aloja.getLocalizacion());
		aloja2.setLongitud(aloja.getLongitud());
		aloja2.setEmail(aloja.getEmail());
		aloja2.setTipo(aloja.getTipo());
		aloja2.setWeb(aloja.getWeb());
		aloja2.setTelefono(aloja.getTelefono());
		aloja2.setNombre(aloja.getNombre());
		assertNotEquals(aloja, aloja2);
	}
	@Test
	public void testReservas() {
		Reservas reserva = new Reservas();
		Reservas reserva2 = new Reservas(1,1, "1", new Date(), new Date(), new Date());
		reserva.setCodAlojamiento(reserva2.getCodAlojamiento());
		reserva.setCodReserva(reserva2.getCodReserva());
		reserva.setCodUsuario(reserva2.getCodUsuario());
		reserva.setFechaEntrada(reserva2.getFechaEntrada());
		reserva.setFechaRealizada(reserva2.getFechaRealizada());
		reserva.setFechaSalida(reserva2.getFechaSalida());
		assertNotEquals(reserva, reserva2);
	}
	@Test
	public void testUsuario() {
		Usuarios usuario = new Usuarios("dni", "nombre", "apellidos", "contrasena", 123123123,"as@as.com");
		Usuarios usuario2 = new Usuarios();
		usuario2.setDni(usuario.getDni());
		usuario2.setNombre(usuario.getNombre());
		usuario2.setApellidos(usuario.getApellidos());
		usuario2.setTelefono(usuario.getTelefono());
		usuario2.setEmail(usuario.getEmail());
		usuario2.setContrasena(usuario.getContrasena());
		assertNotEquals(usuario,usuario2);
	}
	CargaXml carga = new CargaXml();

	 ArrayList<Alojamientos> listaAlojamientosTest = new ArrayList<Alojamientos>();
	@Before
	public void prepararTest() {
		GestorArchivos gestor = new GestorArchivos();
		gestor.borrarFichero(datos.getArchivo1(), "archivos/");
		 carga.guardarDatosAlojamientos("archivos/"+datos.getArchivo2(), listaAlojamientosTest);
		File file = new File("archivos/"+datos.getArchivo2());

			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedWriter bf = new BufferedWriter(fw);
			try {
				bf.write("<aguita de coco>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	@Test
	public void gestionXmlTest() {
		boolean actualizar,noActualizar;
		actualizar = carga.gestionXML();
		noActualizar= carga.gestionXML();
		
		assertTrue(actualizar);
		assertFalse(noActualizar);
		
	}
	@Test
	public void leerXmlTest() {
		
		boolean leerOk,leerNotOk;
		
		leerOk =carga.leerXml("archivos/"+datos.getArchivo3());
		assertTrue(leerOk);
		
		leerNotOk= carga.leerXml("archivos/");
		assertFalse(leerNotOk);
		
	}
	@Test
	public void guardarAlojamientosTest() {
		 ArrayList<Alojamientos> listaAlojamientos = new ArrayList<Alojamientos>();
		 carga.guardarDatosAlojamientos("archivos/"+datos.getArchivo3(), listaAlojamientos);
		 assertSame(listaAlojamientos, listaAlojamientosTest);
		 
	}
	@Test
	public void appTest() {
		App app = new App();
		
	}
}
