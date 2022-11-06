package elementosDelSistema;

import java.time.LocalDate;
import java.time.LocalTime;

public class Muestra {
	Usuario usuario;
	AreaGeografica areaGeografica;
	LocalDate fechaCreacion = LocalDate.now();
	LocalTime horaDeCreacion = LocalTime.now();
	
	public Muestra(Usuario usuario, AreaGeografica ubicacion) {
		this.usuario = usuario;
		this.areaGeografica = ubicacion;
	}
}
