package trabajo1.parque;

public class Usuario {

	private float presupuesto;
	private float tiempoDiponible;
	private int velocidadDeTraslado;
	private TipoDeAtraccion AtraccionPreferida;
	private Coordenada posicion;
	private Coordenada domicilio;
	
	public Usuario (TipoDeAtraccion atraccionPreferida, Coordenada domicilio){
		this.posicion = new Coordenada (0,0);
		this.AtraccionPreferida = atraccionPreferida;
		this.domicilio = domicilio;
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

	public float getTiempoDiponible() {
		return this.tiempoDiponible;
	}

	public void setTiempoDiponible(float tiempoDiponible) {
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
	
	public Coordenada getDomicilio (){
		return this.domicilio;
	}
}