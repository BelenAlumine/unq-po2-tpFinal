package elementosDelSistema;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	String nombre;
	String descripcion;
	List<Usuario> participantes = new ArrayList<Usuario>();
	List<Muestra> muestras = new ArrayList<Muestra>();
	List<Desafio> desafios = new ArrayList<Desafio>();
	List<String> categorias = new ArrayList<String>();
	
	public Proyecto(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;	
	};
	
	public String getNombre() {
		return nombre;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	public List<Desafio> getDesafios() {
		return desafios;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void suscribirParticipante(Usuario participante) {
		this.getParticipantes().add(participante);
	}
	
	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}
}