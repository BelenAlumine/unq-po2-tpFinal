package elementosDelSistema;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	String nombre;
	String descripcion;
	List<Usuario> participantes = new ArrayList<Usuario>();
	List<Muestra> muestras = new ArrayList<Muestra>();
	List<Desafio> desafios = new ArrayList<Desafio>();
	//List<> categorias = new ArrayList<>();
	
	public Proyecto(String nombre, String descripcion) {
		nombre = this.nombre;
		descripcion = this.descripcion;	
	};
	
	public List<Usuario> getParticipantes() {
		return participantes;
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	public List<Desafio> getDesafios() {
		return desafios;
	}

	public void suscribirParticipante(Usuario participante) {
		this.getParticipantes().add(participante);
	}
	
	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}
}