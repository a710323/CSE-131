package finalproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import cse131.ArgsProcessor;

public class HumanPlayer implements Player {

	private final ArgsProcessor ap; // Don't change this!

	private String name;
	private int height;
	private int width;
	private int numShips;
	private int surviveShips;
	private Map<Integer, Ship> shipMap = new HashMap<Integer, Ship>();
	private int[] shotXarr = new int[1];
	private int[] shotYarr = new int[1];
	private int shotCount = 0;
	private String[][] boardRecord;
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
		this.surviveShips = 0;
		this.boardRecord = new String[width][height];
	}

	@Override
	public boolean addShip(Ship s) {
		if(s.getxArr()[0] < 0 || s.getyArr()[0] < 0) {
			return false;
		}
		if(s.getxArr().length > this.width || s.getyArr().length > this.height) {
			return false;
		}
		if(isValidShipToAdd(s)) {
			this.shipMap.put(this.numShips, s);
			this.numShips++;
			this.surviveShips++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int[] getTargetLocation() {
		int x = this.ap.nextInt("X coordinate");
		int y = this.ap.nextInt("Y coordinate");
		while(x < 0 || y < 0 || x >= this.width || y >= this.height) {
			x = this.ap.nextInt("X coordinate");
			y = this.ap.nextInt("Y coordinate");
		}
		int[] ans = new int[2];
		ans[0] = x;
		ans[1] = y;
		this.shotXarr = Arrays.copyOf(this.shotXarr, this.shotCount+1);
		this.shotYarr = Arrays.copyOf(this.shotYarr, this.shotCount+1);
		this.shotXarr[this.shotCount] = x;
		this.shotYarr[this.shotCount] = y;
		this.shotCount++;
		return ans;
	}

	@Override
	public void recordHitOrMiss(int x, int y, boolean isHit) {
		int[] ans = getTargetLocation();
		x = ans[0];
		y = ans[1];
		for(int i = 0; i < this.shipMap.size(); i++) {
			isHit = this.shipMap.get(i).isHit(x, y);
		}
	}

	@Override
	public Ship decideShipPlacement(int length) {
		int x = this.ap.nextInt("X coordinate");
		int y = this.ap.nextInt("Y coordinate");
		boolean isHo = this.ap.nextBoolean("Horizontal?");
		Ship s = new Ship(x, y, length, isHo);
		while(!isValidShipToAdd(s)) {
			x = this.ap.nextInt("X coordinate");
			y = this.ap.nextInt("Y coordinate");
			isHo = this.ap.nextBoolean("Horizontal?");
			s = new Ship(x, y, length, isHo);
		}
		return s;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean respondToFire(int x, int y) {
		if(x < 0 || y < 0) {
			return false;
		}
		if(x >= this.width || y >= this.height) {
			return false;
		}
		for(int i = 0; i < this.shipMap.size(); i++) {
			if(this.shipMap.get(i).getIsHorizontal()) {
				if(y == this.shipMap.get(i).getyArr()[0]) {
					for(int j = 0; j < this.shipMap.get(i).getxArr().length; j++) {
						if(this.shipMap.get(i).getxArr()[j] == x) {
							this.shipMap.get(i).isHit(x, y);
							if(this.shipMap.get(i).isSunk()) {
								this.surviveShips--;
							}
							this.shotXarr = Arrays.copyOf(this.shotXarr, this.shotCount+1);
							this.shotYarr = Arrays.copyOf(this.shotYarr, this.shotCount+1);
							this.shotXarr[this.shotCount] = x;
							this.shotYarr[this.shotCount] = y;
							this.shotCount++;
							return true;
						}
					}
				}
			} else {
				if(x == this.shipMap.get(i).getxArr()[0]) {
					for(int j = 0; j < this.shipMap.get(i).getyArr().length; j++) {
						if(this.shipMap.get(i).getyArr()[j] == y) {
							this.shipMap.get(i).isHit(x, y);
							if(this.shipMap.get(i).isSunk()) {
								this.surviveShips--;
							}
							this.shotXarr = Arrays.copyOf(this.shotXarr, this.shotCount+1);
							this.shotYarr = Arrays.copyOf(this.shotYarr, this.shotCount+1);
							this.shotXarr[this.shotCount] = x;
							this.shotYarr[this.shotCount] = y;
							this.shotCount++;
							return true;
						}
					}
				}
			}
		}
		this.shotXarr = Arrays.copyOf(this.shotXarr, this.shotCount+1);
		this.shotYarr = Arrays.copyOf(this.shotYarr, this.shotCount+1);
		this.shotXarr[this.shotCount] = x;
		this.shotYarr[this.shotCount] = y;
		this.shotCount++;
		return false;
	}

	@Override
	public int numShipsStillAfloat() {
		return this.surviveShips;
	}

	@Override
	public boolean addRandomShip(int length) {
		int x = (int) (Math.random() * (this.width));
		int y = (int) (Math.random() * (this.height));
		boolean isHorizon = Math.random() < 0.5 ? true : false;
		Ship s = new Ship(x, y, length, isHorizon);
		while(!isValidShipToAdd(s)) {
			x = (int) (Math.random() * (this.width));
			y = (int) (Math.random() * (this.height));
			isHorizon = Math.random() < 0.5 ? true : false;
			s = new Ship(x, y, length, isHorizon);
		}
		return addShip(s);
	}

	@Override
	public boolean isValidShipToAdd(Ship s) {
		for(int i = 0; i < this.shipMap.size(); i++) {
			if(this.shipMap.get(i).equals(s)) {
				return false;
			}
		}
		if(s.getTopX() < 0 || s.getTopY() < 0) {
			return false;
		}
		if(s.getTopX() > this.width - 1) {
			return false;
		}
		if(s.getTopY()> this.height - 1) {
			return false;
		}
		if(s.getIsHorizontal()) {
			if(s.getTopX() + s.getShipLength() > this.width) {
				return false;
			}
		} else {
			if(s.getTopY() + s.getShipLength() > this.height) {
				return false;
			}
		}
		
		for(int i = 0; i < this.shipMap.size(); i++) {
			if(this.shipMap.get(i).getIsHorizontal() && s.getIsHorizontal()) {
				if(this.shipMap.get(i).getyArr()[0] == s.getyArr()[0]) {
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
								this.shipMap.get(i).getyArr()[k] == s.getyArr()[0]) {
							return false;
						}
					}
				}
			} else if(!this.shipMap.get(i).getIsHorizontal() && !s.getIsHorizontal()){
				if(this.shipMap.get(i).getxArr()[0] == s.getxArr()[0]) {
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
		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				this.boardRecord[i][j] = ".";
				//	System.out.print(this.boardRecord[i][j]);
			}
			//System.out.println();
		}
		for(int i = 0; i < this.shipMap.size(); i++) {
			if(this.shipMap.get(i).getIsHorizontal()) {
				for(int j = 0; j < this.shipMap.get(i).getxArr().length; j++) {
					this.boardRecord[this.shipMap.get(i).getyArr()[0]][this.shipMap.get(i).getxArr()[j]] = "S";
				}
			} else if(!this.shipMap.get(i).getIsHorizontal()) {
				for(int j = 0; j < this.shipMap.get(i).getyArr().length; j++) {
					this.boardRecord[this.shipMap.get(i).getyArr()[j]][this.shipMap.get(i).getxArr()[0]] = "S";
				}
			}
		}
		for(int i = 0; i < this.shipMap.size(); i++) {
			if(this.shipMap.get(i).getIsHorizontal()) {
				for(int j = 0; j < this.shipMap.get(i).getHitXArr().length; j++) {
					this.boardRecord[this.shipMap.get(i).getHitYArr()[0]][this.shipMap.get(i).getHitXArr()[j]] = "H";
				}
			} else if(!this.shipMap.get(i).getIsHorizontal()) {
				for(int j = 0; j < this.shipMap.get(i).getHitYArr().length; j++) {
					this.boardRecord[this.shipMap.get(i).getHitYArr()[j]][this.shipMap.get(i).getHitXArr()[0]] = "H";
				}
			} 
		}

		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				System.out.print(this.boardRecord[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		HumanPlayer a = new HumanPlayer("Alex", 10, 10, ap);
		Ship s1 = new Ship(0,0,2,true);
		Ship s2 = new Ship(1,1,3,false);
		a.addShip(s2);
		a.addShip(s1);
		a.printRadar();
	}

}
