package com.github.augusto1982.betelgeuse.datastructures.graph;

/**
 * 
 * @author Augusto Recordon
 * 
 * Simple digraph implementation using Adjacency Matrix.
 *
 * @param <T>
 */
public class AdjacencyMatrixDiGraph<T> implements Digraph<T> {
	
	/* ********************************************************************* */
	
	private static final int DEFAULT_MAX_SIZE = 100;
	
	/* ********************************************************************* */
	
	private int length;
	
	/* ********************************************************************* */
	
	protected byte[][] adjacencies;
	
	/* ********************************************************************* */
	
	protected Vertex<T>[] vertices;
	
	/* ********************************************************************* */
	
	public AdjacencyMatrixDiGraph(){
		this(AdjacencyMatrixDiGraph.DEFAULT_MAX_SIZE);
	}
	/* ********************************************************************* */
	
	@SuppressWarnings("unchecked")
	public AdjacencyMatrixDiGraph(int size){
		super();
		this.vertices = new Vertex[size];
		this.length = 0;
	}
	
	/* ********************************************************************* */
	
	@Override
	public boolean addVertex(T data) {
		boolean inserted = this.length < this.vertices.length;
		this.vertices[this.length] = new VertexImpl<T>(data);
		this.length++;
		return inserted;
		
	}
	
	/* ********************************************************************* */
	
	protected int indegree(int vertexPosition){
		int total = 0;
		for(int i = 0; i < this.length; i++){
			if(this.adjacencies[i][vertexPosition] > 0){
				total++;
			}
		}
		return total;
	}
	
	/* ********************************************************************* */
	
	protected int outdegree(int vertexPosition){
		int total = 0;
		for(int i = 0; i < this.length; i++){
			if(this.adjacencies[vertexPosition][i] > 0){
				total++;
			}
		}
		return total;
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
	
	protected boolean[] initializeVisited(){
		boolean[] visited = new boolean[this.length];
		for(int i = 0; i < this.length; i++){
			visited[i] = false;
		}
		return visited;
		
	}
	
	/* ********************************************************************* */
	
	
	protected void dfs(){
		boolean[] visited = this.initializeVisited();
		for(int i = 0; i < this.length; i++){
			this.dfs(i, visited);
		}
		
	}
	
	/* ********************************************************************* */
	
	protected void dfs(int position, boolean[] visited){
		if(!visited[position]){
			visited[position] = true;
			for(int i = 0; i < this.length; i++){
				if(this.adjacencies[position][i] > 0){
					this.dfs(i, visited);
				}
			}
			visited[position] = false;
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
