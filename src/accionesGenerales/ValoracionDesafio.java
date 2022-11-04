package accionesGenerales;

public class ValoracionDesafio {

	private int valoracionAsociada;
	
	public void agregarValoracion(int valorAsociado) throws Exception {
		if (valorAsociado > 5 || valorAsociado < 0) {
			throw new Exception("Valor no valido para la valoración de desafio");
		} else {
			this.valoracionAsociada = valorAsociado;
		}
	}
	
	public int obtenerValoracion() {
		return valoracionAsociada;
	}
}
