package ejercicio1;

import java.util.HashMap;

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
		
		}else{
			
			for (int i = 0; i < this.characters.length(); i++){
				if (this.characters.charAt(i) == character){
					result++;
				}
			}
			
		}
		
		return result;
	}
	
	
	public HashMap<Character, Integer> countAll() {

		HashMap<Character, Integer> results = new HashMapModified();

		for (int i = 0; i < this.characters.length(); i++) {

			if (results.containsKey(this.characters.charAt(i))) {

				int subtotal = results.get(this.characters.charAt(i));
				results.put(this.characters.charAt(i), subtotal + 1);

			} else {
				results.put(this.characters.charAt(i), 1);
			}
		}

		return results;
	}
}