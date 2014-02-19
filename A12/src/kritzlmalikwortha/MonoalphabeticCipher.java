package kritzlmalikwortha;

import java.util.HashSet;
/**
 * Überprüft die eingegebenen Alphabete, ist für das ver-und entschlüsseln zuständig
 * 
 * @author Patrik Malik(Programmieren), Martin Kritzl(Dukumentieren)
 *
 */
public class MonoalphabeticCipher implements Cipher{

	private String secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
/**
 * Legt den Standardwert des Alphabets fest
 */
	public MonoalphabeticCipher() {
		
		this.secretAlphabet=secretAlphabet;
		
	}
/**
 * Gibt das Alphabet zurück
 * @return secretAlphabet
 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}


	/**Ist für das verschlüsseln eines Textes mit dem SecretAlphabet zuständig
	 * 
	 * @param text des zu verschlüsselnde Text
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


	/**Ist für das entschlüsseln eines Textes mit dem SecretAlphabet zuständig
	 * 
	 * @param text des zu verschlüsselnde Text
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
	/**Prüft das eingegebene Alphabet und setzt es wenn keine Exceptions auftreten
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
	/**Gibt das StandardAlphabet zurück
	 * 
	 * @return String - StandardAlphabet
	 */
	public String getStandardAlphabet(){
		return "abcdefghijklmnopqrstuvwxyzäöüß";
	}

}
