package calculo;

import parque.Atraccion;
import parque.Coordenada;
import parque.Usuario;

public class CalculadorDeTraslado {

	public float calcularTiempoDeTraslado(Atraccion atraccion,
			Usuario usuario, Coordenada posicionDeCalculo) {

		float tiempoDeTraslado = 0;

		float distanciaX = atraccion.getPosicion().getX()
				- posicionDeCalculo.getX();
		float distanciaY = atraccion.getPosicion().getY()
				- posicionDeCalculo.getY();

		float distancia = (float) (Math.pow(distanciaX, 2) + Math.pow(
				distanciaY, 2));
		distancia = (float) Math.pow(distancia, 0.5);

		tiempoDeTraslado = distancia / usuario.getVelocidadDeTraslado();

		return tiempoDeTraslado;
	}
	
	
}
