package com.github.augusto1982.betelgeuse.sorting;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class QuickSort {
	
	/* ********************************************************************* */
	
	private int[] localCopy;
	
	/* ********************************************************************* */
	
	public void sort(int[] numbers){
		this.localCopy = numbers;
		this.sort(0,this.localCopy.length - 1);
	}
	
	/* ********************************************************************* */
	
	private void sort(int low, int high){
		
		int i = low;
		int j = high;
		int pivot = this.localCopy[(low + high) / 2];
		
		while(i <= j){
			while(this.localCopy[i] < pivot){
				i++;
			}
			while(this.localCopy[j] > pivot){
				j--;
			}
			
			if(i <= j){
				this.swap(i, j);
				i++;
				j--;
			}
		}
		if(i < high){
			this.sort(i, high);
		}
		if(j > low){
			this.sort(low,j);
		}
		
	}
	
	/* ********************************************************************* */
	
	private void swap(int posA, int posB){
		int temp = this.localCopy[posA];
		this.localCopy[posA] = this.localCopy[posB];
		this.localCopy[posB] = temp;
	}
	
	
	/* ********************************************************************* */
	
}
