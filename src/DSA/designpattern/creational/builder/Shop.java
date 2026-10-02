package DSA.designpattern.creational.builder;
//when we want to create the complex object
//object can be created without  with and without field meaning every field is not necessary
public class Shop {
  public static void main(String[] args) {
      Phone p = new PhoneBuilder().setName("iphone")
              .setRam(2).setBattery(5000).setPrice(50000).getPhone();
      System.out.println(p);
    }
}
