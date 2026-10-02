package DSA.designpattern.creational.factory;

public class FactoryMain {
    public static void main(String[] args) {
        OperatingSystemFactory osFactory = new OperatingSystemFactory();
        Os os = osFactory.getOs("ios");
        os.spec();
    }
}
