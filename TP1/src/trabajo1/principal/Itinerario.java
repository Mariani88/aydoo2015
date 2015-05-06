package trabajo1.principal;

import java.util.LinkedList;
import java.util.List;
import trabajo1.parque.Atraccion;

public class Itinerario {

	private List<Atraccion> atracciones;
	private float costoTotal;
	private float tiempoRequerido;
	
	public void setCostoTotal(float costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Itinerario (){
		this.costoTotal = 0;
		this.atracciones = new LinkedList <Atraccion> ();
		this.tiempoRequerido = 0;
	}
	
	public Itinerario (float costoTotal, List <Atraccion> atracciones){
		this.costoTotal = costoTotal;
		this.atracciones = atracciones;
		this.tiempoRequerido = 0;
	}
	
	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public float getCostoTotal() {
		return this.costoTotal;
	}
		
	public boolean equals(Object obj) {

		boolean iguales = this == obj;

		if (!iguales && obj instanceof Itinerario) {

			Itinerario obje = (Itinerario) obj;

			iguales = this.atracciones.equals(obje.getAtracciones())
					&& this.costoTotal == obje.costoTotal;
		}

		return iguales;
	}

	public float getTiempoRequerido() {
		return this.tiempoRequerido;
	}

	public void setTiempoRequerido(float tiempoRequerido) {
		this.tiempoRequerido = tiempoRequerido;
	}
}