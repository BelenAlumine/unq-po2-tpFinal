package sistemaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;
import sistema.Sistema;

class sistemaTest {
	Muestra muestra;
	Desafio desafio;
	Proyecto proyecto;
	Usuario usuario;
	PerfilUsuario perfil;
	RestriccionTemporal restriccion;
	Sistema sistema;
	RecomendacionDeDesafio recomendacion;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setUp(){
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		restriccion = new RestriccionPorFecha(LocalDate.now(), LocalDate.now());
		desafio = new Desafio(1, 2, restriccion, areaGeografica);
		proyecto = new Proyecto("String1", "String2");
		perfil = new PerfilUsuario();
		usuario = new Usuario("Pedro", perfil, recomendacion);
		muestra = new Muestra(usuario);
		sistema = new Sistema();
	}


	@Test
	void agregarDatos() {
		//Inicia con 0 en todo.
		assertEquals(0, sistema.getDesafios().size());
		assertEquals(0, sistema.getMuestras().size());
		assertEquals(0, sistema.getProyectos().size());
		assertEquals(0, sistema.getUsuarios().size());
		
		//Cargo en el sistema un dato de cada uno
		sistema.agregarDesafio(desafio);
		sistema.agregarMuestra(muestra);
		sistema.agregarProyecto(proyecto);
		sistema.agregarUsuario(usuario);
		
		//Corroboro que se haya incrementado la cantidad en cada una de las listas.
		assertEquals(1, sistema.getDesafios().size());
		assertEquals(1, sistema.getMuestras().size());
		assertEquals(1, sistema.getProyectos().size());
		assertEquals(1, sistema.getUsuarios().size());
	}

}
