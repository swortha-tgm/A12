package kritzlmalikwortha;

import java.util.LinkedHashSet;

/**
 * Die Klasse ist zur Verschl�sselung nach einem Keyword zust�ndig. Hierbei wird ein Keyword am Anfang geschrieben
 * und die nicht vorkommenden Buchstaben aus dem Alphabet werden hinten angeh�ngt
 *
 * 
 * @author Martin Kritzl
 * 
 */

public class KeywordCipher extends MonoalphabeticCipher {
	
	private String keyword;
	
	/** 
	 * @param keyword - ein Default Key der schon in der Aufrufermethode auf Richtigkeit gepr�ft wird
	 * Speichern des Eingangsparameter in das Attribut
	 * 
	 */
	public KeywordCipher(String keyword) {
		this.setKeyword(keyword);
	}

	/**
	 * 
	 * Das Keyword wird am Anfang geschrieben und die nicht in diesem Wort vorkommenden Character werden in alphabetischer Reihenfolge
	 * hinten angeh�ngt und dann diesen String mit der Methode setSecretAlphabet gespeichert
	 * 
	 * @param keyword
	 * 
	 * @throws IllegalArgumentException - wenn das Keyword Zeichen enth�lt die nicht im Alphabet vorhanden sind oder l�nger ist als
	 * 30 Zeichen
	 * 
	 */
	public void setKeyword(String keyword) {
		keyword = keyword.toLowerCase();
		for(int i = 0;i<keyword.length();i++){
			
			if(!this.getSecretAlphabet().contains(""+keyword.charAt(i))){
				throw new IllegalArgumentException("The character '"+keyword.charAt(i)+"' with the index "+i+" is NOT allowed");				
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
