package alojamientos.appdatosA;

import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;

public class objetosTest {
	
	
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
	
	
}
