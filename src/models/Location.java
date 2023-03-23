package models;

public class Location {

	private int x, y;
	
	public Location(int xCoordinate, int yCoordinate) {
		this.x = xCoordinate;
		this.y = yCoordinate;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "Location (x=" + x + ", y=" + y + ")";
	}

	
	
}
