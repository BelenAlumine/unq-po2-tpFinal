package sistemaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Proyecto;
import sistema.CriterioDeBusqueda;
import sistema.TituloConTexto;

class BusquedaTituloConTextoTest {
	Proyecto proyecto;
	Proyecto proyecto1;
	Proyecto proyecto2;
	CriterioDeBusqueda busquedaConCategoria;
	
	@BeforeEach
	void setUp() {
		busquedaConCategoria = new TituloConTexto();
		
		proyecto = new Proyecto("bioProy", "bio");
		proyecto1 = new Proyecto("mateProy", "mate");
		proyecto2 = new Proyecto("bioQcaProy", "bio");
		
		proyecto.getCategorias().add("bio");
		
		proyecto1.getCategorias().add("mate");
		proyecto1.getCategorias().add("qca");
		
		proyecto2.getCategorias().add("qca");
		proyecto2.getCategorias().add("bio");
	}

	@Test
	void test() {
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		resultado.add(proyecto);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto));
		assertEquals(1, busquedaConCategoria.getProyectosBuscados("bioProy").size());
		assertEquals(resultado, busquedaConCategoria.getProyectosBuscados("bioProy"));
		
		
		List<Proyecto> resultado1 = new ArrayList<Proyecto>();
		resultado.add(proyecto1);
		
		assertEquals(resultado1, busquedaConCategoria.getProyectosBuscados("bioProy"));
		
		
		List<Proyecto> resultado2 = new ArrayList<Proyecto>();
		resultado.add(proyecto2);
		
		assertEquals(resultado2, busquedaConCategoria.getProyectosBuscados("bioQcaProy"));
	}
}
