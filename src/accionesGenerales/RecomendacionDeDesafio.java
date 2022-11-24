package accionesGenerales;

import java.util.ArrayList;
import java.util.List;

import elementosDelSistema.Desafio;
import elementosDelSistema.DesafioDeUsuario;
import elementosDelSistema.Usuario;
import sistema.Sistema;

public class RecomendacionDeDesafio {

	private TipoDeRecomendacion recomendacionElegida;
	private Sistema sistemaBase;
	
	public List<DesafioDeUsuario> getRecomendaciones(Usuario usuarioBase) {
		List<Desafio> desafiosNoAceptadosPorUsuario = sistemaBase.getDesafios();
		desafiosNoAceptadosPorUsuario.removeAll(usuarioBase.getDesafiosAceptados());
		// Cambio efectuado para entregar DesafioDeUsuario en lugar de Desafio 
		List<Desafio> desafiosBase = recomendacionElegida.desafiosRecomendados(usuarioBase, desafiosNoAceptadosPorUsuario);
		List<DesafioDeUsuario> desafiosAEntregar = new ArrayList<DesafioDeUsuario>();
		for (Desafio desafio : desafiosBase) {
			desafiosAEntregar.add(new DesafioDeUsuario(desafio));
		}
		return desafiosAEntregar;
	}
	
	
	public void setTipoDeRecomendacion(TipoDeRecomendacion tipoEscogido) {
		this.recomendacionElegida = tipoEscogido;
	}
	
	public void setSistemaAUsar(Sistema sistema) {
		this.sistemaBase = sistema;
	}
}
