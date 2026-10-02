package DSA.designpattern.structural.decorator;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double cost() {
        return pizza.cost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}
