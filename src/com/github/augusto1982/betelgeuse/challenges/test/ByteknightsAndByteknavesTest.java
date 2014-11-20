package com.github.augusto1982.betelgeuse.challenges.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.github.augusto1982.betelgeuse.challenges.ByteknightsAndByteknaves;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class ByteknightsAndByteknavesTest {
	
	/* ********************************************************************* */
	
	private ByteknightsAndByteknaves bb;
	
	/* ********************************************************************* */
	
	@Before
	public void before(){
		this.bb = new ByteknightsAndByteknaves();
	}

	/* ********************************************************************* */
	
	@Test
	public void testOne(){
		bb.offer(1,1);
		bb.offer(2,2);
		bb.offer(1,1);
		bb.offer(0,0);
		int[] result = bb.min();
		assertEquals(result[0], 2);
		assertEquals(result[1], 2);
	}

	/* ********************************************************************* */
	
	@Test
	public void testTwo(){
		bb.offer(0,1);
		int[] result = bb.min();
		assertEquals(result[0], 1);
		assertEquals(result[1], 1);
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testThree(){
		bb.offer(1, 4);
		bb.offer(2, 4);	
		bb.offer(3, 4);
		bb.offer(4, 4);
		int[] result = bb.min();
		assertEquals(result[0], 5);
		assertEquals(result[1], 0);
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testFour(){
		bb.offer(1, 2);
		bb.offer(0, 0);	
		bb.offer(1, 3);
		int[] result = bb.min();
		assertEquals(result[0], 1);
		assertEquals(result[1], 5);
	}
	
	/* ********************************************************************* */
}
