package elementosDelSistemaTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionPorSemana;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;

class DesafioDeUsuarioTest {

	DesafioDeUsuario desafioUsuario1;
	DesafioDeUsuario desafioUsuario2;
	DesafioDeUsuario desafioUsuario3;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	EstadoDelDesafio estadoNoRealizado;
	EstadoDelDesafio estadoEnCurso;
	RestriccionTemporal restriccionPorFecha;
	RestriccionTemporal restriccionPorSemana;
	RestriccionTemporal restriccionPorFinDeSemana;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setup() {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		restriccionPorFecha = new RestriccionPorFecha(LocalDate.of(2021,12,2), LocalDate.of(2023,12,12));
		restriccionPorSemana = new RestriccionPorSemana(); 
		//restriccionFinDeSemana = new RestriccionPorFinDeSemana();
		estadoNoRealizado = new EstadoNoRealizado();
		estadoEnCurso = new EstadoEnCurso();
		desafio1 = new Desafio(5, 10, 5, restriccionPorFecha, areaGeografica);
		desafio2 = new Desafio(5, 5, 5, restriccionPorSemana, areaGeografica);
		
		desafioUsuario1 = new DesafioDeUsuario(desafio1);
		desafioUsuario2 = new DesafioDeUsuario(desafio2);
	}
	
	@Test
	void estadoInicialDeMuestras() {
		assertEquals(0, desafioUsuario1.getMuestrasRecolectadas());
		desafioUsuario1.sumarMuestraCargada();
		assertEquals(1, desafioUsuario1.getMuestrasRecolectadas());
	}
	
	@Test
	void restriccionDelDesafio() {
		assertEquals(false, desafioUsuario1.isDesafioRestringido());
		restriccionPorFecha.restringir(desafioUsuario1);
		assertEquals(false, desafioUsuario1.isDesafioRestringido());
	}
	
	@Test
	void avanceDeDesafioEnMuestras() {
		assertTrue(desafioUsuario1.leFaltanMuestrasARecolectar());
		desafioUsuario1.sumarMuestraCargada();
		desafioUsuario1.sumarMuestraCargada();
		desafioUsuario1.sumarMuestraCargada();
		desafioUsuario1.sumarMuestraCargada();
		assertTrue(desafioUsuario1.leFaltanMuestrasARecolectar());
		desafioUsuario1.sumarMuestraCargada();
		assertTrue(desafioUsuario1.esUnDesafioCompletado());
	}
	
	@Test
	void validacionDeEstado() {
		//Verifico que el estado sea el inicial (no realizado)
		assertTrue(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		
		//setteo un estado nuevo y verifico que no siga siendo el anterior, despu�s verifico que sea el que sette�
		desafioUsuario1.setEstadoDelDesafio(estadoEnCurso);
		assertFalse(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		assertTrue(desafioUsuario1.getEstadoDelDesafio() instanceof EstadoEnCurso); 
	}

}
