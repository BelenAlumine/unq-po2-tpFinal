package accionesGenerales;

import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.Desafio;

public class ActualizacionDeDesafio {
	/**
	 * Clase que actualiza los desaf�os cu�ndo se carga una muestra.
	 * El m�todo ''agregarMuestra'' en Proyecto utiliza esta clase para chequear el estado del desafio,
	 * si este se encuentra en curso, actualiza.
	 * La actualizaci�n debe incrementar en 1 la cantidad de muestras recolectadas.
	 */
	
	
	public void actualizarDesafio(Desafio desafio) {
		if (desafio.getEstadoDelDesafio() instanceof EstadoEnCurso) {
			desafio.sumarMuestraCargada();
		}
	 }
	
	public void actualizarMuestrasRecolectadas(Desafio desafio) {
		RestriccionTemporal restriccion = desafio.getRestriccion();
		
		if (restriccion.restringido(desafio)) {
			desafio.sumarMuestraCargada();
		}
	}
}
