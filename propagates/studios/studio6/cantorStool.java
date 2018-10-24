package studio6;

import java.awt.Color;

import sedgewick.StdDraw;

public class cantorStool {

	public static void main(String[] args) {
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.setPenColor(Color.GRAY);
		stool(0.5, 0.75,0.5,0.25);
	}

	public static void stool (double x, double y, double halfWidth, double halfHeight) {
		StdDraw.filledRectangle(x, y, halfWidth, halfHeight);

		if (halfWidth <= .01) { 
			return; 
		}

		//left rectangle
		stool(x/3,y*0.5,halfWidth/3.0,halfHeight/2.0);
		// right rectangle
		stool((5.0/3.0)*x,y*0.5,halfWidth/3.0, halfHeight/2.0);
	}

}
