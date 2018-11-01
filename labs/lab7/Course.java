package lab7;

public class Course {
	private String name;
	private int credits;
	private int capacity;
	private int numSeats;
	private Student[] roster;
	public Course(String name, int credits, int seats) {
		this.name = name;
		this.credits = credits;
		this.numSeats = seats;
		this.capacity = seats;
		this.roster = new Student[seats];
	}
	public int getCredits() {
		return this.credits;
	}
	public String getName() {
		return this.name;
	}
	public int getCapacity() {
		return this.capacity;
	}
	public int getSeatsRemaining() {
		return this.numSeats;
	}
	public boolean addStudent(Student s) {
		if (this.getSeatsRemaining() <= 0) {
			return false;
		}
		for (int i = 0; i < this.roster.length; i++) {
			if (this.roster[i] == null) {
				this.roster[i] = s;
				this.numSeats--;
				return true;
			}
			if (this.roster[i].compare(s)) {
				return false;
			}
		}
		return false;
	}
	public String generateRoster() {
		String ans = "";
		for(int i = 0; i < this.roster.length; i++) {
			if(this.roster[i] != null) {
				ans = ans + " " + this.roster[i].getFullName();
			}
		}
		return ans;
	}
	public double calculateAverageGPA() {
		double ans = 0;
		for(int i = 0; i < this.roster.length; i++) {
			if(this.roster[i] == null) {
				return ans;
			}
			ans = ans*(i) + this.roster[i].calculateGradePointAverage();
			ans = ans/(i+1);
		}
		return ans;
	}
	public String toString() {
		return this.getName() + " " + this.getCredits();
	}
}
