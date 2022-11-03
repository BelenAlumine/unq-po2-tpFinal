package accionesDeProyecto;

import java.time.LocalDate;

import elementosDelSistema.Desafio;

public class RestriccionPorFecha extends RestriccionTemporal{
	LocalDate inicioRestriccion;
	LocalDate finRestriccion;
	
	public RestriccionPorFecha(LocalDate inicioRestriccion, LocalDate finRestriccion) {
		
		this.inicioRestriccion = inicioRestriccion;
		this.finRestriccion = finRestriccion;
	}
	
	
	@Override
	public void restringir(Desafio desafio) {
		
		if (this.restringido(desafio)) {
			desafio.setDesafioRestringido(true);
		} else {
			desafio.setDesafioRestringido(false);
		}
	}
	
	public boolean fechaPreviaAlDesafio(Desafio desafio) {
		return desafio.getFechaActual().isBefore(finRestriccion);
	}
	
	public boolean fechaPosteriorAlDesafio(Desafio desafio) {
		return desafio.getFechaActual().isAfter(inicioRestriccion);
	}

	@Override
	public boolean restringido(Desafio desafio) {
		return !(this.fechaPreviaAlDesafio(desafio) && this.fechaPosteriorAlDesafio(desafio));
	}
	
	
}
