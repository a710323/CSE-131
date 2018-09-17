package arrays;
import cse131.ArgsProcessor;

public class Birthday {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Number of people");
		int[][] arr = new int[12][31];
		double averageMonthSum = 0;
		double averageDaySum = 0;
		int exactSameDay = 0;

		System.out.println("Month \t\tpeople \t\tfraction ");

		for(int i=0; i < N; i++) {
			int months = (int)(Math.random()*12 + 1);
			int days = (int)(Math.random()*31 +1);
			arr[months-1][days-1] = arr[months-1][days-1] + 1;
		}
		//		for (int r=0; r<12; r++) {
		//			for(int c=0; c<31;c++) {
		//				System.out.print(arr[r][c] + " ");
		//			}
		//			System.out.println();
		//		}
		for (int k=0; k<12; k++) {
			int monthSum = 0;
			double fractionOfMonth = 0;
			for (int l=0; l<31; l++) {
				monthSum = arr[k][l] + monthSum;
				fractionOfMonth = (double)(Math.round(((double)monthSum/N)*1000))/10;
			}
			System.out.println((k+1) +"\t\t" + monthSum + "\t\t" + fractionOfMonth + "%");
			averageMonthSum = averageMonthSum + fractionOfMonth;
		}
		System.out.println();
		System.out.println("The average of monthly fractino is: " + (double)Math.round((averageMonthSum/12)*10)/10 + "%");
		System.out.println();
		System.out.println("Day \t\tpeople \t\tfraction ");

		for (int m=0; m<31; m++) {
			int daySum = 0;
			double fractionOfDay = 0;
			for(int n=0; n<12;n++) {
				daySum = arr[n][m] +daySum;
				fractionOfDay = (double)(Math.round(((double)daySum/N)*1000))/10;
			}
			System.out.println((m+1) + "\t\t" + daySum + "\t\t" + (double)(Math.round(((double)daySum/N)*1000))/10 + "%");
			averageDaySum = averageDaySum + fractionOfDay;
		}
		System.out.println();
		System.out.println("The average of daily fracion is: " + (double)Math.round((averageDaySum/31)*10)/10 + "%");
		System.out.println();

		for (int a=0; a<12;a++) {
			for(int b=0; b<31;b++) {
				if (arr[a][b] > 1) {
					exactSameDay = arr[a][b] + exactSameDay;
				}
			}
		}
		System.out.println("The number of people born on the exact same day is: " + exactSameDay);
		System.out.println("The fraction of people born on the exact same day: " + (double)(Math.round(((double)exactSameDay/N)*1000))/10 + "%");
	}

}
