package accionesGenerales;


import elementosDelSistema.AreaGeografica;

import accionesDeProyecto.EstadoEnCurso;

import accionesDeProyecto.EstadoEnCurso;

//import java.time.LocalDate;
//import java.time.LocalTime;


//import accionesDeProyecto.EstadoDelDesafio;
//import accionesDeProyecto.EstadoEnCurso;
import elementosDelSistema.Desafio;
import elementosDelSistema.Muestra;
import elementosDelSistema.Proyecto;
import elementosDelSistema.Usuario;

public class GeneradorDeMuestra {
	/**Crea una muestra y a guarda en el proyecto
	 * La contabiliza en los desafios si corresponde.
	 */
	
	Muestra muestra;
	ActualizacionDeDesafio actualizar;
	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio, AreaGeografica area) {
		muestra = new Muestra(usuario, area);
		
		this.crearMuestra(usuario, proyecto, desafio, muestra); 


	}
	
	public void crearMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio, Muestra muestra) {
		actualizar = new ActualizacionDeDesafio();
		
		proyecto.agregarMuestra(muestra);
		if (desafio.getEstadoDelDesafio() instanceof EstadoEnCurso) {
			actualizar.actualizarDesafio(desafio);
		}
	}
}