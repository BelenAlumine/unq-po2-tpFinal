package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public class OperadorOR extends BusquedaCompuesta {

	public OperadorOR(FiltroDeBusqueda primerFiltro, FiltroDeBusqueda segundoFiltro) {
		this.setBusqueda1(primerFiltro);
		this.setBusqueda2(segundoFiltro);
	}
	
	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		this.getPrimerFiltrado().addAll(this.getBusqueda1().buscar(proyectos));
		this.getSegundoFiltrado().addAll(this.getBusqueda2().buscar(proyectos));
		
		for (Proyecto proyecto : proyectos) {
			this.agregarProyecto(proyecto);
		} 
		return this.getResultadoDeBusqueda();
	}

	public void agregarProyecto(Proyecto proyecto) {
		if(primerFiltrado.contains(proyecto) || segundoFiltrado.contains(proyecto)) {
			this.getResultadoDeBusqueda().add(proyecto);
		} 
	}

	@Override
	public List<Proyecto> buscar(String valorBuscado, List<Proyecto> proyectos) {
		// TODO Auto-generated method stub
		return null;
	}
}