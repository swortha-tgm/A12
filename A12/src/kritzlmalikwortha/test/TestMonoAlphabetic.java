package kritzlmalikwortha.test;

import static org.junit.Assert.*;
import kritzlmalikwortha.MonoalphabeticCipher;
import kritzlmalikwortha.SubstitutionCipher;

import org.junit.Test;
/**
 * �berpr�ft die Klasse MonoalphabeticCipher und SubstitutionCipher
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
			a.setSecretAlphabet("aabcdefghijklmnopqrstuvwxyz���");
		}
		/**
		 * Es wird ein Alphabet gesetzt, welches am Anfang und am Ende das selbe Zeichen besitzt
		 */
		@Test (expected=IllegalArgumentException.class)
		public void alph3() {
			MonoalphabeticCipher a = new MonoalphabeticCipher();
			a.setSecretAlphabet("abcdefghijklmnopqrstuvwxyz����a");
		}
		/**
		 * Es wird ein korrektes Alphabet gesetzt welches gleich wieder geholt wird
		 */
		@Test
		public void alph4() {
			MonoalphabeticCipher a = new MonoalphabeticCipher();
			 a.setSecretAlphabet("acbdefghijklmnopqrstuvwxyz����");
			 assertEquals("acbdefghijklmnopqrstuvwxyz����",a.getSecretAlphabet());	
		 }
		 /**
		  * Ruft nur den Konstruktor auf und pr�ft das Standardalphaabet
		  */
		 @Test
		 public void alph5(){
			 MonoalphabeticCipher a = new MonoalphabeticCipher();
			 assertEquals("abcdefghijklmnopqrstuvwxyz����",a.getSecretAlphabet());
		 }
		 /**
		  * Es wird ein Alpahbet gesetzt welches ein falsches Zeichen enth�lt
		  */
		 @Test (expected=IllegalArgumentException.class)
			public void alph6() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("abcdefgh%jklmnopqrstuvwxyz����");
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
		  * verschl�sselt wird
		  */
		 @Test
			public void alph8() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyz����a");
				assertEquals(a.encrypt("Hallo"), "ibmmp");
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach links verschoben wurde und mit decrypt ein Wort 
		  * enschl�sselt wird
		  */
		 @Test
			public void alph9() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyz����a");
				assertEquals(a.decrypt("ibmmp"), "hallo");
		}
		/**
		 * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach rechts verschoben wurde und mit encrypt ein Wort 
		  * verschl�sselt wird 
		 */
		 @Test
			public void alph10() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("�abcdefghijklmnopqrstuvwxyz���");
				assertEquals(a.encrypt("Hallo"), "g�kkn");
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach rechts verschoben wurde und mit decrypt ein Wort 
		  * enschl�sselt wird
		  */
		 @Test
			public void alph11() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("�abcdefghijklmnopqrstuvwxyz���");
				assertEquals(a.decrypt("g�kkn"), "hallo");
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach links verschoben wurde und mit decrypt ein Wort, 
		  * welches auch Sonderzeichen enth�lt(" "), verschl�sselt wird
		  */
		 @Test
			public void alph12() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyz����a");
				assertEquals(a.encrypt("Hallo wie gehts"), "ibmmp xjf hfiut");
		}
		 /**
		  * Es wird ein Alphabet gesetzt, welches um ein Zeichen nach links verschoben wurde und mit decrypt ein Wort, 
		  * welches auch Sonderzeichen enth�lt(" "), entschl�sselt wird
		  */
		 @Test
			public void alph13() {
				MonoalphabeticCipher a = new MonoalphabeticCipher();
				a.setSecretAlphabet("�abcdefghijklmnopqrstuvwxyz���");
				assertEquals(a.encrypt("ibmmp xjf hfiut"), "hallo wie gehts");
		}
		 
		 //SubstitutionCipher
		 
		/**
		* Es wird ein korrektes Alphabet gesetzt welches gleich wieder geholt wird
		 */
		 @Test
			public void alph14() {
				SubstitutionCipher a = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
				assertEquals("abcdefghijklmnopqrstuvwxyz����", a.getSecretAlphabet());
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
			 	new SubstitutionCipher("aabcdefghijklmnopqrstuvwxyz���");
		}
		 
}
