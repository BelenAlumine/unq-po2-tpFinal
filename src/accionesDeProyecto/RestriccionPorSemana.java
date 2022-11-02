package accionesDeProyecto;

import java.time.DayOfWeek;
import java.time.LocalDate;

import elementosDelSistema.Desafio;

public class RestriccionPorSemana extends RestriccionTemporal {
	
	
	public RestriccionPorSemana() {
		
	}
	
	@Override
	public void restringir(Desafio desafio) {
		
		if (!this.esFinDeSemana(desafio)) {
			desafio.setDesafioRestingido(false); 
		} else {
			desafio.setDesafioRestingido(true);
		}
	}
	

	@Override
	public boolean restringido(Desafio desafio) {
		return !this.esFinDeSemana(desafio);
	}
}
