package accionesDeProyectoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.Usuario;

class EstadoNoRealizadoTest {
	Usuario usuario;
	Desafio desafio;
	Muestra muestra;
	Muestra muestra0;
	RestriccionTemporal restriccionPorFecha;
	EstadoDelDesafio desafioNoRealizado;
	EstadoDelDesafio desafioEnCurso;
	
	@BeforeEach
	void setup() {
		usuario = new Usuario();
		muestra = new Muestra(usuario);
		muestra0 = new Muestra(usuario);
		desafioNoRealizado = new EstadoNoRealizado();
		desafioEnCurso = new EstadoEnCurso();
		restriccionPorFecha = new RestriccionPorFecha(LocalDate.now());
		desafio = new Desafio(15, 2, restriccionPorFecha); //desafío de 15 muestras, nivel 3
	}

	@Test
	void test() {
		assertTrue(desafio.getEstadoDelDesafio() instanceof EstadoNoRealizado);
	}
	
	@Test
	void cambioDeEstado() {
		List<Muestra> muestrasSubidas = new ArrayList<Muestra>();
		
		muestrasSubidas.add(muestra);//Acá hay que poner usuario.agregarMuestra(proyecto)
		                             //el agregar debería ver si la restriccion es FALSE y si el estado es en curso
		assertTrue(desafio.getEstadoDelDesafio() instanceof EstadoEnCurso);
	}
}
