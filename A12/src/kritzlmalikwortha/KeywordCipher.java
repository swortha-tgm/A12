package kritzlmalikwortha;

import java.util.LinkedHashSet;

/**
 * @author Martin Kritzl
 * Funktion: Die Klasse ist zur Verschl�sselung nach einem Keyword zust�ndig. Hierbei wird ein Keyword am Anfang geschrieben
 * 			 und die nicht vorkommenden Buchstaben aus dem Alphabet werden hinten angeh�ngt
 *
 */

public class KeywordCipher extends MonoalphabeticCipher {
	
	private String keyword;
	
	/** 
	 * @param String keyword
	 * 
	 * Eingangsparameter: ein String der nur Character aus dem Alphabet beinhalten darf, ansonsten wird eine IllegalArgumentException 
	 * 					  geworfen
	 * Das Keyword wird am Anfang geschrieben und die nicht in diesem Wort vorkommenden Character werden in alphabetischer Reihenfolge
	 * hinten angeh�ngt und dann diesen String mit der Methode setSecretAlphabet gespeichert
	 * 
	 */
	public KeywordCipher(String keyword) {
		char[] keyChar = keyword.toCharArray();
		LinkedHashSet<Character> alphabetCharSet = new LinkedHashSet<Character>(); 
		char[] alphabetChar = this.getSecretAlphabet().toCharArray();
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
		//Wird nach dem Testen wieder gel�scht
		System.out.println(ausgabe);
		this.setSecretAlphabet(ausgabe);
	}
	/**
	 * @param String keyword
	 * 
	 * Speichert den �bergebenen String in das Attribut ab
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	/**
	 * @param String [] args
	 * Diese Methode wird nach dem Testen wieder gel�scht
	 */
	
	public static void main(String[] args) {
		new KeywordCipher("bd");
	}

}
