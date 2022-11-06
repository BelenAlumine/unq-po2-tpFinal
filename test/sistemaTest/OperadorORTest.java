package sistemaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elementosDelSistema.Proyecto;
import sistema.Busqueda;
import sistema.BusquedaCompuesta;
import sistema.BusquedaIncluyeCategoria;
import sistema.BusquedaTituloConTexto;
import sistema.FiltroDeBusqueda;
import sistema.OperadorOR;

class OperadorORTest {
	Proyecto proyecto;
	Proyecto proyecto1;
	Proyecto proyecto2;
	FiltroDeBusqueda filtro;
	Busqueda busqueda;
	BusquedaIncluyeCategoria buscadorCategoria;
	BusquedaTituloConTexto buscadorTitulo;
	BusquedaCompuesta buscadorCompuesto;
	OperadorOR buscadorOR;
	
	@BeforeEach
	void setUp() {
		buscadorCategoria = new BusquedaIncluyeCategoria();
		buscadorTitulo = new BusquedaTituloConTexto();
		buscadorOR = new OperadorOR(buscadorCategoria, buscadorTitulo);
		
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
	void busquedaConDosCoincidencias() {
		
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto);
		resultado.add(proyecto);
		
		buscadorCategoria.setValorBuscado("bio");
		buscadorTitulo.setValorBuscado("bio");
		
		buscadorOR.buscar(proyectosARevisar);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto));
		assertEquals(resultado, buscadorOR.getResultadoDeBusqueda());
		
	}

	@Test
	void busquedaConUnaCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto1);
		resultado.add(proyecto1);
		
		buscadorCategoria.setValorBuscado("bio");
		buscadorTitulo.setValorBuscado("mate");
		
		buscadorOR.buscar(proyectosARevisar);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto1));
		assertEquals(resultado, buscadorOR.getResultadoDeBusqueda());
	}
	
	@Test
	void busquedaConDosElementosYCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto2);
		resultado.add(proyecto2);
		
		buscadorCategoria.setValorBuscado("bio");
		buscadorTitulo.setValorBuscado("bio");
		
		buscadorOR.buscar(proyectosARevisar);
		
		assertEquals(1, resultado.size());
		assertTrue(resultado.contains(proyecto2));
		assertEquals(resultado, buscadorOR.getResultadoDeBusqueda());
	}
	
	@Test
	void busquedaConNingunaCoincidencia() {
		List<Proyecto> proyectosARevisar = new ArrayList<Proyecto>();
		List<Proyecto> resultado = new ArrayList<Proyecto>();
		proyectosARevisar.add(proyecto1);
		
		
		buscadorCategoria.setValorBuscado("bio");
		buscadorTitulo.setValorBuscado("bio");
		
		buscadorOR.buscar(proyectosARevisar);
		
		assertEquals(0, resultado.size());
		assertFalse(resultado.contains(proyecto1));
		assertEquals(resultado, buscadorOR.getResultadoDeBusqueda());
	}
}