package elementosDelSistemaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.Favorito;
import accionesGenerales.RecomendacionDeDesafio;
import accionesGenerales.ValoracionDesafio;
import elementosDelSistema.AreaGeografica;
import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;
import elementosDelSistema.PerfilUsuario;
import elementosDelSistema.Usuario;
import static org.mockito.Mockito.*;

import java.util.Arrays;

class UsuarioTest {

	Usuario usuarioBase;
	Usuario usuarioBase2;
	PerfilUsuario perfilAsociado;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	DesafioDeUsuario desafioUsuario1;
	DesafioDeUsuario desafioUsuario2;
	DesafioDeUsuario desafioUsuario3;
	DesafioDeUsuario desafioUsuario4;
	DesafioDeUsuario desafioUsuario5;
	DesafioDeUsuario desafioUsuario6;
	DesafioDeUsuario desafioUsuario7;
	DesafioDeUsuario desafioUsuario8;
	DesafioDeUsuario desafioUsuario9;
	DesafioDeUsuario desafioUsuario10;
	RecomendacionDeDesafio recomendador1;
	RecomendacionDeDesafio recomendador2;
	Favorito tipoFavorito;
	RestriccionTemporal restriccion1;
	AreaGeografica areaGeografica;
	
	@BeforeEach
	void setUp() {
		perfilAsociado = mock(PerfilUsuario.class);
		recomendador1 = mock(RecomendacionDeDesafio.class);
		restriccion1 = mock(RestriccionTemporal.class);
		usuarioBase = new Usuario("Marcos", perfilAsociado, recomendador1);
		usuarioBase2 = new Usuario("Prueba", perfilAsociado, recomendador2);
		recomendador2 = new RecomendacionDeDesafio();
		desafio1 = new Desafio(3, 5, 8, restriccion1, areaGeografica);
		desafio2 = new Desafio(5, 2, 10, restriccion1, areaGeografica);
		desafio3 = new Desafio(7, 5, 14, restriccion1, areaGeografica);
		desafio4 = new Desafio(3, 4, 6, restriccion1, areaGeografica);
		desafio5 = new Desafio(2, 5, 5, restriccion1, areaGeografica);
		desafioUsuario1 = new DesafioDeUsuario(desafio1);
		desafioUsuario2 = new DesafioDeUsuario(desafio2);
		desafioUsuario3 = new DesafioDeUsuario(desafio3);
		desafioUsuario4 = new DesafioDeUsuario(desafio4);
		desafioUsuario5 = new DesafioDeUsuario(desafio5);
		desafioUsuario6 = mock(DesafioDeUsuario.class);
		desafioUsuario7 = mock(DesafioDeUsuario.class);
		desafioUsuario8 = mock(DesafioDeUsuario.class);
		desafioUsuario9 = mock(DesafioDeUsuario.class);
		desafioUsuario10 = mock(DesafioDeUsuario.class);
	}
	
	@Test
	void testPedidoDeDesafios() {
		when(recomendador1.getRecomendaciones(usuarioBase))
			.thenReturn(Arrays.asList(desafioUsuario1, desafioUsuario2, desafioUsuario3, desafioUsuario4, desafioUsuario5));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		assertEquals(5, usuarioBase.getDesafiosAceptados().size());
	}
	
    // Verifica que no se agregan mas de 5 desafios al usuario
	@Test
	void testSegundoPedidoDeDesafios() {
		when(recomendador1.getRecomendaciones(usuarioBase))
				.thenReturn(Arrays.asList(desafioUsuario1, desafioUsuario2, desafioUsuario3, desafioUsuario5, desafioUsuario4, desafioUsuario7));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		when(recomendador1.getRecomendaciones(usuarioBase)).thenReturn(Arrays.asList(desafioUsuario9, desafioUsuario8, desafioUsuario5));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		assertEquals(5, usuarioBase.getDesafiosAceptados().size());
	}
	
	// Verificar que el desafio con la mayor votación se toma como el desafio que mas le gusta al usuario
	@Test
	void testVotacionDeDesafioYMayorVotado() throws Exception {
		when(recomendador1.getRecomendaciones(usuarioBase))
			.thenReturn(Arrays.asList(desafioUsuario1, desafioUsuario2, desafioUsuario3, desafioUsuario5, desafioUsuario4));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		usuarioBase.votarDesafioCon(desafioUsuario1, 3);
		usuarioBase.votarDesafioCon(desafioUsuario2, 4);
		usuarioBase.votarDesafioCon(desafioUsuario3, 2);
		usuarioBase.votarDesafioCon(desafioUsuario4, 3);
		usuarioBase.votarDesafioCon(desafioUsuario5, 1);
		assertEquals(desafio2, usuarioBase.desafioQueMasLeGusto());
	}
	
	@Test
	void testDeCompletitudDeUnDesafio() {
		usuarioBase.agregarDesafio(desafioUsuario3);
		desafioUsuario3.sumarMuestraCargada();
		desafioUsuario3.sumarMuestraCargada();
		desafioUsuario3.sumarMuestraCargada();
		desafioUsuario3.sumarMuestraCargada();
		assertEquals(57.14286f, usuarioBase.porcentajeCompletitudDeDesafio(desafioUsuario3));
	}

	@Test
	void testDeCompletitudTotal() {
		usuarioBase.agregarDesafio(desafioUsuario6);
		usuarioBase.agregarDesafio(desafioUsuario7);
		usuarioBase.agregarDesafio(desafioUsuario8);
		usuarioBase.agregarDesafio(desafioUsuario9);
		usuarioBase.agregarDesafio(desafioUsuario10);
		when(desafioUsuario6.porcentajeDeCompletitud()).thenReturn(100f);
		when(desafioUsuario7.porcentajeDeCompletitud()).thenReturn(95f);
		when(desafioUsuario8.porcentajeDeCompletitud()).thenReturn(72.5f);
		when(desafioUsuario9.porcentajeDeCompletitud()).thenReturn(50f);
		when(desafioUsuario10.porcentajeDeCompletitud()).thenReturn(36.5f);
		assertEquals(70.8f, usuarioBase.porcentajeDeCompletitudTotal());
	}
	
}
