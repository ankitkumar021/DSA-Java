package DSA.designpattern.behavioural.strategypattern.strategy;

public class XyzDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("XYZ drive strategy");
    }
}
