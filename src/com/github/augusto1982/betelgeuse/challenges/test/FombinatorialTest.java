package com.github.augusto1982.betelgeuse.challenges.test;

import org.junit.Test;

import com.github.augusto1982.betelgeuse.challenges.Fombinatorial;
import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class FombinatorialTest {
	
	@Test
	public void test(){
		Fombinatorial fombinatorial = new Fombinatorial();
		assertEquals(fombinatorial.fombinatorial("5 24 2"), 8);
	}

}
