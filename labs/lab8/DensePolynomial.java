package lab8;

import java.util.Arrays;

public class DensePolynomial implements Polynomial{
	private final double[] myDouble;

	// Constructor1, create nothing
	public DensePolynomial() {
		this.myDouble = new double[1];
		//myDouble[0]=0.0;
	}

	// Constructor2, create DensePolynomial object with given double array
	private DensePolynomial(double[] arr) {
		this.myDouble = arr;
	}

	// Simply call the method in CoefficientArrayUtils class
	// Create two array, arr and temp, in order not to mutate the anything
	@Override
	public Polynomial addTerm(double coefficient, int degree) {
		double[] arr = this.myDouble;
		double[] temp = new double[0];
		temp = CoefficientArrayUtils.createNextCoefficients(coefficient, degree, arr);
		Polynomial d = new DensePolynomial(temp);
		return d;
	}

	// return int, length - 1 would equal the degree
	@Override
	public int degree() {
		return this.myDouble.length-1;
	}
	
	// If input less than the length of this.myDouble, means the degree is valid, return index of degree
	//  otherwise, return 0.0
	@Override
	public double getCoefficientAtDegree(int degree) {
		if(degree < this.myDouble.length) {
			return this.myDouble[degree];
		}
		else {
			return 0.0;
		}
	}
	
	//	iterate through the whole polynomial with given value of x
	@Override
	public double evaluate(double x) {
		double sum = 0;
		for (int i = 0; i < this.myDouble.length; i++) {
			sum += getCoefficientAtDegree(i) * Math.pow(x, i);
		}
		return sum;
	}

	//	the derivative of a constant would be zero, length would decrease by 1
	@Override
	public Polynomial derivative() {
		if(this.myDouble.length == 1) {
			double[] arr = new double[1];
			arr[0] = 0.0;
			Polynomial d = new DensePolynomial(arr);
			return d;
		}
		double[] arr = new double[this.myDouble.length-1];
		for(int i = 1; i < this.myDouble.length; i++) {
			arr[i-1] = getCoefficientAtDegree(i) * i;
		}
		Polynomial d = new DensePolynomial(arr);
		return d;
	}

	//	sum two polynomial, if the length of one array is larger than the other,
	//	sum all the coefficient to the minimum length
	//	then copy the rest of the coefficient from longer polynomial
	@Override
	public Polynomial sum(Polynomial other) {
		double[] arr = new double[Math.max(this.myDouble.length, other.degree()+1)];
		for (int i = 0; i < Math.min(this.myDouble.length, other.degree()+1); i++) {
			arr[i] = this.myDouble[i] + other.getCoefficientAtDegree(i);
		}
		if (this.myDouble.length > other.degree() +1) {
			for (int i = other.degree()+1; i < this.myDouble.length; i++) {
				arr[i] = this.myDouble[i];
			}
		}
		if (other.degree() + 1 > this.myDouble.length) {
			for (int i = this.myDouble.length; i < other.degree()+1; i++) {
				arr[i] = other.getCoefficientAtDegree(i);
			}
		}
		Polynomial d = new DensePolynomial(arr);
		return d;
	}
	
	// get the coefficients at each degree and + "x^" + degree
	@Override
	public String toString() {
		String ans = "";
		for(int i = 0; i < this.myDouble.length; i++) {
			ans = ans + getCoefficientAtDegree(i) + "x^" + i + " ";
		}
		return ans;
	}
	
}
