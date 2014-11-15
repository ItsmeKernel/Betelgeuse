package com.github.augusto1982.j4i.datastructures.graph;

/**
 * 
 * @author Augusto Recordon
 *
 * @param <T>
 */
public interface Graph<T> {
	
	public void addVertex(T data);
	
	public void connect(T origin, T destination);
	
}
