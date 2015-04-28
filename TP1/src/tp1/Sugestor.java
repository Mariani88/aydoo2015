package tp1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import parque.Atraccion;
import parque.Promocion;
import parque.Usuario;

public class Sugestor {

	private List<Atraccion> atracciones;
	private List<Promocion> promocionesDisponibles;

	public Sugestor(List<Atraccion> atracciones, List<Promocion> promociones) {
		this.atracciones = atracciones;
		this.promocionesDisponibles = promociones;
		
	}

	public List<Itinerario> crearItinerarios(Usuario usuario) {

		List<Itinerario> itinerarios = new LinkedList<Itinerario>();
		float precioItinerario = 0;
		
		Iterator<Atraccion> iterador = this.atracciones.iterator();

		List<Atraccion> atraccionesAccesibles = new LinkedList<Atraccion>();

		while (iterador.hasNext()) {
			
			Atraccion atraccionEnEvaluacion = iterador.next();

			boolean interesaAtraccion =  atraccionEnEvaluacion.getTipo() == usuario
					.getAtraccionPreferida();
			
			boolean alcanzaPresupuesto = (precioItinerario + atraccionEnEvaluacion
					.getCosto()) <= usuario.getPresupuesto();

			boolean hayCupo = atraccionEnEvaluacion.getCupo()!=0; 
			
			if (interesaAtraccion && alcanzaPresupuesto && hayCupo) {
				
				atraccionesAccesibles.add(atraccionEnEvaluacion);
				precioItinerario += atraccionEnEvaluacion.getCosto();
				
			}
		}

		itinerarios
				.add(new Itinerario(precioItinerario, atraccionesAccesibles));
		
		return itinerarios;
	}
}
