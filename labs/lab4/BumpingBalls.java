package lab4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class BumpingBalls {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numBall = ap.nextInt("How many balls?");
		int pauseTime = ap.nextInt("Enter pause time");
		double[][] ballPosition = new double[numBall][2];
		double[][] ballSpeed = new double[numBall][2];
		double radius = 0.05;

		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		StdDraw.setPenRadius(radius);
		for (int i = 0; i < numBall; i++) {
			double rx = Math.random() * 2 - (1 - radius);
			double ry = Math.random() * 2 - (1 - radius);
			ballPosition[i][0] = rx;
			ballPosition[i][1] = ry;
			double vx = Math.random() * .03;
			double vy = Math.random() * .03;
			ballSpeed[i][0] = vx;
			ballSpeed[i][1] = vy;			
		}
		while(true) {
			StdDraw.setPenColor(Color.BLUE);
			for(int i=0; i< numBall; i++ ) {
				if(Math.abs(ballPosition[i][0] + ballSpeed[i][0]) >= (1 - radius) ) {
					ballSpeed[i][0] = -ballSpeed[i][0];
				}
				if(Math.abs(ballPosition[i][1] + ballSpeed[i][1]) >= (1 - radius) ) {
					ballSpeed[i][1] = -ballSpeed[i][1];
				}
				for (int j=i+1; j < numBall; j++) {
					if (Math.sqrt(Math.pow((ballPosition[i][0] - ballPosition[j][0]), 2) + Math.pow(ballPosition[i][1] - ballPosition[j][1], 2))<= 2*radius) {
						ballSpeed[i][0] = -ballSpeed[i][0];
						ballSpeed[i][1] = -ballSpeed[i][1];
						ballSpeed[j][0] = -ballSpeed[j][0];
						ballSpeed[j][1] = -ballSpeed[j][1];
					}
				}
				ballPosition[i][0] = ballPosition[i][0] + ballSpeed[i][0];
				ballPosition[i][1] = ballPosition[i][1] + ballSpeed[i][1];
				StdDraw.filledCircle(ballPosition[i][0], ballPosition[i][1], radius);
			}
			StdDraw.show(pauseTime);
			StdDraw.clear();

		}
	}
}
