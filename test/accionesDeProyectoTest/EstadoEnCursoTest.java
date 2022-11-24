package accionesDeProyectoTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoFinalizado;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;

class EstadoEnCursoTest {

	Desafio desafio1;
	DesafioDeUsuario desafioUsuario1;
	EstadoDelDesafio estadoNoRealizado;
	EstadoDelDesafio estadoEnCurso;
	EstadoDelDesafio estadoFinalizado;
	RestriccionTemporal restriccionPorFecha;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setup() {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		restriccionPorFecha = new RestriccionPorFecha(LocalDate.now(), LocalDate.now());
		desafio1 = new Desafio(5, 5, 5, restriccionPorFecha, areaGeografica);
		estadoNoRealizado = new EstadoNoRealizado();
		estadoEnCurso = new EstadoEnCurso();
		estadoFinalizado = new EstadoFinalizado();
		desafioUsuario1 = new DesafioDeUsuario(desafio1);
	}

	@Test
	void validacionDeEstado() {
		assertTrue(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		
		desafioUsuario1.setEstadoDelDesafio(estadoEnCurso);
		assertFalse(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		assertTrue(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoEnCurso);
	}
	
	@Test
	void cambioDeEstadoEnDesafio() {
		assertTrue(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		desafioUsuario1.setEstadoDelDesafio(estadoEnCurso);
		desafioUsuario1.sumarMuestraCargada();
		desafioUsuario1.sumarMuestraCargada();
		desafioUsuario1.sumarMuestraCargada();
		desafioUsuario1.sumarMuestraCargada();
		desafioUsuario1.sumarMuestraCargada();
		estadoEnCurso.revisarEstadoDelDesafio(desafioUsuario1);
		assertFalse(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoEnCurso);
		assertTrue(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoFinalizado);
	}

}
