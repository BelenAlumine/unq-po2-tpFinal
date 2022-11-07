package sistemaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Proyecto;
import sistema.Busqueda;
import sistema.BusquedaIncluyeCategoria;
import sistema.FiltroDeBusqueda;

class BusquedaIncluyeCategoriaTest {
	Proyecto proyecto;
	Proyecto proyecto1;
	Proyecto proyecto2;
	FiltroDeBusqueda filtro;
	Busqueda busqueda;
	BusquedaIncluyeCategoria buscadorCategoria;
	
	
	@BeforeEach
	void setUp() {
		buscadorCategoria = new BusquedaIncluyeCategoria();
		proyecto = new Proyecto("bio", "bio");
		proyecto1 = new Proyecto("mateqca", "mate");
		proyecto2 = new Proyecto("bioqca", "qca");
		
		proyecto.getCategorias().add("bio");
		
		proyecto1.getCategorias().add("mate");
		proyecto1.getCategorias().add("qca");
		
		proyecto2.getCategorias().add("qca");
		proyecto2.getCategorias().add("bio");
	}
	
	
	@Test
	void busquedaConUnElementoYCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto);
		resultado.add(proyecto);
		
		buscadorCategoria.setValorBuscado("bio");
		
		buscadorCategoria.buscar(proyectosARevisar);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto));
		assertEquals(resultado, buscadorCategoria.getResultadoDeBusqueda());
		
	}

	@Test
	void busquedaConDosElementosYSinCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto1);
		
		buscadorCategoria.setValorBuscado("bio");
		
		buscadorCategoria.buscar(proyectosARevisar);
		
		assertEquals(0, resultado.size());
		assertFalse(resultado.contains(proyecto1));
		assertEquals(resultado, buscadorCategoria.getResultadoDeBusqueda());
	}
	
	@Test
	void busquedaConDosElementosYCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto2);
		resultado.add(proyecto2);
		
		buscadorCategoria.setValorBuscado("bio");
		
		buscadorCategoria.buscar(proyectosARevisar);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto2));
		assertEquals(resultado, buscadorCategoria.getResultadoDeBusqueda());
	}
}
