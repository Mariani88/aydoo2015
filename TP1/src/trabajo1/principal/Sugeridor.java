package trabajo1.principal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import trabajo1.calculo.EvaluadorDeContexto;
import trabajo1.parque.Atraccion;
import trabajo1.parque.Coordenada;
import trabajo1.parque.Promocion;
import trabajo1.parque.Usuario;

public class Sugeridor {

	private List<Atraccion> atracciones;
	private List<Promocion> promocionesDisponibles;

	public Sugeridor(List<Atraccion> atracciones, List<Promocion> promociones) {
		this.atracciones = atracciones;
		this.promocionesDisponibles = promociones;
	}
	
	public Sugeridor(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
		this.promocionesDisponibles = new LinkedList <Promocion>();
	}

	public List<Itinerario> crearItinerarios(Usuario usuario) {

		List<Itinerario> itinerarios = new LinkedList<Itinerario>();
		Coordenada posicionDeCalculo = usuario.getPosicion();
		Iterator<Atraccion> iterador = this.atracciones.iterator();
		EvaluadorDeContexto evaluador = new EvaluadorDeContexto (usuario);
		
		this.aplicarPromociones (itinerarios, usuario);
		
		Itinerario itinerario = new Itinerario ();
		
		while (iterador.hasNext()) {

			Atraccion atraccionEnEvaluacion = iterador.next();

			evaluador.evaluarSiAtraccionEsAccesible(
					atraccionEnEvaluacion, itinerario, posicionDeCalculo);	
		}
		
		itinerarios.add(itinerario);

		return itinerarios;
	}

	
	private void aplicarPromociones(List<Itinerario> itinerarios,
			Usuario usuario) {
	
		Iterator <Promocion> iterador = this.promocionesDisponibles.iterator();
		EvaluadorDeContexto evaluador = new EvaluadorDeContexto (usuario);
		
		while (iterador.hasNext()){
			Promocion promocionAEvaluar = iterador.next();
			Itinerario itinerarioACrear = new Itinerario ();
			
			if (evaluador.promocionEsAplicable(promocionAEvaluar, itinerarioACrear)) {
				itinerarios.add( itinerarioACrear );
			}	
		}
	}
}