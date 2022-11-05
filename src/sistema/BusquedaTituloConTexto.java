package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public class BusquedaTituloConTexto extends BuscadorSimple {

@Override
public List<Proyecto> buscar(String busqueda) {
		
	for (Proyecto proyecto : proyectos) {
		this.agregar(proyecto, busqueda, resultadoDeBusqueda);
	}
	return resultadoDeBusqueda;
}
		
public List<Proyecto> agregar(Proyecto proyecto, String busqueda, List<Proyecto> resultadoDeBusqueda) {

	if (proyecto.getNombre().contains(busqueda)) {				
		resultadoDeBusqueda.add(proyecto);
	}
	return resultadoDeBusqueda;
}


public Proyecto proyectoIncluyeBusqueda(String string, Proyecto proyecto) {
	// TODO Auto-generated method stub
	return null;
}
}
