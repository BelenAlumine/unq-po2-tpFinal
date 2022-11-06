package accionesDeProyecto;

import elementosDelSistema.Desafio;

public class EstadoEnCurso extends EstadoDelDesafio {
/** Método que calcule el porcentaje de realización del desafío. Info para el usuario
 *  Una vez en este estado, el desafio ya no puede volver al estado anterior. Pero si al siguiente, esto pasa 
 *  cuando se logran la cantidad de muestras necesarias.
 *  
 */
	EstadoEnCurso desafioEnCurso;
	EstadoFinalizado desafioFinalizado;
	
	@Override
	public void revisarEstadoDelDesafio(Desafio desafio) {
		//Revisar si la cantidad de muestras subidas es igual a las requeridas, si es as�
		//actualizar el estado, sino dejarlo como esta
		if (desafio.getMuestrasRecolectadas() == desafio.getMuestrasARecolectar()) {
			this.cambiarDeEstado(desafio);
		}
		
	}

	@Override
	public void cambiarDeEstado(Desafio desafio) {
		desafio.setEstadoDelDesafio(desafioFinalizado);
		
	}

}