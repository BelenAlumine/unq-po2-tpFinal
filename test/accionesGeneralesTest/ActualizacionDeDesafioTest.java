package accionesGeneralesTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoFinalizado;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.ActualizacionDeDesafio;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class ActualizacionDeDesafioTest {
	
	Usuario usuario;
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Desafio desafio;
	Desafio desafio1;
	DesafioDeUsuario desafioUsuario;
	DesafioDeUsuario desafioUsuario1;
	Proyecto proyecto;
	AreaGeografica areaGeografica;
	ActualizacionDeDesafio actualizacion;
	RestriccionTemporal restriccion;
	RestriccionTemporal restriccion1;
	EstadoDelDesafio estado;
	EstadoDelDesafio estadoEnCurso;
	EstadoFinalizado estadoFinalizado;
	
	@BeforeEach
	void setUp(){
		usuario = mock(Usuario.class);
		actualizacion = new ActualizacionDeDesafio();
		estado = new EstadoNoRealizado();
		estadoEnCurso = new EstadoEnCurso();
		estadoFinalizado = new EstadoFinalizado();
		restriccion = new RestriccionPorFecha(LocalDate.of(2021, 01, 1), LocalDate.of(2025,3,2));
		restriccion1 = new RestriccionPorFecha(LocalDate.of(2020, 12, 1), LocalDate.of(2021,3,2));
		areaGeografica = new AreaGeografica(8.0, 4.0, 10);
		desafio = new Desafio(1, 2, 3, restriccion, areaGeografica);
		desafio1 = new Desafio(1, 2, 3, restriccion, areaGeografica);
		
		muestra1 = new Muestra(usuario, 3, 5);
		muestra2 = new Muestra(usuario, 6, 2);
		muestra3 = new Muestra(usuario, 14, 14);
		desafioUsuario = new DesafioDeUsuario(desafio);
		desafioUsuario1 = new DesafioDeUsuario(desafio1);
		
	}
	
	@Test
	void estadoNoRealizado() {
		//No actualiza porque el estado es no realizado
		actualizacion.actualizarDesafio(desafioUsuario, muestra1);
		assertTrue(desafioUsuario.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		assertEquals(0, desafioUsuario.getMuestrasRecolectadas());	
	}
	
	@Test
	void estadoEnCurso() {
		// Actualiza pero solo con una muestra debido a que muestra3 se encuentra fuera del area del desafio
		desafioUsuario.setEstadoDelDesafio(estadoEnCurso); 
		actualizacion.actualizarDesafio(desafioUsuario, muestra2);
		actualizacion.actualizarDesafio(desafioUsuario, muestra3); 
		assertTrue(desafioUsuario.getEstadoDelDesafio() instanceof EstadoEnCurso);
		assertEquals(1, desafioUsuario.getMuestrasRecolectadas());	
	}
	
	@Test
	void estadoFinalizado() {
		//No actualiza porque el estado es finalizado
		//Acá es test provisorio. Hay que terminar el state.
		//Porque o sea, el assertEquals es comparando con cero, en el estado finalizado adem�s
		//de chequear el estado se tiene que cumplir que la cantidad de muestras sea igual a las 
		//necesarias para pasar el desaf�o, pero bueno, eso no le interesa a esta parte(?
		desafioUsuario.setEstadoDelDesafio(estadoFinalizado); 
		actualizacion.actualizarDesafio(desafioUsuario, muestra2);
		assertTrue(desafioUsuario.getEstadoDelDesafio() instanceof EstadoFinalizado);
		assertEquals(0, desafioUsuario.getMuestrasRecolectadas());	
	}
	
	@Test
	void actualizarMuestras() {
		desafioUsuario.setEstadoDelDesafio(estadoEnCurso);
		desafio.setRestriccion(restriccion);
		
		actualizacion.actualizarMuestrasRecolectadas(desafioUsuario);
		assertEquals(1, desafioUsuario.getMuestrasRecolectadas());
		
		actualizacion.actualizarDesafio(desafioUsuario, muestra1);
		assertEquals(2, desafioUsuario.getMuestrasRecolectadas());
		
		desafio1.setRestriccion(restriccion1);
		actualizacion.actualizarDesafio(desafioUsuario1, muestra2);
		assertEquals(0, desafioUsuario1.getMuestrasRecolectadas());
	}
}
