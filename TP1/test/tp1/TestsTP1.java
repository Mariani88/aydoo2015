package tp1;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import parque.Atraccion;
import parque.Coordenada;
import parque.Promocion;
import parque.PromocionAbsoluta;
import parque.PromocionAxB;
import parque.PromocionPorcentual;
import parque.TipoDeAtraccion;
import parque.Usuario;
import tp1.Itinerario;
import tp1.Sugestor;

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

		this.inicializarUsuarioDePrueba();
		this.inicializarPromociones();

	}

	public void inicializarUsuarioDePrueba() {

		this.usuario = new Usuario(TipoDeAtraccion.AVENTURA);
	}

	public void inicializarPromociones() {

		// atraccion0, atraccion1
		List<Atraccion> atracciones0 = new LinkedList<Atraccion>();
		atracciones0.add(this.atracciones.get(0));
		atracciones0.add(this.atracciones.get(1));

		Promocion promocion0 = new PromocionAbsoluta(atracciones0, 1, 100);

		// atraccion0, atraccion1, atraccion3
		List<Atraccion> atracciones1 = new LinkedList<Atraccion>();
		atracciones1.add(this.atracciones.get(0));
		atracciones1.add(this.atracciones.get(1));
		atracciones1.add(this.atracciones.get(3));

		Promocion promocion1 = new PromocionPorcentual(atracciones1, 3, 25);

		// atraccion0, atraccion1, atraccion3, atraccion5
		List<Atraccion> atracciones2 = new LinkedList<Atraccion>();
		atracciones2.addAll(atracciones1);
		atracciones2.add(this.atracciones.get(5));

		Promocion promocion2 = new PromocionAxB(atracciones2, 6,
				this.atracciones.get(5));

		this.promociones = new LinkedList<Promocion>();
		this.promociones.add(promocion0);
		this.promociones.add(promocion1);
		this.promociones.add(promocion2);
	}

	@Test
	public void testMismaPosicionYMismoTipoIgualMismaAtraccion() {

		Atraccion atraccion1 = new Atraccion(new Coordenada(1, 1),
				TipoDeAtraccion.AVENTURA);
		Atraccion atraccion2 = new Atraccion(new Coordenada(1, 1),
				TipoDeAtraccion.AVENTURA);

		Assert.assertTrue(atraccion1.equals(atraccion2));
	}

	@Test
	public void testDevolverItinerarioConAtraccionesPreferidas() {

		this.usuario.setPresupuesto(60000);
		this.usuario.setTiempoDiponible(1000);
		this.usuario.setVelocidadDeTraslado(1000);
		
		List<Atraccion> atraccionesResultantes = new LinkedList<Atraccion>();
		atraccionesResultantes.add(this.atracciones.get(0));
		atraccionesResultantes.add(this.atracciones.get(1));
		atraccionesResultantes.add(this.atracciones.get(4));

		Sugestor sugestor = new Sugestor(this.atracciones, this.promociones);
		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		Assert.assertEquals(atraccionesResultantes, itinerarios.get(0)
				.getAtracciones());
	}

	@Test
	public void devolverItinerarioConAtraccionesMasAccesiblesPorPresupuesto() {

		this.usuario.setPresupuesto(600);
		this.usuario.setTiempoDiponible(1000);
		this.usuario.setVelocidadDeTraslado(1000);

		Sugestor sugestor = new Sugestor(this.atracciones, this.promociones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		List<Atraccion> atraccionesAccesibles = new LinkedList<Atraccion>();
		atraccionesAccesibles.add(this.atracciones.get(0));
		atraccionesAccesibles.add(this.atracciones.get(1));

		Assert.assertEquals(atraccionesAccesibles, itinerarios.get(0)
				.getAtracciones());
	}
}