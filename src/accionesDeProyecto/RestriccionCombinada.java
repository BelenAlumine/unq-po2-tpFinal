package accionesDeProyecto;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.DesafioDeUsuario;

public class RestriccionCombinada implements RestriccionTemporal {
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
	public void restringir(DesafioDeUsuario desafio) {
		for (RestriccionTemporal restriccion : this.getRestricciones()) {
			this.restringido(desafio, restriccion);
		}		
	}

	public boolean restringido(DesafioDeUsuario desafio, RestriccionTemporal restriccion) {
		if(restriccion.restringido(desafio)) {
			desafio.setDesafioRestringido(true);
			return true;
		} else {
		desafio.setDesafioRestringido(false);
			return false;
		}
	}

	@Override
	public boolean restringido(DesafioDeUsuario desafio) {
		
		return false;
	}
}
