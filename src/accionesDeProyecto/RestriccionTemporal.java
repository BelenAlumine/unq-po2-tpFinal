package accionesDeProyecto;

import elementosDelSistema.DesafioDeUsuario;

public interface RestriccionTemporal {
	
	public abstract void restringir(DesafioDeUsuario desafio); 
	
	public abstract boolean restringido(DesafioDeUsuario desafio);

	public abstract void agregarRestriccion(RestriccionTemporal restriccionPorSemana);

}
