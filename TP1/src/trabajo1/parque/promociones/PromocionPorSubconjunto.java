package trabajo1.parque.promociones;

import java.util.List;

import trabajo1.parque.Atraccion;

public abstract class PromocionPorSubconjunto extends Promocion {
	
	
	public PromocionPorSubconjunto (List<Atraccion> atracciones, float vigencia){
		this.atracciones = atracciones;
		this.vigencia = vigencia;
	}
	
	public abstract float getDescuento ();

	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public float getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(float vigencia) {
		this.vigencia = vigencia;
	}	
	
	
}