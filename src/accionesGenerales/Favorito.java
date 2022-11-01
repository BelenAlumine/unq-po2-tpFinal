package accionesGenerales;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import elementosDelSistema.Desafio;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;


public class Favorito extends TipoDeRecomendacion {

	@Override
	protected List<Desafio> desafiosRecomendados( Usuario usuario) {
		List<Desafio> desafiosAOrdenarPorSimilitud =  this.desafiosConMayorCoincidencia(this.desafiosConCoincidencias(usuario.getPerfil()) , 20);
		LinkedHashMap<Desafio, Integer> desafiosPorSimilitud = this.desafiosConValorDeSimilitud(desafiosAOrdenarPorSimilitud, usuario);
		
		return this.desafiosConMayorCoincidencia(this.ordenarDesafios(desafiosPorSimilitud), 5);
	}
	
	public LinkedHashMap<Desafio, Integer> desafiosConValorDeSimilitud(List<Desafio> desafios, Usuario usuario) {
		LinkedHashMap<Desafio, Integer> desafiosConSimilitud = new LinkedHashMap<Desafio, Integer>();
		for(Desafio desafio : desafios) {
			desafiosConSimilitud.put(desafio, this.calcularSimilitud(desafio, usuario.desafioQueMasLeGusto()));
		}
		return desafiosConSimilitud;
	}

	public int calcularSimilitud(Desafio desafioAComprobar, Desafio desafioFavorito) {
		return (this.diferenciaDeCaracteristicas(desafioAComprobar.getMuestrasARecolectar(), desafioFavorito.getMuestrasARecolectar()) +
				this.diferenciaDeCaracteristicas(desafioAComprobar.getRecompensa(), desafioFavorito.getRecompensa()) +
				this.diferenciaDeCaracteristicas(desafioAComprobar.getDificultad(), desafioFavorito.getDificultad())) / 3;
	}
	

}
