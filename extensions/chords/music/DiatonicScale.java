package chords.music;

/**
 * Represent a diatonic scale at some starting pitch
 *   (A Diatonic scale has-a starting pitch)
 * A diatonic scale has tones commonly called do, re, mi, fa, so, la, ti, do (same tone as low do, but an octiave higher)
 * These can correspond to the white keys of a piano, if the starting pitch for do is a C note on the piano
 * The chromatic steps between the pitches are as follows
 * do     re      mi     fa      so     la     ti     do
 *     2       2      1       2      2      2      1
 * @author roncytron
 *
 */
public class DiatonicScale {

	private Pitch myPitch;
	/**
	 * Create a diatonic (do, re mi, etc.) scale with the starting note (do) at the specified Sedgewick pitch
	 * @param p an integer pitch a la Sedgewick, so that 0 is concert A (the first A above middle C on a piano)
	 */
	public DiatonicScale(int p) {
		this(new Pitch(p));
	}

	/**
	 * Creates a diatonic scale (do, re, me, etc.) with the specified pitch as the starting note (do)
	 * @param p starting pitch (do) of the diatonic scale
	 */
	public DiatonicScale(Pitch p) {
		this.myPitch = p;
	}

	/**
	 * Returns the pitch at the diantonic offset from the starting pitch of this diatonic scale.
	 * Important:  the offset is in terms of diatonic steps, not chromatic steps.  The header comment
	 * for this class explains the chromatic distance between notes of a diatonic scale.
	 * @param pitch specifies the number of diatonic notes distant from the starting pitch of this diatonic scale.
	 *     Examples:   0 would correspond to the starting pitch (do), 1 would correspond to re
	 *     These offsets can be larger than 7 (the distance to the octave) and could be arbitrarily negative as well
	 * @return the pitch corresponding to the note at the specified diatonic distance from this scale's starting pitch
	 */
	public Pitch getPitch(int offset) {
		double frequency = this.myPitch.getHertz();
		int pitch =  (int) Math.round((Math.log(frequency/440) / Math.log(2) * 12));
		System.out.println(pitch);
		//	for A major
		if ((pitch % 12) == 0) {
			int a = 0;
			if (offset % 7 <= 1 && offset % 7 >=0) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if(offset % 7 > 1 && offset % 7 < 5) {
				a = offset / 7 * 12 + offset % 7 * 2 - 1;
			} else if(offset % 7 >= 5 && offset % 7 < 7) {
				a = offset / 7 * 12 + offset % 7 * 2 - 2;
			} else if (offset % 7 < 0 && offset % 7 >=-2) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if (offset % 7 < -2 && offset % 7 > -6) {
				a = offset / 7 * 12 + offset % 7 * 2 + 1;
			} else if (offset % 7 == -6) {
				a = offset / 7 * 12 + offset % 7 * 2 - 2;
			}
			Pitch d = new Pitch(pitch+a);
			return d;
		} 
		//	for G major
		else if (Math.round(pitch % 12) == 2) {
			int a = 0;
			if (offset % 7 <= 2 && offset % 7 >=0) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if(offset % 7 > 2 && offset % 7 <= 5) {
				a = offset / 7 * 12 + offset % 7 * 2 - 1;
			} else if(offset % 7 > 5 && offset % 7 < 7) {
				a = offset / 7 * 12 + offset % 7 * 2 - 2;
			} else if (offset % 7 < 0 && offset % 7 >-2) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if (offset % 7 <= -2 && offset % 7 > -5) {
				a = offset / 7 * 12 + offset % 7 * 2 + 1;
			} else if (offset % 7 <= -5 && offset % 7 >= -6) {
				a = offset / 7 * 12 + offset % 7 * 2 + 2;
			}
			Pitch d = new Pitch(pitch+a);
			return d;
		} 
		//	F major
		else if (Math.abs(pitch % 12) == 4) {
			int a = 0;
			if(offset % 7 >=0 && offset % 7 <= 3) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if(offset % 7 > 3 && offset % 7 <= 6) {
				a = offset / 7 * 12 + offset % 7 * 2 - 1;
			} else if(offset % 7 <= -1 && offset % 7 >= -3) {
				a = offset / 7 * 12 + offset % 7 * 2 + 1;
			} else if(offset % 7 < -3 && offset % 7 >= -6) {
				a = offset / 7 * 12 + offset % 7 * 2 + 2;
			}
			Pitch d = new Pitch(pitch+a);
			return d;
		} else if (Math.abs(pitch) == 5) {
			int a = 0;
			if (offset % 7 <=1 && offset % 7 >=0) {
				a = offset / 7 * 12 + offset % 7;
			} else if (offset % 7 > 1 && offset % 7 < 5) {
				a = offset / 7 * 12 + offset % 7 * 2 - 1;
			} else if (offset % 7 >= 5 && offset % 7 <= 6) {
				a = offset / 7 * 12 + offset % 7 * 2 - 2;
			} else if (offset % 7 <= -1 && offset % 7 >= -2) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if (offset % 7 < -2) {
				a = offset / 7 * 12 + offset % 7 * 2 + 1;
			}
			Pitch d = new Pitch(pitch + a);
			return d;
		} else if (Math.abs(pitch) == 7) {
			int a = 0;
			if (Math.abs(offset % 7) == 1) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if (offset % 7 >= 2 && offset % 7 <= 5) {
				a = offset / 7 * 12 + offset % 7 * 2 - 1;
			} else if (offset % 7 == 6) {
				a = offset / 7 * 12 + offset % 7 * 2 -2 ;
			} else if (offset <= -2 && offset >= -5) {
				a = offset / 7 * 12 + offset % 7 * 2 + 1;
			} else if (offset % 7 == -6) {
				a = offset / 7 * 12 + offset % 7 * 2 + 2;
			}
			Pitch d = new Pitch(pitch + a);
			return d;
		} else if (Math.abs(pitch) == 9) {
			int a = 0;
			if (offset % 7 >= 0 && offset % 7 <= 2) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if (offset % 7 > 2 && offset % 7 <= 6) {
				a = offset / 7 * 12 + offset % 7 * 2 - 1;
			} else if (offset % 7 <= -1 && offset % 7 >= -4) {
				a = offset / 7 * 12 + offset % 7 * 2 + 1;
			} else if (offset % 7 < -4 && offset % 7 >= -6) {
				a = offset / 7 * 12 + offset % 7 * 2 + 2;
			}
			Pitch d = new Pitch(pitch+a);
			return d;
		} else //if (Math.abs(pitch) == 11) 
		{
			int a = 0;
			if (offset % 7 >= 0 && offset % 7 <= 3) {
				a = offset / 7 * 12 + offset % 7 * 2;
			} else if (offset % 7 > 3 && offset % 7 <= 6) {
				a = offset / 7 * 12 + offset % 7 * 2 - 1;
			} else if (offset % 7 <= -1 && offset % 7 >= -3) {
				a = offset / 7 * 12 + offset % 7 * 2 + 1;
			} else if (offset % 7 < -3 && offset % 7 >= -6) {
				a = offset / 7 * 12 + offset % 7 * 2 + 2;
			}
			Pitch d = new Pitch(pitch+a);
			return d;
		}
	}

	/**
	 * Return the pitches of this diatonic scale
	 */
	public String toString() {
		String ans = "";
		for (int i=0; i < 16; ++i) {
			ans = ans + getPitch(i) + " ";
		}
		return ans;
	}

	/**
	 * You can run this to see some diatonic scales
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=0; i <= 12; ++i) {
			System.out.println(new DiatonicScale(i));
		}
	}
}
