package com.github.augusto1982.betelgeuse.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class MinHeap<T extends Comparable> {
	
	/* ********************************************************************* */
	
	protected List<T> elements;
	
	/* ********************************************************************* */
	
	protected int nary = 2;
	
	/* ********************************************************************* */
	
	public MinHeap(){
		super();
		this.elements = new ArrayList<T>();
		this.elements.add(null);
	}
	
	/* ********************************************************************* */
	
	public MinHeap(int nary){
		this();
		this.nary = nary;
	}
	
	/* ********************************************************************* */
	
	public boolean isEmpty(){
		return this.elements.size() == 1;
	}
	
	/* ********************************************************************* */
	
	public void add(T element){
		this.elements.add(element);
		this.percolateUp();
	}
	
	/* ********************************************************************* */
	
	protected void percolateUp(){
		if(this.size() > 1){
			int parentIndex = this.size() / this.nary;
			int promotedIndex = this.promotedChildIndex(parentIndex);
			while((parentIndex >= 1) && (parentIndex != promotedIndex)){
				this.swap(parentIndex, promotedIndex);
				parentIndex /= this.nary;
				if(parentIndex >= 1){
					promotedIndex = this.promotedChildIndex(parentIndex);
				}
			}
		}
		
	}
	
	/* ********************************************************************* */
	
	protected void percolateDown(){
		if(this.size() > 1){
			int parentIndex = 1;
			int promotedIndex = this.promotedChildIndex(parentIndex);
			while((this.firstChildIndex(parentIndex) <= this.size()) && (parentIndex != promotedIndex)){
				this.swap(parentIndex, promotedIndex);
				parentIndex = promotedIndex;
				if(this.firstChildIndex(parentIndex) <= this.size()){
					promotedIndex = this.promotedChildIndex(parentIndex);
				}
			}
		}
		
	}
	
	/* ********************************************************************* */
	
	public T top(){
		T top = this.peek();
		T temp = null;
		if(top != null){
			temp = this.elements.remove(this.size());
		}
		if(this.size() >= 1){
			this.elements.set(1, temp);
			this.percolateDown();
		}
		
		return top;
	}
	
	/* ********************************************************************* */
	
	protected int promotedChildIndex(int parentIndex){
		if((parentIndex > 0) && (parentIndex <= this.size())){
			
			int firstChild = this.firstChildIndex(parentIndex);
			int lastChild = this.lastChildIndex(firstChild);
			int currentChild = firstChild;
			
			int promotedIndex = parentIndex;
			T promotedElement = this.elements.get(promotedIndex);
			
			while(currentChild <= lastChild){
				if(this.shouldBePromoted(promotedElement, currentChild)){
					promotedElement = this.elements.get(currentChild);
					promotedIndex = currentChild;
				}
				currentChild++;
			}
			return promotedIndex;
		}else{
			throw new RuntimeException("Invalid position: " + parentIndex);
		}
	}
	
	/* ********************************************************************* */
	
	@SuppressWarnings("unchecked")
	protected boolean shouldBePromoted(T currentPromoted, int position){
		return this.elements.get(position).compareTo(currentPromoted) < 0;
	}
	
	/* ********************************************************************* */
	
	protected int firstChildIndex(int parentIndex){
		
		if((parentIndex > 0) && (parentIndex < this.elements.size())){
			return Math.max(parentIndex + 1, this.nary * parentIndex - this.nary + 2);
		}else{
			throw new RuntimeException("Invalid position: " + parentIndex);
		}
	}
	
	/* ********************************************************************* */
	
	protected  int lastChildIndex(int firstChildIndex){
		return Math.min(firstChildIndex + this.nary - 1, this.size());
	}
	
	/* ********************************************************************* */
	
	protected int parentIndex(int currentIndex){
		return currentIndex / this.nary;
	}
	
	/* ********************************************************************* */
	
	protected void swap(int a, int b){
		T temp = this.elements.get(a);
		this.elements.set(a, this.elements.get(b));
		this.elements.set(b, temp);
	}
	
	/* ********************************************************************* */
	
	public int size(){
		return this.elements.size() - 1;
	}
	
	/* ********************************************************************* */
	
	public T peek(){
		T result = null;
		if(this.size() > 0){
			result = this.elements.get(1);
		}
		return result;
	}
	
	/* ********************************************************************* */
	
	public static void main(String[] args){
		
		MinHeap<Integer> heap = new MinHeap<Integer>();
		for(int i = 30; i > 0; i--){
			heap.add(i);
		}
		
		for(int i = 1; i <= 30; i++){
			System.out.println(heap.top());
		}
	}

}
