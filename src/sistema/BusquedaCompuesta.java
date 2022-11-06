package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public abstract class BusquedaCompuesta extends Busqueda {
	
	FiltroDeBusqueda busqueda1;
	FiltroDeBusqueda busqueda2;
	List<Proyecto> primerFiltrado = new ArrayList<Proyecto>();
	List<Proyecto> segundoFiltrado = new ArrayList<Proyecto>();
	
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

	public void setPrimerFiltrado(List<Proyecto> primerResultado) {
		this.primerFiltrado = primerResultado;
	}

	public void setSegundoFiltrado(List<Proyecto> segundoResultado) {
		this.segundoFiltrado = segundoResultado;
	}

	public List<Proyecto> getPrimerFiltrado() {
		return primerFiltrado;
	}

	public List<Proyecto> getSegundoFiltrado() {
		return segundoFiltrado;
	}

	public void setBusqueda2(FiltroDeBusqueda busqueda2) {
		this.busqueda2 = busqueda2;
	}
	
	
}
