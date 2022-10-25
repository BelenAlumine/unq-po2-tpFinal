package elementosDelSistema;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	String nombre;
	String descripcion;
	List<Usuario> participantes = new ArrayList<Usuario>();
	
	public Proyecto(String nombre, String descripcion) {
		nombre = this.nombre;
		descripcion = this.descripcion;	
	}
	
	public void suscribirParticipante (Usuario usuario) {
		participantes =+ this.add(usuario);
	}
}