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
		this.setPrimerFiltrado(this.getBusqueda1().buscar(proyectos));
		this.setSegundoFiltrado(this.getBusqueda2().buscar(proyectos));
		this.setResultadoDeBusqueda(this.getPrimerFiltrado());
		
		for (Proyecto proyecto : this.getSegundoFiltrado()) {
			this.agregarProyecto(proyecto);
		}
		return resultadoDeBusqueda; 
	}

	public void agregarProyecto(Proyecto proyecto) {
		if (!this.getPrimerFiltrado().contains(proyecto) && !resultadoDeBusqueda.contains(proyecto)) {
			this.getResultadoDeBusqueda().add(proyecto);
		}
	}
}