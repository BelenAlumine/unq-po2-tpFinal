package accionesGenerales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import elementosDelSistema.Desafio;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;

public abstract class TipoDeRecomendacion {

	protected abstract List<Desafio> desafiosRecomendados(Usuario usuario);
	
	public  LinkedHashMap<Desafio, Integer> ordenarDesafios(Map<Desafio, Integer> desafios) {
		return desafios.entrySet()
		        .stream()
		        .sorted(Map.Entry.<Desafio, Integer>comparingByValue())
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
	}
	
	public List<Desafio> desafiosConMayorCoincidencia(LinkedHashMap<Desafio, Integer> desafios, int cantidadDeCoincidencias) {
		List<Desafio> desafiosMasCoincidentes = new ArrayList<Desafio>();
		Iterator<Desafio> iterator = desafios.keySet().iterator();
		for (int i = 0; i < cantidadDeCoincidencias; i++) {
			desafiosMasCoincidentes.add(iterator.next());
		}
		return desafiosMasCoincidentes;
	}
	
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

	protected int diferenciaDeCaracteristicas(int valor1, int valor2) {
		return Math.abs(valor1 - valor2);
	}


	
	

}
