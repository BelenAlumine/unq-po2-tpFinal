package accionesGenerales;

import java.util.LinkedHashMap;
import java.util.List;

import elementosDelSistema.Desafio;
import elementosDelSistema.Usuario;


public class PreferenciasDeJuego extends TipoDeRecomendacion {
	
	@Override
	protected List<Desafio> desafiosRecomendados(Usuario usuario) {

		return this.desafiosConMayorCoincidencia(
				this.ordenarDesafios(this.desafiosConCoincidencias(usuario.getPerfil())), 5);
	}

}
