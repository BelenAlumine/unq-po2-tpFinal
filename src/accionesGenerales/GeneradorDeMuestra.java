package accionesGenerales;


import elementosDelSistema.AreaGeografica;

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
	//EstadoDelDesafio estadoDelDesafio;
	Muestra muestra;
	ActualizacionDeDesafio actualizar;
	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio, AreaGeografica area) {
		muestra = new Muestra(usuario, area);
		//estadoDelDesafio = new EstadoEnCurso();
		
		this.crearMuestra(usuario, proyecto, desafio, muestra); 
		//proyecto.actualizarDesafio(desafio);
		//desafio.actualizarDesafio(); 
		//Qui�n actualiza, el proyecto o el desafio?
	}
	
	public void crearMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio, Muestra muestra) {
		proyecto.agregarMuestra(muestra);
		//actualizar.actualizarDesafio(desafio);
	}
}