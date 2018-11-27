package finalproject;


/**
 * @author Mariah Yelenick
 * @version 11/4/2018
 */
public interface Battleship {
	
	/**
	 * Start/play the game!
	 * @return the player who won the game
	 */
	public Player play();
	
	/**
	 * Play one turn of Battleship -- this consists of one player making one move
	 * 		1) Print out the board for the given player
	 * 		2) Get the move (row, col) from the given player
	 * 		3) Check if that move was a hit or miss on the other player (will be the same player in OnePlayerBattleship)
	 * 		4) Update the player's radar
	 * Note: be sure to print out "You sunk my battleship!" if a hit sinks a ship
	 * 
	 * @param p the player whose turn it is
	 * @return true if the game is over, false otherwise
	 */
	public boolean turn(Player p);
	
	/**
	 * @return player one
	 */
	public Player getPlayerOne();
	
	/**
	 * @return player two
	 */
	public Player getPlayerTwo();
}
