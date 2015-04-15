package ejercicio1;

import java.util.HashMap;
import java.util.Map;


/**
 * @author matias
 *Clase que hereda de un HashMap con tipos ya definidos, 
 *construida para sobreescribir el metodo GET 
 */

public class HashMapModified extends HashMap<Character, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Devuelve el valor asociado a una clave, 
	 * si la clave no existe devuelve 0 en lugar de NULL
	 */
	@Override
	public Integer get(Object key){
		Integer resultado = 0;
		
		if (super.get(key) !=null){
			resultado = super.get(key);
		}
		
		return resultado;
	}	
}