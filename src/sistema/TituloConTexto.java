package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public class TituloConTexto extends CriterioDeBusqueda {
	Sistema sistema = new Sistema();
	List<Proyecto> proyectos = sistema.getProyectos();
	
	@Override
	public List<Proyecto> getProyectosBuscados(String busqueda) {
		  List<Proyecto> proyectosResultantes = new ArrayList<Proyecto>();
		
		for (Proyecto proyecto : proyectos) {
			this.agregar(proyecto, busqueda, proyectosResultantes);
		}
		return proyectosResultantes;
	}
	
	public List<Proyecto> agregar(Proyecto proyecto, String busqueda, List<Proyecto> proyectosResultantes) {

		if (proyecto.getNombre().contains(busqueda)) {				
			proyectosResultantes.add(proyecto);
		}
		return proyectosResultantes;
	}

	@Override
	public Proyecto proyectoIncluyeBusqueda(String string, Proyecto proyecto) {
		// TODO Auto-generated method stub
		return null;
	}
}
