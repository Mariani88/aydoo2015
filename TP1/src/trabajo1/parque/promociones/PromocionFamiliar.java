package trabajo1.parque.promociones;

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
		// TODO Auto-generated method stub
		return null;
	}
}