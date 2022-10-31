package elementosDelSistema;

import accionesGenerales.GeneradorDeMuestra;

public class Usuario {
	
	GeneradorDeMuestra generadorDeMuestra = new GeneradorDeMuestra();
	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio) {
		generadorDeMuestra.generarMuestra(usuario, proyecto, desafio);
	}
}
