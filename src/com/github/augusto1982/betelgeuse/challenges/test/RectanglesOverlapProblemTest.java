package com.github.augusto1982.betelgeuse.challenges.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.github.augusto1982.betelgeuse.challenges.RectanglesOverlapProblem;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class RectanglesOverlapProblemTest {
	
	/* ********************************************************************* */
	
	RectanglesOverlapProblem rop; 
	
	/* ********************************************************************* */
	
	@Before
	public void before(){
		this.rop = new RectanglesOverlapProblem();
		
	}

	/* ********************************************************************* */
	
	@Test
	public void testOne(){
		assertTrue(this.rop.overlap(
				rop.createPoint(1, 1), 
				rop.createPoint(4, 4), 
				
				rop.createPoint(2, 2), 
				rop.createPoint(5, 5)
			));
		
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testTwo(){
		assertFalse(this.rop.overlap(
				rop.createPoint(1, 1), 
				rop.createPoint(4, 4), 
				
				rop.createPoint(2, 6), 
				rop.createPoint(5, 5)
			));
		
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testThree(){
		assertTrue(this.rop.overlap(
				rop.createPoint(1, 1), 
				rop.createPoint(4, 4), 
				
				rop.createPoint(1, 2), 
				rop.createPoint(5, 5)
			));
		
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testFour(){
		assertTrue(this.rop.overlap(
				rop.createPoint(1, 1), 
				rop.createPoint(4, 4), 
				
				rop.createPoint(1, 1), 
				rop.createPoint(5, 5)
			));
		
	}
	
	/* ********************************************************************* */
	
	@Test
	public void testFive(){
		assertTrue(this.rop.overlap(
				rop.createPoint(1, 1), 
				rop.createPoint(1, 1), 
				
				rop.createPoint(1, 1), 
				rop.createPoint(1, 1)
			));
		
	}
	
	/* ********************************************************************* */
}
