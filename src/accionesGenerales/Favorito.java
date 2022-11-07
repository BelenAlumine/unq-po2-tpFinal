package accionesGenerales;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import elementosDelSistema.Desafio;
import elementosDelSistema.Usuario;


public class Favorito extends TipoDeRecomendacion {

	@Override
	public List<Desafio> desafiosRecomendados(Usuario usuario, List<Desafio> desafios) {
		LinkedHashMap<Desafio, Float> desafiosAOrdenarPorSimilitud = this.desafiosConCoincidencias(usuario.getPerfil(), desafios);
		List<Desafio> desafiosAOrdenar = this.primerosDesafiosARecomendar(this.ordenarDesafios(desafiosAOrdenarPorSimilitud) , 20);
		desafiosAOrdenarPorSimilitud = this.desafiosAsociadosASimilitud(desafiosAOrdenar, usuario);
	
		return this.primerosDesafiosARecomendar(this.ordenarDesafios(desafiosAOrdenarPorSimilitud), 5);
	}
	
	public LinkedHashMap<Desafio, Float> desafiosAsociadosASimilitud(List<Desafio> desafios, Usuario usuario) {
		LinkedHashMap<Desafio, Float> desafiosConSimilitud = new LinkedHashMap<Desafio, Float>();
		for(Desafio desafio : desafios) {
			desafiosConSimilitud.put(desafio, this.calcularSimilitud(desafio, usuario.desafioQueMasLeGusto()));
		}
		return desafiosConSimilitud;
	}

	public Float calcularSimilitud(Desafio desafioAComprobar, Desafio desafioFavorito) {
		return (float) (this.diferenciaDeCaracteristicas(desafioAComprobar.getMuestrasARecolectar(), desafioFavorito.getMuestrasARecolectar()) +
				this.diferenciaDeCaracteristicas(desafioAComprobar.getRecompensa(), desafioFavorito.getRecompensa()) +
				this.diferenciaDeCaracteristicas(desafioAComprobar.getDificultad(), desafioFavorito.getDificultad())) / 3;
	}
	

}
