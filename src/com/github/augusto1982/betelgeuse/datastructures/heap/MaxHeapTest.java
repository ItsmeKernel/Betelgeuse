package com.github.augusto1982.betelgeuse.datastructures.heap;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class MaxHeapTest {
	
	@Test
	public void testHeap(){
		
		MaxHeap<Integer> heap = new MaxHeap<Integer>();
		for(int i = 1; i <= 30; i++){
			heap.add(i);
		}
		
		for(int i = 30; i >= 1; i--){
			assertEquals((Integer)heap.top(), (Integer)i);
		}
	}

}
