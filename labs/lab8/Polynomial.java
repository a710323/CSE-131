package lab8;

/**
 * @author Ron Cytron
 */
public interface Polynomial {
	/**
	 * Return a new Polynomial that includes the supplied coefficient and degree
	 * term. If the supplied term is of the same degree as an already existing Term
	 * in this Polynomial, then the coefficients of the supplied and existing terms
	 * are summed in the returned new Polynomial.
	 * 
	 * This Polynomial must not be disturbed by this method. Be sure to return a new
	 * Polynomial that is like this one, but with the extra term included.
	 * 
	 * @param coefficient
	 * @param degree
	 * @return new Polynomial as described above
	 */
	public Polynomial addTerm(double coefficient, int degree);

	/**
	 * Return the degree of this Polynomial, computed as the highest degree Term of
	 * this Polynomial over all Terms with non-zero coefficients. The degree of all
	 * Polynomials is at least 0, because a Polynomial with no Terms is equivalent
	 * to 0.0 x^0
	 * 
	 * @return the degree of this Polynomial
	 */
	public int degree();

	/**
	 * Returns the coefficient of the term at the specified degree. If no such term
	 * exists in the Polynomial, 0.0 should be returned.
	 * 
	 * @param degree of interest
	 * @return coefficient of the degree of interest
	 */
	public double getCoefficientAtDegree(int degree);

	/**
	 * Evaluate this Polynomial at the specified value for x
	 * 
	 * @param x value of the unknown
	 * @return the sum of all terms evaluated at x
	 */
	public double evaluate(double x);

	/**
	 * Returns a new Polynomial that is the derivative of this one. Be sure not to
	 * modify this Polynomial.
	 * 
	 * @return
	 */
	public Polynomial derivative();

	/**
	 * Return a new Polynomial that is the sum of this one and the other one. Be
	 * sure not to disturb this Polynomial.
	 * 
	 * @param other another Polynomial
	 * @return the sum of this and the other Polynomial
	 */
	public Polynomial sum(Polynomial other);
}
