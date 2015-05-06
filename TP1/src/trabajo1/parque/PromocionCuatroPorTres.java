package trabajo1.parque;

import java.util.List;

public class PromocionCuatroPorTres extends Promocion {
	
	public PromocionCuatroPorTres(List<Atraccion> atracciones, float vigencia, Atraccion atraccionGratuita) {
		super(atracciones, vigencia);
		
		this.criterioDeDescuento = atraccionGratuita.getCosto();
	}

	@Override
	public float getDescuento() {
		
		return this.criterioDeDescuento;
	}	
}