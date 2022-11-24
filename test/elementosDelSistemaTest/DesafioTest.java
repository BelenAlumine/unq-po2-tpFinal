package elementosDelSistemaTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionPorSemana;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;

class DesafioTest {

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
		estadoNoRealizado = new EstadoNoRealizado();
		estadoEnCurso = new EstadoEnCurso();
		desafio1 = new Desafio(5, 10, 5, restriccionPorFecha, areaGeografica);
		desafio2 = new Desafio(5, 5, 5, restriccionPorSemana, areaGeografica);
	}

	
	@Test
	void estadoInicial() {
		assertEquals(10, desafio1.getDificultad());
		assertEquals(5, desafio1.getRecompensa());
		assertEquals(5, desafio1.getMuestrasARecolectar());
		assertEquals(LocalDate.now(), desafio1.getFechaActual());
		
	}
	
}