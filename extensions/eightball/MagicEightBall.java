package eightball;
import java.awt.Color;
import java.awt.Font;

import cse131.ArgsProcessor;
import sedgewick.*;

public class MagicEightBall {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		while(true){
		ap.nextString("What true or false question would you like to ask the all-knowing magic 8 ball?");
		StdDraw.clear();
		StdDraw.setPenColor();
		StdDraw.filledCircle(0.5, 0.5, 0.5);
		double[] x = {(0.35), (0.5), (0.65)};
		double[] y = {(0.35), (0.6), (0.35)};
		double chances = (int) (1 + (Math.random() * 15));
		String response = "";
		Color rColor = StdDraw.BLACK;
		if (chances == 1){
			rColor = StdDraw.GREEN;
			response = "It is certain";
		}
		else if(chances == 2){
			rColor = StdDraw.GREEN;
			response = "It is decidedly so";
		}
		else if(chances == 3){
			rColor = StdDraw.GREEN;
			response = "Without a doubt";
		}
		else if(chances == 4){
			rColor = StdDraw.GREEN;
			response = "Yes, definitely";
		}
		else if(chances == 5){
			rColor = StdDraw.GREEN;
			response = "You may rely on it";
		}
		else if(chances == 6){
			rColor = StdDraw.YELLOW;
			response = "Reply hazy";
		}
		else if(chances == 7){
			rColor = StdDraw.YELLOW;
			response = "Ask again later";
		}
		else if(chances == 8){
			rColor = StdDraw.YELLOW;
			response = "Better not tell you";
		}
		else if(chances == 9){
			rColor = StdDraw.YELLOW;
			response = "Cannot predict now";
		}
		else if(chances == 10){
			rColor = StdDraw.YELLOW;
			response = "Focus and ask again";
		}
		else if(chances == 11){
			rColor = StdDraw.RED;
			response = "Don't count on it";
		}
		else if(chances == 12){
			rColor = StdDraw.RED;
			response = "My reply is no";
		}
		else if(chances == 13){
			rColor = StdDraw.RED;
			response = "My sources say no";
		}
		else if(chances == 14){
			rColor = StdDraw.RED;
			response = "Outlook not so good";
		}
		else{
			rColor = StdDraw.RED;
			response = "Very doubtful";
		}
		Font font = new Font("Arial", Font.BOLD, 10);
		StdDraw.setFont(font);
		for(int i = 0; i < 255; ++i){
//			StdDraw.clear();
//			StdDraw.setPenColor();
//			StdDraw.filledCircle(0.5, 0.5, 0.5);
			Color boo = new Color(0, 0, i);
			StdDraw.setPenColor(boo);
			StdDraw.filledPolygon(x, y);
			StdDraw.setPenColor(rColor);
			if(i < 240){
			StdDraw.text(0.51, 0.425, response, 255-i);
			}
			StdDraw.text(0.5, 0.425, response, 255-i);
			StdDraw.show();
		}
		//StdDraw.text(0.5, 0.45, response);
		}
	}

}