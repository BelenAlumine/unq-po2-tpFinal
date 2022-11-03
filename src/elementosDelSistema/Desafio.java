package elementosDelSistema;

import java.time.LocalDate;
import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoFinalizado;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionTemporal;

public class Desafio {
	int muestrasRecolectadas = 0;
	int muestrasARecolectar;
	int dificultad; //agregar un throw exception para que la dificultad no pueda ser m�s de 5
	int recompensa;
	//AreaGeografica
	EstadoDelDesafio estadoDelDesafio = new EstadoNoRealizado();
	LocalDate fechaActual = LocalDate.now();
	RestriccionTemporal restriccion;
	boolean desafioRestingido = true;
	private int votacionDeUsuario = 0;
	
	
	public Desafio(int muestrasARecolectar, int dificultad, RestriccionTemporal restriccion) {
		this.muestrasARecolectar = muestrasARecolectar;
		this.dificultad = dificultad;
		this.restriccion = restriccion;
	}
	
	public Desafio(int muestrasARecolectar, int dificultad, int recompensa, RestriccionTemporal restriccion) {
		this.muestrasARecolectar = muestrasARecolectar;
		this.dificultad = dificultad;
		this.restriccion = restriccion;
		this.recompensa = recompensa;
	}


	public int getMuestrasARecolectar() {
		return muestrasARecolectar;
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
	
	public void setVotacionDeUsuario(int votacion) {
		this.votacionDeUsuario = votacion;
	}
	
	public int getVotacionDeUsuario() {
		return votacionDeUsuario;
	}
	
//	public boolean esUnDesafioEnCurso() {
//		EstadoEnCurso estadoBuscado = new EstadoEnCurso(); 
//		return (estadoBuscado).equals(this.getEstadoDelDesafio());
//	}
//	
//	public boolean esUnDesafioFinalizado() {
//		EstadoDelDesafio estadoBuscado = new EstadoFinalizado(); 
//		return (this.getEstadoDelDesafio()).equals(new EstadoFinalizado());
//	}
	
	public boolean leFaltanMuestrasARecolectar() {
		return this.getMuestrasARecolectar() > this.getMuestrasRecolectadas();
	}
	
	public boolean esUnDesafioCompletado() {
		return this.getMuestrasARecolectar() == this.getMuestrasRecolectadas();
	}
}
