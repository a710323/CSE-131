package studio7;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Fraction {
	
	private int numerator;
	private int denominator;
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public int getDeno() {
		return this.denominator;
	}
	public int getNum() {
		return this.numerator;
	}
	public int calDeno(Fraction a, Fraction b) {
		return a.getDeno() * b.getDeno();
	}
	public double calNum(Fraction a, Fraction b) {
		return a.getNum() * b.getDeno() + b.getNum() * a.getDeno();
	}
	public double  facPlus(Fraction a, Fraction b) {
		return calNum(a,b) /  calDeno(a,b);
	}
	public int facMulNum(Fraction a, Fraction b) {
		return a.getNum() * b.getNum() ;
	}
	public String facMul(Fraction a , Fraction  b) {
		return facMulNum(a,b) + "/" + calDeno(a,b);
	}
	public String reci(Fraction a, Fraction b) {
		return calDeno(a,b) + "/" + facMulNum(a,b);
	}
	
	public String greatCommonDivisor(Fraction a) {
		int nume = a.getNum();
		int deno = a.getDeno();
		int gcd = deno - (nume % deno);
		
		int stored = 1;
		for(int i = 1; i <= deno; i++) {
			if(deno%i == 0 && nume%i==0) {
				stored = i;
			}
		}
		
		return nume/stored + "/" + deno/stored;
		
	}
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction(18,3);
		Fraction f2 = new Fraction(2,2);
//		System.out.println(f1.facPlus(f1, f2));
//		System.out.println(f1.facMul(f1, f2));
//		System.out.println(f1.reci(f1, f2));
		System.out.println(f1.greatCommonDivisor(f1));

	}
	

}
