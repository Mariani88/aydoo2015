package trabajo1.parque.promociones;

import java.util.List;

import trabajo1.parque.Atraccion;
import trabajo1.parque.Coordenada;

public class PromocionExtranjero extends PromocionEnglobadora {

	private Coordenada domicilioExtranjero;

	public PromocionExtranjero(float vigencia, Coordenada domicilio){
		super(50, vigencia);
		
		this.domicilioExtranjero = domicilio;
	}

	@Override
	public List<Atraccion> rebajarPrecioAtracciones() {
		// TODO Auto-generated method stub
		return null;
	}
}