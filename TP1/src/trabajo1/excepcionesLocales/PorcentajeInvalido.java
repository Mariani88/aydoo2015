package trabajo1.excepcionesLocales;

public class PorcentajeInvalido extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PorcentajeInvalido() {
		super(
				"el valor del porcentaje debe ser mayor a 0 y menor o igual a 100");
	}
}
