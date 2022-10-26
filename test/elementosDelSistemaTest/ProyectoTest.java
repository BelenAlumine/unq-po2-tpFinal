package elementosDelSistemaTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test.*;

import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class ProyectoTest {
	
	Proyecto proyectoBio;
	
	@Mock
	Usuario usuario1;
	Proyecto proyecto2;
	
	@BeforeEach
	void setup() {
		proyectoBio = new Proyecto("Proyecto de biología", "Un proyecto para aprender de las plantas.");
	}

	@Test
	void test() {
	//Usuario usuario1 = mock();
	  /*doReturn...*/ //config mock
		
	Proyecto proyecto = new Proyecto("Proyecto 2", "Proyecto con mock");
	  proyecto2.suscribirParticipante(usuario1);  //realizar la prueba
		
	int expected = 1;
	  assertEquals(1, proyecto.getParticipantes().size());
	}

}