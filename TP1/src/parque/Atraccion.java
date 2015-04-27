package parque;

public class Atraccion {

	private Coordenada posicion;
	private float costo;
	private int tiempoDeDuracion;
	private int cupo;
	private TipoDeAtraccion tipo;

	public Atraccion(Coordenada posicion, TipoDeAtraccion tipo) {
		this.posicion = posicion;
		this.tipo = tipo;
	}

	public float getCosto() {
		return this.costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public int getTiempoDeDuracion() {
		return this.tiempoDeDuracion;
	}

	public void setTiempoDeDuracion(int tiempoDeDuracion) {
		this.tiempoDeDuracion = tiempoDeDuracion;
	}

	public int getCupo() {
		return this.cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoDeAtraccion tipo) {
		this.tipo = tipo;
	}

	public Coordenada getPosicion() {
		return this.posicion;
	}

	public boolean equals(Object obj) {

		boolean iguales = super.equals(obj);

		if (!iguales && obj instanceof Atraccion) {

			Atraccion obje = (Atraccion) obj;

			iguales = this.posicion.equals(obje.getPosicion())
					&& this.tipo == obje.getTipo();
		}

		return iguales;
	}
	
	public int hashCode (){
		
		
		return this.posicion.hashCode();
		
	}
	
}