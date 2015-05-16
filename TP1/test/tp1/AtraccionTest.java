package tp1;

import org.junit.Assert;
import org.junit.Test;
import trabajo1.parque.Atraccion;
import trabajo1.parque.Coordenada;
import trabajo1.parque.TipoDeAtraccion;

public class AtraccionTest {

	@Test
	public void clonarAtraccionTest (){
		
		Atraccion atraccion = new Atraccion(new Coordenada(1, 1),
				TipoDeAtraccion.DEGUSTACION);
		
		Atraccion copiaAtraccion = atraccion.clone();

		Assert.assertEquals(copiaAtraccion, atraccion);
		Assert.assertFalse( copiaAtraccion == atraccion );
	}
}