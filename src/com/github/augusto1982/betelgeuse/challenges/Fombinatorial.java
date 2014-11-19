package com.github.augusto1982.betelgeuse.challenges;

/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://www.codechef.com/problems/POWERMUL
 *
 */
public class Fombinatorial {
	
	/* ********************************************************************* */
	
	private int[] fombinatories;
	
	/* ********************************************************************* */
	
	protected int fombinatory(int n, int r, int m){
		return ((this.fombinatories[n])/(this.fombinatories[r] * this.fombinatories[n - r])) % m;
	}
	
	/* ********************************************************************* */
	
	protected void loadFombinatories(int n, int r){
		this.fombinatories = new int[Math.max(n, r) + 1];
		this.fombinatories[1] = 1;
		for(int i = 2; i < this.fombinatories.length; i++){
			this.fombinatories[i] = this.fombinatories[i - 1] * (int)Math.pow(i, i);
		}
	}
	
	
	/* ********************************************************************* */
	
	public int fombinatorial(String line){
		String[] split = line.split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int r = Integer.parseInt(split[2]);
		this.loadFombinatories(n, r);
		return this.fombinatory(n, r, m);
	}
	
	/* ********************************************************************* */
	
}
