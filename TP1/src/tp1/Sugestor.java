package tp1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import calculo.CalculadorDeTraslado;
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
	
	public Sugestor(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
		this.promocionesDisponibles = new LinkedList <Promocion>();

	}
	

	

	public List<Itinerario> crearItinerarios(Usuario usuario) {

		List<Itinerario> itinerarios = new LinkedList<Itinerario>();
		float precioItinerario = 0;
		float tiempoAcumulado = 0;
		float tiempoDeTraslado = 0;
		Coordenada posicionDeCalculo = usuario.getPosicion();

		Iterator<Atraccion> iterador = this.atracciones.iterator();

		List<Atraccion> atraccionesAccesibles = new LinkedList<Atraccion>();

		this.aplicarPromociones (itinerarios, usuario);
		
		CalculadorDeTraslado calculador = new CalculadorDeTraslado ();
		
		while (iterador.hasNext()) {

			Atraccion atraccionEnEvaluacion = iterador.next();

			tiempoDeTraslado = calculador.calcularTiempoDeTraslado(
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

	
	private void aplicarPromociones(List<Itinerario> itinerarios,
			Usuario usuario) {
	
		Iterator <Promocion> iterador = this.promocionesDisponibles.iterator();
		
		while (iterador.hasNext()){
			Promocion promocionAEvaluar = iterador.next();
			
			if (promocionAEvaluar.esAplicableA(usuario)) {
				itinerarios.add( new Itinerario( promocionAEvaluar.getCosto(),
						promocionAEvaluar.getAtracciones()) );
			}	
		}
	}
}
