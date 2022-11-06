package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public class OperadorAND extends BusquedaCompuesta {

	public OperadorAND(FiltroDeBusqueda busqueda1, FiltroDeBusqueda busqueda2) {
		this.busqueda1 = busqueda1;
		this.busqueda2 = busqueda2;
	}
	
	@Override
	public List<Proyecto> buscar(String busqueda) {
		/*FiltroDeBusqueda busqueda1;
	FiltroDeBusqueda busqueda2;
	List<Proyecto> primerResultado = new ArrayList<Proyecto>();
	List<Proyecto> segundoResultado = new ArrayList<Proyecto>();*/
		
		
		/*
		for (Proyecto proyecto : proyectos) {
			this.proyectoIncluyeBusqueda(busqueda, proyecto);
			resultadoDeBusqueda.add(proyecto);
		}
		return resultadoDeBusqueda;
		*/
		return null;
	}
}
