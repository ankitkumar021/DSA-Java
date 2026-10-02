package DSA.designpattern.structural.decorator;

public class OliveDecorator extends PizzaDecorator{
    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double cost() {
        return pizza.cost() + 0.75;// Cost of olive topping
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " olive pizza ";
    }
}
