package elementosDelSistema;


import accionesGenerales.GeneradorDeMuestra;
import accionesGenerales.RecomendacionDeDesafio;
import accionesGenerales.TipoDeRecomendacion;

import java.util.ArrayList;
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

	public Usuario(String nombre, PerfilUsuario perfil) {
		this.desafiosAceptados = new ArrayList<Desafio>();
		this.nombre = nombre;
		this.perfil = perfil;
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.recomendador = null;
	}
	
	public Usuario(String nombre, PerfilUsuario perfil, RecomendacionDeDesafio recomendador) {
		this.desafiosAceptados = new ArrayList<Desafio>();
		this.nombre = nombre;
		this.perfil = perfil;
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.recomendador = recomendador;
	}
	
	public Usuario(PerfilUsuario perfil, RecomendacionDeDesafio recomendador, List<Desafio> desafiosDeBase) {
		this.desafiosAceptados = desafiosDeBase;
		this.nombre = "Test";
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
		return desafiosAceptados.stream().filter(desafio -> desafio.esUnDesafioCompletado()).toList();
	}
	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio) {
		generadorDeMuestra.generarMuestra(usuario, proyecto, desafio);
	}

	public void solicitarNuevosDesafiosRecomendados() {
		List<Desafio> desafiosActivos = this.getDesafiosAceptados();
		desafiosActivos.removeAll(this.getDesafiosFinalizados());
		List<Desafio> desafiosQueAceptar = this.obtenerNuevosDesafios().subList(0, 5 - desafiosActivos.size());
		for (Desafio desafioActual : desafiosQueAceptar) {
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
		return desafiosAceptados.stream().max(Comparator.comparingInt(Desafio::getVotacionDeUsuario)).get();
	}
	
	public void votarDesafioCon(Desafio desafio, int valoracion) {
		desafio.setVotacionDeUsuario(valoracion);
	}

}
