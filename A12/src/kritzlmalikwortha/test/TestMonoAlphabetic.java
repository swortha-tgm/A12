package kritzlmalikwortha.test;

import static org.junit.Assert.*;
import kritzlmalikwortha.MonoalphabeticCipher;

import org.junit.Test;

public class TestMonoAlphabetic {
	
	@Test (expected=IllegalArgumentException.class)
	public void alph1() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("a");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void alph2() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("aabcdefghijklmnopqrstuvwxyzäüö");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void alph3() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäüößa");
	}

	 @Test
	 public void alph4() {
		 MonoalphabeticCipher a = new MonoalphabeticCipher();
		 a.setSecretAlphabet("acbdefghijklmnopqrstuvwxyzäüöß");
		 assertEquals("acbdefghijklmnopqrstuvwxyzäüöß",a.getSecretAlphabet());
	 }
	 
	 @Test
	 public void alph5(){
		 MonoalphabeticCipher a = new MonoalphabeticCipher();
		 assertEquals("abcdefghijklmnopqrstuvwxyzäöüß",a.getSecretAlphabet());
	 }
}
