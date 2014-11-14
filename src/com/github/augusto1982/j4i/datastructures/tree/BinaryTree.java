package com.github.augusto1982.j4i.datastructures.tree;


/**
 * 
 * @author Augusto Recordon
 * 
 * Simple implementation of the Binary Tree.
 *
 */
public class BinaryTree<T> {
	
	/* ********************************************************************* */
	
	private BinaryTreeNode<T> root;

	/* ********************************************************************* */

	/**
	 * Accessor is private to protect the internal representation
	 * of the tree.
	 * 
	 * @return root of the tree (a node)
	 */
	protected BinaryTreeNode<T> getRoot(){
		return this.root;
	}
	
	/* ********************************************************************* */

	public BinaryTree(){
		super();
	}

	/* ********************************************************************* */
	
	private BinaryTree(BinaryTreeNode<T> root){
		super();
		this.root = root;
	}
	
	/* ********************************************************************* */

	public BinaryTree<T> getLeftBranch(){
		BinaryTree<T> bt = null;
		BinaryTreeNode<T> btn = this.root.getLeftBranch();
		if(btn != null){
			bt = new BinaryTree<T>(btn);
		}
		return bt;
	}
	
	/* ********************************************************************* */

	public BinaryTree<T> getRightBranch(){
		BinaryTree<T> bt = null;
		BinaryTreeNode<T> btn = this.root.getRightBranch();
		if(btn != null){
			bt = new BinaryTree<T>(btn);
		}
		return bt;
	}
	
	/* ********************************************************************* */

	public void setLeftTree(BinaryTree<T> tree){
		this.root.setLeftBranch(tree.getRoot());
	}
	
	/* ********************************************************************* */

	public void setRightTree(BinaryTree<T> tree){
		this.root.setRightBranch(tree.getRoot());
	}
	
	/* ********************************************************************* */

	public Object getRootData(){
		Object data = null;
		if(this.root != null){
			data = this.root.getData();
		}
		return data;
	}
	
	/* ********************************************************************* */

	public void setRootData(T data){
		if(this.root == null){
			this.root = new BinaryTreeNode<T>(data);
		}else{
			this.root.setData(data);
		}
	}
	
	/* ********************************************************************* */

	/**
	 * This method determines whether this tree is balanced. That means that
	 * the difference between branches doesn't exceed the given value.
	 * 
	 * @param heightDifference
	 * @return
	 */
	public boolean isBalanced(int heightDifference){
		return this.isBalanced2(heightDifference) > 0;
	}

	/* ********************************************************************* */

	private int isBalanced2(int hd){
		int height = -1;
		if(this.root == null){
			height = 0;
		}else{
			int leftHeight = new BinaryTree<T>(this.root.getLeftBranch()).isBalanced2(hd);
			if(leftHeight > -1){
				int rightHeight = new BinaryTree<T>(this.root.getRightBranch()).isBalanced2(hd);
				if(rightHeight > -1){
					if(Math.abs(leftHeight - rightHeight) <= hd){
						height = 1 + Math.max(leftHeight, rightHeight);
					}
				}


			}

		}
		return height;
	}
	
	/* ********************************************************************* */
}
