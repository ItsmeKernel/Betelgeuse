package com.github.augusto1982.betelgeuse.challenges;

/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://leetcode.com/2011/08/insert-into-a-cyclic-sorted-list.html
 *
 */
public class CyclicSortedListInserter{

	/* ********************************************************************* */

	public void add(Node head, Comparable data){
		Node temp = new Node();
		temp.data = data;
		Node previous = this.findPrevious(head, data);
		temp.next = previous.next;
		previous.next = temp;
	}

	/* ********************************************************************* */

	public Node findPrevious(Node head, Comparable data){
		Node previous = null;
		if(head.data.compareTo(data) < 0){
			previous = this.findMinSpot(head, data);
		}else{
			previous = this.findMaxSpot(head, data);
		}
		return previous;
	}
	
	/* ********************************************************************* */

	protected Node findMinSpot(Node head, Comparable data){
		Node current = head;
		while(current.next.data.compareTo(data) < 0 && current.next != head){
			current = current.next;
		}
		return current;
	}
	
	/* ********************************************************************* */

	protected Node findMaxSpot(Node head, Comparable data){
		Node current = head;
		while(current.next.data.compareTo(data) > 0 && current.next != head){
			current = current.next;
		}
		return current;
	}
	
	/* ********************************************************************* */
		
	class Node{
		Comparable data;
		Node next;
	}
	
	/* ********************************************************************* */
}