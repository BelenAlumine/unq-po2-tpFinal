package accionesDeProyecto;

import elementosDelSistema.Desafio;

public abstract class EstadoDelDesafio {
	//Desafio desafio;
	
	public abstract void revisarEstadoDelDesafio(Desafio desafio);
	public abstract void cambiarDeEstado(Desafio desafio);
}
