package lab8;


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
		double[] arr = new double[degree+1];
		
		if (coefficient== 0) {
			arr = new double[1];
		}
		else {
			arr[degree] = coefficient;
		}
		Polynomial d = new DensePolynomial(arr);
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
