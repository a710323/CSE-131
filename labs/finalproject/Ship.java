package finalproject;

import cse131.NotYetImplementedException;

/**
 * @author Mariah Yelenick and Adam Kern
 * @version 11/18/18
 */
public class Ship {
	
	/**
	 * Create an instance of the ship class, recording all necessary information into
	 * any instance variables you choose to create
	 * 
	 * @param topLeftX the x coordinate of the ship's uppermost, leftmost space
	 * @param topLeftY the y coordinate of the ship's uppermost, leftmost space
	 * @param length the number of spaces the ship occupies
	 * @param isHorizontal if true, the ship is placed horizontally, else the ship is placed vertically
	 */
	public Ship(int topLeftX, int topLeftY, int length, boolean isHorizontal) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}
	
	/**
	 * Check if the ship has been sunk
	 * This should only be true if the ship was hit in all the spaces it occupies
	 * 
	 * @return true if the ship has been sunk
	 */
	public boolean isSunk() {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}
	
	/**
	 * Check if the ship occupies a space at (x, y)
	 * Note: Be sure to update the hits array so that you can check if the ship is sunk!
	 * 
	 * @param x the x coordinate to shoot at
	 * @param y the y coordinate to shoot at
	 * @return true if this ship occupies that spot (hit), false otherwise (miss)
	 */
	public boolean isHit(int x, int y) {
		throw new NotYetImplementedException("Delete this line and implement this method");
	}
	
}
