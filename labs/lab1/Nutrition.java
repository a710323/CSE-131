package lab1;

import cse131.ArgsProcessor;

public class Nutrition {
	public static void main(String[] args) {
		//prompt the user to enter food name and its nutrition info
		ArgsProcessor ap = new ArgsProcessor(args);
		String foodName = ap.nextString("Enter the food name");
		double carbs = ap.nextDouble("How much is the carbohyrate in this food?");
		double fats = ap.nextDouble("How much is the fat in this food?");
		double protein = ap.nextDouble("How much is the protein in this food?");
		double statedCals = ap.nextDouble("How many is the calories stated on label? ");
		
//		double carbsCal = RoundTo2(carbs*4, 2);
//		double fatsCal = RoundTo2(fats*9, 2);
//		double proteinCal = RoundTo2(protein*4, 2);
//		double carbsPercent = RoundTo1_Percentage(carbsCal/statedCals, 1);
//		double fatsPercent = RoundTo1_Percentage(fatsCal/statedCals,1);
//		double proteinPercent = RoundTo1_Percentage(proteinCal/statedCals, 1);
//		
//		System.out.println(carbsCal+ "\t"+ fatsCal + "\t" + proteinCal + "\t" + carbsPercent + "\t" + fatsPercent + "\t"  + proteinPercent );
//		
		//print out the info based on the instruction
		//and do the calculation in print statement
		//use Math.round() to round the number up to second decimal point by
		//multiplying the number by 100, round it up to integer, then divide the number by 100.
		//use Math.round() to round the percentage up to first decimal point
		//this is a little bit tricky. And an % at the end of the number
		//because we add %, so multiply the number by 100.
		//then to round up to first decimal point. multiply 10, round it up, divide by 10.
		//overall multiply the number by 1000, use Math.round(), then divide 10
		
		System.out.println(foodName + " has");
		System.out.println("\t" + carbs + " grams of carbohyrates = " + (double)Math.round((carbs*4)*100) / 100 + " Calories");
		System.out.println("\t" + fats + " grams of fats = " + (double)Math.round((fats*9)*100) / 100 + " Calories");
		System.out.println("\t" + protein + " grams of protein = " + (double) Math.round((protein*4)*100) / 100 + " Calories");
		System.out.println("This food is said to have " + (double) Math.round(statedCals*100) / 100 + " (available) Calories.");
		double sumCals = carbs*4 + fats*9 + protein*4; 
		System.out.println("With " + (double) Math.round((sumCals - statedCals)*100) / 100 + " (unavailable) Calories, this food has " + (double) Math.round(((sumCals - statedCals)/4)*100) / 100  + " grams of fiber");
		System.out.println();
		System.out.println("Approximately");
		System.out.println("\t" + (double) Math.round(((carbs*4)/statedCals)*1000)/10 + "% of your food is carbohyrates");
		System.out.println("\t" + (double) Math.round(((fats*9)/statedCals)*1000)/10 + "% of your food is fats");
		System.out.println("\t" + (double) Math.round(((protein*4)/statedCals)*1000)/10 + "% of your food is protein");
		System.out.println();
		
		//add two boolean to check if the food is low-carb or low-fat
		
		boolean isLowCarb = ((double) Math.round(((carbs*4)/statedCals)*10)/10) <= 0.25;
		boolean isLowFat = ((double) Math.round(((fats*9)/statedCals)*10)/10) <= 0.15;
		System.out.println("This food is acceptible for a low-carb diet? \t" + isLowCarb);
		System.out.println("This food is acceptible for a low-fat diet? \t" + isLowFat);
		
		//add a boolean to decide if user should eat it. 
		//btw, I'll definitely not to flip a coin to decide if I should eat it or not.
		//not low-fat is fine, but I'm not fond of not low-carb food
		boolean eatIt = Math.random() < 0.5;
		System.out.println("By flip a coin, you should eat this food?\t" + eatIt );
		
// Here I declare two methods to round the number, 
		//first is to round the number to 2nd decimal point.
		//second is to round the number to 1st decimal point and present is as a %
		
		
//	public static double RoundTo2(double input, double decimal) {
//		double decimal1 = Math.pow(10, decimal);
//		double input1 = Math.round(input*decimal1) / Math.pow(10, decimal);
//		return input1;
//	}
//	public static double RoundTo1_Percentage(double input, double decimal) {
//		double decimal2 = Math.pow(10, decimal+2);
//		double input2 = Math.round(input*decimal2) / Math.pow(10, decimal);
//		return input2;
//	}
	}
}
