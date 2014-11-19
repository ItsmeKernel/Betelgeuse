package com.github.augusto1982.betelgeuse.challenges.test;

import org.junit.Before;
import org.junit.Test;

import com.github.augusto1982.betelgeuse.challenges.PayingUp;

import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class PayingUpTest {
	
	/* ********************************************************************* */
	
	private PayingUp pu;
	
	/* ********************************************************************* */
	
	@Before
	public void before(){
		this.pu = new PayingUp();
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testOne(){
		String[] input = {
				"3 3",
				"1",
				"1",
				"1"
		};
		assertEquals(pu.payUp(input), "Yes");
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testTwo(){
		String[] input = {
				"5 11",
				"1",
				"2",
				"4",
				"8",
				"16"
		};
		assertEquals(pu.payUp(input), "Yes");
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testThree(){
		String[] input = {
				"5 23",
				"1",
				"2",
				"4",
				"8",
				"16"
		};
		assertEquals(pu.payUp(input), "Yes");
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testFour(){
		String[] input = {
				"5 13",
				"1",
				"5",
				"5",
				"10",
				"10"
		};
		assertEquals(pu.payUp(input), "No");
	}
	
	/* ********************************************************************* */

	@Test
	public void testFive(){
		String[] input = {
				"20 132",
				"17",
				"6",
				"4",
				"998",
				"254",
				"137",
				"259",
				"153",
				"154",
				"3",
				"28",
				"19",
				"123",
				"542",
				"857",
				"23",
				"687",
				"35",
				"99",
				"999",
		};
		assertEquals(pu.payUp(input), "Yes");
	}
	
	/* ********************************************************************* */
}
