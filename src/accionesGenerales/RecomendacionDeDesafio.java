package accionesGenerales;


import java.util.LinkedHashMap;
import java.util.List;

import elementosDelSistema.Desafio;
import elementosDelSistema.PerfilUsuario;

public class RecomendacionDeDesafio {

	private TipoDeRecomendacion recomendacionElegida;
	
	public List<Desafio> getRecomendaciones(PerfilUsuario perfilBase) {
		LinkedHashMap<Desafio, Integer> coincidenciasAOrdenar = recomendacionElegida.desafiosConCoincidencias(perfilBase);
		coincidenciasAOrdenar = recomendacionElegida.ordenarDesafios(coincidenciasAOrdenar);
		return recomendacionElegida.desafiosRecomendados(coincidenciasAOrdenar);
	}
	
	
	public void setTipoDeRecomendacion(TipoDeRecomendacion tipoEscogido) {
		this.recomendacionElegida = tipoEscogido;
	}
}
