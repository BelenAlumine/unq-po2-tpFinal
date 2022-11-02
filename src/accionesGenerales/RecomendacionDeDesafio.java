package accionesGenerales;

import java.util.List;

import elementosDelSistema.Desafio;
import elementosDelSistema.Usuario;
import sistema.Sistema;

public class RecomendacionDeDesafio {

	private TipoDeRecomendacion recomendacionElegida;
	private Sistema sistemaBase;
	
	public List<Desafio> getRecomendaciones(Usuario usuarioBase) {
		return recomendacionElegida.desafiosRecomendados(usuarioBase, sistemaBase.getDesafios());
	}
	
	
	public void setTipoDeRecomendacion(TipoDeRecomendacion tipoEscogido) {
		this.recomendacionElegida = tipoEscogido;
	}
}
