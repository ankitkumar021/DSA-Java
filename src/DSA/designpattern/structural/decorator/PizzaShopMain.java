package DSA.designpattern.structural.decorator;
//The decorator pattern attaches additional responsibilities to an object dynamically.
//Decorators provide a flexible alternative to subclassing for extending the functionality.
//The Decorator pattern is a structural design pattern that allows you to enhance or
// modify the behavior of objects at runtime
// It achieves this by creating a set of decorator classes that are used to wrap concrete components.
// Each decorator adds a specific feature or behavior to the component.

//When to Use the Decorator Pattern

//Adding New Features: You want to add extra features to objects without changing their core structure.
// It’s like putting toppings on a pizza without changing the pizza itself.

//Avoiding Messy Code: You want to avoid having too many different classes for all possible combinations of features.
// Instead, you can mix and match decorators as needed.

//Open for Extension, Closed for Modification: You want to make your code ready for future changes
// by allowing new features to be added without messing up existing code.
// This aligns with the Open/Closed Principle.
public class PizzaShopMain {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        System.out.println(pizza.getDescription() + " $" + pizza.cost());

        pizza = new CheeseDecorator(pizza);
        System.out.println(pizza.getDescription() + " $" + pizza.cost());

        pizza = new PepperoniDecorator(pizza);
        System.out.println(pizza.getDescription() + " $" + pizza.cost());

/*        pizza = new MushroomDecorator(pizza);
        System.out.println(pizza.getDescription() + " $" + pizza.cost());*/

        pizza = new OliveDecorator(pizza);
        System.out.println(pizza.getDescription() + " $" + pizza.cost());
    }
}
