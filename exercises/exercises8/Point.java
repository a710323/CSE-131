package exercises8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Point {
	
	//
	// has-a x and y coordinate, both integers
	//  these are immutable so you should declare them "final"
	//
	// declare instance variables here:
	//
	private final int x;
	private final int y;
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	

	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}



	public static void main(String[] args) {
		Set<Point> temp = new HashSet<Point>();
		temp.add(new Point(131,132));
		temp.add(new Point(0,0));
		temp.add(new Point(131,132));
		System.out.println(temp);
		
		List<Point> temp2 = new LinkedList<Point>();
		temp2.add(new Point(131,132));
		temp2.add(new Point(0,0));
		temp2.add(new Point(131,132));
		System.out.println(temp2);
	}

}
