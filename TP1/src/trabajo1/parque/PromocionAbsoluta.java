package trabajo1.parque;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	
	public PromocionAbsoluta(List<Atraccion> atracciones, float vigencia, float descuento) {
		super(atracciones, vigencia);
		this.criterioDeDescuento = descuento;	
	}

	@Override
	public float getDescuento() {
		return this.criterioDeDescuento;
	}
}