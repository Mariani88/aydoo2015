package tp1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parque.Atraccion;
import parque.Coordenada;
import parque.Promocion;
import parque.PromocionAbsoluta;
import parque.PromocionAxB;
import parque.PromocionPorcentual;
import parque.TipoDeAtraccion;
import parque.Usuario;

public class TestsTP1 {

	private List<Atraccion> atracciones = new LinkedList<Atraccion>();
	private Usuario usuario;
	private List<Promocion> promociones;

	@Before
	public void inicializarAtraccionesDePrueba() {

		Atraccion atraccion0 = new Atraccion(new Coordenada(1, 1),
				TipoDeAtraccion.AVENTURA);
		atraccion0.setCosto(100);
		atraccion0.setCupo(20);
		atraccion0.setTiempoDeDuracion(3);

		Atraccion atraccion1 = new Atraccion(new Coordenada(3, 10),
				TipoDeAtraccion.AVENTURA);
		atraccion1.setCosto(500);
		atraccion1.setCupo(40);
		atraccion1.setTiempoDeDuracion(5);

		Atraccion atraccion2 = new Atraccion(new Coordenada(4, 6),
				TipoDeAtraccion.DEGUSTACION);
		atraccion2.setCosto(500);
		atraccion2.setCupo(30);
		atraccion2.setTiempoDeDuracion(6);

		Atraccion atraccion3 = new Atraccion(new Coordenada(5, 5),
				TipoDeAtraccion.PAISAJE);
		atraccion3.setCosto(4000);
		atraccion3.setCupo(50);
		atraccion3.setTiempoDeDuracion(10);

		Atraccion atraccion4 = new Atraccion(new Coordenada(15, 10),
				TipoDeAtraccion.AVENTURA);
		atraccion4.setCosto(400);
		atraccion4.setCupo(80);
		atraccion4.setTiempoDeDuracion(1);

		Atraccion atraccion5 = new Atraccion(new Coordenada(70, 10),
				TipoDeAtraccion.PAISAJE);
		atraccion5.setCosto(50);
		atraccion5.setCupo(40);
		atraccion5.setTiempoDeDuracion(4);

		this.atracciones.add(atraccion0);
		this.atracciones.add(atraccion1);
		this.atracciones.add(atraccion2);
		this.atracciones.add(atraccion3);
		this.atracciones.add(atraccion4);
		this.atracciones.add(atraccion5);

	}

	@Test
	public void testMismaPosicionYMismoTipoIgualMismaAtraccion() {

		Atraccion atraccion1 = new Atraccion(new Coordenada(1, 1),
				TipoDeAtraccion.AVENTURA);
		Atraccion atraccion2 = new Atraccion(new Coordenada(1, 1),
				TipoDeAtraccion.AVENTURA);

		Assert.assertTrue(atraccion1.equals(atraccion2));
	}

	/*
	 * @Test public void mismaPromocionSiMismasAtracciones (){
	 * 
	 * 
	 * }
	 * 
	 * @Test public void devolverItinerarioConPromocionesAccesibles(){
	 * 
	 * }
	 */

}
