package trabajo1.parque.promociones;

import java.util.List;

import trabajo1.parque.Atraccion;

public class PromocionCuatroPorTres extends PromocionPorSubconjunto {
	
	public PromocionCuatroPorTres(List<Atraccion> atracciones, float vigencia, Atraccion atraccionGratuita) {
		super(atracciones, vigencia);
		
		this.criterioDeDescuento = atraccionGratuita.getCosto();
	}

	@Override
	public float getDescuento() {
		
		return this.criterioDeDescuento;
	}	
}