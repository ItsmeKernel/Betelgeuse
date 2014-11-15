package com.github.augusto1982.j4i.datastructures.heap;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinHeapTest {
	
	@Test
	public void testHeap(){
		
		MinHeap<Integer> heap = new MinHeap<Integer>();
		for(int i = 30; i >= 1; i--){
			heap.add(i);
		}
		
		for(int i = 1; i <= 30; i++){
			assertEquals((Integer)heap.top(), (Integer)i);
		}
	}

}
