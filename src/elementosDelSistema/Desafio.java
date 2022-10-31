package elementosDelSistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionTemporal;

public class Desafio {
	int muestrasRecolectadas = 0;
	int muestrasARecolectar;
	int dificultad;
	int recompensa;
	//AreaGeografica
	EstadoDelDesafio estadoDelDesafio = new EstadoNoRealizado();
	LocalDate fechaActual = LocalDate.now();
	RestriccionTemporal restriccion;
	boolean desafioRestingido;
	
	
	public Desafio(int muestrasARecolectar, int dificultad, RestriccionTemporal restriccion) {
		this.muestrasARecolectar = muestrasARecolectar;
		this.dificultad = dificultad;
		this.restriccion = restriccion;
	}


	public int getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}


	public boolean isDesafioRestingido() {
		return desafioRestingido;
	}


	public void setDesafioRestingido(boolean desafioRestingido) {
		this.desafioRestingido = desafioRestingido;
	}


	public RestriccionTemporal getRestriccion() {
		return restriccion;
	}


	public void setRestriccion(RestriccionTemporal restriccion) {
		this.restriccion = restriccion;
	}


	public EstadoDelDesafio getEstadoDelDesafio() {
		return estadoDelDesafio;
	}


	public void setEstadoDelDesafio(EstadoDelDesafio estadoDelDesafio) {
		this.estadoDelDesafio = estadoDelDesafio;
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


	public LocalDate getFechaActual() {
		return fechaActual;
	}
	
	public int sumarMuestraCargada() {
		return muestrasRecolectadas++;
	}
}
