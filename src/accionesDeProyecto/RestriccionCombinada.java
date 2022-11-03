package accionesDeProyecto;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Desafio;

public class RestriccionCombinada extends RestriccionTemporal {
	List<RestriccionTemporal> restricciones = new ArrayList<RestriccionTemporal>();
	
	public RestriccionCombinada() {
	}
	
	public List<RestriccionTemporal> getRestricciones() {
		return restricciones;
	}

	public void agregarRestriccion(RestriccionTemporal restriccion) {
		this.getRestricciones().add(restriccion);
	}

	@Override
	public void restringir(Desafio desafio) {
		for (RestriccionTemporal restriccion : this.getRestricciones()) {
			restriccion.restringido(desafio);
		};
		
	}
	
	/*if (this.restringido(desafio)) {
			desafio.setDesafioRestringido(true);
		} else {
			desafio.setDesafioRestringido(false);
		}*/

	@Override
	public boolean restringido(Desafio desafio) {
		return false;
		/*for (RestriccionTemporal restriccion : this.getRestricciones()) {
			this.restringir(desafio);
			return true;
		}*/
		 
	}
	
}
