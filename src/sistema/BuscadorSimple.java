package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public abstract class BuscadorSimple extends Busqueda {
		
	public abstract List<Proyecto> buscar(List<Proyecto> proyectos);
	
	public List<Proyecto> buscar(String valorBuscado, List<Proyecto> proyectos) {///////////////////////////////////////////////////////////////////////////////////////////
		this.setValorBuscado(valorBuscado);
		return this.buscar(proyectos); 
	}
}
