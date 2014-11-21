package com.github.augusto1982.betelgeuse.challenges;

/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://leetcode.com/2011/05/a-distance-maximizing-problem.html
 *
 */
public class DistanceMaximizingProblem{


	/* ********************************************************************* */
	
	private int[] numbers;
	
	/* ********************************************************************* */
	
	private Node head;

	/* ********************************************************************* */

	public int dmp(int[] numbers){
		this.numbers = numbers;
		this.buildTree();
		return this.calculateDMP();
	}

	/* ********************************************************************* */
	
	protected int calculateDMP(){
		int dmp = 1;
		int temp;
		for(int i = 0; i < this.numbers.length - 1; i++){
			if(this.numbers[i] > this.numbers[i + 1]){
				temp = this.pollTree(this.numbers[i], i);
				if(temp == -1){
					return this.numbers.length - i -1;
				}else{
					temp -= i;
					if(temp > dmp){
						dmp = temp;
					}
				}
			}
		}
		return dmp;
	}

	/* ********************************************************************* */
	
	protected int pollTree(int data, int position){
		return this.pollTree(this.head, data, position);	
	}

	/* ********************************************************************* */
	
	protected int pollTree(Node node, int data, int position){
		if(node.data == data && node.position == position){
			if(node.right == null){
				return -1;
			}
			return node.right.position;
		} else if((data < node.data) || ((data == node.data) && (position < node.position))){
			return this.pollTree(node.left, data, position);
		} else if((data > node.data) || ((data == node.data) && (position > node.position))){
			return this.pollTree(node.right, data, position);
		}
		return -1;
	}

	/* ********************************************************************* */
	
	protected void buildTree(){
		this.head = new Node(this.numbers[0], 0);
		for(int i = 1; i < this.numbers.length; i++){
			this.add(i);
		}
	}

	/* ********************************************************************* */
	
	protected void add(int position){
		Node node = new Node(this.numbers[position], position);
		this.add(this.head, node);
	}

	/* ********************************************************************* */
	
	protected void add(Node previous, Node node){
		if((node.data < previous.data) || ((node.data == previous.data) && (node.position < previous.position))){
			if(previous.left == null){
				previous.left = node;
			}else{
				this.add(previous.left, node);
			}
		}else if((node.data > previous.data) || ((node.data == previous.data) && (node.position > previous.position))){
			if(previous.right == null){
				previous.right = node;
			}else{
				this.add(previous.right, node);
			}

		}
	}

	/* ********************************************************************* */
	
	class Node{
		private int data;
		private int position;
		private Node left;
		private Node right;

		public Node(int data, int position){
			super();
			this.data = data;
			this.position = position;
		}
	}
	
	/* ********************************************************************* */
	public static void main(String[] args){
		DistanceMaximizingProblem dmp = new DistanceMaximizingProblem();
		System.out.println(dmp.dmp(new int[]{4,3,2,1}));
	}
}
