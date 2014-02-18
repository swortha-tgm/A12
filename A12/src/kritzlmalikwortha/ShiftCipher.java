package kritzlmalikwortha;

/**
 * @author Martin Kritzl
 * Funktion: Die Klasse ist zur Verschlüsselung nach einem Verschiebewert zuständig. Hierbei wird das Alphabet um den gegebenen
 * 			 Wert nach links verschoben(z.B Verschiebung 1 --> Anfang mit b)
 *
 */

public class ShiftCipher extends MonoalphabeticCipher {
	
	private int shiftAmount;
	
	/**
	 * @param int value
	 * 
	 * Eingangsparameter: ein int Wert der schon in von der Aufrufermethode überprüft werden muss
	 * Berechnet wird das verschobene Alphabet und dann diesen String mit der Methode setSecretAlphabet gespeichert
	 */
	public ShiftCipher(int value) {
		this.setShiftAmount(value);
		char[] alphabetChar = this.getSecretAlphabet().toCharArray();
		char[] alphabetShift = new char[30];
		for(int i=0; i < 30;i++) {
			alphabetShift[(i+30-this.shiftAmount)%30] = alphabetChar[i];
		}
		this.setSecretAlphabet(String.valueOf(alphabetShift));
		//Wird nach dem Testen wieder gelöscht
		System.out.println(String.valueOf(alphabetShift));
	}
	/**
	 * @param int shiftamount
	 * 
	 * Eingangsparameter: ein int Wert der schon in von der Aufrufermethode überprüft werden muss
	 * Es wird der shiftAmount gesetzt, aber schon mittels %30 vereinfacht
	 */
	public void setShiftAmount(int shiftamount) {
		this.shiftAmount = shiftamount%30;
	}
	/**
	 * @param String [] args
	 * Diese Methode wird nach dem Testen wieder gelöscht
	 */
	
	public static void main(String[] args) {
		new ShiftCipher(2);
	}
}
