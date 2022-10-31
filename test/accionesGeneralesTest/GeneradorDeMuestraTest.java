package accionesGeneralesTest;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.GeneradorDeMuestra;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class GeneradorDeMuestraTest {
	Usuario usuario;
	Proyecto proyecto;
	Muestra muestra;
	Desafio desafio;
	RestriccionTemporal restriccionPorFecha;
	GeneradorDeMuestra generadorDeMuestra;
	PerfilUsuario perfil;
	
	@BeforeEach
	void setup()  {
		perfil = new PerfilUsuario();
		usuario = new Usuario("Juancito", perfil);
		proyecto = new Proyecto("null", "null");
		//muestra = new Muestra(usuario);
		desafio = new Desafio(2, 3, restriccionPorFecha);
	}

	@Test
	void generarMuestra() {
		//Estado inicial
		assertEquals(0, proyecto.getMuestras().size());
		assertEquals(0, desafio.getMuestrasRecolectadas());
		
		//Cambios al generar muestra
		usuario.generarMuestra(usuario, proyecto, desafio);
		assertEquals(1, proyecto.getMuestras().size());
		//assertEquals(1, desafio.getMuestrasRecolectadas());
	}

}
