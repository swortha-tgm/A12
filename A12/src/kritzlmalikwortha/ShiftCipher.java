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
	 * @param value
	 * 
	 * Eingangsparameter: ein int-Wert der eine beliebige Zahl sein kann
	 * Speichern des Eingangsparameter in das Attribut
	 */
	public ShiftCipher(int value) {
		this.shiftAmount = value%30;
				
	}
	/**
	 * @param shiftamount
	 * 
	 * Eingangsparameter: ein int-Wert der eine beliebige Zahl sein kann
	 * Es wird der shiftAmount gesetzt, aber schon mittels %30 gleich vereinfacht wird und dann das Alphabet um
	 * diesen Wert verschiebt
	 */
	public void setShiftAmount(int shiftamount) {
		this.shiftAmount = shiftamount%30;
		char[] alphabetChar = this.getSecretAlphabet().toCharArray();
		char[] alphabetShift = new char[30];
		for(int i=0; i < 30;i++) {
			alphabetShift[(i+30-this.shiftAmount)%30] = alphabetChar[i];
		}
		this.setSecretAlphabet(String.valueOf(alphabetShift));
		//Wird nach dem Testen wieder gelöscht
		System.out.println("Krittzl: " + String.valueOf(alphabetShift));
	}
	/**
	 * @param args
	 * Diese Methode wird nach dem Testen wieder gelöscht
	 */
	
	public static void main(String[] args) {
		new ShiftCipher(2);
	}
}
