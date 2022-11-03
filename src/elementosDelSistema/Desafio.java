package elementosDelSistema;

import java.time.LocalDate;
import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionTemporal;

public class Desafio {
	int muestrasRecolectadas = 0;
	int muestrasARecolectar;
	int dificultad; //agregar un throw exception para que la dificultad no pueda ser m�s de 5
	int recompensa;
	AreaGeografica areaGeografica;
	EstadoDelDesafio estadoDelDesafio = new EstadoNoRealizado();
	LocalDate fechaActual = LocalDate.now();
	RestriccionTemporal restriccion;
	boolean desafioRestringido = false;
	private int votacionDeUsuario;
	
	
	public Desafio(int muestrasARecolectar, int dificultad, RestriccionTemporal restriccion, AreaGeografica areaGeografica) {
		this.muestrasARecolectar = muestrasARecolectar;
		this.dificultad = dificultad;
		this.restriccion = restriccion; 
		this.areaGeografica = areaGeografica;
	}

	
	public int getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}

	public int getMuestrasARecolectar() {
		return muestrasARecolectar;
	}

	public int getDificultad() {
		return dificultad;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public EstadoDelDesafio getEstadoDelDesafio() {
		return estadoDelDesafio;
	}

	public void setEstadoDelDesafio(EstadoDelDesafio estadoDelDesafio) {
		this.estadoDelDesafio = estadoDelDesafio;
	}

	public LocalDate getFechaActual() {
		return fechaActual;
	}
	
	public boolean isDesafioRestringido() {
		return desafioRestringido;
	}

	public void setDesafioRestringido(boolean desafioRestringido) {
		this.desafioRestringido = desafioRestringido;
	}


	public RestriccionTemporal getRestriccion() {
		return restriccion;
	}


	public void setRestriccion(RestriccionTemporal restriccion) {
		this.restriccion = restriccion;
	}

	
	public int sumarMuestraCargada() {
		return muestrasRecolectadas++;
	}
	
	public void setVotacionDeUsuario(int votacion) {
		this.votacionDeUsuario = votacion;
	}
	
	public int getVotacionDeUsuario() {
		return votacionDeUsuario;
	}
}
