package accionesGenerales;



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
	
	public void generarMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio) {
		muestra = new Muestra(usuario);
		//estadoDelDesafio = new EstadoEnCurso();
		
		this.crearMuestra(usuario, proyecto, desafio, muestra); 
		//proyecto.actualizarDesafio(desafio);
		//desafio.actualizarDesafio(); 
		//Quién actualiza, el proyecto o el desafio?
	}
	
	public void crearMuestra(Usuario usuario, Proyecto proyecto, Desafio desafio, Muestra muestra) {
		proyecto.agregarMuestra(muestra);
		//actualizar.actualizarDesafio(desafio);
	}
}