package sistemaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Proyecto;
import sistema.Busqueda;
import sistema.BusquedaTituloConTexto;
import sistema.FiltroDeBusqueda;

class BusquedaTituloConTextoTest {
	Proyecto proyecto;
	Proyecto proyecto1;
	Proyecto proyecto2;
	FiltroDeBusqueda filtro;
	Busqueda busqueda;
	BusquedaTituloConTexto buscadorTitulo;
	
	
	@BeforeEach
	void setUp() {
		buscadorTitulo = new BusquedaTituloConTexto();
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
	void proyectoIncluye() {
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		resultado.add(proyecto);
		
		
		/*assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto));
		assertEquals(proyecto, busquedaConCategoria.proyectoIncluyeBusqueda("bio", proyecto));
		///
		List<Proyecto> resultado1 = new ArrayList<Proyecto>();
		resultado.add(proyecto1);
		
		assertEquals(resultado1, busquedaConCategoria.getProyectosBuscados("bio"));
		assertEquals(null, busquedaConCategoria.proyectoIncluyeBusqueda("bio", proyecto1));
		///
		List<Proyecto> resultado2 = new ArrayList<Proyecto>();
		resultado.add(proyecto2);
		
		assertEquals(proyecto2, busquedaConCategoria.proyectoIncluyeBusqueda("bio", proyecto2));
		assertEquals(resultado2, busquedaConCategoria.getProyectosBuscados("bio"));
		*/
	}
	
	@Test
	void busquedaConCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto);
		resultado.add(proyecto);
		
		//buscadorCategoria = new BusquedaIncluyeCategoria(proyectosARevisar);
		buscadorTitulo.setValorBuscado("bio");
		
		buscadorTitulo.buscar(proyectosARevisar);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto));
		assertEquals(resultado, buscadorTitulo.getResultadoDeBusqueda());
		
	}

	@Test
	void busquedaSinCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto1);
		
		//buscadorCategoria = new BusquedaIncluyeCategoria(proyectosARevisar);
		buscadorTitulo.setValorBuscado("bio");
		
		buscadorTitulo.buscar(proyectosARevisar);
		
		assertEquals(0, resultado.size());
		assertFalse(resultado.contains(proyecto1));
		assertEquals(resultado, buscadorTitulo.getResultadoDeBusqueda());
	}
	
	@Test
	void busquedaConCoincidencia2() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto2);
		resultado.add(proyecto2);
		
		//buscadorCategoria = new BusquedaIncluyeCategoria(proyectosARevisar);
		buscadorTitulo.setValorBuscado("bio");
		
		buscadorTitulo.buscar(proyectosARevisar);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto2));
		assertEquals(resultado, buscadorTitulo.getResultadoDeBusqueda());
	}
}
