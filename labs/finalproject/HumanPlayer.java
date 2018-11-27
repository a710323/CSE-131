package finalproject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import cse131.ArgsProcessor;
import cse131.NotYetImplementedException;

public class HumanPlayer implements Player {
	
	private final ArgsProcessor ap; // Don't change this!
	
	/**
	 * Creates an instance of the HumanPlayer class
	 * Note that we already dealt with taking in an ArgsProcessor object
	 * 		We know you've never seen this before, which is why it's given to you
	 * 		You can treat this ArgsProcessor (ap) throughout the HumanPlayer class
	 * 			like any other ArgsProcessor you've used in 131
	 * We leave the rest of the constructor to you
	 * 
	 * @param name the name of the player
	 * @param height the height of the board
	 * @param width the width of the board
	 * @param ap the ArgsProcessor object
	 */
	public HumanPlayer(String name, int height, int width, ArgsProcessor ap) {
		this.ap = ap;
	}

	@Override
	public boolean addShip(Ship s) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public int[] getTargetLocation() {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public void recordHitOrMiss(int x, int y, boolean isHit) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public Ship decideShipPlacement(int length) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public String getName() {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public boolean respondToFire(int x, int y) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public int numShipsStillAfloat() {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public boolean addRandomShip(int length) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public boolean isValidShipToAdd(Ship s) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public void printRadar() {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}


}
