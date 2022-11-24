package elementosDelSistema;

public class AreaGeografica {
	
	private double latitudCentro;
	private double longitudCentro;
	private double radio;
	
	public AreaGeografica(double latitud, double longitud, double radio) {
		this.latitudCentro = latitud;
		this.longitudCentro = longitud;
		this.radio = radio;
	}

	public double getLatitud() {
		return latitudCentro;
	}
	
	public double getLongitud() {
		return longitudCentro;
	}
	
	public double getRadio() {
		return radio;
	}
	
	// Establecer distancia entre el centro y el punto donde estará la muestra
	
	
	public boolean seEncuentraEnElArea(double latitud, double longitud) {
		double distLatitud = Math.pow(latitud - this.latitudCentro, 2);
		double distLongitud = Math.pow(longitud - this.longitudCentro, 2) ;
		return Math.sqrt(distLatitud + distLongitud) < radio;
	}
}
