package com.github.augusto1982.betelgeuse.challenges.test;

import org.junit.Test;

import com.github.augusto1982.betelgeuse.challenges.LongestPalindromeFinder;

import static org.junit.Assert.assertEquals;
/**
 * 
 * @author Augusto Recordon
 *
 */
public class LongestPalindromeFinderTest {

	/* ********************************************************************* */
	
	@Test
	public void test(){
		LongestPalindromeFinder lpf = new LongestPalindromeFinder();
		assertEquals(lpf.longestPalindromeFor(null), null);
		assertEquals(lpf.longestPalindromeFor(""), null);
		assertEquals(lpf.longestPalindromeFor("AA"), "AA");
		assertEquals(lpf.longestPalindromeFor("AAC"), "AA");
		assertEquals(lpf.longestPalindromeFor("CAA"), "AA");
		assertEquals(lpf.longestPalindromeFor("CAAC"), "CAAC");
		assertEquals(lpf.longestPalindromeFor("CABAC"), "CABAC");
		assertEquals(lpf.longestPalindromeFor("CACAC"), "CACAC");
		assertEquals(lpf.longestPalindromeFor("DBXACA"), "ACA");
		assertEquals(lpf.longestPalindromeFor("CAXACA"), "CAXAC");
		assertEquals(lpf.longestPalindromeFor("CDXRCA"), "C");
	}
	
	/* ********************************************************************* */
	
}
