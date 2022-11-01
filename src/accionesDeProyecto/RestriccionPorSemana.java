package accionesDeProyecto;

import java.time.LocalDate;

import elementosDelSistema.Desafio;

public class RestriccionPorSemana extends RestriccionTemporal {
	LocalDate diaDeSemana;
	
	public RestriccionPorSemana(LocalDate diaDeSemana) {
		this.diaDeSemana = diaDeSemana;
	}
	
	@Override
	public void restringir(Desafio desafio) {
		
		if (desafio.getFechaActual().getDayOfWeek() != null /*dias de la semana*/) {
			desafio.setDesafioRestingido(true);
		}
	}
}
