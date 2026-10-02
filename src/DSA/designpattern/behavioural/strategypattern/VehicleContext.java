package DSA.designpattern.behavioural.strategypattern;

import DSA.designpattern.behavioural.strategypattern.strategy.DriveStrategy;

public class VehicleContext {
    DriveStrategy driveObj;
    //injected using constructor injection
    public VehicleContext(DriveStrategy driveObj) {
        this.driveObj = driveObj;
    }
    public void drive(){
        driveObj.drive();//calling the drive method of particular obj which is called
    }

}
