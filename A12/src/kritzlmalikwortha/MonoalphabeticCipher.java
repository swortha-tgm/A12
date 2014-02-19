package kritzlmalikwortha;

import java.util.HashSet;
/**
 * �berpr�ft die eingegebenen Alphabete, ist f�r das ver-und entschl�sseln zust�ndig
 * 
 * @author Patrik Malik(Programmieren), Martin Kritzl(Dukumentieren)
 *
 */
public class MonoalphabeticCipher implements Cipher{

	private String secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
/**
 * Legt den Standardwert des Alphabets fest
 */
	public MonoalphabeticCipher() {
		
		this.secretAlphabet=secretAlphabet;
		
	}
/**
 * Gibt das Alphabet zur�ck
 * @return secretAlphabet
 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}


	/**Ist f�r das verschl�sseln eines Textes mit dem SecretAlphabet zust�ndig
	 * 
	 * @param text des zu verschl�sselnde Text
	 */
	public String encrypt(String text) {
		String alph = this.getStandardAlphabet();
		text=text.toLowerCase();
		String unklar = ""; //Verschl�sselt
		
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


	/**Ist f�r das entschl�sseln eines Textes mit dem SecretAlphabet zust�ndig
	 * 
	 * @param text des zu verschl�sselnde Text
	 */
	public String decrypt(String text) {
		String alph = this.getStandardAlphabet();
		text=text.toLowerCase();
		String klar = ""; //Entschl�sselt
		
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
	/**Pr�ft das eingegebene Alphabet und setzt es wenn keine Exceptions auftreten
	 * 
	 * @param alphabet
	 * @throws IllegalArgumentException
	 */
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
	/**Gibt das StandardAlphabet zur�ck
	 * 
	 * @return String - StandardAlphabet
	 */
	public String getStandardAlphabet(){
		return "abcdefghijklmnopqrstuvwxyz����";
	}

}
