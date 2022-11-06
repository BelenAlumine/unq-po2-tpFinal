package accionesGenerales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import elementosDelSistema.Desafio;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;

public abstract class TipoDeRecomendacion {

	public abstract List<Desafio> desafiosRecomendados(Usuario usuario, List<Desafio> desafios);
	
	// Ordenar los desafios del Map según su valor de coincidencia/similitud
	public  LinkedHashMap<Desafio, Float> ordenarDesafios(Map<Desafio, Float> desafios) {
		return desafios.entrySet()
		        .stream()
		        .sorted(Map.Entry.<Desafio, Float>comparingByValue())
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
	}
	
	// Devolver los primeros desafios del Map de desafios con sus coincidencias asociadas
	public List<Desafio> primerosDesafiosARecomendar(LinkedHashMap<Desafio, Float> desafios, int cantidadRequerida) {
		List<Desafio> desafiosMasCoincidentes = new ArrayList<Desafio>();
		Iterator<Desafio> iterator = desafios.keySet().iterator();
		int i = 0;
		while(i < cantidadRequerida && iterator.hasNext()) {
			i++;
			desafiosMasCoincidentes.add(iterator.next());
		}
		return desafiosMasCoincidentes;
	}
	
	// Metodo que procesa los desafios asociando cada desafio con su valor de coincidencia respecto al perfil de usuario dado
	public LinkedHashMap<Desafio, Float> desafiosConCoincidencias(PerfilUsuario perfilBase, List<Desafio> desafios) {
		LinkedHashMap<Desafio, Float> desafiosARecomendar = new LinkedHashMap<Desafio, Float>();
		for(Desafio desafioActual : desafios) {
			desafiosARecomendar.put(desafioActual, this.obtenerCoincidencias(desafioActual, perfilBase));
		}
		return desafiosARecomendar;
	}
	
	// Calculo de coincidencias entre desafio y preferencias en el perfil de usuario
	public Float obtenerCoincidencias(Desafio desafio, PerfilUsuario perfil) {
		return (float) this.diferenciaDeCaracteristicas(desafio.getMuestrasARecolectar(), perfil.getCantidadDeMuestrasARecolectar()) +
			   this.diferenciaDeCaracteristicas(desafio.getRecompensa(), perfil.getRecompensaPreferida()) +
			   this.diferenciaDeCaracteristicas(desafio.getDificultad(), perfil.getDificultadDeseada());
	}

	protected int diferenciaDeCaracteristicas(int valor1, int valor2) {
		return (Math.abs(valor1 - valor2));
	}

	

}
