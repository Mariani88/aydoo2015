package parque;

public class Usuario {

	private float presupuesto;
	private int tiempoDiponible;
	private int velocidadDeTraslado;
	private TipoDeAtraccion AtraccionPreferida;
	private Coordenada posicion;
	
	
	public Usuario (TipoDeAtraccion atraccionPreferida){
		this.posicion = new Coordenada (0,0);
		
		this.AtraccionPreferida = atraccionPreferida;
	}


	public void setPosicion(Coordenada posicion) {
		this.posicion = posicion;
	}


	public float getPresupuesto() {
		return this.presupuesto;
	}


	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}


	public int getTiempoDiponible() {
		return this.tiempoDiponible;
	}


	public void setTiempoDiponible(int tiempoDiponible) {
		this.tiempoDiponible = tiempoDiponible;
	}


	public int getVelocidadDeTraslado() {
		return this.velocidadDeTraslado;
	}


	public void setVelocidadDeTraslado(int velocidadDeTraslado) {
		this.velocidadDeTraslado = velocidadDeTraslado;
	}


	public TipoDeAtraccion getAtraccionPreferida() {
		return this.AtraccionPreferida;
	}


	public Coordenada getPosicion() {
		return this.posicion;
	}	
}