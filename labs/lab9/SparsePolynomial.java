package lab9;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lab8.Polynomial;

public class SparsePolynomial implements Polynomial {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myMap == null) ? 0 : myMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SparsePolynomial other = (SparsePolynomial) obj;
		if (myMap == null) {
			if (other.myMap != null)
				return false;
		} else if (!myMap.equals(other.myMap))
			return false;
		return true;
	}

	private final Map<Integer, Double> myMap; 
	
	public SparsePolynomial() {
		this.myMap = new HashMap<>();
	}
	private SparsePolynomial(Map<Integer, Double> map) {
		this.myMap = map;
	}
	
	@Override
	public Polynomial addTerm(double coefficient, int degree) {
		Map<Integer, Double> copy = this.myMap;
		Map<Integer, Double> copy2 = MapDegreeToCoefficientUtils.createNextMap(coefficient, degree, copy);
		Polynomial d = new SparsePolynomial(copy2);
		return d;
	}

	@Override
	public int degree() {
		if(myMap.isEmpty()) {
			return 0;
		}
		int a = Integer.MIN_VALUE;
		for(Integer b : myMap.keySet()) {
			if (b > a) {
				a = b;
			}
		}
		return a;
	}

	@Override
	public double getCoefficientAtDegree(int degree) {
		if (this.myMap.containsKey(degree)) {
			return this.myMap.get(degree);
		}
		return 0.0;
	}

	@Override
	public double evaluate(double x) {
		double sum = 0;
		for(Entry<Integer, Double> record : this.myMap.entrySet()) {
			sum = sum + record.getValue() * (Math.pow(x, record.getKey()));
		}
		return sum;
	}

	@Override
	public Polynomial derivative() {
		Map<Integer, Double> copy = new HashMap<>();
		for(Entry<Integer, Double> record: this.myMap.entrySet()) {
			if(record.getKey() != 0) {
				double a = record.getValue();
				a = a * record.getKey();
				int b = record.getKey();
				b = b - 1;
				copy.put(b, a);
			}
		}
		Polynomial copy2 = new SparsePolynomial(copy);
		return copy2;
	}

	@Override
	public Polynomial sum(Polynomial other) {
		Map<Integer, Double> copy = MapDegreeToCoefficientUtils.copyMap(this.myMap);
		double sum = 0;
		for(int i = 0; i <= Math.max(this.degree(), other.degree()); i++) {
			sum = this.getCoefficientAtDegree(i) + other.getCoefficientAtDegree(i);
			copy.put(i, sum);
		}
		Polynomial d = new SparsePolynomial(copy);
		return d;
	}

	@Override
	public String toString() {
		String ans = "";
		for(Entry<Integer, Double> record : this.myMap.entrySet()) {
			ans = ans + record.getValue() + "x^" + record.getKey() + " ";
		}
		return ans;
	}
}
