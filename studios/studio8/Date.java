package studio8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Date implements Working{
	private final int day;
	private final int month;
	private final int year;
	private boolean isHoliday;



	public Date(int day, int month, int year, boolean isHoliday) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.isHoliday = isHoliday;
	}


	@Override
	public String toString() {
		return "Date [day=" + day + ", "
				+ "month=" + month + ", "
				+ "year=" + year + ", "
				+ "isHoliday=" + isHoliday + "]";
	}



	@Override
	public int hashCode() {
		//		final int prime = 31;
		//		int result = 1;
		//		result = prime * result + day;
		//		result = prime * result + month;
		//		result = prime * result + year;
		//		return result;
		return 0;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public boolean isEarlierThan(Date other) {
		if (this.year<other.year) {
			return true;
		}
		if (this.year==other.year) {
			if (this.month<other.month) {
				return true;
			}
			if (this.month==other.month) {
				if (this.day<other.day) {
					return true;
				}
			}
		}

		return false;
	}
	public static void main(String[] args) {
		Set<Date> mySet = new HashSet<Date>();
		Date alexBirth = new Date(1,8,1993, false);
		Date alexBirth2 = new Date(1, 8, 1993, false);
		Date reshadBirth = new Date(2, 11, 1998, false);
		Date michaelBirth = new Date(6, 11, 1999, false);
		Date tonyBirth = new Date (16, 7, 1997, false);
		Date winterBreak = new Date (20,12,2018, true);
		if(alexBirth.equals(alexBirth2)) {
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}
		Date d1 = new Date(1, 8, 1993, false);
		Date d2 = new Date(4, 20, 1945, false);


		HashSet<Date> set = new HashSet<Date>();
		set.add(d1);
		set.add(d2);
		set.add(d1);
		System.out.println(set);
		
		



		//		LinkedList<Date> myList = new LinkedList<Date>();
		//		myList.add(alexBirth);
		//		myList.add(winterBreak);
		//		myList.add(reshadBirth);
		//		myList.add(michaelBirth);
		//		myList.add(tonyBirth);
		//		myList.add(reshadBirth);
		//		myList.remove(alexBirth);
		//		System.out.println(myList.offerLast(winterBreak));
		//		
		//		System.out.println(myList);
		//		System.out.println(myList.get(2));



		//		mySet.add(alexBirth);
		//		mySet.add(reshadBirth);
		//		mySet.add(reshadBirth);
		//		System.out.println(mySet);
		//		System.out.println(alexBirth);
		//		System.out.println(reshadBirth);
		//		System.out.println(michaelBirth);
	}

	
	@Override
	public boolean amWorking() {
		if (this.day %2 == 0) {
			return true;
		}
		return false;
	}

}
