package accionesGeneralesTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.Favorito;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.Usuario;

class TipoFavorito {

	Favorito favoritoBase;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	Desafio desafio6;
	Desafio desafio7;
	RestriccionTemporal restriccionBase;
	Usuario usuarioBase;
	
	@BeforeEach
	void setUp() {
		favoritoBase = new Favorito();
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);
		usuarioBase = mock(Usuario.class);
		desafio7 = new Desafio(7, 3, 10, restriccionBase);
	}
	
	@Test
	void testCalculoDeSimilitud1() {
		when(desafio1.getMuestrasARecolectar()).thenReturn(10);
		when(desafio1.getDificultad()).thenReturn(4);
		when(desafio1.getRecompensa()).thenReturn(11);
		assertEquals(1.6666666f, favoritoBase.calcularSimilitud(desafio1, desafio7));
	}

	@Test
	void testCalculoDeSimilitud2() {
		when(desafio1.getMuestrasARecolectar()).thenReturn(10);
		when(desafio1.getDificultad()).thenReturn(4);
		when(desafio1.getRecompensa()).thenReturn(12);
		assertEquals(2f, favoritoBase.calcularSimilitud(desafio1, desafio7));
	}
	
	@Test
	void desafiosConSimilitudAsociadaTest() {
		when(usuarioBase.desafioQueMasLeGusto()).thenReturn(desafio7);
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
		List<Desafio> desafios = Arrays.asList(desafio1, desafio2, desafio3, desafio4, desafio5, desafio6);
		LinkedHashMap<Desafio, Float> resultado = favoritoBase.desafiosAsociadosASimilitud(desafios, usuarioBase);
		assertEquals(3f, resultado.get(desafio1));
		assertEquals(2.3333333f, resultado.get(desafio2));
		assertEquals(0.66666667f, resultado.get(desafio3));
		assertEquals(1.3333334f, resultado.get(desafio4));
		assertEquals(4f, resultado.get(desafio5));
		assertEquals(2.6666667f, resultado.get(desafio6));
	}
}



