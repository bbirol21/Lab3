package simulationengine;

import java.util.Scanner;

import models.BattleshipArena;
import models.Location;
import models.Ship;


public class BattleshipSimulationEngine {

	private boolean status;
	private BattleshipArena arena = new BattleshipArena(30, 30);
	private Ship ship1 = new Ship("Sedef Kalkavan", 2, 2);
	private Ship ship2 = new Ship("Alp Bustos", 2, 2);
	Scanner input = new Scanner (System.in);
    
    /*
        As you know "this" keywod corresponds to the current object.
        Since we can return any object type from a method we can also return the current object itself.
        returning the reference of the current object allows us to chain functions back to back
        
        here we can do the following
	
	
        new BattleshipSimulationEngine().init().start();
        
        new BattleshipSimulationEngine() -> creates an instance of the object return its reference
        init() -> performs some operations and returns the same reference.
        
        
        if you catch the reference, you can access its methods like following.
        BattleshipSimulationEngine engine = new BattleshipSimulationEngine();
        engine.start()
        
        but you can do that without catching the reference, you can do it directly like new BattleshipSimulationEngine().start();
        but after that you lose the reference since start returns void.
        
        however init() function returns its reference again, we don't loose the reference after calling it.
        so new BattleshipSimulationEngine().init().start(); is possible.
        
        
    */
	// TODO: init enviroment add one ship
	public BattleshipSimulationEngine init() {
		status = true;
		//BattleshipArena arena = new BattleshipArena(40, 40);
		//Ship ship1 = new Ship("Sedef Kalkavan", 2, 2);
		Location loc1 = new Location(2, 2);
		Location loc2 = new Location(15, 15);
		arena.addShip(ship1, loc1);
		arena.addShip(ship2, loc2);
		arena.drawArena();
		return this;
	}

	public void start() {
		while (this.getStatus()) {
			this.update();
		}
		for (int i=0; i<arena.getShipList().length; i++) {
			if (arena.getShipList()[i] != null) {
				System.out.println(arena.getShipList()[i].toString());
			}
	
		}
		
	}

	// TODO: implement this method
	public BattleshipSimulationEngine update() {
		
		System.out.println("X Location to Fire: ");
		int x = input.nextInt();
		System.out.println("Y Location to Fire: ");
		int y = input.nextInt();
		
		Location loc = new Location(x,y);
		arena.attack(loc);
		
		if(arena.getAliveShipCount()==0) {
			setStatus(false);
		}
		return this;
	}
	

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
