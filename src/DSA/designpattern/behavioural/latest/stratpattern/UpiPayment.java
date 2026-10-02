package DSA.designpattern.behavioural.latest.stratpattern;

public class UpiPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("paid using upi " + amount);
    }
}
