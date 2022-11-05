package sistemaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Proyecto;
import sistema.CriterioDeBusqueda;
import sistema.IncluyeCategoria;

class BusquedaExcluyeCategoriaTest {
	Proyecto proyecto;
	Proyecto proyecto1;
	Proyecto proyecto2;
	CriterioDeBusqueda busquedaConCategoria;
	
	@BeforeEach
	void setUp() {
		busquedaConCategoria = new IncluyeCategoria();
		
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
		
		assertEquals(1, resultado.size());
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
		
	}
	
	@Test
	void test() {
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		resultado.add(proyecto);
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto));
		assertEquals(null, busquedaConCategoria.getProyectosBuscados("bio"));
		
		
		List<Proyecto> resultado1 = new ArrayList<Proyecto>();
		resultado.add(proyecto1);
		assertEquals(resultado1, busquedaConCategoria.getProyectosBuscados("bio"));
		
		
		List<Proyecto> resultado2 = new ArrayList<Proyecto>();
		resultado.add(proyecto2);
		assertEquals(null, busquedaConCategoria.getProyectosBuscados("bio"));
		
	}
}
