package kritzlmalikwortha.test;

import static org.junit.Assert.*;
import kritzlmalikwortha.KeywordCipher;

import org.junit.Test;

/**
 * Die Testklasse für den keywordCipher
 * @author Simon Wortha
 *
 */
public class TestKeywordCipher {

	/**
	 * Testet den Konstruktor, ob das richtige Secretalphabet erstellt wird
	 */
	@Test
	public void test_KeywordCipher1() {
		KeywordCipher kc = new KeywordCipher("b");
		assertEquals("bacdefghijklmnopqrstuvwxyzäöüß", kc.getSecretAlphabet());
	}
	/**
	 * Testet den Konstruktor, ob das richtige Secretalphabet erstellt wird
	 */
	@Test
	public void test_KeywordCipher2() {
		KeywordCipher kc = new KeywordCipher("tt");
		assertEquals("tabcdefghijklmnopqrsuvwxyzäöüß", kc.getSecretAlphabet());
	}
	/**
	 * Testet den Konstruktor, ob das richtige Secretalphabet erstellt wird
	 */
	@Test
	public void test_KeywordCipher3() {
		KeywordCipher kc = new KeywordCipher("");
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", kc.getSecretAlphabet());
	}
	/**
	 * Testet ob die Methode setKeyword richtig arbeitet
	 */
	@Test
	public void test_setKeyword1() {
		KeywordCipher kc = new KeywordCipher("Default");
		kc.setKeyword("z");
		assertEquals("zabcdefghijklmnopqrstuvwxyäöüß", kc.getSecretAlphabet());
	}
	/**
	 * Testet ob die Methode setKeyword richtig arbeitet
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_setKeyword2() {
		KeywordCipher kc = new KeywordCipher("Default");
		kc.setKeyword("!");
	}
	/**
	 * Testet ob die Methode setKeyword richtig arbeitet
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_setKeyword3() {
		KeywordCipher kc = new KeywordCipher("Default");
		kc.setKeyword("hiazwhdzbasiocunzeczesunczcznscscdcscäöäöäöäödfdsfwefescsdcscc");
	}
	/**
	 * Testet ob die Methode setKeyword richtig arbeitet
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_setKeyword4() {
		KeywordCipher kc = new KeywordCipher("Default");
		kc.setKeyword("7");
	}
}
