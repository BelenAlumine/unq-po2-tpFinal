package accionesDeProyecto;

import java.time.DayOfWeek;
import java.time.LocalDate;

import elementosDelSistema.Desafio;

public class RestriccionPorSemana extends RestriccionTemporal {
	
	
	public RestriccionPorSemana() {
		
	}
	
	@Override
	public void restringir(Desafio desafio) {
		
		if (!this.esSabado(desafio) && !this.esDomingo(desafio)) {
			desafio.setDesafioRestingido(false); 
		} else {
			desafio.setDesafioRestingido(true);
		}
	}
	
	
	
}
