package alojamientos.appdatosA;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tReservas")
public class Reservas {
	@Id 
	@Column(name="cReserva")
	private int codReserva;
	
	@Column(name="cAlojamiento")
	@OneToOne
	private Alojamientos alojamiento;

	@Column(name="cUsuario")
	@ManyToMany
	private Usuarios usuario;

	@Column(name="cFechaRealizada")
	private Date fechaRealizada;
	
	@Column(name="cFechaEntrada")
	private Date fechaEntrada;
	
	@Column(name="cFechaSalida")
	private Date fechaSalida;
	
	
	public  Reservas() {
	}


	public Reservas(int codReserva, Alojamientos alojamiento, Usuarios usuario, Date fechaRealizada, Date fechaEntrada,
			Date fechaSalida) {
		super();
		this.codReserva = codReserva;
		this.alojamiento = alojamiento;
		this.usuario = usuario;
		this.fechaRealizada = fechaRealizada;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}


	public int getCodReserva() {
		return codReserva;
	}


	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}


	public Alojamientos getAlojamiento() {
		return alojamiento;
	}


	public void setAlojamiento(Alojamientos alojamiento) {
		this.alojamiento = alojamiento;
	}


	public Usuarios getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}


	public Date getFechaRealizada() {
		return fechaRealizada;
	}


	public void setFechaRealizada(Date fechaRealizada) {
		this.fechaRealizada = fechaRealizada;
	}


	public Date getFechaEntrada() {
		return fechaEntrada;
	}


	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	
	
}
