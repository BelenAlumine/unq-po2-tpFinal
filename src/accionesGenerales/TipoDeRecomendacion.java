package accionesGenerales;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import elementosDelSistema.Desafio;
import elementosDelSistema.PerfilUsuario;

public abstract class TipoDeRecomendacion {

	// ordenarDesafios debe devolver solamente desafios ordenados en PreferenciasDeJuego y los primeros 20 en Favorito
	public abstract LinkedHashMap<Desafio, Integer> ordenarDesafios(Map<Desafio, Integer> desafios);
	
	public LinkedHashMap<Desafio, Integer> desafiosConCoincidencias(PerfilUsuario perfilBase) {
		LinkedHashMap<Desafio, Integer> desafiosARecomendar = new LinkedHashMap<Desafio, Integer>();
		List<Desafio> desafios = null; // Pasaje de todos los desafios desde sistema a procesar por coincidencias
		for(Desafio desafioActual : desafios) {
			desafiosARecomendar.put(desafioActual, this.obtenerCoincidencias(desafioActual, perfilBase));
		}
		return desafiosARecomendar;
	}
	
	public int obtenerCoincidencias(Desafio desafio, PerfilUsuario perfil) {
		return this.diferenciaDeCaracteristicas(desafio.getMuestrasARecolectar(), perfil.getCantidadDeMuestrasARecolectar()) +
			   this.diferenciaDeCaracteristicas(desafio.getRecompensa(), perfil.getRecompensaPreferida()) +
			   this.diferenciaDeCaracteristicas(desafio.getDificultad(), perfil.getDificultadDeseada());
	}
	
	private int diferenciaDeCaracteristicas(int valor1, int valor2) {
		return Math.abs(valor1 - valor2);
	}
	

}
