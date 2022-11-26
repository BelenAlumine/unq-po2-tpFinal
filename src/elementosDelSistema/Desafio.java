package elementosDelSistema;

import java.time.LocalDate;
import accionesDeProyecto.RestriccionTemporal;

public class Desafio {
	private int muestrasARecolectar;
	private int dificultad; 
	private int recompensa;
	private AreaGeografica areaGeografica;
	LocalDate fechaActual =  LocalDate.now();
	RestriccionTemporal restriccion;

	
	public Desafio(int muestrasARecolectar, int dificultad, int recompensa, RestriccionTemporal restriccion, AreaGeografica area) {
		this.muestrasARecolectar = muestrasARecolectar;
		this.dificultad = dificultad;
		this.restriccion = restriccion;
		this.recompensa = recompensa;
		this.areaGeografica = area;
	}

	
	public AreaGeografica getAreaDeDesafio() {
		return areaGeografica;
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
	
	
	public RestriccionTemporal getRestriccion() {
		return restriccion;
	}
	
	public void setRestriccion(RestriccionTemporal restriccion) {
		this.restriccion = restriccion;
	}
	

	public LocalDate getFechaActual() {
		return fechaActual;
	}

}
