package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public abstract class BuscadorSimple extends Busqueda {
	String valorBuscado;
	

	public String getValorBuscado() {
		return valorBuscado;
	}

	public void setValorBuscado(String valorBuscado) {
		this.valorBuscado = valorBuscado;
	}
	
	public abstract List<Proyecto> buscar(List<Proyecto> proyectos);

}
