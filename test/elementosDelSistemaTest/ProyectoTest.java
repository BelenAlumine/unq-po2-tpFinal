package elementosDelSistemaTest;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Muestra;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

class ProyectoTest {
	
	Proyecto proyectoBio;
	Usuario usuario;
	Muestra arbol;
	
	@BeforeEach
	void setup() {
		proyectoBio = new Proyecto("Proyecto de biología", "Un proyecto para aprender de las plantas.");
		usuario = new Usuario();
		arbol = new Muestra(usuario);
	}

	@Test
	void cargarInformacionAlProyecto() { 
	  assertEquals(0, proyectoBio.getParticipantes().size());
	  assertEquals(0, proyectoBio.getDesafios().size());
	  assertEquals(0, proyectoBio.getMuestras().size());
	  
	  proyectoBio.suscribirParticipante(usuario);
	  assertEquals(1, proyectoBio.getParticipantes().size());
	  
	  proyectoBio.agregarMuestra(arbol);
	  assertEquals(1, proyectoBio.getMuestras().size());
	}

}