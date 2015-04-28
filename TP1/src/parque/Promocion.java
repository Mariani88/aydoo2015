package parque;

import java.util.Iterator;
import java.util.List;

public abstract class Promocion {
	
	protected List<Atraccion> atracciones;
	protected float vigencia;
	protected float criterioDeDescuento;
	
	public Promocion (List<Atraccion> atracciones, float vigencia){
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
	
	
	public  boolean esAplicableA (Usuario usuario){
		
		Iterator <Atraccion> iterador = this.atracciones.iterator();
		int atraccionInteresante = 0;
		float tiempoAcumulado = 0;
		boolean hayCupo = true;
		
		while (iterador.hasNext() && hayCupo){
			
			Atraccion atraccion = iterador.next();
			
			if (atraccion.getTipo() == usuario.getAtraccionPreferida()){
				atraccionInteresante++;
			}
			
			tiempoAcumulado+=atraccion.getTiempoDeDuracion();
			hayCupo = atraccion.getCupo() > 0;
			
		}
		
		boolean interesaAtraccion = atraccionInteresante >= this.atracciones
				.size() / 2;
		boolean alcanzaPresupuesto = this.getCosto() <= usuario
				.getPresupuesto();
		boolean hayTiempo = tiempoAcumulado <= usuario.getTiempoDiponible();
		boolean esAplicable = interesaAtraccion && alcanzaPresupuesto
				&& hayCupo && hayTiempo;

		return esAplicable;
	}

	
	public float getCosto() {
			
		Iterator<Atraccion> iterador = this.atracciones.iterator();
		float costo = 0;
		
		while ( iterador.hasNext() ){
			costo+= iterador.next().getCosto();
		}
		
		costo-=this.getDescuento();
		
		return costo;
	}
	
}