package DSA.designpattern.behavioural.strategypattern;

import DSA.designpattern.behavioural.strategypattern.strategy.XyzDriveStrategy;

public class OffRoadVehicle extends VehicleContext {
   public OffRoadVehicle(){
       super(new XyzDriveStrategy());
    }
}
