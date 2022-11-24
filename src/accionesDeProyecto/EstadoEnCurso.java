package accionesDeProyecto;

import elementosDelSistema.DesafioDeUsuario;

public class EstadoEnCurso extends EstadoDelDesafio {
	/** Método que calcule el porcentaje de realización del desafío. Info para el usuario
	 *  Una vez en este estado, el desafio ya no puede volver al estado anterior. Pero si al siguiente, esto pasa 
	 *  cuando se logran la cantidad de muestras necesarias. 
	 */
		EstadoEnCurso desafioEnCurso;
		EstadoFinalizado desafioFinalizado = new EstadoFinalizado();
		
		@Override
		public void revisarEstadoDelDesafio(DesafioDeUsuario desafio) {
			//Revisar si la cantidad de muestras subidas es igual a las requeridas, si es as�
			//actualizar el estado, sino dejarlo como esta
			if (desafio.esUnDesafioCompletado()) {
				this.cambiarDeEstado(desafio);
			}
			
		}

		@Override
		public void cambiarDeEstado(DesafioDeUsuario desafio) {
			desafio.setEstadoDelDesafio(desafioFinalizado);
			
		}


}