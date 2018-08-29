package studio1;

import cse131.ArgsProcessor;

public class Grading {
	public static void main(String[] args) {
		ArgsProcessor input = new ArgsProcessor(args);
		String name = input.nextString("Enter the studnet name.");
		double quizzes = input.nextDouble("The number of quizzes you receive");
		double studios = input.nextDouble("The number of studio points you receive");
		double labs = input.nextDouble("The number of lab points you receive");
		double finalProject = input.nextDouble("Your final project grade");
		double extensions = input.nextDouble("The number of extension points you receive");
		double exam1 = input.nextDouble("Enter the score of exam 1.");
		double exam2 = input.nextDouble("Enter the score of exam 2.");
		double exam3 = input.nextDouble("Enter the score of exam 3.");
		double participation = input.nextDouble("The number of participation points you receive");
		double exercises = input.nextDouble("The number of exercise points you receive");
		double questionForStudio = input.nextDouble("The number of question for studios points you receive");
		int courseEvaluation = input.nextInt("If you complete the course evaluation, please enter 100, else, enter 0");
		
		double totalScore = 0.02 * quizzes + 0.08 * studios + 0.25 * labs + 0.05 * finalProject + 
				0.25 * extensions + 0.1 * (exam1 + exam2 + exam3) + 0.02 * exercises + 0.02 * questionForStudio + 0.01 * courseEvaluation;
		
		System.out.printf("%s's course performance:%n%.2f points for quizzes%n%.2f points for studios%n%.2f points for labs", name, quizzes, studios, labs);
		System.out.printf("%n%.2f points for final project%n%.2f points for extensions %n%.2f points for exam1%n%.2f points for exam2", finalProject, extensions, exam1, exam2);
		System.out.printf("%n%.2f points for exam3%n%.2f points for particiaption%n%.2f points for exercises%n%.2f points for questionForStudio%n%n", exam3, participation, exercises, questionForStudio);
		
		System.out.println(name + "'s total score for the class is: " + totalScore);
		System.out.println("Grade for the course is: " + (int)totalScore);
		
		int lastDigit = (int)totalScore % 10;
		boolean plus = lastDigit >= 7;
		boolean minus = lastDigit < 3;
		
		System.out.println("Final grade has a plus? " + plus );
		System.out.println("Final grade has a minus? " + minus);
		
	}

}
