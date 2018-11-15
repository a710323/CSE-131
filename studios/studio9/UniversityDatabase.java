package studio9;

import java.util.HashMap;
import java.util.Map;

import lab7.Student;

public class UniversityDatabase {
	private final Map<String, Student> myMap;

	public UniversityDatabase() {
		this.myMap = new HashMap<>();
	}

	public void addStudent (String accountName, Student student) {
		this.myMap.put(accountName, student);
	}

	public int getStudentCount() {
		return this.myMap.size();
	}

	public String lookUpFullName(String accountName) {
		if(this.myMap.containsKey(accountName)) {
			return this.myMap.get(accountName).getFullName();
		} else {
			return null;
		}
	}

	public double getTotalBearBucks () {
		double sum = 0;
		for(Student s : this.myMap.values()) {
			sum += s.getBearBucksBalance();
		}
		return sum;
	}
}
