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
		double[] temp = new double[arr.length];
		if (coefficient == 0) {
			temp = new double[1];
			temp[0] = coefficient;
		}
		else {
			temp = Arrays.copyOf(arr, degree+1);
			temp[degree] = coefficient;
		}
		Polynomial d = new DensePolynomial(temp);
		return d;
	}

	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCoefficientAtDegree(int degree) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Polynomial derivative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial sum(Polynomial other) {
		// TODO Auto-generated method stub
		return null;
	}

}
