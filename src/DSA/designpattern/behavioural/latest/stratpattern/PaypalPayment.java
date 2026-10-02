package DSA.designpattern.behavioural.latest.stratpattern;
//concrete implementation
public class PaypalPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("paid using paypal: " + amount);

    }
}
