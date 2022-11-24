package sistema;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

public class Sistema {
	List<Desafio> desafios = new ArrayList<Desafio>();
	List<Muestra> muestras = new ArrayList<Muestra>();
	List<Usuario> usuarios = new ArrayList<Usuario>();
	List<Proyecto> proyectos = new ArrayList<Proyecto>();
//	FiltroDeBusqueda filtro;
	
	public List<Desafio> getDesafios() {
		return desafios;
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	
	public void agregarDesafio(Desafio desafio) {
		this.getDesafios().add(desafio);
	}
	
	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}
	
	public void agregarProyecto(Proyecto proyecto) {
		this.getProyectos().add(proyecto);
	}
	/*
	public void setFiltro(FiltroDeBusqueda filtro) {
		this.filtro = filtro;
	}*/
	
	public List<Proyecto> buscar(List<Proyecto> proyectos, Busqueda filtro) {
		return filtro.buscar(proyectos);
	}
}