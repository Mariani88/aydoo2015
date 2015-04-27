package parque;

import java.util.List;

public abstract class Promocion {
	
	protected List<Atraccion> atracciones;
	protected int vigencia;
	protected float criterioDeDescuento;
	
	public Promocion (List<Atraccion> atracciones, int vigencia){
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

	public int getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}	
}