package kritzlmalikwortha;

/**
 * Die Klasse ist zur Verschlüsselung nach einem Verschiebewert zuständig. Hierbei wird das Alphabet um den gegebenen
 * 			 Wert nach links verschoben(z.B Verschiebung 1 --> Anfang mit b)
 * 
 * 
 * @author Martin Kritzl
 * 
 */

public class ShiftCipher extends MonoalphabeticCipher {
	
	private int shiftAmount;
	
	/**Speichert die Eingabe in das Attribut shiftAmount ab
	 * 
	 * @param value ein int-Wert der eine beliebige Zahl sein kann
	 */
	public ShiftCipher(int value) {
		this.shiftAmount = value%30;
				
	}
	/**
	 * Es wird der shiftAmount gesetzt, aber schon mittels %30 gleich vereinfacht wird und dann das Alphabet um
	 * diesen Wert verschiebt
	 * 
	 * @param shiftamount ein int-Wert der eine beliebige Zahl sein kann
	 */
	public void setShiftAmount(int shiftamount) {
		this.shiftAmount = shiftamount%30;
		char[] alphabetChar = this.getStandardAlphabet().toCharArray();
		char[] alphabetShift = new char[30];
		for(int i=0; i < 30;i++) {
			alphabetShift[(i+30-this.shiftAmount)%30] = alphabetChar[i];
		}
		this.setSecretAlphabet(String.valueOf(alphabetShift));
	}
}
