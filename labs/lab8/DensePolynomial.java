package lab8;

import java.util.Arrays;

public class DensePolynomial implements Polynomial{
	private final double[] myDouble;

	public DensePolynomial() {
		this.myDouble = new double[1];
		//myDouble[0]=0.0;
	}

	private DensePolynomial(double[] arr) {
		this.myDouble = arr;
	}

	@Override
	public Polynomial addTerm(double coefficient, int degree) {
		double[] arr = this.myDouble;
		double[] temp = new double[0];
		temp = CoefficientArrayUtils.createNextCoefficients(coefficient, degree, arr);
		Polynomial d = new DensePolynomial(temp);
		return d;
	}

	@Override
	public int degree() {
		return this.myDouble.length-1;
	}

	@Override
	public double getCoefficientAtDegree(int degree) {
		if(degree < this.myDouble.length) {
			return this.myDouble[degree];
		}
		else {
			return 0.0;
		}
	}

	@Override
	public double evaluate(double x) {
		double sum = 0;
		for (int i = 0; i < this.myDouble.length; i++) {
			sum += getCoefficientAtDegree(i) * Math.pow(x, i);
		}
		return sum;
	}

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

	@Override
	public Polynomial sum(Polynomial other) {
		double[] arr = new double[Math.max(this.myDouble.length, other.degree()+1)];
		for (int i = 0; i < Integer.min(this.myDouble.length, other.degree()+1); i++) {
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
	
	@Override
	public String toString() {
		String ans = "";
		for(int i = 0; i < this.myDouble.length; i++) {
			ans = ans + getCoefficientAtDegree(i) + "x^" + i;
		}
		
		return ans;
	}
	
}
