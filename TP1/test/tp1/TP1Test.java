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

public class TP1Test {

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

		Atraccion atraccion5 = new Atraccion(new Coordenada(20, 10),
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

		Promocion promocion0 = new PromocionAbsoluta(atracciones0, 9, 100);

		// atraccion0, atraccion1, atraccion3
		List<Atraccion> atracciones1 = new LinkedList<Atraccion>();
		atracciones1.add(this.atracciones.get(1));
		atracciones1.add(this.atracciones.get(4));

		Promocion promocion1 = new PromocionPorcentual(atracciones1, 7, 25);

		// atraccion0, atraccion1, atraccion3, atraccion5
		List<Atraccion> atracciones2 = new LinkedList<Atraccion>();
		atracciones2.addAll(atracciones0);
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
	public void testMismaPosicionYMismoTipoIgualMismaAtraccion () {

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

		Sugestor sugestor = new Sugestor(this.atracciones);
		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		Assert.assertEquals(atraccionesResultantes, itinerarios.get(0)
				.getAtracciones());
	}

	@Test
	public void devolverItinerarioConAtraccionesMasAccesiblesPorPresupuesto () {

		this.usuario.setPresupuesto(600);
		this.usuario.setTiempoDiponible(1000);
		this.usuario.setVelocidadDeTraslado(1000);

		Sugestor sugestor = new Sugestor(this.atracciones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		List<Atraccion> atraccionesAccesibles = new LinkedList<Atraccion>();
		atraccionesAccesibles.add(this.atracciones.get(0));
		atraccionesAccesibles.add(this.atracciones.get(1));

		Assert.assertEquals(atraccionesAccesibles, itinerarios.get(0)
				.getAtracciones());
	}
	
	@Test
	public void noDevolverAtraccionesSinCupo  (){
		
		this.usuario.setPresupuesto(600);
		this.usuario.setTiempoDiponible(1000);
		this.usuario.setVelocidadDeTraslado(1000);

		this.atracciones.get(0).setCupo(0);
		
		Sugestor sugestor = new Sugestor(this.atracciones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		List<Atraccion> atraccionesAccesibles = new LinkedList<Atraccion>();
		
		atraccionesAccesibles.add(this.atracciones.get(1));

		Assert.assertEquals(atraccionesAccesibles, itinerarios.get(0)
				.getAtracciones());
		
		this.atracciones.get(0).setCupo(100);
		
	}
	
	
	@Test
	public void rechazarAtraccionesConTiempoQueSuperaElDisponible (){
		
		this.usuario.setPresupuesto(6000);
		this.usuario.setTiempoDiponible((float)4.1);
		this.usuario.setVelocidadDeTraslado(100000);

		Sugestor sugestor = new Sugestor(this.atracciones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		List<Atraccion> atraccionesAccesibles = new LinkedList<Atraccion>();
		atraccionesAccesibles.add(this.atracciones.get(0));
		atraccionesAccesibles.add(this.atracciones.get(4));

		Assert.assertEquals(atraccionesAccesibles, itinerarios.get(0)
				.getAtracciones());
	}
	
	@Test
	public void rechazarAtraccionesConDistanciaInaccesiblePorTiempo (){
		
		this.usuario.setPresupuesto(6000);
		this.usuario.setTiempoDiponible((float)8.5);
		this.usuario.setVelocidadDeTraslado(30);
		
		Sugestor sugestor = new Sugestor(this.atracciones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		List<Atraccion> atraccionesAccesibles = new LinkedList<Atraccion>();
		atraccionesAccesibles.add(this.atracciones.get(0));
		atraccionesAccesibles.add(this.atracciones.get(1));

		Assert.assertEquals(atraccionesAccesibles, itinerarios.get(0)
				.getAtracciones());
	
		//modifico tiempo disponible
		this.usuario.setVelocidadDeTraslado(1);
		
		itinerarios = sugestor.crearItinerarios(this.usuario);
		atraccionesAccesibles.remove(1);
		Assert.assertEquals(atraccionesAccesibles, itinerarios.get(0)
				.getAtracciones());
	}
	
	@Test
	public void considerarPromocionesAccesiblesSobreItinerarioComun  (){
		
		this.usuario.setPresupuesto(600);
		this.usuario.setTiempoDiponible((float)100);
		this.usuario.setVelocidadDeTraslado(10000);
		
		Sugestor sugestor = new Sugestor(this.atracciones, this.promociones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);


		Assert.assertEquals(this.promociones.get(0).getAtracciones(),
				itinerarios.get(0).getAtracciones());
		Assert.assertEquals(500, itinerarios.get(0).getCostoTotal(), 1);
	}
	
	
	@Test
	public void considerarPromocionesAccesiblesPorTiempoDisponible (){
		
		this.usuario.setPresupuesto(6000);
		this.usuario.setTiempoDiponible((float)20);
		this.usuario.setVelocidadDeTraslado(10000);
		
		Sugestor sugestor = new Sugestor(this.atracciones, this.promociones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);


		Assert.assertEquals(this.promociones.get(0).getAtracciones(),
				itinerarios.get(0).getAtracciones());
		Assert.assertEquals(500, itinerarios.get(0).getCostoTotal(), 1);
		
		Assert.assertEquals(this.promociones.get(1).getAtracciones(),
				itinerarios.get(1).getAtracciones());
		Assert.assertEquals(675, itinerarios.get(1).getCostoTotal(), 1);
		
	}
	
	@Test
	public void ConsiderarPromocionesAccesiblesPorVigencia (){
		
		this.usuario.setPresupuesto(6000);
		this.usuario.setTiempoDiponible((float)8.1);
		this.usuario.setVelocidadDeTraslado(10000);
		
		Sugestor sugestor = new Sugestor(this.atracciones, this.promociones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		
		Itinerario itinerarioInaccesible = new Itinerario(4600, this.promociones
				.get(2).getAtracciones());

		Assert.assertEquals(this.promociones.get(0).getAtracciones(),
				itinerarios.get(0).getAtracciones());
		Assert.assertEquals(500, itinerarios.get(0).getCostoTotal(), 1);
		
		Assert.assertFalse(itinerarios.contains( itinerarioInaccesible ));

	}
	
	@Test
	public void considerarTiempoDeTrasladoEnLasPromociones (){
		
		this.usuario.setPresupuesto(6000);
		this.usuario.setTiempoDiponible((float)8);
		this.usuario.setVelocidadDeTraslado(10000);
		
		Sugestor sugestor = new Sugestor(this.atracciones, this.promociones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		
		Itinerario itinerarioInaccesible = new Itinerario(500, this.promociones
				.get(0).getAtracciones());

		
		
		Assert.assertFalse(itinerarios.contains( itinerarioInaccesible ));
		
		
		
		
	}
}