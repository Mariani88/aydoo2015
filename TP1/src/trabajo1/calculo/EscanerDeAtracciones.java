package trabajo1.calculo;

import java.util.Iterator;
import java.util.List;

import trabajo1.parque.Atraccion;
import trabajo1.parque.Coordenada;
import trabajo1.parque.Usuario;
import trabajo1.parque.promociones.PromocionEnglobadora;
import trabajo1.parque.promociones.PromocionPorSubconjunto;
import trabajo1.principal.Itinerario;

public class EscanerDeAtracciones {

	private EvaluadorDeContexto evaluador;
	private Usuario usuario;
	
	public EscanerDeAtracciones (Usuario usuario){
		this.evaluador = new EvaluadorDeContexto (usuario);
		this.usuario = usuario;
	}
	
	public Itinerario escanearAtracciones ( List <Atraccion> atracciones){
		
		Coordenada posicionDeCalculo = this.usuario.getPosicion();
		Iterator<Atraccion> iterador = atracciones.iterator();
		Itinerario itinerario = new Itinerario ();
		
		while (iterador.hasNext()) {

			Atraccion atraccionEnEvaluacion = iterador.next();

			this.evaluador.evaluarSiAtraccionEsAccesible(
					atraccionEnEvaluacion, itinerario, posicionDeCalculo);	
		}
		
		return itinerario;
	}
	
	public void escanearPromociones(List<Itinerario> itinerarios,
			List <PromocionPorSubconjunto> promocionesDisponibles) {
	
		Iterator <PromocionPorSubconjunto> iterador = promocionesDisponibles.iterator();
		
		
		while (iterador.hasNext()){
			PromocionPorSubconjunto promocionAEvaluar = iterador.next();
			Itinerario itinerarioACrear = new Itinerario ();
			
			if (this.evaluador.promocionEsAplicable(promocionAEvaluar, itinerarioACrear)) {
				itinerarios.add( itinerarioACrear );
			}	
		}
	}

	/**
	 * agrega un itinerario por cada promocion englobadora, 
	 * si aplica la promocion
	 * @param itinerarios
	 * @param promocionesAlConjunto
	 */
	public void escanearPromocionesEnglobadoras(List<Itinerario> itinerarios,
			List<PromocionEnglobadora> promocionesAlConjunto) {
		
		Iterator <PromocionEnglobadora> iterador = promocionesAlConjunto.iterator();
		
		while ( iterador.hasNext() ){
			
			List<Atraccion> atraccionesRebajadas = iterador.next()
					.rebajarPrecioAtracciones();
			
			Itinerario itinerario = this
					.escanearAtracciones(atraccionesRebajadas);
			
			itinerarios.add(itinerario);
		}
	}
}