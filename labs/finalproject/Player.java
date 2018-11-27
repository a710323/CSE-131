package finalproject;

public interface Player {

	/**
	 * Add a ship to whatever collection of ships the Player uses to keep track of its ships
	 * 
	 * @param s the ship to add
	 */	
	
	/**
	 * Add a ship to whatever collection of ships the Player uses to keep track of its ships
	 * Note: This method should only return true upon successful addition to the collection
	 * 
	 * @param s the ship to be added
	 * @return whether the ship was successfully added to the collection
	 */
	public boolean addShip(Ship s);
	
	/**
	 * Ask the user for the location they want to fire at
	 * 
	 * @return an integer array of length 2 which contains the (x,y) location the player wants to fire at
	 */
	public int[] getTargetLocation();
	
	/**
	 * Record on the board/radar whether a shot made was a hit or a miss
	 * 
	 * @param x the x location to record if hit or miss
	 * @param y the y location to record if hit or miss
	 * @param isHit whether the shot was a hit (true) or miss (false)
	 */
	public void recordHitOrMiss(int x, int y, boolean isHit);
	
	/**
	 * Given the length of a ship, decide where on the board to place that ship
	 * Note: The decision must be valid, i.e. the ship does not overlap any other ships or go off the board, etc
	 * 
	 * @param sl the length of the ship to place
	 * @return a Ship instance with the desired (x, y) location, length, and orientation
	 */
	public Ship decideShipPlacement(int length);
	
	/**
	 * @return the name of the player
	 */
	public String getName();
	
	/**
	 * Tell whether any of the player's ships were hit given an (x, y) firing location
	 * And record that hit on the ship
	 * 
	 * @param x the x location the other player shot at
	 * @param y the y location the other player shot at
	 * @return true if hit, false if miss
	 */
	public boolean respondToFire(int x, int y);
	
	/**
	 * Tell how many of the player's ships have been sunk / how many have not yet been sunk
	 * 
	 * @return the number of ships still afloat
	 */
	public int numShipsStillAfloat();
	
	/**
	 * Randomly place a ship of the given length in a valid location
	 * Be sure to add it to the collection of ships for the game
	 * Note: The random ship should NOT OVERLAP any existing ships
	 * 
	 * @param length the length of the ship to be added
	 */
	public boolean addRandomShip(int length);
	
	/**
	 * Tell whether a given ship s will intersect any of the existing ships
	 * @param s the ship to add
	 * @return whether the ship intersects any other ships on the board
	 */
	public boolean isValidShipToAdd(Ship s);
		
	/**
	 * Prints out the radar indicating where the user has fired,
	 * and whether those fires were hits or misses
	 */
	public void printRadar();
	
}
