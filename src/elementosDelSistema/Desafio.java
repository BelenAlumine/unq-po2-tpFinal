package elementosDelSistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoNoRealizado;

public class Desafio {
	List<Muestra> muestrasRecolectadas = new ArrayList<Muestra>();
	int muestrasARecolectar;
	int dificultad;
	int recompensa;
	//AreaGeografica
	EstadoDelDesafio estadoDelDesafio = new EstadoNoRealizado();
	LocalDate fechaActual = LocalDate.now();
	//RestriccionTemporal
	
	
	public Desafio(int muestrasARecolectar, int dificultad) {
		this.muestrasARecolectar = muestrasARecolectar;
		this.dificultad = dificultad;
	}


	public EstadoDelDesafio getEstadoDelDesafio() {
		return estadoDelDesafio;
	}


	public void setEstadoDelDesafio(EstadoDelDesafio estadoDelDesafio) {
		this.estadoDelDesafio = estadoDelDesafio;
	}


	public List<Muestra> getMuestrasRecolectadas() {
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


	public LocalDate getFechaActual() {
		return fechaActual;
	}
}