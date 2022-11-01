package accionesDeProyecto;



import elementosDelSistema.Desafio;


public abstract class RestriccionTemporal {

	
	public void restringir(Desafio desafio) {
		desafio.setRestriccion(this);
	}
	
	public void agregarRestriccion() {
		
	}
}
