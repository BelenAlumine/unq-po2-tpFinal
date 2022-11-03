package elementosDelSistema;


import accionesGenerales.GeneradorDeMuestra;
import accionesGenerales.RecomendacionDeDesafio;
import accionesGenerales.TipoDeRecomendacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import accionesDeProyecto.EstadoDelDesafio;

public class Usuario {

	private List<Desafio> desafiosAceptados;
	private String nombre;
	private PerfilUsuario perfil;
	private List<Muestra> muestrasRecolectadas;
	GeneradorDeMuestra generadorDeMuestra = new GeneradorDeMuestra();
	private RecomendacionDeDesafio recomendador;
	
	public Usuario(String nombre, PerfilUsuario perfil, RecomendacionDeDesafio recomendador) {
		this.desafiosAceptados = new ArrayList<Desafio>();
		this.nombre = nombre;
		this.perfil = perfil;
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.recomendador = recomendador;
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

	public void solicitarNuevosDesafiosRecomendados() {
		List<Desafio> desafiosAceptados = this.obtenerNuevosDesafios().subList(0, 5 - this.getDesafiosAceptados().size());
		// subList(0, 5 - this.getDesafiosAceptados().size()) , para garantizar que el usuario no tiene mas de 5 desafios activos
		for (Desafio desafioActual : desafiosAceptados) {
			EstadoDelDesafio estadoActual = desafioActual.getEstadoDelDesafio();
			estadoActual.cambiarDeEstado(desafioActual);
			desafiosAceptados.add(desafioActual);
		}
	}
	
	public List<Desafio> obtenerNuevosDesafios() {
		return recomendador.getRecomendaciones(this);
	}
	
	public PerfilUsuario getPerfil() {
		return perfil;
	}
	
	public void cambiarTipoDeRecomendacion(TipoDeRecomendacion tipoEscogido) {
		recomendador.setTipoDeRecomendacion(tipoEscogido);
	}
	
	public Desafio desafioQueMasLeGusto() {
		return this.getDesafiosFinalizados().stream().max(Comparator.comparingInt(Desafio::getVotacionDeUsuario)).get();
	}

}
