package com.github.augusto1982.j4i.sorting;


/**
 * 
 * @author Augusto Recordon
 *
 */
public class MergeSort {
	
	/* ********************************************************************* */
	
	private int[] localCopy;
	
	/* ********************************************************************* */
	
	private int[] helper;
	
	/* ********************************************************************* */
	
	public void sort(int[] numbers){
		int size = numbers.length;
		this.helper = new int[size];
		this.localCopy = numbers;
		this.merge(0, size - 1);
	}
	
	/* ********************************************************************* */
	
	private void merge(int low, int high){
		if(low < high){
			int middle = (low + high) / 2;
			this.merge(low,middle);
			this.merge(middle + 1, high);
			this.doMerge(low, middle, high);
		}
	}
	
	/* ********************************************************************* */
	
	private void doMerge(int low, int middle, int high){
		for(int i = low; i <= high; i++){
			this.helper[i] = this.localCopy[i];
		}
		int i = low;
		int j = middle + 1;
		int currentPosition = low;
		while((i <= middle) && (j <= high)){
			if(this.helper[i] < this.helper[j]){
				this.localCopy[currentPosition] = this.helper[i];
				i++;
			}else{
				this.localCopy[currentPosition] = this.helper[j];
				j++;
			}
			currentPosition++;
		}
		
		while(i <= middle){
			this.localCopy[currentPosition++] = this.helper[i++];
		}
	}

	/* ********************************************************************* */
}
