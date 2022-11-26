package accionesDeProyecto;

import elementosDelSistema.DesafioDeUsuario;

public abstract class EstadoDelDesafio {
	
	public abstract void revisarEstadoDelDesafio(DesafioDeUsuario desafio);
	public abstract void cambiarDeEstado(DesafioDeUsuario desafio);
}
