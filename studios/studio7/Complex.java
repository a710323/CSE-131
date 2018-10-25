package studio7;

public class Complex {
	
	private int real;
	private int imaginary;
	public Complex(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	public int getReal() {
		return this.real;
	}
	public int getImaginary() {
		return this.imaginary;
	}
	
	public String add(Complex a, Complex b) {
		return a.getReal()+b.getReal() + " + " + (a.getImaginary()+b.getImaginary()) + "i";
	}
	
	public String multi(Complex a, Complex b) {
		return ((a.getReal()*b.getReal())-(a.getImaginary()*b.getImaginary())+ " + " + ((a.getReal()*b.getImaginary()-(a.getImaginary()*b.getReal()) +"i")));
	}
	
	public static void main(String[] args) {
		Complex c1 = new Complex(2,3);
		Complex c2 = new Complex(4,2);
		System.out.println(c1.add(c1,c2));
		System.out.println(c1.multi(c1, c2));
	}

}
