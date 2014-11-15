package com.github.augusto1982.betelgeuse.sorting;

import com.github.augusto1982.betelgeuse.datastructures.heap.MinHeap;

public class HeapSort {
	
	
	private MinHeap<Integer> loadHeap(int[] numbers){
		MinHeap<Integer> heap = new MinHeap<Integer>();
		for(int i = 0; i < numbers.length; i++){
			heap.add(numbers[i]);
		}
		return heap;
	}
	public void sort(int[] numbers){
		MinHeap<Integer> heap = this.loadHeap(numbers);
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = heap.top();
		}
	}

}
