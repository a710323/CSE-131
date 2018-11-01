package exercises8;

import java.util.HashSet;
import java.util.Set;

public class StockHolding implements Valuable {
	private final String code;
	private final String owner;
	private int shares;
	private double price;
	
	public StockHolding(String code, String owner, double price) {
		this.code = code;
		this.owner = owner;
		this.shares = 0;
		this.price = price;
	}
	
	public int getCurrentValue() {
		return (int) (this.price * this.shares);
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "StockHolding [code=" + code + ", owner=" + owner + ", "
				+ "shares=" + shares + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		StockHolding other = (StockHolding) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Set<StockHolding> set = new HashSet<StockHolding>();
		StockHolding s1 = new StockHolding("IBM", "Alex", 100);
		s1.setShares(1000);
		set.add(s1);
		s1.setShares(2000);
		System.out.println(set);
		StockHolding s2 = new StockHolding("IBM", "Teng", 2000);
		set.add(s2);
		System.out.println(set);
	}

	@Override
	public int getLiquidValue() {
		// TODO Auto-generated method stub
		return this.getCurrentValue();
	}	
	

}
