package com.github.augusto1982.betelgeuse.dp;


/**
 * 
 * @author Augusto Recordon
 * 
 * Source: http://www.codechef.com/wiki/tutorial-dynamic-programming
 * 
 * Problem Statement: On a positive integer, you can perform any one of the 
 * following 3 steps. 
 * 
 * 1.) Subtract 1 from it. ( n = n - 1 )
 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )
 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
 * 
 * Now the question is, given a positive integer n, find the minimum number of 
 * steps that takes n to 1 eg: 
 * 
 * 1.) For n = 1 , output: 0
 * 2.) For n = 4 , output: 2  ( 4  /2 = 2 / 2 = 1 )    
 * 3.) For n = 7 , output: 3  ( 7 - 1 = 6 / 3 = 2 / 2 = 1 )
 *
 */
public class MinimumStepsToOne {
	
	/* ********************************************************************* */
	
	private int[] memoSteps;
	
	/* ********************************************************************* */
	
	private int[] dpSteps;
	
	/* ********************************************************************* */
	
	private void initMemoSteps(int number){
		this.memoSteps = new int[number + 1];
		for (int i = 0; i < number; i++){
			this.memoSteps[i] = -1;
		}
	}
	
	/* ********************************************************************* */
	
	private int countMemoSteps(int number){
		int value = -1;
		if(number == 1){
			value = 0;
		}else if(this.memoSteps[number] > 0){
			value = this.memoSteps[number];
		}else{
		
			value = 1+this.countMemoSteps( number - 1);
			
			if(number % 2 == 0){
				value = Math.min(value, 1 + this.countMemoSteps(number / 2));
			}
			
			if(number % 3 == 0){
				value = Math.min(value, 1 + this.countMemoSteps(number / 3));
			}
			
		}
		this.memoSteps[number] = value;
		return value;
	}
	
	/* ********************************************************************* */
	
	private void countDPSteps(int current, int number){
		int value = -1;
		if(current == 1){
			value = 0;
		}else if(current <= number){
			value = 1 + this.dpSteps[current -1];
			if(current % 2 == 0){
				value = Math.min(value, 1 + this.dpSteps[current / 2]);
			}
			if(current % 3 == 0){
				value = Math.min(value, 1 + this.dpSteps[current / 3]);
			}
		}
		this.dpSteps[current] = value;
		
		if(current < number){
			this.countDPSteps(current + 1, number);
		}
	}
	
	/* ********************************************************************* */
	
	public int stepsRequiredWithDP(int number){
		int steps = -1;
		if(number > 0){
			long initime = System.currentTimeMillis();
			this.dpSteps = new int[number + 1];
			this.countDPSteps(1, number);
			steps = this.dpSteps[number];
			System.out.println("DP took: " + (System.currentTimeMillis() - initime));
		}
		return steps;
	}
	
	/* ********************************************************************* */
	
	public int stepsRequiredWithMemo(int number){
		int steps = -1;
		if(number > 0){
			long initime = System.currentTimeMillis();
			this.initMemoSteps(number);
			steps = this.countMemoSteps(number);
			System.out.println("Memo took: " + (System.currentTimeMillis() - initime));
		}
		return steps;
	}
	
	/* ********************************************************************* */
}
