package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public abstract class BusquedaCompuesta extends Busqueda {
	
	FiltroDeBusqueda busqueda1;
	FiltroDeBusqueda busqueda2;
	List<Proyecto> primerResultado = new ArrayList<Proyecto>();
	List<Proyecto> segundoResultado = new ArrayList<Proyecto>();
	
	public abstract List<Proyecto> buscar(String busqueda);
	
	public FiltroDeBusqueda getBusqueda1() {
		return busqueda1;
	}
	
	public FiltroDeBusqueda getBusqueda2() {
		return busqueda2;
	}

	public void setBusqueda1(FiltroDeBusqueda busqueda1) {
		this.busqueda1 = busqueda1;
	}

	public void setPrimerResultado(List<Proyecto> primerResultado) {
		this.primerResultado = primerResultado;
	}

	public void setSegundoResultado(List<Proyecto> segundoResultado) {
		this.segundoResultado = segundoResultado;
	}

	public List<Proyecto> getPrimerResultado() {
		return primerResultado;
	}

	public List<Proyecto> getSegundoResultado() {
		return segundoResultado;
	}

	public void setBusqueda2(FiltroDeBusqueda busqueda2) {
		this.busqueda2 = busqueda2;
	}
	
	
}
