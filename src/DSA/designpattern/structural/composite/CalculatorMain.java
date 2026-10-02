package DSA.designpattern.structural.composite;

//The Composite Design Pattern is a structural pattern that organizes
// objects into tree structures,
//allowing clients to treat individual objects and groups of objects uniformly.
//Component – Defines a common interface that both leaf objects
// and composite objects implement.
//Leaf – Represents simple, indivisible objects that perform operations directly.
// Composite – Represents complex objects that can contain children
// (leaves or other composites)
// and delegate operations to them.
//Client – Works with all objects through the Component interface, treating individual
// and composite objects uniformly.
public class CalculatorMain {
    public static void main(String[] args) {
        //2*(1+7)
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);

        ArithmeticExpression addExpression = new Expression(one,seven, Operation.ADD);
        ArithmeticExpression parentExpression = new Expression(two,addExpression,Operation.MULTIPLY);

        System.out.println("result of overall expression " + parentExpression.evaluate());
    }
}
