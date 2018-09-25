package homeowning;

import cse131.ArgsProcessor;

public class HomeOwning {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String apartmentName = ap.nextString("What's the apartment complex");
		String zipCode = ap.nextString("What's the apartment's zipcode");
		int rent = ap.nextInt("Monthly rent (Integer)");
		int interest = ap.nextInt("How much the daily interset of a mortage, if it's $300.00, please convert it to cent and enter 30000");
		String x = rent*12 >= (interest*365/100+interest*365%100) ? "buy" : "rent";//compare the annual rent and interest
		String y = rent/4 >= (interest*7/100+interest*7%100) ? "buy" : "rent";//compare the weekly rent and interest

		System.out.println(apartmentName + " is located at Zip code " + zipCode);
		System.out.println("Rent per year :" + rent*12);
		System.out.println("Rent per week :" + (Math.round(((double)rent / 4)*100))/100);
		System.out.println();
		System.out.printf("Interest paid per year: $%d.%02d", interest*365/100, interest*365%100);
		System.out.println();
		System.out.printf("Interest paid per week: $%d.%02d", interest*7/100, interest*7%100);
		System.out.println();
		System.out.println("I should " + x + " this apartment");
//		System.out.println("I should " + y + " this apartment");
	}
}
