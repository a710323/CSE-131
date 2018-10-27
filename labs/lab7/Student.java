package lab7;

public class Student {
	private String firstName;
	private String lastName;
	private final int id;
	private int attemptedCredit;
	private int passingCredit;
	private double point;
	private double gpa;
	private double bearBucks;

	public Student(String firstName, String lastName, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.point = 0.0;
		this.attemptedCredit = 0;
		this.bearBucks = 0;
		this.gpa = Double.NaN;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	public boolean compare(Student s2) {
		if(this.getFullName().compareTo(s2.getFullName()) == 0) {
			if(this.getId() == s2.getId()) {
				return true;
			}
		}
		return false;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	public int getId() {
		return id;
	}
	public void submitGrade(double grade, int credits) {
		double tempGPA = (grade * credits + this.point*this.attemptedCredit)
				/(this.attemptedCredit+credits);
		this.point = tempGPA;
		this.gpa = tempGPA;
		if (grade > 4.0 || grade < 0) {
			return;
		}
		else {
			if (grade < 1.7) {
				this.attemptedCredit += credits;
				this.passingCredit += 0;
			}
			else {
				this.attemptedCredit += credits;
				this.passingCredit += credits;
			}
			
		}
	}
	public int getTotalAttemptedCredits() {
		return this.attemptedCredit;
	}
	public int getTotalPassingCredits() {
		return this.passingCredit;
	}
	public double calculateGradePointAverage() {
		return this.gpa;
	}
	public String getClassStanding() {
		if (passingCredit < 30) {
			return "FirstYear";
		}
		else if(passingCredit>=30 && passingCredit <60) {
			return "Sophomore";
		}
		else if(passingCredit>=60 && passingCredit < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	public boolean isEligibleForPhiBetaKappa() {
		if (this.gpa >= 3.6) {
			if (this.passingCredit >= 98) {
				return true;
			}
			if(this.passingCredit >= 75) {
				if (this.gpa >= 3.8) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Student Alex = new Student("Alex", "Teng", 1);
		Alex.submitGrade(3.0, 3);
		double x = Alex.calculateGradePointAverage();

		Alex.submitGrade(3.9, 4);
		double y = Alex.calculateGradePointAverage();
		System.out.println(x);
		System.out.println(y);
	}
	
	public void depositBearBucks(double amount) {
		this.bearBucks += amount;
	}
	public void deductBearBucks(double amount) {
		this.bearBucks -= amount;
	}
	public double getBearBucksBalance() {
		return this.bearBucks;
	}
	public double cashOutBearBucks() {
		if (this.bearBucks <= 10.0) {
			this.bearBucks = 0;
			return 0;
		}
		else {
			double ans = this.bearBucks - 10;
			this.bearBucks = 0;
			return ans;
			
		}
	}
	public String concatLastName(Student otherParent, boolean isHyphenated) {
		if (isHyphenated == true) {
			return this.lastName+"-"+otherParent.lastName;
		}
		else {
			return this.lastName;
		}
	}
	
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		Student child = new Student(firstName, concatLastName(otherParent, isHyphenated), id);
		child.bearBucks = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
		return child;
	}
	public String toString() {
		return this.getFullName() + " " + this.id;
	}
	
	
}
