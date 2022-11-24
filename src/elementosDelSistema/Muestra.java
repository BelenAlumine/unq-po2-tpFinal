package elementosDelSistema;

import java.time.LocalDate;
import java.time.LocalTime;

public class Muestra {
	
	Usuario usuario;
	private double latitudMuestra;
	private double longitudMuestra;
	LocalDate fechaCreacion = LocalDate.now();
	LocalTime horaDeCreacion = LocalTime.now();
	
	public Muestra(Usuario usuario, double latitud, double longitud) {
		this.usuario = usuario;
		this.latitudMuestra = latitud;
		this.longitudMuestra = longitud;
	}
	
	public double getLatitudMuestra() {
		return latitudMuestra;
	}
	
	public double getLongitudMuestra() {
		return longitudMuestra;
	}
}
