package DSA.designpattern.behavioural.strategypattern;

public class MainClass {
    public static void main(String[] args) {
        VehicleContext v = new SportsVehicle();
        v.drive();
    }
}
