package parque;

import java.util.Set;

public class PromocionAxB extends Promocion {
	
	public PromocionAxB(Set<Atraccion> atracciones, int vigencia, Atraccion atraccionGratuita) {
		super(atracciones, vigencia);
		
		this.criterioDeDescuento = atraccionGratuita.getCosto();
	}

	@Override
	public float getDescuento() {
		
		return this.criterioDeDescuento;
	}	
}