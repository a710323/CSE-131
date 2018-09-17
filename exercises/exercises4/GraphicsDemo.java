package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class GraphicsDemo {

	public static void main(String[] args) {
		StdDraw.setPenColor(Color.BLUE);
		// blue point (look carefully, will be very small on your screen)
		StdDraw.point(0.88, 0.12);
		// larger green point
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.setPenRadius(0.03);
		StdDraw.point(0.11,0.34);
		
		// unfilled red triangle
		StdDraw.setPenColor(Color.RED);
		StdDraw.rectangle(0.34, 0.45, 0.2, 0.3);
		
		// yellow circle, filled
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.filledCircle(0.01, 0.02, 0.3);
		// filled blue rectangle
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(0.79, 0.82, 0.05, 0.04);


	}

}
