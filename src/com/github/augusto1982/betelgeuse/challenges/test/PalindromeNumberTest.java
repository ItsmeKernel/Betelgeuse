package com.github.augusto1982.betelgeuse.challenges.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.github.augusto1982.betelgeuse.challenges.PalindromeNumber;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class PalindromeNumberTest {
	
	/* ********************************************************************* */
	
	private PalindromeNumber pn;
	
	/* ********************************************************************* */
	
	@Before
	public void before(){
		this.pn = new PalindromeNumber();
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testOne(){
		assertTrue(this.pn.isPalindrome(5445));
		assertTrue(this.pn.isPalindrome(54345));
		assertTrue(this.pn.isPalindrome(8));
		assertTrue(this.pn.isPalindrome(0));
		assertFalse(this.pn.isPalindrome(1122));
		assertFalse(this.pn.isPalindrome(11822));
		assertFalse(this.pn.isPalindrome(-1));
		assertTrue(this.pn.isPalindrome(212));
	}

	/* ********************************************************************* */
}
