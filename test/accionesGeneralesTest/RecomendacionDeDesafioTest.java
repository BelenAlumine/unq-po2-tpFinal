package accionesGeneralesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.Favorito;
import accionesGenerales.PreferenciasDeJuego;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;
import sistema.Sistema;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;


class RecomendacionDeDesafioTest {

	Sistema sistemaBase;
	RecomendacionDeDesafio recomendador1;
	PreferenciasDeJuego preferencias1;
	Favorito favorito1;
	Usuario usuarioBase;
	PerfilUsuario perfilBase;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	Desafio desafio6;
	Desafio desafio7;
	Desafio desafio8;
	RestriccionTemporal restriccionBase;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setUp() {
		sistemaBase = mock(Sistema.class);
		recomendador1 = new RecomendacionDeDesafio();
		restriccionBase = mock(RestriccionTemporal.class);
		
		preferencias1 = new PreferenciasDeJuego();
		favorito1 = new Favorito();
		perfilBase = new PerfilUsuario(6, 3, 8);
		usuarioBase = new Usuario("Prueba", perfilBase, recomendador1);
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);
		desafio7 = mock(Desafio.class);
		desafio8 = new Desafio(7, 3, 10, restriccionBase, areaGeografica);
	}
	
	@Test
	void recomendadosSegunTipoPreferenciasDeJuego() {
		when(sistemaBase.getDesafios()).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio4, desafio5, desafio6, desafio7));
		when(desafio1.getMuestrasARecolectar()).thenReturn(9);
		when(desafio1.getDificultad()).thenReturn(4);
		when(desafio1.getRecompensa()).thenReturn(4);
		when(desafio2.getMuestrasARecolectar()).thenReturn(10);
		when(desafio2.getDificultad()).thenReturn(5);
		when(desafio2.getRecompensa()).thenReturn(12);
		when(desafio3.getMuestrasARecolectar()).thenReturn(8);
		when(desafio3.getDificultad()).thenReturn(3);
		when(desafio3.getRecompensa()).thenReturn(10);
		when(desafio4.getMuestrasARecolectar()).thenReturn(7);
		when(desafio4.getDificultad()).thenReturn(3);
		when(desafio4.getRecompensa()).thenReturn(5);
		when(desafio5.getMuestrasARecolectar()).thenReturn(12);
		when(desafio5.getDificultad()).thenReturn(5);
		when(desafio5.getRecompensa()).thenReturn(15);
		when(desafio6.getMuestrasARecolectar()).thenReturn(3);
		when(desafio6.getDificultad()).thenReturn(2);
		when(desafio6.getRecompensa()).thenReturn(6);
		when(desafio7.getMuestrasARecolectar()).thenReturn(4);
		when(desafio7.getDificultad()).thenReturn(3);
		when(desafio7.getRecompensa()).thenReturn(6);
		recomendador1.setSistemaAUsar(sistemaBase);
		recomendador1.setTipoDeRecomendacion(preferencias1);
		List<Desafio> resultado = recomendador1.getRecomendaciones(usuarioBase);
		
		// Las preferencias del perfil de usuario es 6(Muestras) 3(Dificultad) 8(Recompensa)
		assertTrue(resultado.contains(desafio1)); // Coincidencia = 8
		assertFalse(resultado.contains(desafio2)); // Coincidencia = 10
		assertTrue(resultado.contains(desafio3)); // Coincidencia = 4
		assertTrue(resultado.contains(desafio4)); // Coincidencia = 4
		assertFalse(resultado.contains(desafio5)); // Coincidencia = 15 
		assertTrue(resultado.contains(desafio6)); // Coincidencia = 6
		assertTrue(resultado.contains(desafio7)); // Coincidencia = 4
	}
	
	@Test
	void recomendadosSegunTipoFavorito() throws Exception {
		usuarioBase.agregarDesafio(desafio8);
		usuarioBase.votarDesafioCon(desafio8, 4);
		when(sistemaBase.getDesafios()).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio4, desafio5, desafio6, desafio7));
		when(desafio1.getMuestrasARecolectar()).thenReturn(9);
		when(desafio1.getDificultad()).thenReturn(4);
		when(desafio1.getRecompensa()).thenReturn(4);
		when(desafio2.getMuestrasARecolectar()).thenReturn(10);
		when(desafio2.getDificultad()).thenReturn(5);
		when(desafio2.getRecompensa()).thenReturn(12);
		when(desafio3.getMuestrasARecolectar()).thenReturn(9);
		when(desafio3.getDificultad()).thenReturn(3);
		when(desafio3.getRecompensa()).thenReturn(10);
		when(desafio4.getMuestrasARecolectar()).thenReturn(7);
		when(desafio4.getDificultad()).thenReturn(3);
		when(desafio4.getRecompensa()).thenReturn(6);
		when(desafio5.getMuestrasARecolectar()).thenReturn(12);
		when(desafio5.getDificultad()).thenReturn(5);
		when(desafio5.getRecompensa()).thenReturn(15);
		when(desafio6.getMuestrasARecolectar()).thenReturn(3);
		when(desafio6.getDificultad()).thenReturn(2);
		when(desafio6.getRecompensa()).thenReturn(7);
		when(desafio7.getMuestrasARecolectar()).thenReturn(4);
		when(desafio7.getDificultad()).thenReturn(3);
		when(desafio7.getRecompensa()).thenReturn(6);
		recomendador1.setSistemaAUsar(sistemaBase);
		recomendador1.setTipoDeRecomendacion(favorito1);
		List<Desafio> resultado = recomendador1.getRecomendaciones(usuarioBase);
		
		// Los valores del desafio favorito es 7(Muestras) 3(Dificultad) 10(Recompensa)
		assertFalse(resultado.contains(desafio1)); // Similitud = 3
		assertTrue(resultado.contains(desafio2)); // Similitud =  2.33
		assertTrue(resultado.contains(desafio3)); // Similitud =  0.66
		assertTrue(resultado.contains(desafio4)); // Similitud =  1.33
		assertFalse(resultado.contains(desafio5)); // Similitud =  4
		assertTrue(resultado.contains(desafio6)); // Similitud =  2.66
		assertTrue(resultado.contains(desafio7)); // Similitud =  2.33
	}

}
