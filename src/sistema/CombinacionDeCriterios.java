package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public class CombinacionDeCriterios extends CriterioDeBusqueda {
	List<CriterioDeBusqueda> criteriosDeBusqueda = new ArrayList<CriterioDeBusqueda>();
	List<Proyecto> proyectosResultantes = new ArrayList<Proyecto>();
	
	public void agregarCriteriosDeBusqueda(CriterioDeBusqueda criterio) { 
		criteriosDeBusqueda.add(criterio);		
	}
	
	@Override
	public List<Proyecto> getProyectosBuscados(String busqueda) {
		
		
		for (CriterioDeBusqueda criterio : criteriosDeBusqueda) {
			proyectosResultantes.addAll(criterio.getProyectosBuscados(busqueda));
		}
		return proyectosResultantes; 
	}

	@Override
	public Proyecto proyectoIncluyeBusqueda(String string, Proyecto proyecto) {
		// TODO Auto-generated method stub
		return null;
	}
}
