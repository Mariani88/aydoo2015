package trabajo1.parque.promociones;

import java.util.Iterator;
import java.util.List;
import trabajo1.calculo.EvaluadorDeContexto;
import trabajo1.parque.Atraccion;
import trabajo1.parque.Usuario;

public class PromocionExtranjero extends PromocionEnglobadora {

	private Usuario usuario;

	public PromocionExtranjero(float vigencia, Usuario usuario){
		super(50, vigencia);
		this.usuario = usuario;
	}

	@Override
	public List<Atraccion> rebajarPrecioAtracciones() {
		
		EvaluadorDeContexto evaluador = new EvaluadorDeContexto (this.usuario);
		List <Atraccion> copiaAtracciones = this.clonarListaAtracciones();
		
		if ( evaluador.usuarioEsExtranjero(copiaAtracciones) && this.vigencia > 0){
			
			Iterator<Atraccion> iterador = copiaAtracciones.iterator();
			
			while (iterador.hasNext()){
				Atraccion atraccion = iterador.next();
				atraccion.setCosto(atraccion.getCosto()
						* this.criterioDeDescuento / 100);
			}
		}
		
		return copiaAtracciones;
	}
}