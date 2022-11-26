package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public class OperadorAND extends BusquedaCompuesta {
	
	public OperadorAND(FiltroDeBusqueda primerFiltro, FiltroDeBusqueda segundoFiltro) {
		this.setBusqueda1(primerFiltro);
		this.setBusqueda2(segundoFiltro);
	}
	
	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		
		List<Proyecto> primerFiltrado = new ArrayList<Proyecto>();
		List<Proyecto> segundoFiltrado = new ArrayList<Proyecto>();
		primerFiltrado.addAll(this.getBusqueda1().buscar(proyectos));
		segundoFiltrado.addAll(this.getBusqueda2().buscar(proyectos));
		
		for (Proyecto proyecto : primerFiltrado) {
			if(segundoFiltrado.contains(proyecto)) {
				this.agregarProyectoFiltradoAResultado(proyecto);
			}
		} 
		return this.getResultadoDeBusqueda();
	}

	public void agregarProyectoFiltradoAResultado(Proyecto proyecto) {
		this.getResultadoDeBusqueda().add(proyecto);
	}
	
	@Override
	public List<Proyecto> buscar(String valorBuscado, List<Proyecto> proyectos) {
		// TODO Auto-generated method stub
		return null;
	}
}
