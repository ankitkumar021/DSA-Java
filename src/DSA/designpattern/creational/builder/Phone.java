package DSA.designpattern.creational.builder;

public class Phone {
    String name;
    int battery;
    double price;
    int ram;

    public Phone(String name, int battery, double price, int ram) {
        this.name = name;
        this.battery = battery;
        this.price = price;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", battery=" + battery +
                ", price=" + price +
                ", ram=" + ram +
                '}';
    }
}
