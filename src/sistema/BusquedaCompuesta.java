package sistema;

import java.util.List;

import elementosDelSistema.Proyecto;

public abstract class BusquedaCompuesta extends Busqueda {
	public abstract List<Proyecto> buscar(String busqueda);
}
