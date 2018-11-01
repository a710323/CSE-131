package studio8;

import java.util.HashSet;
import java.util.Set;

public class Calendar {

	private Set<Appointment> myCalendar;

	public Calendar(Set<Appointment> myCalendar) {
		super();
		this.myCalendar = myCalendar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myCalendar == null) ? 0 : myCalendar.hashCode());
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
		Calendar other = (Calendar) obj;
		if (myCalendar == null) {
			if (other.myCalendar != null)
				return false;
		} else if (!myCalendar.equals(other.myCalendar))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Calendar [myCalendar=" + myCalendar + "]";
	}

	public static void main(String[] args) {
		Date alexBirth = new Date(1,8,2018, false);
		Time alexTime = new Time(11,45);
		Date dent = new Date (1,8,2018, false);
		Time dennt = new Time (11,30);
		Appointment myApp = new Appointment(alexBirth, alexTime);
		Set myCal = new HashSet<Appointment>();
		myCal.add(myApp);
		Appointment dentist = new Appointment(dent, dennt);
		myCal.add(dentist);
		System.out.println(myCal);
	}
	
	
}
