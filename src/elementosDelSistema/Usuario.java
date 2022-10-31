package elementosDelSistema;


import accionesGenerales.GeneradorDeMuestra;
import java.util.List;

import accionesDeProyecto.EstadoDelDesafio;

public class Usuario {

	private List<Desafio> desafiosAceptados;
	private String nombre;
	private PerfilUsuario perfil;
	private List<Muestra> muestrasRecolectadas;
	GeneradorDeMuestra generadorDeMuestra = new GeneradorDeMuestra();

	
	public Usuario(String nombre, PerfilUsuario perfil) {
		this.nombre = nombre;
		this.perfil = perfil;
	}
	
	public List<Muestra> getMuestras() {
		return muestrasRecolectadas;
	}
	
	public List<Desafio> getDesafiosAceptados() {
		return desafiosAceptados;
	}
	
	public List<Desafio> getDesafiosFinalizados() {
		return null;
		//return desafios.(filter para la verifación de estado )
	}
	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio) {
		generadorDeMuestra.generarMuestra(usuario, proyecto, desafio);
	}

	public void aceptarNuevosDesafiosRecomendados(List<Desafio> desafios) {
		List<Desafio> desafiosAceptados = desafios.subList(0, 5 - this.getDesafiosAceptados().size());
		for (Desafio desafioActual : desafiosAceptados) {
			EstadoDelDesafio estadoActual = desafioActual.getEstadoDelDesafio();
			estadoActual.cambiarDeEstado(desafioActual);
			desafiosAceptados.add(desafioActual);
		}
	}
}
