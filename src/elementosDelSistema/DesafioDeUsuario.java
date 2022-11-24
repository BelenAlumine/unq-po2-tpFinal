package elementosDelSistema;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoNoRealizado;
import accionesGenerales.ValoracionDesafio;

public class DesafioDeUsuario {

	private Desafio desafioBase;
	private int muestrasRecolectadas = 0;
	private ValoracionDesafio valoracion;
	private boolean desafioRestringido = false;
	private EstadoDelDesafio estadoDelDesafio = new EstadoNoRealizado();
	
	public DesafioDeUsuario(Desafio desafioBase) {
		this.desafioBase = desafioBase;
		this.valoracion = new ValoracionDesafio();
	}
	
	public Desafio getDesafioBase() {
		return desafioBase;
	}
	
	public int getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}
	
	// Estado de restricción de desafio
	
	public boolean isDesafioRestringido() {
		return desafioRestringido;
	}
	
	public void setDesafioRestringido(boolean desafioRestringido) {
		this.desafioRestringido = desafioRestringido;
	}
	
	// Estado del desafio
	
	public EstadoDelDesafio getEstadoDelDesafio() {
		return estadoDelDesafio;
	}

	public void setEstadoDelDesafio(EstadoDelDesafio estadoDelDesafio) {
		this.estadoDelDesafio = estadoDelDesafio;
	}
	
	
	// Valoraciones
	
	public void agregarVotacion(int votacion) throws Exception {
		valoracion.agregarValoracion(votacion);
	}
	
	public int getVotacion() {
		return valoracion.obtenerValoracion();
	}
	
	// Completitud de desafio
	
	public int sumarMuestraCargada() {
		// Falta la condición para sumar la muestra quizas, o puede que en otro lado
		return muestrasRecolectadas++;
	}
	
	public boolean leFaltanMuestrasARecolectar() {
		return desafioBase.getMuestrasARecolectar() > this.getMuestrasRecolectadas();
	}
	
	public boolean esUnDesafioCompletado() {
		return desafioBase.getMuestrasARecolectar() == this.getMuestrasRecolectadas();
	}
	
	public float porcentajeDeCompletitud() {
		return ((float) this.muestrasRecolectadas / desafioBase.getMuestrasARecolectar()) * 100;
	}
}
