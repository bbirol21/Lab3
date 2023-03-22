package simulationengine;

import models.BattleshipArena;


public class BattleshipSimulationEngine {

	private boolean status;
	private BattleshipArena arena;
    
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

		return this;
	}

	public void start() {
		while (this.getStatus()) {
			this.update();
		}
	}

	// TODO: implement this method
	public BattleshipSimulationEngine update() {

		return this;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
