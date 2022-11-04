package elementosDelSistemaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.RecomendacionDeDesafio;
import accionesGenerales.ValoracionDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;
import static org.mockito.Mockito.*;

import java.util.Arrays;

class UsuarioTest {

	Usuario usuarioBase;
	PerfilUsuario perfilAsociado;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	Desafio desafio6;
	Desafio desafio7;
	Desafio desafio8;
	Desafio desafio9;
	Desafio desafio10;
	RecomendacionDeDesafio recomendador1;
	RecomendacionDeDesafio recomendador2;
	RestriccionTemporal restriccion1;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setUp() {
		perfilAsociado = mock(PerfilUsuario.class);
		recomendador1 = mock(RecomendacionDeDesafio.class);
		restriccion1 = mock(RestriccionTemporal.class);
		usuarioBase = new Usuario("Marcos", perfilAsociado, recomendador1);
		desafio1 = new Desafio(3, 5, 8, restriccion1, areaGeografica);
		desafio2 = new Desafio(5, 2, 10, restriccion1, areaGeografica);
		desafio3 = new Desafio(7, 5, 14, restriccion1, areaGeografica);
		desafio4 = new Desafio(3, 4, 6, restriccion1, areaGeografica);
		desafio5 = new Desafio(2, 5, 5, restriccion1, areaGeografica);
		desafio6 = mock(Desafio.class);
		desafio7 = mock(Desafio.class);
		desafio8 = mock(Desafio.class);
		desafio9 = mock(Desafio.class);
		desafio10 = mock(Desafio.class);
	}
	
	@Test
	void testPedidoDeDesafios() {
		when(recomendador1.getRecomendaciones(usuarioBase)).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio4, desafio5));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		assertEquals(5, usuarioBase.getDesafiosAceptados().size());
	}
	
    // Verifica que no se agregan mas de 5 desafios al usuario
	@Test
	void testSegundoPedidoDeDesafios() {
		when(recomendador1.getRecomendaciones(usuarioBase)).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio5, desafio4, desafio3));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		when(recomendador1.getRecomendaciones(usuarioBase)).thenReturn(Arrays.asList(desafio3, desafio4, desafio5));
		assertEquals(5, usuarioBase.getDesafiosAceptados().size());
	}
	
	@Test
	void testVotacionDeDesafioYMayorVotado() throws Exception {
		when(recomendador1.getRecomendaciones(usuarioBase)).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio5, desafio4));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		usuarioBase.votarDesafioCon(desafio1, 3);
		usuarioBase.votarDesafioCon(desafio2, 4);
		usuarioBase.votarDesafioCon(desafio3, 2);
		usuarioBase.votarDesafioCon(desafio4, 3);
		usuarioBase.votarDesafioCon(desafio5, 1);
		assertEquals(desafio2, usuarioBase.desafioQueMasLeGusto());
	}
	
	@Test
	void testDeCompletitudDeUnDesafio() {
		usuarioBase.agregarDesafio(desafio3);
		desafio3.sumarMuestraCargada();
		desafio3.sumarMuestraCargada();
		desafio3.sumarMuestraCargada();
		desafio3.sumarMuestraCargada();
		assertEquals(57.14286f, usuarioBase.porcentajeCompletitudDeDesafio(desafio3));
	}

	@Test
	void testDeCompletitudTotal() {
		usuarioBase.agregarDesafio(desafio6);
		usuarioBase.agregarDesafio(desafio7);
		usuarioBase.agregarDesafio(desafio8);
		usuarioBase.agregarDesafio(desafio9);
		usuarioBase.agregarDesafio(desafio10);
		when(desafio6.porcentajeDeCompletitud()).thenReturn(100f);
		when(desafio7.porcentajeDeCompletitud()).thenReturn(95f);
		when(desafio8.porcentajeDeCompletitud()).thenReturn(72.5f);
		when(desafio9.porcentajeDeCompletitud()).thenReturn(50f);
		when(desafio10.porcentajeDeCompletitud()).thenReturn(36.5f);
		assertEquals(70.8f, usuarioBase.porcentajeDeCompletitudTotal());
	}
}
