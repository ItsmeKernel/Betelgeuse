package com.github.augusto1982.betelgeuse.datastructures.heap;


/**
 * 
 * @author Augusto Recordon
 *
 */
public class MaxHeap<T> extends MinHeap<Comparable>{

	@Override
	@SuppressWarnings("unchecked")
	protected boolean shouldBePromoted(Comparable currentPromoted, int position){
		return this.elements.get(position).compareTo(currentPromoted) > 0;
	}
}
