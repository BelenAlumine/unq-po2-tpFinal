package accionesDeProyecto;

import java.time.DayOfWeek;

import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;

public abstract class RestriccionTemporalSimple implements RestriccionTemporal {
	
	public boolean esSabado(Desafio desafio) {
		return desafio.getFechaActual().getDayOfWeek() == DayOfWeek.SATURDAY;
	} 
	
	public boolean esDomingo(Desafio desafio) {
		return desafio.getFechaActual().getDayOfWeek() == DayOfWeek.SUNDAY;
	}

	public boolean esFinDeSemana(Desafio desafio) {
		return this.esSabado(desafio) || this.esDomingo(desafio);
	}
	
	@Override
	public void restringir(DesafioDeUsuario desafio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean restringido(DesafioDeUsuario desafio) {
		// TODO Auto-generated method stub
		return false;
	}
}
