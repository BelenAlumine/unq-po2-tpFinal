package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public class BusquedaExcluyeCategoria extends BuscadorSimple {

	@Override
public List<Proyecto> buscar(String busqueda) {
	for (Proyecto proyecto : proyectos) {
		this.proyectoIncluyeBusqueda(busqueda, proyecto);
		resultadoDeBusqueda.add(proyecto);
	}
	return resultadoDeBusqueda;
		
	}
		
public Proyecto proyectoIncluyeBusqueda(String busqueda, Proyecto proyecto) {
	if (!proyecto.getCategorias().contains(busqueda)) {				
		return proyecto; //proyectosResultantes.add(proyecto);
	}
	return null;
	}

}
