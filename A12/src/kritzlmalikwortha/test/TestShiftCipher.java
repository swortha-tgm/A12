package kritzlmalikwortha.test;

import static org.junit.Assert.*;
import kritzlmalikwortha.KeywordCipher;
import kritzlmalikwortha.ShiftCipher;

import org.junit.Test;
/**
 * 
 * @author Simon Wortha
 *
 */
public class TestShiftCipher {

	/**
	 * Testet den Konstruktor, ob das richtige Secretalphabet erstellt wird
	 */
	@Test
	public void test_ShiftCipher1() {
		ShiftCipher sc = new ShiftCipher(0);
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", sc.getSecretAlphabet());
	}
	/**
	 * Testet ob setShiftAmount richtig arbeitet
	 */
	@Test
	public void test_setShiftAmount1() {
		ShiftCipher sc = new ShiftCipher(0);
		sc.setShiftAmount(1);
		assertEquals("bcdefghijklmnopqrstuvwxyzäöüßa", sc.getSecretAlphabet());
	}
	/**
	 * Testet ob setShiftAmount richtig arbeitet
	 */
	@Test
	public void test_setShiftAmount2() {
		ShiftCipher sc = new ShiftCipher(0);
		sc.setShiftAmount(60);
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß", sc.getSecretAlphabet());
	}
	/**
	 * Testet ob setShiftAmount richtig arbeitet
	 */
	@Test
	public void test_setShiftAmount3() {
		ShiftCipher sc = new ShiftCipher(0);
		sc.setShiftAmount(29);
		assertEquals("ßabcdefghijklmnopqrstuvwxyzäöü", sc.getSecretAlphabet());
	}
}
