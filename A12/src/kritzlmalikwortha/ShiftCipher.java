package kritzlmalikwortha;

public class ShiftCipher extends MonoalphabeticCipher {
	
	private int shiftAmount;
	//Zum testen wird ein Alphabet erstellt
	private String alphabet = "abcdefghijklmnopqrstuvwxyzßöäü";
	
	/**
	 * @param int value
	 * 
	 * Eingangsparameter: ein int Wert der schon in von der Aufrufermethode überprüft werden muss
	 * Berechnet wird das verschobene Alphabet und dann in Monoaphabetic mittels setSecretAlphabet gesettet
	 */
	public ShiftCipher(int value) {
		this.setShiftAmount(value);
		//char[] alphabetChar = this.getSecretAlphabet().toCharArray();
		char[] alphabetChar = this.alphabet.toCharArray();
		char[] alphabetShift = new char[30];
		for(int i=0; i < 30;i++) {
			alphabetShift[(i+30-this.shiftAmount)%30] = alphabetChar[i];
		}
		//this.setSecretAlphabetString.valueOf(alphabetShift));
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
		new ShiftCipher(1);
	}
}
