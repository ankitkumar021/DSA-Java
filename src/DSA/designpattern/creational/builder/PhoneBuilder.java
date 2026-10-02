package DSA.designpattern.creational.builder;

public class PhoneBuilder {
    String name;
    int battery;
    double price;
    int ram;

    public PhoneBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public PhoneBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public Phone getPhone() {
        return new Phone(name, battery, price, ram);
    }
}
