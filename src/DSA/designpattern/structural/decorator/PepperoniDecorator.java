package DSA.designpattern.structural.decorator;

public class PepperoniDecorator extends PizzaDecorator{
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double cost() {
        return pizza.cost() + 2.0;// Cost of pepperoni topping
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " pepperoni pizza ";
    }
}
