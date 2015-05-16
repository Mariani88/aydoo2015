package trabajo1.parque.promociones;

import java.util.List;

import trabajo1.parque.Atraccion;

public class PromocionAbsoluta extends PromocionPorSubconjunto {
	
	public PromocionAbsoluta(List<Atraccion> atracciones, float vigencia, float descuento) {
		super(atracciones, vigencia);
		this.criterioDeDescuento = descuento;	
	}

	@Override
	public float getDescuento() {
		return this.criterioDeDescuento;
	}
}