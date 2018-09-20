package studio4;

import java.awt.Color;
import java.io.FileInputStream;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class Flag {

	
	public static void main(String[] args) {
		//
		//  Add code for your studio below here.
		//
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledRectangle(0, 1, 1.5, (double) 1/3);
		
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(0, (double)(1/3), 1.5, (double) 1/3);
		double [] x = {0,0, 1.0/3.0};
		double [] y = {1,0,0.5};
		
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.filledPolygon(x, y);
		
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(.1);
		StdDraw.rectangle(.5, .5, .55, .55);
		
		double i = 0.0;
		double j = 1.0;
		
		ArgsProcessor.useStdInput("music");

        // repeat as long as there are more integers to read in
        while (!StdIn.isEmpty()) {

            // read in the pitch, where 0 = Concert A (A4)
            int pitch = StdIn.readInt();

            // read in duration in seconds
            double duration = StdIn.readDouble();

            // build sine wave with desired frequency
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int N = (int) (StdAudio.SAMPLE_RATE * duration);
            double[] a = new double[N+1];
            for (int ik = 0; ik <= N; ik++) {
                a[ik] = Math.sin(2 * Math.PI * ik * hz / StdAudio.SAMPLE_RATE);
            }

            // play it using standard audio
            StdAudio.play(a);
        }

		
		while(true) {
			//StdDraw.clear();
			StdDraw.setPenColor(Color.YELLOW);
			StdDraw.text(i, j, "Sudan");
			i = i + 0.1;
			j = j - 0.1;
			
			StdDraw.pause(500);
			
		}

	}

}
