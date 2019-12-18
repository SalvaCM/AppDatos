package alojamientos.appdatosA;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tReservas")
public class Reservas {
	@Id 
	@Column(name="cReserva")
	private int codReserva;
	
	@Column(name="cCodAlojamiento")
	private int codAlojamiento;

	@Column(name="cCodUsuario")
	private int codUsuario;

	@Column(name="cFechaRealizada")
	private Date fechaRealizada;
	
	@Column(name="cFechaEntrada")
	private Date fechaEntrada;
	
	@Column(name="cFechaSalida")
	private Date fechaSalida;
	
	
	public  Reservas() {
	}


	public Reservas(int codReserva, int codAlojamiento, int codUsuario, Date fechaRealizada, Date fechaEntrada,
			Date fechaSalida) {
		super();
		this.codReserva = codReserva;
		this.codAlojamiento = codAlojamiento;
		this.codUsuario = codUsuario;
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


	public int getCodAlojamiento() {
		return codAlojamiento;
	}


	public void setCodAlojamiento(int i) {
		this.codAlojamiento = i;
	}


	public int getCodUsuario() {
		return codUsuario;
	}


	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
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
