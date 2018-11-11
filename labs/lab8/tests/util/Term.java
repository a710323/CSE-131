package lab8.tests.util;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public final class Term implements Comparable<Term> {
	private final double coefficient;
	private final int degree;

	public Term(double coefficient, int degree) {
		this.coefficient = coefficient;
		this.degree = degree;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public int getDegree() {
		return degree;
	}

	@Override
	public String toString() {
		return coefficient + "x^" + degree;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (Double.doubleToLongBits(coefficient) != Double.doubleToLongBits(other.coefficient))
			return false;
		if (degree != other.degree)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coefficient);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + degree;
		return result;
	}

	@Override
	public int compareTo(Term other) {
		if (this.degree != other.degree) {
			return Integer.compare(this.degree, other.degree);
		} else {
			return Double.compare(this.coefficient, other.coefficient);
		}
	}
}
