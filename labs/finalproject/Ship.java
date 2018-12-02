package finalproject;

import java.util.Arrays;

import cse131.NotYetImplementedException;
import lab6.MergeSort;

/**
 * @author Mariah Yelenick and Adam Kern
 * @version 11/18/18
 */
public class Ship {
	private int hitCount;
	private int[] hitXArr = new int[1];
	private int[] hitYArr = new int[1];
	private int[] xArr;
	private int[] yArr;
	private boolean isHorizontal;

	@Override
	public String toString() {
		return "Ship [hitCount=" + hitCount + ", hitXArr=" + Arrays.toString(hitXArr) + ", hitYArr="
				+ Arrays.toString(hitYArr) + ", xArr=" + Arrays.toString(xArr) + ", yArr=" + Arrays.toString(yArr)
				+ ", isHorizontal=" + isHorizontal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hitCount;
		result = prime * result + Arrays.hashCode(hitXArr);
		result = prime * result + Arrays.hashCode(hitYArr);
		result = prime * result + (isHorizontal ? 1231 : 1237);
		result = prime * result + Arrays.hashCode(xArr);
		result = prime * result + Arrays.hashCode(yArr);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (isHorizontal != other.isHorizontal)
			return false;
		if (!Arrays.equals(xArr, other.xArr))
			return false;
		if (!Arrays.equals(yArr, other.yArr))
			return false;
		return true;
	}

	public boolean getIsHorizontal() {
		return isHorizontal;
	}

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
		this.isHorizontal = isHorizontal;
		this.hitCount = 0;
		if(isHorizontal) {
			this.xArr = new int[length];
			this.yArr = new int[1];
			for(int i = 0; i < length; i++) {
				this.yArr[0] = topLeftY;
				this.xArr[i] = topLeftX + i;
			}
		} else {
			this.yArr = new int[length];
			this.xArr = new int[1];
			for(int i = 0; i < length; i++) {
				this.xArr[0] = topLeftX;
				this.yArr[i] = topLeftY + i;
			}
		}
	}

	/**
	 * Check if the ship has been sunk
	 * This should only be true if the ship was hit in all the spaces it occupies
	 * 
	 * @return true if the ship has been sunk
	 */
	public boolean isSunk() {
		if(isHorizontal) {
			if(this.hitYArr[0] != this.yArr[0]) {
				return false;
			} else if(this.hitXArr.length != this.xArr.length) {
				return false;
			} else {
				return true;
			}
		} else {
			if(this.hitXArr[0] != this.xArr[0]) {
				return false;
			} else if(this.hitYArr.length != this.yArr.length) {
				return false;
			} else {
				return true;
			}
		}
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
		if(isHorizontal) {
			if(this.yArr[0] != y) {
				return false;
			} else {
				for(int i = 0; i < this.xArr.length; i++) {
					if(this.xArr[i] == x) {
						for(int j = 0; j < this.hitXArr.length; j++) {
							if(this.hitXArr[j] == x) {
								return true;
							} else {
								this.hitXArr = Arrays.copyOf(this.hitXArr, this.hitCount + 1);
								this.hitXArr[this.hitCount] = x;
								this.hitYArr = Arrays.copyOf(this.hitYArr, this.hitCount + 1);
								this.hitYArr[this.hitCount] = y;
								this.hitCount++;
								return true;
							}
						}

					}
				}
				return false;
			}
		} else {
			if(this.xArr[0] != x) {
				return false;
			} else {
				for(int i = 0; i < this.yArr.length; i++) {
					if(this.yArr[i] == y) {
						for(int j = 0; j < this.hitYArr.length; j++) {
							if(this.hitYArr[j] == y) {
								return true;
							} else {
								this.hitXArr = Arrays.copyOf(this.hitXArr, this.hitCount + 1);
								this.hitXArr[this.hitCount] = x;
								this.hitYArr = Arrays.copyOf(this.hitYArr, this.hitCount + 1);
								this.hitYArr[this.hitCount] = y;
								this.hitCount++;
								return true;
							}
						}
					}
				}
			}
			return false;
		}
	}

	public int[] getxArr() {
		return xArr;
	}

	public int[] getyArr() {
		return yArr;
	}
}
