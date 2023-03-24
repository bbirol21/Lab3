package models;
 
 
public class BattleshipArena {

	private char[][] xySpace;
	private Ship[] shipList;
	private static int shipcounter = 0;
	private int xlength;
	private int ylength;

	// TODO: initialize instance variables in the constructor
	public BattleshipArena(int xlength, int ylength) {
		this.xlength = xlength;
		this.ylength = ylength;
		this.shipList  = new Ship[10];
		this.xySpace = new char[xlength][ylength];
		initXYspace(xySpace, '.');
		
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
		for(int i = 0; i<xlength; i++) {
			for(int j = 0; j<ylength; j++) {
				xySpace[i][j] = pattern;
			}
		}
	}

	
	// TODO: implement addShip method
	public boolean addShip(Ship ship, Location location) {
		int i;
        for (i = 0; i < shipList.length; i++) {
            if (shipList[i] == null) {
                break;
            }
        }
        if (i == shipList.length) {
            System.err.println("Ship list is full");
            return false;
        }
        
        if (!isLocationsValid(location)) {
            System.err.println("Invalid location");
            return false;
        }
        
        if (location.getX() + ship.getXwidth() > xySpace.length || location.getY() + ship.getYwidth() > xySpace[0].length) {
            System.err.println("Ship doesn't fit into the location");
            return false;
        }
        
        for (int x = location.getX(); x < location.getX() + ship.getXwidth(); x++) {
            for (int y = location.getY(); y < location.getY() + ship.getYwidth(); y++) {
                if (xySpace[y][x] == 'S') {
                    System.err.println("Ship overlaps with another ship");
                    return false;
                }
            }
        
        }
        
        for (int j = 0; j < shipList.length; j++) {
            if (shipList[j] == null) {
            	ship.setLocation(location);
        		for(int k = ship.getLocation().getX(); k<ship.getLocation().getX()+ship.getXwidth(); k++) {
        			for(int l = ship.getLocation().getY(); l<ship.getLocation().getY()+ship.getYwidth(); l++) {
        				xySpace[k][l] = 'S';
        			}
        		}
                shipList[i] = ship;
                return true;
            }
        }
		return false;
	}

	
	// TODO: implement attack method
	public void attack(Location location) {
		if (isLocationsValid(location)) {
			Ship shotship = isHit(location);
			if (isHit(location) == null) {
				return;
//				xySpace[location.getX()][location.getY()] = 'N';
//				System.out.println("missed");
//				drawArena();
			}
			else {
				xySpace[location.getX()][location.getY()] = 'X';
		        int damage = (int) calculateHitDemage(shotship);
		        shotship.reduceHealth(damage);
		        System.out.println("Hit the ship has " + shotship.getHealth() + " percent health left. Is ship alive: " + shotship.isAlive());
		        drawArena();
			}
            
        }
		else {
			System.out.println("Invalid location!");
			return;
		}
	}

	
	// TODO: print status of the ships by calling their toString method.
	public void showShipInfo() {
		for (Ship ship : shipList) {
			ship.toString();
			//olmayabilir normal for loopu da denersin olmazsa.
		}
	}

	
	private double calculateHitDemage(Ship ship) {
		return (100.0 / (ship.getXwidth() * ship.getYwidth()));
	}

	
	// TODO: check if there's a ship on the given location
	private Ship isHit(Location location) {
		if (xySpace[location.getX()][location.getY()] != 'S') {
            return null;
        }
        for (Ship ship : shipList) {
            if (ship != null && isLocationHitsTheShip(ship, location)) {
                return ship;
            }
        }
        return null;
	}

	
	// TODO: check if the location hits the given ship
	private boolean isLocationHitsTheShip(Ship ship, Location location) {
		if(location.getX()>=ship.getLocation().getX() && location.getX()<(ship.getLocation().getX()+ship.getXwidth())) {
			if(location.getY()>=ship.getLocation().getY() && location.getY()<(ship.getLocation().getY()+ship.getYwidth())) {
				return true;
			}
		}
		return false;
	}

	
	// TODO: check if the given location exceeds our simulation space
	public boolean isLocationsValid(Location location) {
		if(location.getX()>xlength || location.getY()>ylength || location.getX()<0 || location.getY()<0) {
			return false;
		}
		return true;
	}

	
	// TODO: return alive ship count
	public long getAliveShipCount() {
		int sum = 0;
		for (Ship ship : shipList) {
			if (ship != null && ship.isAlive()) {
				sum+=1;
			}
		}
		return sum;
		//variable was changed!!!!! initially it was 0 now sum
	}


	public Ship[] getShipList() {
		return shipList;
	}


	public int getXlength() {
		return xlength;
	}


	public int getYlength() {
		return ylength;
	}

	

}
