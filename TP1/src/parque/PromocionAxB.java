package parque;

import java.util.List;

public class PromocionAxB extends Promocion {
	
	public PromocionAxB(List<Atraccion> atracciones, float vigencia, Atraccion atraccionGratuita) {
		super(atracciones, vigencia);
		
		this.criterioDeDescuento = atraccionGratuita.getCosto();
	}

	@Override
	public float getDescuento() {
		
		return this.criterioDeDescuento;
	}	
}