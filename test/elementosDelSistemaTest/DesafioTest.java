package elementosDelSistemaTest;


import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Desafio;

class DesafioTest {

	Desafio desafio1;
	
	@BeforeEach
	void setup() {
		desafio1 = new Desafio(5, 5);
	}

	@Test
	void estadoInicial() {
		assertEquals(5, desafio1.getDificultad());
		assertEquals(0, desafio1.getRecompensa());
		assertEquals(5, desafio1.getMuestrasARecolectar());
		assertEquals(LocalDate.now(), desafio1.getFechaActual());
		
		assertEquals(0, desafio1.getMuestrasRecolectadas().size());
	}

}