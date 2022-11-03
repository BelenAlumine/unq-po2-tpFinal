package elementosDelSistemaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
	@BeforeEach
	void setUp() {
		perfilAsociado = mock(PerfilUsuario.class);
		recomendador1 = mock(RecomendacionDeDesafio.class);
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
	}
	
	@Test
	void testPedidoDeDesafios() {
		when(recomendador1.getRecomendaciones(usuarioBase)).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio4));
		usuarioBase.solicitarNuevosDesafiosRecomendados();
		assertEquals(4, usuarioBase.getDesafiosAceptados().size());
	}

}
