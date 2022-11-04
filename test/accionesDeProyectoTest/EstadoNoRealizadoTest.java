package accionesDeProyectoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionTemporal;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class EstadoNoRealizadoTest {
	Usuario usuario;
	Desafio desafio;
	Muestra muestra;
	Muestra muestra0;
	RestriccionTemporal restriccionPorFecha;
	EstadoDelDesafio desafioNoRealizado;
	EstadoDelDesafio desafioEnCurso;
	Proyecto proyecto;
	PerfilUsuario perfil;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setup() {
		areaGeografica = mock(AreaGeografica.class);
		perfil = new PerfilUsuario();
		usuario = new Usuario("Juancito", perfil);
		muestra = new Muestra(usuario, areaGeografica);
		muestra0 = new Muestra(usuario, areaGeografica);
		desafioNoRealizado = new EstadoNoRealizado();
		desafioEnCurso = new EstadoEnCurso();
		restriccionPorFecha = new RestriccionPorFecha(LocalDate.now(), LocalDate.now());
		desafio = new Desafio(15, 2, restriccionPorFecha); //desaf�o de 15 muestras, nivel 3
		proyecto = new Proyecto("String1", "String2");
	}

	@Test
	void test() {
		assertTrue(desafio.getEstadoDelDesafio() instanceof EstadoNoRealizado);
	}
	
	@Test
	void cambioDeEstado() {
		//Ac� hay que ver c�mo el usuario acepta el desafio, y corroborar que al aceptar cambie de estado
		desafioNoRealizado.cambiarDeEstado(desafio);
		assertTrue(desafio.getEstadoDelDesafio() instanceof EstadoEnCurso);
	}
}
