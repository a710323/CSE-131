package studio7;

public class Rectangle {
	
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getArea() {
		return this.length * this.width;
	}
	public double getPerimeter() {
		return 2 * (this.length + this.width);
	}
	
	public boolean compareArea(Rectangle a, Rectangle b) {
		return a.getArea()>b.getArea();
	}
	public boolean isSquare() {
		return this.length == this.width;
	}
	
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle(5.6, 4.3);
		Rectangle rec2 = new Rectangle(2.3, 0.1);
		Rectangle rec3 = new Rectangle(2, 2);

		System.out.println(rec1.getArea() + " " + rec1.getPerimeter());
		System.out.println(rec1.compareArea(rec1, rec2));
		System.out.println(rec1.isSquare());
		System.out.println(rec3.isSquare());

	}
	
	

}
