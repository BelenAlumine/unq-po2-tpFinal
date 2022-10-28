package elementosDelSistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Desafio {
	List<Muestra> muestrasRecolectadas = new ArrayList<Muestra>();
	int muestrasARecolectar;
	int dificultad;
	int recompensa;
	//AreaGeografica
	//EstadoDelDesafio
	LocalDate fechaActual = LocalDate.now();
	//RestriccionTemporal
	
	
	public Desafio(int muestrasARecolectar, int dificultad) {
		this.muestrasARecolectar = muestrasARecolectar;
		this.dificultad = dificultad;
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