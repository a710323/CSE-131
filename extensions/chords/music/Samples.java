package chords.music;

import sedgewick.StdAudio;

/**
 * Represent a double[] samples array.
 * A Samples object has-a double[] array of samples, which it hides and does not expose except through
 *    the methods defined below.
 * @author roncytron
 *
 */


public class Samples {
	private double[] myArray;
	
	/**
	 * Capture the specified samples in our local array, so that they are safe from modification
	 * @param samples
	 */
	public Samples(double[] samples) {
		double[] copy = new double[samples.length];
		for(int i = 0; i < samples.length; i++) {
			copy[i] = samples[i];
		}
		this.myArray = copy;
	}
	
	/**
	 * Construct samples of the specified length, all zero.
	 * @param length
	 */
	public Samples(int length) {
		this.myArray = new double[length];
		for(int i = 0; i < length; i++) {
			this.myArray[i] = 0;
		}
	}
	
	/**
	 * Concatenate this and the other sample, returning a NEW samples object, and leaving the two inputs unchanged
	 * @param other
	 * @return the concatenation of these samples with the other samples
	 */
	public Samples concat(Samples other) {
		double[] copy = new double[this.myArray.length + other.myArray.length];
		for (int i = 0; i < this.myArray.length; i++) {
			copy[i] = this.myArray[i];
		}
		for(int i = this.myArray.length; i < other.myArray.length + this.myArray.length; i++) {
			copy[i] = other.myArray[i-this.myArray.length];
		}
		Samples d = new Samples(copy);
		return d;
	}
	
	/**
	 * Combine this and the other samples, padding by 0 if necessary, returning a NEW samples object, and leaving the two inputs unchanged
	 * @param other
	 * @return the numerical addition of these and the other samples, padded by 0 where necessary
	 */
	public Samples combine(Samples other) {
		double[] copy = new double[Math.max(this.myArray.length, other.myArray.length)];
		for(int i = 0; i < Math.min(this.myArray.length, other.myArray.length); i++) {
			copy[i] = this.myArray[i] + other.myArray[i];
		}
		if (this.myArray.length > other.myArray.length) {
			for (int i = other.myArray.length; i < this.myArray.length; i++) {
				copy[i] = this.myArray[i];
			}
		} else {
			for(int i = this.myArray.length; i < other.myArray.length; i++) {
				copy[i] = other.myArray[i];
			}
		}
		Samples d = new Samples(copy);
		return d;
	}
	
	/**
	 * 
	 * @return the number of samples
	 */
	
	public int getNumSamples() {
		return this.myArray.length;
	}
	
	/**
	 * Play these samples, by calling StdAudio.play(..) passing in the double array of samples
	 */
	public void play() {
		for(int i = 0; i < this.myArray.length; i++) {
			StdAudio.play(this.myArray[i]);
		}
	}
	
	public String toString() {
		return "Samples with " + this.getNumSamples() + " values";
	}

	/**
	 * Accessor to return a particular sample
	 * @param i the sample to be returned, with 0 as the first sample
	 * @return the specified sample value
	 */
	public double getSample(int i) {
		return this.myArray[i];
	}
	
	/**
	 * Valid only for a positive number of samples, this method returns the maximum value of all samples
	 * @return the maximum value
	 */
	public double getMax() {
		double max = Double.MIN_VALUE;
		for (int i = 0; i < this.myArray.length; i++) {
			if(this.myArray[i] > max) {
				max = this.myArray[i];
			}
		}
		return max;
	}
	
	/**
	 * Valid only for a positive number of samples, this method returns the minimum value of all samples
	 * @return the minimum value
	 */
	public double getMin() {
		double min = Double.MAX_VALUE;
		for (int i = 0; i < this.myArray.length; i++) {
			if(this.myArray[i] < min) {
				min = this.myArray[i];
			}
		}
		return min;
	}

}
