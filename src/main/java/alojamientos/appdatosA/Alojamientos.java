package alojamientos.appdatosA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tAlojamientos")
public class Alojamientos {
	@Id 
	@Column(name="cCodAlojamiento")
	private int codAlojamiento;
	
	@Column(name="cNombre")
	private String nombre;
	
	@Column(name="cDescripcion")
	private String descripcion;
	
	
	public Alojamientos() {
		
	}

	public Alojamientos(int codAlojamiento, String nombre, String descripcion, String tipo, String localizacion,
			String telefono, String direccion, String localidad, String email, String web, int capacidad, String latitud, String longitud) {
		super();
		this.codAlojamiento = codAlojamiento;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getCodAlojamiento() {
		return codAlojamiento;
	}

	public void setCodAlojamiento(int codAlojamiento) {
		this.codAlojamiento = codAlojamiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
