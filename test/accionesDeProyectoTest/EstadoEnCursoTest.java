package accionesDeProyectoTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoNoRealizado;
import elementosDelSistema.Desafio;

class EstadoEnCursoTest {

	Desafio desafio1;
	EstadoDelDesafio estadoNoRealizado;
	EstadoDelDesafio estadoEnCurso;
	
	@BeforeEach
	void setup() {
		desafio1 = new Desafio(5, 5);
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
