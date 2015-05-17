package tp1;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import trabajo1.parque.Atraccion;
import trabajo1.parque.Coordenada;
import trabajo1.parque.Usuario;
import trabajo1.parque.promociones.PromocionEnglobadora;
import trabajo1.parque.promociones.PromocionExtranjero;
import trabajo1.principal.Sugeridor;

public class PromocionExtranjeroTest {

	@Test
	public void rebajarPrecioAtraccionesSiAplica() {

		Inicializador inicializador = new Inicializador();
		inicializador.inicializarDatosDePrueba();

		Sugeridor sugeridor = new Sugeridor(inicializador.getAtracciones());
		Usuario usuario = inicializador.getUsuario();
		usuario.getDomicilio().setX(-2000);

		PromocionEnglobadora promocion = new PromocionExtranjero(5, usuario);

		List<Atraccion> atraccionesRebajadas = promocion
				.rebajarPrecioAtracciones();

		Assert.assertEquals(50, atraccionesRebajadas.get(0).getCosto(), 1);
		Assert.assertEquals(250, atraccionesRebajadas.get(1).getCosto(), 1);
		Assert.assertEquals(250, atraccionesRebajadas.get(2).getCosto(), 1);
		Assert.assertEquals(2000, atraccionesRebajadas.get(3).getCosto(), 1);
		Assert.assertEquals(200, atraccionesRebajadas.get(4).getCosto(), 1);
		Assert.assertEquals(25, atraccionesRebajadas.get(5).getCosto(), 1);
	}
	
	
	@Test
	public void noRebajarSiNoAplica (){
		
		Inicializador inicializador = new Inicializador();
		inicializador.inicializarDatosDePrueba();

		Sugeridor sugeridor = new Sugeridor(inicializador.getAtracciones());
		Usuario usuario = inicializador.getUsuario();

		PromocionEnglobadora promocion = new PromocionExtranjero(5, usuario);

		List<Atraccion> atraccionesRebajadas = promocion
				.rebajarPrecioAtracciones();

		this.validarValoresSinModificacion(atraccionesRebajadas);
	}
	
	/*@Test
	public void noRebajarSiNoHayVigencia (){
		
		Inicializador inicializador = new Inicializador();
		inicializador.inicializarDatosDePrueba();

		Sugeridor sugeridor = new Sugeridor(inicializador.getAtracciones());
		Usuario usuario = inicializador.getUsuario();
		usuario.getDomicilio().setX(-2000);
		
		PromocionEnglobadora promocion = new PromocionExtranjero(0, usuario);

		List<Atraccion> atraccionesRebajadas = promocion
				.rebajarPrecioAtracciones();

		this.validarValoresSinModificacion(atraccionesRebajadas);
	}*/
	
	
	private void validarValoresSinModificacion(
			List<Atraccion> atraccionesRebajadas) {
		Assert.assertEquals(100, atraccionesRebajadas.get(0).getCosto(), 1);
		Assert.assertEquals(500, atraccionesRebajadas.get(1).getCosto(), 1);
		Assert.assertEquals(500, atraccionesRebajadas.get(2).getCosto(), 1);
		Assert.assertEquals(4000, atraccionesRebajadas.get(3).getCosto(), 1);
		Assert.assertEquals(400, atraccionesRebajadas.get(4).getCosto(), 1);
		Assert.assertEquals(50, atraccionesRebajadas.get(5).getCosto(), 1);
	}
}