package accionesDeProyecto;

import java.time.LocalDate;

import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;

public class RestriccionPorFecha extends RestriccionTemporalSimple {
	LocalDate inicioRestriccion;
	LocalDate finRestriccion;
	
	public RestriccionPorFecha(LocalDate inicioRestriccion, LocalDate finRestriccion) {
		
		this.inicioRestriccion = inicioRestriccion;
		this.finRestriccion = finRestriccion;
	}
	
	
	@Override
	public void restringir(DesafioDeUsuario desafio) {
		
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
	public boolean restringido(DesafioDeUsuario desafio) {
		return !(this.fechaPreviaAlDesafio(desafio.getDesafioBase()) && this.fechaPosteriorAlDesafio(desafio.getDesafioBase()));
	}


	@Override
	public void agregarRestriccion(RestriccionTemporal restriccionPorSemana) {
		// TODO Auto-generated method stub
		
	}
}
