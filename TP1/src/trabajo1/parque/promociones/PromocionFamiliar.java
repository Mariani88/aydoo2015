package trabajo1.parque.promociones;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import trabajo1.parque.Atraccion;
import trabajo1.principal.Sugeridor;

public class PromocionFamiliar extends PromocionEnglobadora {

	private Map<Atraccion, Integer> entradasPorAtraccion;
	private float descuentoAdicional;
	
	public PromocionFamiliar(float vigencia,
			Map<Atraccion, Integer> entradasPorAtraccion) {
			
		super(10, vigencia);
		
		this.entradasPorAtraccion = entradasPorAtraccion;
		this.descuentoAdicional = 30;
	}

	@Override
	public List<Atraccion> rebajarPrecioAtracciones() {
		
		List<Atraccion> copiaAtracciones = this.clonarListaAtracciones();
		Iterator<Atraccion> iterador = copiaAtracciones.iterator();
		Atraccion atraccion;
		
		while (iterador.hasNext()){
			
			atraccion = iterador.next();
			Integer entrada = this.entradasPorAtraccion.get(atraccion);
			
			if ( entrada!=null ){
				this.rebajarPrecioAtraccion(atraccion, entrada);
			}
		}
		
		return copiaAtracciones;
	}

	private void rebajarPrecioAtraccion(Atraccion atraccion, Integer entrada) {
		
		if ( 0 < entrada && entrada < 4){
			atraccion.setCosto( atraccion.getCosto() * entrada );
		}else{
			float costo = atraccion.getCosto() * 4;
			costo-= costo* this.criterioDeDescuento / 100;
			
			entrada -= 4;
			costo += entrada
					* (atraccion.getCosto() - atraccion.getCosto()
							* this.descuentoAdicional / 100);
			atraccion.setCosto(costo);
		}
	}
}