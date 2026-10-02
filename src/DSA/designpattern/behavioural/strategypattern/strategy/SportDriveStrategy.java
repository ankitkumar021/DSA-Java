package DSA.designpattern.behavioural.strategypattern.strategy;

public class SportDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sport Drive Strategy");
    }
}
