package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public interface FiltroDeBusqueda {
	
	public abstract List<Proyecto> buscar(String string);
	
}
