package tp1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import parque.Atraccion;
import parque.Coordenada;
import parque.Promocion;
import parque.Usuario;

public class Sugestor {

	private List<Atraccion> atracciones;
	private List<Promocion> promocionesDisponibles;

	public Sugestor(List<Atraccion> atracciones, List<Promocion> promociones) {
		this.atracciones = atracciones;
		this.promocionesDisponibles = promociones;

	}

	private float calcularTiempoDeTraslado(Atraccion atraccion,
			Usuario usuario, Coordenada posicionDeCalculo) {

		float tiempoDeTraslado = 0;

		float distanciaX = atraccion.getPosicion().getX()
				- posicionDeCalculo.getX();
		float distanciaY = atraccion.getPosicion().getY()
				- posicionDeCalculo.getY();

		float distancia = (float) (Math.pow(distanciaX, 2) + Math.pow(
				distanciaY, 2));
		distancia = (float) Math.pow(distancia, 0.5);

		tiempoDeTraslado = distancia / usuario.getVelocidadDeTraslado();

		return tiempoDeTraslado;
	}

	public List<Itinerario> crearItinerarios(Usuario usuario) {

		List<Itinerario> itinerarios = new LinkedList<Itinerario>();
		float precioItinerario = 0;
		float tiempoAcumulado = 0;
		float tiempoDeTraslado = 0;
		Coordenada posicionDeCalculo = usuario.getPosicion();

		Iterator<Atraccion> iterador = this.atracciones.iterator();

		List<Atraccion> atraccionesAccesibles = new LinkedList<Atraccion>();

		while (iterador.hasNext()) {

			Atraccion atraccionEnEvaluacion = iterador.next();

			tiempoDeTraslado = this.calcularTiempoDeTraslado(
					atraccionEnEvaluacion, usuario, posicionDeCalculo);

			boolean interesaAtraccion = atraccionEnEvaluacion.getTipo() == usuario
					.getAtraccionPreferida();

			boolean alcanzaPresupuesto = (precioItinerario + atraccionEnEvaluacion
					.getCosto()) <= usuario.getPresupuesto();

			boolean hayCupo = atraccionEnEvaluacion.getCupo() != 0;

			boolean hayTiempo = (tiempoAcumulado
					+ atraccionEnEvaluacion.getTiempoDeDuracion() +
					tiempoDeTraslado) <= usuario.getTiempoDiponible();

			if (interesaAtraccion && alcanzaPresupuesto && hayCupo && hayTiempo) {
				atraccionesAccesibles.add(atraccionEnEvaluacion);
				precioItinerario += atraccionEnEvaluacion.getCosto();
				tiempoAcumulado += atraccionEnEvaluacion.getTiempoDeDuracion()
						+ tiempoDeTraslado;

				posicionDeCalculo = atraccionEnEvaluacion.getPosicion();
			}
		}

		itinerarios
				.add(new Itinerario(precioItinerario, atraccionesAccesibles));

		return itinerarios;
	}
}
