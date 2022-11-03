package accionesDeProyectoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionPorFinDeSemana;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class RestriccionPorFinDeSemanaTest {
	RestriccionTemporal restriccion;
	Desafio desafio;
	Muestra muestra;
	Usuario usuario;
	Proyecto proyecto;
	PerfilUsuario perfil;
	RecomendacionDeDesafio recomendacion;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setup() {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		restriccion = new RestriccionPorFinDeSemana();
		usuario = new Usuario("String", perfil, recomendacion);
		muestra = new Muestra(usuario);
		desafio = new Desafio(1, 2, restriccion, areaGeografica);
		proyecto = new Proyecto("String1", "String2");
	}

	@Test
	void test() {
		//Compruebo la restricción inicial, 
		assertEquals(false, desafio.isDesafioRestringido());
		assertEquals(false, restriccion.esFinDeSemana(desafio));
		assertEquals(false, restriccion.esSabado(desafio));
		assertEquals(false, restriccion.esDomingo(desafio));
		//compruebo la restriccion
		restriccion.restringir(desafio);
		assertEquals(true, desafio.isDesafioRestringido());
		
	}
}
