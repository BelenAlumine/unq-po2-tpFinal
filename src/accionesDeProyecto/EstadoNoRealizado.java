package accionesDeProyecto;

import elementosDelSistema.Desafio;

public class EstadoNoRealizado extends EstadoDelDesafio {
	EstadoNoRealizado estadoNoRealizado;
	EstadoEnCurso estadoEnCurso = new EstadoEnCurso();
	
	public void revisarEstadoDelDesafio(Desafio desafio) {
		//Indicar de alguna forma si el desa�o est� aceptado, y chequear, si no lo est�
		//mantener estado actual, sino, pasar a EstadoEnCurso
		//this.cambiarDeEstado(desafio);
	}
	
	public void cambiarDeEstado(Desafio desafio) {
		
		System.out.println("yyyy, entr� o no?");
		desafio.setEstadoDelDesafio(estadoEnCurso);
		System.out.println("Ac� deber�a cambiar esta vrg");
	}
}