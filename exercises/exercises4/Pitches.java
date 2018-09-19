package exercises4;

import cse131.ArgsProcessor;

public class Pitches {

	public static void main(String[] args) {
		// encoding has 0 as concert A
		//    1 would be Bb, just above A
		//   -1 would be Ab, just below A
		ArgsProcessor ap = new ArgsProcessor(args);
		int pitch = ap.nextInt("Enter a pitch");
		int pitch7 = pitch + 7;
		double frequency = 440.0 * Math.pow(2, pitch/12.0);
		double frequency7 = 440.0 * Math.pow(2, pitch7/12.0);
		System.out.println("For pitch: " + pitch);
		System.out.println("we have frequency: " + frequency);
		System.out.println("freqency 7 is: " + pitch7);
		double ratio = frequency7/frequency;
		System.out.println(ratio);
		

	}

}
