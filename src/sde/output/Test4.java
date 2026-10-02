package sde.output;
//In Java, enumerations (enums) are a special type used to define a group
// of named constants.
//
//Enums help in readability, maintainability,
// and type safety in programs by assigning meaningful names to integer values.
//Mainly useful when we have a small set of possible values for an item like
//directions, days of week, etc.
public class Test4 {
  public   static void main(String[] args) {

        Example one  = Example.ONE;
        Example one1 = Example.ONE;
        Example two = Example.TWO;
        System.out.println(one==one1);
        System.out.println(one.equals(one1));
        System.out.println(one.compareTo(two));
        System.out.println(one.compareTo(one));//compareto method return0,1,-1
        System.out.println(two.compareTo(one));
        for(Example e : Example.values()){
            System.out.println(e);
        }
    }
    public enum Example{
        ONE,
        TWO,
        THREE,
    }
}
