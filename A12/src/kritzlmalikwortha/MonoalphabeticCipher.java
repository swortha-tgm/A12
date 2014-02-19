package kritzlmalikwortha;

import java.util.HashSet;

public class MonoalphabeticCipher implements Cipher{

	private String secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";

	public MonoalphabeticCipher() {
		
		this.secretAlphabet=secretAlphabet;
		
	}

	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}


	/**
	 * @see kritzlmalikwortha.Cipher#encrypt(kritzlmalikwortha.lang.String)
	 */
	public String encrypt(String text) {
		String alph = this.getStandardAlphabet();
		text=text.toLowerCase();
		String unklar = ""; //Verschlüsselt
		
		for (int i = 0; i<text.length();i++){
			char test = text.charAt(i);
			
			if(alph.contains(""+test)){
				int index = alph.indexOf(test);
				unklar = unklar+this.getSecretAlphabet().charAt(index);
			}else{
				unklar=unklar+test;
			}
		}
		return unklar;
	}


	/**
	 * @see kritzlmalikwortha.Cipher#decrypt(kritzlmalikwortha.lang.String)
	 */
	public String decrypt(String text) {
		String alph = this.getStandardAlphabet();
		text=text.toLowerCase();
		String klar = ""; //Entschlüsselt
		
		for (int i = 0; i<text.length();i++){
			char test = text.charAt(i);
			
			if(alph.contains(""+test)){
				int index = this.getSecretAlphabet().indexOf(test);
				klar = klar+alph.charAt(index);
			}else{
				klar=klar+test;
			}
		}
		return klar;
	}
	
	public void setSecretAlphabet(String alphabet) throws IllegalArgumentException{
		String alph = this.getStandardAlphabet();

		if(alphabet==null){
			throw new IllegalArgumentException("alphabet cannot be NULL");
		}
		
		if(alphabet.length()!=30){
			throw new IllegalArgumentException("The alphabet contains too many/less characters");
		}
		
		for(int i = 0;i<this.secretAlphabet.length();i++){
				if(!alph.contains(""+alphabet.charAt(i))){
				throw new IllegalArgumentException("The character '"+alphabet.charAt(i)+"' with the index "+i+" is NOT allowed");				
			}
		}
		
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i = 0;i<this.secretAlphabet.length();i++){
			set.add(alphabet.charAt(i));
		}
		if(set.size()!=30){
			throw new IllegalArgumentException("There is at least one character ocurring at least two times, no duplicates allowed");
		}
		
		this.secretAlphabet=alphabet;
	}
	
	public String getStandardAlphabet(){
		return "abcdefghijklmnopqrstuvwxyzäöüß";
	}

}
