package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public class OperadorOR extends BusquedaCompuesta {

	public OperadorOR(FiltroDeBusqueda primerFiltro, FiltroDeBusqueda segundoFiltro) {
		this.setBusqueda1(primerFiltro);
		this.setBusqueda2(segundoFiltro);
	}
	
	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		
		List<Proyecto> primerFiltrado = new ArrayList<Proyecto>();
		List<Proyecto> segundoFiltrado = new ArrayList<Proyecto>();
		primerFiltrado.addAll(this.getBusqueda1().buscar(proyectos));
		segundoFiltrado.addAll(this.getBusqueda2().buscar(proyectos));
		
		this.getResultadoDeBusqueda().addAll(primerFiltrado);
		
		for (Proyecto proyecto : segundoFiltrado) {
			this.agregarProyectoFiltradoAResultado(proyecto);
		} 
		return this.getResultadoDeBusqueda();
	}

	public void agregarProyectoFiltradoAResultado(Proyecto proyecto) {
		if(!(this.getResultadoDeBusqueda().contains(proyecto))) {
			this.getResultadoDeBusqueda().add(proyecto);
		} 
	}

	@Override
	public List<Proyecto> buscar(String valorBuscado, List<Proyecto> proyectos) {
		// TODO Auto-generated method stub
		return null;
	}
}