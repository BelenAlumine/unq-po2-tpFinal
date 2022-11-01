package accionesDeProyectoTest;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class RestriccionPorFechaTest {
	RestriccionTemporal restriccion;
	Desafio desafio;
	Muestra muestra;
	Usuario usuario;
	Proyecto proyecto;
	PerfilUsuario perfil;
	
	@BeforeEach
	void setup() {
		restriccion = new RestriccionPorFecha(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));
		usuario = new Usuario("String", perfil);
		muestra = new Muestra(usuario);
		desafio = new Desafio(1, 2, restriccion);
		proyecto = new Proyecto("String1", "String2");
	}

	@Test
	void test() {
		//assertEquals(true, desafio.getRestriccion());
		
		restriccion.restringir(desafio);
		assertEquals(true, desafio.getRestriccion());
		
	}

}
