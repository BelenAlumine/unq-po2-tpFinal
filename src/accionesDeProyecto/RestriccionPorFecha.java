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
		
		if (this.fechaPreviaAlDesafio(desafio) && this.fechaPosteriorAlDesafio(desafio)) {
			desafio.setDesafioRestingido(false);
		} 
		else if (this.fechaPreviaAlDesafio(desafio) || this.fechaPosteriorAlDesafio(desafio)){
			desafio.setDesafioRestingido(true);
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
		return this.fechaPreviaAlDesafio(desafio) || this.fechaPosteriorAlDesafio(desafio);
	}
}
