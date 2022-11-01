package accionesDeProyecto;

import java.time.LocalDate;

import elementosDelSistema.Desafio;

public class RestriccionPorFinDeSemana extends RestriccionTemporal {
	LocalDate finDeSemana;
	
	public RestriccionPorFinDeSemana(LocalDate finDeSemana) {
		this.finDeSemana = finDeSemana;
	}
	
	@Override
	public void restringir(Desafio desafio) {
		
		if (desafio.getFechaActual().getDayOfWeek() != null /*!dias de la semana*/) {
			desafio.setDesafioRestingido(true);
		}
	}
}
