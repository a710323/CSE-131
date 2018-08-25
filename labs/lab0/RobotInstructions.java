package lab0;

public class RobotInstructions  {

	/*
	 * Below you see a method called "act".
	 * It has one parameter, called "robot".
	 * For now, the way in which the code below fits into what you see on
	 * the screen will seem mysterious.  That's OK.
	 * 
	 * For now, please accept that the instructions below cause the robot to
	 * move forward, turn left, or turn right.
	 */
	public void act(RobotMotionAdapter robot) {
		
		/**
		 * Each of the following lines of code executes in turn.  The
		 * first line causes the robot to move forward 60 "pixels".  A pixel is
		 * a measurement of distance on a computer screen.
		 * 
		 * The second line causes the robot to turn left.  Based on what you see,
		 * what does "90" represent?
		 * 
		 * Run the program as instructed in the lab write-up and observe how the robot
		 * moves in response to the code you see below.
		 * 
		 * You will add instructions at the end of the code to cause the robot to move
		 * as you desire.
		 */
		// leave room 218
		robot.turnRight(90);
		robot.turnRight(90);
		robot.forward(30);
		robot.turnLeft(90);
		robot.forward(40);
		
		//Go to the stairs
		robot.turnRight(90);
		robot.forward(80);
		robot.turnLeft(90);
		robot.forward(18);
		
		//Go upstairs
		robot.turnLeft(90);
		robot.forward(25);
		robot.turnRight(90);
		robot.forward(5);
		robot.turnRight(90);
		
		//Enter room 220
		robot.forward(23);
		robot.turnLeft(90);
		
		//Leave room 220 and direct to the bridge that connect Jolley Hall and Urbauer
		robot.forward(20);
		robot.turnLeft(90);
		robot.forward(77);
		robot.turnLeft(90);
		robot.forward(370);
		
		//Go to the Office 304
		robot.turnRight(90);
		robot.forward(67);
		robot.turnRight(90);
		robot.forward(20);
		robot.turnLeft(90);
	
		//Enter Professor's Office
		robot.forward(25);
		
	}

}
