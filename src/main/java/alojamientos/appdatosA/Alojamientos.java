package alojamientos.appdatosA;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

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
	
	@Column(name="cTipo")
	private String tipo;
	
	@Column(name="cLocalizacion")
	private String localizacion;
	
	@Column(name="cTelefono")
	private String telefono;
	
	@Column(name="cDireccion")
	private String direccion;
	
	@Column(name="cLocalidad")
	private String localidad;
	
	@Column(name="cEmail")
	private String email;
	
	@Column(name="cWeb")
	private String web;
	
	@Column(name="cCapacidad")
	private int capacidad;
	
	public Alojamientos() {
		
	}

	public Alojamientos(int codAlojamiento, String nombre, String descripcion, String tipo, String localizacion,
			String telefono, String direccion, String localidad, String email, String web, int capacidad) {
		super();
		this.codAlojamiento = codAlojamiento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.localizacion = localizacion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.localidad = localidad;
		this.email = email;
		this.web = web;
		this.capacidad = capacidad;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int i) {
		this.capacidad = i;
	}
	

	
}
