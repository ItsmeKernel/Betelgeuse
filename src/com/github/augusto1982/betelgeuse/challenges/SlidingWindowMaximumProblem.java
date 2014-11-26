package com.github.augusto1982.betelgeuse.challenges;


/**
 * 
 * @author Augusto Recordon
 * 
 * Reference http://leetcode.com/2011/01/sliding-window-maximum.html
 *
 */
public class SlidingWindowMaximumProblem {
	
	/* ********************************************************************* */
	
	public int[] buildArray(int[] a, int w){
		int[] b = null;
		if(a != null){
			b = new int[a.length - w + 1];
			int[] positions = new int[w];
			int index = 0;
			int head = 0;
			for(int i = 0; i < w; i++){
				while(index > head && a[i] > a[positions[index - 1]]){
					index--;
				}
				if(index < head){
					index = head;
				}
				positions[index] = i;
				index++;
			}
			
			for(int i = w; i < a.length; i++){
				b[i - w] = a[positions[head]];
				while(head >= index && head < (i - w)){
					head++;
				}
				
				while(index > head &&  a[i] > a[positions[index - 1]]){
					index--;
				}
				if(index < head){
					index = head;
				}
				positions[index] = i;
				index++;
			}
			
			b[a.length - w] = a[positions[head]];
		}
		return b;
	}
	
	/* ********************************************************************* */
	
	public static void main(String[] args){
		SlidingWindowMaximumProblem swmp = new SlidingWindowMaximumProblem();
		int[] numbers = new int[]{1,3,-1,-3,5,3,6,7};
		int[] b = swmp.buildArray(numbers, 3);
		for(int i = 0; i < b.length; i++){
			System.out.println(b[i]);
		}
	}
	
	/* ********************************************************************* */

}
