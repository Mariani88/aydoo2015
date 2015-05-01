
import iterador.Iterador;
import iterador.Lista;

import org.junit.Assert;
import org.junit.Test;

public class IteradorTest {

	@Test
	public void test(){
		
		Lista<Integer> lista = new Lista <Integer> ();
		Iterador <Integer> iterador = lista.iterador();

		Assert.assertFalse(iterador.haySiguiente());
		
		lista.agregar(4);
		iterador = lista.iterador();
		
		Assert.assertTrue(iterador.haySiguiente());
		Assert.assertEquals(new Integer(4), iterador.siguiente());
		Assert.assertFalse(iterador.haySiguiente());
		
		
		
	}
	
	
	
}
