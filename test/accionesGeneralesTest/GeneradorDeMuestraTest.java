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
import elementosDelSistema.DesafioDeUsuario;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class GeneradorDeMuestraTest {
	Usuario usuario;
	Proyecto proyecto;
	Muestra muestra;
	Desafio desafio;
	DesafioDeUsuario desafioUsuario;
	AreaGeografica areaGeografica;
	RestriccionTemporal restriccionPorFecha;
	GeneradorDeMuestra generadorDeMuestra;
	PerfilUsuario perfil;

	ActualizacionDeDesafio actualizacion;
	RecomendacionDeDesafio recomendacion;
	
	@BeforeEach
	void setup()  {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		perfil = new PerfilUsuario(1, 1, 1);
		usuario = new Usuario("Juancito", perfil, recomendacion);
		proyecto = new Proyecto("null", "null");
		muestra = new Muestra(usuario, 0.0, 1.0);
		desafio = new Desafio(2, 3, 1, restriccionPorFecha, areaGeografica);
		desafioUsuario = new DesafioDeUsuario(desafio);
		generadorDeMuestra = new GeneradorDeMuestra();
		actualizacion = new ActualizacionDeDesafio();
	}

	@Test 
	void crearMuestra() {
		
		generadorDeMuestra.crearMuestra(usuario, proyecto, desafioUsuario, muestra);
		assertEquals(1, proyecto.getMuestras().size());
	}
	
	@Test
	void generarMuestra() {
		//Estado inicial
		assertEquals(0, proyecto.getMuestras().size());
		assertEquals(0, desafioUsuario.getMuestrasRecolectadas());
		
		//Cambios al generar muestra
		usuario.generarMuestra(usuario, proyecto, desafioUsuario, 0.0, 1.0);
		assertEquals(1, proyecto.getMuestras().size());
	}

}
