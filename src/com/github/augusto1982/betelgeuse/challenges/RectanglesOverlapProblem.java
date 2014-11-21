package com.github.augusto1982.betelgeuse.challenges;

/**
 * 
 * @author Augusto Recordon
 * 
 * Reference: http://leetcode.com/2011/05/determine-if-two-rectangles-overlap.html
 *
 */
public class RectanglesOverlapProblem{
	
	/* ********************************************************************* */
	
	public boolean overlap(Point p1, Point p2, Point p3, Point p4){
		boolean xOverlap = (p1.x <= p3.x && p3.x <= p2.x) || (p1.x <= p4.x && p4.x <= p2.x);
		boolean yOverlap = (p1.y <= p3.y && p3.y <= p2.y) || (p1.y <= p4.y && p4.y <= p2.y);
		return xOverlap && yOverlap;
	}
	
	/* ********************************************************************* */

	public Point createPoint(int x, int y){
		return new Point(x, y);
	}
	
	/* ********************************************************************* */
	
	class Point{
		int x;
		int y;
		
		Point(int x, int y){
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	/* ********************************************************************* */
	
}
