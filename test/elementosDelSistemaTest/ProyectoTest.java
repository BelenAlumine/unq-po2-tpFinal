package elementosDelSistemaTest;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import elementosDelSistema.Proyecto;

class ProyectoTest {
	
	Proyecto proyectoBio;

	
	@BeforeEach
	void setup() {
		proyectoBio = new Proyecto("Proyecto de biología", "Un proyecto para aprender de las plantas.");
	}

	@Test
	void test() { 
	  assertEquals(0, proyectoBio.getParticipantes().size());
	}

}