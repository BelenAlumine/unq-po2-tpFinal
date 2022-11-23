package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Proyecto;

public abstract class Busqueda implements FiltroDeBusqueda {
	String valorBuscado;
	
	List<Proyecto> resultadoDeBusqueda = new ArrayList<Proyecto>();
	
	public abstract List<Proyecto> buscar(List<Proyecto> proyectos);
	
	public abstract List<Proyecto> buscar(String valorBuscado, List<Proyecto> proyectos);
	
	public void agregarProyectoAlResultado(Proyecto proyecto) {
		resultadoDeBusqueda.add(proyecto);
	}
	
	public List<Proyecto> getResultadoDeBusqueda() {
		return resultadoDeBusqueda;
	}

	public void setResultadoDeBusqueda(List<Proyecto> resultadoDeBusqueda) {
		this.resultadoDeBusqueda = resultadoDeBusqueda;
	}
	
	public String getValorBuscado() {
		return valorBuscado;
	}

	public void setValorBuscado(String valorBuscado) {
		this.valorBuscado = valorBuscado;
	}

}
