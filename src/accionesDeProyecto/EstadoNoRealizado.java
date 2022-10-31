package accionesDeProyecto;

import elementosDelSistema.Desafio;

public class EstadoNoRealizado extends EstadoDelDesafio {
	EstadoNoRealizado estadoNoRealizado;
	EstadoEnCurso estadoEnCurso = new EstadoEnCurso();
	
	public void revisarEstadoDelDesafio(Desafio desafio) {
		//Indicar de alguna forma si el desaío está aceptado, y chequear, si no lo está
		//mantener estado actual, sino, pasar a EstadoEnCurso
		//this.cambiarDeEstado(desafio);
		
	}
	
	public void cambiarDeEstado(Desafio desafio) {
		
		desafio.setEstadoDelDesafio(estadoEnCurso);
	}
}