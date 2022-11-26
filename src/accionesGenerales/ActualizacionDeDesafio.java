package accionesGenerales;

import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;
import elementosDelSistema.Muestra;

public class ActualizacionDeDesafio {
	/**
	 * Clase que actualiza los desafíos cuando se carga una muestra.
	 * El método ''agregarMuestra'' en Proyecto utiliza esta clase para chequear el estado del desafio,
	 * si este se encuentra en curso, actualiza.
	 * La actualización debe incrementar en 1 la cantidad de muestras recolectadas.
	 */
	
	
	public void actualizarDesafio(DesafioDeUsuario desafio, Muestra muestra) {
		boolean esMuestraDeArea = desafio.getDesafioBase().getAreaDeDesafio().seEncuentraEnElArea(muestra.getLatitudMuestra(), muestra.getLongitudMuestra());
		boolean validoPorRestriccion = !desafio.getDesafioBase().getRestriccion().restringido(desafio);
		
		if (desafio.getEstadoDelDesafio() instanceof EstadoEnCurso && esMuestraDeArea && validoPorRestriccion) {
			desafio.sumarMuestraCargada();
			desafio.getEstadoDelDesafio().revisarEstadoDelDesafio(desafio);
		}
	 }
	
	public void actualizarMuestrasRecolectadas(DesafioDeUsuario desafio) {
		RestriccionTemporal restriccion = desafio.getDesafioBase().getRestriccion();
		
		if (!restriccion.restringido(desafio)) {
			desafio.sumarMuestraCargada();
		}
	}
}
