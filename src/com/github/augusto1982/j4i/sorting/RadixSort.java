package com.github.augusto1982.j4i.sorting;

import java.util.LinkedList;
import java.util.List;


/**
 * 
 * @author Augusto Recordon
 *
 */
public class RadixSort {
	
	/* ********************************************************************* */
	
	private List[] createEmptyBuckets(){
		List[] buckets = new List[10];
		for(int i = 0; i <= 9; i++){
			buckets[i] = new LinkedList<Integer>();
		}
		return buckets;
	}
	
	/* ********************************************************************* */
	
	private List[] splitByDigit(int[] numbers, int digit){
		List[] buckets = this.createEmptyBuckets();
		int n = (int)Math.pow(10, digit);
		int m = n * 10;
		for(int i = 0; i < numbers.length; i++){
			int currentNumber = numbers[i];
			buckets[(currentNumber % m) / n].add(currentNumber);
		}
		return buckets;
	}
	
	/* ********************************************************************* */
	
	private void copyArray(int[] numbers, List[] buckets){
		int position = 0;
		for(int i = 0; i <= 9; i++){
			List<Integer> currentList = buckets[i];
			for(Integer currentNumber : currentList){
				numbers[position] = currentNumber;
				position++;
			}
		}
	}
	
	/* ********************************************************************* */
	
	private void sort(int[] numbers, int digit, int maxLength){
		if(digit < maxLength){
			List[] buckets = this.splitByDigit(numbers, digit);
			this.copyArray(numbers, buckets);
			this.sort(numbers, digit + 1, maxLength);
		}
		
	}
	
	/* ********************************************************************* */
	
	public void sort(int[] numbers){
		this.sort(numbers, 0, 3);
	}
	
	/* ********************************************************************* */
	

}
