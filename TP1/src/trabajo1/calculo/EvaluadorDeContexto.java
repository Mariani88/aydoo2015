package trabajo1.calculo;

import java.util.Iterator;
import trabajo1.parque.Atraccion;
import trabajo1.parque.Coordenada;
import trabajo1.parque.Promocion;
import trabajo1.parque.Usuario;
import trabajo1.principal.Itinerario;

public class EvaluadorDeContexto {

	private Usuario usuarioAEvaluar;

	public EvaluadorDeContexto(Usuario usuarioAEvaluar) {
		this.usuarioAEvaluar = usuarioAEvaluar;
	}

	public float calcularTiempoDeTraslado(Atraccion atraccion,
			Coordenada posicionDeCalculo) {

		float tiempoDeTraslado = 0;

		float distanciaX = atraccion.getPosicion().getX()
				- posicionDeCalculo.getX();
		float distanciaY = atraccion.getPosicion().getY()
				- posicionDeCalculo.getY();

		float distancia = (float) (Math.pow(distanciaX, 2) + Math.pow(
				distanciaY, 2));
		distancia = (float) Math.pow(distancia, 0.5);

		tiempoDeTraslado = distancia
				/ this.usuarioAEvaluar.getVelocidadDeTraslado();

		return tiempoDeTraslado;
	}
	
	/**
	 * evalua si una atraccion puede agregarse a un itinerario, si se puede
	 * lo agrega.
	 * @param atraccionAEvaluar
	 * @param itinerario
	 * @param posicionDeCalculo
	 */
	public void evaluarSiAtraccionEsAccesible(
			Atraccion atraccionAEvaluar, Itinerario itinerario, Coordenada posicionDeCalculo) {

		boolean accesible = false;
		float tiempoDeTraslado = this.calcularTiempoDeTraslado(
				atraccionAEvaluar, posicionDeCalculo);
		
		boolean interesaAtraccion = atraccionAEvaluar.getTipo() == this.usuarioAEvaluar
				.getAtraccionPreferida();
		
		boolean alcanzaPresupuesto = (itinerario.getCostoTotal() + atraccionAEvaluar
				.getCosto()) <= this.usuarioAEvaluar.getPresupuesto();
		boolean hayCupo = atraccionAEvaluar.getCupo() != 0;
		
		boolean hayTiempo = (itinerario.getTiempoRequerido()
				+ atraccionAEvaluar.getTiempoDeDuracion() + tiempoDeTraslado) <= this.usuarioAEvaluar
				.getTiempoDiponible();

		accesible = interesaAtraccion && alcanzaPresupuesto && hayCupo
				&& hayTiempo;

		if (accesible) {
			this.transmitirInfoDeAtraccionAItinerario(atraccionAEvaluar,
					itinerario, posicionDeCalculo);
		}
	}
	
	/**
	 * Evaluar si una promocion es aplicable, si es aplicable devuelve true
	 * con el itinerario a Crear cargado de informacion. En caso contrario 
	 * devuelve false 
	 * @param promocionAEvaluar
	 * @param itinerarioACrear
	 * @return
	 */
	public boolean promocionEsAplicable(Promocion promocionAEvaluar,
			Itinerario itinerarioACrear) {
		
		Iterator<Atraccion> iterador = promocionAEvaluar.getAtracciones()
				.iterator();
		int atraccionesInteresantes = 0;
		boolean hayCupo = true;
		Coordenada posicionDeCalculo = this.usuarioAEvaluar.getPosicion();
		boolean esAplicable = false;
		
		while (iterador.hasNext() && hayCupo) {

			Atraccion atraccion = iterador.next();

			if (atraccion.getTipo() == this.usuarioAEvaluar
					.getAtraccionPreferida()) {
				atraccionesInteresantes++;
			}
			
			this.transmitirInfoDeAtraccionAItinerario(atraccion,
					itinerarioACrear, posicionDeCalculo);
			hayCupo = atraccion.getCupo() > 0;
		}

		itinerarioACrear.setCostoTotal(itinerarioACrear.getCostoTotal()
				- promocionAEvaluar.getDescuento());

		if (hayCupo){
			esAplicable = this.aplicaPromocion(atraccionesInteresantes,
					itinerarioACrear, promocionAEvaluar);
		}

		return esAplicable;
	}


	/**
	 * actualiza la informacion del itinerario al agregar una atraccion,
	 * costo (sin descuento), tiempo requerido y atracciones
	 * @param atraccion
	 * @param itinerario 
	 * @param posicionDeCalculo contiene la posicion de la ultima atraccion
	 * agregada al itinerario. Se actualiza con la posicion de la atraccion
	 * pasada por parametro
	 */
	private void transmitirInfoDeAtraccionAItinerario(Atraccion atraccion,
			Itinerario itinerario, Coordenada posicionDeCalculo) {
		
		float tiempoDeTraslado = this.calcularTiempoDeTraslado(atraccion,
				posicionDeCalculo);

		itinerario.getAtracciones().add(atraccion);
		itinerario.setCostoTotal(itinerario.getCostoTotal()
				+ atraccion.getCosto());
		itinerario.setTiempoRequerido(itinerario.getTiempoRequerido()
				+ atraccion.getTiempoDeDuracion() + tiempoDeTraslado);

		posicionDeCalculo = atraccion.getPosicion();	
	}

	
	
	/**
	 * revisa las condiciones para aplicar una promocion y devuelve true
	 * si aplica y false si no.
	 * @param atraccionesInteresantes
	 * @param itinerarioTemporal
	 * @param promocionAEvaluar
	 * @return
	 */
	private boolean aplicaPromocion(int atraccionesInteresantes,
			Itinerario itinerarioTemporal, Promocion promocionAEvaluar) {
		
		boolean estaVigente = itinerarioTemporal.getTiempoRequerido() < promocionAEvaluar
				.getVigencia();

		boolean interesaAtraccion = atraccionesInteresantes >= promocionAEvaluar
				.getAtracciones().size() / 2;
		boolean alcanzaPresupuesto = itinerarioTemporal.getCostoTotal() <= this.usuarioAEvaluar
				.getPresupuesto();
		boolean hayTiempo = itinerarioTemporal.getTiempoRequerido() <= this.usuarioAEvaluar
				.getTiempoDiponible();
		boolean aplica = interesaAtraccion && alcanzaPresupuesto
				&& hayTiempo && estaVigente;
		
		return aplica;
	}
}