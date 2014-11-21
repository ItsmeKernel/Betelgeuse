package com.github.augusto1982.betelgeuse.challenges.test;

import org.junit.Test;

import com.github.augusto1982.betelgeuse.challenges.DistanceMaximizingProblem;

import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class DistanceMaximizingProblemTets {
	
	/* ********************************************************************* */
	
	@Test
	public void test(){
		DistanceMaximizingProblem dmp = new DistanceMaximizingProblem();
		assertEquals(dmp.dmp(new int[]{4,3,5,2,1,3,2,3}), 5);
		assertEquals(dmp.dmp(new int[]{4,3,2,2,1,3,2,3}), 7);
		assertEquals(dmp.dmp(new int[]{1,3,1,4}), 2);
		assertEquals(dmp.dmp(new int[]{1,2,3,4}), 1);
		assertEquals(dmp.dmp(new int[]{4,3,2,1}), 3);
		assertEquals(dmp.dmp(new int[]{1}), 1);
	}

	/* ********************************************************************* */
}
