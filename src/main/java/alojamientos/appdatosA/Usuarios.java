package alojamientos.appdatosA;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tUsuarios")
public class Usuarios {
	@Id 
	@Column(name="cDni")
	private String dni;
	
	@Column(name="cNombre")
	private String nombre;
	
	@Column(name="cApellidos")
	private String apellidos;
	
	@Column(name="cContrasena")
	private String contrasena;
	
	@Column(name="cTelefono")
	private int telefono;
	
	@Column(name="cEmail")
	private String email;
	
	public Usuarios() {
		
	}

	public Usuarios(String dni, String nombre, String apellidos, String contrasena, int telefono, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
