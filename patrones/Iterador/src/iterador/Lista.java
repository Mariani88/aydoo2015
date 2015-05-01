package iterador;

public class Lista<T> implements Iterable<T>{

	private Object[] lista = new Object[10]  ;
	private int tamanio = 0;
	
	@Override
	public Iterador<T> iterador() {
		return new ImplementacionIterador <T>(this);
	}
	
	public void agregar (T elemento){
		this.lista[tamanio] = elemento;
		tamanio++;
	}
	
	
	public int longitud (){
		return this.tamanio;
	}
	
	
	public T obtener (int indice){
		return (T)this.lista[indice];
	}
	
}
