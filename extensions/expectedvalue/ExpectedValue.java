package expectedvalue;

import cse131.ArgsProcessor;

public class ExpectedValue {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		double successRate = ap.nextDouble("What's the success rate of being a gamer?");
		double expectedSalaryOfGamer = successRate * 190000 + (1- successRate) * 50000; 
		double programmerSalary =(int) (Math.random()*50000) + 110000;
		boolean x = expectedSalaryOfGamer > programmerSalary;
		
		System.out.printf("Gamer: $%,d" ,(int)expectedSalaryOfGamer);
		System.out.println();
		System.out.printf("Programmer: $%,d" , (int)programmerSalary);
		System.out.println();
		System.out.println("You should be a gamer and not a programmer: " + x);
		
		double utilityOfGamer = 3 * Math.sqrt(successRate * 190000 + (1- successRate) * 50000);
		double utilityOfProgrammer = 2 * Math.sqrt((int) (Math.random()*50000) + 110000);
		boolean y = utilityOfGamer > utilityOfProgrammer;
		
		System.out.println();
		System.out.println("Now, we measure the wealth of gamer in the function of 3 * sqrt(wealth), and 2 * sqrt(wealth) for programmer");
		
		System.out.printf("Gamer: $%,d", (int)utilityOfGamer);
		System.out.println();
		System.out.printf("Programmer: $%,d", (int)utilityOfProgrammer);
		System.out.println();
		System.out.println("You should be a gamer and not a programmer: " + y);
	}

}
