package rockpaperscissors;

import cse131.ArgsProcessor;

public class RPS {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("Enter your name");
		int rounds = ap.nextInt("How many games you want to play?");
		String outcome = "";
		int humanWin = 0;
		int compWin = 0;
		int tie = 0;

		System.out.println("Round\t\t"+name+"\t\tComputer\tOutcome");

		for (int i =0; i<rounds; i++) {
			int input = ap.nextInt("Enter 1 for Rock, 2 for Paper, 3 for Scissor");
			while (input != 3 && input != 2 && input != 1) {
				input = ap.nextInt("Enter 1 for Rock, 2 for Paper, 3 for Scissor");
			}
			String input1 = "";
			if (input == 1) {
				input1 = "Rock";
			}
			else if(input == 2) {
				input1 = "Paper";
			}
			else {
				input1 = "Scissor";
			}
			int compMove = (int) (Math.random()*3+1);
			String compMoveS = "";
			if (compMove == 1) {
				compMoveS = "Rock"; 
			}
			else if(compMove ==2) {
				compMoveS = "Paper";
			}
			else {
				compMoveS = "Scissor";
			}

			if(input1 == "Rock") {
				if (compMoveS == "Rock") {
					outcome = "Tie";
					tie++;
				}
				if (compMoveS == "Paper") {
					outcome = "Computer wins";
					compWin++;
				}
				if (compMoveS == "Scissor") {
					outcome = "Human wins";
					humanWin++;
				}
			}
			if (input1 == "Paper") {
				if (compMoveS =="Rock") {
					outcome = "Human wins";
					humanWin++;
				}
				if (compMoveS == "Paper") {
					outcome = "Tie";
					tie++;
				}
				if (compMoveS == "Scissor") {
					outcome = "Computer wins";
					compWin++;
				}
			}
			if (input1 == "Scissor") {
				if (compMoveS == "Rock") {
					outcome = "Computer wins";
					compWin++;
				}
				if (compMoveS == "Paper") {
					outcome = "Human wins";
					humanWin++;
				}
				if (compMoveS == "Scissor") {
					outcome = "Tie";
					tie++;
				}
			}
			System.out.println((i+1) + "\t\t" + input1 + "\t\t" + compMoveS + "\t\t" + outcome);		
		}
		System.out.println();
		System.out.println(name + "'s win rate is: " + (double)Math.round(((double)humanWin/rounds)*1000)/10 + "%");
		System.out.println("Computer's win rate is: " + (double)Math.round(((double)compWin/rounds)*1000)/10 + "%");
		System.out.println("Tie rate is: " + (double)Math.round(((double)tie/rounds)*1000)/10 + "%");
	}
}
