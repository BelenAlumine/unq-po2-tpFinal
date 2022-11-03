package accionesDeProyecto;


import elementosDelSistema.Desafio;

public class RestriccionPorFinDeSemana extends RestriccionTemporal {
	
	public RestriccionPorFinDeSemana() {
		
	}
	
	@Override
	public void restringir(Desafio desafio) {
		
		if (this.esSabado(desafio) || this.esDomingo(desafio)) {
			desafio.setDesafioRestringido(false);
		} else {
			desafio.setDesafioRestringido(true);
		}
	}

	@Override
	public boolean restringido(Desafio desafio) {
		return this.esFinDeSemana(desafio);
	}

	@Override
	public void agregarRestriccion(RestriccionTemporal restriccionPorFechaRest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getRestricciones() {
		// TODO Auto-generated method stub
		return null;
	}
}
