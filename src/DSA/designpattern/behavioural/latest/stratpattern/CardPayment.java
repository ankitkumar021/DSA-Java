package DSA.designpattern.behavioural.latest.stratpattern;
//follows single responsibility principle
//here we also use open-closed principle. we can add new payment without modifying
public class CardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("paid using card : " + amount);
    }
}
