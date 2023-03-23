package models;

public class Ship {

	private String name;
	private Location location;
	private double xwidth, ywidth, health;
	private boolean isAlive;
	
	public Ship(String name, int xwidth, int ywidth) {
		this.name = name;
		this.xwidth = xwidth;
		this.ywidth = ywidth;
		this.health = 100;
		this.isAlive = true;
	}
	
	public void reduceHealth(double damage) {
		health -= damage;
		if (health<1) {
			isAlive = false;
		}
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public double getYwidth() {
		return ywidth;
	}

	public double getXwidth() {
		return xwidth;
	}

	public double getHealth() {
		return health;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String toString() {
		return "Ship (name=" + name + ", isAlive=" + isAlive + ", health=" + health + ", location=" + location.toString() +  ", xwidth=" + xwidth +  ", ywidth=" + ywidth +")";
	}
	
	
}
