package accionesDeProyecto;

import elementosDelSistema.DesafioDeUsuario;

public class EstadoNoRealizado extends EstadoDelDesafio {
	EstadoNoRealizado estadoNoRealizado;
	EstadoEnCurso estadoEnCurso = new EstadoEnCurso();
	
	@Override
	public void revisarEstadoDelDesafio(DesafioDeUsuario desafio) {
		// TODO Auto-generated method stub	
	}
	
	public void cambiarDeEstado(DesafioDeUsuario desafio) {
		desafio.setEstadoDelDesafio(estadoEnCurso);
	}
}