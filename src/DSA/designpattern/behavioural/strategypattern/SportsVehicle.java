package DSA.designpattern.behavioural.strategypattern;

import DSA.designpattern.behavioural.strategypattern.strategy.SportDriveStrategy;

public class SportsVehicle extends VehicleContext {
    public SportsVehicle(){

        super(new SportDriveStrategy());
    }
}
