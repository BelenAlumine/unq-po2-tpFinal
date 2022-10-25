package elementosDelSistemaTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Proyecto;
/*@Run With(MockitoJUnitRunner.class)*/

class ProyectoTest {
	
	/*@Mock
	 Usuario usuario1 Mock;*/
	Proyecto proyectoBio;
	
	/*@Inyect Mocks
	 Proyecto proyecto2;*/
	
	@BeforeEach
	void setup() {
		proyectoBio = new Proyecto("Proyecto de biología", "Un proyecto para aprender de las plantas.");
	}

	@Test
	void test() {
	/*Usuario usuario1 = mock(UsuarioMock);
	  doReturn...*/ //config mock
		
	/*Proyecto proyecto = new Proyecto("Proyecto 2", "Proyecto con mock");
	  proyecto2.suscribirParticipante(usuario1); */ //realizar la prueba
		
	/*int expected = 1;
	  assertEquals(1, proyecto.getParticipantes().size;*/
	}

}