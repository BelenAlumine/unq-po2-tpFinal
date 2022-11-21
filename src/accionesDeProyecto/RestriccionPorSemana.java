package accionesDeProyecto;


import elementosDelSistema.Desafio;

public class RestriccionPorSemana extends RestriccionTemporalSimple  {
	
	
	public RestriccionPorSemana() {
		
	}
	
	@Override
	public void restringir(Desafio desafio) {
		
		if (this.restringido(desafio)) {
			desafio.setDesafioRestringido(false); 
		} else {
			desafio.setDesafioRestringido(true);
		}
	}
	

	@Override
	public boolean restringido(Desafio desafio) {
		return !this.esFinDeSemana(desafio);
	}

	@Override
	public void agregarRestriccion(RestriccionTemporal restriccionPorSemana) {
		// TODO Auto-generated method stub
		
	}
}
