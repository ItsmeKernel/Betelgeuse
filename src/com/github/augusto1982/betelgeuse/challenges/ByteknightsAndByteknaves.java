package com.github.augusto1982.betelgeuse.challenges;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://www.codechef.com/problems/BYTEISLE
 *
 */
public class ByteknightsAndByteknaves {
	
	/* ********************************************************************* */
	
	private Queue<BytelandiansPossiblity> possibilities;
	
	/* ********************************************************************* */
	
	public ByteknightsAndByteknaves(){
		super();
		this.possibilities = new LinkedList<ByteknightsAndByteknaves.BytelandiansPossiblity>();
		BytelandiansPossiblity bp = new BytelandiansPossiblity();
		bp.byteknights = 0;
		bp.possibility = 0;
		this.possibilities.add(bp);
		this.possibilities.add(null);
	}
	
	/* ********************************************************************* */
	
	public void offer(int min, int max){
		BytelandiansPossiblity bp = this.possibilities.poll();
		if(this.possibilities.size() == 0){
		}else{
			while(bp != null){
				BytelandiansPossiblity temp = null;
				bp.possibility = bp.possibility << 1;
				/* if possible he's telling the truth? */
				if((bp.byteknights + 1 <= max) && (bp.byteknights + 1 >= min)){
					temp = new BytelandiansPossiblity();
					temp.possibility = bp.possibility;
					temp.byteknights = bp.byteknights;
					bp.possibility |= 1;
					bp.byteknights++;
				}else{
					/* assumed they were all Byteknaves, but there 
					 * must be a Byteknights (the last one) */
					if(bp.byteknights == 0 && min == 0 && max == 0){
						bp.possibility = 2 ;
						bp.byteknights = 1;
						/* Already counted that number of Byteknights
						 * so the last Byteknight was a Byteknave.
						 * */
					}else if(bp.byteknights == min && bp.byteknights == max ){
						int aux = bp.possibility;
						while(aux % 2 == 0){
							aux = aux >> 1;
						}
						aux --;
						aux = aux << 1;
						aux |= 1;
						bp.possibility = aux;
					}
				}
				this.possibilities.offer(bp);
				if(temp != null && min > temp.byteknights){
					this.possibilities.offer(temp);
				}
				bp = this.possibilities.poll();
			}
		}
		this.possibilities.offer(null);
	}
	
	/* ********************************************************************* */
	
	public int[] min(){
		Set<Integer> pos = new HashSet<Integer>();
		BytelandiansPossiblity min = null;
		BytelandiansPossiblity bp = this.possibilities.poll();
		while(bp != null){
			pos.add(bp.possibility);
			if(min == null || bp.possibility < min.possibility){
				min = bp;
			}
			bp = this.possibilities.poll();
		}
		return new int[]{pos.size(), min.possibility};
	}
	
	/* ********************************************************************* */
	
	class BytelandiansPossiblity{
		
		int byteknights;
		int possibility;
	}

	/* ********************************************************************* */
}
