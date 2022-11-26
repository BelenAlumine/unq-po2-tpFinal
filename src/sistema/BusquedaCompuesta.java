package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public abstract class BusquedaCompuesta extends Busqueda {
	
	
	private FiltroDeBusqueda busqueda1;
	private FiltroDeBusqueda busqueda2;
	
	
	public abstract List<Proyecto> buscar(List<Proyecto> proyecto);
	
	public FiltroDeBusqueda getBusqueda1() {
		return busqueda1;
	}
	
	public FiltroDeBusqueda getBusqueda2() {
		return busqueda2;
	}

	public void setBusqueda1(FiltroDeBusqueda busqueda1) {
		this.busqueda1 = busqueda1;
	}
	
	public void setBusqueda2(FiltroDeBusqueda busqueda2) {
		this.busqueda2 = busqueda2;
	}

	
}
