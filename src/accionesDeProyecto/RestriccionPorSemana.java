package accionesDeProyecto;


import elementosDelSistema.Desafio;

public class RestriccionPorSemana extends RestriccionTemporal {
	
	
	public RestriccionPorSemana() {
		
	}
	
	@Override
	public void restringir(Desafio desafio) {
		
		if (!this.esFinDeSemana(desafio)) {
			desafio.setDesafioRestringido(false); 
		} else {
			desafio.setDesafioRestringido(true);
		}
	}
	

	@Override
	public boolean restringido(Desafio desafio) {
		return !this.esFinDeSemana(desafio);
	}
}
