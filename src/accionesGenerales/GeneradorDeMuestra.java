package accionesGenerales;


import accionesDeProyecto.EstadoEnCurso;

import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;
import elementosDelSistema.Muestra;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

public class GeneradorDeMuestra {
	/**Crea una muestra y a guarda en el proyecto
	 * La contabiliza en los desafios si corresponde.
	 */
	
	Muestra muestra;
	ActualizacionDeDesafio actualizar;
	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, DesafioDeUsuario desafio, double latitud, double longitud) {
		muestra = new Muestra(usuario, latitud, longitud);
		
		this.crearMuestra(usuario, proyecto, desafio, muestra); 

	}
	
	public void crearMuestra(Usuario usuario, Proyecto proyecto, DesafioDeUsuario desafio, Muestra muestra) {
		actualizar = new ActualizacionDeDesafio();
		
		proyecto.agregarMuestra(muestra);
		if (desafio.getEstadoDelDesafio() instanceof EstadoEnCurso) {
			actualizar.actualizarDesafio(desafio, muestra);
		}
	}
}