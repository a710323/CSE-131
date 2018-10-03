package lab4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;

public class BumpingBalls {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numBall = ap.nextInt("How many balls?");
		int pauseTime = ap.nextInt("Enter pause time");
		int iterationTime = ap.nextInt("How many iterations");
		double[][] ballPosition = new double[numBall][2];
		double[][] ballSpeed = new double[numBall][2];
		double radius = 0.03;
		

		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		StdDraw.setPenRadius(radius);
//				for (int i = 0; i < numBall; i++) {
//					double rx = (-1.0 + radius) + Math.random() * (2 - 2*radius);
//					double ry = (-1.0 + radius) + Math.random() * (2 - 2*radius);
//					ballPosition[i][0] = rx;
//					ballPosition[i][1] = ry;
//					double vx = Math.random() * .05;
//					double vy = Math.random() * .05;
//					ballSpeed[i][0] = vx;
//					ballSpeed[i][1] = vy;
//				}

		double rx1 = (-1.0 + radius) + Math.random() * (2 - 2*radius);
		double ry1 = (-1.0 + radius) + Math.random() * (2 - 2*radius);
		for (int i=0; i < numBall; i++) {
			if (Math.abs(rx1) > (1-radius)) {
				rx1 = rx1 -2*(1-radius);
				ry1 = ry1 + 2.5*radius;
				ballPosition[i][0] = rx1;
				ballPosition[i][1] = ry1;
			}
			else if(Math.abs(ry1) > (1-radius)) {
				ry1 = ry1-2*(1-radius);
				ballPosition[i][0] = rx1;
				ballPosition[i][1] = ry1;
			}
			else {
				ballPosition[i][0] = rx1;
				ballPosition[i][1] = ry1;
			}
			rx1 = rx1 + 2.5*radius;
			double vx = Math.random() * .05;
			double vy = Math.random() * .05;
			ballSpeed[i][0] = vx;
			ballSpeed[i][1] = vy;
		}
		int k = 0;

		while(k<iterationTime) {
//			StdDraw.setPenColor(Color.RED);
			for(int i=0; i< numBall; i++ ) {
				if(Math.abs(ballPosition[i][0] + ballSpeed[i][0]) >= (1 - radius) ) {
					ballSpeed[i][0] = -ballSpeed[i][0];
//	            	StdAudio.play("sound/BonkCrsh.wav");

				}
				if(Math.abs(ballPosition[i][1] + ballSpeed[i][1]) >= (1 - radius) ) {
					ballSpeed[i][1] = -ballSpeed[i][1];
//	            	StdAudio.play("sound/elaugh.wav");

				}
				for (int j=i+1; j < numBall; j++) {
					if (Math.sqrt(Math.pow(((ballPosition[j][0]+ballSpeed[j][0]) - (ballPosition[i][0]+ballSpeed[i][0])), 2) + Math.pow((ballPosition[j][1]+ballSpeed[j][1]) - (ballSpeed[i][1]+ballPosition[i][1]), 2))<2*radius) {
						ballSpeed[i][0] = -ballSpeed[i][0];
						ballSpeed[i][1] = -ballSpeed[i][1];
						ballSpeed[j][0] = -ballSpeed[j][0];
						ballSpeed[j][1] = -ballSpeed[j][1];
					}
				}
				ballPosition[i][0] = ballPosition[i][0] + ballSpeed[i][0];
				ballPosition[i][1] = ballPosition[i][1] + ballSpeed[i][1];
//				StdDraw.picture(ballPosition[i][0], ballPosition[i][1], "images/smileyface.gif");
				StdDraw.filledCircle(ballPosition[i][0], ballPosition[i][1], radius);
			}
			StdDraw.show(pauseTime);
			StdDraw.clear();
			k++;
		}
	}
}
