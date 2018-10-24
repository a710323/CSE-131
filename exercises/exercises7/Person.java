package exercises7;

/**
 * 
 * Identify the parts of this object:
 *      Constructor
 *      Instance variables
 *      Methods
 *         Accessors
 *         Mutators
 *         Other
 *
 */
public class Person {
	
	/**
	 * instance variables
	 */
	private int height, age;
	
	/**
	 * Constructor
	 * @param height
	 */
	public Person(int height) {
		this.height = height;
		this.age    = 0;
	}
	
	/**
	 * mutator
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * other 
	 */
	public void happyBirthday() {
		this.age = this.age + 1;
	}
	
	/**
	 * accessor 
	 * @return
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * accessor
	 * @return
	 */
	public int getAge() {
		return this.age;
	}
	

}
