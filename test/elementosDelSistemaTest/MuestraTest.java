package elementosDelSistemaTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import elementosDelSistema.AreaGeografica;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;

class MuestraTest {
	
	Muestra muestra;
	Usuario usuario1;
	PerfilUsuario perfil;
	AreaGeografica areaGeografica;
	RecomendacionDeDesafio recomendacion;
	
	@BeforeEach
	void setup() {
		perfil = new PerfilUsuario(1, 1, 1);
		usuario1 = new Usuario("Juancito", perfil, recomendacion);
		areaGeografica = new AreaGeografica(0d, 0d, 0d);
		muestra = new Muestra(usuario1, areaGeografica);
	}

	@Test
	void test() {
		//fail("Not yet implemented");
	}

}
