package com.github.augusto1982.betelgeuse.challenges;


/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://www.codechef.com/problems/MARCHA1/
 *
 */
public class PayingUp {
	
	
	private Wallet wallet;
	
	
	public String payUp(String[] input){
		this.wallet = new Wallet(input);
		for(int comb = 1; comb < Math.pow(2,this.wallet.bankNotes.length); comb++){
			int sum = 0;
			for(int j = 0; j < this.wallet.bankNotes.length; j++ ){
				if((comb >> j) % 2 == 1){
					sum+= this.wallet.bankNotes[j];
					if(sum == this.wallet.askedFor){
						return "Yes";
					}
				}
			}
		}
		
		return "No";
	}
	
	
	
	
	class Wallet{
		
		int[] bankNotes;
		int askedFor;
		
		Wallet(String[] input){
			if((input != null) && (input.length > 0)){
				String[] split = input[0].split(" ");
				if(split.length == 2){
					int bn = Integer.parseInt(split[0]);
					this.askedFor = Integer.parseInt(split[1]);
					this.bankNotes = new int[bn];
					if(input.length == bn + 1){
						for(int i = 1; i < input.length; i++){
							this.bankNotes[i - 1] = Integer.parseInt(input[i]);
						}
					}else{
						throw new RuntimeException("Invalid number of banknotes given");
					}
				}else{
					throw new RuntimeException("Invalid Format");
				}
			}else{
				throw new RuntimeException("Invalid Format");
			}
		}
	}
	
	public static void main(String[] args){
		String[] input = {
				"3 3",
				"10",
				"1",
				"1"
		};
		System.out.println(new PayingUp().payUp(input));
	}

}
