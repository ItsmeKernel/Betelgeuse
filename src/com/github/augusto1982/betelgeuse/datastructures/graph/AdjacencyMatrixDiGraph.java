package com.github.augusto1982.betelgeuse.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;


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
	
	protected void topologicalSort(){
		int[] indegrees = this.buildIndegree();
		int index = this.findFirstZeroIndegree(indegrees);
		while(index == 0){
			indegrees[index] = -1;
			for(int i = 0; i < this.length; i++){
				if(this.adjacencies[index][i] > 0){
					indegrees[i]--;
				}
			}
			index = this.findFirstZeroIndegree(indegrees);
		}
	}
	
	/* ********************************************************************* */
	
	protected int findFirstZeroIndegree(int[] indegrees){
		for(int i = 0; i < this.length; i++){
			if(indegrees[i] == 0){
				return i;
			}
		}
		return -1;
	}
	
	/* ********************************************************************* */
	
	protected int[] buildIndegree(){
		int[] indegrees = new int[this.length];
		for(int i = 0; i < this.length; i++){
			indegrees[i] = this.indegree(i);
		}
		return indegrees;
	}
	
	/* ********************************************************************* */
	
	public void bfs(){
		for(int i = 0; i < this.vertices.length; i++){
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = this.initializeVisited();
			int level = 0;
			if(!visited[i]){
				queue.offer(i);
				queue.offer(-1);
			}
			while(!(queue.isEmpty())){
				int element = queue.poll();
				if(element == -1){
					level++;
					if(!queue.isEmpty()){
						queue.offer(-1);
					}
				}else{
					if(!visited[element]){
						visited[element] = true;
						for(int j = 0; j < this.length; j++){
							if(this.adjacencies[element][j] > 0){
								queue.offer(j);
							}
						}
					}
				}
			}
		}
		
	}
	
	/* ********************************************************************* */
	
	
	
	
	
	/* ********************************************************************* */
	
	
	public void dfs(){
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
	
	protected int[] dijkstra(int initialIndex){
		boolean[] visited = new boolean[this.length];
		int[] costs = new int[this.length];
		int[] previous = new int[this.length];
		for(int i = 0; i < this.length; i++){
			visited[i] = false;
			costs[i] = Integer.MAX_VALUE;
			previous[i] = -1;
		}
		costs[initialIndex] = 0;
		
		for(int i = 0; i < this.length; i++){
			int current = this.getMinDistance(costs, visited);
			if(current > -1){
				visited[current] = true;
				for(int j = 0; j < this.length; j++){
					if(this.adjacencies[current][j] > 0){
						int distance = costs[current] + this.adjacencies[current][j];
						if(distance < costs[j]){
							costs[j] = distance;
							previous[j] = current;
						}
					}
				}
			}
		}
		return previous;
	}
	
	/* ********************************************************************* */
	
	protected int[] dijkstra(){
		return this.dijkstra(0);
	}
	
	/* ********************************************************************* */
	
	protected int getMinDistance(int[] costs, boolean[] visited){
		int position = -1;
		int minCost = Integer.MAX_VALUE;
		for(int i = 0; i < this.length; i++){
			if((!visited[i]) && (costs[i] < minCost)){
				minCost = costs[i];
				position = i;
			}
		}
		return position;
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
