package elementosDelSistemaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;

class MuestraTest {
	
	Muestra muestra;
	Usuario usuario1;
	PerfilUsuario perfil;
	
	@BeforeEach
	void setup() {
		perfil = new PerfilUsuario();
		usuario1 = new Usuario("Juancito", perfil);
		muestra = new Muestra(usuario1);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
