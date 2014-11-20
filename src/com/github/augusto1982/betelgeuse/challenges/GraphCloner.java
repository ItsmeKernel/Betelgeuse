package com.github.augusto1982.betelgeuse.challenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://leetcode.com/2012/05/clone-graph-part-i.html
 * 
 * Problem: It doesn't clone the whole graph, it'd only clone
 * 			the connected vertices.
 *
 */
public class GraphCloner{

	public Node clone(Node graphNode){
		Node clone = null;
		if(graphNode != null){
			clone = this.createNode(graphNode.data);
			Queue<Node> queue1 = new LinkedList<Node>();
			Queue<Node> queue2 = new LinkedList<Node>();
			List<Node> visited = new ArrayList<Node>();
			queue1.offer(graphNode);
			queue2.offer(clone);
			while(!queue1.isEmpty()){
				Node aux1 = queue1.poll();
				Node aux2 = queue2.poll();
				visited.add(aux1);
				for(Node node : aux1.neighbors){
					Node copy = this.createNode(aux1.data);
					aux2.neighbors.add(copy);
					if(!visited.contains(aux1)){
						queue1.offer(node);
						queue2.offer(copy);
					}
				}
			}
		}
		return clone;
	}


	public Node createNode(Object data){
		Node result = new Node();
		result.data = data;
		result.neighbors = new ArrayList<Node>();
		return result;
	}

	class Node{
		Object data;
		List<Node> neighbors;
	}
}