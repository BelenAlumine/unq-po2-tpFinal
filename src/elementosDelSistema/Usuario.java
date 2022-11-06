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
	
	public PerfilUsuario getPerfil() {
		return perfil;
	}
	
	public List<Desafio> getDesafiosAceptados() {
		return desafiosAceptados;
	}
	
	public List<Desafio> getDesafiosFinalizados() {
		return desafiosAceptados.stream().filter(desafio -> desafio.esUnDesafioCompletado()).toList();
	}
	
	public float porcentajeDeCompletitudTotal() {
		float sumaDePorcentajes = 0;
		for (Desafio desafio : this.getDesafiosAceptados()) {
			sumaDePorcentajes = sumaDePorcentajes + desafio.porcentajeDeCompletitud();
		}
		return sumaDePorcentajes / this.getDesafiosAceptados().size();
	}
	
	public float porcentajeCompletitudDeDesafio(Desafio desafio) {
		return desafio.porcentajeDeCompletitud();
	}

	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio, AreaGeografica area) {
		generadorDeMuestra.generarMuestra(usuario, proyecto, desafio, area);
	}

	// Método se encarga de que la cantidad a agregar de nuevos desafios no lo haga sobrepasarse de 5 desafios activos, no finalizados
	public void solicitarNuevosDesafiosRecomendados() {
		List<Desafio> desafiosActivos = this.getDesafiosAceptados();
		desafiosActivos.removeAll(this.getDesafiosFinalizados());
		List<Desafio> desafiosQueAceptar = this.obtenerNuevosDesafios().subList(0, 5 - desafiosActivos.size());
		for (Desafio desafioActual : desafiosQueAceptar) {
			EstadoDelDesafio estadoActual = desafioActual.getEstadoDelDesafio();
			estadoActual.cambiarDeEstado(desafioActual);
			agregarDesafio(desafioActual);
		}
	}
	
	public void agregarDesafio(Desafio desafio) {
		desafiosAceptados.add(desafio);
	}
	
	public List<Desafio> obtenerNuevosDesafios() {
		return recomendador.getRecomendaciones(this);
	}
	
	
	public void cambiarTipoDeRecomendacion(TipoDeRecomendacion tipoEscogido) {
		recomendador.setTipoDeRecomendacion(tipoEscogido);
	}
	
	public Desafio desafioQueMasLeGusto() {
		return desafiosAceptados.stream().max(Comparator.comparingInt(Desafio::getVotacion)).get();
	}
	
	public void votarDesafioCon(Desafio desafio, int valoracion) throws Exception {
		desafio.agregarVotacion(valoracion);
	}
	
}
