package elementosDelSistemaTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;

class MuestraTest {
	
	Muestra muestra;
	Usuario usuario1;
	PerfilUsuario perfil;
	RecomendacionDeDesafio recomendacion;
	
	@BeforeEach
	void setup() {
		perfil = new PerfilUsuario();
		usuario1 = new Usuario("Juancito", perfil, recomendacion);
		muestra = new Muestra(usuario1);
	}

	@Test
	void test() {
		//fail("Not yet implemented");
	}

}
