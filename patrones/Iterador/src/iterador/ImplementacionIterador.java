package iterador;

public class ImplementacionIterador<T> implements Iterador<T>{

	private Lista<T> lista;
	private int indice = -1;
	
	public ImplementacionIterador ( Lista<T> lista){
		this.lista = lista;
	}
	
	@Override
	public boolean haySiguiente() {
		
		return this.indice < this.lista.longitud()-1;
	}

	@Override
	public T siguiente() {
		indice++;
		return (T)this.lista.obtener(indice);
	}


}
