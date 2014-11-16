package com.github.augusto1982.betelgeuse.datastructures.graph;

/**
 * 
 * @author Augusto Recordon
 *
 */
public class VertexImpl<T> implements Vertex<T>{
	
	private T data;
	
	public VertexImpl(T data){
		super();
		this.data = data;
	}

	@Override
	public T getData() {
		return this.data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
		
	}

	
}
