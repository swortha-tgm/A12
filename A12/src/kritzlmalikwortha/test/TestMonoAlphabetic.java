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
				a.setSecretAlphabet("aabcdefghijklmnopqrstuvwxyz���");
			}
			
			@Test (expected=IllegalArgumentException.class)
			public void alph3() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("abcdefghijklmnopqrstuvwxyz����a");
			}
		
			@Test
			public void alph4() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				 a.setSecretAlphabet("acbdefghijklmnopqrstuvwxyz����");
				 assertEquals("acbdefghijklmnopqrstuvwxyz����",a.getSecretAlphabet());	
			 }
			 
			 @Test
			 public void alph5(){
				 MonoalphabeticCipher a = new MonoalphabeticCipher();
				 assertEquals("abcdefghijklmnopqrstuvwxyz����",a.getSecretAlphabet());
			 }
			 
			 @Test (expected=IllegalArgumentException.class)
			 public void alph6() {
				 MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet("aabcdefghijklmnopqrstuvwxyz���");
				}
			 @Test (expected=IllegalArgumentException.class)
				public void alph7() {
					MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet("abcdefgh%jklmnopqrstuvwxyz����");
			}
			 
			 @Test (expected=IllegalArgumentException.class)
				public void alph8() {
					MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet(null);
			}
			 
			 @Test
				public void alph9() {
					MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyz����a");
					assertEquals(a.encrypt("Hallo"), "ibmmp");
			}
			 
			 @Test
				public void alph10() {
					MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyz����a");
					assertEquals(a.decrypt("ibmmp"), "hallo");
			}
			 
			 @Test
				public void alph11() {
					MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet("�abcdefghijklmnopqrstuvwxyz���");
					assertEquals(a.encrypt("Hallo"), "g�kkn");
			}
			 
			 
			 @Test
				public void alph12() {
					MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet("�abcdefghijklmnopqrstuvwxyz���");
					assertEquals(a.decrypt("g�kkn"), "hallo");
			}
			 @Test
				public void alph13() {
					MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyz����a");
					assertEquals(a.encrypt("Hallo wie gehts"), "ibmmp xjf hfiut");
			}
			 
			 @Test
				public void alph14() {
					MonoalphabeticCipher a = new MonoalphabeticCipher();
					a.setSecretAlphabet("�abcdefghijklmnopqrstuvwxyz���");
					assertEquals(a.encrypt("ibmmp xjf hfiut"), "hallo wie gehts");
			}
}
