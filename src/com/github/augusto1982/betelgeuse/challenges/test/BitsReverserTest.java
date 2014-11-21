package com.github.augusto1982.betelgeuse.challenges.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.github.augusto1982.betelgeuse.challenges.BitsReverser;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class BitsReverserTest {
	
	/* ********************************************************************* */
	
	@Test
	public void test(){
		BitsReverser br = new BitsReverser();
		assertEquals(br.invert(1), 0);
		assertEquals(br.invert(2), 1);
		assertEquals(br.invert(10), 5);
		assertEquals(br.invert(15), 0);
		assertEquals(br.invert(16), 15);
		assertEquals(br.invert(127), 0);
		assertEquals(br.invert(1024), 1023);
		
	}
	
	/* ********************************************************************* */

}
