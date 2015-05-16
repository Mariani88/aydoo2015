package trabajo1.parque;

public class Coordenada implements Cloneable{
	
	private int x;
	private int y;
	
	public Coordenada (int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public boolean equals (Object obj){
		
		boolean iguales = super.equals(obj);
		
		if ( !iguales && obj != null && obj instanceof Coordenada ){	
			Coordenada obje = (Coordenada)obj;
			iguales = this.x == obje.getX() && this.y == obje.getY();
		}
		
		return iguales;
	}
	
	public Coordenada clone(){
		
		Coordenada copiaPosicion = null;
		
		try{
			copiaPosicion = (Coordenada)super.clone();
		}catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		
		return copiaPosicion;
	}
}