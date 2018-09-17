package exercises4;

import sedgewick.StdDraw;

public class WaitPoint {

	public static void main(String[] args) {

		// wait for the mouse to be pressed and released
		while (!StdDraw.mousePressed()) {
			StdDraw.pause(100);
		}
		// here, the mouse has been pressed
		System.out.println("Pressed");
		while (StdDraw.mousePressed()) {
			StdDraw.pause(100);
		}
		// here the mouse is released
		System.out.println("Released");

		// draw a point at the location of the mouse
		StdDraw.setPenRadius(0.1);
		StdDraw.point(StdDraw.mouseX(), StdDraw.mouseY());

		char got = ' ';
		while (got !='q') {	
			// here, a q has been typed
			while (!StdDraw.hasNextKeyTyped()) {
				StdDraw.pause(100);
			}
			got = StdDraw.nextKeyTyped();
		}
		StdDraw.text(0.5, 0.5, "Farewell!");
	}
}
