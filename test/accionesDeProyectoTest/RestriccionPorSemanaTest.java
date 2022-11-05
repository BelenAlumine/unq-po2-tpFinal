package accionesDeProyectoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionPorSemana;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

class RestriccionPorSemanaTest {
	RestriccionTemporal restriccion;
	Desafio desafio1;
	Desafio desafio2;
	Muestra muestra;
	Usuario usuario;
	Proyecto proyecto;
	AreaGeografica areaGeografica;
	PerfilUsuario perfil;
	RecomendacionDeDesafio recomendacion;
	
	@BeforeEach
	void setup() {
//		usuario = new Usuario("String", perfil, recomendacion);
//		muestra = new Muestra(usuario, areaGeografica);
		
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		restriccion = new RestriccionPorSemana();
		desafio1 = mock(Desafio.class);
		desafio2 = new Desafio(1, 2, 3, restriccion, areaGeografica);

		proyecto = new Proyecto("String1", "String2");
	}
	
	@Test
	void testSobreFechaConcreta() {
		//Compruebo la restricción en un dia particular, un día martes
		when(desafio1.getFechaActual()).thenReturn(LocalDate.of(2022, 11, 1)); 
		assertFalse(restriccion.esFinDeSemana(desafio1));
		assertFalse(restriccion.esSabado(desafio1));
		assertFalse(restriccion.esDomingo(desafio1));
		
	}
	
//	@Test
	void testRestriccionDeSemanaAplicadaADesafio() {
		// Comprobación de su estado inicial
		// Al solo tomar en cuenta el día actual que se toma del desafio, solo en los días de semana el test se va a cumplir
		assertFalse(desafio2.isDesafioRestringido());
		
		// Comprobación tras aplicar la restricción
		restriccion.restringir(desafio2);
		assertTrue(desafio2.isDesafioRestringido());
	}
}
