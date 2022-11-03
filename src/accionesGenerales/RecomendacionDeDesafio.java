package accionesGenerales;

import java.util.List;

import elementosDelSistema.Desafio;
import elementosDelSistema.Usuario;
import sistema.Sistema;

public class RecomendacionDeDesafio {

	private TipoDeRecomendacion recomendacionElegida;
	private Sistema sistemaBase;
	
	public List<Desafio> getRecomendaciones(Usuario usuarioBase) {
		List<Desafio> desafiosNoAceptadosPorUsuario = sistemaBase.getDesafios();
		desafiosNoAceptadosPorUsuario.removeAll(usuarioBase.getDesafiosAceptados());
		return recomendacionElegida.desafiosRecomendados(usuarioBase, desafiosNoAceptadosPorUsuario);
	}
	
	
	public void setTipoDeRecomendacion(TipoDeRecomendacion tipoEscogido) {
		this.recomendacionElegida = tipoEscogido;
	}
	
	public void setSistemaAUsar(Sistema sistema) {
		this.sistemaBase = sistema;
	}
}
