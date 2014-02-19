package kritzlmalikwortha.test;

import static org.junit.Assert.*;
import kritzlmalikwortha.MonoalphabeticCipher;
import kritzlmalikwortha.SubstitutionCipher;

import org.junit.Test;
/**
 * Überprüft die Klasse MonoalphabeticCipher und SubstitutionCipher
 * 
 * @author Martin Kritzl
 *
 */
public class TestMonoAlphabetic {
		
	//MonoaphabeticCipher
	
		/**
		 * Es wird ein Alphabet mit zu wenigen zeichen gesettet
		 */
		@Test (expected=IllegalArgumentException.class)
		public void alph1() {
			MonoalphabeticCipher a = new MonoalphabeticCipher();
			a.setSecretAlphabet("a");
		}
		/**
		 * Es wird ein Alphabet wobei ein Zeichen doppelt vorkommt
		 */
		@Test (expected=IllegalArgumentException.class)
		public void alph2() {
			MonoalphabeticCipher a = new MonoalphabeticCipher();
			a.setSecretAlphabet("aabcdefghijklmnopqrstuvwxyzäüö");
		}
		/**
		 * Es wird ein Alphabet gesetzt, welches am Anfang und am Ende das selbe Zeichen besitzt
		 */
		@Test (expected=IllegalArgumentException.class)
		public void alph3() {
			MonoalphabeticCipher a = new MonoalphabeticCipher();
			a.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäüößa");
		}
		/**
		 * Es wird ein korrektes Alphabet gesetzt welches gleich wieder geholt wird
		 */
		@Test
		public void alph4() {
			MonoalphabeticCipher a = new MonoalphabeticCipher();
			 a.setSecretAlphabet("acbdefghijklmnopqrstuvwxyzäüöß");
			 assertEquals("acbdefghijklmnopqrstuvwxyzäüöß",a.getSecretAlphabet());	
		 }
		 /**
		  * Ruft nur den Konstruktor auf und prüft das Standardalphaabet
		  */
		 @Test
		 public void alph5(){
			 MonoalphabeticCipher a = new MonoalphabeticCipher();
			 assertEquals("abcdefghijklmnopqrstuvwxyzäöüß",a.getSecretAlphabet());
		 }
		 /**
		  * Es wird ein Alpahbet gesetzt welches ein falsches Zeichen enthält
		  */
		 @Test (expected=IllegalArgumentException.class)
			public void alph6() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("abcdefgh%jklmnopqrstuvwxyzäüöß");
		}
		 /**
		  * Es wird ein Alphabet gesetzt welches "null" ist
		  */
		 @Test (expected=IllegalArgumentException.class)
			public void alph7() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet(null);
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach links verschoben wurde und mit encrypt ein Wort 
		  * verschlüsselt wird
		  */
		 @Test
			public void alph8() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyzäüößa");
				assertEquals(a.encrypt("Hallo"), "ibmmp");
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach links verschoben wurde und mit decrypt ein Wort 
		  * enschlüsselt wird
		  */
		 @Test
			public void alph9() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyzäüößa");
				assertEquals(a.decrypt("ibmmp"), "hallo");
		}
		/**
		 * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach rechts verschoben wurde und mit encrypt ein Wort 
		  * verschlüsselt wird 
		 */
		 @Test
			public void alph10() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("ßabcdefghijklmnopqrstuvwxyzäüö");
				assertEquals(a.encrypt("Hallo"), "gßkkn");
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach rechts verschoben wurde und mit decrypt ein Wort 
		  * enschlüsselt wird
		  */
		 @Test
			public void alph11() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("ßabcdefghijklmnopqrstuvwxyzäüö");
				assertEquals(a.decrypt("gßkkn"), "hallo");
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach links verschoben wurde und mit decrypt ein Wort, 
		  * welches auch Sonderzeichen enthält(" "), verschlüsselt wird
		  */
		 @Test
			public void alph12() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyzäüößa");
				assertEquals(a.encrypt("Hallo wie gehts"), "ibmmp xjf hfiut");
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach links verschoben wurde und mit decrypt ein Wort, 
		  * welches auch Sonderzeichen enthält(" "), entschlüsselt wird
		  */
		 @Test
			public void alph13() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("ßabcdefghijklmnopqrstuvwxyzäüö");
				assertEquals(a.encrypt("ibmmp xjf hfiut"), "hallo wie gehts");
		}
		 
		 //SubstitutionCipher
		 
		/**
		* Es wird ein korrektes Alphabet gesetzt welches gleich wieder geholt wird
		 */
		 @Test
			public void alph14() {
				SubstitutionCipher a = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
				assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", a.getSecretAlphabet());
		}
		 /**
		  * Es wird ein Alphabet null gesetzt
		  */
		 @Test(expected=IllegalArgumentException.class)
			public void alph15() {
				new SubstitutionCipher(null);
		}
		 /**
		 * Es wird ein Alphabet wobei ein Zeichen doppelt vorkommt
		 */
		 @Test(expected=IllegalArgumentException.class)
			public void alph16() {
			 	new SubstitutionCipher("aabcdefghijklmnopqrstuvwxyzäüö");
		}
		 
}
