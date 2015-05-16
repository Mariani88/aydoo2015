package trabajo1.parque.promociones;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import trabajo1.parque.Atraccion;
import trabajo1.principal.Sugeridor;

public abstract class PromocionEnglobadora extends Promocion {
	
	public PromocionEnglobadora(float criterioDeDescuento, float vigencia) {
		this.atracciones = Sugeridor.getAtracciones();
		this.vigencia = vigencia;
		this.criterioDeDescuento = criterioDeDescuento;
	}

	public abstract List <Atraccion> rebajarPrecioAtracciones();
	
	protected List <Atraccion> clonarListaAtracciones (){
		
		List <Atraccion> copiaAtracciones = new LinkedList <Atraccion> ();
		Iterator <Atraccion> iterador = this.atracciones.iterator();
		
		while ( iterador.hasNext() ){
			copiaAtracciones.add(iterador.next().clone());
		}
			
		return copiaAtracciones;
	}
}