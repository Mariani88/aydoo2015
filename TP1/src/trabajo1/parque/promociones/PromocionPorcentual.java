package trabajo1.parque.promociones;

import java.util.Iterator;
import java.util.List;

import trabajo1.excepcionesLocales.PorcentajeInvalido;
import trabajo1.parque.Atraccion;

public class PromocionPorcentual extends PromocionPorSubconjunto {

	public PromocionPorcentual(List<Atraccion> atracciones, float vigencia, float porcentajeDeDescuento) {
		super(atracciones, vigencia);
		
		try {
			if ( porcentajeDeDescuento <= 100 && 0 < porcentajeDeDescuento ){
				this.criterioDeDescuento = porcentajeDeDescuento /100;
			}else{
				RuntimeException e = new PorcentajeInvalido ();
				throw e;
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
		}
	}

	@Override
	public float getDescuento() {
		
		float total = 0;
		Iterator<Atraccion> iterador = this.atracciones.iterator();
		
		while (iterador.hasNext()){
			total = total + iterador.next().getCosto();
		}
		
		return total*this.criterioDeDescuento;
	}	
}