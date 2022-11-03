package elementosDelSistemaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import accionesDeProyecto.RestriccionTemporal;
import accionesGenerales.RecomendacionDeDesafio;
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
	RecomendacionDeDesafio recomendador1;
	RecomendacionDeDesafio recomendador2;
	RestriccionTemporal restriccion1;
	
	@BeforeEach
	void setUp() {
		perfilAsociado = mock(PerfilUsuario.class);
		recomendador1 = mock(RecomendacionDeDesafio.class);
		restriccion1 = mock(RestriccionTemporal.class);
		usuarioBase = new Usuario("Marcos", perfilAsociado, recomendador1);
		desafio1 = new Desafio(3, 5, restriccion1);
		desafio2 = new Desafio(5, 2, restriccion1);
		desafio3 = new Desafio(7, 5, restriccion1);
		desafio4 = new Desafio(3, 4, restriccion1);
		desafio5 = new Desafio(2, 5, restriccion1);
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
	void testVotacionDeDesafioYMayorVotado() {
		when(recomendador1.getRecomendaciones(usuarioBase)).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio5, desafio4));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		usuarioBase.votarDesafioCon(desafio3, 3);
		usuarioBase.votarDesafioCon(desafio2, 4);
		usuarioBase.votarDesafioCon(desafio4, 3);
		assertEquals(desafio2, usuarioBase.desafioQueMasLeGusto());
	}

}
