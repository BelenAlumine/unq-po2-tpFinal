package elementosDelSistemaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Muestra;
import elementosDelSistema.Usuario;

class MuestraTest {
	
	Muestra muestra;
	Usuario usuario1;
	
	@BeforeEach
	void setup() {
		usuario1 = new Usuario();
		muestra = new Muestra(usuario1);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
