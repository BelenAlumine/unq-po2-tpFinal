package elementosDelSistema;


import accionesGenerales.GeneradorDeMuestra;
import accionesGenerales.RecomendacionDeDesafio;
import accionesGenerales.TipoDeRecomendacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import accionesDeProyecto.EstadoDelDesafio;

public class Usuario {

	private List<DesafioDeUsuario> desafiosAceptados;
	private String nombre;
	private PerfilUsuario perfil;
	private List<Muestra> muestrasRecolectadas;
	private GeneradorDeMuestra generadorDeMuestra = new GeneradorDeMuestra();
	private RecomendacionDeDesafio recomendador;
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();

	public Usuario(String nombre, PerfilUsuario perfil, RecomendacionDeDesafio recomendador) {
		this.desafiosAceptados = new ArrayList<DesafioDeUsuario>();
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
	
	public List<DesafioDeUsuario> getDesafiosAceptados() {
		return desafiosAceptados;
	}
	
	public List<DesafioDeUsuario> desafiosCompletos() {
		return desafiosAceptados.stream().filter(desafio -> desafio.esUnDesafioCompletado()).toList();
	}
	
	
	public float porcentajeDeCompletitudTotal() {
		float sumaDePorcentajes = 0;
		for (DesafioDeUsuario desafio : this.getDesafiosAceptados()) {
			sumaDePorcentajes = sumaDePorcentajes + desafio.porcentajeDeCompletitud();
		}
		return sumaDePorcentajes / this.getDesafiosAceptados().size();
	}

	
	public float porcentajeCompletitudDeDesafio(DesafioDeUsuario desafio) {
		return desafio.porcentajeDeCompletitud();
	}
	
	
	public void agregarDesafio(DesafioDeUsuario desafio) {
		desafiosAceptados.add(desafio);
	}
		
	
	public void agregarProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}
	
	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, DesafioDeUsuario desafio, double latitud, double longitud) {
		generadorDeMuestra.generarMuestra(usuario, proyecto, desafio, latitud, longitud);
	}

	// Método se encarga de que la cantidad a agregar de nuevos desafios no lo haga sobrepasarse de 5 desafios activos, no finalizados
	public void solicitarNuevosDesafiosRecomendados() {
		List<DesafioDeUsuario> desafiosActivos = this.getDesafiosAceptados();
		desafiosActivos.removeAll(this.desafiosCompletos());
		List<DesafioDeUsuario> desafiosQueAceptar = this.obtenerNuevosDesafios().subList(0, 5 - desafiosActivos.size());
		for (DesafioDeUsuario desafioActual : desafiosQueAceptar) {
			EstadoDelDesafio estadoActual = desafioActual.getEstadoDelDesafio();
			estadoActual.cambiarDeEstado(desafioActual);
			agregarDesafio(desafioActual);
		}
	}
	
	public List<DesafioDeUsuario> obtenerNuevosDesafios() {
		return recomendador.getRecomendaciones(this);
	}
	
	public void cambiarTipoDeRecomendacion(TipoDeRecomendacion tipoEscogido) {
		recomendador.setTipoDeRecomendacion(tipoEscogido);
	}
	
	public Desafio desafioQueMasLeGusto() {
		return desafiosAceptados.stream().max(Comparator.comparingInt(DesafioDeUsuario::getVotacion)).get().getDesafioBase();
	}
	
	public void votarDesafioCon(DesafioDeUsuario desafio, int valoracion) throws Exception {
		desafio.agregarVotacion(valoracion);
	}
	
}
