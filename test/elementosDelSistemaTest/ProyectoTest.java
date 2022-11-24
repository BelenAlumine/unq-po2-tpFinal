package elementosDelSistemaTest;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import elementosDelSistema.AreaGeografica;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class ProyectoTest {
	
	Proyecto proyectoBio;
	Usuario usuario;
	Muestra arbol;
	PerfilUsuario perfil;
	AreaGeografica areaGeografica;
	RecomendacionDeDesafio recomendacion;

	@BeforeEach
	void setup() {
		proyectoBio = new Proyecto("Proyecto de biologia", "Un proyecto para aprender de las plantas.");
		perfil = new PerfilUsuario(1, 1, 1);
		usuario = new Usuario("Juancito", perfil, recomendacion);
		areaGeografica = new AreaGeografica(0d, 0d, 0d);
		arbol = new Muestra(usuario, 0.0, 1.0);
	}

	@Test
	void cargarInformacionAlProyecto() { 
	  assertEquals(0, proyectoBio.getParticipantes().size());
	  assertEquals(0, proyectoBio.getDesafios().size());
	  assertEquals(0, proyectoBio.getMuestras().size());
	  
	  proyectoBio.suscribirParticipante(usuario);
	  assertEquals(1, proyectoBio.getParticipantes().size());
	  
	  proyectoBio.agregarMuestra(arbol);
	  assertEquals(1, proyectoBio.getMuestras().size());
	}

}