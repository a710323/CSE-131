package studio1;
import cse131.ArgsProcessor;
public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int n1 = ap.nextInt("enter an integer");
		int n2 = ap.nextInt("enter another integer");
		double anw = ((double) n1 + (double)n2)/2;
		System.out.println(anw);
	}

}
