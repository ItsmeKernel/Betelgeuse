package com.github.augusto1982.betelgeuse.datastructures.graph;

/**
 * 
 * @author Augusto Recordon
 *
 * @param <T>
 */
public interface Graph<T> {
	
	/* ********************************************************************* */
	
	/**
	 * Adds a vertex with the given data.
	 * 
	 * @param data
	 */
	public boolean addVertex(T data);
	
	/* ********************************************************************* */
	
	/**
	 * Connects two vertices.
	 * 
	 * @param origin
	 * @param destination
	 */
	public void connect(T origin, T destination);
	
	/* ********************************************************************* */
	
	/**
	 * Returns the degree of the current graph.
	 * 
	 * @return
	 */
	public int degree();
	
	/* ********************************************************************* */
	
	/**
	 * Determines whether the graph is complete or not. That is, if every
	 * vertex is connected to all the others.
	 * 
	 * @return
	 */
	public boolean isComplete();
	
	/* ********************************************************************* */
}
