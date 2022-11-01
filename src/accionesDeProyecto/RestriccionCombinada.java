package accionesDeProyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
}
