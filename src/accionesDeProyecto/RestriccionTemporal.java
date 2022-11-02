package accionesDeProyecto;



import java.time.DayOfWeek;

import elementosDelSistema.Desafio;


public abstract class RestriccionTemporal {

	
	
	abstract public void restringir(Desafio desafio); 
	
	public void agregarRestriccion() {
		
	}

	public boolean esSabado(Desafio desafio) {
		return desafio.getFechaActual().getDayOfWeek() == DayOfWeek.SATURDAY;
	}
	
	public boolean esDomingo(Desafio desafio) {
		return desafio.getFechaActual().getDayOfWeek() == DayOfWeek.SUNDAY;
	}

	public boolean esFinDeSemana(Desafio desafio) {
		return this.esSabado(desafio) && this.esDomingo(desafio);
	}

	public abstract boolean restringido(Desafio desafio);
}
