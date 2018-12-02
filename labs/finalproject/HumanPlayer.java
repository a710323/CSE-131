package finalproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import cse131.ArgsProcessor;
import cse131.NotYetImplementedException;

public class HumanPlayer implements Player {

	private final ArgsProcessor ap; // Don't change this!
	private String name;
	private int height;
	private int width;
	private int numShips;
	private Map<Integer, Ship> shipMap = new HashMap<Integer, Ship>();
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
		this.name = name;
		this.height = height;
		this.width = width;
		this.numShips = 0;
	}

	@Override
	public boolean addShip(Ship s) {
		if(s.getxArr()[0] < 0 || s.getyArr()[0] < 0) {
			return false;
		}
		if(s.getxArr().length >= 20 || s.getyArr().length >= 20) {
			return false;
		}
		if(this.shipMap.size() == 0) {
			this.shipMap.put(0, s);
			this.numShips++;
			return true;
		} else {
			if(isValidShipToAdd(s)) {
				this.shipMap.put(this.numShips, s);
				return true;
			} else {
				return false;
			}
		}
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
		return this.name;
	}

	@Override
	public boolean respondToFire(int x, int y) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public int numShipsStillAfloat() {
		return numShips;
	}

	@Override
	public boolean addRandomShip(int length) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}

	@Override
	public boolean isValidShipToAdd(Ship s) {
		for(int i = 0; i < this.shipMap.size(); i++) {
			if(this.shipMap.get(i).equals(s)) {
				return false;
			}
		}
		for(int i = 0; i < this.shipMap.size(); i++) {
			if(this.shipMap.get(i).getIsHorizontal() && s.getIsHorizontal()) {
				if(this.shipMap.get(i).getyArr()[0] != s.getyArr()[0]) {
					return true;
				} else {
					for(int j = 0; j < s.getxArr().length; j++) {
						for(int k = 0; k < this.shipMap.get(i).getxArr().length; k++) {
							if(this.shipMap.get(i).getxArr()[k] == s.getxArr()[j]) {
								return false;
							}
						}
					}
				}
			} else if (this.shipMap.get(i).getIsHorizontal() && !s.getIsHorizontal()) {
				for(int j = 0; j < s.getyArr().length; j++) {
					for(int k = 0; k < this.shipMap.get(i).getxArr().length; k++) {
						if(this.shipMap.get(i).getxArr()[k] == s.getxArr()[0] && 
								this.shipMap.get(i).getyArr()[0] == s.getyArr()[j]) {
							return false;
						}
					}
				}
			} else if(!this.shipMap.get(i).getIsHorizontal() && s.getIsHorizontal()) {
				for(int j = 0; j < s.getxArr().length; j++) {
					for(int k = 0; k < this.shipMap.get(i).getyArr().length; k++) {
						if(this.shipMap.get(i).getxArr()[0] == s.getxArr()[j] && 
								this.shipMap.get(i).getyArr()[k] == s.getyArr()[j]) {
							return false;
						}
					}
				}
			} else {
				if(this.shipMap.get(i).getxArr()[0] != s.getxArr()[0]) {
					return true;
				} else {
					for(int j = 0; j < s.getyArr().length; j++) {
						for(int k = 0; k < this.shipMap.get(i).getyArr().length; k++) {
							if(this.shipMap.get(i).getyArr()[k] == s.getyArr()[j]) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public void printRadar() {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}


}
