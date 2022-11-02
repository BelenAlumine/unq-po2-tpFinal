package accionesDeProyectoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionPorSemana;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class RestriccionPorSemanaTest {
	RestriccionTemporal restriccion;
	Desafio desafio;
	Muestra muestra;
	Usuario usuario;
	Proyecto proyecto;
	PerfilUsuario perfil;
	
	@BeforeEach
	void setup() {
		restriccion = new RestriccionPorSemana();
		usuario = new Usuario("String", perfil);
		muestra = new Muestra(usuario);
		desafio = new Desafio(1, 2, restriccion);
		proyecto = new Proyecto("String1", "String2");
	}

	@Test
	void test() {
		//assertEquals(true, desafio.getRestriccion());
		
		//restriccion.restringir(desafio);
		
		assertEquals(true, restriccion.esSabado(desafio));
		assertEquals(false, restriccion.esSabado(desafio));
		
	}
}