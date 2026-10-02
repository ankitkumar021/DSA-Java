package DSA.designpattern.behavioural.latest.stratpattern;
//client code
//if we dont use the strategy here we have to use the multiple if-else block based on the type
public class StrategyMain {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new UpiPayment());

        paymentService.makePayment(1000);

        //change the strategy at the run time,without changing the paymentservice

        paymentService = new PaymentService(new CardPayment());

        paymentService.makePayment(2000);

    }
}
