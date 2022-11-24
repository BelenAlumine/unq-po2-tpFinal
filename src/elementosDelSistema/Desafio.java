package elementosDelSistema;

import java.time.LocalDate;
import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.ValoracionDesafio;

public class Desafio {
//  Lo que esta comentado es lo que se descarta de Desafio y estará en DesafioDeUsuario	
//	private int muestrasRecolectadas = 0;
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
//		this.valoracion = new ValoracionDesafio();
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

//	public boolean isDesafioRestringido() {
//	return desafioRestringido;
//}
//
//	public void setDesafioRestringido(boolean desafioRestringido) {
//	this.desafioRestringido = desafioRestringido;
//}
	
//	public EstadoDelDesafio getEstadoDelDesafio() {
//	return estadoDelDesafio;
//}
//
//public void setEstadoDelDesafio(EstadoDelDesafio estadoDelDesafio) {
//	this.estadoDelDesafio = estadoDelDesafio;
//}

	
//	public int sumarMuestraCargada() {
//		return muestrasRecolectadas++;
//	}
	
//	public void agregarVotacion(int votacion) throws Exception {
//		valoracion.agregarValoracion(votacion);
//	}
//	
//	public int getVotacion() {
//		return valoracion.obtenerValoracion();
//	}

	
//	public boolean leFaltanMuestrasARecolectar() {
//		return this.getMuestrasARecolectar() > this.getMuestrasRecolectadas();
//	}
//	
//	public boolean esUnDesafioCompletado() {
//		return this.getMuestrasARecolectar() == this.getMuestrasRecolectadas();
//	}
//	
//	public float porcentajeDeCompletitud() {
//		return ((float) this.muestrasRecolectadas / this.muestrasARecolectar) * 100;
//	}

}
