package elementosDelSistema;

import java.time.LocalDate;
import java.time.LocalTime;

public class Muestra {
	Usuario usuario;
	//ubicacion: Coordenada
	LocalDate fechaCreacion = LocalDate.now();
	LocalTime horaDeCreacion = LocalTime.now();
	
	public Muestra(Usuario usuario /*ubicacion*/) {
		this.usuario = usuario;
	}
	
	
}
