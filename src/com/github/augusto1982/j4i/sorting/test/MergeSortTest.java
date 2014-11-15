package com.github.augusto1982.j4i.sorting.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.github.augusto1982.j4i.sorting.MergeSort;


/**
 * 
 * @author Augusto Recordon
 *
 */
public class MergeSortTest {

	/* ********************************************************************* */

	private int[] numbers;
	
	/* ********************************************************************* */
	
	private final static int SIZE = 7;
	
	/* ********************************************************************* */
	
	private final static int MAX = 20;

	/* ********************************************************************* */
	
	@Before
	public void setUp() throws Exception {
		numbers = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
	}
	
	/* ********************************************************************* */

	@Test
	public void testMergeSort() {
		long startTime = System.currentTimeMillis();

		MergeSort sorter = new MergeSort();
		sorter.sort(numbers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Mergesort " + elapsedTime);

		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				fail("Should not happen");
			}
		}
		assertTrue(true);

	}
	
	/* ********************************************************************* */

	@Test
	public void worksRepeatably() {
		for (int i = 0; i < 200; i++) {
			numbers = new int[SIZE];
			Random generator = new Random();
			for (int a = 0; a < numbers.length; a++) {
				numbers[a] = generator.nextInt(MAX);
			}
			MergeSort sorter = new MergeSort();
			sorter.sort(numbers);
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					fail("Should not happen");
				}
			}
			assertTrue(true);
		}
	}
	
	/* ********************************************************************* */

} 