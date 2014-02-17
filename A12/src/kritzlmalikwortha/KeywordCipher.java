package kritzlmalikwortha;

import java.util.LinkedHashSet;

public class KeywordCipher extends MonoalphabeticCipher {
	
	private String keyword;
	
	//Wird nach dem Testen gelöscht
	private String alphabet = "abcdefghijklmnopqrstuvwxyzßöäü";
	
	/** 
	 * @param String keyword
	 * 
	 * Eingangsparameter: ein String der nur Character aus dem Alphabet beinhalten darf, ansonsten wird eine IllegalArgumentException 
	 * 					  geworfen
	 * Das Keyword wird am Anfang geschrieben und die nicht in diesem Wort vorkommenden Character werden in alphabetischer Reihenfolge
	 * hinten angehängt und dann diesen String mit der Methode setSecretAlphabet gespeichert
	 * 
	 */
	public KeywordCipher(String keyword) {
		char[] keyChar = keyword.toCharArray();
		LinkedHashSet<Character> alphabetCharSet = new LinkedHashSet<Character>(); 
		//Wird nach dem Testen mit dem unteren Ausdruck ausgetauscht
		//char[] alphabetChar = this.getSecretAlphabet().toCharArray();
		char[] alphabetChar = this.alphabet.toCharArray();
		for (Character c : keyChar) {
			alphabetCharSet.add(c);
		}
		for (Character c : alphabetChar) {
			alphabetCharSet.add(c);
		}
		//Wird nach dem Testen gelöscht
		for (Character c: alphabetCharSet) {
			System.out.print(c);
		}
	}
	/**
	 * @param String keyword
	 * 
	 * Speichert den übergebenen String in das Attribut ab
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	/**
	 * @param String [] args
	 * Diese Methode wird nach dem Testen wieder gelöscht
	 */
	
	public static void main(String[] args) {
		new KeywordCipher("bd");
	}

}
