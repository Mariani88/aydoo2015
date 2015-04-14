package ejercicio1;

public class CharCounter {

	private String characters;
	
	public CharCounter (String characters){
		this.characters = characters;
	}

	public int howMany (char character){
		
		int result = 0;
		
		if ( character == '$' ){
			result = -1;
		
		}else if(character == '@'){
			result = -2;
		}
		
		return result;
	}
}
