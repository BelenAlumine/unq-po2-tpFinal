package accionesDeProyectoTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionPorFecha;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class RestriccionPorFechaTest {
	
	RestriccionPorFecha restriccion;
	RestriccionPorFecha restriccion1;
	Desafio desafio1;
	Desafio desafio2;
	DesafioDeUsuario desafioUsuario1;
	DesafioDeUsuario desafioUsuario2;
	Muestra muestra;
	Usuario usuario;
	Proyecto proyecto;
	PerfilUsuario perfil;
	RecomendacionDeDesafio recomendacion;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setup() {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		restriccion = new RestriccionPorFecha(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));
		restriccion1 = new RestriccionPorFecha(LocalDate.of(2020,10,12), LocalDate.of(2020, 12, 31));
		usuario = new Usuario("String", perfil, recomendacion);
		muestra = new Muestra(usuario, 0.0, 1.0);
		desafio1 = new Desafio(1, 2, 3, restriccion, areaGeografica);
		desafio2 = new Desafio(1, 2, 3, restriccion1, areaGeografica);
		desafioUsuario1 = new DesafioDeUsuario(desafio1);
		desafioUsuario2 = new DesafioDeUsuario(desafio2);
		
		proyecto = new Proyecto("String1", "String2");
	}
	
	@Test
	void restriccionDelDesafio() {
		//Por default el desafio no esta restringido. Cargo parametros que contengan en medio la fecha actual. 
		assertEquals(false, desafioUsuario1.isDesafioRestringido());
		restriccion.restringir(desafioUsuario1);
		assertEquals(false, desafioUsuario1.isDesafioRestringido());
		
		//Lo mismo, con un rango de fechas anteriores a la actual.
		assertEquals(false, desafioUsuario2.isDesafioRestringido());
		restriccion1.restringir(desafioUsuario2);
		assertEquals(true, desafioUsuario2.isDesafioRestringido());
	}
}
