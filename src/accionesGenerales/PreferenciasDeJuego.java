package accionesGenerales;

import java.util.LinkedHashMap;
import java.util.List;

import elementosDelSistema.Desafio;
import elementosDelSistema.Usuario;


public class PreferenciasDeJuego extends TipoDeRecomendacion {
	
	@Override
	public List<Desafio> desafiosRecomendados(Usuario usuario, List<Desafio> desafios) {
		LinkedHashMap<Desafio, Integer> desafiosAComprobar = this.desafiosConCoincidencias(usuario.getPerfil(), desafios);
		return this.primerosDesafiosARecomendar(this.ordenarDesafios(desafiosAComprobar), 5);
	}

}
