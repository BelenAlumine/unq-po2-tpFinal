package accionesDeProyectoTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionCombinada;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionPorFinDeSemana;
import accionesDeProyecto.RestriccionPorSemana;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class RestriccionCombinadaTest {
	
	AreaGeografica areaGeografica;
	
	PerfilUsuario perfil;
	RecomendacionDeDesafio recomendacion;
	
	RestriccionTemporal restriccionPorFechaNoRest;
	RestriccionTemporal restriccionPorFechaRest;
	RestriccionTemporal restriccionPorSemana;
	RestriccionTemporal restriccionPorFinDeSemana;
	RestriccionTemporal restriccionCombinadaRest;
	RestriccionTemporal restriccionCombinadaNoRest;
	
	Usuario usuario;
	
	Muestra muestra;
	
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	Desafio desafio6;
	
	Proyecto proyecto;
	
	@BeforeEach
	void setUp() throws Exception {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		
		restriccionPorFechaNoRest = new RestriccionPorFecha(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));
		restriccionPorFechaRest = new RestriccionPorFecha(LocalDate.of(2020,10,12), LocalDate.of(2020, 12, 31));
		restriccionPorSemana = new RestriccionPorSemana();
		restriccionPorFinDeSemana = new RestriccionPorFinDeSemana();
		restriccionCombinadaRest = new RestriccionCombinada();
		restriccionCombinadaNoRest = new RestriccionCombinada();
		
		
		usuario = new Usuario("String", perfil, recomendacion);
		
		muestra = new Muestra(usuario);
		
		desafio1 = new Desafio(1, 2, restriccionPorFechaNoRest, areaGeografica);
		desafio2 = new Desafio(1, 2, restriccionPorFechaRest, areaGeografica);
		desafio3 = new Desafio(1, 2, restriccionPorSemana, areaGeografica);
		desafio4 = new Desafio(1, 2, restriccionPorFinDeSemana, areaGeografica);
		
		desafio5 = new Desafio(1, 2, restriccionCombinadaRest, areaGeografica);
		desafio6 = new Desafio(1, 2, restriccionCombinadaNoRest, areaGeografica);
		
		proyecto = new Proyecto("String1", "String2");
	}

	@Test
	void agregarRestricciones() {
		//Creo lista restricciones y le cargo una restricción para comparar en el assert
		List<RestriccionTemporal> restricciones = new ArrayList<RestriccionTemporal>();
		restricciones.add(restriccionPorFechaRest);
		//Creo otra lista para comparar que se cargue correctamente
		List<RestriccionTemporal> restricciones1 = new ArrayList<RestriccionTemporal>();
		restricciones1.add(restriccionPorFechaNoRest);
		restricciones1.add(restriccionPorSemana);
		
	
		restriccionCombinadaRest.agregarRestriccion(restriccionPorFechaRest);
		assertEquals(restricciones, restriccionCombinadaRest.getRestricciones());
		
		restriccionCombinadaNoRest.agregarRestriccion(restriccionPorFechaNoRest);
		restriccionCombinadaNoRest.agregarRestriccion(restriccionPorSemana);
		assertEquals(restricciones1, restriccionCombinadaNoRest.getRestricciones());
	}

}
