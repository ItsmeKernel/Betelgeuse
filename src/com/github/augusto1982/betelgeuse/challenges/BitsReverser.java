package com.github.augusto1982.betelgeuse.challenges;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class BitsReverser {
	
	/* ********************************************************************* */
	
	protected int bitsRequired(int number){
		return (int)(Math.log10(number) / Math.log10(2) + 1);
	}
	
	/* ********************************************************************* */
	
	protected int mask(int number){
		return (int)Math.pow(2, this.bitsRequired(number)) -1;
	}
	
	/* ********************************************************************* */
	
	public int invert(int number){
		return number ^ this.mask(number);
	}

	/* ********************************************************************* */
}
