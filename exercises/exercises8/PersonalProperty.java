package exercises8;

public class PersonalProperty implements Valuable{
	private final int initialValue;
	private int yearsOld;
	
	public PersonalProperty(int initialValue) {
		this.initialValue = initialValue;
	}
	
	public int depreciatedValue() {
		return (int)(initialValue * Math.pow(0.8, this.yearsOld));
	}
	
	public void yearOlder() {
		this.yearsOld = this.yearsOld + 1;
	}
	
	public String toString() {
		return "Initial Value: " + this.initialValue + " current value: " + this.depreciatedValue();
	}

	@Override
	public int getLiquidValue() {
		// TODO Auto-generated method stub
		return this.depreciatedValue();
	}
	
	

}
