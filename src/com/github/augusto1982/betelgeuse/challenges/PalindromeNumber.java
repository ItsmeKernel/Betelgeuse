package com.github.augusto1982.betelgeuse.challenges;

/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://leetcode.com/2012/01/palindrome-number.html
 *
 */
public class PalindromeNumber{
	
	/* ********************************************************************* */

	public boolean isPalindrome(int number){
		if(number < 0){
			return false;
		}else if(number < 10){
			return true;
		}else{
			for(int i = 0; i < (Math.log10(number)+1) / 2; i++){
				if(this.firstDigit(number, i) != this.lastDigit(number,i)){
					return false;
				}
			}
		}
		return true;
	}

	/* ********************************************************************* */
	
	protected int digitAt(int number, int position){
		return number / (int)(Math.pow(10, position)) % 10;
	}

	/* ********************************************************************* */
	
	protected int firstDigit(int number, int position){
		return this.digitAt(number, position);
	}

	/* ********************************************************************* */
	
	protected int lastDigit(int number, int position){
		return this.digitAt(number, (int)Math.log10(number) - position);
	}
	
	/* ********************************************************************* */

}