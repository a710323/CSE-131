package instrument;

import cse131.ArgsProcessor;
import sedgewick.*;
/*************************************************************************
 *  Compilation:  javac PlayThatTune.java
 *  Execution:    java PlayThatTune < input.txt
 *  Dependencies: StdAudio.java StdAudio.java
 *
 *  This is a data-driven program that plays pure tones from
 *  the notes on the chromatic scale, specified on standard input
 *  by their distance from concert A.
 *
 *  % java PlayThatTune < elise.txt
 *
 *
 *  Data files
 *  ----------
 *  http://www.cs.princeton.edu/introcs/21function/elise.txt
 *  http://www.cs.princeton.edu/introcs/21function/99luftballons.txt
 *  http://www.cs.princeton.edu/introcs/21function/freebird.txt
 *  http://www.cs.princeton.edu/introcs/21function/Ascale.txt
 *  http://www.cs.princeton.edu/introcs/21function/National_Anthem.txt
 *  http://www.cs.princeton.edu/introcs/21function/looney.txt
 *  http://www.cs.princeton.edu/introcs/21function/StairwayToHeaven.txt
 *  http://www.cs.princeton.edu/introcs/21function/entertainer.txt
 *  http://www.cs.princeton.edu/introcs/21function/old-nassau.txt
 *  http://www.cs.princeton.edu/introcs/21function/arabesque.txt
 *  http://www.cs.princeton.edu/introcs/21function/firstcut.txt 
 *  http://www.cs.princeton.edu/introcs/21function/tomsdiner.txt
 *
 *************************************************************************/

public class PlayThatTune {

	public static void main(String[] args) {

		ArgsProcessor.useStdInput("music");
		ArgsProcessor ap = new ArgsProcessor(args);
		int simulation = ap.nextInt("How many simulation");
		int j=0;
		int[] numArr = new int[simulation];
		int[] denoArr = new int[simulation];
		double[] steArr = new double[simulation];
		double pitchArr = 0;
		double strengthArr = 0;

		while(j<simulation) {
			int numerator = ap.nextInt("Enter pitch for numerator");
			numArr[j] = numerator;
			int denominator = ap.nextInt("Enter fundamental pitch");
			denoArr[j] = denominator;
			double strength = ap.nextDouble("Enter relative strength");
			steArr[j] = strength;
			j++;
		}
		for(int k = 0; k<simulation; k++) {
			pitchArr = pitchArr + Math.pow(numArr[k], 2)/Math.pow(denoArr[k], 2);
		}
		
		for(int k = 0; k< simulation; k++) {
			strengthArr = strengthArr + steArr[k];
		}
		
		
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
			for (int i = 0; i <= N; i++) {
				a[i] = (strengthArr)*Math.sin(2 * Math.PI * i * hz *(pitchArr/simulation)  / StdAudio.SAMPLE_RATE);
			}

			// play it using standard audio
			StdAudio.play(a);
		}
	}
}
