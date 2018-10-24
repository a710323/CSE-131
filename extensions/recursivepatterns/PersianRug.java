package recursivepatterns;

import java.awt.Color;
import sedgewick.*;

public class PersianRug {

	/**
	 * 
	 * @param palette an array of Colors to choose from
	 * @param llx lower left x coordinate of this rug square
	 * @param lly lower left y coordinate of this rug square
	 * @param size width (and therefore also height) of this rug square
	 * @param north color index of the north side of this rug square
	 * @param east color index of the east side of this rug square
	 * @param south color index of the south side of this rug square
	 * @param west color index of the west side of this rug square
	 */
	private static void persianRug(
			Color[] palette, 
			double llx, double lly,
			double size, 
			int north, int east, int south, int west) {
		if (size < 0.001) {
			return;
		}
//		//bottom line
//		StdDraw.setPenColor(palette[south]);
//		StdDraw.line(llx, lly, llx+size, lly);
//		//right line
//		StdDraw.setPenColor(palette[east]);
//		StdDraw.line(llx+size, lly, llx+size, lly+size);
//		//upper line
//		StdDraw.setPenColor(palette[north]);
//		StdDraw.line(llx+size, lly+size, llx, lly+size);
//		//left line
//		StdDraw.setPenColor(palette[west]);
//		StdDraw.line(llx, lly+size, llx, lly);
		
		
		StdDraw.setPenColor(palette[choiceOfColor(north, east, south, west)]);
		StdDraw.line(llx + size/2, lly, llx+size/2, lly+size);
		StdDraw.line(llx, lly + size/2, llx+size, lly+size/2);
		//lowerleft
		persianRug( palette, llx, lly, size/2, choiceOfColor(north, east, south, west), 
				choiceOfColor(north, east, south, west), south, west);
		//lowerright
		persianRug(palette, llx + size/2, lly, size/2, choiceOfColor(north, east, south, west), 
				east, south, choiceOfColor(north, east, south, west));
		//upperleft
		persianRug(palette, llx, lly+size/2, size/2, north, choiceOfColor(north, east, south, west), 
				choiceOfColor(north, east, south, west), west);
		//upperright
		persianRug(palette, llx + size/2, lly + size/2, size/2, north, east, choiceOfColor(north, east, south, west), 
				choiceOfColor(north, east, south, west));
	}
	
	public static int choiceOfColor(int north, int east, int south, int west) {
		int ans = 0;
		if((north+east+south+west) % 12 == 0) {
			ans = 1;
		}
		if((north+east+south+west) % 12 == 1) {
			ans = 2;
		}
		if((north+east+south+west) % 12 == 2) {
			ans = 3;
		}
		if((north+east+south+west) % 12 == 3) {
			ans = 4;
		}
		if((north+east+south+west) % 12 == 4) {
			ans = 5;
		}
		if((north+east+south+west) % 12 == 5) {
			ans = 6;
		}
		if((north+east+south+west) % 12 == 6) {
			ans = 7;
		}
		if((north+east+south+west) % 12 == 7) {
			ans = 8;
		}
		if((north+east+south+west) % 12 == 8) {
			ans = 9;
		}
		if((north+east+south+west) % 12 == 9) {
			ans = 10;
		}
		if((north+east+south+west) % 12 == 10) {
			ans = 11;
		}
		if((north+east+south+west) % 12 == 11) {
			ans = 0;
		}
		return ans;
	}

	public static void main(String args[]) {
		//
		// Leave the following line commented out, but once you
		//   have things working, uncomment it, and also uncomment
		//   the similar line at the end of this method.
		// Uncommenting those lines will run the graphics code
		//   in double-buffering mode, so that your image will appear
		//   almost instantaneously, instead of being drawn one line
		//   at a time.
		//
		//  Here is the line to uncomment:
		//
		  StdDraw.show(10);   // don't forget to uncomment the other line at the end
		//
		
		
		//
		// Generate a palette of colors
		//
		Color[] palette = { StdDraw.BLUE, StdDraw.CYAN, StdDraw.DARK_GRAY,
				StdDraw.GRAY, StdDraw.GREEN, StdDraw.LIGHT_GRAY,
				StdDraw.MAGENTA, StdDraw.ORANGE, StdDraw.PINK, StdDraw.RED,
				StdDraw.WHITE, StdDraw.YELLOW };
		//
		// Draw the outermost square as a special case
		// Use color 0 for that
		//
		StdDraw.setPenColor(palette[0]);
		StdDraw.line(0, 0, 1, 0);
		StdDraw.line(1, 0, 1, 1);
		StdDraw.line(1, 1, 0, 1);
		StdDraw.line(0, 1, 0, 0);

		//
		// Kick off the recursion
		// Lower left is point (0,0)
		// Size of the square is 1
		// The color index of each surrounding side is 0
		//
		persianRug(palette, 0, 0, 1, 4, 10, 3, 9);
		//
		// Also uncomment this line when you have things working
		//   to speed up the drawing:
		//
		 StdDraw.show(10);
		//
	}

}
