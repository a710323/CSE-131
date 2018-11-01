package studio8;

public class Appointment {
	
	private Date date;
	private Time time;
	
	public Appointment(Date date, Time time) {
		super();
		this.date = date;
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Appointment other = (Appointment) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Appointment [date=" + date + ", time=" + time + "]";
	}

	public static void main(String[] args) {
		Date alexBirth = new Date(1,8,1990, false);
		Time alexTime = new Time(11,45);
		Appointment myApp = new Appointment(alexBirth, alexTime);
		Date alexisBirth = new Date(1,8,1993, false);
		Time alexisTime = new Time(11,40);
		Appointment myApp2 = new Appointment(alexisBirth, alexisTime);
		System.out.println(alexBirth.isEarlierThan(alexisBirth));
		System.out.println(alexTime.isEarlierThan(alexisTime));

	}

}
