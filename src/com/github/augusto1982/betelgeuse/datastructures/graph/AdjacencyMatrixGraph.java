package com.github.augusto1982.betelgeuse.datastructures.graph;

/**
 * 
 * @author Augusto Recordon
 *
 * @param <T>
 */
public class AdjacencyMatrixGraph<T> implements Graph<T> {
	
	/* ********************************************************************* */
	
	private static final int DEFAULT_MAX_SIZE = 100;
	
	/* ********************************************************************* */
	
	private int length;
	
	/* ********************************************************************* */
	
	protected byte[][] adjacencies;
	
	/* ********************************************************************* */
	
	protected Vertex<T>[] vertices;
	
	/* ********************************************************************* */
	
	public AdjacencyMatrixGraph(){
		this(AdjacencyMatrixGraph.DEFAULT_MAX_SIZE);
	}
	/* ********************************************************************* */
	
	@SuppressWarnings("unchecked")
	public AdjacencyMatrixGraph(int size){
		super();
		this.vertices = new Vertex[size];
		this.length = 0;
	}
	
	/* ********************************************************************* */
	
	@Override
	public boolean addVertex(T data) {
		boolean inserted = this.length < this.vertices.length;
		this.vertices[this.length] = new VertexImpl(data);
		this.length++;
		return inserted;
		
	}
	
	/* ********************************************************************* */
	
	/**
	 * Locate a vertex's position by its data.
	 * 
	 * @param data
	 * @return
	 */
	protected int locate(T data){
		int position = -1;
		int i = 0;
		while((position < 0) && (i < this.length)){
			if(this.vertices[i].getData().equals(data)){
				position = i;
			}
		}
		return position;
	}
	
	/* ********************************************************************* */
	
	/**
	 * Connects two vertices.
	 */
	@Override
	public void connect(T origin, T destination) {
		int opos = this.locate(origin);
		int dpos = this.locate(destination);
		if((opos >= 0) && (dpos >= 0)){
			this.adjacencies[opos][dpos] = 1;
		}
		
	}

	/* ********************************************************************* */
	
	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* ********************************************************************* */
	
	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	/* ********************************************************************* */
}
