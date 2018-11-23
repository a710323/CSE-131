package chords.music;

public class Triad {
	
	private SingleTone base; 
	private SingleTone twoDiatonic;
	private SingleTone fourDiatonic;
	/**
	 * Diatonic triad starting at the specified note
	 * @param ds  Scale for the triad
	 * @param root  Starting note of the triad
	 */
	public Triad(DiatonicScale ds, int root) {
		double a = ds.getPitch(root).getHertz();
		double b = ds.getPitch(root + 2).getHertz();
		double c = ds.getPitch(root + 4).getHertz();
		this.base = new SingleTone(a);
		this.twoDiatonic = new SingleTone(b);
		this.fourDiatonic = new SingleTone(c);
	}
	
	/**
	 * Returns the root, middle, and top note of the triad as an array
	 * @return an array with the root, middle, top notes of this triad
	 */
	public SingleTone[] getTones() {
		SingleTone[] copy = new SingleTone[3];
		copy[0] = this.base;
		copy[1] = this.twoDiatonic;
		copy[2] = this.fourDiatonic;
		return copy;
	}
	
	public String toString() {
		return "A triad";  // FIXME with more detail if you like
	}
	
	/**
	 * Return samples of this triad that have the specified amplitude and duration.
	 * @param amplitude the amplitude of the combined samples.  This means the individual tones must be scaled to fit
	 *    within the specified amplitude.
	 * @param duration the length in seconds of the returned samples
	 * @return samples of this triad at the specified amplitude and duration
	 */
	public Samples getSamples(double amplitude, double duration) {
		Samples a = this.base.getSamples(amplitude/3, duration);
		Samples b = this.twoDiatonic.getSamples(amplitude/3, duration);
		Samples c = this.fourDiatonic.getSamples(amplitude/3, duration);
		Samples combined = a.combine(b).combine(c);
		return combined;
	}
}
