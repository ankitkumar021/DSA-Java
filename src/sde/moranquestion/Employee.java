package sde.moranquestion;

import java.util.ArrayList;
import java.util.List;

public final class Employee {
   private final int id;
   private final String name;
    List<String> certifications;
   private final Address address;//mutable class

    public Employee(int id, String name, List<String> certifications,Address address) {
        this.id = id;
        this.name = name;
        this.certifications=new ArrayList<>(certifications);
        this.address = new Address(address);
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public List<String> getCertifications(){
        return new ArrayList<>();
    }
    public Address getAddress(){
        return new Address(address);
    }

}
