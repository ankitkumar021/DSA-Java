package DSA.designpattern.structural.decorator;

public class PlainPizza implements Pizza{

    @Override
    public double cost(){
        return 8.0;// Base price of the pizza
    }
    @Override
    public String getDescription(){
        return  "plain pizza description";
    }
}
