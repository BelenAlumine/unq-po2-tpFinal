package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public class BusquedaExcluyeCategoria extends BuscadorSimple {
	String valorBuscado;
	

	public String getValorBuscado() {
		return valorBuscado;
	}

	public void setValorBuscado(String valorBuscado) {
		this.valorBuscado = valorBuscado;
	}

	@Override
	public List<Proyecto> buscar(List<Proyecto> proyectos) {
		for (Proyecto proyecto : proyectos) {
			this.proyectoExcluyeValor(proyecto, valorBuscado);
		}
		return resultadoDeBusqueda;
	}
	
	public Proyecto proyectoExcluyeValor(Proyecto proyecto, String valorBuscado) {
		if (!proyecto.getCategorias().contains(valorBuscado)) {
			resultadoDeBusqueda.add(proyecto);
			return proyecto;
		}
		return null;
	}
}