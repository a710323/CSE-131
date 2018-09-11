package speeding;

import cse131.ArgsProcessor;

public class SpeedLimit {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int speedLimit = ap.nextInt("Enter the speed limit");
		int speed = ap.nextInt("What's the speed of vehicle");
		
		int offLimit = ((speed - speedLimit) > 0) ? speed - speedLimit: 0;
		int firstFine = (speed > (speedLimit+10)) ? 50 : 0;
		int secondFine = (speed - (speedLimit+10) > 0) ? (speed - (speedLimit+10))*10 : 0;

		System.out.println("You reported a speed of " + speed + " MPH for a speed limit of " + speedLimit + " MPH.");
		System.out.println("You went " + offLimit + " over the speed limit.");
		System.out.println("Your fine is $" + (firstFine + secondFine));

	}

}
