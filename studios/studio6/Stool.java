package studio6;

import java.awt.Color;

import sedgewick.StdDraw;

public class Stool {
	
	public static void main(String[] args) {
		StdDraw.setXscale(0,1);
		StdDraw.setYscale(0,1);
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(1.0/2, 3/4.0, 1.0/2, 1.0/4);
		stool(1.0/2,3/4.0,1/2.0,1/4.0);
	}
	public static void stool(double x, double y, double width, double height) {
		if(width<=0.001) {
			return;
		}
		StdDraw.filledRectangle(x, y, width, height);
		stool(x-(width*2/3.0), y/2.0,width/3.0,height/2.0);
		stool(x+(width*2/3.0), y/2.0,width/3.0,height/2.0);
	}
}
