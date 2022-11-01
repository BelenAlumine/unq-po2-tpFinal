package accionesGenerales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import elementosDelSistema.Desafio;
import elementosDelSistema.PerfilUsuario;

public class RecomendacionDeDesafio {

	private TipoDeRecomendacion recomendacionElegida;
	
	public List<Desafio> getRecomendaciones(PerfilUsuario perfilBase) {
		LinkedHashMap<Desafio, Integer> coincidenciasAOrdenar = recomendacionElegida.desafiosConCoincidencias(perfilBase);
		coincidenciasAOrdenar = recomendacionElegida.ordenarDesafios(coincidenciasAOrdenar);
		return this.desafiosConMayorCoincidencia(coincidenciasAOrdenar);
	}
	
	private List<Desafio> desafiosConMayorCoincidencia(LinkedHashMap<Desafio, Integer> desafios) {
		List<Desafio> desafiosMasCoincidentes = new ArrayList<Desafio>();
		Iterator<Desafio> iterator = desafios.keySet().iterator();
		for (int i = 0; i < 5; i++) {
			desafiosMasCoincidentes.add(iterator.next());
		}
		return desafiosMasCoincidentes;
	}
	
	public void setTipoDeRecomendacion(TipoDeRecomendacion tipoEscogido) {
		this.recomendacionElegida = tipoEscogido;
	}
}
