package tp1;

import java.util.LinkedList;
import java.util.List;
import trabajo1.parque.Atraccion;
import trabajo1.parque.Coordenada;
import trabajo1.parque.TipoDeAtraccion;
import trabajo1.parque.Usuario;
import trabajo1.parque.promociones.PromocionAbsoluta;
import trabajo1.parque.promociones.PromocionCuatroPorTres;
import trabajo1.parque.promociones.PromocionPorSubconjunto;
import trabajo1.parque.promociones.PromocionPorcentual;

public class Inicializador {

	
	private List<Atraccion> atracciones = new LinkedList<Atraccion>();
	private Usuario usuario;
	private List<PromocionPorSubconjunto> promociones;

	private void inicializarAtraccionesDePrueba() {

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

	private void inicializarUsuarioDePrueba() {

		this.usuario = new Usuario(TipoDeAtraccion.AVENTURA, new Coordenada(
				-100, -100));
	}

	private void inicializarPromociones() {

		// atraccion0, atraccion1
		List<Atraccion> atracciones0 = new LinkedList<Atraccion>();
		atracciones0.add(this.atracciones.get(0));
		atracciones0.add(this.atracciones.get(1));

		PromocionPorSubconjunto promocion0 = new PromocionAbsoluta(atracciones0, 9, 100);

		// atraccion0, atraccion1, atraccion3
		List<Atraccion> atracciones1 = new LinkedList<Atraccion>();
		atracciones1.add(this.atracciones.get(1));
		atracciones1.add(this.atracciones.get(4));

		PromocionPorSubconjunto promocion1 = new PromocionPorcentual(atracciones1, 7, 25);

		// atraccion0, atraccion1, atraccion3, atraccion5
		List<Atraccion> atracciones2 = new LinkedList<Atraccion>();
		atracciones2.addAll(atracciones0);
		atracciones2.addAll(atracciones1);
		atracciones2.add(this.atracciones.get(5));

		PromocionPorSubconjunto promocion2 = new PromocionCuatroPorTres(atracciones2, 6,
				this.atracciones.get(5));

		this.promociones = new LinkedList<PromocionPorSubconjunto>();
		this.promociones.add(promocion0);
		this.promociones.add(promocion1);
		this.promociones.add(promocion2);
	}


	public void inicializarDatosDePrueba (){	
		this.inicializarAtraccionesDePrueba();	
	}

	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public List<PromocionPorSubconjunto> getPromociones() {
		return this.promociones;
	}	
}