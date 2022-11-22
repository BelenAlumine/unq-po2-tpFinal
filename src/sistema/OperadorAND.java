package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public class OperadorAND extends BusquedaCompuesta {
	
	public OperadorAND(FiltroDeBusqueda primerFiltro, FiltroDeBusqueda segundoFiltro) {
		this.setBusqueda1(primerFiltro);
		this.setBusqueda2(segundoFiltro);
	}
	
	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		this.getPrimerFiltrado().addAll(this.getBusqueda1().buscar(proyectos));
		this.getSegundoFiltrado().addAll(this.getBusqueda2().buscar(proyectos));
		
		for (Proyecto proyecto : primerFiltrado) {
			this.agregarProyecto(proyecto);
		} 
		return this.getResultadoDeBusqueda();
	}

	public void agregarProyecto(Proyecto proyecto) {
		if(segundoFiltrado.contains(proyecto)) {
			this.getResultadoDeBusqueda().add(proyecto);
		}
	}
	
	@Override
	public List<Proyecto> buscar(String valorBuscado, List<Proyecto> proyectos) {
		// TODO Auto-generated method stub
		return null;
	}
}
