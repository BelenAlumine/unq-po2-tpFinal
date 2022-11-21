package sistemaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Proyecto;
import sistema.Busqueda;
import sistema.BusquedaExcluyeCategoria;
import sistema.FiltroDeBusqueda;
import sistema.Sistema;

class BusquedaExcluyeCategoriaTest {
	Proyecto proyecto;
	Proyecto proyecto1;
	Proyecto proyecto2;
	FiltroDeBusqueda filtro;
	Busqueda busqueda;
	BusquedaExcluyeCategoria buscadorCategoria;
	Sistema sistema;
	
	@BeforeEach
	void setUp() {
		sistema = new Sistema();
		buscadorCategoria = new BusquedaExcluyeCategoria();
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
		//El buscador excluye el proyecto si hay coincidencia
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto);
		//resultado.add(proyecto);
		
		
		buscadorCategoria.buscar("bio", proyectosARevisar);
		
		assertEquals(0, resultado.size());
		assertFalse(resultado.contains(proyecto));
		assertEquals(resultado, buscadorCategoria.getResultadoDeBusqueda());
		
	}

	@Test
	void busquedaConDosElementosYSinCoincidencia() {
		//El buscador incluye el proyecto porque ninguna categoría coincide
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto1);
		resultado.add(proyecto1);
		
		//buscadorCategoria.setValorBuscado("bio");
		//buscadorCategoria.buscar(proyectosARevisar);
		buscadorCategoria.buscar("bio", proyectosARevisar);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto1));
		assertEquals(resultado, buscadorCategoria.getResultadoDeBusqueda());
	}
	
	@Test
	void busquedaConDosElementosYCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto2);
		
		//buscadorCategoria.setValorBuscado("bio");
		//buscadorCategoria.buscar(proyectosARevisar);
		buscadorCategoria.buscar("bio", proyectosARevisar);
		
		
		assertEquals(0, resultado.size());
		assertFalse(resultado.contains(proyecto2));
		assertEquals(resultado, buscadorCategoria.getResultadoDeBusqueda());
	}
	
	@Test
	void busquedaConDosProyectosYCoincidencia() {
		//Ambos proyectos contienen el valor buscado, no se retorna nada.
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto2);
		proyectosARevisar.add(proyecto);
		
		//buscadorCategoria.setValorBuscado("bio");
		//buscadorCategoria.buscar(proyectosARevisar);
		buscadorCategoria.buscar("bio", proyectosARevisar);
		
		
		assertEquals(0, resultado.size());
		assertFalse(resultado.contains(proyecto2));
		assertFalse(resultado.contains(proyecto1));
		assertEquals(resultado, buscadorCategoria.getResultadoDeBusqueda());
	}
	
	@Test
	void busquedaConDosProyectosYUnaCoincidencia() {
		//Se retorna el proyecto que no contiene el valor buscado
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto1);
		proyectosARevisar.add(proyecto);
		resultado.add(proyecto1);
		
		//buscadorCategoria.setValorBuscado("bio");
		//buscadorCategoria.buscar(proyectosARevisar);
		buscadorCategoria.buscar("bio", proyectosARevisar);
		
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto1));
		assertEquals(resultado, buscadorCategoria.getResultadoDeBusqueda());
	}
}