package alojamientos.appdatosA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tAlojamientos")
public class Alojamiento {
	@Id 
	@Column(name="cId")
	private int id;
	
	@Column(name="cNombre")
	private String nombre;
	
	public Alojamiento() {
		
	}
	public Alojamiento(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
