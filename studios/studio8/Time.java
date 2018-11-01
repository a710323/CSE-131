package studio8;

public class Time implements Working{
	private final int hour;
	private final int minute;


	public static void main(String[] args) {
	}



	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public boolean isEarlierThan(Time other) {
		if (this.hour<other.hour) {
			return true;
		}
		if (this.hour==other.hour) {
			if (this.minute<other.minute) {
				return true;
			}
		}
		return false;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + minute;
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
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + "]";
	}



	@Override
	public boolean amWorking() {
		if (this.hour>=9) {
			if (this.hour<17) {
				return true;
			}
		}
		return false;
	}
}