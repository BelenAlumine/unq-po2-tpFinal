package accionesDeProyectoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Desafio;

class EstadoNoRealizadoTest {
	Desafio desafio;
	
	@BeforeEach
	void setup() {
		desafio = new Desafio(15, 3); //desafío de 15 muestras, nivel 3
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
