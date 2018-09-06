package bankinterest;
import java.math.BigDecimal;

public class BankInterestCalculator {
	
	public static void main(String[] args) {
		
		System.out.println("Date" + "    " + "Type" + "       " + "Amount" + "      " + "Balance");
		String type1 = "Deposit";
		String type2 = "Withdraw";
//		BigDecimal withdraw = new BigDecimal("100.00");
//		BigDecimal initialDeposit = new BigDecimal("4000.00");
//		BigDecimal deposit = new BigDecimal("200.50");
//		BigDecimal interestRate = new BigDecimal(".02");
		
		double withdraw = 100.00;
		double initialDeposit = 4000.00;
		double deposit = 200.50;
	
		
		
		for(int i=0; i < 30; i++) {
			int c = (int)(Math.random()*2+1);
			if (i<9) {
				System.out.print(i+1 + "       ");
				}
			else {
				System.out.print(i+1 + "      ");
			}
//			if (c == 1) {
//				System.out.print(type1 + "    $" + deposit + "     $" + (initialDeposit.add(deposit)));
//				initialDeposit = initialDeposit.add(deposit);
//			}
//			else {
//				System.out.print(type2 + "   $" + "" + withdraw + "     $" + (initialDeposit.subtract(withdraw)));
//				initialDeposit = initialDeposit.subtract(withdraw);
//			}
			if (c == 1) {
				System.out.printf("%s    $%.2f     $%.2f", type1, deposit, (initialDeposit+deposit));
				initialDeposit = initialDeposit + deposit;
			}
			else {
				System.out.printf("%s   $%.2f     $%.2f", type2, withdraw, (initialDeposit-withdraw));
				initialDeposit = initialDeposit-withdraw;
			}
			System.out.println();
		
		}
		System.out.println();
//		System.out.println("Interest earned: " + initialDeposit.multiply(interestRate));
//		System.out.println("Money after one month's interest: " + (initialDeposit.add(initialDeposit.multiply(interestRate))));
		System.out.printf("Interest earned: $%.2f",initialDeposit * 0.02);
		System.out.println();
		System.out.printf("Money after one month's interest: $%.2f", (initialDeposit + initialDeposit* 0.02));
	}

}
