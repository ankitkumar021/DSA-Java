package DSA.designpattern.behavioural.latest.stratpattern;
//context
//follows single responsibility
//also follows dependency inversion principle
//high level class depends on abstraction(paymentstrategy)
//not the concrete implementation our payment depends on interface on their concrete implementation

public class PaymentService {
   public final PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount){
        paymentStrategy.pay(amount);
    }
}
