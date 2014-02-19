package kritzlmalikwortha;

import java.util.LinkedHashSet;

/**
 * @author Martin Kritzl
 * Funktion: Die Klasse ist zur Verschlüsselung nach einem Keyword zuständig. Hierbei wird ein Keyword am Anfang geschrieben
 * 			 und die nicht vorkommenden Buchstaben aus dem Alphabet werden hinten angehängt
 *
 */

public class KeywordCipher extends MonoalphabeticCipher {
	
	private String keyword;
	
	/** 
	 * @param keyword
	 * 
	 * Eingangsparameter: ein Default Key der schon in der Aufrufermethode auf Richtigkeit geprüft wird
	 * Speichern des Eingangsparameter in das Attribut
	 * 
	 */
	public KeywordCipher(String keyword) {
		this.setKeyword(keyword);
	}

	/**
	 * @param keyword
	 * 
	 * Eingangsparameter: ein String der nur Character aus dem Alphabet beinhalten darf und nicht länger oder kürzer als 30 Zeichen
	 *					  sein darf, ansonsten eine IllegalArgumentException geworfen
	 * Das Keyword wird am Anfang geschrieben und die nicht in diesem Wort vorkommenden Character werden in alphabetischer Reihenfolge
	 * hinten angehängt und dann diesen String mit der Methode setSecretAlphabet gespeichert
	 * 
	 */
	public void setKeyword(String keyword) {
		keyword = keyword.toLowerCase();
		for(int i = 0;i<keyword.length();i++){
			
			if(!this.getSecretAlphabet().contains(""+keyword.charAt(i))){
				throw new IllegalArgumentException("The character '"+this.keyword.charAt(i)+"' with the index "+i+" is NOT allowed");				
			}
		}
		if (keyword.length() > 30) throw new IllegalArgumentException("The Keyword contains to many characters");
		this.keyword = keyword;
		
		char[] keyChar = this.keyword.toCharArray();
		LinkedHashSet<Character> alphabetCharSet = new LinkedHashSet<Character>(); 
		char[] alphabetChar = this.getStandardAlphabet().toCharArray();
		for (Character c : keyChar) {
			alphabetCharSet.add(c);
		}
		for (Character c : alphabetChar) {
			alphabetCharSet.add(c);
		}
		String ausgabe = "";
		
		for (Character c: alphabetCharSet) {
			ausgabe += c;
		}
		this.setSecretAlphabet(ausgabe);
	}
}
