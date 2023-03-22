package main;

import simulationengine.BattleshipSimulationEngine;
 
public class Main {

	public static void main(String[] args){
	    
		BattleshipSimulationEngine engine = new BattleshipSimulationEngine();
		engine.init();
		engine.start();
		
	    // new BattleshipSimulationEngine().init().start() another way of the execution. please check the explanation in BattleshipSimulationEngine class.
	}
}
