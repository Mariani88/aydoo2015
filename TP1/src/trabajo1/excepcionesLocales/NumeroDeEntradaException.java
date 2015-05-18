package trabajo1.excepcionesLocales;

public class NumeroDeEntradaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumeroDeEntradaException (){
		super("Cantidad de entradas no puede ser negativo");
	}
}
