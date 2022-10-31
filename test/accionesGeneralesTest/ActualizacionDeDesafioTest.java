package accionesGeneralesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoFinalizado;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.ActualizacionDeDesafio;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class ActualizacionDeDesafioTest {
	
	Usuario usuario;
	Muestra muestra;
	Desafio desafio;
	Proyecto proyecto;
	ActualizacionDeDesafio actualizacion;
	RestriccionTemporal restriccion;
	EstadoDelDesafio estado;
	EstadoDelDesafio estadoEnCurso;
	EstadoFinalizado estadoFinalizado;
	
	@BeforeEach
	void setUp(){
		desafio = new Desafio(1, 2, restriccion);
		actualizacion = new ActualizacionDeDesafio();
		estado = new EstadoNoRealizado();
		estadoEnCurso = new EstadoEnCurso();
		estadoFinalizado = new EstadoFinalizado();
	}
	
	@Test
	void estadoNoRealizado() {
		//No actualiza porque el estado es no realizado
		actualizacion.actualizarDesafio(desafio);
		assertTrue(desafio.getEstadoDelDesafio() instanceof EstadoNoRealizado);
		assertEquals(0, desafio.getMuestrasRecolectadas());	
	}
	
	@Test
	void estadoEnCurso() {
		//No actualiza porque el estado es no realizado
		desafio.setEstadoDelDesafio(estadoEnCurso); 
		actualizacion.actualizarDesafio(desafio);
		assertTrue(desafio.getEstadoDelDesafio() instanceof EstadoEnCurso);
		assertEquals(1, desafio.getMuestrasRecolectadas());	
	}
	
	@Test
	void estadoFinalizado() {
		//No actualiza porque el estado es finalizado
		//Acá es test provisorio. Hay que terminar el state.
		//Porque o sea, el assertEquals es comparando con cero, en el estado finalizado además
		//de chequear el estado se tiene que cumplir que la cantidad de muestras sea igual a las 
		//necesarias para pasar el desafío, pero bueno, eso no le interesa a esta parte(?
		desafio.setEstadoDelDesafio(estadoFinalizado); 
		actualizacion.actualizarDesafio(desafio);
		assertTrue(desafio.getEstadoDelDesafio() instanceof EstadoFinalizado);
		assertEquals(0, desafio.getMuestrasRecolectadas());	
	}
}
