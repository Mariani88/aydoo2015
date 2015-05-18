package tp1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.junit.Assert;
import org.junit.Test;

import trabajo1.parque.Atraccion;
import trabajo1.parque.promociones.PromocionEnglobadora;
import trabajo1.parque.promociones.PromocionFamiliar;
import trabajo1.principal.Sugeridor;

public class PromocionFamiliarTest {

	@Test
	public void rebajarPrecioAtraccionesSiAplica() {

		Map<Atraccion, Integer> entradasPorAtraccion = new HashMap<Atraccion, Integer>();
		Inicializador inicializador = new Inicializador();
		inicializador.inicializarDatosDePrueba();

		Sugeridor sugeridor = new Sugeridor(inicializador.getAtracciones());

		this.cargarMap(entradasPorAtraccion, inicializador.getAtracciones());

		PromocionEnglobadora promocion = new PromocionFamiliar(5,
				entradasPorAtraccion);

		List<Atraccion> copiaAtracciones = promocion.rebajarPrecioAtracciones();

		Assert.assertEquals(200, copiaAtracciones.get(0).getCosto(), 1);
		Assert.assertEquals(1500, copiaAtracciones.get(1).getCosto(), 1);
		Assert.assertEquals(1800, copiaAtracciones.get(2).getCosto(), 1);
		Assert.assertEquals(17200, copiaAtracciones.get(3).getCosto(), 1);
		Assert.assertEquals(2000, copiaAtracciones.get(4).getCosto(), 1);
		Assert.assertEquals(285, copiaAtracciones.get(5).getCosto(), 1);
	}

	private void cargarMap(Map<Atraccion, Integer> entradasPorAtraccion,
			List<Atraccion> atracciones) {
		
		Iterator <Atraccion> iterador = atracciones.iterator();
		int entrada = 1;
		
		while (iterador.hasNext()){  //2,3,4,5,6,7 
			entrada++;
			entradasPorAtraccion.put(iterador.next().clone(), entrada );	
		}
	}

	@Test
	public void noRebajarPreciosSiNoEstaVigente(){
		
		Map<Atraccion, Integer> entradasPorAtraccion = new HashMap<Atraccion, Integer>();
		Inicializador inicializador = new Inicializador();
		inicializador.inicializarDatosDePrueba();

		Sugeridor sugeridor = new Sugeridor(inicializador.getAtracciones());

		this.cargarMap(entradasPorAtraccion, inicializador.getAtracciones());

		PromocionEnglobadora promocion = new PromocionFamiliar(0,
				entradasPorAtraccion);

		List<Atraccion> copiaAtracciones = promocion.rebajarPrecioAtracciones();

		Assert.assertEquals(100, copiaAtracciones.get(0).getCosto(), 1);
		Assert.assertEquals(500, copiaAtracciones.get(1).getCosto(), 1);
		Assert.assertEquals(500, copiaAtracciones.get(2).getCosto(), 1);
		Assert.assertEquals(4000, copiaAtracciones.get(3).getCosto(), 1);
		Assert.assertEquals(400, copiaAtracciones.get(4).getCosto(), 1);
		Assert.assertEquals(50, copiaAtracciones.get(5).getCosto(), 1);
	}


}