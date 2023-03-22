package models;
 
 
public class BattleshipArena {

	private char[][] xySpace;
	private Ship[] shipList;
	private static int shipcounter = 0;
	private int xlength;
	private int ylength;

	// TODO: initialize instance variables in the constructor
	public BattleshipArena(int xlength, int ylength) {

	}

	public void drawArena() {
		for (int j = 0; j < ylength; j++)
			System.out.print("- ");
		System.out.println("-> y axis columns");
		for (int i = 0; i < xlength; i++) {
			System.out.print("|");
			for (int j = 0; j < ylength; j++) {
				System.out.print(xySpace[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("v");
		System.out.println("x axis rows");
	}

	// TODO: implement xyspace initializer
	private void initXYspace(char[][] xySpace, char pattern) {
	}

	// TODO: implement addShip method
	public boolean addShip(Ship ship, Location location) {
		return false;
	}

	// TODO: implement attack method
	public void attack(Location location) {

	}

	// TODO: print status of the ships by calling their toString method.
	public void showShipInfo() {

	}

	private double calculateHitDemage(Ship ship) {
		return (100.0 / (ship.getWidth() * ship.getHeight()));
	}

	// TODO: check if there's a ship on the given location
	private Ship isHit(Location location) {
		return null;
	}

	// TODO: check if the location hits the given ship
	private boolean isLocationHitsTheShip(Ship ship, Location location) {
		return false;
	}

	// TODO: check if the given location exceeds our simulation space
	public boolean isLocationsValid(Location location) {
		return true;
	}

	// TODO: return alive ship count
	public long getAliveShipCount() {
		return 0;
	}

}
