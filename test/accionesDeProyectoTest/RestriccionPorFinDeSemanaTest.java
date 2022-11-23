package accionesDeProyectoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionPorFinDeSemana;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

class RestriccionPorFinDeSemanaTest {
	RestriccionPorFinDeSemana restriccion;
	Desafio desafio1;
	Desafio desafio2;
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
		muestra = new Muestra(usuario, areaGeografica);
		desafio1 = mock(Desafio.class);
		desafio2 = new Desafio(1, 2, 3, restriccion, areaGeografica);
		proyecto = new Proyecto("String1", "String2");
	}

	@Test
	void testSobreComprobacionDeFinDeSemana() {
		///Compruebo la restricción en un dia particular, un día domingo
		when(desafio1.getFechaActual()).thenReturn(LocalDate.of(2022, 10, 30));
		assertTrue(restriccion.esFinDeSemana(desafio1));
		assertFalse(restriccion.esSabado(desafio1));
		assertTrue(restriccion.esDomingo(desafio1));
		
	}
	
	@Test
	void testRestrccionFinDeSemanaEnDesafio() {
		//Comprobación de la restricción inicial,
		assertFalse(desafio1.isDesafioRestringido());
		
		//compruebo cambio con m�todo restringir
		when(desafio1.getFechaActual()).thenReturn(LocalDate.of(2022, 10, 30));
		restriccion.restringir(desafio1);
		assertFalse(desafio1.isDesafioRestringido());
	}
}
