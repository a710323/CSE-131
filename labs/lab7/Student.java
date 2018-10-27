package lab7;

public class Student {
	private String firstName;
	private String lastName;
	private final int id;
	private int attemptedCredit;
	private int passingCredit;
	private double point;
	private double bearBucks;

	public Student(String firstName, String lastName, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		point = 0.0;
		this.attemptedCredit = 0;
		this.bearBucks = 0;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	public int getId() {
		return id;
	}
	public void submitGrade(double grade, int credits) {
		if (grade < 1.7) {
			this.attemptedCredit += credits;
			this.passingCredit += 0;
		}
		else {
			this.attemptedCredit += credits;
			this.passingCredit += credits;
		}
		double tempGPA = (grade * credits + this.point*this.attemptedCredit)
				/(this.attemptedCredit+credits);
		this.point = tempGPA;

	}
	public int getTotalAttemptedCredits() {
		return this.attemptedCredit;
	}
	public int getTotalPassingCredits() {
		return this.passingCredit;
	}
	public double calculateGradePointAverage() {
		if (this.point <=4.0 && this.point >=0) {
			return this.point;
		}
		return 0.0;
	}


}
