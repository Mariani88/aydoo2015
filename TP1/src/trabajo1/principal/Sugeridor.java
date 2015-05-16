package trabajo1.principal;

import java.util.LinkedList;
import java.util.List;

import trabajo1.calculo.EscanerDeAtracciones;
import trabajo1.parque.Atraccion;
import trabajo1.parque.Usuario;
import trabajo1.parque.promociones.PromocionPorSubconjunto;

public class Sugeridor {

	private static List<Atraccion> atracciones;
	private List<PromocionPorSubconjunto> promocionesDisponibles;
	
	
	public Sugeridor(List<Atraccion> atraccionesDelParque, List<PromocionPorSubconjunto> promociones) {
		atracciones = atraccionesDelParque;
		this.promocionesDisponibles = promociones;
	}
	
	public Sugeridor(List<Atraccion> atraccionesDelParque) {
		atracciones = atraccionesDelParque;
		this.promocionesDisponibles = new LinkedList <PromocionPorSubconjunto>();
	}
	
	public static List <Atraccion> getAtracciones(){
		return atracciones;
	}
	
	public List<Itinerario> crearItinerarios(Usuario usuario) {

		List<Itinerario> itinerarios = new LinkedList<Itinerario>();
		EscanerDeAtracciones escaner = new EscanerDeAtracciones (usuario);
		
		escaner.escanearPromociones(itinerarios, this.promocionesDisponibles);
		Itinerario itinerario = escaner.escanearAtracciones(atracciones);
		itinerarios.add(itinerario);

		return itinerarios;
	}
}