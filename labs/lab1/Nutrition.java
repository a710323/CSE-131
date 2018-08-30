package lab1;

import cse131.ArgsProcessor;

public class Nutrition {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String foodName = ap.nextString("Enter the food name");
		double carbs = ap.nextDouble("How much is the carbohyrate in this food?");
		double fats = ap.nextDouble("How much is the fat in this food?");
		double protein = ap.nextDouble("How much is the protein in this food?");
		double statedCals = ap.nextDouble("How many is the calories stated on label? ");
		
		System.out.println(foodName + " has");
		System.out.println(" " + carbs + " grams of carbohyrates = " + (double)Math.round((carbs*4)*100) / 100 + " Calories");
		System.out.println(" " + fats + " grams of fats = " + (double)Math.round((fats*9)*100) / 100 + " Calories");
		System.out.println(" " + protein + " grams of protein = " + (double) Math.round((protein*4)*100) / 100 + " Calories");
		System.out.println("This food is said to have " + (double) Math.round(statedCals*100) / 100 + " (available) Calories.");
		double sumCals = carbs*4 + fats*9 + protein*4; 
		System.out.println("With " + (double) Math.round((sumCals - statedCals)*100) / 100 + " (unavailable) Calories, this food has " + (double) Math.round(((sumCals - statedCals)/4)*100) / 100  + " grams of fiber");
		
	}

}
