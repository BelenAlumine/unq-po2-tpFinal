package elementosDelSistema;

public class PerfilUsuario {

	private int cantidadDeMuestrasARecolectar;
	private int dificultadDeseada;
	private int recompensaPreferida;
	

	public PerfilUsuario(int cantidadDeMuestras, int dificultad, int recompensa) {
		this.cantidadDeMuestrasARecolectar = cantidadDeMuestras;
		this.dificultadDeseada = dificultad;
		this.recompensaPreferida = recompensa;
	}
	
	public void setRecomenpensaPreferida(int recompensaDeseada) {
		this.recompensaPreferida = recompensaDeseada;
	}
	
	public void setDificultadDeseada(int dificultaddeseada) {
		this.dificultadDeseada = dificultaddeseada;
	}
	
	public void setCantidadDeMuestrasARecolectarDeseada(int cantidadDeseada) {
		this.cantidadDeMuestrasARecolectar = cantidadDeseada;
	}
	
	public int getCantidadDeMuestrasARecolectar() {
		return cantidadDeMuestrasARecolectar;
	}
	
	public int getDificultadDeseada() {
		return dificultadDeseada;
	}
	
	public int getRecompensaPreferida() {
		return recompensaPreferida;
	}
}
