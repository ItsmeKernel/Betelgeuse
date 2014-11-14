package com.github.augusto1982.j4i.datastructures.tree;


/**
 * 
 * @author Augusto Recordon
 * 
 * This class implements a Binary Tree Node, with a data object
 * and a reference for each of its two branches.
 *
 */
public class BinaryTreeNode<T> {
	
	/* ********************************************************************* */
	
	private T data;
	
	/* ********************************************************************* */
	
	private BinaryTreeNode<T> leftBranch;
	
	/* ********************************************************************* */
	
	private BinaryTreeNode<T> rightBranch;

	/* ********************************************************************* */
	
	/**
	 * This is the only constructor, which must receive an object of T type.
	 * 
	 * @param data
	 */
	public BinaryTreeNode(T data){
		super();
		this.data = data;
	}
	
	/* ********************************************************************* */
	
	public T getData() {
		return data;
	}

	/* ********************************************************************* */
	
	public void setData(T data) {
		this.data = data;
	}

	/* ********************************************************************* */
	
	public BinaryTreeNode<T> getLeftBranch() {
		return leftBranch;
	}

	/* ********************************************************************* */
	
	public void setLeftBranch(BinaryTreeNode<T> leftBranch) {
		this.leftBranch = leftBranch;
	}

	/* ********************************************************************* */
	
	public BinaryTreeNode<T> getRightBranch() {
		return rightBranch;
	}

	/* ********************************************************************* */
	
	public void setRightBranch(BinaryTreeNode<T> rightBranch) {
		this.rightBranch = rightBranch;
	}

	/* ********************************************************************* */
}
