package accionesGeneralesTest;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.ActualizacionDeDesafio;
import accionesGenerales.GeneradorDeMuestra;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
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
	AreaGeografica areaGeografica;
	RestriccionTemporal restriccionPorFecha;
	GeneradorDeMuestra generadorDeMuestra;
	PerfilUsuario perfil;
	ActualizacionDeDesafio actualizacion;
	RecomendacionDeDesafio recomendacion;
	
	@BeforeEach
	void setup()  {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		perfil = new PerfilUsuario();
		usuario = new Usuario("Juancito", perfil, recomendacion);
		proyecto = new Proyecto("null", "null");
		//muestra = new Muestra(usuario);
		desafio = new Desafio(2, 3, restriccionPorFecha, areaGeografica);
		generadorDeMuestra = new GeneradorDeMuestra();
		actualizacion = new ActualizacionDeDesafio();
	}

	@Test 
	void crearMuestra() {
		
		generadorDeMuestra.crearMuestra(usuario, proyecto, desafio, muestra);
		assertEquals(1, proyecto.getMuestras().size());
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
