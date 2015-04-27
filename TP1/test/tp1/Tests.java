package tp1;

import java.util.HashSet;
import java.util.Set;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parque.Atraccion;
import parque.Coordenada;
import parque.Promocion;
import parque.PromocionAbsoluta;
import parque.TipoDeAtraccion;

public class Tests {

	
	@Test
	public void mismaPosicionYMismoTipoIgualMismaAtraccion() {

		Atraccion atraccion1 = new Atraccion(new Coordenada(1, 1),
				TipoDeAtraccion.AVENTURA);
		Atraccion atraccion2 = new Atraccion(new Coordenada(1, 1),
				TipoDeAtraccion.AVENTURA);

		
		Assert.assertTrue(atraccion1.equals(atraccion2));
		
	}
	
	
	/*@Before
	public void inicializarDatosDePrueba (){
		
		Set <Atraccion> atracciones = new HashSet <Atraccion> ();
		
		Promocion promocionAbsoluta = new PromocionAbsoluta(, 5, 500);
		
		
	}
	
	@Test
	public void devolverItinerarioConPromocionesAccesibles(){
		
	}*/
	
	
}
