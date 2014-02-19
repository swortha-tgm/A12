package kritzlmalikwortha;

public class SubstitutionCipher extends MonoalphabeticCipher{

	public SubstitutionCipher(String secretalphabet) {
		this.setSecretAlphabet(secretalphabet);
	}

	public void setSecretAlphabet(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}

}
