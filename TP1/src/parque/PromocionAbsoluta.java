package parque;

import java.util.Set;

public class PromocionAbsoluta extends Promocion {
	
	public PromocionAbsoluta(Set<Atraccion> atracciones, int vigencia, float descuento) {
		super(atracciones, vigencia);
		this.criterioDeDescuento = descuento;	
	}

	@Override
	public float getDescuento() {
		return this.criterioDeDescuento;
	}	
}