package accionesDeProyecto;

import elementosDelSistema.Desafio;

public interface RestriccionTemporal {
	
	public abstract void restringir(Desafio desafio); 
	
	public abstract boolean restringido(Desafio desafio);

	public abstract void agregarRestriccion(RestriccionTemporal restriccionPorSemana);

}
