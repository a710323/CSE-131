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
		
		boolean isLowCarb = ((double) Math.round(((carbs*4)/statedCals)*10)/10) <= 0.25;
		boolean isLowFat = ((double) Math.round(((fats*9)/statedCals)*10)/10) <= 0.15;
		System.out.println("This food is acceptible for a low-carb diet? \t" + isLowCarb);
		System.out.println("This food is acceptible for a low-fat diet? \t" + isLowFat);
		
		boolean eatIt = Math.random() < 0.5;
		System.out.println("By flip a coin, you should eat this food?\t" + eatIt );
		
	}

}
