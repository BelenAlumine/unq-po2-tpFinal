package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public class BusquedaIncluyeCategoria extends BuscadorSimple {
	

	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		for (Proyecto proyecto : proyectos) {
			this.proyectoIncluyeValor(proyecto, valorBuscado);
		}
		return resultadoDeBusqueda;
	}
	
	public Proyecto proyectoIncluyeValor(Proyecto proyecto, String valorBuscado) {
		if (proyecto.getCategorias().contains(valorBuscado)) {
			resultadoDeBusqueda.add(proyecto);
			return proyecto; //proyectosResultantes.add(proyecto);
		}
		return null;
	}

}
