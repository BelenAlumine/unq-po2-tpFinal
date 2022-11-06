package elementosDelSistemaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.PerfilUsuario;

class PerfilUsuarioTest {

	PerfilUsuario perfilBase;
	
	@BeforeEach
	void setUp() {
		perfilBase = new PerfilUsuario(0, 0, 0);
	}
	
	@Test
	void testCambioDeAtributos() {
		perfilBase.setCantidadDeMuestrasARecolectarDeseada(8);
		perfilBase.setDificultadDeseada(4);
		perfilBase.setRecomenpensaPreferida(12);
		assertEquals(12, perfilBase.getRecompensaPreferida());
		assertEquals(4, perfilBase.getDificultadDeseada());
		assertEquals(8, perfilBase.getCantidadDeMuestrasARecolectar());
	}

}
