package lab5;

public class Strings {
	/**
	 * @param a a string
	 * @param b a string to be compared with a
	 * @return true if ignoring case a is lexicographically before b, false otherwise
	 */
	public static boolean isLessThan(String a, String b) {
		return a.compareToIgnoreCase(b) < 0;
	}

	/**
	 * @param a a string
	 * @param b a string to be compared with a
	 * @return true if ignoring case a and b are equal, false otherwise
	 */
	public static boolean equals(String a, String b) {
		return a.compareToIgnoreCase(b) == 0;
	}

	/**
	 * @param a a string
	 * @param b a string to be compared with a
	 * @return true if ignoring case a is lexicographically after b, false otherwise
	 */
	public static boolean isGreaterThan(String a, String b) {
		return a.compareToIgnoreCase(b) > 0;
	}
}
