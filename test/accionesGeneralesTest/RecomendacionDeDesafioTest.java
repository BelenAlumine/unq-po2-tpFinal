package accionesGeneralesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.Favorito;
import accionesGenerales.PreferenciasDeJuego;
import accionesGenerales.RecomendacionDeDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;
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
	
	DesafioDeUsuario desafioUsuario1;
	DesafioDeUsuario desafioUsuario2;
	DesafioDeUsuario desafioUsuario3;
	DesafioDeUsuario desafioUsuario4;
	DesafioDeUsuario desafioUsuario5;
	DesafioDeUsuario desafioUsuario6;
	DesafioDeUsuario desafioUsuario7;
	DesafioDeUsuario desafioUsuario8;
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
		
		desafioUsuario1 = new DesafioDeUsuario(desafio1);
		desafioUsuario2 = new DesafioDeUsuario(desafio2);
		desafioUsuario3 = new DesafioDeUsuario(desafio3);
		desafioUsuario4 = new DesafioDeUsuario(desafio4);
		desafioUsuario5 = new DesafioDeUsuario(desafio5);
		desafioUsuario6 = new DesafioDeUsuario(desafio6);
		desafioUsuario7 = new DesafioDeUsuario(desafio7);
		desafioUsuario8 = new DesafioDeUsuario(desafio8);
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
		List<DesafioDeUsuario> resultado = recomendador1.getRecomendaciones(usuarioBase);
		
		// Las preferencias del perfil de usuario es 6(Muestras) 3(Dificultad) 8(Recompensa)
		// Se realiza una comparación por las muestras a recolectar siendo diferentes en todos los desafios debido 
		// a que no se puede comparar por la igualdad del objeto, pero en la lista resultante se sigue
		// encontrando los desafios con la Coincidencia más cercana
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 9));  // Coincidencia = 8
		assertFalse(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 10)); // Coincidencia = 10
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 8));  // Coincidencia = 4
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 7));  // Coincidencia = 4
		assertFalse(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 12)); // Coincidencia = 15 
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 3));  // Coincidencia = 6
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 4));  // Coincidencia = 4
		
//		assertTrue(resultado.contains(desafioUsuario1)); // Coincidencia = 8
//		assertFalse(resultado.contains(desafioUsuario2)); // Coincidencia = 10
//		assertTrue(resultado.contains(desafioUsuario3)); // Coincidencia = 4
//		assertTrue(resultado.contains(desafioUsuario4)); // Coincidencia = 4
//		assertFalse(resultado.contains(desafioUsuario5)); // Coincidencia = 15 
//		assertTrue(resultado.contains(desafioUsuario6)); // Coincidencia = 6
//		assertTrue(resultado.contains(desafioUsuario7)); // Coincidencia = 4
	} 
	                    // muestras dificultad recompensa
	// desafio8 = new Desafio(7, 3, 10, restriccionBase, areaGeografica);
	@Test
	void recomendadosSegunTipoFavorito() throws Exception {
		usuarioBase.agregarDesafio(desafioUsuario8);
		usuarioBase.votarDesafioCon(desafioUsuario8, 4);
		when(sistemaBase.getDesafios()).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio4, desafio5, desafio6, desafio7));
		when(desafio1.getMuestrasARecolectar()).thenReturn(9);
		when(desafio1.getDificultad()).thenReturn(4);
		when(desafio1.getRecompensa()).thenReturn(4);
		when(desafio2.getMuestrasARecolectar()).thenReturn(10);
		when(desafio2.getDificultad()).thenReturn(5);
		when(desafio2.getRecompensa()).thenReturn(12);
		when(desafio3.getMuestrasARecolectar()).thenReturn(8); // 0.66
		when(desafio3.getDificultad()).thenReturn(3);
		when(desafio3.getRecompensa()).thenReturn(11);
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
		List<DesafioDeUsuario> resultado = recomendador1.getRecomendaciones(usuarioBase);
		
		// Los valores del desafio favorito es 7(Muestras) 3(Dificultad) 10(Recompensa)
		// Se identifica los desafios según las muestras a recolectar, a los desafios que debieron
		// quedar en la lista según la mayor similitud con el desafio favorito
		assertFalse(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 9));  // Similitud = 3
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 10)); // Similitud = 2.33
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 8));  // Similitud = 0.66
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 7));  // Similitud = 1.33
		assertFalse(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 12)); // Similitud = 4
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 3));  // Similitud = 2.66
		assertTrue(resultado.stream().anyMatch(d -> d.getDesafioBase().getMuestrasARecolectar() == 4));  // Similitud = 2.33
		
//		assertFalse(resultado.contains(desafioUsuario1)); // Similitud = 3
//		assertTrue(resultado.contains(desafioUsuario2)); // Similitud =  2.33
//		assertTrue(resultado.contains(desafioUsuario3)); // Similitud =  0.66
//		assertTrue(resultado.contains(desafioUsuario4)); // Similitud =  1.33
//		assertFalse(resultado.contains(desafioUsuario5)); // Similitud =  4
//		assertTrue(resultado.contains(desafioUsuario6)); // Similitud =  2.66
//		assertTrue(resultado.contains(desafioUsuario7)); // Similitud =  2.33
	}

}
