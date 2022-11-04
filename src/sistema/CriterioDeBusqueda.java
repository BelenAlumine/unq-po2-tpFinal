package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public abstract class CriterioDeBusqueda {


	public List<Proyecto> getProyectosBuscados(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	abstract public Proyecto proyectoIncluyeBusqueda(String string, Proyecto proyecto);
	
}
