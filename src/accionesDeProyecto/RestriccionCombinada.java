package accionesDeProyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Desafio;

public class RestriccionCombinada extends RestriccionTemporal {
	List<RestriccionTemporal> restricciones = new ArrayList<RestriccionTemporal>();
	
	public RestriccionCombinada(LocalDate restriccion) {
		
		// TODO Auto-generated constructor stub
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
			this.restringir(desafio);
		};
		
	}

	@Override
	public boolean restringido(Desafio desafio) {
		for (RestriccionTemporal restriccion : this.getRestricciones()) {
			this.restringido(desafio);
			return true;
		}
		return false;
	}
	
}
