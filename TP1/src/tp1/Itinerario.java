package tp1;

import java.util.List;

import parque.Atraccion;

public class Itinerario {

	private List<Atraccion> atracciones;
	private float costoTotal;
	
	public Itinerario (float costoTotal, List <Atraccion> atracciones){
		this.costoTotal = costoTotal;
		this.atracciones = atracciones;
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
	
}