package accionesDeProyecto;

import elementosDelSistema.Desafio;

public class EstadoNoRealizado extends EstadoDelDesafio {
	EstadoNoRealizado estadoNoRealizado;
	EstadoEnCurso estadoEnCurso = new EstadoEnCurso();
	
	@Override
	public void revisarEstadoDelDesafio(Desafio desafio) {
		// TODO Auto-generated method stub	
	}
	
	public void cambiarDeEstado(Desafio desafio) {
		desafio.setEstadoDelDesafio(estadoEnCurso);
	}
}