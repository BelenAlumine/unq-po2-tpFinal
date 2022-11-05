package accionesDeProyectoTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;

class EstadoEnCursoTest {

	Desafio desafio1;
	EstadoDelDesafio estadoNoRealizado;
	EstadoDelDesafio estadoEnCurso;
	RestriccionTemporal restriccionPorFecha;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setup() {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		restriccionPorFecha = new RestriccionPorFecha(LocalDate.now(), LocalDate.now());
		desafio1 = new Desafio(5, 5, 5, restriccionPorFecha, areaGeografica);
		estadoNoRealizado = new EstadoNoRealizado();
		estadoEnCurso = new EstadoEnCurso();
	}

	@Test
	void validacionDeEstado() {
		assertTrue(desafio1.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		
		desafio1.setEstadoDelDesafio(estadoEnCurso);
		assertFalse(desafio1.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		assertTrue(desafio1.getEstadoDelDesafio() instanceof EstadoEnCurso);
	}


}
