package accionesDeProyectoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.EstadoDelDesafio;
import accionesDeProyecto.EstadoEnCurso;
import accionesDeProyecto.EstadoNoRealizado;
import accionesDeProyecto.RestriccionPorFecha;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;
import elementosDelSistema.Muestra;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class EstadoNoRealizadoTest {
	Usuario usuario;
	Desafio desafio;
	DesafioDeUsuario desafioUsuario;
	Muestra muestra;
	Muestra muestra0;
	RestriccionTemporal restriccionPorFecha;
	EstadoDelDesafio desafioNoRealizado;
	EstadoDelDesafio desafioEnCurso;
	Proyecto proyecto;
	PerfilUsuario perfil;
	RecomendacionDeDesafio recomendacion;
	AreaGeografica areaGeografica;
	
		
	@BeforeEach
	void setup() {
		areaGeografica = new AreaGeografica(0.0, 0.0, 1);
		perfil = new PerfilUsuario(5, 5, 5);
		usuario = new Usuario("Juancito", perfil, recomendacion);
		muestra = new Muestra(usuario, 0.0, 1.0);
		muestra0 = new Muestra(usuario, 0.0, 1.0);

		desafioNoRealizado = new EstadoNoRealizado();
		desafioEnCurso = new EstadoEnCurso();
		restriccionPorFecha = new RestriccionPorFecha(LocalDate.now(), LocalDate.now());
		desafio = new Desafio(15, 3, 20, restriccionPorFecha, areaGeografica); //desafío de 15 muestras, dificultad 3
		desafioUsuario = new DesafioDeUsuario(desafio);
		proyecto = new Proyecto("String1", "String2");
	}

	@Test
	void test() {
		assertTrue(desafioUsuario.getEstadoDelDesafio() instanceof EstadoNoRealizado);
	}
		
	@Test
	void cambioDeEstado() {
		//Acá hay que ver como el usuario acepta el desafio, y corroborar que al aceptar cambie de estado
		desafioNoRealizado.cambiarDeEstado(desafioUsuario);
		assertTrue(desafioUsuario.getEstadoDelDesafio() instanceof EstadoEnCurso);
	}
}
