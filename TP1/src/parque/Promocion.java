package parque;

import java.util.Set;

public abstract class Promocion {
	
	protected Set<Atraccion> atracciones;
	protected int vigencia;
	protected float criterioDeDescuento;
	
	public Promocion (Set <Atraccion> atracciones, int vigencia){
		this.atracciones = atracciones;
		this.vigencia = vigencia;
	}
	
	public abstract float getDescuento ();

	public Set<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public void setAtracciones(Set<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public int getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}	
}