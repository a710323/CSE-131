package exercises4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N  = ap.nextInt("How many history");
		double[] X = new double[N];
		double[] Y = new double[N];
		int cur = 0;
		

		StdDraw.setPenColor(Color.blue);

		while (true) {
			StdDraw.clear();
			//
			// Render one frame of your animation below here
			//
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			
			X[cur] = x;
			Y[cur] = y;
			cur = cur + 1;
			if (cur >= X.length) {
				cur = 0;
			}
			int history = cur;
					
			StdDraw.filledCircle(X[history], Y[history], 0.02);


			//  
			// End of your frame
			//
			// Stdraw.show(..) achieves double buffering and
			//   avoids the tight spinning loop
			StdDraw.show(10);
		}

	}

}
