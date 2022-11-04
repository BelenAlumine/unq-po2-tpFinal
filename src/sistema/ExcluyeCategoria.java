package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public class ExcluyeCategoria extends CriterioDeBusqueda {
	Sistema sistema = new Sistema();
	List<Proyecto> proyectos = sistema.getProyectos();
	List<Proyecto> proyectosResultantes = new ArrayList<Proyecto>();

	@Override
	public List<Proyecto> getProyectosBuscados(String busqueda) {
		for (Proyecto proyecto : proyectos) {
			this.proyectoIncluyeBusqueda(busqueda, proyecto);
			proyectosResultantes.add(proyecto);
		}
		return proyectosResultantes;
	
	}
	
	public Proyecto proyectoIncluyeBusqueda(String busqueda, Proyecto proyecto) {
		if (!proyecto.getCategorias().contains(busqueda)) {				
			return proyecto; //proyectosResultantes.add(proyecto);
		}
		return null;
	}
	/*
	@Override
	public List<Proyecto> getProyectosBuscados(String busqueda) {
		  List<Proyecto> proyectosResultantes = new ArrayList<Proyecto>();
		
		for (Proyecto proyecto : proyectos) {
			this.agregar(proyecto, busqueda, proyectosResultantes);
		}
		return proyectosResultantes;
	}
	
	public List<Proyecto> agregar(Proyecto proyecto, String busqueda, List<Proyecto> proyectosResultantes) {
		
		for(String categoria : proyecto.getCategorias()) {
			if (!proyecto.getCategorias().contains(busqueda)) {				
				proyectosResultantes.add(proyecto);
			}
		}
		return proyectosResultantes;
	}
*/
}
