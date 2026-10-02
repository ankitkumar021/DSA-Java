package DSA.designpattern.structural.decorator;

public class CheeseDecorator extends PizzaDecorator{

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public double cost() {
        return pizza.cost() + 1.5;// Cost of cheese topping
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " cheese pizza";
    }


}
