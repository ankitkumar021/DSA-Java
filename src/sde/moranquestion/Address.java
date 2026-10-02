package sde.moranquestion;

import java.util.Objects;

public class Address {
    private String state;
    private String city;

    public Address(String state, String city) {
        this.state = state;
        this.city = city;
    }
    //copy constructor
    public Address(Address copyAddress){
        this.state=copyAddress.state;
        this.city=copyAddress.city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(state, address.state) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
