package elementosDelSistema;

public class AreaGeografica {

	private double latitud;
	private double longitud;
	private double radio;
	
	public AreaGeografica(double latitud, double longitud, double radio) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.radio = radio;
	}

	
	public double getLatitud() {
		return latitud;
	}
	
	public double getLongitud() {
		return longitud;
	}
	
	public double getRadio() {
		return radio;
	}
	
}
