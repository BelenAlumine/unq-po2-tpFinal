package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public class BusquedaTituloConTexto extends BuscadorSimple {	
	
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
			this.proyectoConValorBuscadoEnTitulo(proyecto, valorBuscado);
		}
		return resultadoDeBusqueda;
	}
	
	public Proyecto proyectoConValorBuscadoEnTitulo(Proyecto proyecto, String valorBuscado) {
		if (proyecto.getNombre().contains(valorBuscado)) {
			resultadoDeBusqueda.add(proyecto);
			return proyecto; //proyectosResultantes.add(proyecto);
		}
		return null;
	}

}
