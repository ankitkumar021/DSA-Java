package DSA.designpattern.behavioural.strategypattern;

import DSA.designpattern.behavioural.strategypattern.strategy.NormalDriveStrategy;

public class GoodsVehicle extends VehicleContext {
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
