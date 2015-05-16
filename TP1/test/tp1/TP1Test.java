package tp1;

import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trabajo1.parque.Atraccion;
import trabajo1.parque.Coordenada;
import trabajo1.parque.TipoDeAtraccion;
import trabajo1.parque.Usuario;
import trabajo1.parque.promociones.PromocionPorSubconjunto;
import trabajo1.principal.Itinerario;
import trabajo1.principal.Sugeridor;

public class TP1Test {

	private List<Atraccion> atracciones = new LinkedList<Atraccion>();
	private Usuario usuario;
	private List<PromocionPorSubconjunto> promociones;

	@Before
	public void inicializarDatos (){
		
		Inicializador inicializador = new Inicializador ();
		inicializador.inicializarDatosDePrueba();
		
		this.atracciones = inicializador.getAtracciones();
		this.promociones = inicializador.getPromociones();
		this.usuario = inicializador.getUsuario();
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

		Sugeridor sugestor = new Sugeridor(this.atracciones);
		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);

		Assert.assertEquals(atraccionesResultantes, itinerarios.get(0)
				.getAtracciones());
	}

	
	
	
	@Test
	public void devolverItinerarioConAtraccionesMasAccesiblesPorPresupuesto () {

		this.usuario.setPresupuesto(600);
		this.usuario.setTiempoDiponible(1000);
		this.usuario.setVelocidadDeTraslado(1000);

		Sugeridor sugestor = new Sugeridor(this.atracciones);

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
		
		Sugeridor sugestor = new Sugeridor(this.atracciones);

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

		Sugeridor sugestor = new Sugeridor(this.atracciones);

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
		
		Sugeridor sugestor = new Sugeridor(this.atracciones);

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
		
		Sugeridor sugestor = new Sugeridor(this.atracciones, this.promociones);

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
		
		Sugeridor sugestor = new Sugeridor(this.atracciones, this.promociones);

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
		
		Sugeridor sugestor = new Sugeridor(this.atracciones, this.promociones);

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
		
		Sugeridor sugestor = new Sugeridor(this.atracciones, this.promociones);

		List<Itinerario> itinerarios = sugestor.crearItinerarios(this.usuario);
		
		Itinerario itinerarioInaccesible = new Itinerario(500, this.promociones
				.get(0).getAtracciones());

		Assert.assertFalse(itinerarios.contains( itinerarioInaccesible ));	
	}
}