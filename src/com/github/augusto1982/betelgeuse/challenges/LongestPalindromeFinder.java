package com.github.augusto1982.betelgeuse.challenges;

/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 *
 */
public class LongestPalindromeFinder{
	
	/* ********************************************************************* */

	private int start;

	/* ********************************************************************* */
	
	private int end;

	/* ********************************************************************* */

	public String longestPalindromeFor(String string){
		if(string == null || string.length() == 0){
			return null;
		}
		this.start = 0;
		this.end = 0;

		for(int i  = 0; i < string.length() -1; i++){
			this.checkFrom(i, string);
		}

		return string.substring(this.start, this.end + 1);
	}

	/* ********************************************************************* */
	
	protected void checkFrom(int position, String string){

		int low = position;
		int high = position + 1;
		if(string.charAt(low) != string.charAt(high)){
			low--;
		}
		while(low >= 0 && high < string.length() && string.charAt(low) == string.charAt(high)){
			low --;
			high ++;
		}
		if((low < 0) || (high == string.length())){
			high --;
			low++;
		}
		if(string.charAt(low) == string.charAt(high)){
			if(high - low > end - start){
				this.start = low;
				this.end = high;
			}
		}
	}
	
	/* ********************************************************************* */
}