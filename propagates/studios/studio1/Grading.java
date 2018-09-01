package studio1;
import cse131.ArgsProcessor;
public class Grading {

	public static void main(String[] args) {
		
	ArgsProcessor ap = new ArgsProcessor(args);
	String name = ap.nextString("Enter your name");
	int quizzes = ap.nextInt("Enter your quiz score (0-100)");
	int studios = ap.nextInt("Enter your studio score (0-100)");
	int labs = ap.nextInt("Enter your lab score (0-100)");
	int final_project = ap.nextInt("Enter your final project score (0-100)");
	int extensions = ap.nextInt("Enter your extension score (0-100)");
	int exam1 = ap.nextInt("Enter your first exam score (0-100)");
	int exam2 = ap.nextInt("Enter your second exam score (0-100)");
	int exam3 = ap.nextInt("Enter your third exam score (0-100)");
	int exercises = ap.nextInt("Enter your exercise score (0-100)");
	int q_for_studio = ap.nextInt("Enter your questions for studio score (0-100)");
	int course_evaluation = ap.nextInt("Enter your course evaluation score (0-100)");
	
	double overall_grade = (double) quizzes*.02 + (double)studios*.08 + (double)labs*.25 
			+(double)final_project*.05+(double)extensions*.25+(double)exam1*.1+(double)exam2*.1+(double)exam3*.1 + (double)exercises*.02
			+(double)q_for_studio*.02+(double)course_evaluation*.01;
	int grade = (int) overall_grade;
	boolean minus = (grade%10 < 3) ? true:false;
	boolean plus = (grade%10 >= 7) ? true:false;
	System.out.print(grade);
	System.out.println("final grade has a ...");
	System.out.println("Plus: " + plus);
	System.out.println("Minus: " + minus);
	
	}

}
